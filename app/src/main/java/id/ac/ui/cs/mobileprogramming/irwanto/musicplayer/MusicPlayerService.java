package id.ac.ui.cs.mobileprogramming.irwanto.musicplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MusicPlayerService extends Service {
    public static final String MUSICPLAYER_BR = "id.ac.ui.cs.mobileprogramming.irwanto.musicplayer";
    Intent bi = new Intent(MUSICPLAYER_BR);

    private Handler timeHandler = new Handler();
    private MediaPlayer musicPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        musicPlayer = MediaPlayer.create(this, R.raw.infinity_and_beyond);
        musicPlayer.setLooping(true);
        timeHandler.removeCallbacks(startTime);
        timeHandler.postDelayed(startTime, 0);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Playing music", Toast.LENGTH_SHORT).show();
        musicPlayer.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timeHandler.removeCallbacks(startTime);
        musicPlayer.stop();
        Toast.makeText(this, "Stopped music", Toast.LENGTH_SHORT).show();
    }

    private Runnable startTime = new Runnable() {
        @Override
        public void run() {
            double progress = (double) musicPlayer.getCurrentPosition() / musicPlayer.getDuration();
            int current = musicPlayer.getCurrentPosition();
            int duration = musicPlayer.getDuration();
            int currentMinute = (int) ((current / 1000) / 60);
            int currentSecond = ((int) (current / 1000)) % 60;
            int durationMinute = (int) ((duration / 1000) / 60);
            int durationSecond = ((int) (duration / 1000)) % 60;
            bi.putExtra("progress", (int) (progress * 100));
            bi.putExtra("current", String.format("%02d:%02d", currentMinute, currentSecond));
            bi.putExtra("duration", String.format("%02d:%02d", durationMinute, durationSecond));
            sendBroadcast(bi);
            timeHandler.postDelayed(this, 1000);
        }
    };
}
