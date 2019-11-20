package com.example.administrador.pvsegalmex.view;

import android.os.Bundle;

import com.example.administrador.pvsegalmex.R;

public class CreditView extends MenuView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getPageLayoutId() {
        return R.layout.activity_credit_view;
    }

    @Override
    protected String getScreenTitle() {
        return getString(R.string.itemMenu10);
    }
}
