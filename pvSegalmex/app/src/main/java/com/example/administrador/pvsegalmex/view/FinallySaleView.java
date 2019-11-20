package com.example.administrador.pvsegalmex.view;

import android.Manifest;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.adapter.ProductSale;
import com.example.administrador.pvsegalmex.api.LoginInfo;
import com.example.administrador.pvsegalmex.entity.CashShortEntity;
import com.example.administrador.pvsegalmex.entity.ClienteEntity;
import com.example.administrador.pvsegalmex.entity.SalesEntity;
import com.example.administrador.pvsegalmex.entity.StoreEntity;
import com.example.administrador.pvsegalmex.utils.TemplatePDF;
import com.example.administrador.pvsegalmex.viewEntity.CashShortViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.SalesDetailViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.StoreViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.CashShortViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.SalesDetailViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.StoreViewEntityFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class FinallySaleView extends AppCompatActivity {

    //region VARS
    private CompositeDisposable compositeDisposable;

    //region SALES DETAIL
    private SalesDetailViewEntity salesDetailViewEntity;
    SalesDetailViewEntityFactory salesDetailViewEntityFactory;
    private Integer id, idTable, idTabla;
    //endregion

    //region TICKET
    private TemplatePDF templatePDF;
    private String[] header = {"Cantidad", "Producto", "Precio"};
    private String shortText = "Punto de venta";
    private Drawable image;
    private String longTex = "___________________________", images, phone, imagen, nameClient;
    private double subtotal = 0.0;
    private String titleTicket;
    private Integer folio;
    final int PERMISSION_REQUEST_CODE = 1001;
    private String addressTicket = "";
    //endregion

    //region CASH SHORT
    private CashShortViewEntity cashShortViewEntity;
    CashShortViewEntityFactory cashShortViewEntityFactory;
    private ArrayList<CashShortEntity> cashShortDetailList;
    //endregion

    //region STORE
    private StoreViewEntity storeViewEntity;
    private StoreViewEntityFactory storeViewEntityFactory;
    //endregion
    //endregion

    //region VIEWS
    private Button btnComplete, btnPrint, btnPrintPDF;
    private ArrayList<ProductSale> productSalesList;
    //endregion

    //region PRIVATE METHODS
    private void inizialiteViews() {
        btnPrint = findViewById(R.id.btnPrint);
        btnPrintPDF = findViewById(R.id.btnPrintPDF);
        productSalesList = new ArrayList<>();
        btnComplete = findViewById(R.id.btnCompleteSale);
    }

    //region CASH SHORT
    private void searchCashShort() {
        compositeDisposable.add(cashShortViewEntity.getFilterCashShort()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<CashShortEntity>>) cashShortDetailListSearch -> {
                            cashShortDetailList = (ArrayList<CashShortEntity>) cashShortDetailListSearch;
                            for (int i = 0; i < cashShortDetailList.size(); i++) {
                                CashShortEntity.instance.setId(cashShortDetailList.get(i).getId());
                            }
                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), getString(R.string.errorConsulta), Toast.LENGTH_LONG).show();
                            Log.e(getString(R.string.errorSQLITE), "");
                        }
                ));
    }
    //endregion


    //region SALE DETAIL
    private void getDetailSale() {
        Bundle data = this.getIntent().getExtras();
        productSalesList = data.getParcelableArrayList("vListDetailSale");
    }

    //region TICKET
    private void dataPDF() {
        titleTicket = StoreEntity.instance.getStoreName();
        addressTicket = StoreEntity.instance.getDirection();
        folio = SalesEntity.instance.getDocumentFolio();
        imagen = StoreEntity.instance.getLocalDirection();
        phone = StoreEntity.instance.getPhonenumber();
        nameClient = ClienteEntity.instance.getName() + " " + ClienteEntity.instance.getLastName1() + " " + ClienteEntity.instance.getLastName2();

        if (titleTicket == null || titleTicket.isEmpty()) {
            titleTicket = "Punto Cytruss";
        }
        String nameUser = String.valueOf(LoginInfo.build(FinallySaleView.this).getNombreUsuario());
        templatePDF = new TemplatePDF(getApplicationContext());
        templatePDF.openDocumente();
        templatePDF.addImage(imagen);
        templatePDF.addMetaData("Ticket", "Venta", "PuntoCytruss");
        templatePDF.addTitles(titleTicket, addressTicket);
        templatePDF.addClientInformation("Datos del Cliente", nameClient);
        templatePDF.addTicketInformation("Factura simplificada", "Folio: " + folio, getDate(), "Le ha atendido a usted:" + nameUser);
        templatePDF.addParagraph(shortText);
        templatePDF.createTable(header, getProduct());
        templatePDF.addParagraph(longTex);
        templatePDF.addParagraph("Total: " + subtotal);
        templatePDF.addSmallParagraph(addressTicket, phone);
        templatePDF.closeDocumente();
    }

    public String getDate() {
        Date objDate = new Date();
        String strDateFormat = "dd-mm-yyyy KK:mm:ss";
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

                ActivityCompat.requestPermissions(FinallySaleView.this,
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

    private ArrayList<String[]> getProduct() {
        subtotal = 0.0;
        double costoProducto = 0.0;
        ArrayList<String[]> rows = new ArrayList<>();
        for (int i = 0; i < productSalesList.size(); i++) {
            costoProducto = productSalesList.get(i).getProductSaleCostQuantity();
            subtotal = subtotal + costoProducto;
            rows.add(new String[]{productSalesList.get(i).getProductQuantity().toString(), productSalesList.get(i).getProductSaleDescription(), productSalesList.get(i).getProductSaleCostQuantity().toString()});
        }
        return rows;
    }
    //endregion

    //region STORE
    private void searchStore() {
        compositeDisposable.add(storeViewEntity.getFilterStore()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<StoreEntity>) storeSearch -> {
                            if (storeSearch.getId() != null) {
                                StoreEntity.instance.setId(storeSearch.getId());
                                StoreEntity.instance.setDirection(storeSearch.getDirection());
                                StoreEntity.instance.setLatitud(storeSearch.getLatitud());
                                StoreEntity.instance.setLongitud(storeSearch.getLongitud());
                                StoreEntity.instance.setOwner(storeSearch.getOwner());
                                StoreEntity.instance.setPhonenumber(storeSearch.getPhonenumber());
                                StoreEntity.instance.setStoreName(storeSearch.getStoreName());
                                StoreEntity.instance.setImage(storeSearch.getImage());
                                StoreEntity.instance.setLocalDirection(storeSearch.getLocalDirection());
                                addressTicket = storeSearch.getDirection();
                                titleTicket = storeSearch.getStoreName();
                            }

                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), "Ocurrio un error al consultar tienda", Toast.LENGTH_LONG).show();
                            Log.e(getString(R.string.errorSQLITE), "");
                        }
                )
        );
    }
    //endregion
    //endregion

    //region PUBLIC METHODS
    public void pdfPrint(View view) {
        openPDF();
    }

    public void pdfView(View view) {
        openViewer();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), PointOfSaleView.class);
        startActivity(intent);
        this.finish();
    }
    //endregion

    //region PROTECTED
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finally_sale_view);
        inizialiteViews();
        compositeDisposable = new CompositeDisposable();

        salesDetailViewEntityFactory = Injection.providerSaleDetailViewModelFactory(getApplicationContext());
        salesDetailViewEntity = ViewModelProviders.of(this, salesDetailViewEntityFactory).get(SalesDetailViewEntity.class);

        getDetailSale();
        dataPDF();

        btnComplete.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), PointOfSaleView.class);
            startActivity(intent);
        });

        storeViewEntityFactory = Injection.providerStoreViewModelFactory(getApplicationContext());
        storeViewEntity = ViewModelProviders.of(this, storeViewEntityFactory).get(StoreViewEntity.class);
        searchStore();

        btnPrint.setOnClickListener(v -> openViewer());
        btnPrintPDF.setOnClickListener(v -> openPDF());
    }

    @Override
    protected void onResume() {
        super.onResume();
        storeViewEntityFactory = Injection.providerStoreViewModelFactory(getApplicationContext());
        storeViewEntity = ViewModelProviders.of(this, storeViewEntityFactory).get(StoreViewEntity.class);
        searchStore();
        cashShortViewEntityFactory = Injection.providerCashShortViewModelFactory(getApplicationContext());
        cashShortViewEntity = ViewModelProviders.of(this, cashShortViewEntityFactory).get(CashShortViewEntity.class);
        searchCashShort();
    }
    //endregion
}