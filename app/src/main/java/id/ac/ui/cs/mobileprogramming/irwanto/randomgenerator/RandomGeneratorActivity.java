package id.ac.ui.cs.mobileprogramming.irwanto.randomgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import id.ac.ui.cs.mobileprogramming.irwanto.R;

public class RandomGeneratorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_generator);
    }

    public void generateNumber(View view) {
        EditText editTextMin = (EditText) findViewById(R.id.minimum);
        EditText editTextMax = (EditText) findViewById(R.id.maximum);
        TextView numberView = (TextView) findViewById(R.id.generated_number);

        int min = Integer.parseInt(editTextMin.getText().toString());
        int max = Integer.parseInt(editTextMax.getText().toString());
        RandomNumberGenerator generator = new RandomNumberGenerator();
        int randomNumber = generator.generateFromRange(min, max);
        numberView.setText(String.valueOf(randomNumber));
    }

    public boolean generateButtonClickable(View view) {
        EditText editTextMin = (EditText) findViewById(R.id.minimum);
        EditText editTextMax = (EditText) findViewById(R.id.maximum);

        String min = editTextMin.getText().toString();
        String max = editTextMax.getText().toString();

        return min != "" && max != "";
    }
}