package com.example.administrador.pvsegalmex.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.api.ApiService;
import com.example.administrador.pvsegalmex.api.BitacoraApi;
import com.example.administrador.pvsegalmex.api.CashShortApi;
import com.example.administrador.pvsegalmex.api.CashShortDetailApi;
import com.example.administrador.pvsegalmex.api.CategoryApi;
import com.example.administrador.pvsegalmex.api.ClientApi;
import com.example.administrador.pvsegalmex.api.CollectionPaymentApi;
import com.example.administrador.pvsegalmex.api.DepartmentApi;
import com.example.administrador.pvsegalmex.api.ExistApi;
import com.example.administrador.pvsegalmex.api.IncomeApi;
import com.example.administrador.pvsegalmex.api.JSONBitacora;
import com.example.administrador.pvsegalmex.api.JSONCategory;
import com.example.administrador.pvsegalmex.api.JSONDepartment;
import com.example.administrador.pvsegalmex.api.JSONProduct;
import com.example.administrador.pvsegalmex.api.JSONUnitMeasurement;
import com.example.administrador.pvsegalmex.api.JSONWayPay;
import com.example.administrador.pvsegalmex.api.KardexApi;
import com.example.administrador.pvsegalmex.api.KardexDetailApi;
import com.example.administrador.pvsegalmex.api.LoginInfo;
import com.example.administrador.pvsegalmex.api.ProductApi;
import com.example.administrador.pvsegalmex.api.ProviderApi;
import com.example.administrador.pvsegalmex.api.ReceiptMerchandiseApi;
import com.example.administrador.pvsegalmex.api.ReceiptMerchandiseDetailApi;
import com.example.administrador.pvsegalmex.api.SaleApi;
import com.example.administrador.pvsegalmex.api.SaleDetailApi;
import com.example.administrador.pvsegalmex.api.ServiceProvider;
import com.example.administrador.pvsegalmex.api.UnitMeasurement;
import com.example.administrador.pvsegalmex.api.WayPayApi;
import com.example.administrador.pvsegalmex.api.WithdrawalApi;
import com.example.administrador.pvsegalmex.entity.CashIncomeEntity;
import com.example.administrador.pvsegalmex.entity.CashShortDetailEntity;
import com.example.administrador.pvsegalmex.entity.CashShortEntity;
import com.example.administrador.pvsegalmex.entity.CategoryEntity;
import com.example.administrador.pvsegalmex.entity.ClienteEntity;
import com.example.administrador.pvsegalmex.entity.CollectionOfPaymentEntity;
import com.example.administrador.pvsegalmex.entity.DepartmentEntity;
import com.example.administrador.pvsegalmex.entity.ExistEntity;
import com.example.administrador.pvsegalmex.entity.KardexDetailEntity;
import com.example.administrador.pvsegalmex.entity.KardexEntity;
import com.example.administrador.pvsegalmex.entity.ProductEntity;
import com.example.administrador.pvsegalmex.entity.ProviderEntity;
import com.example.administrador.pvsegalmex.entity.ReceiptOfMerchandiseDetailEntity;
import com.example.administrador.pvsegalmex.entity.ReceiptOfMerchandiseEntity;
import com.example.administrador.pvsegalmex.entity.SalesDetailEntity;
import com.example.administrador.pvsegalmex.entity.SalesEntity;
import com.example.administrador.pvsegalmex.entity.TypeDocumentsEntity;
import com.example.administrador.pvsegalmex.entity.UnitMeasurementEntity;
import com.example.administrador.pvsegalmex.entity.WayPayEntity;
import com.example.administrador.pvsegalmex.entity.WithdrawalEntity;
import com.example.administrador.pvsegalmex.viewEntity.CashIncomeViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.CashShortDetailViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.CashShortViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.CategoryViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.ClienteViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.CollectionOfPaymentViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.DepartmentViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.ExistViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.KardexDetailViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.KardexViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.ProductViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.ProviderViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.ReceiptOfMerchandiseDetailViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.ReceiptOfMerchandiseViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.SalesDetailViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.SalesViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.UnitMeasurementViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.WayPayViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.WithdrawalViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.CashIncomeViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.CashShortDetailViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.CashShortViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.CategoryViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.ClienteViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.CollectionOfPaymentViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.DepartmentViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.ExistViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.KardexDetailViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.KardexViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.ProductViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.ProviderViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.ReceiptOfMerchandiseDetailViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.ReceiptOfMerchandiseViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.SalesDetailViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.SalesViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.UnitMeasurementViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.WayPayViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.WithdrawalViewEntityFactory;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


abstract class MenuView extends BaseView {
    CompositeDisposable compositeDisposable;
    Boolean bandera = false;

    //region API VARS
    ApiService apiService;
    HashMap<String, String> hashMap;

    //region JSON
    Gson gson = new Gson();
    JsonArray jsonArray = new JsonArray();
    JsonObject jsonObject = new JsonObject();
    String object;
    //endregion

    //region API DOWNLOAD
    //region API DEPARTMENT VARS
    Call<JSONDepartment> callDepartment;
    List<DepartmentApi> departmentApiListWS = new ArrayList<>();
    //endregion

    //region API WAY PAY VARS
    Call<JSONWayPay> callWayPay;
    List<WayPayApi> wayPayApiListWS = new ArrayList<>();
    //endregion

    //region API CATEGORY VARS
    List<CategoryApi> categoryApiListWS = new ArrayList<>();
    Call<JSONCategory> callCategory;
    //endregion

    //region API PRODUCT VARS
    List<ProductApi> productApiListWS = new ArrayList<>();
    Call<JSONProduct> callProduct;
    //endregion

    //region API UNIT MEASURE
    Call<JSONUnitMeasurement> callUnitMeasure;
    List<UnitMeasurement> unitMeasurementListWs = new ArrayList<>();
    //endregion
    //endregion

    //region API SYNC
    //region API SALE VARS
    Call<SaleApi> callSale;
    //endregion

    //region API SALE DETAIL VARS
    Call<SaleDetailApi> callSaleDetail;
    //endregion

    //region API EXIST VARS
    Call<ExistApi> callExist;
    //endregion

    //region API COLLECTION PAYMENT VARS
    Call<CollectionPaymentApi> callCollectionPayment;
    //endregion

    //region API RECEIPT VARS
    Call<ReceiptMerchandiseApi> callReceiptMerchandise;
    //endregion

    //region API RECEIPT DETAIL VARS
    Call<ReceiptMerchandiseDetailApi> callReceipMerchandiseDetail;
    //endregion

    //region API RECEIPT INCOME VARS
    Call<IncomeApi> callIncome;
    //endregion

    //region API WITHDRAWAL VARS
    Call<WithdrawalApi> callWithdrawal;
    //endregion

    //region API KARDEX VARS
    Call<KardexApi> callKardex;
    //endregion

    //region API KARDEX DETAIL VARS
    Call<KardexDetailApi> callKardexDetail;
    //endregion

    //region API CASH SHORT VARS
    Call<CashShortApi> callCashShort;
    //endregion

    //region API CASH SHORT DETAIL VARS
    Call<CashShortDetailApi> callCashShortDetail;
    //endregion

    //region API CLIENT VARS
    Call<ClientApi> callClient;
    //endregion

    //region API PROVIDER VARS
    Call<ProviderApi> callProvider;
    //endregion

    //region BITACORA
    Call<JSONBitacora> callBitacora;
    List<BitacoraApi> bitacoraApiListWs = new ArrayList<>();
    //endregion
    //endregion

    //region VARS  DOWNLOAD
    //region PRODUCT VARS
    private ArrayList<ProductEntity> productListMenuView;
    private ProductViewEntityFactory productFactory;
    private ProductViewEntity productViewEntity;
    //endregion

    //region Unit Measurement
    private ArrayList<UnitMeasurementEntity> unitMeasurementListMenuView;
    private UnitMeasurementViewEntity unitMeasurementViewEntity;
    private UnitMeasurementViewEntityFactory unitMeasurementViewEntityFactory;
    //endregion

    //region WAY PAYS VARS
    private ArrayList<WayPayEntity> wayPayListMenuView;
    private ArrayList<WayPayEntity> wayPayListUUID;
    private WayPayViewEntity wayPayViewEntity;
    private WayPayViewEntityFactory wayPayViewEntityFactory;
    //endregion

    //region CATEGORY VARS
    private ArrayList<CategoryEntity> categoryListMenuView;
    private CategoryViewEntity categoryViewEntity;
    private CategoryViewEntityFactory categoryViewEntityFactory;
    //endregion

    //region DEPARTMENT VARS
    private DepartmentViewEntity departmentViewEntity;
    private DepartmentViewEntityFactory departmentViewEntityFactory;
    private ArrayList<DepartmentEntity> departmentListMenuView;
    //endregion
    //endregion

    //region VARS SYNC
    //region CASH SHORT
    private CashShortViewEntity cashShortViewEntity;
    private CashShortViewEntityFactory cashShortViewEntityFactory;
    private ArrayList<CashShortEntity> cashShortList;
    //endregion

    //region CASH SHORT DETAIL
    private CashShortDetailViewEntity cashShortDetailViewEntity;
    private CashShortDetailViewEntityFactory cashShortDetailViewEntityFactory;
    private ArrayList<CashShortDetailEntity> cashShortDetailList;
    //endregion

    //region Sale
    private SalesViewEntity salesViewEntity;
    private SalesViewEntityFactory salesViewEntityFactory;
    private ArrayList<SalesEntity> salesList;//
    //endregion

    //region Sale Detail
    private SalesDetailViewEntity salesDetailViewEntity;
    private SalesDetailViewEntityFactory salesDetailViewEntityFactory;
    private ArrayList<SalesDetailEntity> salesDetailList;//
    //endregion

    //region CollectionOFPayment
    private CollectionOfPaymentViewEntity collectionOfPaymentViewEntity;
    private CollectionOfPaymentViewEntityFactory collectionOfPaymentViewEntityFactory;
    private ArrayList<CollectionOfPaymentEntity> collectionOfPaymentList;//
    //endregion

