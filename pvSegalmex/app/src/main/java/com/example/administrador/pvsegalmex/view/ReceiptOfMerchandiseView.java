package com.example.administrador.pvsegalmex.view;

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
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.adapter.RvReceiptMerchandiseProviderAdapter;
import com.example.administrador.pvsegalmex.entity.ExistEntity;
import com.example.administrador.pvsegalmex.entity.KardexDetailEntity;
import com.example.administrador.pvsegalmex.entity.KardexEntity;
import com.example.administrador.pvsegalmex.entity.ReceiptOfMerchandiseDetailEntity;
import com.example.administrador.pvsegalmex.entity.ReceiptOfMerchandiseEntity;
import com.example.administrador.pvsegalmex.entity.TypeDocumentsEntity;
import com.example.administrador.pvsegalmex.pojo.ReceiptMerchandiseProviderPojo;
import com.example.administrador.pvsegalmex.viewEntity.ReceiptOfMerchandiseViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.ReceiptOfMerchandiseViewEntityFactory;

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

public class ReceiptOfMerchandiseView extends MenuView {

    //region VARS
    private ArrayList<ReceiptMerchandiseProviderPojo> receiptMerchandiseProviderList;
    ArrayList<ReceiptOfMerchandiseEntity> receiptOfMerchandiseList;
    private ReceiptOfMerchandiseViewEntity receiptOfMerchandiseViewEntity;
    ReceiptOfMerchandiseViewEntityFactory receiptOfMerchandiseViewEntityFactory;
    private CompositeDisposable compositeDisposable;
    private RvReceiptMerchandiseProviderAdapter rvReceiptMerchandiseProviderAdapter;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    int dia, mes, anio;
    //endregion

    //region VIEWS
    private EditText edtReceipt;
    private FloatingActionButton btnSearchReceiptMerchandise, addReceiptMerchandise;
    private RecyclerView rvReceiptMerchandise;
    //endregion

    //region PRIVATE METHODS
    private void inizialiteViews() {
        receiptMerchandiseProviderList = new ArrayList<>();
        receiptOfMerchandiseList = new ArrayList<>();
        edtReceipt = findViewById(R.id.edtDateReceiptMerchandise);
        btnSearchReceiptMerchandise = findViewById(R.id.btnSearchReceiptMerchandise);
        rvReceiptMerchandise = findViewById(R.id.rvReceiptMerchandise);
        addReceiptMerchandise = findViewById(R.id.btnAddReceiptMerchandise);
    }

    private void searchReceiptMerchandise() {
        String date = edtReceipt.getText().toString();
        compositeDisposable.add(receiptOfMerchandiseViewEntity.getFilterReceiptOfMerchandise(date)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<ReceiptMerchandiseProviderPojo>>) receiptMerchandiseListSearch -> {
                            receiptMerchandiseProviderList = (ArrayList<ReceiptMerchandiseProviderPojo>) receiptMerchandiseListSearch;
                            if (receiptMerchandiseProviderList.isEmpty())
                                Toast.makeText(getApplicationContext(), getString(R.string.noHayRegistros), Toast.LENGTH_SHORT).show();
                            rvReceiptMerchandiseProviderAdapter = new RvReceiptMerchandiseProviderAdapter(receiptMerchandiseProviderList, getApplicationContext());
                            // rvReceiptMerchandiseProviderAdapter.setOnClickListener(onClick);
                            rvReceiptMerchandise.setAdapter(rvReceiptMerchandiseProviderAdapter);
                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), getString(R.string.errorConsulta), Toast.LENGTH_SHORT).show();
                            Log.e(getString(R.string.errorSQLITE), "");
                        }
                )
        );
    }

    private void showDatePickerDialog() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(
                ReceiptOfMerchandiseView.this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                mDateSetListener,
                year, month, day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    public void setFechaActual() {
        final Calendar c = Calendar.getInstance();
        anio = c.get(Calendar.YEAR);
        mes = c.get(Calendar.MONTH);
        dia = c.get(Calendar.DAY_OF_MONTH);
        Format formatter = new SimpleDateFormat("dd/MM/yyyy");
        String s = formatter.format(c.getTime());
        edtReceipt.setText(s);
    }

    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inizialiteViews();
        compositeDisposable = new CompositeDisposable();
        rvReceiptMerchandiseProviderAdapter = new RvReceiptMerchandiseProviderAdapter(receiptMerchandiseProviderList, getApplicationContext());
        rvReceiptMerchandise.setLayoutManager(new LinearLayoutManager(this));
        rvReceiptMerchandise.setAdapter(rvReceiptMerchandiseProviderAdapter);
        btnSearchReceiptMerchandise.setOnClickListener(v -> showDatePickerDialog());

        addReceiptMerchandise.setOnClickListener(v -> {
            ReceiptOfMerchandiseEntity.instance.clear();
            ReceiptOfMerchandiseDetailEntity.instance.clear();
            TypeDocumentsEntity.instance.clear();
            ExistEntity.instance.clear();
            KardexEntity.instance.clear();
            KardexDetailEntity.instance.clear();
            startActivity(CrudReceiptMerchandiseView.class);
        });

        setFechaActual();

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
            sdf = new SimpleDateFormat("d/M/yyyy");
            dateStr = sdf.format(date);

            edtReceipt.setText(dateStr);
        };

        String dateStr = "20190226";

        edtReceipt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                searchReceiptMerchandise();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @Override
    protected int getPageLayoutId() {
        return R.layout.activity_receipt_of_merchandise_view;
    }

    @Override
    protected String getScreenTitle() {
        return getString(R.string.itemMenu16);
    }

    @Override
    protected void onResume() {
        super.onResume();
        receiptOfMerchandiseViewEntityFactory = Injection.providerReceiptMerchandiseViewModelFactory(getApplicationContext());
        receiptOfMerchandiseViewEntity = ViewModelProviders.of(this, receiptOfMerchandiseViewEntityFactory).get(ReceiptOfMerchandiseViewEntity.class);
        searchReceiptMerchandise();
    }

    @Override
    public void onBackPressed() {
    }
}
