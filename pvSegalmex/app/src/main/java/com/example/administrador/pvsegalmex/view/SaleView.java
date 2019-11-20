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
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.adapter.RvSalesAdapter;
import com.example.administrador.pvsegalmex.entity.SalesDetailEntity;
import com.example.administrador.pvsegalmex.entity.SalesEntity;
import com.example.administrador.pvsegalmex.pojo.SalesClientPojo;
import com.example.administrador.pvsegalmex.viewEntity.SalesDetailViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.SalesViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.SalesDetailViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.SalesViewEntityFactory;

import java.text.DecimalFormat;
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

public class SaleView extends MenuView {

    //region VARS
    private ArrayList<SalesClientPojo> salesList;
    private SalesViewEntity salesViewEntity;
    private SalesViewEntityFactory salesFactory;
    private SalesDetailViewEntity salesDetailViewEntity;
    private SalesDetailViewEntityFactory salesDetailViewEntityFactory;
    private ArrayList<SalesDetailEntity> salesDetailList;
    private CompositeDisposable compositeDisposable;
    private RvSalesAdapter rvSalesAdapter;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    int dia, mes, anio, numSales;
    Double sumSale, totalSale, sumUtility, totalUtility, sumCost;
    //endregion

    //region VIEWS
    private TextView tvSumTotal, tvNumberSale, tvUtility;
    private EditText edtDateSale;
    private FloatingActionButton btnSearchSale;
    private RecyclerView rvSales;
    //endregion

    //region PRIVATE METHODS
    private void initializeViews() {
        salesList = new ArrayList<>();
        edtDateSale = findViewById(R.id.edtSaleDate);
        btnSearchSale = findViewById(R.id.btnSearchSale);
        rvSales = findViewById(R.id.rvSales);
        tvSumTotal = findViewById(R.id.tvTotalAmount);
        tvNumberSale = findViewById(R.id.tvNumberSale);
        tvUtility = findViewById(R.id.tvUtility);
    }

    private void searchSale() {
        if (salesViewEntity == null) {
            salesViewEntity = ViewModelProviders.of(this, salesFactory).get(SalesViewEntity.class);
        }
        String date = "";
        if (date == null) {
            return;
        }

        date = edtDateSale.getText().toString();
        compositeDisposable.add(salesViewEntity.getFilterSale(date)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<SalesClientPojo>>) saleListSearch -> {
                            salesList = (ArrayList<SalesClientPojo>) saleListSearch;
                            rvSalesAdapter = new RvSalesAdapter(salesList, getApplicationContext());
                            rvSalesAdapter.setOnClickListener(onClick);
                            rvSales.setAdapter(rvSalesAdapter);
                            sumAmount();
                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), getString(R.string.errorConsulta), Toast.LENGTH_LONG).show();
                            Log.e(getString(R.string.errorSQLITE), "");
                        }
                ));
    }

    private void sumAmount() {
        sumSale = 0.0;
        sumUtility = 0.0;
        totalSale = 0.0;
        sumCost = 0.0;
        numSales = salesList.size();

        for (int i = 0; i < salesList.size(); i++) {
            sumUtility = sumUtility + Double.parseDouble(salesList.get(i).getUtilityPercentage());
            sumSale = sumSale + Double.parseDouble(salesList.get(i).getAmount());
        }

        SalesEntity.instance.setSumaTotal(sumSale);
        tvSumTotal.setText(String.valueOf(sumSale));
        totalUtility = sumUtility / numSales;
        if (totalUtility == 0.0 || totalUtility.isNaN()) {
            tvUtility.setText(String.valueOf(0 + "%"));
        } else {
            DecimalFormat df = new DecimalFormat("#.00");
            tvUtility.setText(String.valueOf((df.format(totalUtility) + "%")));
        }
        tvNumberSale.setText(String.valueOf(salesList.size()));
    }

    private View.OnClickListener onClick = this::addItem;

    public void addItem(View v) {
        int id = Integer.parseInt(salesList.get(rvSales.getChildAdapterPosition(v)).getIdSale());
        String nameClient = salesList.get(rvSales.getChildAdapterPosition(v)).getClient();
        Double amount = Double.parseDouble(salesList.get(rvSales.getChildAdapterPosition(v)).getAmount());
        String date = salesList.get(rvSales.getChildAdapterPosition(v)).getDate();
        String status = salesList.get(rvSales.getChildAdapterPosition(v)).getStatus();
        Intent intent = new Intent(getApplicationContext(), DetailSaleView.class);
        intent.putExtra("idSale", id);
        intent.putExtra("nameClient", nameClient);
        intent.putExtra("amountSale", amount);
        intent.putExtra("date", date);
        intent.putExtra("status", status);
        startActivity(intent);
    }

    private void addInformation() {
        SalesEntity salesEntity = new SalesEntity();
        SalesClientPojo salesClientPojo = new SalesClientPojo();
        salesClientPojo.setAmount(String.valueOf(salesEntity.getTotal()));
        salesClientPojo.setIdClient(String.valueOf(salesEntity.getClient()));
        salesClientPojo.setIdSale(String.valueOf(salesEntity.getId()));
        salesClientPojo.setStatus(salesEntity.getSalesStatus());
    }

    private void showDatePickerDialog() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(
                SaleView.this,
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
        edtDateSale.setText(s);
    }
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeViews();
        addInformation();
        rvSalesAdapter = new RvSalesAdapter(salesList, getApplicationContext());
        rvSales.setLayoutManager(new LinearLayoutManager(this));
        rvSales.setAdapter(rvSalesAdapter);

        btnSearchSale.setOnClickListener(v -> showDatePickerDialog());
        compositeDisposable = new CompositeDisposable();

        salesDetailViewEntityFactory = Injection.providerSaleDetailViewModelFactory(getApplicationContext());
        salesDetailViewEntity = ViewModelProviders.of(this, salesDetailViewEntityFactory).get(SalesDetailViewEntity.class);

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
            sdf = new SimpleDateFormat("dd/MM/yyyy");
            dateStr = sdf.format(date);

            edtDateSale.setText(dateStr);
        };

        String dateStr = "20190226";

        edtDateSale.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                searchSale();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @Override
    protected int getPageLayoutId() {
        return R.layout.activity_purchase_view;
    }

    @Override
    protected String getScreenTitle() {
        return getString(R.string.itemMenu14);
    }

    @Override
    protected void onResume() {
        super.onResume();
        salesFactory = Injection.providerSaleViewModelFactory(getApplicationContext());
        salesViewEntity = ViewModelProviders.of(this, salesFactory).get(SalesViewEntity.class);
        searchSale();
    }

    @Override
    public void onBackPressed() {
    }
}