    //region Exist
    private ExistViewEntity existViewEntity;
    private ExistViewEntityFactory existViewEntityFactory;
    private ArrayList<ExistEntity> existList;//
    //endregion

    //region ReceiptMerchandise
    private ReceiptOfMerchandiseViewEntity receiptOfMerchandiseViewEntity;
    private ReceiptOfMerchandiseViewEntityFactory receiptOfMerchandiseViewEntityFactory;
    private ArrayList<ReceiptOfMerchandiseEntity> receiptOfMerchandiseList;//
    //endregion

    //region ReceiptMerchandiseDetail
    private ReceiptOfMerchandiseDetailViewEntity receiptOfMerchandiseDetailViewEntity;
    private ReceiptOfMerchandiseDetailViewEntityFactory receiptOfMerchandiseDetailViewEntityFactory;
    private ArrayList<ReceiptOfMerchandiseDetailEntity> receiptOfMerchandiseDetailList;//
    //endregion

    //region Income
    private CashIncomeViewEntity cashIncomeViewEntity;
    private CashIncomeViewEntityFactory cashIncomeViewEntityFactory;//
    private ArrayList<CashIncomeEntity> cashIncomeList;
    //endregion

    //region Withdrawal
    private WithdrawalViewEntity withdrawalViewEntity;
    private WithdrawalViewEntityFactory withdrawalViewEntityFactory;//
    private ArrayList<WithdrawalEntity> withdrawalList;
    //endregion

    //region Kardex
    private KardexViewEntity kardexViewEntity;
    private KardexViewEntityFactory kardexViewEntityFactory;//
    private ArrayList<KardexEntity> kardexEntityList;
    //endregion

    //region KardexDetail
    private KardexDetailViewEntity kardexDetailViewEntity;
    private KardexDetailViewEntityFactory kardexDetailViewEntityFactory;//
    private ArrayList<KardexDetailEntity> kardexDetailList;
    //endregion

    //region Client
    private ClienteViewEntity clienteViewEntity;
    private ClienteViewEntityFactory clienteViewEntityFactory;//
    private ArrayList<ClienteEntity> clienteList;
    //endregion

    //region Provider
    private ProviderViewEntity providerViewEntity;
    private ProviderViewEntityFactory providerViewEntityFactory;//
    private ArrayList<ProviderEntity> providerList;
    //endregion
    //endregion

    String lastDaySyncProduct, lastDaySyncCategory, lastDaySyncDepartment, lastDaySyncWayPay, lastDaySyncUnitMeasure;
    //endregion

    //region PUBLIC METHODS
    public String getDate() {
        Date objDate = new Date();
        String strDateFormat = "dd/LL/yyyy KK:mm:ss:SSS";
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
        String date = String.valueOf(objSDF.format(objDate));
        return date;
    }

    public String generateUUID() {
        Date objDate = new Date();
        String strDateFormat = "yyLLddKKmmssSSS";
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);

        String user = String.valueOf(LoginInfo.build(MenuView.this).getUserId());
        String u = "";
        if (user.length() == 1) {
            u = "00000" + user;
        } else if (user.length() == 2) {
            u = "0000" + user;
        } else if (user.length() == 3) {
            u = "000" + user;
        } else if (user.length() == 4) {
            u = "00" + user;
        } else if (user.length() == 5) {
            u = "0" + user;
        } else if (user.length() == 6) {
            u = user;
        }

