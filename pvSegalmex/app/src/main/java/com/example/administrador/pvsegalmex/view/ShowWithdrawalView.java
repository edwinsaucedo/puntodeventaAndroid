package com.example.administrador.pvsegalmex.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.entity.WithdrawalEntity;

public class ShowWithdrawalView extends AppCompatActivity {

    AppCompatButton back;
    TextView comment, amount;

    private void inizializate() {
        comment = findViewById(R.id.tvCommentsWithdrawal);
        amount = findViewById(R.id.tvAmountWithdrawalView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_withdrawal_view);
        inizializate();
        amount.setText(String.valueOf(WithdrawalEntity.instance.getAmount()));
        comment.setText(WithdrawalEntity.instance.getComments());

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.itemMenu11));
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp); // your drawable
        toolbar.setNavigationOnClickListener(v -> {
            onBackPressed(); // Implemented by activity
        });
    }
}