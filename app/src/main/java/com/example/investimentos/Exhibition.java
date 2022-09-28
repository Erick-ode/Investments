package com.example.investimentos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.LinkedList;

public class Exhibition extends AppCompatActivity {

    class InvestAdapter extends ArrayAdapter<Investment> {
        public InvestAdapter(Context ctx) {
            super(ctx, 0, investments);
        }

        @Override
        public View getView(int pos, View recicle, ViewGroup parent) {
            if (recicle == null) {
                recicle = getLayoutInflater().inflate(R.layout.item_investment, null);
            }
            TextView month = (TextView) recicle.findViewById(R.id.txt_month_number);
            TextView fees = (TextView) recicle.findViewById(R.id.txt_fees_number);
            TextView deposit = (TextView) recicle.findViewById(R.id.txt_deposit_number);
            TextView saved = (TextView) recicle.findViewById(R.id.txt_save_number);

            Investment inv = investments.get(pos);
            month.setText(String.valueOf(inv.getMonth()));
            fees.setText(String.valueOf(inv.getFees()));
            deposit.setText(String.valueOf(inv.getDeposit()));
            saved.setText(String.valueOf(inv.getSaves()));

            return recicle;
        }
    }

    ArrayList<Investment> investments;
    ListView listInv;
    InvestAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_evolution);

        Intent it = getIntent();
        investments = (ArrayList<Investment>) it.getSerializableExtra("investments");
        adapter = new InvestAdapter(this);

        listInv = (ListView) findViewById(R.id.list_invest);
        listInv.setAdapter(adapter);
        listInv.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setResult(RESULT_CANCELED);
        finish();
    }

    public void exit(View v) {
        finish();
    }
}
