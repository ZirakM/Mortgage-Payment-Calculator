package com.example.mobileapplicationassignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText principalEditText, interestRateEditText, amortizationPeriodEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        principalEditText = findViewById(R.id.editPrincipal);
        interestRateEditText = findViewById(R.id.editInterestRate);
        amortizationPeriodEditText = findViewById(R.id.editAmortizationPeriod);

        Button calculateButton = findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user input
                double principal = Double.parseDouble(principalEditText.getText().toString());
                double interestRate = Double.parseDouble(interestRateEditText.getText().toString());
                int amortizationPeriod = Integer.parseInt(amortizationPeriodEditText.getText().toString());

                // Calculate the monthly payment
                double monthlyPayment = calculateMonthlyPayment(principal, interestRate, amortizationPeriod);

                // Create an intent to pass data to the result activity
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("principal", principal);
                intent.putExtra("interestRate", interestRate);
                intent.putExtra("amortizationPeriod", amortizationPeriod);
                intent.putExtra("monthlyPayment", monthlyPayment);

                // Start the result activity
                startActivity(intent);
            }
        });
    }

    private double calculateMonthlyPayment(double principal, double interestRate, int amortizationPeriod) {
        // Convert annual interest rate to monthly rate
        double monthlyInterestRate = (interestRate / 100) / 12;

        // Calculate the number of monthly payments
        int numberOfPayments = amortizationPeriod;

        // Calculate the monthly payment
        double monthlyPayment = (principal * monthlyInterestRate) /
                (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));

        return monthlyPayment;
    }
}

