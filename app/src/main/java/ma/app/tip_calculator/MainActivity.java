package ma.app.tip_calculator;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioGroup groupe;
    private EditText cout;
    private Button calculate;
    private TextView result;
    private Switch aSwitch;
    private double montant;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cout = findViewById(R.id.cout_de_service);
        groupe = findViewById(R.id.options);
        calculate = findViewById(R.id.calculate_button);
        aSwitch = findViewById(R.id.round_up_switch);
        result = findViewById(R.id.result);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cout.getText().toString().isEmpty()) {
                    // If the EditText for price is empty, show a toast message
                    Toast.makeText(MainActivity.this, "Please enter the price for the service you paid", Toast.LENGTH_SHORT).show();
                    return; // Exit the onClick method
                }

                int option = groupe.getCheckedRadioButtonId();
                double percent = 0;
                switch (option) {
                    case R.id.option_dix_height_percent:
                        percent = 0.18;
                        break;
                    case R.id.option_quinze_percent:
                        percent = 0.15;
                        break;
                    case R.id.option_vingt_percent:
                        percent = 0.2;
                        break;
                }
                montant = Double.parseDouble(cout.getText().toString()) * percent;
                if (aSwitch.isChecked()) {
                    montant = Math.round(montant * 100.0) / 100.0;
                }
                result.setText("");
                result.append("Montant pourboire : " + montant);
            }
        });


    }
}