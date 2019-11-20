package com.example.administrador.pvsegalmex.view;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.adapter.ArrayAdapterProduct;
import com.example.administrador.pvsegalmex.adapter.ArrayAdapterProviderSpinner;
import com.example.administrador.pvsegalmex.adapter.ArrayAdapterSpinnerMeasure;
import com.example.administrador.pvsegalmex.adapter.RvReceiptMerchandiseDetailAdapter;
import com.example.administrador.pvsegalmex.adapter.SimpleSpinnerProviderAdapter;
import com.example.administrador.pvsegalmex.adapter.SimpleSpinnerUnitMeasurementReceipt;
import com.example.administrador.pvsegalmex.api.LoginInfo;
import com.example.administrador.pvsegalmex.api.User;
import com.example.administrador.pvsegalmex.entity.BitacoraEntity;
import com.example.administrador.pvsegalmex.entity.ExistEntity;
import com.example.administrador.pvsegalmex.entity.KardexDetailEntity;
import com.example.administrador.pvsegalmex.entity.KardexEntity;
import com.example.administrador.pvsegalmex.entity.ProductEntity;
import com.example.administrador.pvsegalmex.entity.ProviderEntity;
import com.example.administrador.pvsegalmex.entity.ReceiptOfMerchandiseDetailEntity;
import com.example.administrador.pvsegalmex.entity.ReceiptOfMerchandiseEntity;
import com.example.administrador.pvsegalmex.entity.TypeDocumentsEntity;
import com.example.administrador.pvsegalmex.entity.UnitMeasurementEntity;
import com.example.administrador.pvsegalmex.entity.UserEntity;
import com.example.administrador.pvsegalmex.pojo.ReceiptMerchandiseProductPojo;
import com.example.administrador.pvsegalmex.viewEntity.BitacoraViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.ExistViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.KardexDetailViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.KardexViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.ProductViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.ProviderViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.ReceiptOfMerchandiseDetailViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.ReceiptOfMerchandiseViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.TypeDocumentsViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.UnitMeasurementViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.UserViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.BitacoraViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.ExistViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.KardexDetailViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.KardexViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.ProductViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.ProviderViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.ReceiptOfMerchandiseDetailViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.ReceiptOfMerchandiseViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.TypeDocumentsViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.UnitMeasurementViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.UserViewEntityFactory;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.sql.Timestamp;
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

public class CrudReceiptMerchandiseView extends MenuView {

    //region VARS

    //region USER
    UserViewEntityFactory userViewEntityFactory;
    private UserViewEntity userViewEntity;
    //endregion

    //region TYPE DOCUMENT
    private TypeDocumentsViewEntity typeDocumentsViewEntity;
    TypeDocumentsViewEntityFactory typeDocumentsViewEntityFactory;
    private ArrayList<TypeDocumentsEntity> typeDocumentsArrayListReceiptMerchandise;
    //endregion

    //region KARDEX
    private KardexViewEntity kardexViewEntity;
    KardexViewEntityFactory kardexViewEntityFactory;
    //endregion

    //region KARDEX DETAIL
    private KardexDetailViewEntity kardexDetailViewEntity;
    KardexDetailViewEntityFactory kardexDetailViewEntityFactory;
    //endregion

    //region RECEIPT MERCHANDISE
    ReceiptOfMerchandiseViewEntityFactory receiptOfMerchandiseViewEntityFactory;
    private ReceiptOfMerchandiseViewEntity receiptOfMerchandiseViewEntity;
    //endregion

    //region RECEIPT MERCHANDISE DETAIL
    private ReceiptOfMerchandiseDetailViewEntity receiptOfMerchandiseDetailViewEntity;
    ReceiptOfMerchandiseDetailViewEntityFactory receiptOfMerchandiseDetailViewEntityFactory;
    ArrayList<DetailReceiptMerchandise> detailReceiptMerchandiseListReceiptMerchandise;

    RvReceiptMerchandiseDetailAdapter rvReceiptMerchandiseDetailAdapter;
    ArrayList<ReceiptMerchandiseProductPojo> receiptMerchandiseProductPojoList;
    //endregion

    //region EXIST
    private ExistViewEntity existViewEntity;
    private ExistViewEntityFactory existViewEntityFactory;
    private ArrayList<ExistEntity> existListReceiptMerchandise;
    //endregion

    //region BITACORA
    private BitacoraViewEntity bitacoraViewEntity;
    private BitacoraViewEntityFactory bitacoraViewEntityFactory;
    private ArrayList<BitacoraEntity> bitacoraListReceiptMerchandise;
    //endregion

    //region PRODUCT
    private ArrayList<ProductEntity> productListReceiptMerchandise;
    ProductViewEntityFactory productFactory;
    private ProductViewEntity productViewEntity;
    private ArrayAdapterProduct rvProductAdapter;
    //endregion

    //region PROVIDER
    private ArrayList<ProviderEntity> providerListReceiptMerchandise;
    private ArrayAdapterProviderSpinner adapterProvider;
    SimpleSpinnerProviderAdapter spinnerProviderAdapter;
    private ProviderViewEntity providerViewEntity;
    ProviderViewEntityFactory providerFactory;
    //endregion

    //region Unit Meseasurement
    private UnitMeasurementViewEntity unitMeasurementViewEntity;
    private UnitMeasurementViewEntityFactory unitMeasurementViewEntityFactory;
    private ArrayList<UnitMeasurementEntity> unitMeasurementListReceiptMerchandise;
    SimpleSpinnerUnitMeasurementReceipt spinnerUnitMeasurementAdapter;
    private ArrayAdapterSpinnerMeasure adapterSpinnerMeasure;
    //endregion

    private String tableName;
    private ListView recyclerViewDetail;
    CompositeDisposable compositeDisposable;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private Integer idTabla;
    private int articles, consecutive, typeDocumentConsecutive;

    //endregion

    //region VIEWS
    private EditText edtDate, edtQuantityProduct, edtPriceProduct, edtComment, edtFolio;
    private SearchableSpinner spinnerProvider, spinnerProduct, spinnerUnitPurchaseReceipt;
    private TextView tvSubtotal, tvTotal, tvNoArticles;
    private AppCompatButton btnSave;
    private FloatingActionButton btnSearchDate, btnAddReceiptMerchandiseDetail;
    private AppCompatCheckBox chboxDiconsa;
    private ScrollView scrollViewRM;
    private String uuidProduct;
    //endregion

