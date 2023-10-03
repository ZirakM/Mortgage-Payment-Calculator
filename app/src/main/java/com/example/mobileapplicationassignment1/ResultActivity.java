package com.example.mobileapplicationassignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView resultText = findViewById(R.id.resultText);
        Button backButton = findViewById(R.id.backButton);

        // Retrieve data from the intent
        Intent intent = getIntent();
        double principal = intent.getDoubleExtra("principal", 0);
        double interestRate = intent.getDoubleExtra("interestRate", 0);
        int amortizationPeriod = intent.getIntExtra("amortizationPeriod", 0);
        double monthlyPayment = intent.getDoubleExtra("monthlyPayment", 0);

        // Display the result
        resultText.setText(String.format("Monthly Payment: $%.2f%nPrincipal: $%.2f%nInterest Rate: %.2f%%%nAmortization Period: %d months", monthlyPayment, principal, interestRate, amortizationPeriod));

        // Set up a onclick listener for the "Back" button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the current activity (ResultActivity) to go back to MainActivity
                finish();
            }
        });
    }
}
