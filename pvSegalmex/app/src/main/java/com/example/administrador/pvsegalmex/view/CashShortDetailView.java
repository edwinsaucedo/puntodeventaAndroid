package com.example.administrador.pvsegalmex.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.adapter.RvCashShortDetailAdapter;
import com.example.administrador.pvsegalmex.entity.CashShortDetailEntity;
import com.example.administrador.pvsegalmex.entity.CashShortEntity;
import com.example.administrador.pvsegalmex.viewEntity.CashShortViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.CashShortViewEntityFactory;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CashShortDetailView extends MenuView {

    //region VARS
    private ArrayList<CashShortEntity> cashShortList;
    private CashShortViewEntity cashShortViewEntity;
    private CashShortViewEntityFactory cashShortViewEntityFactory;

    private CompositeDisposable compositeDisposable;
    private RvCashShortDetailAdapter rvCashShortDetailAdapter;
    //endregion

    //region VIEWS
    private RecyclerView rvCashShortDetail;
    private FloatingActionButton btnAddCashShortDetail;
    //endregion

    //region PRIVATE METHODS-+
    private void inizializateViews() {
        cashShortList = new ArrayList<>();
        rvCashShortDetail = findViewById(R.id.rvCashShort);
        btnAddCashShortDetail = findViewById(R.id.btnAddCashShortDetail);
    }

    private void gotoShowCashShortDetail(CashShortEntity cashShortEntity) {
        Integer id = cashShortEntity.getId();
        Intent intent = new Intent(getApplicationContext(), ShowCashShortDetailView.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    @SuppressWarnings("unchecked")
    private void searchCashShortDetail() {
        compositeDisposable.add(cashShortViewEntity.getFilterCashShort()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<CashShortEntity>>) cashShortListSearch -> {
                            cashShortList = (ArrayList<CashShortEntity>) cashShortListSearch;
                            rvCashShortDetailAdapter = new RvCashShortDetailAdapter(cashShortList, getApplicationContext());
                            rvCashShortDetailAdapter.setOnClickListener(onClick);
                            rvCashShortDetail.setAdapter(rvCashShortDetailAdapter);
                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), getString(R.string.errorConsulta), Toast.LENGTH_SHORT).show();
                            Log.e(getString(R.string.errorSQLITE), "");
                        }
                ));
    }
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inizializateViews();
        compositeDisposable = new CompositeDisposable();
        rvCashShortDetailAdapter = new RvCashShortDetailAdapter(cashShortList, getApplicationContext());
        rvCashShortDetail.setLayoutManager(new GridLayoutManager(this, 2));
        rvCashShortDetail.setAdapter(rvCashShortDetailAdapter);

        cashShortViewEntityFactory = Injection.providerCashShortViewModelFactory(getApplicationContext());
        cashShortViewEntity = ViewModelProviders.of(this, cashShortViewEntityFactory).get(CashShortViewEntity.class);

        btnAddCashShortDetail.setOnClickListener(v -> {
            CashShortDetailEntity.instance.clear();
            CashShortEntity.instance.clear();
            Intent intent = new Intent(getApplicationContext(), CrudCashShortDetailView.class);
            startActivity(intent);
        });
    }

    @Override
    protected int getPageLayoutId() {
        return R.layout.activity_cash_short_detail_view;
    }

    @Override
    protected String getScreenTitle() {
        return getString(R.string.itemMenu12);
    }

    @Override
    protected void onResume() {
        super.onResume();
        cashShortViewEntityFactory = Injection.providerCashShortViewModelFactory(getApplicationContext());
        cashShortViewEntity = ViewModelProviders.of(this, cashShortViewEntityFactory).get(CashShortViewEntity.class);
        searchCashShortDetail();
    }

    private View.OnClickListener onClick = this::addItem;

    public void addItem(View v) {
        CashShortEntity cashShortDetailEntity = cashShortList.get(rvCashShortDetail.getChildAdapterPosition(v));
        gotoShowCashShortDetail(cashShortDetailEntity);
    }

    @Override
    public void onBackPressed() {
    }
}