    //region PROTECTED
    @SuppressLint({"ClickableViewAccessibility", "SimpleDateFormat"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inizialiteViews();
        tvNoArticles.setText("0.0");
        compositeDisposable = new CompositeDisposable();

        bitacoraViewEntityFactory = Injection.providerBitacoraViewModelFactory(getApplicationContext());
        bitacoraViewEntity = ViewModelProviders.of(this, bitacoraViewEntityFactory).get(BitacoraViewEntity.class);
        searchBitacora();

        receiptOfMerchandiseViewEntityFactory = Injection.providerReceiptMerchandiseViewModelFactory(getApplicationContext());
        receiptOfMerchandiseViewEntity = ViewModelProviders.of(this, receiptOfMerchandiseViewEntityFactory).get(ReceiptOfMerchandiseViewEntity.class);

        receiptOfMerchandiseDetailViewEntityFactory = Injection.providerReceiptMerchandiseDetailViewModelFactory(getApplicationContext());
        receiptOfMerchandiseDetailViewEntity = ViewModelProviders.of(this, receiptOfMerchandiseDetailViewEntityFactory).get(ReceiptOfMerchandiseDetailViewEntity.class);

        typeDocumentsViewEntityFactory = Injection.providerTypeDocumentsViewModelFactory(getApplicationContext());
        typeDocumentsViewEntity = ViewModelProviders.of(this, typeDocumentsViewEntityFactory).get(TypeDocumentsViewEntity.class);

        kardexViewEntityFactory = Injection.providerKardexViewModelFactory(getApplicationContext());
        kardexViewEntity = ViewModelProviders.of(this, kardexViewEntityFactory).get(KardexViewEntity.class);

        kardexDetailViewEntityFactory = Injection.providerKardexDetailModelFactory(getApplicationContext());
        kardexDetailViewEntity = ViewModelProviders.of(this, kardexDetailViewEntityFactory).get(KardexDetailViewEntity.class);

        existViewEntityFactory = Injection.providerExistViewModelFactory(getApplicationContext());
        existViewEntity = ViewModelProviders.of(this, existViewEntityFactory).get(ExistViewEntity.class);

        unitMeasurementViewEntityFactory = Injection.providerUnitMeasurementViewModelFactory(getApplicationContext());
        unitMeasurementViewEntity = ViewModelProviders.of(this, unitMeasurementViewEntityFactory).get(UnitMeasurementViewEntity.class);

        scrollViewRM.setOnTouchListener((v, event) -> {
            findViewById(R.id.rvReceiptMerchandiseCrud).getParent()
                    .requestDisallowInterceptTouchEvent(false);
            return false;
        });

        recyclerViewDetail.setOnTouchListener((v, event) -> {
            v.getParent().requestDisallowInterceptTouchEvent(true);
            return false;
        });

        sumQuantity();
        updateTotalValue();

        btnSearchDate.setOnClickListener(v -> showDatePickerDialog());
        setFechaActual();
        mDateSetListener = (datePicker, year, month, day) -> {
            month = month + 1;

            String dateStr = day + "/" + month + "/" + year;
            @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("d/M/yyyy");
            Date date = null;
            try {
                date = sdf.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            sdf = new SimpleDateFormat("dd/MM/yyyy");
            dateStr = sdf.format(date);
            edtDate.setText(dateStr);
        };

        edtDate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        btnSave.setOnClickListener(v -> {
            saveExist();
            saveReceiptMerchandise();
            saveProduct();
            saveTypeDocument();
            this.finish();
        });
    }

    @Override

    protected int getPageLayoutId() {
        return R.layout.activity_crud_receipt_merchandise_view;
    }

    @Override
    protected String getScreenTitle() {
        return getString(R.string.itemMenu16);
    }

    @Override
    protected void onResume() {
        super.onResume();
        providerFactory = Injection.providerProviderViewModelFactory(getApplicationContext());
        providerViewEntity = ViewModelProviders.of(this, providerFactory).get(ProviderViewEntity.class);
        searchProvider();

        productFactory = Injection.providerProductViewModelFactory(getApplicationContext());
        productViewEntity = ViewModelProviders.of(this, productFactory).get(ProductViewEntity.class);
        searchProduct();

        bitacoraViewEntityFactory = Injection.providerBitacoraViewModelFactory(getApplicationContext());
        bitacoraViewEntity = ViewModelProviders.of(this, bitacoraViewEntityFactory).get(BitacoraViewEntity.class);
        searchBitacora();

        existViewEntityFactory = Injection.providerExistViewModelFactory(getApplicationContext());
        existViewEntity = ViewModelProviders.of(this, existViewEntityFactory).get(ExistViewEntity.class);
        searchExist();

        unitMeasurementViewEntityFactory = Injection.providerUnitMeasurementViewModelFactory(getApplicationContext());
        unitMeasurementViewEntity = ViewModelProviders.of(this, unitMeasurementViewEntityFactory).get(UnitMeasurementViewEntity.class);
        searchUnitMeasurement();

        userViewEntityFactory = Injection.providerUserViewModelFactory(getApplicationContext());
        userViewEntity = ViewModelProviders.of(this, userViewEntityFactory).get(UserViewEntity.class);
        //searchUser();

        btnAddReceiptMerchandiseDetail.setOnClickListener(v -> {
            addItemDetail();
            sumQuantity();
            updateTotalValue();
            edtPriceProduct.setText("0.0");
            edtQuantityProduct.setText("0.0");
        });
    }

    //endregion
    //region PRIVATE METHODS
    private void inizialiteViews() {
        bitacoraListReceiptMerchandise = new ArrayList<>();
        productListReceiptMerchandise = new ArrayList<>();
        receiptMerchandiseProductPojoList = new ArrayList<>();
        existListReceiptMerchandise = new ArrayList<>();
        unitMeasurementListReceiptMerchandise = new ArrayList<>();
        detailReceiptMerchandiseListReceiptMerchandise = new ArrayList<>();
        typeDocumentsArrayListReceiptMerchandise = new ArrayList<>();


        edtDate = findViewById(R.id.dateReceiptMerchandise);
        edtPriceProduct = findViewById(R.id.edtProductPriceReceiptMerchandise);
        edtQuantityProduct = findViewById(R.id.edtQuantityProductReceiptMerchandise);
        edtComment = findViewById(R.id.edtCommentsReceiptMerchandise);
        edtFolio = findViewById(R.id.folioReceiptMerchandise);

        spinnerUnitPurchaseReceipt = findViewById(R.id.spinnerUnitPurchaseReceipt);
        spinnerProduct = findViewById(R.id.spinnerProduct);
        spinnerProvider = findViewById(R.id.spinnerProvider);

        btnSearchDate = findViewById(R.id.btnSearchDate);
        btnAddReceiptMerchandiseDetail = findViewById(R.id.btnAddProductReceiptMerchandise);
        btnSave = findViewById(R.id.btnSaveReceiptMerchandise);

        tvSubtotal = findViewById(R.id.tvAmountReceiptMerchandise);
        tvTotal = findViewById(R.id.tvTotalReceiptMerchandiseCrud);
        tvNoArticles = findViewById(R.id.tvNoArticles);

        chboxDiconsa = findViewById(R.id.chboxReceiptMerchandiseDiconsa);

        recyclerViewDetail = findViewById(R.id.rvReceiptMerchandiseCrud);
        scrollViewRM = findViewById(R.id.scrollViewRM);


    }

    //region BINNACLE
    @SuppressWarnings("unchecked")
    private void searchBitacora() {
        compositeDisposable.add(bitacoraViewEntity.getFilterBitacora()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<BitacoraEntity>>) bitacoraListSearch -> bitacoraListReceiptMerchandise = (ArrayList<BitacoraEntity>) bitacoraListSearch, throwable -> {
                        }
                )
        );
    }

