package id.ac.ui.cs.mobileprogramming.irwanto.musicplayer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private boolean played = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button playButton = (Button) findViewById(R.id.play_button);
        final ProgressBar pb = (ProgressBar) findViewById(R.id.progress_bar);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!played) {
                    startService(new Intent(MainActivity.this, MusicPlayerService.class));
                    registerReceiver(br, new IntentFilter(MusicPlayerService.MUSICPLAYER_BR));
                    playButton.setText("Stop");
                    played = true;
                } else {
                    stopService(new Intent(MainActivity.this, MusicPlayerService.class));
                    unregisterReceiver(br);
                    playButton.setText("Play");
                    played = false;
                    pb.setProgress(0);
                }
            }
        });
    }

    private BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            updateProgress(intent);
        }
    };

    private void updateProgress(Intent intent) {
        if (intent.getExtras() != null) {
            ProgressBar pb = (ProgressBar) findViewById(R.id.progress_bar);
            TextView current = (TextView) findViewById(R.id.playing_time);
            TextView duration = (TextView) findViewById(R.id.duration);
            pb.setProgress(intent.getIntExtra("progress", 0));
            current.setText(intent.getStringExtra("current"));
            duration.setText(intent.getStringExtra("duration"));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(br, new IntentFilter(MusicPlayerService.MUSICPLAYER_BR));
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Warning!");
        alertDialogBuilder.setMessage("Do you really want to close this app?");
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (played) {
            unregisterReceiver(br);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (played) {
            stopService(new Intent(this, MusicPlayerService.class));
        }
    }
}