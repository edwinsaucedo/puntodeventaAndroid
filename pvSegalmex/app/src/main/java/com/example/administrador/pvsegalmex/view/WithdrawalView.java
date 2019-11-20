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
import android.widget.Toast;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.adapter.RvWithdrawalAdapter;
import com.example.administrador.pvsegalmex.entity.WithdrawalDetailEntity;
import com.example.administrador.pvsegalmex.entity.WithdrawalEntity;
import com.example.administrador.pvsegalmex.viewEntity.WithdrawalViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.WithdrawalViewEntityFactory;

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

public class WithdrawalView extends MenuView {

    //region VARS
    private ArrayList<WithdrawalEntity> withdrawalList;
    private WithdrawalViewEntity withdrawalViewEntity;
    private WithdrawalViewEntityFactory withdrawalFactory;
    private RvWithdrawalAdapter rvWithdrawalAdapter;

    private CompositeDisposable compositeDisposable;

    private DatePickerDialog.OnDateSetListener mDateSetListener;
    //endregion

    //region VIEWS
    private EditText edtWithdrawalDate;
    private FloatingActionButton btnAddWithdrawal, btnSearchWithdrawal;
    private RecyclerView rvWithdrawal;
    //endregion

    //region PRIVATE METHODS
    private void inizializateViews() {
        withdrawalList = new ArrayList<>();
        edtWithdrawalDate = findViewById(R.id.edtDateWithdrawal);
        btnAddWithdrawal = findViewById(R.id.btnAddWithdrawal);
        btnSearchWithdrawal = findViewById(R.id.btnSearchWithdrawal);
        rvWithdrawal = findViewById(R.id.rvWithdrawal);
    }

    public void searchWithdrawal() {
        String date;
        date = edtWithdrawalDate.getText().toString();
        compositeDisposable.add(withdrawalViewEntity.getFilterWithdrawal(date)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<WithdrawalEntity>>) withdrawalListSearch -> {
                            withdrawalList = (ArrayList<WithdrawalEntity>) withdrawalListSearch;
                            if (withdrawalList.isEmpty())
                                Toast.makeText(getApplicationContext(), getString(R.string.noHayRegistros), Toast.LENGTH_SHORT).show();
                            rvWithdrawalAdapter = new RvWithdrawalAdapter(withdrawalList, getApplicationContext());
                            rvWithdrawalAdapter.setOnClickListener(onClick);
                            rvWithdrawal.setAdapter(rvWithdrawalAdapter);
                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), getString(R.string.errorConsulta), Toast.LENGTH_SHORT).show();
                            Log.e(getString(R.string.errorSQLITE), "");
                        }
                ));
    }

    private void goToEditWithdrawal(WithdrawalEntity withdrawal) {
        WithdrawalEntity.instance.setId(withdrawal.getId());
        WithdrawalEntity.instance.setAmount(withdrawal.getAmount());
        WithdrawalEntity.instance.setComments(withdrawal.getComments());
        WithdrawalEntity.instance.setDate(withdrawal.getDate());
        WithdrawalEntity.instance.setUser(withdrawal.getUser());
        Intent intent = new Intent(getApplicationContext(), ShowWithdrawalView.class);
        startActivity(intent);
    }

    private void showDatePickerDialog() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(
                WithdrawalView.this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                mDateSetListener,
                year, month, day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    public void setFechaActual() {
        final Calendar c = Calendar.getInstance();
        int anio = c.get(Calendar.YEAR);
        int mes = c.get(Calendar.MONTH);
        int dia = c.get(Calendar.DAY_OF_MONTH);
        Format formatter = new SimpleDateFormat("dd/MM/yyyy");
        String s = formatter.format(c.getTime());
        edtWithdrawalDate.setText(s);
    }
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        inizializateViews();

        compositeDisposable = new CompositeDisposable();

        rvWithdrawalAdapter = new RvWithdrawalAdapter(withdrawalList, getApplicationContext());
        rvWithdrawal.setLayoutManager(new LinearLayoutManager(this));
        rvWithdrawal.setAdapter(rvWithdrawalAdapter);

        btnAddWithdrawal.setOnClickListener(v -> {
            WithdrawalEntity.instance.clear();
            WithdrawalDetailEntity.instance.clear();
            startActivity(CrudWithdrawalView.class);
        });

        btnSearchWithdrawal.setOnClickListener(v -> showDatePickerDialog());
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


            edtWithdrawalDate.setText(dateStr);
        };

        String dateStr = "20190226";

        edtWithdrawalDate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                searchWithdrawal();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @Override
    protected int getPageLayoutId() {
        return R.layout.activity_withdrawal_view;
    }

    @Override
    protected String getScreenTitle() {
        return getString(R.string.itemMenu11);
    }

    @Override
    protected void onResume() {
        super.onResume();
        withdrawalFactory = Injection.providerWithdrawalViewModelFactory(getApplicationContext());
        withdrawalViewEntity = ViewModelProviders.of(this, withdrawalFactory).get(WithdrawalViewEntity.class);
        searchWithdrawal();
    }

    private View.OnClickListener onClick = this::addItem;

    public void addItem(View v) {
        WithdrawalEntity withdrawalClicked = withdrawalList.get(rvWithdrawal.getChildAdapterPosition(v));
        goToEditWithdrawal(withdrawalClicked);
    }

    @Override
    public void onBackPressed() {
    }
}