    //region KARDEX
    private void clearTableKardex() {
        String x = "Kardex";
        for (int i = 0; i < bitacoraListReceiptMerchandise.size(); i++) {
            tableName = bitacoraListReceiptMerchandise.get(i).getTable();
            if (x.equals(tableName)) {
                idTabla = bitacoraListReceiptMerchandise.get(i).getId();
            }
        }
        if (idTabla == null) {
            BitacoraEntity.instance.clear();
        }
    }

    private void saveBinnacleKardex() {
        try {
            BitacoraEntity bitacoraEntity = new BitacoraEntity();
            clearTableKardex();
            bitacoraEntity.setDate(getDate());
            bitacoraEntity.setTable("Kardex");
            bitacoraEntity.setIdTable(KardexEntity.instance.getId());

            if (BitacoraEntity.instance.getId() == -1) {
                insertBinnacleKardex(bitacoraEntity);
            } else {
                bitacoraEntity.setId(BitacoraEntity.instance.getId());
                updateBinnacleKardex(bitacoraEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertBinnacleKardex(BitacoraEntity bitacoraEntity) {
        compositeDisposable.add(bitacoraViewEntity.insertBitacora(bitacoraEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                })
        );
    }

    private void updateBinnacleKardex(BitacoraEntity bitacoraEntity) {
        compositeDisposable.add(bitacoraViewEntity.updateBitacora(bitacoraEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                })
        );
    }
    //endregion

    //region KARDEX DETAIL
    private void clearTableKardexDetail() {
        String k = "KardexDetalle";
        for (int i = 0; i < bitacoraListReceiptMerchandise.size(); i++) {
            tableName = bitacoraListReceiptMerchandise.get(i).getTable();
            if (k.equals(tableName)) {
                idTabla = bitacoraListReceiptMerchandise.get(i).getId();
            }
        }
        if (idTabla == null) {
            BitacoraEntity.instance.clear();
        }
    }

    private void saveBinnacleKardexDetail() {
        try {
            BitacoraEntity bitacoraEntity = new BitacoraEntity();
            clearTableKardexDetail();
            bitacoraEntity.setDate(getDate());
            bitacoraEntity.setTable("KardexDetalle");
            bitacoraEntity.setIdTable(KardexDetailEntity.instance.getId());

            if (BitacoraEntity.instance.getId() == -1) {
                insertBinnacleKardexDetail(bitacoraEntity);
            } else {
                bitacoraEntity.setId(BitacoraEntity.instance.getId());
                updateBinnacleKardexDetail(bitacoraEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertBinnacleKardexDetail(BitacoraEntity bitacoraEntity) {
        compositeDisposable.add(bitacoraViewEntity.insertBitacora(bitacoraEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                })
        );
    }

    private void updateBinnacleKardexDetail(BitacoraEntity bitacoraEntity) {
        compositeDisposable.add(bitacoraViewEntity.updateBitacora(bitacoraEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                })
        );
    }
    //endregion

    //region RECEIPT OF MERCHANDISE
    private void clearTableReceiptMerchandise() {
        String t = "ReciboMercancia";
        for (int i = 0; i < bitacoraListReceiptMerchandise.size(); i++) {
            tableName = bitacoraListReceiptMerchandise.get(i).getTable();
            if (t.equals(tableName)) {
                idTabla = bitacoraListReceiptMerchandise.get(i).getId();
            }
        }
        if (idTabla == null) {
            BitacoraEntity.instance.clear();
        }
    }

    private void saveBinnacleReceiptMerchandise() {
        try {
            BitacoraEntity bitacoraEntity = new BitacoraEntity();
            clearTableReceiptMerchandise();
            bitacoraEntity.setDate(getDate());
            bitacoraEntity.setTable("ReciboMercancia");
            bitacoraEntity.setIdTable(ReceiptOfMerchandiseEntity.instance.getId());

            if (BitacoraEntity.instance.getId() == -1) {
                insertBinnacleReceiptMerchandise(bitacoraEntity);
            } else {
                bitacoraEntity.setId(BitacoraEntity.instance.getId());
                updateBinnacleReceiptMerchandise(bitacoraEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertBinnacleReceiptMerchandise(BitacoraEntity bitacoraEntity) {
        compositeDisposable.add(bitacoraViewEntity.insertBitacora(bitacoraEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                })
        );
    }

    private void updateBinnacleReceiptMerchandise(BitacoraEntity bitacoraEntity) {
        compositeDisposable.add(bitacoraViewEntity.updateBitacora(bitacoraEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                })
        );
    }
    //endregion

    //region RECEIPT MERCHANDISE DETAIL
    private void clearTableReceiptMerchandiseDetail() {
        String o = "ReciboMercanciaDetalle";
        for (int i = 0; i < bitacoraListReceiptMerchandise.size(); i++) {
            tableName = bitacoraListReceiptMerchandise.get(i).getTable();
            if (o.equals(tableName)) {
                idTabla = bitacoraListReceiptMerchandise.get(i).getId();
            }
        }
        if (idTabla == null) {
            BitacoraEntity.instance.clear();
        }
    }

    private void saveBinnacleReceiptMerchandiseDetail() {
        try {
            BitacoraEntity bitacoraEntity = new BitacoraEntity();
            clearTableReceiptMerchandiseDetail();
            bitacoraEntity.setDate(getDate());
            bitacoraEntity.setTable("ReciboMercanciaDetalle");
            bitacoraEntity.setIdTable(ReceiptOfMerchandiseDetailEntity.instance.getId());

            if (BitacoraEntity.instance.getId() == -1) {
                insertBinnacleReceiptMerchandiseDetail(bitacoraEntity);
            } else {
                bitacoraEntity.setId(BitacoraEntity.instance.getId());
                updateBinnacleReceiptMerchandiseDetail(bitacoraEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertBinnacleReceiptMerchandiseDetail(BitacoraEntity bitacoraEntity) {
        compositeDisposable.add(bitacoraViewEntity.insertBitacora(bitacoraEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                })
        );
    }

    private void updateBinnacleReceiptMerchandiseDetail(BitacoraEntity bitacoraEntity) {
        compositeDisposable.add(bitacoraViewEntity.updateBitacora(bitacoraEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                })
        );
    }
    //endregion

    //region Unit Measurement
    @SuppressWarnings("unchecked")
    private void searchUnitMeasurement() {
        compositeDisposable.add(unitMeasurementViewEntity.getFitlerUnitMeasurament()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<UnitMeasurementEntity>>) unitMeasurementListSearch -> {

                            unitMeasurementListReceiptMerchandise = (ArrayList<UnitMeasurementEntity>) unitMeasurementListSearch;
                            spinnerUnitMeasurementAdapter = new SimpleSpinnerUnitMeasurementReceipt(getApplicationContext(), R.layout.spinner_provider, unitMeasurementListReceiptMerchandise);
                            adapterSpinnerMeasure = new ArrayAdapterSpinnerMeasure(getApplicationContext(), R.layout.sp_client_sale, unitMeasurementListReceiptMerchandise);
                            adapterSpinnerMeasure.setDropDownViewResource(R.layout.sp_client_sale);
                            spinnerUnitPurchaseReceipt.setAdapter(adapterSpinnerMeasure);
                        }, throwable -> {

                        }
                ));
    }
    //endregion

    //region EXIST
    private void clearExist() {
        String e = "Existencia";
        for (int i = 0; i < bitacoraListReceiptMerchandise.size(); i++) {
            tableName = bitacoraListReceiptMerchandise.get(i).getTable();
            if (e.equals(tableName)) {
                idTabla = bitacoraListReceiptMerchandise.get(i).getId();
            }
        }
        if (idTabla == null) {
            BitacoraEntity.instance.clear();
        }
    }


    private void saveBinnacleExist() {
        try {
            BitacoraEntity bitacoraEntity = new BitacoraEntity();
            clearExist();
            bitacoraEntity.setDate(getDate());
            bitacoraEntity.setTable("Existencia");
            bitacoraEntity.setIdTable(ExistEntity.instance.getId());

            if (BitacoraEntity.instance.getId() == -1) {
                insertBinnacleExist(bitacoraEntity);
            } else {
                bitacoraEntity.setId(BitacoraEntity.instance.getId());
                updateBinnacleExist(bitacoraEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertBinnacleExist(BitacoraEntity bitacoraEntity) {
        compositeDisposable.add(bitacoraViewEntity.insertBitacora(bitacoraEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                })
        );
    }

    private void updateBinnacleExist(BitacoraEntity bitacoraEntity) {
        compositeDisposable.add(bitacoraViewEntity.updateBitacora(bitacoraEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                })
        );
    }
    //endregion
    //endregion

    //region PRODUCT
    private void saveProduct() {
        for (int i = 0; i < detailReceiptMerchandiseListReceiptMerchandise.size(); i++) {
            int idProduct = Integer.valueOf(detailReceiptMerchandiseListReceiptMerchandise.get(i).getIdProduct());
            double cost = Double.parseDouble(detailReceiptMerchandiseListReceiptMerchandise.get(i).getPrice());
            int idUnitMeseasurement = Integer.valueOf(detailReceiptMerchandiseListReceiptMerchandise.get(i).getIdUnitMeasurement());
            for (int j = 0; j < productListReceiptMerchandise.size(); j++) {
                if (idProduct == productListReceiptMerchandise.get(j).getId()) {
                    ProductEntity product = new ProductEntity();
                    product.setId(idProduct);
                    product.setDescription(productListReceiptMerchandise.get(j).getDescription());
                    product.setAlternateCode(productListReceiptMerchandise.get(j).getAlternateCode());
                    product.setCategory(productListReceiptMerchandise.get(j).getCategory());
                    product.setCode(productListReceiptMerchandise.get(j).getCode());
                    product.setDiconsa(productListReceiptMerchandise.get(j).getDiconsa());
                    product.setGranel(productListReceiptMerchandise.get(j).getGranel());
                    product.setService(productListReceiptMerchandise.get(j).getService());
                    product.setFactor(productListReceiptMerchandise.get(j).getFactor());
                    product.setMaximum(productListReceiptMerchandise.get(j).getMaximum());
                    product.setMinimum(productListReceiptMerchandise.get(j).getMinimum());
                    product.setReorderPoint(productListReceiptMerchandise.get(j).getReorderPoint());
                    product.setUnitMeasurePurchase(idUnitMeseasurement);
                    product.setUuid(productListReceiptMerchandise.get(j).getUuid());
                    product.setLastDateSync(productListReceiptMerchandise.get(j).getLastDateSync());
                    product.setCost(productListReceiptMerchandise.get(j).getCost());
                    product.setCostUC(cost);
                    product.setDateUC(edtDate.getText().toString());
                    updateProduct(product);
                }
            }
        }
    }

    private void updateProduct(ProductEntity product) {
        compositeDisposable.add(productViewEntity.updateProduct(product)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
        );
    }

    @SuppressWarnings("unchecked")
    private void searchProduct() {
        compositeDisposable.add(productViewEntity.getFilterProductsCatalog()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<ProductEntity>>) productListSearch -> {
                            productListReceiptMerchandise = (ArrayList<ProductEntity>) productListSearch;
                            rvProductAdapter = new ArrayAdapterProduct(CrudReceiptMerchandiseView.this, R.layout.sp_client_sale, productListReceiptMerchandise);
                            rvProductAdapter.setDropDownViewResource(R.layout.sp_client_sale);
                            spinnerProduct.setAdapter(rvProductAdapter);
                        }, throwable -> {

                        }
                ));
    }
    //endregion

    //region EXIST
    @SuppressWarnings("unchecked")
    private void searchExist() {
        compositeDisposable.add(existViewEntity.getFilterExist()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<ExistEntity>>) existListSearch -> existListReceiptMerchandise = (ArrayList<ExistEntity>) existListSearch, throwable -> {
                        }
                ));
    }

    private void saveExist() {
        for (int i = 0; i < detailReceiptMerchandiseListReceiptMerchandise.size(); i++) {
            int idProduct = Integer.valueOf(detailReceiptMerchandiseListReceiptMerchandise.get(i).getIdProduct());
            if (existListReceiptMerchandise.isEmpty()) {
                Double quantity = Double.parseDouble(detailReceiptMerchandiseListReceiptMerchandise.get(i).getQuantity());
                ExistEntity existEntity = new ExistEntity();
                existEntity.setCommitted(0.0);
                existEntity.setEnable(0.0);
                existEntity.setExist(ExistEntity.instance.getExist() + quantity);
                existEntity.setLastDate(ReceiptOfMerchandiseEntity.getInstance().getDate());
                existEntity.setProduct(idProduct);
                existEntity.setSynced(false);
                existEntity.setTraffic(0.0);
                existEntity.setUuid(generateUUID());
                existEntity.setUuidProduct(detailReceiptMerchandiseListReceiptMerchandise.get(i).getUuidProduct());
                existEntity.setDate(getDate());
                insertExist(existEntity);
            } else {
                for (int j = 0; j < existListReceiptMerchandise.size(); j++) {
                    if (idProduct == existListReceiptMerchandise.get(i).getProduct()) {
                        Double quantity = Double.parseDouble(detailReceiptMerchandiseListReceiptMerchandise.get(i).getQuantity());
                        ExistEntity existEntity = new ExistEntity();
                        existEntity.setCommitted(0.0);
                        existEntity.setEnable(0.0);
                        existEntity.setExist(existListReceiptMerchandise.get(i).getExist() + quantity);
                        existEntity.setLastDate(ReceiptOfMerchandiseEntity.getInstance().getDate());
                        existEntity.setProduct(idProduct);
                        existEntity.setSynced(false);
                        existEntity.setTraffic(0.0);
                        existEntity.setUuid(generateUUID());
                        existEntity.setDate(getDate());
                        existEntity.setId(existListReceiptMerchandise.get(i).getId());
                        existEntity.setUuidProduct(detailReceiptMerchandiseListReceiptMerchandise.get(i).getUuidProduct());
                        updateExist(existEntity);
                    } else {
                        Double quantity = Double.parseDouble(detailReceiptMerchandiseListReceiptMerchandise.get(i).getQuantity());
                        ExistEntity existEntity = new ExistEntity();
                        existEntity.setCommitted(0.0);
                        existEntity.setEnable(0.0);
                        existEntity.setExist(quantity);
                        existEntity.setLastDate(ReceiptOfMerchandiseEntity.getInstance().getDate());
                        existEntity.setProduct(idProduct);
                        existEntity.setSynced(false);
                        existEntity.setTraffic(0.0);
                        existEntity.setUuid(generateUUID());
                        existEntity.setDate(getDate());
                        existEntity.setUuidProduct(detailReceiptMerchandiseListReceiptMerchandise.get(i).getUuidProduct());
                        insertExist(existEntity);
                    }
                }
            }
        }
    }

    private void insertExist(ExistEntity existEntity) {
        compositeDisposable.add(existViewEntity.insertExist(existEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (ExistEntity.instance.getId() != -1) {
                        saveBinnacleExist();
                    }
                })
        );
    }

    private void updateExist(ExistEntity existEntity) {
        compositeDisposable.add(existViewEntity.updateExist(existEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (ExistEntity.instance.getId() != -1) {
                        saveBinnacleExist();
                    }
                })
        );
    }
    //endregion

    //region TYPE DOCUMENT
    @SuppressWarnings("unchecked")
    private void searchTypeDocument() {
        String typeDocument = "RECIBO DE MERCANCIA";
        compositeDisposable.add(typeDocumentsViewEntity.getFilterTypeDocuments(typeDocument)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<TypeDocumentsEntity>>) saleListSearch -> {
                            typeDocumentsArrayListReceiptMerchandise = (ArrayList<TypeDocumentsEntity>) saleListSearch;
                            for (int i = 0; i < typeDocumentsArrayListReceiptMerchandise.size(); i++) {
                                consecutive = typeDocumentsArrayListReceiptMerchandise.get(i).getConsecutive();
                            }
                        }, throwable -> {

                        }
                ));
    }