        String uuid = (u + (String.valueOf(objSDF.format(objDate))));
        return uuid;
    }

    public void drawerMenuOnClick(View drawerButton) {
        drwMenuPrincipal.closeDrawers();
        switch (drawerButton.getId()) {
            case R.id.tvBtnHome:
                if (this instanceof InicioView)
                    return;
                Intent intent = new Intent(getApplicationContext(), InicioView.class);
                startActivity(intent);
                break;
            case R.id.tvBtnClientManage:
                if (this instanceof ClienteView)
                    return;
                startActivity(ClienteView.class);
                break;
            case R.id.tv_btnWayPayManage:
                if (this instanceof WayPayView)
                    return;
                startActivity(WayPayView.class);
                break;
            case R.id.tv_btnDepartamentManage:
                if (this instanceof DepartmentView)
                    return;
                startActivity(DepartmentView.class);
                break;
            case R.id.tv_btnProviderManage:
                if (this instanceof ProviderView)
                    return;
                startActivity(ProviderView.class);
                break;
            case R.id.tv_btnProductManage:
                if (this instanceof ProductView)
                    return;
                startActivity(ProductView.class);
                break;

            case R.id.tv_btnCategoryManage:
                if (this instanceof CategoryView)
                    return;
                startActivity(CategoryView.class);
                break;
            case R.id.tv_point_of_sell:
                if (this instanceof PointOfSaleView)
                    return;
                TypeDocumentsEntity.instance.clear();
                startActivity(PointOfSaleView.class);
                break;
            case R.id.tv_btnCashShortManage:
                if (this instanceof CashShortDetailView) {
                    return;
                }
                startActivity(CashShortDetailView.class);
                break;
            case R.id.tv_btnWithdrawal:
                if (this instanceof WithdrawalView)
                    return;
                startActivity(WithdrawalView.class);
                break;

            case R.id.tv_btnStoreManage:
                if (this instanceof StoreView)
                    return;
                startActivity(StoreView.class);
                break;

            case R.id.tvBtnSalesManage:
                if (this instanceof SaleView)
                    return;
                startActivity(SaleView.class);
                break;

            case R.id.tv_btnIncome:
                if (this instanceof CashIncomeView)
                    return;
                startActivity(CashIncomeView.class);
                break;

            case R.id.tv_btnReceiptMerchandise:
                if (this instanceof ReceiptOfMerchandiseView)
                    return;
                startActivity(ReceiptOfMerchandiseView.class);
                break;

            case R.id.tv_btnStock:
                if (this instanceof ExistView)
                    return;
                startActivity(ExistView.class);
                break;

            case R.id.tv_btnSync:
                getBitacoraActualizaciones();
                //searchCategory();
                //  sendSale();
                //  sendCashIncome();
                //  sendCashShort();
                //  sendCashShortDetail();
                //  sendCollectionOfPayment();
                //  sendExist();
                //  sendKardex();
                //  //sendKardexDetail();
                //  //sendProvider();
                //  sendReceiptMerchandise();
                //  sendReceiptMerchandiseDetail();
                //  sendSaleDetail();
                //  sendWithdrawal();
                break;

            case R.id.tvBtnLogout:
                LoginInfo.build(MenuView.this).clear();
                mainHandler.postDelayed(() -> restartActivity(MainActivity.class), 500);
                break;
        }
    }
    //endregion

    //region PROTECTED METHODS
    protected Handler mainHandler;
    private LayoutInflater inflater;
    private View mainView;
    private int REQUEST_CODE_ADD_PHOTO = 1001;

    protected DrawerLayout drwMenuPrincipal;
    RelativeLayout mainContainer;
    RelativeLayout rlheader;
    TextView txtTitle, tv_usernameViewer;
    ImageView ivBtnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_view);
        initializeViews();

        drwMenuPrincipal = findViewById(R.id.drwMenuPrincipal);
        mainContainer = findViewById(R.id.rl_mainPageContainer);
        txtTitle = findViewById(R.id.tv_titleViewer);
        ivBtnMenu = findViewById(R.id.ivBtnMenu);
        rlheader = findViewById(R.id.rlHeader);
        tv_usernameViewer = findViewById(R.id.tv_usernameViewer);
        mainHandler = new Handler(getMainLooper());
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mainView = inflater.inflate(getPageLayoutId(), null);

        mainContainer.addView(mainView);
        txtTitle.setText(getScreenTitle());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setExitTransition(null);
            getWindow().setEnterTransition(null);
        }
        ivBtnMenu.setOnClickListener(v ->
        {
            drwMenuPrincipal.openDrawer(Gravity.START);
            hideKeyBoaard();

        });
        mainContainer.setOnClickListener(v -> hideKeyBoaard());

        rlheader.setOnClickListener(v -> hideKeyBoaard());
    }

    protected void hideKeyBoaard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private void hideKeyBoard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    protected abstract int getPageLayoutId();

    protected abstract String getScreenTitle();

    @Override
    protected void onResume() {
        super.onResume();

        //region ON RESUME DOWNLOAD
        departmentViewEntityFactory = Injection.providerDepartamentoViewModelFactory(getApplicationContext());
        departmentViewEntity = ViewModelProviders.of(this, departmentViewEntityFactory).get(DepartmentViewEntity.class);
        //searchDepartament();

        categoryViewEntityFactory = Injection.providerCategoryViewModelFactory(getApplicationContext());
        categoryViewEntity = ViewModelProviders.of(this, categoryViewEntityFactory).get(CategoryViewEntity.class);
        // searchCategory();

        wayPayViewEntityFactory = Injection.providerWayPayViewModelFactory(getApplicationContext());
        wayPayViewEntity = ViewModelProviders.of(this, wayPayViewEntityFactory).get(WayPayViewEntity.class);
        // searchWayPay();

        productFactory = Injection.providerProductViewModelFactory(getApplicationContext());
        productViewEntity = ViewModelProviders.of(this, productFactory).get(ProductViewEntity.class);
        // searchProduct();

        unitMeasurementViewEntityFactory = Injection.providerUnitMeasurementViewModelFactory(getApplicationContext());
        unitMeasurementViewEntity = ViewModelProviders.of(this, unitMeasurementViewEntityFactory).get(UnitMeasurementViewEntity.class);
        //searchUnitMeasure();
        //endregion

        //region ON RESUME SYNC
        existViewEntityFactory = Injection.providerExistViewModelFactory(getApplicationContext());
        existViewEntity = ViewModelProviders.of(this, existViewEntityFactory).get(ExistViewEntity.class);
        //searchExistSync();

        salesViewEntityFactory = Injection.providerSaleViewModelFactory(getApplicationContext());
        salesViewEntity = ViewModelProviders.of(this, salesViewEntityFactory).get(SalesViewEntity.class);
        //searchSaleSync();

        salesDetailViewEntityFactory = Injection.providerSaleDetailViewModelFactory(getApplicationContext());
        salesDetailViewEntity = ViewModelProviders.of(this, salesDetailViewEntityFactory).get(SalesDetailViewEntity.class);
        //searchSaleDetailSync();

        clienteViewEntityFactory = Injection.providerClientViewModelFactory(getApplicationContext());
        clienteViewEntity = ViewModelProviders.of(this, clienteViewEntityFactory).get(ClienteViewEntity.class);
        //searchClientSync();

        cashIncomeViewEntityFactory = Injection.providerCashIncomeViewModelFactory(getApplicationContext());
        cashIncomeViewEntity = ViewModelProviders.of(this, cashIncomeViewEntityFactory).get(CashIncomeViewEntity.class);
        //searchCashIncomeSync();

        cashShortDetailViewEntityFactory = Injection.providerCashShortDetailViewModelFactory(getApplicationContext());
        cashShortDetailViewEntity = ViewModelProviders.of(this, cashShortDetailViewEntityFactory).get(CashShortDetailViewEntity.class);
        //searchCashShortDetailSync();

        cashShortViewEntityFactory = Injection.providerCashShortViewModelFactory(getApplicationContext());
        cashShortViewEntity = ViewModelProviders.of(this, cashShortViewEntityFactory).get(CashShortViewEntity.class);
        //searchCashShortSync();

        kardexDetailViewEntityFactory = Injection.providerKardexDetailModelFactory(getApplicationContext());
        kardexDetailViewEntity = ViewModelProviders.of(this, kardexDetailViewEntityFactory).get(KardexDetailViewEntity.class);
        //searchKardexDetailSync();

        kardexViewEntityFactory = Injection.providerKardexViewModelFactory(getApplicationContext());
        kardexViewEntity = ViewModelProviders.of(this, kardexViewEntityFactory).get(KardexViewEntity.class);
        //searchKardexSync();

        withdrawalViewEntityFactory = Injection.providerWithdrawalViewModelFactory(getApplicationContext());
        withdrawalViewEntity = ViewModelProviders.of(this, withdrawalViewEntityFactory).get(WithdrawalViewEntity.class);
        //searchWithdrawalSync();

        receiptOfMerchandiseDetailViewEntityFactory = Injection.providerReceiptMerchandiseDetailViewModelFactory(getApplicationContext());
        receiptOfMerchandiseDetailViewEntity = ViewModelProviders.of(this, receiptOfMerchandiseDetailViewEntityFactory).get(ReceiptOfMerchandiseDetailViewEntity.class);
        //searchReceiptMerchandiseDetailSync();

        receiptOfMerchandiseViewEntityFactory = Injection.providerReceiptMerchandiseViewModelFactory(getApplicationContext());
        receiptOfMerchandiseViewEntity = ViewModelProviders.of(this, receiptOfMerchandiseViewEntityFactory).get(ReceiptOfMerchandiseViewEntity.class);
        //searchReceipMerchandiseSync();

        collectionOfPaymentViewEntityFactory = Injection.providerCollectionOfPaymentViewModelFactory(getApplicationContext());
        collectionOfPaymentViewEntity = ViewModelProviders.of(this, collectionOfPaymentViewEntityFactory).get(CollectionOfPaymentViewEntity.class);
        //searchCollectionOfPaymentSync();

        providerViewEntityFactory = Injection.providerProviderViewModelFactory(getApplicationContext());
        providerViewEntity = ViewModelProviders.of(this, providerViewEntityFactory).get(ProviderViewEntity.class);
        //searchProvider();
        //endregion
    }
    //endregion

    //region PRIVATE METHODS DOWNLOAD SYNC
    private void initializeViews() {
        compositeDisposable = new CompositeDisposable();
        unitMeasurementListMenuView = new ArrayList<>();
        departmentListMenuView = new ArrayList<>();
        categoryListMenuView = new ArrayList<>();
        productListMenuView = new ArrayList<>();
        wayPayListMenuView = new ArrayList<>();
        wayPayListUUID = new ArrayList<>();
    }

    //region BITACORA
    private String getLastDate() {
        String d = "";
        if (departmentListMenuView.isEmpty() && categoryListMenuView.isEmpty() && wayPayListMenuView.isEmpty() && productListMenuView.isEmpty() && unitMeasurementListMenuView.isEmpty()) {
            d = "01/01/2000 00:00:00:000";
        } else {
            String dateDepartment = lastDaySyncDepartment;
            String dateCategory = lastDaySyncCategory;
            String dateProduct = lastDaySyncProduct;
            String dateWayPay = lastDaySyncWayPay;
            String dateUnitMeasurement = lastDaySyncUnitMeasure;
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/LL/yyyy kk:mm:ss:SSS");
                Date dDepartement = sdf.parse(dateDepartment);
                Date dCategory = sdf.parse(dateCategory);
                Date dProduct = sdf.parse(dateProduct);
                Date dWayPay = sdf.parse(dateWayPay);
                Date dUnitMeasurement = sdf.parse(dateUnitMeasurement);

                if (dDepartement.compareTo(dCategory) == -1 && dDepartement.compareTo(dProduct) == -1 && dDepartement.compareTo(dUnitMeasurement) == -1 && dDepartement.compareTo(dWayPay) == -1) {
                    d = DepartmentEntity.instance.getLastDateSync();
                } else if (dCategory.compareTo(dDepartement) == -1 && dCategory.compareTo(dProduct) == -1 && dCategory.compareTo(dUnitMeasurement) == -1 && dCategory.compareTo(dWayPay) == -1) {
                    d = CategoryEntity.instance.getLastDateSync();
                } else if (dWayPay.compareTo(dDepartement) == -1 && dWayPay.compareTo(dProduct) == -1 && dWayPay.compareTo(dUnitMeasurement) == -1 && dWayPay.compareTo(dCategory) == -1) {
                    d = WayPayEntity.instance.getLastDateSync();
                } else if (dUnitMeasurement.compareTo(dDepartement) == -1 && dUnitMeasurement.compareTo(dProduct) == -1 && dUnitMeasurement.compareTo(dCategory) == -1 && dUnitMeasurement.compareTo(dWayPay) == -1) {
                    d = UnitMeasurementEntity.instance.getLastDateSync();
                } else if (dProduct.compareTo(dDepartement) == -1 && dProduct.compareTo(dCategory) == -1 && dProduct.compareTo(dUnitMeasurement) == -1 && dProduct.compareTo(dWayPay) == -1) {
                    d = ProductEntity.instance.getLastDateSync();
                } else {
                    d = ProductEntity.instance.getLastDateSync();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String date = d;
        return date;
    }

    private void getBitacoraActualizaciones() {
        hashMap = new HashMap<>();
        apiService = ServiceProvider.getApiServiceInstance();
        hashMap.put("fechaUltimaActualizacion", getLastDate());
        hashMap.put("authToken", LoginInfo.build(MenuView.this).getAuthToken());
        callBitacora = apiService.getBitacoraActividades(hashMap);
        callBitacora.enqueue(new Callback<JSONBitacora>() {
            @Override
            public void onResponse(Call<JSONBitacora> call, Response<JSONBitacora> response) {
                JSONBitacora jsonBitacora = response.body();
                if (response.body() == null) {
                    Toast.makeText(MenuView.this, getString(R.string.errorServidor), Toast.LENGTH_SHORT).show();
                } else if (response.body().getCode().equals("0")) {
                    bitacoraApiListWs = jsonBitacora.getResponse().getTablas();
                    getTables(bitacoraApiListWs);
                } else {
                    Toast.makeText(MenuView.this, getString(R.string.errorServidor), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JSONBitacora> call, Throwable t) {
                Toast.makeText(MenuView.this, getString(R.string.errorServidor), Toast.LENGTH_SHORT).show();
                Log.e("Error: ", getString(R.string.errorServidor), t);
            }
        });
    }

    private void getTables(List<BitacoraApi> bitacoraApi) {
        for (int i = 0; i < bitacoraApi.size(); i++) {
            if (bitacoraApi.get(i).getTabla().equals("DEPARTAMENTO")) {
                downloadDepartment();
            }
            if (bitacoraApi.get(i).getTabla().equals("CATEGORIA")) {
                downloadCategory();
            }
            if (bitacoraApi.get(i).getTabla().equals("FORMA_PAGO")) {
                downloadWayPay();
            }
            if (bitacoraApi.get(i).getTabla().equals("UNIDAD_MEDIDA")) {
                downloadUnitMeasure();
            }
            if (bitacoraApi.get(i).getTabla().equals("PRODUCTO")) {
                downloadProduct();
            }
        }
    }
    //endregion

    //region UNIT MEASURE
    //region WEB SERVICES
    private void downloadUnitMeasure() {
        hashMap = new HashMap<>();
        apiService = ServiceProvider.getApiServiceInstance();
        hashMap.put("fechaUltimaActualizacion", UnitMeasurementEntity.instance.getLastDateSync());
        hashMap.put("authToken", LoginInfo.build(MenuView.this).getAuthToken());
        callUnitMeasure = apiService.getUnidadesMedida(hashMap);
        callUnitMeasure.enqueue(new Callback<JSONUnitMeasurement>() {
            @Override
            public void onResponse(Call<JSONUnitMeasurement> call, Response<JSONUnitMeasurement> response) {
                JSONUnitMeasurement jsonUnitMeasurement = response.body();
                if (response.body() == null) {
                    Toast.makeText(MenuView.this, getString(R.string.errorServidor), Toast.LENGTH_SHORT).show();
                } else if (response.body().getCode().equals("0")) {
                    unitMeasurementListWs = jsonUnitMeasurement.getResponse().getUnidadesMedida();
                    insertDataUnitMeasureWS(unitMeasurementListWs);
                } else {
                    Toast.makeText(MenuView.this, getString(R.string.errorServidor), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JSONUnitMeasurement> call, Throwable t) {
                Toast.makeText(MenuView.this, getString(R.string.errorServidor), Toast.LENGTH_SHORT).show();
                Log.e("Error: ", getString(R.string.errorServidor), t);
            }
        });
    }

    private void insertDataUnitMeasureWS(List<UnitMeasurement> jsonUnitMeasure) {
        if (unitMeasurementListMenuView.isEmpty()) {
            for (int j = 0; j < jsonUnitMeasure.size(); j++) {
                UnitMeasurementEntity unitMeasurementEntity = new UnitMeasurementEntity();
                unitMeasurementEntity.setKey(jsonUnitMeasure.get(j).getClave());
                unitMeasurementEntity.setKaySAT(jsonUnitMeasure.get(j).getClaveSat());
                unitMeasurementEntity.setDescription(jsonUnitMeasure.get(j).getDescripcion());
                unitMeasurementEntity.setLastDateSync(getDate());
                unitMeasurementEntity.setUuid(jsonUnitMeasure.get(j).getUuid());
                unitMeasurementListMenuView.add(unitMeasurementEntity);
            }
            insertUnitMeasureDefault(unitMeasurementListMenuView);
        } else {
            for (int j = 0; j < jsonUnitMeasure.size(); j++) {
                String uuidWS = jsonUnitMeasure.get(j).getUuid();
                UnitMeasurementEntity unitMeasurementEntity = new UnitMeasurementEntity();
                unitMeasurementEntity.setKey(jsonUnitMeasure.get(j).getClave());
                unitMeasurementEntity.setKaySAT(jsonUnitMeasure.get(j).getClaveSat());
                unitMeasurementEntity.setDescription(jsonUnitMeasure.get(j).getDescripcion());
                unitMeasurementEntity.setLastDateSync(getDate());
                unitMeasurementEntity.setUuid(jsonUnitMeasure.get(j).getUuid());

                compositeDisposable.add(unitMeasurementViewEntity.getCountUnitMeasure(uuidWS)
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(() -> {
                                    if (unitMeasurementViewEntity.rowCount <= 0) {
                                        insertUnitMeasure(unitMeasurementEntity);
                                    } else {
                                        for (int i = 0; i < unitMeasurementListMenuView.size(); i++) {
                                            if (unitMeasurementListMenuView.get(i).getUuid().equals(uuidWS)) {
                                                unitMeasurementEntity.setId(unitMeasurementListMenuView.get(i).getId());
                                                break;
                                            }
                                        }
                                        updateUnitMeasure(unitMeasurementEntity);
                                    }

                                }, throwable -> {

                                }
                        ));
            }
        }
    }

    //endregion
    //region LOCAL
    private void insertUnitMeasureDefault(ArrayList unitMeasurementList) {
        compositeDisposable.add(unitMeasurementViewEntity.insertUnitMeasurementDefault(unitMeasurementList)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                })
        );
    }

    private void updateUnitMeasure(UnitMeasurementEntity unitMeasurementEntity) {
        compositeDisposable.add(unitMeasurementViewEntity.updateUnitMeasurement(unitMeasurementEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                })
        );
    }

    private void insertUnitMeasure(UnitMeasurementEntity unitMeasurementEntity) {
        compositeDisposable.add(unitMeasurementViewEntity.insertUnitMeasurement(unitMeasurementEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                })
        );
    }

    private void searchUnitMeasure() {
        compositeDisposable.add(unitMeasurementViewEntity.getFitlerUnitMeasurament()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<UnitMeasurementEntity>>) unitMeasurementListSearch -> {
                            unitMeasurementListMenuView = (ArrayList<UnitMeasurementEntity>) unitMeasurementListSearch;
                            for (int i = 0; i < unitMeasurementListMenuView.size(); i++) {
                                lastDaySyncUnitMeasure = unitMeasurementListMenuView.get(i).getLastDateSync();
                            }
                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), "Ocurrio un error al consultar los departamentos", Toast.LENGTH_LONG).show();
                            Log.e("PV SEGALMEX error en:", "");
                        }
                ));
    }

    //endregion
    //endregion
    //region DEPARTMENT
    //region WEB SERVICES
    private void downloadDepartment() {
        hashMap = new HashMap<>();
        apiService = ServiceProvider.getApiServiceInstance();
        hashMap.put("fechaUltimaActualizacion", DepartmentEntity.instance.getLastDateSync());
        hashMap.put("authToken", LoginInfo.build(MenuView.this).getAuthToken());
        hashMap.put("compania", String.valueOf(LoginInfo.build(MenuView.this).getCompania()));
        callDepartment = apiService.getDepartamentos(hashMap);
        callDepartment.enqueue(new Callback<JSONDepartment>() {
            @Override
            public void onResponse(Call<JSONDepartment> call, Response<JSONDepartment> response) {
                JSONDepartment jsonDepartment = response.body();
                if (response.body() == null) {
                    Toast.makeText(MenuView.this, getString(R.string.errorServidor), Toast.LENGTH_SHORT).show();
                } else if (response.body().getCode().equals("0")) {
                    departmentApiListWS = jsonDepartment.getResponse().getDepartamentos();
                    insertDataDepartmentWS(departmentApiListWS);
                } else {
                    Toast.makeText(MenuView.this, getString(R.string.errorServidor), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JSONDepartment> call, Throwable t) {
                Toast.makeText(MenuView.this, getString(R.string.errorServidor), Toast.LENGTH_SHORT).show();
                Log.e("Error: ", getString(R.string.errorServidor), t);
            }
        });
    }

    private void insertDataDepartmentWS(List<DepartmentApi> jsonDepartmentApis) {
        try {
            if (departmentListMenuView.isEmpty()) {
                for (int j = 0; j < jsonDepartmentApis.size(); j++) {
                    DepartmentEntity department = new DepartmentEntity();
                    department.setUuid(jsonDepartmentApis.get(j).getUUID());
                    department.setDescription(jsonDepartmentApis.get(j).getDESCRIPCION());
                    department.setStatus(1);
                    department.setLastDateSync(getDate());
                    departmentListMenuView.add(department);
                }
                insertDepartmentDefault(departmentListMenuView);
            } else {
                for (int j = 0; j < jsonDepartmentApis.size(); j++) {
                    String uuidWS = jsonDepartmentApis.get(j).getUUID();
                    DepartmentEntity department = new DepartmentEntity();
                    department.setUuid(jsonDepartmentApis.get(j).getUUID());
                    department.setDescription(jsonDepartmentApis.get(j).getDESCRIPCION());
                    department.setStatus(1);
                    department.setLastDateSync(getDate());

                    compositeDisposable.add(departmentViewEntity.getCountDepartment(uuidWS)
                            .subscribeOn(Schedulers.computation())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(() -> {
                                        if (departmentViewEntity.rowCount <= 0) {
                                            insertDepartment(department);
                                        } else {
                                            for (int i = 0; i < departmentListMenuView.size(); i++) {
                                                if (departmentListMenuView.get(i).getUuid().equals(uuidWS)) {
                                                    department.setId(departmentListMenuView.get(i).getId());
                                                    break;
                                                }
                                            }
                                            updateDepartment(department);
                                        }

                                    }, throwable -> {

                                    }
                            ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //endregion
    //region LOCAL
    private void insertDepartmentDefault(ArrayList departmentList) {
        compositeDisposable.add(departmentViewEntity.insertDepartmentDefault(departmentList)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (DepartmentEntity.instance.getId() != -1) {
                    }
                })
        );
    }

    private void insertDepartment(DepartmentEntity departmentEntity) {
        compositeDisposable.add(departmentViewEntity.insertDepartamento(departmentEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (DepartmentEntity.instance.getId() != -1) {

                    }
                })
        );
    }

    private void updateDepartment(DepartmentEntity departmentEntity) {
        compositeDisposable.add(departmentViewEntity.updateDepartamento(departmentEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (DepartmentEntity.instance.getId() != -1) {

                    }
                })
        );
    }

    private void searchDepartament() {
        compositeDisposable.add(departmentViewEntity.getFilterCategory()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<DepartmentEntity>>) departmentListSearch -> {
                            departmentListMenuView = (ArrayList<DepartmentEntity>) departmentListSearch;
                            for (int i = 0; i < departmentListMenuView.size(); i++) {
                                lastDaySyncDepartment = departmentListSearch.get(i).getLastDateSync();
                            }
                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), "Ocurrio un error al consultar los departamentos", Toast.LENGTH_LONG).show();
                            Log.e("PV SEGALMEX error en:", "");
                        }
                ));
    }
    //endregion
    //endregion

    //region CATEGORY
    //region WEBSERVICES
    private void downloadCategory() {
        hashMap = new HashMap<>();
        apiService = ServiceProvider.getApiServiceInstance();
        hashMap.put("fechaUltimaActualizacion", CategoryEntity.instance.getLastDateSync());
        hashMap.put("authToken", LoginInfo.build(MenuView.this).getAuthToken());
        hashMap.put("compania", String.valueOf(LoginInfo.build(MenuView.this).getCompania()));
        callCategory = apiService.getCategorias(hashMap);
        callCategory.enqueue(new Callback<JSONCategory>() {
            @Override
            public void onResponse(Call<JSONCategory> call, Response<JSONCategory> response) {
                JSONCategory jsonCategory = response.body();
                if (response.body() == null) {
                    Toast.makeText(MenuView.this, "Error de conexión", Toast.LENGTH_SHORT).show();
                } else if (response.body().getCode().equals("0")) {
                    categoryApiListWS = jsonCategory.getResponse().getCategorias();
                    insertDataCategoryWS(categoryApiListWS);
                } else {
                    Toast.makeText(MenuView.this, getString(R.string.errorServidor), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JSONCategory> call, Throwable t) {
                Toast.makeText(MenuView.this, "Error en el servidor", Toast.LENGTH_SHORT).show();
                Log.e("Error: ", "Error en el servidor", t);
            }
        });
    }

    private void insertDataCategoryWS(List<CategoryApi> jsosonCategoryApi) {
        try {
            if (categoryListMenuView.isEmpty()) {
                for (int j = 0; j < jsosonCategoryApi.size(); j++) {
                    CategoryEntity categoryEntity = new CategoryEntity();
                    categoryEntity.setUuid(jsosonCategoryApi.get(j).getUUID());
                    categoryEntity.setDescription(jsosonCategoryApi.get(j).getDESCRIPCION());
                    categoryEntity.setDepartment(jsosonCategoryApi.get(j).getDEPARTAMENTO());
                    categoryEntity.setStatus(1);
                    categoryEntity.setLastDateSync(getDate());
                    categoryListMenuView.add(categoryEntity);
                }
                insertCategoryDefault(categoryListMenuView);
            } else {
                for (int j = 0; j < jsosonCategoryApi.size(); j++) {
                    String uuidWS = jsosonCategoryApi.get(j).getUUID();
                    CategoryEntity categoryEntity = new CategoryEntity();
                    categoryEntity.setUuid(jsosonCategoryApi.get(j).getUUID());
                    categoryEntity.setDescription(jsosonCategoryApi.get(j).getDESCRIPCION());
                    categoryEntity.setDepartment(jsosonCategoryApi.get(j).getDEPARTAMENTO());
                    categoryEntity.setStatus(1);
                    categoryEntity.setLastDateSync(getDate());

                    compositeDisposable.add(categoryViewEntity.getCountCategory(uuidWS)
                            .subscribeOn(Schedulers.computation())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(() -> {
                                        if (productViewEntity.rowCount <= 0) {
                                            insertCategory(categoryEntity);
                                        } else {
                                            for (int i = 0; i < categoryListMenuView.size(); i++) {
                                                if (categoryListMenuView.get(i).getUuid().equals(uuidWS)) {
                                                    categoryEntity.setId(categoryListMenuView.get(i).getId());
                                                    break;
                                                }
                                            }
                                            updateCategory(categoryEntity);
                                        }

                                    }, throwable -> {

                                    }
                            ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //endregion
    //region LOCAL
    private void insertCategoryDefault(ArrayList categoryList) {
        compositeDisposable.add(categoryViewEntity.insertCategoryDefault(categoryList)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (CategoryEntity.instance.getId() != -1) {
                    }
                })
        );
    }

    private void insertCategory(CategoryEntity categoryList) {
        compositeDisposable.add(categoryViewEntity.inserCategory(categoryList)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                })
        );
    }

    private void updateCategory(CategoryEntity categoryList) {
        compositeDisposable.add(categoryViewEntity.updateCategory(categoryList)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                })
        );
    }

    private void searchCategory() {
        compositeDisposable.add(categoryViewEntity.getFilterProduct()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<CategoryEntity>>) categoryListSearch -> {
                            categoryListMenuView = (ArrayList<CategoryEntity>) categoryListSearch;
                            if (!categoryListMenuView.isEmpty()) {
                                searchProduct();
                            }
                            for (int i = 0; i < categoryListMenuView.size(); i++) {
                                lastDaySyncCategory = categoryListMenuView.get(i).getLastDateSync();
                            }

                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), "Ocurrio un error al consultar las categorias", Toast.LENGTH_LONG).show();
                            Log.e("PV SEGALMEX error en:", "");
                        }
                ));
    }
    //endregion
    //endregion

    //region PRODUCT
    //region WEBSERVICES
    private void downloadProduct() {
        hashMap = new HashMap<>();
        apiService = ServiceProvider.getApiServiceInstance();
        hashMap.put("fechaUltimaActualizacion", ProductEntity.instance.getLastDateSync());
        hashMap.put("authToken", LoginInfo.build(MenuView.this).getAuthToken());
        hashMap.put("puntoVenta", String.valueOf(LoginInfo.build(MenuView.this).getPunto_venta()));
        callProduct = apiService.getProductos(hashMap);
        callProduct.enqueue(new Callback<JSONProduct>() {
            @Override
            public void onResponse(Call<JSONProduct> call, Response<JSONProduct> response) {
                JSONProduct jsonProduct = response.body();
                if (response.body() == null) {
                    Toast.makeText(MenuView.this, "Error de conexión", Toast.LENGTH_SHORT).show();
                } else if (response.body().getCode().equals("0")) {
                    productApiListWS = jsonProduct.getResponse().getProductos();
                    insertDataProductWS(productApiListWS);
                } else {
                    Toast.makeText(MenuView.this, getString(R.string.errorServidor), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JSONProduct> call, Throwable t) {
                Toast.makeText(MenuView.this, "Error en el servidor", Toast.LENGTH_SHORT).show();
                Log.e("Error: ", "Error en el servidor", t);
            }
        });
    }

    private void insertDataProductWS(List<ProductApi> jsonProducts) {
        try {
            if (productListMenuView.isEmpty()) {
                for (int j = 0; j < jsonProducts.size(); j++) {
                    ProductEntity productEntity = new ProductEntity();
                    productEntity.setLastDateSync(getDate());
                    productEntity.setUuid(jsonProducts.get(j).getUuid());
                    productEntity.setDateUC(jsonProducts.get(j).getFechaUc());
                    productEntity.setCostUC(jsonProducts.get(j).getCostoUc());
                    productEntity.setCost(jsonProducts.get(j).getCosto());
                    productEntity.setCategory(jsonProducts.get(j).getCategoria());
                    productEntity.setCategory(jsonProducts.get(j).getCategoria());
                    productEntity.setCode(jsonProducts.get(j).getCodigo());
                    productEntity.setUuid(jsonProducts.get(j).getUuid());
                    if (jsonProducts.get(j).getDiconsa()) {
                        productEntity.setDiconsa(1);
                    } else {
                        productEntity.setDiconsa(0);
                    }
                    if (jsonProducts.get(j).getGranel()) {
                        productEntity.setGranel(1);
                    } else {
                        productEntity.setGranel(0);
                    }
                    if (jsonProducts.get(j).getServicio()) {
                        productEntity.setService(1);
                    } else {
                        productEntity.setService(0);
                    }
                    productEntity.setFactor(jsonProducts.get(j).getFactor());
                    productEntity.setMaximum(jsonProducts.get(j).getMaximo());
                    productEntity.setMinimum(jsonProducts.get(j).getMinimo());
                    productEntity.setReorderPoint(jsonProducts.get(j).getPuntoReorden());
                    productEntity.setUnitMeasure(jsonProducts.get(j).getUnidadMedida());
                    productEntity.setUnitMeasurePurchase(jsonProducts.get(j).getUnidadMedidaCompra());
                    productEntity.setStatus(1);
                    productEntity.setDescription(jsonProducts.get(j).getDescripcion());
                    productListMenuView.add(productEntity);
                }
                insertProductDefault(productListMenuView);
            } else {
                for (int i = 0; i < jsonProducts.size(); i++) {
                    String uuidWS = jsonProducts.get(i).getUuid();
                    ProductEntity productEntity = new ProductEntity();
                    productEntity.setLastDateSync(getDate());
                    productEntity.setUuid(jsonProducts.get(i).getUuid());
                    productEntity.setDateUC(jsonProducts.get(i).getFechaUc());
                    productEntity.setCostUC(jsonProducts.get(i).getCostoUc());
                    productEntity.setCost(jsonProducts.get(i).getCosto());
                    productEntity.setCategory(jsonProducts.get(i).getCategoria());
                    productEntity.setCategory(jsonProducts.get(i).getCategoria());
                    productEntity.setCode(jsonProducts.get(i).getCodigo());
                    productEntity.setUuid(jsonProducts.get(i).getUuid());
                    if (jsonProducts.get(i).getDiconsa()) {
                        productEntity.setDiconsa(1);
                    } else {
                        productEntity.setDiconsa(0);
                    }
                    if (jsonProducts.get(i).getGranel()) {
                        productEntity.setGranel(1);
                    } else {
                        productEntity.setGranel(0);
                    }
                    if (jsonProducts.get(i).getServicio()) {
                        productEntity.setService(1);
                    } else {
                        productEntity.setService(0);
                    }
                    productEntity.setFactor(jsonProducts.get(i).getFactor());
                    productEntity.setMaximum(jsonProducts.get(i).getMaximo());
                    productEntity.setMinimum(jsonProducts.get(i).getMinimo());
                    productEntity.setReorderPoint(jsonProducts.get(i).getPuntoReorden());
                    productEntity.setUnitMeasure(jsonProducts.get(i).getUnidadMedida());
                    productEntity.setUnitMeasurePurchase(jsonProducts.get(i).getUnidadMedidaCompra());
                    productEntity.setStatus(1);
                    productEntity.setDescription(jsonProducts.get(i).getDescripcion());

                    compositeDisposable.add(productViewEntity.getCountProduct(uuidWS)
                            .subscribeOn(Schedulers.computation())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(() -> {
                                        if (productViewEntity.rowCount <= 0) {
                                            insertProduct(productEntity);
                                        } else {
                                            for (int j = 0; j < productListMenuView.size(); j++) {
                                                if (productListMenuView.get(j).getUuid().equals(uuidWS)) {
                                                    productEntity.setId(productListMenuView.get(j).getId());
                                                    break;
                                                }
                                            }
                                            updateProduct(productEntity);
                                        }

                                    }, throwable -> {

                                    }
                            ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //endregion
    //region LOCAL
    private void insertProductDefault(ArrayList list) {
        compositeDisposable.add(productViewEntity.insertProductDefault(list)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (ProductEntity.instance.getId() != -1) {
                        Log.i("inserto", "Inserto");
                    }
                })
        );
    }

    private void insertProduct(ProductEntity productEntity) {
        compositeDisposable.add(productViewEntity.insertProduct(productEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (ProductEntity.instance.getId() != -1) {
                        Log.i("inserto", "Inserto");
                    }
                })
        );
    }

    private void updateProduct(ProductEntity productEntity) {
        compositeDisposable.add(productViewEntity.updateProduct(productEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (ProductEntity.instance.getId() != -1) {
                        Log.i("inserto", "Inserto");
                    }
                })
        );
    }

    private void searchProduct() {
        compositeDisposable.add(productViewEntity.getFilterProductsCatalog()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<ProductEntity>>) productListSearch -> {
                            productListMenuView = (ArrayList<ProductEntity>) productListSearch;
                            for (int i = 0; i < productListMenuView.size(); i++) {
                                lastDaySyncProduct = productListMenuView.get(i).getLastDateSync();
                            }
                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), "Ocurrio un error al consultar los clientes", Toast.LENGTH_LONG).show();
                            Log.e("PV SEGALMEX error en:", "");
                        }
                ));
    }
    //endregion
    //endregion

    //region WAY PAY
    //region WEBSERVICES
    private void downloadWayPay() {
        hashMap = new HashMap<>();
        apiService = ServiceProvider.getApiServiceInstance();
        hashMap.put("fechaUltimaActualizacion", WayPayEntity.instance.getLastDateSync());
        hashMap.put("authToken", LoginInfo.build(MenuView.this).getAuthToken());
        callWayPay = apiService.getFormasPago(hashMap);
        callWayPay.enqueue(new Callback<JSONWayPay>() {
            @Override
            public void onResponse(Call<JSONWayPay> call, Response<JSONWayPay> response) {
                JSONWayPay jsonWayPay = response.body();
                if (response.body() == null) {
                    Toast.makeText(MenuView.this, "Error de conexión", Toast.LENGTH_SHORT).show();
                } else if (response.body().getCode().equals("0")) {
                    wayPayApiListWS = jsonWayPay.getResponse().getFormasPago();
                    insertDataWayPayWS(wayPayApiListWS);
                } else {
                    Toast.makeText(MenuView.this, getString(R.string.errorServidor), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JSONWayPay> call, Throwable t) {
                Toast.makeText(MenuView.this, "Error en el servidor", Toast.LENGTH_SHORT).show();
                Log.e("Error: ", "Error en el servidor", t);
            }
        });
    }

    private void insertDataWayPayWS(List<WayPayApi> jsonWayPayApi) {
        try {
            if (wayPayListMenuView.isEmpty()) {
                for (int j = 0; j < jsonWayPayApi.size(); j++) {
                    WayPayEntity wayPayEntity = new WayPayEntity();
                    wayPayEntity.setLastDateSync(getDate());
                    wayPayEntity.setUuid(jsonWayPayApi.get(j).getUuid());
                    wayPayEntity.setImage(jsonWayPayApi.get(j).getImagen());
                    wayPayEntity.setDescription(jsonWayPayApi.get(j).getDescripcion());
                    wayPayListMenuView.add(wayPayEntity);
                }
                insertWayPayDefault(wayPayListMenuView);
            } else {
                for (int i = 0; i < jsonWayPayApi.size(); i++) {
                    String uuidWS = jsonWayPayApi.get(i).getUuid();

                    WayPayEntity wayPayEntityLocal = new WayPayEntity();
                    wayPayEntityLocal.setLastDateSync(getDate());
                    wayPayEntityLocal.setUuid(jsonWayPayApi.get(i).getUuid());
                    wayPayEntityLocal.setImage(jsonWayPayApi.get(i).getImagen());
                    wayPayEntityLocal.setDescription(jsonWayPayApi.get(i).getDescripcion());

                    compositeDisposable.add(wayPayViewEntity.getCountWayPay(uuidWS)
                            .subscribeOn(Schedulers.computation())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(() -> {
                                        if (wayPayViewEntity.rowCount <= 0) {
                                            insertWayPay(wayPayEntityLocal);
                                        } else {
                                            for (int j = 0; j < wayPayListMenuView.size(); j++) {
                                                if (wayPayListMenuView.get(j).getUuid().equals(uuidWS)) {
                                                    wayPayEntityLocal.setId(wayPayListMenuView.get(j).getId());
                                                    break;
                                                }
                                            }
                                            updateWayPay(wayPayEntityLocal);
                                        }

                                    }, throwable -> {

                                    }
                            ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //endregion
    //region LOCAL

    private void searchWayPay() {
        compositeDisposable.add(wayPayViewEntity.getFilterWayPayCashShort()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<WayPayEntity>>) wayPayListSearch -> {
                            wayPayListMenuView = (ArrayList<WayPayEntity>) wayPayListSearch;
                            for (int i = 0; i < wayPayListMenuView.size(); i++) {
                                lastDaySyncWayPay = wayPayListMenuView.get(i).getLastDateSync();
                            }

                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), "Ocurrio un error al consultar las formas de pago", Toast.LENGTH_LONG).show();
                            Log.e("PV SEGALMEX error en:", "");
                        }
                ));
    }

    private void insertWayPayDefault(ArrayList wayPayList) {
        compositeDisposable.add(wayPayViewEntity.insertWayPayDefault(wayPayList)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (WayPayEntity.instance.getId() != -1) {
                        Log.i("inserto", "Inserto");
                    }
                })
        );
    }

    private void insertWayPay(WayPayEntity wayPayList) {
        compositeDisposable.add(wayPayViewEntity.insertWayPay(wayPayList)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (WayPayEntity.instance.getId() != -1) {
                        Log.i("inserto", "Inserto");
                    }
                })
        );
    }

    private void updateWayPay(WayPayEntity wayPayList) {
        compositeDisposable.add(wayPayViewEntity.updateWayPay(wayPayList)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (WayPayEntity.instance.getId() != -1) {
                        Log.i("inserto", "Inserto");
                    }
                })
        );
    }
    //endregion
    //endregion
    //endregion

    //region PRIVATE METHODS SYNC 
    //region Exist
    private void searchExistSync() {
        compositeDisposable.add(existViewEntity.getRegisterExistSync()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<ExistEntity>>) saleListSearch -> {
                            existList = (ArrayList<ExistEntity>) saleListSearch;
                        }, throwable -> {

                        }
                ));
    }

    private void sendExist() {
        JsonElement jsonElement = gson.toJsonTree(existList);
        jsonArray = jsonElement.getAsJsonArray();
        String object = String.valueOf(existList);
        hashMap = new HashMap<>();
        apiService = ServiceProvider.getApiServiceInstance();
        hashMap.put("authToken", LoginInfo.build(MenuView.this).getAuthToken());
        hashMap.put("existencia", object);
        hashMap.put("puntoVenta", String.valueOf(LoginInfo.build(MenuView.this).getPunto_venta()));
        callExist = apiService.postExist(hashMap);
        callExist.enqueue(new Callback<ExistApi>() {
            @Override
            public void onResponse(Call<ExistApi> call, Response<ExistApi> response) {
                ExistApi existApi = response.body();
                if (response.body() == null) {
                    Toast.makeText(MenuView.this, "Error de conexión", Toast.LENGTH_SHORT).show();
                } else if (response.body().getCode().equals("200")) {
                    Toast.makeText(MenuView.this, getString(R.string.exitoso), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MenuView.this, getString(R.string.errorServidor), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ExistApi> call, Throwable t) {
                Toast.makeText(MenuView.this, "Error en el servidor", Toast.LENGTH_SHORT).show();
                Log.e("Error: ", "Error en el servidor", t);
            }
        });
    }
    //endregion

    //region Sale
    private void searchSaleSync() {
        compositeDisposable.add(salesViewEntity.getRegisterSalesSync()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<SalesEntity>>) saleListSearch -> {
                            salesList = (ArrayList<SalesEntity>) saleListSearch;
                        }, throwable -> {

                        }
                ));
    }

    private void sendSale() {
        JsonElement jsonElement = gson.toJsonTree(salesList);
        jsonArray = jsonElement.getAsJsonArray();
        String object = jsonArray.toString();
        hashMap = new HashMap<>();
        apiService = ServiceProvider.getApiServiceInstance();
        hashMap.put("authToken", LoginInfo.build(MenuView.this).getAuthToken());
        hashMap.put("venta", object);
        hashMap.put("puntoVenta", String.valueOf(LoginInfo.build(MenuView.this).getPunto_venta()));
        callSale = apiService.postSale(hashMap);
        callSale.enqueue(new Callback<SaleApi>() {
            @Override
            public void onResponse(Call<SaleApi> call, Response<SaleApi> response) {
                SaleApi saleApi = response.body();
                if (response.body() == null) {
                    Toast.makeText(MenuView.this, "Error de conexión", Toast.LENGTH_SHORT).show();
                } else if (response.body().getCode().equals("200")) {
                    Toast.makeText(MenuView.this, getString(R.string.exitoso), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MenuView.this, getString(R.string.errorServidor), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SaleApi> call, Throwable t) {
                Toast.makeText(MenuView.this, "Error en el servidor", Toast.LENGTH_SHORT).show();
                Log.e("Error: ", "Error en el servidor", t);
            }
        });
    }
    //endregion

    //region SaleDetail
    private void searchSaleDetailSync() {
        compositeDisposable.add(salesDetailViewEntity.getRegisterSalesDetailSync()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<SalesDetailEntity>>) saleDetailListSearch -> {
                            salesDetailList = (ArrayList<SalesDetailEntity>) saleDetailListSearch;
                        }, throwable -> {

                        }
                ));
    }

    private void sendSaleDetail() {
        JsonElement jsonElement = gson.toJsonTree(salesDetailList);
        jsonArray = jsonElement.getAsJsonArray();
        String object = jsonArray.toString();
        hashMap = new HashMap<>();
        apiService = ServiceProvider.getApiServiceInstance();
        hashMap.put("authToken", LoginInfo.build(MenuView.this).getAuthToken());
        hashMap.put("ventaDetalle", object);
        callSaleDetail = apiService.postSaleDetail(hashMap);
        callSaleDetail.enqueue(new Callback<SaleDetailApi>() {
            @Override
            public void onResponse(Call<SaleDetailApi> call, Response<SaleDetailApi> response) {
                if (response.body() == null) {
                    Toast.makeText(MenuView.this, "Error de conexión", Toast.LENGTH_SHORT).show();
                } else if (response.body().getCode().equals("200")) {
                    Toast.makeText(MenuView.this, getString(R.string.exitoso), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MenuView.this, getString(R.string.errorServidor), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SaleDetailApi> call, Throwable t) {
                Toast.makeText(MenuView.this, "Error en el servidor", Toast.LENGTH_SHORT).show();
                Log.e("Error: ", "Error en el servidor", t);
            }
        });
    }
    //endregion

    //region CollectionOfPayment
    private void searchCollectionOfPaymentSync() {
        compositeDisposable.add(collectionOfPaymentViewEntity.getRegisterCollectionOfPaymentSync()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<CollectionOfPaymentEntity>>) collectionOfPaymentListSearch -> {
                            collectionOfPaymentList = (ArrayList<CollectionOfPaymentEntity>) collectionOfPaymentListSearch;
                        }, throwable -> {
                        }
                ));
    }

    private void sendCollectionOfPayment() {
        JsonElement jsonElement = gson.toJsonTree(collectionOfPaymentList);
        jsonArray = jsonElement.getAsJsonArray();
        String object = jsonArray.toString();
        hashMap = new HashMap<>();
        apiService = ServiceProvider.getApiServiceInstance();
        hashMap.put("authToken", LoginInfo.build(MenuView.this).getAuthToken());
        hashMap.put("ventaCobro", object);
        callCollectionPayment = apiService.postColectionPayment(hashMap);
        callCollectionPayment.enqueue(new Callback<CollectionPaymentApi>() {
            @Override
            public void onResponse(Call<CollectionPaymentApi> call, Response<CollectionPaymentApi> response) {
                if (response.body() == null) {
                    Toast.makeText(MenuView.this, "Error de conexión", Toast.LENGTH_SHORT).show();
                } else if (response.body().getCode().equals("200")) {
                    Toast.makeText(MenuView.this, getString(R.string.exitoso), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MenuView.this, getString(R.string.errorServidor), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CollectionPaymentApi> call, Throwable t) {
                Toast.makeText(MenuView.this, "Error en el servidor", Toast.LENGTH_SHORT).show();
                Log.e("Error: ", "Error en el servidor", t);
            }
        });
    }
    //endregion

    //region Receipt Merchandise
    private void searchReceipMerchandiseSync() {
        compositeDisposable.add(receiptOfMerchandiseViewEntity.getRegisterReceiptOfMerchandiseDetailSync()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<ReceiptOfMerchandiseEntity>>) receiptOfMerchandiseListSearch -> {
                            receiptOfMerchandiseList = (ArrayList<ReceiptOfMerchandiseEntity>) receiptOfMerchandiseListSearch;
                        }, throwable -> {

                        }
                ));
    }

    private void sendReceiptMerchandise() {
        JsonElement jsonElement = gson.toJsonTree(receiptOfMerchandiseList);
        jsonArray = jsonElement.getAsJsonArray();
        String object = jsonArray.toString();
        hashMap = new HashMap<>();
        apiService = ServiceProvider.getApiServiceInstance();
        hashMap.put("authToken", LoginInfo.build(MenuView.this).getAuthToken());
        hashMap.put("recepcionMercancia", object);
        hashMap.put("puntoVenta", String.valueOf(LoginInfo.build(MenuView.this).getPunto_venta()));
        callReceiptMerchandise = apiService.postReceiptMerchandise(hashMap);
        callReceiptMerchandise.enqueue(new Callback<ReceiptMerchandiseApi>() {
            @Override
            public void onResponse(Call<ReceiptMerchandiseApi> call, Response<ReceiptMerchandiseApi> response) {
                if (response.body() == null) {
                    Toast.makeText(MenuView.this, "Error de conexión", Toast.LENGTH_SHORT).show();
                } else if (response.body().getCode().equals("200")) {
                    Toast.makeText(MenuView.this, getString(R.string.exitoso), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MenuView.this, getString(R.string.errorServidor), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ReceiptMerchandiseApi> call, Throwable t) {
                Toast.makeText(MenuView.this, "Error en el servidor", Toast.LENGTH_SHORT).show();
                Log.e("Error: ", "Error en el servidor", t);
            }
        });
    }
    //endregion

    //region ReceiptMerchandiseDetail
    private void searchReceiptMerchandiseDetailSync() {
        compositeDisposable.add(receiptOfMerchandiseDetailViewEntity.getRegisterReceiptOfMerchandiseDetailSync()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<ReceiptOfMerchandiseDetailEntity>>) receiptOfMerchandiseDetailListSearch -> {
                            receiptOfMerchandiseDetailList = (ArrayList<ReceiptOfMerchandiseDetailEntity>) receiptOfMerchandiseDetailListSearch;
                        }, throwable -> {

                        }
                ));
    }

    private void sendReceiptMerchandiseDetail() {
        JsonElement jsonElement = gson.toJsonTree(receiptOfMerchandiseDetailList);
        jsonArray = jsonElement.getAsJsonArray();
        String object = jsonArray.toString();
        hashMap = new HashMap<>();
        apiService = ServiceProvider.getApiServiceInstance();
        hashMap.put("authToken", LoginInfo.build(MenuView.this).getAuthToken());
        hashMap.put("recepcionMercanciaDetalle", object);
        callReceipMerchandiseDetail = apiService.postReceiptMerchandiseDetail(hashMap);
        callReceipMerchandiseDetail.enqueue(new Callback<ReceiptMerchandiseDetailApi>() {
            @Override
            public void onResponse(Call<ReceiptMerchandiseDetailApi> call, Response<ReceiptMerchandiseDetailApi> response) {
                if (response.body() == null) {
                    Toast.makeText(MenuView.this, "Error de conexión", Toast.LENGTH_SHORT).show();
                } else if (response.body().getCode().equals("200")) {
                    Toast.makeText(MenuView.this, getString(R.string.exitoso), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MenuView.this, getString(R.string.errorServidor), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ReceiptMerchandiseDetailApi> call, Throwable t) {
                Toast.makeText(MenuView.this, "Error en el servidor", Toast.LENGTH_SHORT).show();
                Log.e("Error: ", "Error en el servidor", t);
            }
        });
    }
    //endregion

    //region Income
    private void searchCashIncomeSync() {
        compositeDisposable.add(cashIncomeViewEntity.getRegisterCashIncomeSync()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<CashIncomeEntity>>) cashIncomeListSearch -> {
                            cashIncomeList = (ArrayList<CashIncomeEntity>) cashIncomeListSearch;
                        }, throwable -> {

                        }
                ));
    }

    private void sendCashIncome() {
        JsonElement jsonElement = gson.toJsonTree(cashIncomeList);
        jsonArray = jsonElement.getAsJsonArray();
        String object = jsonArray.toString();
        hashMap = new HashMap<>();
        apiService = ServiceProvider.getApiServiceInstance();
        hashMap.put("authToken", LoginInfo.build(MenuView.this).getAuthToken());
        hashMap.put("ingreso", object);
        hashMap.put("puntoVenta", String.valueOf(LoginInfo.build(MenuView.this).getPunto_venta()));
        callIncome = apiService.postIncome(hashMap);
        callIncome.enqueue(new Callback<IncomeApi>() {
            @Override
            public void onResponse(Call<IncomeApi> call, Response<IncomeApi> response) {
                if (response.body() == null) {
                    Toast.makeText(MenuView.this, "Error de conexión", Toast.LENGTH_SHORT).show();
                } else if (response.body().getCode().equals("200")) {
                    Toast.makeText(MenuView.this, getString(R.string.exitoso), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MenuView.this, getString(R.string.errorServidor), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<IncomeApi> call, Throwable t) {
                Toast.makeText(MenuView.this, "Error en el servidor", Toast.LENGTH_SHORT).show();
                Log.e("Error: ", "Error en el servidor", t);
            }
        });
    }
    //endregion

    //region Withdrawal
    private void searchWithdrawalSync() {
        compositeDisposable.add(withdrawalViewEntity.getRegisterWithdrawalSync()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<WithdrawalEntity>>) withdrawalListSearch -> {
                            withdrawalList = (ArrayList<WithdrawalEntity>) withdrawalListSearch;
                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), getString(R.string.errorConsulta), Toast.LENGTH_LONG).show();
                            Log.e(getString(R.string.errorSQLITE), "");
                        }
                ));
    }

    private void sendWithdrawal() {
        JsonElement jsonElement = gson.toJsonTree(withdrawalList);
        jsonArray = jsonElement.getAsJsonArray();
        String object = jsonArray.toString();
        hashMap = new HashMap<>();
        apiService = ServiceProvider.getApiServiceInstance();
        hashMap.put("authToken", LoginInfo.build(MenuView.this).getAuthToken());
        hashMap.put("retiroCaja", object);
        hashMap.put("puntoVenta", String.valueOf(LoginInfo.build(MenuView.this).getPunto_venta()));
        callWithdrawal = apiService.postWithdrawal(hashMap);
        callWithdrawal.enqueue(new Callback<WithdrawalApi>() {
            @Override
            public void onResponse(Call<WithdrawalApi> call, Response<WithdrawalApi> response) {
                if (response.body() == null) {
                    Toast.makeText(MenuView.this, "Error de conexión", Toast.LENGTH_SHORT).show();
                } else if (response.body().getCode().equals("200")) {
                    Toast.makeText(MenuView.this, getString(R.string.exitoso), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MenuView.this, getString(R.string.errorServidor), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<WithdrawalApi> call, Throwable t) {
                Toast.makeText(MenuView.this, "Error en el servidor", Toast.LENGTH_SHORT).show();
                Log.e("Error: ", "Error en el servidor", t);
            }
        });
    }
    //endregion

    //region KARDEX
    private void searchKardexSync() {
        compositeDisposable.add(kardexViewEntity.getRegisterKardexSync()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<KardexEntity>>) kardexEntityListSearch -> {
                            kardexEntityList = (ArrayList<KardexEntity>) kardexEntityListSearch;
                        }, throwable -> {

                        }
                ));
    }

    private void sendKardex() {
        JsonElement jsonElement = gson.toJsonTree(kardexEntityList);
        jsonArray = jsonElement.getAsJsonArray();
        String object = jsonArray.toString();
        hashMap = new HashMap<>();
        apiService = ServiceProvider.getApiServiceInstance();
        hashMap.put("authToken", LoginInfo.build(MenuView.this).getAuthToken());
        hashMap.put("kardex", object);
        hashMap.put("puntoVenta", String.valueOf(LoginInfo.build(MenuView.this).getPunto_venta()));
        callKardex = apiService.postKardex(hashMap);
        callKardex.enqueue(new Callback<KardexApi>() {
            @Override
            public void onResponse(Call<KardexApi> call, Response<KardexApi> response) {
                if (response.body() == null) {
                    Toast.makeText(MenuView.this, "Error de conexión", Toast.LENGTH_SHORT).show();
                } else if (response.body().getCode().equals("200")) {
                    Toast.makeText(MenuView.this, getString(R.string.exitoso), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MenuView.this, getString(R.string.errorServidor), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<KardexApi> call, Throwable t) {
                Toast.makeText(MenuView.this, "Error en el servidor", Toast.LENGTH_SHORT).show();
                Log.e("Error: ", "Error en el servidor", t);
            }
        });
    }
    //endregion

    //region KARDEX DETAIL
    private void searchKardexDetailSync() {
        compositeDisposable.add(kardexDetailViewEntity.getRegisterKardexDetailSync()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<KardexDetailEntity>>) kardexDetailEntityListSearch -> {
                            kardexDetailList = (ArrayList<KardexDetailEntity>) kardexDetailEntityListSearch;
                        }, throwable -> {

                        }
                ));
    }

    private void sendKardexDetail() {
        JsonElement jsonElement = gson.toJsonTree(kardexDetailList);
        jsonArray = jsonElement.getAsJsonArray();
        String object = jsonArray.toString();
        hashMap = new HashMap<>();
        apiService = ServiceProvider.getApiServiceInstance();
        hashMap.put("authToken", LoginInfo.build(MenuView.this).getAuthToken());
        hashMap.put("venta", object);
        hashMap.put("puntoVenta", String.valueOf(LoginInfo.build(MenuView.this).getPunto_venta()));
        callKardexDetail = apiService.postKardexDetail(hashMap);
        callKardexDetail.enqueue(new Callback<KardexDetailApi>() {
            @Override
            public void onResponse(Call<KardexDetailApi> call, Response<KardexDetailApi> response) {
                if (response.body() == null) {
                    Toast.makeText(MenuView.this, "Error de conexión", Toast.LENGTH_SHORT).show();
                } else if (response.body().getCode().equals("200")) {
                    Toast.makeText(MenuView.this, getString(R.string.exitoso), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MenuView.this, getString(R.string.errorServidor), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<KardexDetailApi> call, Throwable t) {
                Toast.makeText(MenuView.this, "Error en el servidor", Toast.LENGTH_SHORT).show();
                Log.e("Error: ", "Error en el servidor", t);
            }
        });
    }
    //endregion

    //region Cash Short
    private void searchCashShortSync() {
        compositeDisposable.add(cashShortViewEntity.getRegisterCashShortSync()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<CashShortEntity>>) cashShortEntityListSearch -> {
                            cashShortList = (ArrayList<CashShortEntity>) cashShortEntityListSearch;
                        }, throwable -> {

                        }
                ));
    }

    private void sendCashShort() {
        JsonElement jsonElement = gson.toJsonTree(cashShortList);
        jsonArray = jsonElement.getAsJsonArray();
        String object = jsonArray.toString();
        hashMap = new HashMap<>();
        apiService = ServiceProvider.getApiServiceInstance();
        hashMap.put("authToken", LoginInfo.build(MenuView.this).getAuthToken());
        hashMap.put("cortesCaja", object);
        hashMap.put("puntoVenta", String.valueOf(LoginInfo.build(MenuView.this).getPunto_venta()));
        hashMap.put("usuario", String.valueOf(LoginInfo.build(MenuView.this).getUserId()));
        callCashShort = apiService.postCashShort(hashMap);
        callCashShort.enqueue(new Callback<CashShortApi>() {
            @Override
            public void onResponse(Call<CashShortApi> call, Response<CashShortApi> response) {
                if (response.body() == null) {
                    Toast.makeText(MenuView.this, "Error de conexión", Toast.LENGTH_SHORT).show();
                } else if (response.body().getCode().equals("200")) {
                    Toast.makeText(MenuView.this, getString(R.string.exitoso), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MenuView.this, getString(R.string.errorServidor), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CashShortApi> call, Throwable t) {
                Toast.makeText(MenuView.this, "Error en el servidor", Toast.LENGTH_SHORT).show();
                Log.e("Error: ", "Error en el servidor", t);
            }
        });
    }
    //endregion

    //region CashShortDetail
    private void searchCashShortDetailSync() {
        compositeDisposable.add(cashShortDetailViewEntity.getFilterCashShortDetail()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<CashShortDetailEntity>>) cashShortDetailListSearch -> {
                            cashShortDetailList = (ArrayList<CashShortDetailEntity>) cashShortDetailListSearch;
                        }, throwable -> {

                        }
                ));
    }

    private void sendCashShortDetail() {
        JsonElement jsonElement = gson.toJsonTree(cashShortDetailList);
        jsonArray = jsonElement.getAsJsonArray();
        String object = jsonArray.toString();
        hashMap = new HashMap<>();
        apiService = ServiceProvider.getApiServiceInstance();
        hashMap.put("authToken", LoginInfo.build(MenuView.this).getAuthToken());
        hashMap.put("cortesCajaDetalle", object);
        callCashShortDetail = apiService.postCashShortDetail(hashMap);
        callCashShortDetail.enqueue(new Callback<CashShortDetailApi>() {
            @Override
            public void onResponse(Call<CashShortDetailApi> call, Response<CashShortDetailApi> response) {
                if (response.body() == null) {
                    Toast.makeText(MenuView.this, "Error de conexión", Toast.LENGTH_SHORT).show();
                } else if (response.body().getCode().equals("200")) {
                    Toast.makeText(MenuView.this, getString(R.string.exitoso), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MenuView.this, getString(R.string.errorServidor), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CashShortDetailApi> call, Throwable t) {
                Toast.makeText(MenuView.this, "Error en el servidor", Toast.LENGTH_SHORT).show();
                Log.e("Error: ", "Error en el servidor", t);
            }
        });
    }
    //endregion

    //region Client
    private void searchClientSync() {
        compositeDisposable.add(clienteViewEntity.getRegisterClienteSync()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<ClienteEntity>>) clienteListSearch -> {
                            clienteList = (ArrayList<ClienteEntity>) clienteListSearch;
                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), getString(R.string.errorConsulta), Toast.LENGTH_LONG).show();
                            Log.e(getString(R.string.errorSQLITE), "");
                        }
                ));
    }

   /* private void sendClient(){
        JsonElement jsonElement = gson.toJsonTree(clienteList);
        jsonArray = jsonElement.getAsJsonArray();
        String object = jsonArray.toString();
        hashMap = new HashMap<>();
        apiService = ServiceProvider.getApiServiceInstance();
        hashMap.put("authToken", LoginInfo.build(MenuView.this).getAuthToken());
        hashMap.put("venta", object);
        hashMap.put("puntoVenta", String.valueOf(LoginInfo.build(MenuView.this).getPunto_venta()));
        callClient = apiService.postClient(hashMap);
        callClient.enqueue(new Callback<ClientApi>() {
            @Override
            public void onResponse(Call<ClientApi> call, Response<ClientApi> response) {
                if (response.body() == null) {
                    Toast.makeText(MenuView.this, "Error de conexión", Toast.LENGTH_SHORT).show();
                } else if (response.body().getCode().equals("200")) {
                    Toast.makeText(MenuView.this, getString(R.string.exitoso), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MenuView.this, getString(R.string.errorServidor), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ClientApi> call, Throwable t) {
                Toast.makeText(MenuView.this, "Error en el servidor", Toast.LENGTH_SHORT).show();
                Log.e("Error: ", "Error en el servidor", t);
            }
        });
    }*/
    //endregion

    //region Provider
    private void searchProvider() {
        compositeDisposable.add(providerViewEntity.getRegisterReceiptOfMerchandiseDetailSync()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<ProviderEntity>>) providerListSearch -> {
                            providerList = (ArrayList<ProviderEntity>) providerListSearch;
                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), getString(R.string.errorConsulta), Toast.LENGTH_LONG).show();
                            Log.e(getString(R.string.errorSQLITE), "");
                        }
                ));
    }

    private void sendProvider() {
        JsonElement jsonElement = gson.toJsonTree(providerList);
        jsonArray = jsonElement.getAsJsonArray();
        String object = jsonArray.toString();
        hashMap = new HashMap<>();
        apiService = ServiceProvider.getApiServiceInstance();
        hashMap.put("authToken", LoginInfo.build(MenuView.this).getAuthToken());
        hashMap.put("venta", object);
        hashMap.put("puntoVenta", String.valueOf(LoginInfo.build(MenuView.this).getPunto_venta()));
        callProvider = apiService.postProvider(hashMap);
        callProvider.enqueue(new Callback<ProviderApi>() {
            @Override
            public void onResponse(Call<ProviderApi> call, Response<ProviderApi> response) {
                if (response.body() == null) {
                    Toast.makeText(MenuView.this, "Error de conexión", Toast.LENGTH_SHORT).show();
                } else if (response.body().getCode().equals("200")) {
                    Toast.makeText(MenuView.this, getString(R.string.exitoso), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MenuView.this, getString(R.string.errorServidor), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ProviderApi> call, Throwable t) {
                Toast.makeText(MenuView.this, "Error en el servidor", Toast.LENGTH_SHORT).show();
                Log.e("Error: ", "Error en el servidor", t);
            }
        });
    }
    //endregion
    //endregion SY
}
