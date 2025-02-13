package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText weightInput;
    private EditText heightInput;
    private Button calculateButton;
    private TextView bmiOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightInput = findViewById(R.id.weight_input);
        heightInput = findViewById(R.id.height_input);
        calculateButton = findViewById(R.id.calculate_button);
        bmiOutput = findViewById(R.id.bmi_output);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weightString = weightInput.getText().toString();
                String heightString = heightInput.getText().toString();

                if (!weightString.isEmpty() && !heightString.isEmpty()) {
                    double weight = Double.parseDouble(weightString);
                    double height = Double.parseDouble(heightString);
                    double bmi = weight / (height * height);
                    String bmiCategory = getBMICategory(bmi);
                    String output = String.format("BMI: %.2f\nCategory: %s", bmi, bmiCategory);
                    bmiOutput.setText(output);
                } else {
                    bmiOutput.setText("Please enter valid weight and height.");
                }
            }
        });
    }

    private String getBMICategory(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "Normal weight";
        } else if (bmi >= 25 && bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}