    private void saveTypeDocument() {
        searchTypeDocument();
        TypeDocumentsEntity typeDocumentsEntity = new TypeDocumentsEntity();
        typeDocumentsEntity.setModule("REC");
        typeDocumentsEntity.setDescription("RECIBO DE MERCANCIA");
        typeDocumentsEntity.setStatus(1);
        typeDocumentConsecutive = consecutive + 1;
        typeDocumentsEntity.setConsecutive(typeDocumentConsecutive);

        if (TypeDocumentsEntity.instance.getId() == -1) {
            insertTypeDocument(typeDocumentsEntity);
        }
    }

    private void insertTypeDocument(TypeDocumentsEntity typeDocumentsEntity) {
        compositeDisposable.add(typeDocumentsViewEntity.insertTypeDocuments(typeDocumentsEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (TypeDocumentsEntity.instance.getId() != -1) {
                        saveKardex();
                    }
                })
        );
    }
    //endregion

    //region KARDEX
    private void saveKardex() {
        java.util.Date utilDate = new java.util.Date();

        Calendar cal = Calendar.getInstance(); // locale-specific
        cal.setTime(utilDate);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        long time = cal.getTimeInMillis();

        java.sql.Timestamp sqlTimestamp = new Timestamp(time);
        int id = TypeDocumentsEntity.instance.getId();
        //int idUser = User.build(CrudReceiptMerchandiseView.this).getUser();
        KardexEntity kardexEntity = new KardexEntity();
        kardexEntity.setDate(String.valueOf(sqlTimestamp));
        kardexEntity.setTypeDocument(id);
        kardexEntity.setUser(1);
        kardexEntity.setUuid(generateUUID());
        kardexEntity.setNumberDocument(TypeDocumentsEntity.instance.getConsecutive());
        kardexEntity.setUuidTypeDocument(TypeDocumentsEntity.instance.getUuid());
        kardexEntity.setUuidUser(UserEntity.instance.getUuid());

        if (KardexEntity.instance.getId() == -1) {
            insertKardex(kardexEntity);
        } else {
            kardexEntity.setId(KardexEntity.instance.getId());
            updateKardex(kardexEntity);
        }
    }

    private void insertKardex(KardexEntity kardexEntity) {
        compositeDisposable.add(kardexViewEntity.insertKardex(kardexEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (KardexEntity.instance.getId() != -1) {
                        saveKardexDetail();
                        saveBinnacleKardex();
                    }
                }));
    }

    private void updateKardex(KardexEntity kardexEntity) {
        compositeDisposable.add(kardexViewEntity.updateKardex(kardexEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (KardexEntity.instance.getId() != -1) {
                        saveKardexDetail();
                        saveBinnacleKardex();
                    }
                }));
    }
    //endregion

    //region KARDEX DETAIL
    private void saveKardexDetail() {
        java.util.Date utilDate = new java.util.Date();

        Calendar cal = Calendar.getInstance(); // locale-specific
        cal.setTime(utilDate);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        long time = cal.getTimeInMillis();

        java.sql.Timestamp sqlTimestamp = new Timestamp(time);
        for (int j = 0; j < productListReceiptMerchandise.size(); j++) {
            for (int i = 0; i < detailReceiptMerchandiseListReceiptMerchandise.size(); i++) {
                if (productListReceiptMerchandise.get(j).getId().equals(Integer.valueOf(detailReceiptMerchandiseListReceiptMerchandise.get(i).getIdProduct()))) {
                    int idProduct = Integer.valueOf(detailReceiptMerchandiseListReceiptMerchandise.get(i).getIdProduct());
                    int idUnitMeseauseremt = Integer.valueOf(detailReceiptMerchandiseListReceiptMerchandise.get(i).getIdUnitMeasurement());
                    Double quantity = Double.parseDouble(detailReceiptMerchandiseListReceiptMerchandise.get(i).getQuantity());
                    Double cost = Double.parseDouble(detailReceiptMerchandiseListReceiptMerchandise.get(i).getPrice());
                    KardexDetailEntity kardexDetailEntity = new KardexDetailEntity();
                    kardexDetailEntity.setCost(cost);
                    kardexDetailEntity.setKardex(KardexEntity.instance.getId());
                    kardexDetailEntity.setFactor(0.0);
                    kardexDetailEntity.setProduct(idProduct);
                    kardexDetailEntity.setQuantity(quantity);
                    kardexDetailEntity.setStatus(1);
                    kardexDetailEntity.setValue(0.0);
                    kardexDetailEntity.setUuid(generateUUID());
                    kardexDetailEntity.setUuidKardex(KardexEntity.instance.getUuid());
                    kardexDetailEntity.setUuidProduct(productListReceiptMerchandise.get(j).getUuid());
                    kardexDetailEntity.setUnitOfMeasure(idUnitMeseauseremt);
                    kardexDetailEntity.setDate(String.valueOf(sqlTimestamp));
                    insertKardexDetail(kardexDetailEntity);
                }
            }
        }
    }

    private void insertKardexDetail(KardexDetailEntity kardexDetailEntity) {
        compositeDisposable.add(kardexDetailViewEntity.insertKardexDetail(kardexDetailEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (KardexDetailEntity.instance.getId() != -1) {
                        saveBinnacleKardexDetail();
                    }
                }));
    }
    //endregion

    //region USER
    @SuppressWarnings("unchecked")
    private void searchUser() {
        int user = LoginInfo.build(CrudReceiptMerchandiseView.this).getUserId();
        compositeDisposable.add(userViewEntity.getFilterUser(user)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<UserEntity>) userSearch -> {
                            UserEntity.instance.setUuid(userSearch.getUuid());
                            UserEntity.instance.setUserPV(userSearch.getUserPV());
                            UserEntity.instance.setUser(userSearch.getUser());
                            UserEntity.instance.setPassword(userSearch.getPassword());
                            UserEntity.instance.setName(userSearch.getName());
                            UserEntity.instance.setIdws(userSearch.getIdws());
                            UserEntity.instance.setEmail(userSearch.getEmail());
                            UserEntity.instance.setCompany(userSearch.getCompany());
                            UserEntity.instance.setAccessKey(userSearch.getAccessKey());
                            UserEntity.instance.setStatus(userSearch.getStatus());
                            UserEntity.instance.setTypeUser(userSearch.getTypeUser());
                        }, throwable -> {

                        }
                ));
    }
    //endregion

    //region RECEIPT MERCHANDISE
    private void saveReceiptMerchandise() {
        sumQuantity();
        updateTotalValue();
        ReceiptOfMerchandiseEntity receiptOfMerchandise = new ReceiptOfMerchandiseEntity();
        receiptOfMerchandise.setDate(edtDate.getText().toString().trim());
        if (edtFolio.getText().toString().isEmpty() || edtFolio.getText() == null || edtFolio.getText().toString().equals("")) {
            edtFolio.setError(getString(R.string.fieldRequired));
            return;
        }
        if (providerListReceiptMerchandise.size() < 1) {
            receiptOfMerchandise.setProvider(null);
        } else {
            receiptOfMerchandise.setProvider((int) adapterProvider.getItemId(spinnerProvider.getSelectedItemPosition()));
        }

        if (edtComment.getText().toString().equals("")) {
            receiptOfMerchandise.setComment("");
        } else {
            receiptOfMerchandise.setComment(edtComment.getText().toString().trim());
        }

        if (ReceiptOfMerchandiseEntity.instance.isDiconsa()) {
            chboxDiconsa.setChecked(true);
        } else {
            chboxDiconsa.setChecked(false);
        }

        Double subtotal = Double.parseDouble(tvSubtotal.getText().toString());
        Double total = Double.parseDouble(tvTotal.getText().toString());
        receiptOfMerchandise.setArticles(articles);
        receiptOfMerchandise.setSubtotal(subtotal);
        receiptOfMerchandise.setTotal(total);
        receiptOfMerchandise.setUuid(generateUUID());
        receiptOfMerchandise.setFolio(edtFolio.getText().toString());
        receiptOfMerchandise.setConsecutive(typeDocumentConsecutive);
        receiptOfMerchandise.setUuidProvider(ProviderEntity.instance.getUuid());
        for (int i = 0; i < providerListReceiptMerchandise.size(); i++) {
            if (providerListReceiptMerchandise.get(i).getId().equals(receiptOfMerchandise.getProvider())) {
                receiptOfMerchandise.setUuidProvider(providerListReceiptMerchandise.get(i).getUuid());
            }
        }
        if (ReceiptOfMerchandiseEntity.instance.getId() == -1) {
            insertReceiptMerchandise(receiptOfMerchandise);
        } else {
            receiptOfMerchandise.setId(ReceiptOfMerchandiseEntity.instance.getId());
            updateReceiptMerchandise(receiptOfMerchandise);
        }
    }

    private void insertReceiptMerchandise(ReceiptOfMerchandiseEntity receiptOfMerchandiseEntity) {
        compositeDisposable.add(receiptOfMerchandiseViewEntity.insertReceiptOfMerchandise(receiptOfMerchandiseEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (ReceiptOfMerchandiseEntity.instance.getId() != -1) {
                        saveReceiptMerchandiseDetail();
                        saveBinnacleReceiptMerchandise();
                    }
                }));
    }

    private void updateReceiptMerchandise(ReceiptOfMerchandiseEntity receiptOfMerchandiseEntity) {
        compositeDisposable.add(receiptOfMerchandiseViewEntity.updateReceiptOfMerchandise(receiptOfMerchandiseEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe());
    }
    //endregion

    //region RECEIPT MERCHANDISE DETAIL
    private void saveReceiptMerchandiseDetail() {
        java.util.Date utilDate = new java.util.Date();

        Calendar cal = Calendar.getInstance(); // locale-specific
        cal.setTime(utilDate);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        long time = cal.getTimeInMillis();

        java.sql.Timestamp sqlTimestamp = new Timestamp(time);
        for (int j = 0; j < productListReceiptMerchandise.size(); j++) {
            for (int i = 0; i < detailReceiptMerchandiseListReceiptMerchandise.size(); i++) {
                if (productListReceiptMerchandise.get(j).getId().equals(Integer.valueOf(detailReceiptMerchandiseListReceiptMerchandise.get(i).getIdProduct()))) {
                    int idProduct = Integer.valueOf(detailReceiptMerchandiseListReceiptMerchandise.get(i).getIdProduct());
                    Double quantity = Double.parseDouble(detailReceiptMerchandiseListReceiptMerchandise.get(i).getQuantity());
                    Double subtotal = Double.parseDouble(detailReceiptMerchandiseListReceiptMerchandise.get(i).getSubtotal());
                    Double cost = Double.parseDouble(detailReceiptMerchandiseListReceiptMerchandise.get(i).getPrice());
                    Integer idUnit = Integer.parseInt(detailReceiptMerchandiseListReceiptMerchandise.get(i).getIdUnitMeasurement());

                    ReceiptOfMerchandiseDetailEntity receiptOfMerchandiseDetailEntity = new ReceiptOfMerchandiseDetailEntity();
                    clearTableReceiptMerchandiseDetail();
                    receiptOfMerchandiseDetailEntity.setQuantity(quantity);
                    receiptOfMerchandiseDetailEntity.setSubtotal(subtotal);
                    receiptOfMerchandiseDetailEntity.setProduct(idProduct);
                    receiptOfMerchandiseDetailEntity.setPrice(cost);
                    receiptOfMerchandiseDetailEntity.setTotal(subtotal);
                    receiptOfMerchandiseDetailEntity.setSubtotal(subtotal);
                    receiptOfMerchandiseDetailEntity.setReceiptOfMerchandise(ReceiptOfMerchandiseEntity.instance.getId());
                    receiptOfMerchandiseDetailEntity.setDeparture(1);
                    receiptOfMerchandiseDetailEntity.setFactor(1.0);
                    receiptOfMerchandiseDetailEntity.setUnitMeasure(idUnit);
                    receiptOfMerchandiseDetailEntity.setUuidProduct(productListReceiptMerchandise.get(i).getUuid());
                    receiptOfMerchandiseDetailEntity.setDate(String.valueOf(sqlTimestamp));
                    receiptOfMerchandiseDetailEntity.setUuid(generateUUID());
                    insertReceiptMerchandiseDetail(receiptOfMerchandiseDetailEntity);
                }
            }
        }
    }

    private void insertReceiptMerchandiseDetail(ReceiptOfMerchandiseDetailEntity receiptOfMerchandiseDetailEntity) {
        compositeDisposable.add(receiptOfMerchandiseDetailViewEntity.insertReceiptOfMerchandiseDetail(receiptOfMerchandiseDetailEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (ReceiptOfMerchandiseDetailEntity.instance.getId() != -1) {
                        saveBinnacleReceiptMerchandiseDetail();
                    }
                }));
    }

    //endregion

    //region PROVIDER
    @SuppressWarnings("unchecked")
    private void searchProvider() {
        compositeDisposable.add(providerViewEntity.getFilterProviderReceiptMerchandise()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<ProviderEntity>>) providerListSearch -> {
                    providerListReceiptMerchandise = (ArrayList<ProviderEntity>) providerListSearch;
                    if (providerListReceiptMerchandise.isEmpty())
                        Toast.makeText(getApplicationContext(), getString(R.string.noHayRegistros), Toast.LENGTH_SHORT).show();
                    spinnerProviderAdapter = new SimpleSpinnerProviderAdapter(providerListReceiptMerchandise, getApplicationContext());
                    adapterProvider = new ArrayAdapterProviderSpinner(CrudReceiptMerchandiseView.this, R.layout.spinner_provider, providerListReceiptMerchandise);
                    adapterProvider.setDropDownViewResource(R.layout.spinner_provider);
                    spinnerProvider.setAdapter(adapterProvider);
                }, throwable -> {
                    Toast.makeText(getApplicationContext(), getString(R.string.errorConsulta), Toast.LENGTH_SHORT).show();
                    Log.e(getString(R.string.errorSQLITE), "");
                }));
    }
    //endregion
    @SuppressLint("SimpleDateFormat")
    public void setFechaActual() {
        final Calendar c = Calendar.getInstance();
        Format formatter = new SimpleDateFormat("dd/MM/yyyy");
        String s = formatter.format(c.getTime());
        edtDate.setText(s);
    }

    private void showDatePickerDialog() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(
                CrudReceiptMerchandiseView.this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                mDateSetListener,
                year, month, day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    private void updateTotalValue() {
        Double sum = 0.0;
        for (int i = 0; i < detailReceiptMerchandiseListReceiptMerchandise.size(); i++) {
            sum += Double.parseDouble(detailReceiptMerchandiseListReceiptMerchandise.get(i).getSubtotal());
        }
        tvTotal.setText(String.valueOf(sum));
        tvSubtotal.setText(String.valueOf(sum));
    }

    private void sumQuantity() {
        Double quantityProduct = 0.0;
        for (int i = 0; i < detailReceiptMerchandiseListReceiptMerchandise.size(); i++) {
            quantityProduct += Double.parseDouble(detailReceiptMerchandiseListReceiptMerchandise.get(i).getQuantity());
        }
        tvNoArticles.setText(String.valueOf(quantityProduct));
        articles = (int) quantityProduct.doubleValue();
    }

    private void addItemDetail() {
        if (edtPriceProduct.getText().toString().isEmpty()) {
            edtPriceProduct.setError(getString(R.string.fieldRequired));
            return;
        }
        if (edtQuantityProduct.getText().toString().isEmpty()) {
            edtQuantityProduct.setError(getString(R.string.fieldRequired));
            return;
        }
        int idProduct = (int) spinnerProduct.getSelectedItemId();
        String unitMeasesurement = String.valueOf(spinnerUnitPurchaseReceipt.getSelectedItem());
        int idMeasesurement = (int) spinnerUnitPurchaseReceipt.getSelectedItemId();
        String product = String.valueOf(spinnerProduct.getSelectedItem());
        Double price = Double.parseDouble(edtPriceProduct.getText().toString());
        Double quantity = Double.parseDouble(edtQuantityProduct.getText().toString());
        Double subtotal = price * quantity;

        String product2 = String.valueOf(product);
        String price2 = String.valueOf(price);
        String quantity2 = String.valueOf(quantity);
        String subtotal2 = String.valueOf(subtotal);
        String idProdyct2 = String.valueOf(idProduct);
        String idUnit = String.valueOf(idMeasesurement);

        for (int i = 0; i < productListReceiptMerchandise.size(); i++) {
            if (productListReceiptMerchandise.get(i).getId() == idProduct) {
                uuidProduct = productListReceiptMerchandise.get(i).getUuid();
            }
        }
        if (detailReceiptMerchandiseListReceiptMerchandise.isEmpty()) {
            DetailReceiptMerchandise detailReceiptMerchandise = new DetailReceiptMerchandise(product2, quantity2, price2, subtotal2, idProdyct2, idUnit, unitMeasesurement, uuidProduct);
            detailReceiptMerchandiseListReceiptMerchandise.add(detailReceiptMerchandise);
            rvReceiptMerchandiseDetailAdapter = new RvReceiptMerchandiseDetailAdapter(this, R.layout.rv_receipt_merchandise_detail_adapter, detailReceiptMerchandiseListReceiptMerchandise);
            recyclerViewDetail.setAdapter(rvReceiptMerchandiseDetailAdapter);
            rvReceiptMerchandiseDetailAdapter.notifyDataSetChanged();
        } else {
            for (int i = 0; i < detailReceiptMerchandiseListReceiptMerchandise.size(); i++) {
                String productDescription, productQuantity, productPrice, productSubtotal, productId;
                if (detailReceiptMerchandiseListReceiptMerchandise.get(i).getIdProduct().equals(idProdyct2)) {
                    String priceProduct = detailReceiptMerchandiseListReceiptMerchandise.get(i).getPrice();
                    if (priceProduct.equals(price2)) {
                        String quantityList = detailReceiptMerchandiseListReceiptMerchandise.get(i).getQuantity();
                        Double quantityCalculate = Double.valueOf(quantityList) + quantity;
                        Double subtotalCalculate = quantityCalculate * price;
                        String subtotalProduct = String.valueOf(subtotalCalculate);
                        productQuantity = String.valueOf(quantityCalculate);
                        productDescription = product2;
                        productPrice = price2;
                        productSubtotal = subtotalProduct;
                        productId = idProdyct2;
                        DetailReceiptMerchandise detailReceiptMerchandise = new DetailReceiptMerchandise(productDescription, productQuantity, productPrice, productSubtotal, productId, idUnit, unitMeasesurement, uuidProduct);
                        detailReceiptMerchandiseListReceiptMerchandise.set(i, detailReceiptMerchandise);
                        rvReceiptMerchandiseDetailAdapter = new RvReceiptMerchandiseDetailAdapter(this, R.layout.rv_receipt_merchandise_detail_adapter, detailReceiptMerchandiseListReceiptMerchandise);
                        recyclerViewDetail.setAdapter(rvReceiptMerchandiseDetailAdapter);
                        rvReceiptMerchandiseDetailAdapter.notifyDataSetChanged();
                    } else {
                        Double priceEditText = Double.parseDouble(edtPriceProduct.getText().toString());
                        Double quantityEditText = Double.parseDouble(edtQuantityProduct.getText().toString());
                        String priceCalculate = String.valueOf(price);
                        Double subtotalCalculate = quantityEditText * priceEditText;
                        String subtotalProduct = String.valueOf(subtotalCalculate);
                        productQuantity = quantity2;
                        productDescription = product2;
                        productPrice = priceCalculate;
                        productSubtotal = subtotalProduct;
                        productId = idProdyct2;
                        DetailReceiptMerchandise detailReceiptMerchandise = new DetailReceiptMerchandise(productDescription, productQuantity, productPrice, productSubtotal, productId, idUnit, unitMeasesurement, uuidProduct);
                        detailReceiptMerchandiseListReceiptMerchandise.set(i, detailReceiptMerchandise);
                        rvReceiptMerchandiseDetailAdapter = new RvReceiptMerchandiseDetailAdapter(this, R.layout.rv_receipt_merchandise_detail_adapter, detailReceiptMerchandiseListReceiptMerchandise);
                        recyclerViewDetail.setAdapter(rvReceiptMerchandiseDetailAdapter);
                        rvReceiptMerchandiseDetailAdapter.notifyDataSetChanged();
                    }
                } else {
                    productDescription = product2;
                    productId = idProdyct2;
                    productPrice = price2;
                    productQuantity = quantity2;
                    productSubtotal = subtotal2;
                    DetailReceiptMerchandise detailReceiptMerchandise = new DetailReceiptMerchandise(productDescription, productQuantity, productPrice, productSubtotal, productId, idUnit, unitMeasesurement, uuidProduct);
                    detailReceiptMerchandiseListReceiptMerchandise.add(detailReceiptMerchandise);
                    rvReceiptMerchandiseDetailAdapter = new RvReceiptMerchandiseDetailAdapter(this, R.layout.rv_receipt_merchandise_detail_adapter, detailReceiptMerchandiseListReceiptMerchandise);
                    recyclerViewDetail.setAdapter(rvReceiptMerchandiseDetailAdapter);
                    rvReceiptMerchandiseDetailAdapter.notifyDataSetChanged();
                }
            }
        }
    }
    //endregion00.+-+---
}