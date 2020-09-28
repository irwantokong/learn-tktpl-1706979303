package id.ac.ui.cs.mobileprogramming.irwanto.randomgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import id.ac.ui.cs.mobileprogramming.irwanto.R;

public class RandomGeneratorActivity extends AppCompatActivity {
    TextWatcher rangeWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            EditText editTextMin = (EditText) findViewById(R.id.minimum);
            EditText editTextMax = (EditText) findViewById(R.id.maximum);
            Button button = (Button) findViewById(R.id.generate_button);

            String min = editTextMin.getText().toString();
            String max = editTextMax.getText().toString();

            if (min.isEmpty() || max.isEmpty()) {
                button.setEnabled(false);
            } else {
                if (Integer.parseInt(min) <= Integer.parseInt(max)) {
                    button.setEnabled(true);
                } else {
                    button.setEnabled(false);
                }
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_generator);

        EditText editTextMin = (EditText) findViewById(R.id.minimum);
        EditText editTextMax = (EditText) findViewById(R.id.maximum);
        editTextMin.addTextChangedListener(rangeWatcher);
        editTextMax.addTextChangedListener(rangeWatcher);

        Button button = (Button) findViewById(R.id.generate_button);
        button.setEnabled(false);

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
}