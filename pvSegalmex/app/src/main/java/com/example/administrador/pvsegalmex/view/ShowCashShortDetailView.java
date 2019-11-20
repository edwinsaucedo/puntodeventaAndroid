package com.example.administrador.pvsegalmex.view;

import android.Manifest;
import android.arch.lifecycle.ViewModelProviders;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.adapter.RvShowCashShortWayPay;
import com.example.administrador.pvsegalmex.pojo.CashShortDetailWayPayPojo;
import com.example.administrador.pvsegalmex.utils.TemplatePDF;
import com.example.administrador.pvsegalmex.viewEntity.CashShortDetailViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.CashShortDetailViewEntityFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ShowCashShortDetailView extends AppCompatActivity {

    //region TICKET
    private TemplatePDF templatePDF;
    private String[] header = {"Descripción", "Monto"};
    private String shortText = "Corte de Caja";
    private Drawable image;
    private String longTex = "___________________________", images, phone, imagen, nameClient;
    private Double subtotal = 0.0;
    private String titleTicket;
    private Integer folio;
    final int PERMISSION_REQUEST_CODE = 1001;
    private String addressTicket = "";
    //endregion

    private CashShortDetailViewEntity cashShortDetailViewEntity;
    private CashShortDetailViewEntityFactory cashShortDetailViewEntityFactory;
    private ArrayList<CashShortDetailWayPayPojo> cashShortDetailWayPayList;

    private CompositeDisposable compositeDisposable;

    private RecyclerView recyclerView;
    private RvShowCashShortWayPay rvShowCashShortWayPay;

    Double total;


    //region TICKET
    private void dataPDF() {

        if (titleTicket == null || titleTicket.isEmpty()) {
            titleTicket = "Punto Cytruss";
        }
        templatePDF = new TemplatePDF(getApplicationContext());
        templatePDF.openDocumente();

        templatePDF.addTitles(titleTicket, addressTicket);
        templatePDF.addParagraph(shortText);
        templatePDF.createTable(header, getCashShort());
        templatePDF.addParagraph(longTex);
        templatePDF.addParagraph("Total: " + total);
        templatePDF.closeDocumente();
    }

    public String getDate() {
        Date objDate = new Date();
        String strDateFormat = "dd/mm/yyyy KK:mm:ss";
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
        String date = String.valueOf(objSDF.format(objDate));
        return date;
    }

    private void openPDF() {
        boolean result = permissionCheck();
        if (result)
            templatePDF.appViewPDF(this);
    }

    private void openViewer() {
        boolean result = permissionCheck();
        if (result)
            templatePDF.viewPDF();
    }

    private boolean permissionCheck() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
                    checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
            ) {

                ActivityCompat.requestPermissions(ShowCashShortDetailView.this,
                        new String[]{

                                Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE
                        },
                        PERMISSION_REQUEST_CODE);
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    private ArrayList<String[]> getCashShort() {
        ArrayList<String[]> rows = new ArrayList<>();
        Double sumTotal = 0.0;
        for (int i = 0; i < cashShortDetailWayPayList.size(); i++) {
            String amount;
            sumTotal = sumTotal + cashShortDetailWayPayList.get(i).getAmountCapturate();
            amount = String.valueOf(cashShortDetailWayPayList.get(i).getAmountCapturate());
            rows.add(new String[]{cashShortDetailWayPayList.get(i).getWayPayDescription(), amount});
        }
        total = sumTotal;
        return rows;
    }
    //endregion

    private void searchWayPay() {
        Bundle data = this.getIntent().getExtras();
        Integer id = data.getInt("id");
        compositeDisposable.add(cashShortDetailViewEntity.getCashShortDetailWayPay(id)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<CashShortDetailWayPayPojo>>) wayPayListSearch -> {
                            cashShortDetailWayPayList = (ArrayList<CashShortDetailWayPayPojo>) wayPayListSearch;
                            rvShowCashShortWayPay = new RvShowCashShortWayPay(cashShortDetailWayPayList, getApplicationContext());
                            recyclerView.setAdapter(rvShowCashShortWayPay);
                            dataPDF();
                        }, throwable -> {
                        }
                ));
    }

    private void initialize() {
        recyclerView = findViewById(R.id.rvCashShortWayPay);
        cashShortDetailWayPayList = new ArrayList<>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cash_short_detail_view);
        compositeDisposable = new CompositeDisposable();

        initialize();

        rvShowCashShortWayPay = new RvShowCashShortWayPay(cashShortDetailWayPayList, getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(rvShowCashShortWayPay);

        cashShortDetailViewEntityFactory = Injection.providerCashShortDetailViewModelFactory(getApplicationContext());
        cashShortDetailViewEntity = ViewModelProviders.of(this, cashShortDetailViewEntityFactory).get(CashShortDetailViewEntity.class);
        searchWayPay();

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.itemMenu12));
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setPopupTheme(R.style.MyCustomTabLayout);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp); // your drawable
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_pdf, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.viewPDF:
                openViewer();
                return true;
            case R.id.openPDF:
                openPDF();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}