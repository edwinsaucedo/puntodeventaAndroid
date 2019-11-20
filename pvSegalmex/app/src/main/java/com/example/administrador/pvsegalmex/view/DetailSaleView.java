package com.example.administrador.pvsegalmex.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.adapter.RvDetailSaleAdapter;
import com.example.administrador.pvsegalmex.entity.SalesDetailEntity;
import com.example.administrador.pvsegalmex.entity.TypeDocumentsEntity;
import com.example.administrador.pvsegalmex.pojo.SalesDetailProductPojo;
import com.example.administrador.pvsegalmex.viewEntity.SalesDetailViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.SalesDetailViewEntityFactory;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DetailSaleView extends AppCompatActivity {

    //region VARS
    private CompositeDisposable compositeDisposable;
    ArrayList<SalesDetailProductPojo> detailProductList;
    ArrayList<SalesDetailEntity> detailEntityArrayList;
    RvDetailSaleAdapter rvDetailSaleAdapter;
    SalesDetailViewEntityFactory salesDetailViewEntityFactory;
    private SalesDetailViewEntity salesDetailViewEntity;
    //endregion

    //region VIEWS
    private TextView tvIDSaleDetail, tvClientNameSaleDetail, tvStatusSaleDetail, tvTotalSaleDetail, tvEstatusSaleDetail, tvUtilitySaleDetail;
    TextView tvSubtotalSale, tvIVASale;
    private RecyclerView rvDetailSales;
    //endregion

    Double sumUtility, sumTotal;

    //region PRIVATE METHODS
    private void inizialiteViews() {
        detailProductList = new ArrayList<>();
        tvClientNameSaleDetail = findViewById(R.id.tvClientNameSaleDetail);
        tvIDSaleDetail = findViewById(R.id.tvIDSaleDetail);
        tvStatusSaleDetail = findViewById(R.id.tvStatusSaleDetail);
        tvTotalSaleDetail = findViewById(R.id.tvTotalSaleN);
        rvDetailSales = findViewById(R.id.rvDetailSale);
        tvEstatusSaleDetail = findViewById(R.id.tvEstatusSaleDetail);
        tvUtilitySaleDetail = findViewById(R.id.tvUtilitySaleDetail);
        tvSubtotalSale = findViewById(R.id.tvSubtotalSale);
        tvIVASale = findViewById(R.id.tvIVASale);
    }

    private void getDataPurchase() {
        Bundle data = this.getIntent().getExtras();
        String amount = String.valueOf(data.getDouble("amountSale"));
        String nameClient = data.getString("nameClient");
        String id = String.valueOf(data.getInt("idSale"));
        String date = data.getString("date");
        String status = data.getString("status");

        sumUtility = 0.0;
        sumTotal = 0.0;
        Double totalUtility;
        for (int i = 0; i < detailProductList.size(); i++) {
            sumUtility = sumUtility + Double.parseDouble(detailProductList.get(i).getAmount());
            if (detailProductList.get(i).getUnitPrice() == null) {
                sumTotal = sumTotal + Double.parseDouble(detailProductList.get(i).getCost());
            } else {
                sumTotal = sumTotal + Double.parseDouble(detailProductList.get(i).getUnitPrice());
            }
        }
        if (sumUtility == 0.0 || sumUtility.isNaN()) {
            tvUtilitySaleDetail.setText(" $0.0");
        } else {
            tvUtilitySaleDetail.setText("$" + String.valueOf(sumUtility));
        }
        tvTotalSaleDetail.setText("$ " + amount);
        tvClientNameSaleDetail.setText(nameClient);
        tvIDSaleDetail.setText(id);
        tvStatusSaleDetail.setText(date);
        tvEstatusSaleDetail.setText(status);

    }

    private void searchDetailSale() {
        Bundle data = this.getIntent().getExtras();
        Integer id = data.getInt("idSale");
        compositeDisposable.add(salesDetailViewEntity.getFilterSaleDetail(id)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<SalesDetailProductPojo>>) saleListSearch -> {
                            detailProductList = (ArrayList<SalesDetailProductPojo>) saleListSearch;
                            if (detailProductList.isEmpty())
                                Toast.makeText(getApplicationContext(), getString(R.string.noHayRegistros), Toast.LENGTH_SHORT).show();
                            rvDetailSaleAdapter = new RvDetailSaleAdapter(detailProductList, getApplicationContext());
                            rvDetailSales.setAdapter(rvDetailSaleAdapter);
                            getDataPurchase();
                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), getString(R.string.errorConsulta), Toast.LENGTH_SHORT).show();
                            Log.e(getString(R.string.errorSQLITE), "");
                        }
                ));
    }
    //endregion

    //region PROTECTED METHODS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sale_view);
        inizialiteViews();
        compositeDisposable = new CompositeDisposable();
        rvDetailSaleAdapter = new RvDetailSaleAdapter(detailProductList, getApplicationContext());
        rvDetailSales.setLayoutManager(new LinearLayoutManager(this));
        rvDetailSales.setAdapter(rvDetailSaleAdapter);
        salesDetailViewEntityFactory = Injection.providerSaleDetailViewModelFactory(getApplicationContext());
        salesDetailViewEntity = ViewModelProviders.of(this, salesDetailViewEntityFactory).get(SalesDetailViewEntity.class);
        searchDetailSale();

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.titleDetailSale));
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp); // your drawable
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    //endregion
}