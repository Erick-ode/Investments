package com.example.investimentos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    LinkedList<Investment> investments;
    EditText edValueReach, edInitial, edContribuition, edIncome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        investments = new LinkedList<>();
        edValueReach = (EditText) findViewById(R.id.ed_value_reach);
        edContribuition = (EditText) findViewById(R.id.ed_contribuition);
        edInitial = (EditText) findViewById(R.id.ed_initial);
        edIncome = (EditText) findViewById(R.id.ed_income);
    }

    public void calculate(View v) {
        Investment invest = new Investment();
        double yield = Double.parseDouble(edIncome.getText().toString());
        double intendedValue = Double.parseDouble(edValueReach.getText().toString());

        invest.setDeposit(
                Double.parseDouble(edInitial.getText().toString()));
        invest.setFees(yield);
        invest.setSaves(invest.getDeposit());
        invest.addDepositMonth();

        investments.add(invest);

        invest.setDeposit(
                Double.parseDouble(edContribuition.getText().toString()));

        while (invest.getSaves() < intendedValue) {
            invest.setMonth();
            invest.setFees(invest.getSaves() * yield);
            invest.addDepositMonth();

            investments.add(invest);
        }
        Intent it = new Intent(this, Exhibition.class);
        it.putExtra("investments", investments);
        startActivity(it);
    }

    public void clean(View v) {
        edContribuition.setText("");
        edIncome.setText("");
        edInitial.setText("");
        edValueReach.setText("");
    }

}