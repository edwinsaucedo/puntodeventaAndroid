package com.example.administrador.pvsegalmex.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.adapter.RvExistProductAdapter;
import com.example.administrador.pvsegalmex.pojo.ExistProductPojo;
import com.example.administrador.pvsegalmex.viewEntity.ExistViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.ExistViewEntityFactory;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ExistView extends MenuView {

    //region VARS
    private ArrayList<ExistProductPojo> existProductList;
    private ExistViewEntity existViewEntity;
    private ExistViewEntityFactory existViewEntityFactory;
    private CompositeDisposable compositeDisposable;
    private RvExistProductAdapter rvExistProductAdapter;
    private Context context;
    //endregion

    //region VIEWS
    private EditText edtProductExist;
    private FloatingActionButton btnSearchExist;
    private RecyclerView rvExist;
    //endregion

    private void initializeViews() {
        existProductList = new ArrayList<>();
        edtProductExist = findViewById(R.id.edtProductExist);
        btnSearchExist = findViewById(R.id.btnSearchExist);
        rvExist = findViewById(R.id.rvExist);
        existProductList = new ArrayList<>();
    }

    private void searchExist() {
        String description = edtProductExist.getText().toString();
        compositeDisposable.add(existViewEntity.getFilterExistProductPojo(description)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<ExistProductPojo>>) saleListSearch -> {
                            existProductList = (ArrayList<ExistProductPojo>) saleListSearch;
                            if (existProductList.isEmpty())
                                Toast.makeText(getApplicationContext(), getString(R.string.noHayRegistros), Toast.LENGTH_SHORT).show();
                            rvExistProductAdapter = new RvExistProductAdapter(existProductList, getApplicationContext());
                            rvExist.setAdapter(rvExistProductAdapter);
                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), getString(R.string.errorConsulta), Toast.LENGTH_SHORT).show();
                            Log.e(getString(R.string.errorSQLITE), "");
                        }
                ));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeViews();
        compositeDisposable = new CompositeDisposable();
        rvExistProductAdapter = new RvExistProductAdapter(existProductList, getApplicationContext());
        rvExist.setLayoutManager(new LinearLayoutManager(this));
        rvExist.setAdapter(rvExistProductAdapter);
        btnSearchExist.setOnClickListener(v -> searchExist());
    }

    @Override
    protected int getPageLayoutId() {
        return R.layout.activity_exist_view;
    }

    @Override
    protected String getScreenTitle() {
        return getString(R.string.itemMenu17);
    }

    @Override
    protected void onResume() {
        super.onResume();
        existViewEntityFactory = Injection.providerExistViewModelFactory(getApplicationContext());
        existViewEntity = ViewModelProviders.of(this, existViewEntityFactory).get(ExistViewEntity.class);
        searchExist();
    }

    @Override
    public void onBackPressed() {
    }
}
