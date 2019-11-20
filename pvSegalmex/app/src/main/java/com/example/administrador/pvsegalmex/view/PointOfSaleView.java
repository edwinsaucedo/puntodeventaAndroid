package com.example.administrador.pvsegalmex.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.adapter.GridProductAdapter;
import com.example.administrador.pvsegalmex.adapter.ProductSale;
import com.example.administrador.pvsegalmex.adapter.RvProductSaleAdapter;
import com.example.administrador.pvsegalmex.controller.SwipeControllerActions;
import com.example.administrador.pvsegalmex.controller.SwipeControllerRV;
import com.example.administrador.pvsegalmex.entity.BitacoraEntity;
import com.example.administrador.pvsegalmex.entity.CashRegisterEntity;
import com.example.administrador.pvsegalmex.entity.ClienteEntity;
import com.example.administrador.pvsegalmex.entity.CollectionOfPaymentEntity;
import com.example.administrador.pvsegalmex.entity.SalesDetailEntity;
import com.example.administrador.pvsegalmex.entity.SalesEntity;
import com.example.administrador.pvsegalmex.entity.TypeDocumentsEntity;
import com.example.administrador.pvsegalmex.entity.UnitMeasurementEntity;
import com.example.administrador.pvsegalmex.entity.WayPayEntity;
import com.example.administrador.pvsegalmex.mode.Barcodemode;
import com.example.administrador.pvsegalmex.pojo.ProductPriceCopyPojo;
import com.example.administrador.pvsegalmex.pojo.ProductPricePojo;
import com.example.administrador.pvsegalmex.pojo.SalesDetailProductPojo;
import com.example.administrador.pvsegalmex.uint.ScanHelper;
import com.example.administrador.pvsegalmex.uint.SysBarcodeUtil;
import com.example.administrador.pvsegalmex.utils.DialogUtils;
import com.example.administrador.pvsegalmex.utils.Utils;
import com.example.administrador.pvsegalmex.viewEntity.BitacoraViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.ProductViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.SalesDetailViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.SalesViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.TypeDocumentsViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.BitacoraViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.ProductViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.SalesDetailViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.SalesViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.TypeDocumentsViewEntityFactory;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class PointOfSaleView extends MenuView implements DialogDetailProductSale.setQuantityProduct, DialogGranelProduct.setQuantityGranel, AdapterView.OnItemClickListener {
    //region VARS
    private CompositeDisposable compositeDisposable;

    //region PRODUCT
    private ArrayList<ProductSale> productSalesList;
    private ArrayList<ProductPricePojo> productList;
    private ArrayList<ProductPricePojo> search;
    private ArrayList<ProductPriceCopyPojo> search2;
    private ArrayList<ProductPricePojo> search3;
    private ProductViewEntityFactory productFactory;
    private ProductViewEntity productViewEntity;
    //endregion

    //region TYPE DOCUMENT
    private TypeDocumentsViewEntity typeDocumentsViewEntity;
    private TypeDocumentsViewEntityFactory typeDocumentsViewEntityFactory;
    private ArrayList<TypeDocumentsEntity> typeDocumentsArrayListPointSale;
    //endregion

    //region SALES
    private SalesViewEntity salesViewEntity;
    private SalesViewEntityFactory salesFactory;
    private ArrayList<SalesEntity> salesEntityListPointSale;
    //endregion

    //region SALE DETAIL
    private ArrayList<SalesDetailProductPojo> detailProductList;
    private SalesDetailViewEntity salesDetailViewEntity;
    private SalesDetailViewEntityFactory salesDetailViewEntityFactory;
    //endregion

    //region BITACORA
    private BitacoraViewEntity bitacoraViewEntity;
    private BitacoraViewEntityFactory bitacoraViewEntityFactory;
    private ArrayList<BitacoraEntity> bitacoraListPointSale;
    //endregion

    //region String
    private String codigoRec;
    private String productotabla, codigoDialog;
    private String descriptionDialog, descriptionDialogGranel, codigoDialogGranel, codeBar;
    private String m_Broadcastname;
    //endregion

    //region Integer
    private Integer idTabla, idSale, countIncompleteSale;
    private Integer quantityDialog, idProductDialogGranel, granelDialog, nProducts, typeDocument;
    //endregion

    //region Double
    private Double cost, price, priceM, quantity, subtotal = 0.0, percentageM, amountM, percentage, amount, sumUtility = 0.0, sumProductCost = 0.0;
    private double costDialog, costDialogGranel, quantityDialogGranel, quantityProductGranel, getQuantityDialogGranel;
    //endregion

    //region Int
    private int scanmode = -1, typeDocumentConsecutive, consecutive = 0;
    private int quantityProduct;
    //endregion

    //region Boolean
    private Boolean mayoreo = false;
    private boolean exsist, bandera;
    private boolean bleft = false, bright = false, bsound = false;
    private Boolean saleDetail = false;
    //endregion

    //endregion

    //region VIEWS
    private LottieAnimationView lootieAnimationView;
    private ItemTouchHelper touchHelper;
    private SwipeControllerRV swipe;
    private RecyclerView rvProductsSale, rvIncompleteSale;
    private LinearLayout rlCart;
    private MyDrawerLayout drawerCart;
    private TextView tvTotal, tvPay, tvNproducts, tvProductSaleTotal, tvNproductsHeader, tvContainer;
    private RelativeLayout rlPay;
    private android.support.v7.widget.SearchView searchView;
    private EditText mProductCode;
    private GridView rvProductCatalog;
    private GridProductAdapter gridProductAdapter;
    private FloatingActionButton btnViewGrid, btnViewLinear, btnDeleteProduct, btnCarSale;
    private LinearLayout rlPoint;
    private RvProductSaleAdapter productSaleAdapter;
    private Context context = this;
    //endregion

    //region PROTECTED METHODS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeViews();
        TypeDocumentsEntity.instance.clear();
        SalesEntity.instance.clear();
        UnitMeasurementEntity.instance.clear();

        compositeDisposable = new CompositeDisposable();
        ScanSetting();

        productList = new ArrayList<>();
        gridProductAdapter = new GridProductAdapter(search, getApplicationContext());
        //gridProductAdapter.setOnClickListener(onClick);
        rvProductCatalog.setOnItemClickListener(PointOfSaleView.this::onItemClick);

        typeDocumentsViewEntityFactory = Injection.providerTypeDocumentsViewModelFactory(getApplicationContext());
        typeDocumentsViewEntity = ViewModelProviders.of(this, typeDocumentsViewEntityFactory).get(TypeDocumentsViewEntity.class);

        salesFactory = Injection.providerSaleViewModelFactory(getApplicationContext());
        salesViewEntity = ViewModelProviders.of(this, salesFactory).get(SalesViewEntity.class);

        bitacoraViewEntityFactory = Injection.providerBitacoraViewModelFactory(getApplicationContext());
        bitacoraViewEntity = ViewModelProviders.of(this, bitacoraViewEntityFactory).get(BitacoraViewEntity.class);
        searchBitacora();

        salesDetailViewEntityFactory = Injection.providerSaleDetailViewModelFactory(getApplicationContext());
        salesDetailViewEntity = ViewModelProviders.of(this, salesDetailViewEntityFactory).get(SalesDetailViewEntity.class);

        Utils.visualizacion = Utils.GRID;
        //rvProductCatalog.setLayoutManager(new GridLayoutManager(this, 2));

        final FragmentManager fragment = getSupportFragmentManager();
        final DialogIncompleteSale dialogIncompleteSale = new DialogIncompleteSale();

        rlCart = findViewById(R.id.rl_SeeCart);
        drawerCart = findViewById(R.id.drawerCart);

        rlCart.setOnClickListener(v -> {
            drawerCart.openDrawer(Gravity.END);
            hideKeyBoaard();
        });

        Barcodemode code = new Barcodemode();
        mProductCode.setText(code.getBarcode());
        btnViewGrid.setOnClickListener(v -> {
            Utils.visualizacion = Utils.GRID;
            //rvProductCatalog.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
            gridProductAdapter = new GridProductAdapter(search, getApplicationContext());
            //gridProductAdapter.setOnClickListener(onClick);
            rvProductCatalog.setAdapter(gridProductAdapter);
            rvProductCatalog.setOnItemClickListener(PointOfSaleView.this::onItemClick);
        });

        typeDocumentsViewEntityFactory = Injection.providerTypeDocumentsViewModelFactory(getApplicationContext());
        typeDocumentsViewEntity = ViewModelProviders.of(this, typeDocumentsViewEntityFactory).get(TypeDocumentsViewEntity.class);
        searchTypeDocument();
        btnViewLinear.setOnClickListener(v -> {
            Utils.visualizacion = Utils.LIST;
            //rvProductCatalog.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            gridProductAdapter = new GridProductAdapter(search, getApplicationContext());
            rvProductCatalog.setAdapter(gridProductAdapter);
            rvProductCatalog.setOnItemClickListener(PointOfSaleView.this::onItemClick);
            hideKeyBoaard();
        });

        btnCarSale.setOnClickListener(view -> dialogIncompleteSale.show(fragment, "vv"));
        saleDrawer();
        search2 = new ArrayList<>();
        search3 = new ArrayList<>();
        search = new ArrayList<>();

        search2.size();
        //LimpiarLista
        btnDeleteProduct.setOnClickListener(v -> DialogUtils.showOkayNoDialog(getString(R.string.delProductSaleWarningMessage), getString(R.string.delProductSaleWarningTitle), PointOfSaleView.this, new DialogUtils.OnOkayNoEvent() {
            @Override
            public void onYes() {
                recreate();
            }

            @Override
            public void onNo() {
                Toast.makeText(getApplicationContext(), "Ok", Toast.LENGTH_SHORT).show();
            }
        }));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText == null) {
                    newText = "";
                }
                searchProduct(newText);
                return false;
            }
        });

        rlPay.setOnClickListener(v -> {
            if (CashRegisterEntity.instance.getId() == null) {
                CashRegisterEntity.instance.clear();
            }
            saveTypeDocument();
            CollectionOfPaymentEntity.instance.clear();
            int noArticles = nProducts;
            int idSaleInstance = SalesEntity.instance.getId();
            Intent intent = new Intent(getApplicationContext(), CollectionOfPaymentView.class);
            intent.putExtra("vSubtotal", subtotal);
            intent.putExtra("vListSale", productSalesList);
            intent.putExtra("noArticulos", noArticles);
            intent.putExtra("idSaleInstance", idSaleInstance);
            startActivity(intent);
        });

        //Agregar con Scanner productos al carrito
        mProductCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String codeEdit;

                //Asigna el codigo de barras que espera en metodo addItem con el del EditText(mProductCode)

                codeEdit = mProductCode.getText().toString();
                codeBar = codeEdit;
                codeBar = codeBar.replaceAll("(\n|\r)", "");
                //
                addItem();
            }
        });
        rvProductsSale.setOnClickListener(v -> hideKeyBoaard());
        rvProductsSale.setOnClickListener(v -> hideKeyBoaard());
        // rvProductCatalog.setOnClickListener(v -> hideKeyBoaard());
        rvProductsSale.setOnClickListener(v -> hideKeyBoaard());
        rlPoint.setOnClickListener(v -> hideKeyBoaard());

        updateSubtotal();
    }

    @Override
    protected int getPageLayoutId() {
        return R.layout.activity_point_of_sale_view;
    }

    @Override
    protected String getScreenTitle() {
        return getString(R.string.itemMenu10);
    }

    @Override
    protected void onResume() {
        super.onResume();

        salesFactory = Injection.providerSaleViewModelFactory(this.getApplicationContext());
        salesViewEntity = ViewModelProviders.of(this, salesFactory).get(SalesViewEntity.class);
        searchSaleIncomplete();

        productFactory = Injection.providerProductViewModelFactory(getApplicationContext());
        productViewEntity = ViewModelProviders.of(this, productFactory).get(ProductViewEntity.class);

        searchProduct("");
        updateSubtotal();

        //searchProductCode();
        //calcularTotalVenta();
        final IntentFilter intentFilter = new IntentFilter();
        m_Broadcastname = "com.barcode.sendBroadcast";// com.barcode.sendBroadcastScan
        intentFilter.addAction(m_Broadcastname);
        registerReceiver(receiver, intentFilter);
        checkItemsList();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context arg0, Intent arg1) {
            if (arg1.getAction().equals(m_Broadcastname)) {
                String str = arg1.getStringExtra("BARCODE");
                if (!"".equals(str)) {
                    Barcodemode code = new Barcodemode();
                    code.setBarcode(str);
                    codeBar = str;

                    //searchProductCode();
                    addItem();

                    //  searchProductCode();
                    //mProductCode.setText(str);
                }
            }
        }
    };
    //endregion

    //region PRIVATE METHODS
    private void initializeViews() {
        mProductCode = findViewById(R.id.edtProductCodeSale);
        rvProductCatalog = findViewById(R.id.gridProducts);
        btnDeleteProduct = findViewById(R.id.btnDeleteSale);
        tvNproducts = findViewById(R.id.tvNproducts);
        rvProductsSale = findViewById(R.id.rvProductsSale);
        tvProductSaleTotal = findViewById(R.id.tvProductSaleTotal);
        tvTotal = findViewById(R.id.txvTotal);
        tvNproductsHeader = findViewById(R.id.tvnavHeaderItems);
        rlPay = findViewById(R.id.rlPay);
        tvPay = findViewById(R.id.tvPay);
        searchView = findViewById(R.id.simpleSearchView);
        btnViewLinear = findViewById(R.id.btnViewList);
        btnViewGrid = findViewById(R.id.btnViewGrid);
        rlPoint = findViewById(R.id.rlPoint);
        lootieAnimationView = findViewById(R.id.animation);
        rvIncompleteSale = findViewById(R.id.rvIncompleteSale);
        btnCarSale = findViewById(R.id.btnCarSale);
        lootieAnimationView.setSpeed(5);
        tvContainer = findViewById(R.id.idContainer);
    }

    //region TYPE DOCUMENT
    private void searchTypeDocument() {
        String typeDocument = "VENTA";
        compositeDisposable.add(typeDocumentsViewEntity.getFilterTypeDocuments(typeDocument)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<TypeDocumentsEntity>>) saleListSearch -> {
                            typeDocumentsArrayListPointSale = (ArrayList<TypeDocumentsEntity>) saleListSearch;
                            for (int i = 0; i < typeDocumentsArrayListPointSale.size(); i++) {
                                consecutive = typeDocumentsArrayListPointSale.get(i).getConsecutive();
                            }
                        }, throwable -> {

                        }
                ));
    }

    private void saveTypeDocument() {
        searchTypeDocument();
        TypeDocumentsEntity typeDocumentsEntity = new TypeDocumentsEntity();
        typeDocumentsEntity.setModule("VTA");
        typeDocumentsEntity.setDescription("VENTA");
        typeDocumentsEntity.setStatus(1);

        if (typeDocument == null) {
            typeDocumentConsecutive = 0;
            typeDocumentConsecutive = consecutive + 1;
            typeDocumentsEntity.setConsecutive(typeDocumentConsecutive);
        } else {
            typeDocumentsEntity.setConsecutive(typeDocument);
        }

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
                        saveSales();
                    } else {
                        Toast.makeText(getApplicationContext(), getString(R.string.ocurrioError), Toast.LENGTH_SHORT).show();
                    }
                })
        );
    }
    //endregion

    //region SALES
    public Double sumAmountUtility() {
        Double amountUtility;
        for (int i = 0; i < productSalesList.size(); i++) {
            amountUtility = productSalesList.get(i).getProductAmountPercentage();
            sumUtility = sumUtility + amountUtility;
        }
        return sumUtility;
    }

    public Double sumProductCost() {
        Double amountPercentage;
        for (int i = 0; i < productSalesList.size(); i++) {
            amountPercentage = productSalesList.get(i).getProductCost();
            sumProductCost = sumProductCost + amountPercentage;
        }
        return sumProductCost;
    }

    private void saveSales() {
        Double utility = sumAmountUtility();
        Double cost = sumProductCost();
        Double percentageSale = (utility * 100) / cost;
        int type = TypeDocumentsEntity.instance.getConsecutive();
        SalesEntity sales = new SalesEntity();

        sales.setDate(getDate());//*
        sales.setTotal(Double.parseDouble(tvTotal.getText().toString().trim()));//
        sales.setNoAticles(nProducts);//*
        sales.setSalesStatus("ABIERTA");//*

        sales.setCashShort(1);//*
        sales.setTypeDocumentVta(TypeDocumentsEntity.instance.getId());//*
        sales.setDocumentFolio(typeDocumentConsecutive);//*
        sales.setWayPay(1);//*
        sales.setClient(1);//*

        sales.setUuid(generateUUID());//*
        sales.setUuidCashShort("UUID");//*
        sales.setUuidClient(ClienteEntity.instance.getUuid());//*
        sales.setUuidTypeDocument(TypeDocumentsEntity.instance.getUuid());//*
        sales.setUuidWayPay(WayPayEntity.instance.getUuid());//*
        sales.setUtilityAmount(sumAmountUtility());
        sales.setUtilityPercentage(percentageSale);

        goToEditSale(sales);

        if (SalesEntity.instance.getId() == -1) {
            insertSale(sales);
        } else {
            sales.setId(idSale);
            updateSale(sales);
        }
    }

    private void insertSale(SalesEntity sales) {
        compositeDisposable.add(salesViewEntity.inserSales(sales)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (SalesEntity.instance.getId() != -1) {
                        saveDetailSale();
                    } else {
                        Toast.makeText(getApplicationContext(), getString(R.string.ocurrioError), Toast.LENGTH_SHORT).show();
                    }
                })
        );
    }

    private void updateSale(SalesEntity sales) {
        compositeDisposable.add(salesViewEntity.updateSales(sales)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (SalesEntity.instance.getId() != -1) {
                        saveDetailSale();
                    } else {
                        Toast.makeText(getApplicationContext(), getString(R.string.ocurrioError), Toast.LENGTH_SHORT).show();
                    }
                })
        );
    }

    private void goToEditSale(SalesEntity salesEntity) {
        SalesEntity.instance.setSumaTotal(salesEntity.getSumaTotal());
        SalesEntity.instance.setTypeDocumentVta(salesEntity.getTypeDocumentVta());
        SalesEntity.instance.setTotal(salesEntity.getTotal());
        SalesEntity.instance.setDate(salesEntity.getDate());
        SalesEntity.instance.setSalesStatus(salesEntity.getSalesStatus());
        SalesEntity.instance.setNoAticles(salesEntity.getNoAticles());
        SalesEntity.instance.setWayPay(salesEntity.getWayPay());
        SalesEntity.instance.setClient(salesEntity.getClient());
        SalesEntity.instance.setDocumentFolio(salesEntity.getDocumentFolio());
        SalesEntity.instance.setUuidClient(salesEntity.getUuidClient());
        SalesEntity.instance.setUuidTypeDocument(salesEntity.getUuidTypeDocument());
        SalesEntity.instance.setUuidCashShort(salesEntity.getUuidCashShort());
        SalesEntity.instance.setUuidWayPay(salesEntity.getUuidWayPay());
        SalesEntity.instance.setStatus(salesEntity.getStatus());
        SalesEntity.instance.setCashShort(salesEntity.getCashShort());
        SalesEntity.instance.setUtilityPercentage(salesEntity.getUtilityPercentage());
        SalesEntity.instance.setUtilityAmount(salesEntity.getUtilityAmount());
    }

    @SuppressWarnings("unchecked")
    public void searchSaleIncomplete() {
        compositeDisposable.add(salesViewEntity.getFilterSaleIncomplete()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<SalesEntity>>) saleListSearch -> {
                            salesEntityListPointSale = (ArrayList<SalesEntity>) saleListSearch;
                            countIncompleteSale = 0;
                            for (int i = 0; i < salesEntityListPointSale.size(); i++) {
                                countIncompleteSale = countIncompleteSale + 1;
                            }
                            tvContainer.setText(String.valueOf(countIncompleteSale));
                            if (!salesEntityListPointSale.isEmpty()) {
                                getDetailSaleIncomplete();
                            }
                        }, throwable -> {

                        }
                ));
    }
    //endregion

    //region BINNACLE SALE DETAIL
    private void searchBitacora() {
        compositeDisposable.add(bitacoraViewEntity.getFilterBitacora()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<BitacoraEntity>>) bitacoraListSearch -> bitacoraListPointSale = (ArrayList<BitacoraEntity>) bitacoraListSearch, throwable -> {
                            Toast.makeText(getApplicationContext(), getString(R.string.errorConsulta), Toast.LENGTH_LONG).show();
                            Log.e(getString(R.string.errorSQLITE), "");
                        }
                )
        );
    }

    private void clearTableBinnacleDetalle() {
        String t = "DetalleVenta";
        String tableName;
        for (int i = 0; i < bitacoraListPointSale.size(); i++) {
            tableName = bitacoraListPointSale.get(i).getTable();
            if (t.equals(tableName)) {
                idTabla = bitacoraListPointSale.get(i).getId();
            }
        }
        if (idTabla == null) {
            BitacoraEntity.instance.clear();
        }
    }

    private void saveBinnacleDetalle() {
        try {
            BitacoraEntity bitacoraEntity = new BitacoraEntity();
            clearTableBinnacleDetalle();
            java.util.Date utilDate = new java.util.Date();

            Calendar cal = Calendar.getInstance(); // locale-specific
            cal.setTime(utilDate);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            long time = cal.getTimeInMillis();

            java.sql.Timestamp sqlTimestamp = new Timestamp(time);
            bitacoraEntity.setDate(String.valueOf(sqlTimestamp));
            bitacoraEntity.setTable("DetalleVenta");
            bitacoraEntity.setIdTable(SalesDetailEntity.instance.getId());

            if (BitacoraEntity.instance.getId() == -1) {
                insertBinnacleDetalle(bitacoraEntity);
            } else {
                bitacoraEntity.setId(BitacoraEntity.instance.getId());
                updateBinnacleDetalle(bitacoraEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertBinnacleDetalle(BitacoraEntity bitacoraEntity) {
        compositeDisposable.add(bitacoraViewEntity.insertBitacora(bitacoraEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                })
        );
    }

    private void updateBinnacleDetalle(BitacoraEntity bitacoraEntity) {
        compositeDisposable.add(bitacoraViewEntity.updateBitacora(bitacoraEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                })
        );
    }
    //endregion

    //region SALE DETAIL
    private void saveDetailSale() {
        clearTableBinnacleDetalle();
        for (int i = 0; i < productSalesList.size(); i++) {
            Double amountUnitUtility = productSalesList.get(i).getProductAmountPercentage();
            Double utilityAmount = productSalesList.get(i).getProductAmountPercentage() * productSalesList.get(i).getProductQuantity();
            Double percentage = productSalesList.get(i).getProductPercentage();
            SalesDetailEntity salesDetail = new SalesDetailEntity();
            salesDetail.setProduct(productSalesList.get(i).getProductSaleId());
            salesDetail.setQuantity(productSalesList.get(i).getProductQuantity().doubleValue());
            salesDetail.setSale(SalesEntity.instance.getId());
            salesDetail.setSubtotal(productSalesList.get(i).getProductSaleCostQuantity());
            salesDetail.setTotal(productSalesList.get(i).getProductSaleCostQuantity());
            salesDetail.setUnitPrice(productSalesList.get(i).getProductSaleCost());
            salesDetail.setDate(getDate());
            salesDetail.setUuid(generateUUID());
            salesDetail.setUuidSale(SalesEntity.instance.getUuid());
            salesDetail.setUuidProduct(productSalesList.get(i).getProductUUID());
            salesDetail.setProductCost(productSalesList.get(i).getProductCost());
            salesDetail.setUtilityUnitAmount(amountUnitUtility);
            salesDetail.setPercentage(percentage);
            salesDetail.setUtilityAmount(utilityAmount);
            if (!saleDetail) {
                insertDetailSale(salesDetail);
            } else {
                salesDetail.setId(productSalesList.get(i).getProductIdSaleDetail());
                updateSaleDetail(salesDetail);
            }
        }
    }

    private void insertDetailSale(SalesDetailEntity salesDetail) {
        compositeDisposable.add(salesDetailViewEntity.inserSalesDetail(salesDetail)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> saveBinnacleDetalle())
        );
    }

    private void updateSaleDetail(SalesDetailEntity salesDetail) {
        compositeDisposable.add(salesDetailViewEntity.updateSales(salesDetail)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> saveBinnacleDetalle())
        );
    }

    public void onClickCard(View v) {
        lootieAnimationView.playAnimation();
        if (productList.get(rvProductCatalog.getPositionForView(v)).getGranel() == 1) {
            idProductDialogGranel = productList.get(rvProductCatalog.getPositionForView(v)).getIdProduct();
            granelDialog = productList.get(rvProductCatalog.getPositionForView(v)).getGranel();
            if (productList.get(rvProductCatalog.getPositionForView(v)).getPrice() != null) {
                costDialogGranel = productList.get(rvProductCatalog.getPositionForView(v)).getPrice();
            } else {
                costDialogGranel = productList.get(rvProductCatalog.getPositionForView(v)).getCost();
            }
            codigoDialogGranel = productList.get(rvProductCatalog.getPositionForView(v)).getCode();
            descriptionDialogGranel = productList.get(rvProductCatalog.getPositionForView(v)).getDescription();
            quantityDialogGranel = 1.0;
            new DialogGranelProduct(context, PointOfSaleView.this, codigoDialogGranel, descriptionDialogGranel, costDialogGranel, quantityDialogGranel);
            addItem(v);
        } else {
            addItem(v);
        }
    }

    @SuppressWarnings("unchecked")
    private void searchDetailSale() {
        compositeDisposable.add(salesDetailViewEntity.getFilterSaleDetail(idSale)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<SalesDetailProductPojo>>) saleListSearch -> {
                            detailProductList = (ArrayList<SalesDetailProductPojo>) saleListSearch;
                            if (detailProductList.size() > 1) {
                                getDataSaleDetail();
                            }
                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), getString(R.string.errorConsulta), Toast.LENGTH_SHORT).show();
                            Log.e(getString(R.string.errorSQLITE), "");
                        }
                ));
    }

    private void getDataSaleDetail() {
        if (saleDetail) {
            if (productSalesList.size() < 1) {
                productSalesList.clear();
            }
            Double percentageSaleDetail, amountSaleDetail;
            if (productSalesList.size() < 1) {
                for (int j = 0; j < detailProductList.size(); j++) {
                    int idProduct = Integer.valueOf(detailProductList.get(j).getIdProduct());
                    Double unitPrice = Double.valueOf(detailProductList.get(j).getUnitPrice());
                    int quantity = Integer.valueOf(detailProductList.get(j).getQuantity());
                    String description = detailProductList.get(j).getProductDescription();
                    String code = detailProductList.get(j).getCode();
                    String saleUnit = detailProductList.get(j).getSaleUnit();
                    Integer idSaleDetail = Integer.valueOf(detailProductList.get(j).getIdSaleDetail());

                    Double subtotal = Double.parseDouble(detailProductList.get(j).getSubtotal());
                    int granel = Integer.valueOf(detailProductList.get(j).getGranel());
                    String uuid = detailProductList.get(j).getUuid();
                    Double cost = Double.parseDouble(detailProductList.get(j).getCost());
                    percentageSaleDetail = Double.parseDouble(detailProductList.get(j).getPercentage());
                    amountSaleDetail = Double.parseDouble(detailProductList.get(j).getAmount());
                    productSalesList.add(new ProductSale(idProduct, description, unitPrice, code, quantity, subtotal, granel, saleUnit, uuid, percentageSaleDetail, amountSaleDetail, cost, idSaleDetail));
                    updateSubtotal();
                    checkItemsList();
                }
            }
        }
    }

    private void getDetailSaleIncomplete() {
        Bundle data = this.getIntent().getExtras();
        SalesEntity.instance.setId(data.getInt("id"));
        SalesEntity.instance.setClient(data.getInt("idClient"));
        SalesEntity.instance.setWayPay(data.getInt("idWayPay"));
        SalesEntity.instance.setNoAticles(data.getInt("noArticles"));
        SalesEntity.instance.setSalesStatus(data.getString("salesStatus"));
        SalesEntity.instance.setDate(data.getString("date"));
        SalesEntity.instance.setTotal(data.getDouble("total"));
        SalesEntity.instance.setTypeDocumentVta(data.getInt("typeDocument"));
        SalesEntity.instance.setSumaTotal(data.getDouble("sumTotal"));
        SalesEntity.instance.setStatus(data.getInt("status"));
        idSale = SalesEntity.instance.getId();
        saleDetail = data.getBoolean("saleDetail");
        typeDocument = data.getInt("typeDocument");

        salesDetailViewEntityFactory = Injection.providerSaleDetailViewModelFactory(getApplicationContext());
        salesDetailViewEntity = ViewModelProviders.of(this, salesDetailViewEntityFactory).get(SalesDetailViewEntity.class);
        searchDetailSale();
    }
    //endregion

    //region PRODUCT
    private void searchProduct(String description) {
        if (description == null) {
            return;
        }

        if (productViewEntity == null) {
            productViewEntity = ViewModelProviders.of(this, productFactory).get(ProductViewEntity.class);
        }

        compositeDisposable.add(productViewEntity.getFilterProductsPrice(description)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<ProductPricePojo>>) productListSearch -> {
                            search = (ArrayList<ProductPricePojo>) productListSearch;
                            Double percentageSearchProduct, amountSearchProduct;
                            for (int o = 0; o < productListSearch.size(); o++) {
                                if (search.get(o).getPercentage() == null) {
                                    percentageSearchProduct = 0.0;
                                    amountSearchProduct = 0.0;
                                } else {
                                    percentageSearchProduct = search.get(o).getPercentage();
                                    amountSearchProduct = search.get(o).getUtility();
                                }
                                search2.add(new ProductPriceCopyPojo(search.get(o).getIdProduct(), search.get(o).getCode(), search.get(o).getAlternateCode(), search.get(o).getDescription(), search.get(o).getMinimumn(), search.get(o).getMaximmn(), search.get(o).getReorderPoint(), search.get(o).getMeasuereUnit(), search.get(o).getUnitMeasurePurchase(), search.get(o).getFactor(), search.get(o).getService(), search.get(o).getGranel(), search.get(o).getDiconsa(), search.get(o).getIdCategory(), search.get(o).getStatus(), search.get(o).getRowId(), search.get(o).getCost(), search.get(o).getCostUC(), search.get(o).getDateUC(), search.get(o).getLevel(), search.get(o).getLevel2(), search.get(o).getPrice(), search.get(o).getPriceM(), search.get(o).getQuantity(), search.get(o).getProduct(), search.get(o).getMeasuereUnit(), percentageSearchProduct, amountSearchProduct));
                            }
                            search2.size();
                            productList = (ArrayList<ProductPricePojo>) productListSearch;
                            searchBasePrice();

                            if (productList.isEmpty()) {
                                Toast.makeText(getApplicationContext(), "No hay productos", Toast.LENGTH_SHORT).show();
                            }

                            gridProductAdapter = new GridProductAdapter(productList, getApplicationContext());
                            // gridProductAdapter.setOnItemClickListener(onClick);

                            rvProductCatalog.setAdapter(gridProductAdapter);

                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), "Ocurrio un error al consultar", Toast.LENGTH_SHORT).show();
                            Log.e("PV SEGALMEX error en:", "");
                        }
                ));
    }
    //endregion

    //region OPERATIONS
    //Escaner HandHeld
    private void ScanSetting() {
        // 0 : fast; 1 : slow; 2 : broadcast
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (Settings.System.canWrite(this)) {
                String version = android.os.Build.VERSION.RELEASE;
                if (version.equals("4.2.2")) {
                    scanmode = SysBarcodeUtil.getBarcodeSendMode(PointOfSaleView.this);
                    bleft = SysBarcodeUtil.getLeftSwitchState(PointOfSaleView.this);
                    bright = SysBarcodeUtil.getRightSwitchState(PointOfSaleView.this);
                    if (!bleft) {
                        SysBarcodeUtil.setLeftSwitchState(PointOfSaleView.this, true);
                    }
                    if (!bright) {
                        SysBarcodeUtil.setRightSwitchState(PointOfSaleView.this, true);
                    }
                    if (scanmode != 2) {
                        SysBarcodeUtil.setBarcodeSendMode(PointOfSaleView.this, 2);
                    }
                } else {
                    scanmode = ScanHelper.getBarcodeReceiveMode(PointOfSaleView.this);
                    bleft = ScanHelper.getScanSwitchLeft(PointOfSaleView.this);
                    bright = ScanHelper.getScanSwitchRight(PointOfSaleView.this);
                    bsound = ScanHelper.getScanSound(PointOfSaleView.this);
                    if (!bsound) {
                        ScanHelper.setScanSound(PointOfSaleView.this, true);
                    }
                    if (!bleft) {
                        ScanHelper.setScanSwitchLeft(PointOfSaleView.this, true);
                    }
                    if (!bright) {
                        ScanHelper.setScanSwitchRight(PointOfSaleView.this, true);
                    }
                    if (scanmode != 2) {
                        ScanHelper.setBarcodeReceiveMode(PointOfSaleView.this, 2);
                    }
                }
            }
        }
    }

    private void updateSubtotal() {
        nProducts = 0;
        subtotal = 0.0;
        double costoProducto = 0.0;
        for (int i = 0; i < productSalesList.size(); i++) {
            nProducts = nProducts + productSalesList.get(i).getProductQuantity();
            if (price == null) {
                costoProducto = productSalesList.get(i).getProductSaleCostQuantity();
                subtotal = subtotal + costoProducto;
            } else {
                costoProducto = price;
                subtotal = subtotal + costoProducto;
                price = null;
            }
            if (productSalesList.get(i).getProductQuantity() == 0) {
                productSalesList.remove(productSalesList.get(i));
                checkItemsList();
            }
        }

        tvTotal.setText(String.valueOf(String.format("%.2f", subtotal)));
        tvProductSaleTotal.setText(String.valueOf(String.format("%.2f", subtotal)));
        rvProductsSale.setAdapter(productSaleAdapter);
        if (nProducts < 2) {
            tvNproducts.setText(nProducts + " Item");
            tvNproductsHeader.setText(nProducts + " Item");
        } else {
            tvNproducts.setText(nProducts + " Items");
            tvNproductsHeader.setText(nProducts + " Items");
        }
    }

    private void calculatedPrice(View v) {
        for (int i = 0; i < productSalesList.size(); i++) {
            String producto;
            producto = productSalesList.get(i).getProductSaleCode();

            productotabla = productList.get(rvProductCatalog.getPositionForView(v)).getCode();
            //  subtotal = 10+productSalesList.get(i).getProductSaleCostQuantity();
            // index = i;
            double cantidadVenta = 0.0;
            if (producto.equals(productotabla)) {
                bandera = true;
                quantityProduct = productSalesList.get(i).getProductQuantity() + 1;
                for (int j = 0; j < search2.size(); j++) {
                    if (productSalesList.get(i).getProductSaleId() == search2.get(j).getIdProduct())
                        if (search2.get(j).getLevel() != null) {
                            if (search2.get(j).getLevel() == 1)
                                cantidadVenta = (double) productSalesList.get(i).getProductQuantity();

                            mayoreo = true;
                            if (search2.get(j).getQuantity() == (double) quantityProduct) {
                                quantity = search2.get(j).getQuantity();
                                Toast.makeText(getApplicationContext(), "Se aplico precio de mayoreo", Toast.LENGTH_SHORT).show();
                                priceM = search2.get(j).getPrice();
                                percentageM = search2.get(j).getPercentage();
                                amountM = search2.get(j).getAmountUtility();
                                productSalesList.get(i).setProductSaleCost(priceM);
                                productSalesList.get(i).setProductAmountPercentage(amountM);
                                productSalesList.get(i).setProductPercentage(percentageM);
                            } else if (search2.get(j).getQuantity() > (double) quantityProduct) ;
                            {
                                productList.get(rvProductCatalog.getPositionForView(v)).getCost();
                            }
                        }
                }
                productSalesList.get(i).setProductQuantity(quantityProduct);
                productSalesList.get(i).setProductSaleCostQuantity((productSalesList.get(i).getProductQuantity() * productSalesList.get(i).getProductSaleCost()));

                //  subtotal = subtotal + productSalesList.get(i).getProductSaleCost();
                checkItemsList();
                break;
            } else {
                checkItemsList();
                //searchProductPrice();
                bandera = false;
            }
        }
    }

    private void addItemGranel(View v) {
        //searchProductPrice(idProdcuto);
        rvProductsSale.setAdapter(productSaleAdapter);
        if (idProductDialogGranel == null) {
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
        } else {
            calculatedPrice(v);
        }
        // subtotal2 = subtotal;

        if (!bandera) {
            Double percentageAddItemGranel, amountAddItemGranel;

            cost = (productList.get(rvProductCatalog.getPositionForView(v)).getCost());
            price = productList.get(rvProductCatalog.getPositionForView(v)).getPrice();
            String unitMeasurement = productList.get(rvProductCatalog.getPositionForView(v)).getUnitMeasurePurchase();
            if (productList.get(rvProductCatalog.getPositionForView(v)).getPercentage() == null) {
                percentageAddItemGranel = 0.0;
                amountAddItemGranel = 0.0;
            } else {
                percentageAddItemGranel = productList.get(rvProductCatalog.getPositionForView(v)).getPercentage();
                amountAddItemGranel = productList.get(rvProductCatalog.getPositionForView(v)).getUtility();
            }

            if (price == null) {
                productSalesList.add(new ProductSale(productList.get(rvProductCatalog.getPositionForView(v)).getIdProduct(), productList.get(rvProductCatalog.getPositionForView(v)).getDescription(), productList.get(rvProductCatalog.getPositionForView(v)).getCost(), productList.get(rvProductCatalog.getPositionForView(v)).getCode(), 1, (productList.get(rvProductCatalog.getPositionForView(v)).getCost() * 1), productList.get(rvProductCatalog.getPositionForView(v)).getGranel(), productList.get(rvProductCatalog.getPositionForView(v)).getUnitMeasurePurchase(), productList.get(rvProductCatalog.getPositionForView(v)).getUuid(), percentageAddItemGranel, amountAddItemGranel, cost, -1));
            }

            //subtotal = subtotal + productList.get(rvProductCatalog.getPositionForView(v)).getCost();

            else {
                productSalesList.add(new ProductSale(productList.get(rvProductCatalog.getPositionForView(v)).getIdProduct(), productList.get(rvProductCatalog.getPositionForView(v)).getDescription(), productList.get(rvProductCatalog.getPositionForView(v)).getPrice(), productList.get(rvProductCatalog.getPositionForView(v)).getCode(), 1, (productList.get(rvProductCatalog.getPositionForView(v)).getPrice() * 1), productList.get(rvProductCatalog.getPositionForView(v)).getGranel(), productList.get(rvProductCatalog.getPositionForView(v)).getUnitMeasurePurchase(), productList.get(rvProductCatalog.getPositionForView(v)).getUuid(), percentageAddItemGranel, amountAddItemGranel, cost, -1));
            }
        }
        updateSubtotal();
        // calcularTotalVenta();
        // subtotal = subtotal + productList.get(rvProductCatalog.getPositionForView(v)).getCost();
        checkItemsList();
    }

    private void addItem(View v) {
        Integer idProdcuto = productList.get(rvProductCatalog.getPositionForView(v)).getIdProduct();
        //searchProductPrice(idProdcuto);
        rvProductsSale.setAdapter(productSaleAdapter);
        if (idProdcuto == null) {
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
        } else {
            calculatedPrice(v);
        }
        // subtotal2 = subtotal;

        if (!bandera) {
            Double percentageAddItem, amountAddItem;
            cost = (productList.get(rvProductCatalog.getPositionForView(v)).getCost());
            price = productList.get(rvProductCatalog.getPositionForView(v)).getPrice();
            if (productList.get(rvProductCatalog.getPositionForView(v)).getPercentage() == null) {
                percentageAddItem = 0.0;
                amountAddItem = 0.0;
            } else {
                percentageAddItem = productList.get(rvProductCatalog.getPositionForView(v)).getPercentage();
                amountAddItem = productList.get(rvProductCatalog.getPositionForView(v)).getUtility();
            }

            if (price == null) {
                productSalesList.add(new ProductSale(productList.get(rvProductCatalog.getPositionForView(v)).getIdProduct(), productList.get(rvProductCatalog.getPositionForView(v)).getDescription(), productList.get(rvProductCatalog.getPositionForView(v)).getCost(), productList.get(rvProductCatalog.getPositionForView(v)).getCode(), 1, (productList.get(rvProductCatalog.getPositionForView(v)).getCost() * 1), productList.get(rvProductCatalog.getPositionForView(v)).getGranel(), productList.get(rvProductCatalog.getPositionForView(v)).getUnitMeasurePurchase(), productList.get(rvProductCatalog.getPositionForView(v)).getUuid(), percentageAddItem, amountAddItem, cost, -1));
            }

            //subtotal = subtotal + productList.get(rvProductCatalog.getPositionForView(v)).getCost();

            else {
                productSalesList.add(new ProductSale(productList.get(rvProductCatalog.getPositionForView(v)).getIdProduct(), productList.get(rvProductCatalog.getPositionForView(v)).getDescription(), productList.get(rvProductCatalog.getPositionForView(v)).getPrice(), productList.get(rvProductCatalog.getPositionForView(v)).getCode(), 1, (productList.get(rvProductCatalog.getPositionForView(v)).getPrice() * 1), productList.get(rvProductCatalog.getPositionForView(v)).getGranel(), productList.get(rvProductCatalog.getPositionForView(v)).getUnitMeasurePurchase(), productList.get(rvProductCatalog.getPositionForView(v)).getUuid(), percentageAddItem, amountAddItem, cost, -1));
            }
        }
        updateSubtotal();
        // calcularTotalVenta();
        // subtotal = subtotal + productList.get(rvProductCatalog.getPositionForView(v)).getCost();
        checkItemsList();
        //rvProductsSale.setAdapter(productSaleAdapter);
    }
    //tvProductSaleTotal.setText(String.valueOf(subtotal2));

    private void addItem() {
        lootieAnimationView.playAnimation();
        for (int i = 0; i < productSalesList.size(); i++) {
            String producto;
            producto = productSalesList.get(i).getProductSaleCode();
            codeBar.trim();
            //compara si el codigo de barras existe en algun item de la lista
            if (codeBar == producto || codeBar.equals(producto)) {
                exsist = true;
                //Agrega en cantidad y actualiza precios
                quantityProduct = productSalesList.get(i).getProductQuantity() + 1;
                productSalesList.get(i).setProductQuantity(quantityProduct);
                productSalesList.get(i).setProductSaleCostQuantity(productSalesList.get(i).getProductQuantity() * productSalesList.get(i).getProductSaleCost());
                mProductCode.getText().clear();
                break;
            } else {
                exsist = false;
            }
        }

        if (!exsist) {
            //Busca en la lista de productos, obtiene datos y agrega el nuevo Productos
            for (int o = 0; o < productList.size(); o++) {
                String codeProduct;
                Double percentageAddItem, amountAddItem, costAddItem;
                codeProduct = productList.get(o).getCode();
                costAddItem = productList.get(o).getCost();

                if (productList.get(o).getPercentage() == null) {
                    percentageAddItem = 0.0;
                    amountAddItem = 0.0;
                } else if (percentageM != null) {
                    percentageAddItem = percentageM;
                    amountAddItem = amountM;
                } else {
                    percentageAddItem = productList.get(o).getPercentage();
                    amountAddItem = productList.get(o).getUtility();
                }
                if (codeBar.equals(codeProduct)) {
                    productSalesList.add(new ProductSale(productList.get(o).getIdProduct(), productList.get(o).getDescription(), productList.get(o).getCost(), productList.get(o).getCode(), 1, ((productList.get(o).getCost()) * 1), productList.get(o).getGranel(), productList.get(o).getUnitMeasurePurchase(), productList.get(o).getUuid(), percentageAddItem, amountAddItem, costAddItem, -1));
                    mProductCode.getText().clear();
                }
            }
        }
        updateSubtotal();
        // rvProductsSale.setAdapter(productSaleAdapter);
        checkItemsList();
        //rvProductsSale.setAdapter(productSaleAdapter);
    }

    private void searchBasePrice() {
        Integer idProduct;
        Integer level;
        for (int i = 0; i < productList.size(); i++) {
            idProduct = productList.get(i).getIdProduct();
            level = productList.get(i).getLevel();
            for (int o = 0; o < search.size(); o++) {
                if (idProduct.equals(search.get(o).getIdProduct()) && level != search.get(o).getLevel()) {
                    productList.remove(o);
                    search2.size();
                }
            }
        }
    }

    private void saleDrawer() {
        productSalesList = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvProductsSale.setLayoutManager(linearLayoutManager);
        productSaleAdapter = new RvProductSaleAdapter(getApplicationContext(), productSalesList);
        productSaleAdapter.setOnClickListener(onClickProductSaleDetail);
        // productSaleAdapter.setOnLongClickListener(onLongClickListener);

        swipe = new SwipeControllerRV(new SwipeControllerActions() {
            @Override
            public void onRightClicked(int position) {
                rvProductsSale.setAdapter(productSaleAdapter);
                productSalesList.remove(productSalesList.get(position));
                checkItemsList2();
                updateSubtotal();
                //updateList();
            }
        });
        touchHelper = new ItemTouchHelper(swipe);
        touchHelper.attachToRecyclerView(rvProductsSale);
        rvProductsSale.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                swipe.onDraw(c);
            }
        });

        rvProductsSale.setAdapter(productSaleAdapter);
        productSaleAdapter.notifyDataSetChanged();
        //updateList();
        updateSubtotal();
    }

    private View.OnClickListener onClickProductSaleDetail = v -> {
        if (productSalesList.get(rvProductsSale.getChildAdapterPosition(v)).getProductSaleGranel() == 1) {
            idProductDialogGranel = productSalesList.get(rvProductsSale.getChildAdapterPosition(v)).getProductSaleId();
            costDialog = productSalesList.get(rvProductsSale.getChildAdapterPosition(v)).getProductSaleCost();
            codigoDialog = productSalesList.get(rvProductsSale.getChildAdapterPosition(v)).getProductSaleCode();
            descriptionDialog = productSalesList.get(rvProductsSale.getChildAdapterPosition(v)).getProductSaleDescription();
            getQuantityDialogGranel = 1.0;
            granelDialog = productSalesList.get(rvProductsSale.getChildAdapterPosition(v)).getProductSaleGranel();
            new DialogGranelProduct(context, PointOfSaleView.this, codigoDialog, descriptionDialog, costDialog, getQuantityDialogGranel);
        } else {
            idProductDialogGranel = productSalesList.get(rvProductsSale.getChildAdapterPosition(v)).getProductSaleId();
            granelDialog = productSalesList.get(rvProductsSale.getChildAdapterPosition(v)).getProductSaleGranel();
            costDialog = productSalesList.get(rvProductsSale.getChildAdapterPosition(v)).getProductSaleCost();
            codigoDialog = productSalesList.get(rvProductsSale.getChildAdapterPosition(v)).getProductSaleCode();
            descriptionDialog = productSalesList.get(rvProductsSale.getChildAdapterPosition(v)).getProductSaleDescription();
            quantityDialog = productSalesList.get(rvProductsSale.getChildAdapterPosition(v)).getProductQuantity();
            new DialogDetailProductSale(context, PointOfSaleView.this, codigoDialog, descriptionDialog, costDialog, quantityDialog);
        }
    };

    private void checkItemsList() {
        if (productSalesList.size() < 1) {

            rlPay.setEnabled(false);
            rlPay.setBackgroundColor(getResources().getColor(R.color.light_gray));
            tvPay.setText("No items");
            productSalesList.clear();

        } else {
            rlPay.setEnabled(true);
            rlPay.setBackground(getResources().getDrawable(R.drawable.degradado_pagar
            ));
            tvPay.setText(getString(R.string.btnPay));
        }
    }

    private void checkItemsList2() {
        if (productSalesList.size() < 1) {
            recreate();
        }
    }
    //endregion
    //endregion

    //region PUBLIC METHODS
    @Override
    public void resultQuantity(Integer quant, String code) {
        if (quant == 0) {
            AlertDialog alertDialog = new AlertDialog.Builder(PointOfSaleView.this).create();
            alertDialog.setMessage("Cantidad Minima 1");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", (dialog, which) -> dialog.dismiss());
            alertDialog.show();
            return;
        }

        for (int i = 0; i < productSalesList.size(); i++) {
            quantityProduct = 0;
            quantityProduct = quant;
            codigoRec = code;
            String producto;
            producto = productSalesList.get(i).getProductSaleCode();
            for (int j = 0; j < productList.size(); j++) {
                productotabla = productList.get(j).getCode();
                if (producto.equals(productotabla)) {
                    bandera = true;
                    productSalesList.get(i).getProductSaleCode();
                    if (productSalesList.get(i).getProductSaleCode() == codigoRec) {
                        bandera = true;
                        for (int h = 0; h < search2.size(); h++) {
                            if (productSalesList.get(i).getProductSaleId() == search2.get(h).getIdProduct())
                                if (search2.get(h).getLevel() != null) {
                                    if (search2.get(h).getLevel() == 1)
                                        mayoreo = true;
                                    if ((double) quantityProduct >= search2.get(h).getQuantity()) {
                                        quantity = search2.get(h).getQuantity();
                                        Toast.makeText(getApplicationContext(), "Se aplico precio de mayoreo", Toast.LENGTH_SHORT).show();
                                        priceM = search2.get(h).getPrice();
                                        percentageM = search2.get(h).getPercentage();
                                        amountM = search2.get(h).getAmountUtility();
                                        productSalesList.get(i).setProductSaleCost(priceM);
                                        productSalesList.get(i).setProductPercentage(percentageM);
                                        productSalesList.get(i).setProductAmountPercentage(amountM);
                                        productSalesList.get(i).setProductSaleCostQuantity((quantityProduct * productSalesList.get(i).getProductSaleCost()));
                                    } else {
                                        productSalesList.get(i).setProductSaleCostQuantity((quantityProduct * productSalesList.get(i).getProductSaleCost()));
                                    }
                                }
                        }
                        productSalesList.get(i).setProductQuantity(quantityProduct);
                        productSalesList.get(i).setProductSaleCostQuantity((quantityProduct * productSalesList.get(i).getProductSaleCost()));
                    }
                }
            }
        }
        updateSubtotal();
    }

    @Override
    public void resultQuantity(Double quant, String code) {
        if (quant == 0) {
            AlertDialog alertDialog = new AlertDialog.Builder(PointOfSaleView.this).create();
            alertDialog.setMessage("Cantidad Minima 1");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", (dialog, which) -> dialog.dismiss());
            alertDialog.show();
            return;
        }
        if (granelDialog == 1) {
            for (int i = 0; i < productSalesList.size(); i++) {
                quantityProductGranel = quant;
                codigoRec = code;
                productotabla = productList.get(i).getCode();
                if (idProductDialogGranel == productSalesList.get(i).getProductSaleId()) {
                    for (int h = 0; h < search2.size(); h++) {
                        if (idProductDialogGranel == search2.get(h).getIdProduct()) {
                            if (search2.get(h).getLevel() != null) {
                                if (search2.get(h).getLevel() == 1) {
                                    if (quant >= search2.get(h).getQuantity()) {
                                        quantity = search2.get(h).getQuantity();
                                        Toast.makeText(getApplicationContext(), "Se aplico precio de mayoreo", Toast.LENGTH_SHORT).show();
                                        priceM = search2.get(h).getPrice();
                                        amountM = search2.get(h).getAmountUtility();
                                        percentageM = search2.get(h).getPercentage();
                                        productSalesList.get(i).setProductSaleCostQuantity(quantity * priceM);
                                        productSalesList.get(i).setProductAmountPercentage(amountM);
                                        productSalesList.get(i).setProductPercentage(percentageM);
                                    } else {
                                        productSalesList.get(i).setProductSaleCostQuantity(quantityProductGranel * costDialogGranel);
                                    }
                                }
                                productSalesList.get(i).setProductQuantity(1);
                            }
                            productSalesList.get(i).setProductSaleCostQuantity(quantityProductGranel * costDialogGranel);
                            productSalesList.get(i).setProductQuantity(1);
                            updateSubtotal();
                        }
                    }
                }
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        lootieAnimationView.playAnimation();
        if (productList.get(rvProductCatalog.getPositionForView(v)).getGranel() == 1) {
            idProductDialogGranel = productList.get(rvProductCatalog.getPositionForView(v)).getIdProduct();
            granelDialog = productList.get(rvProductCatalog.getPositionForView(v)).getGranel();
            if (productList.get(rvProductCatalog.getPositionForView(v)).getPrice() != null) {
                costDialogGranel = productList.get(rvProductCatalog.getPositionForView(v)).getPrice();
            } else {
                costDialogGranel = productList.get(rvProductCatalog.getPositionForView(v)).getCost();
            }
            codigoDialogGranel = productList.get(rvProductCatalog.getPositionForView(v)).getCode();
            descriptionDialogGranel = productList.get(rvProductCatalog.getPositionForView(v)).getDescription();
            quantityDialogGranel = 1.0;
            new DialogGranelProduct(context, PointOfSaleView.this, codigoDialogGranel, descriptionDialogGranel, costDialogGranel, quantityDialogGranel);
            addItem(v);
        } else {
            addItem(v);
        }
    }

    @Override
    public void onBackPressed() {
    }
    //endregion
}