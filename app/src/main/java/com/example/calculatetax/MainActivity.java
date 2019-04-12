package com.example.calculatetax;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText monthlySalary;
    TextView taxAmount;
    Button btnCalc;

    private static DecimalFormat df = new DecimalFormat(".##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        monthlySalary = findViewById(R.id.monthlySalary);
        taxAmount = findViewById(R.id.taxAmount);
        btnCalc = findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        double theMonthlySalary = Double.parseDouble(monthlySalary.getText().toString());
        CalculateTax calcObj = new CalculateTax(theMonthlySalary);
        double theTaxAmount = calcObj.getTaxAmount();
        taxAmount.setText("Tax amount : "+df.format(theTaxAmount));
    }
}