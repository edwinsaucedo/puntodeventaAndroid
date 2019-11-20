package com.example.administrador.pvsegalmex.view;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.adapter.RvCashIncomeAdapter;
import com.example.administrador.pvsegalmex.entity.CashIncomeDetailEntity;
import com.example.administrador.pvsegalmex.entity.CashIncomeEntity;
import com.example.administrador.pvsegalmex.viewEntity.CashIncomeViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.CashIncomeViewEntityFactory;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CashIncomeView extends MenuView {

    //region VARS
    ArrayList<CashIncomeEntity> cashIncomeList;
    CashIncomeViewEntity cashIncomeViewEntity;
    CashIncomeViewEntityFactory cashIncomeViewEntityFactory;

    CompositeDisposable compositeDisposable;
    RvCashIncomeAdapter rvCashIncomeAdapter;

    private DatePickerDialog.OnDateSetListener mDateSetListener;
    int dia, mes, anio;
    //endregion

    //region VIEWS
    EditText edtIncomeDate;
    FloatingActionButton btnAddIncome, btnSearchIncome;
    RecyclerView rvIncome;
    //endregion

    //region PRIVATE METHODS
    private void initializeViews() {
        cashIncomeList = new ArrayList<>();
        edtIncomeDate = findViewById(R.id.edtDatCashIncome);
        btnAddIncome = findViewById(R.id.btnAddIncome);
        btnSearchIncome = findViewById(R.id.btnSearchIncome);
        rvIncome = findViewById(R.id.rvIncome);
    }

    @SuppressWarnings("unchecked")
    private void searchIncome() {//metodo de busqueda para mostrar los ingresos registrados
        String date;
        date = edtIncomeDate.getText().toString();
        compositeDisposable.add(cashIncomeViewEntity.getFilterIncome(date)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<CashIncomeEntity>>) incomeListSearch -> {
                            cashIncomeList = (ArrayList<CashIncomeEntity>) incomeListSearch;
                            if (cashIncomeList.isEmpty())
                                Toast.makeText(getApplicationContext(), getString(R.string.noHayRegistros), Toast.LENGTH_SHORT).show();
                            rvCashIncomeAdapter = new RvCashIncomeAdapter(cashIncomeList, getApplicationContext());
                            rvCashIncomeAdapter.setOnClickListener(onClick);
                            rvIncome.setAdapter(rvCashIncomeAdapter);
                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), getString(R.string.errorConsulta), Toast.LENGTH_SHORT).show();
                            Log.e(getString(R.string.errorSQLITE), "");
                        }
                ));
    }

    private void goToShowIncome(CashIncomeEntity cashIncomeEntity) {//metodo que manda datos para visualizarse
        CashIncomeEntity.instance.setId(cashIncomeEntity.getId());
        CashIncomeEntity.instance.setAmount(cashIncomeEntity.getAmount());
        CashIncomeEntity.instance.setComments(cashIncomeEntity.getComments());
        Intent intent = new Intent(getApplicationContext(), ShowCashIncomeView.class);
        startActivity(intent);
    }

    public void setFechaActual() {//obtener fecha actual
        final Calendar c = Calendar.getInstance();
        anio = c.get(Calendar.YEAR);
        mes = c.get(Calendar.MONTH);
        dia = c.get(Calendar.DAY_OF_MONTH);
        @SuppressLint("SimpleDateFormat") Format formatter = new SimpleDateFormat("dd/MM/yyyy");
        String s = formatter.format(c.getTime());
        edtIncomeDate.setText(s);
    }

    private void showDatePickerDialog() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(
                CashIncomeView.this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                mDateSetListener,
                year, month, day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    @SuppressLint("SimpleDateFormat")
    private void getDataDatePicker() {
        mDateSetListener = (datePicker, year, month, day) -> {
            month = month + 1;

            String dateStr = day + "/" + month + "/" + year;
            SimpleDateFormat sdf = new SimpleDateFormat("d/M/yyyy");
            Date date = null;
            try {
                date = sdf.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            sdf = new SimpleDateFormat("dd/MM/yyyy");
            dateStr = sdf.format(date);

            edtIncomeDate.setText(dateStr);
        };


        edtIncomeDate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                searchIncome();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initializeViews();

        compositeDisposable = new CompositeDisposable();

        rvCashIncomeAdapter = new RvCashIncomeAdapter(cashIncomeList, getApplicationContext());
        rvIncome.setLayoutManager(new LinearLayoutManager(this));
        rvIncome.setAdapter(rvCashIncomeAdapter);

        btnAddIncome.setOnClickListener(v -> {
            CashIncomeEntity.instance.clear();
            CashIncomeDetailEntity.instance.clear();
            startActivity(CrudCashIncomeView.class);
        });

        btnSearchIncome.setOnClickListener(v -> showDatePickerDialog());
        setFechaActual();

        getDataDatePicker();
    }

    @Override
    protected int getPageLayoutId() {
        return R.layout.activity_cash_income_view;
    }

    @Override
    protected String getScreenTitle() {
        return getString(R.string.itemMenu15);
    }

    @Override
    protected void onResume() {
        super.onResume();
        cashIncomeViewEntityFactory = Injection.providerCashIncomeViewModelFactory(getApplicationContext());
        cashIncomeViewEntity = ViewModelProviders.of(this, cashIncomeViewEntityFactory).get(CashIncomeViewEntity.class);
        searchIncome();
    }

    private View.OnClickListener onClick = this::addItem;

    public void addItem(View v) {
        CashIncomeEntity cashIncomeEntity = cashIncomeList.get(rvIncome.getChildAdapterPosition(v));
        goToShowIncome(cashIncomeEntity);
    }

    @Override
    public void onBackPressed() {
    }
}