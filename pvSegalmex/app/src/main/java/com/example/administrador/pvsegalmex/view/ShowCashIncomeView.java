package com.example.administrador.pvsegalmex.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.entity.CashIncomeEntity;

public class ShowCashIncomeView extends AppCompatActivity {

    TextView comment, amount;

    private void inizialite() {
        comment = findViewById(R.id.tvCommentsIncomeView);
        amount = findViewById(R.id.tvAmountIncomeView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cash_income_view);
        inizialite();
        amount.setText(String.valueOf(CashIncomeEntity.instance.getAmount()));
        comment.setText(CashIncomeEntity.instance.getComments());

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.itemMenu15));
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp); // your drawable
        toolbar.setNavigationOnClickListener(v -> {
            onBackPressed(); // Implemented by activity
        });
    }
}
