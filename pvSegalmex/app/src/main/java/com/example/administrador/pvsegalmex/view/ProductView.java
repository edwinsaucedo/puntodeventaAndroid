package com.example.administrador.pvsegalmex.view;

import android.app.Activity;
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
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.adapter.RvProductAdapter;
import com.example.administrador.pvsegalmex.controller.SwipeController;
import com.example.administrador.pvsegalmex.controller.SwipeControllerActions;
import com.example.administrador.pvsegalmex.entity.ProductEntity;
import com.example.administrador.pvsegalmex.mode.Barcodemode;
import com.example.administrador.pvsegalmex.uint.ScanHelper;
import com.example.administrador.pvsegalmex.uint.SysBarcodeUtil;
import com.example.administrador.pvsegalmex.utils.DialogUtils;
import com.example.administrador.pvsegalmex.viewEntity.ProductViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.ProductViewEntityFactory;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ProductView extends MenuView {

    //region VARS
    ArrayList<ProductEntity> productList;
    ProductViewEntityFactory productFactory;
    ProductViewEntity productViewEntity;
    CompositeDisposable compositeDisposable;
    CompositeDisposable compositeDisposable2;
    private int scanmode = -1;
    Context context;
    private boolean bleft = false, bright = false, bsound = false;
    private int Index = 1;
    private List<Barcodemode> readermodes = new ArrayList<Barcodemode>();
    private String m_Broadcastname;
    //endregion

    //region VIEWS
    EditText mProductCode;
    RelativeLayout relativeLayout;
    RecyclerView rvProduct;
    RvProductAdapter rvProductAdapter;
    FloatingActionButton btnAddProduct, btnSearchProduct;
    ItemTouchHelper touchHelper;
    SwipeController swipe;
    LinearLayout lnProductView;
    DrawerLayout drMenu;

    //endregion

    //region PRIVATE METHODS
    private void initializeViews() {
        productList = new ArrayList<>();
        mProductCode = findViewById(R.id.edtProductCode);
        btnAddProduct = findViewById(R.id.btnAddProduct);
        rvProduct = findViewById(R.id.rvProducts);
        lnProductView = findViewById(R.id.lnProductView);
        drMenu = findViewById(R.id.drwMenuPrincipal);
        relativeLayout = findViewById(R.id.rlProductView);

    }

    @SuppressWarnings("unchecked")
    private void searchProduct() {
        if (productViewEntity == null) {
            productViewEntity = ViewModelProviders.of(this, productFactory).get(ProductViewEntity.class);
        }
        String product, description = "";
        if (description == null) {
            return;
        }
        product = mProductCode.getText().toString();
        description = mProductCode.getText().toString();

        compositeDisposable.add(productViewEntity.getFilterProducts(description)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<ProductEntity>>) productListSearch -> {

                            productList = (ArrayList<ProductEntity>) productListSearch;
                            if (productList.isEmpty()) {
                                Toast.makeText(getApplicationContext(), getString(R.string.noHayRegistros), Toast.LENGTH_SHORT).show();
                            }
                            rvProductAdapter = new RvProductAdapter(productList, getApplicationContext());
                            rvProduct.setAdapter(rvProductAdapter);
                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), getString(R.string.errorConsulta), Toast.LENGTH_SHORT).show();
                            Log.e(getString(R.string.errorSQLITE), "");
                        }
                ));
    }


    private void goToEditProduct(ProductEntity product) {
        ProductEntity.instance.setId(product.getId());
        ProductEntity.instance.setDescription(product.getDescription());
        ProductEntity.instance.setAlternateCode(product.getAlternateCode());
        ProductEntity.instance.setCode(product.getCode());
        ProductEntity.instance.setCategory(product.getCategory());
        ProductEntity.instance.setCost(product.getCost());
        ProductEntity.instance.setMaximum(product.getMaximum());
        ProductEntity.instance.setMinimum(product.getMinimum());
        ProductEntity.instance.setCostUC(product.getCostUC());
        ProductEntity.instance.setDateUC(product.getDateUC());
        ProductEntity.instance.setDiconsa(product.getDiconsa());
        ProductEntity.instance.setFactor(product.getFactor());
        ProductEntity.instance.setGranel(product.getGranel());
        ProductEntity.instance.setService(product.getService());
        ProductEntity.instance.setUnitMeasure(product.getUnitMeasure());
        ProductEntity.instance.setUnitMeasurePurchase(product.getUnitMeasurePurchase());
        ProductEntity.instance.setReorderPoint(product.getReorderPoint());
        ProductEntity.instance.setImage(product.getImage());
        Intent intent = new Intent(getApplicationContext(), CrudProductView.class);
/*        Bundle bundle = new Bundle();
        bundle.putInt("idProduct",id);
        intent.putExtras(bundle);
        */
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void deleteProduct(ProductEntity product) {
        product.setStatus(-1);
        compositeDisposable.add(productViewEntity.updateProduct(product)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    DialogUtils.showOkayDialog(ProductView.this, getString(R.string.messageSuccTitleGlobal), getString(R.string.deleteProductSuccess), "success");
                })
        );
    }

    private void ScanSetting() {
        // 0 : fast; 1 : slow; 2 : broadcast
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (Settings.System.canWrite(this)) {
                String version = android.os.Build.VERSION.RELEASE;
                if (version.equals("4.2.2")) {
                    scanmode = SysBarcodeUtil.getBarcodeSendMode(ProductView.this);
                    bleft = SysBarcodeUtil.getLeftSwitchState(ProductView.this);
                    bright = SysBarcodeUtil.getRightSwitchState(ProductView.this);
                    if (!bleft) {
                        SysBarcodeUtil.setLeftSwitchState(ProductView.this, true);
                    }
                    if (!bright) {
                        SysBarcodeUtil.setRightSwitchState(ProductView.this, true);
                    }
                    if (scanmode != 2) {
                        SysBarcodeUtil.setBarcodeSendMode(ProductView.this, 2);
                    }
                } else {
                    scanmode = ScanHelper.getBarcodeReceiveMode(ProductView.this);
                    bleft = ScanHelper.getScanSwitchLeft(ProductView.this);
                    bright = ScanHelper.getScanSwitchRight(ProductView.this);
                    bsound = ScanHelper.getScanSound(ProductView.this);
                    if (!bsound) {
                        ScanHelper.setScanSound(ProductView.this, true);
                    }
                    if (!bleft) {
                        ScanHelper.setScanSwitchLeft(ProductView.this, true);
                    }
                    if (!bright) {
                        ScanHelper.setScanSwitchRight(ProductView.this, true);
                    }
                    if (scanmode != 2)
                        ScanHelper.setBarcodeReceiveMode(ProductView.this, 2);

                }
            }
        }

    }

    private void closeKeyboard() {
        InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mProductCode.getWindowToken(), 0);
    }


    public void hideSoftKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_IMPLICIT_ONLY);
    }
    //endregion


    //region PROTECTED METHODS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ProductEntity.instance.clear();
        // setPermision();
        initializeViews();
        compositeDisposable = new CompositeDisposable();
        compositeDisposable2 = new CompositeDisposable();
        rvProductAdapter = new RvProductAdapter(productList, getApplicationContext());
        rvProduct.setLayoutManager(new LinearLayoutManager(this));
        rvProduct.setAdapter(rvProductAdapter);
        ScanSetting();
        Barcodemode code = new Barcodemode();
        mProductCode.setText(code.getBarcode());
        lnProductView.setOnClickListener(v -> hideKeyBoaard());
        drMenu.setOnClickListener(v -> hideKeyBoaard());
        drwMenuPrincipal.setOnClickListener(v -> hideKeyBoaard());
        relativeLayout.setOnClickListener(v -> hideKeyBoaard());
        rvProduct.setOnClickListener(v -> hideKeyBoaard());
        rvProduct.setOnClickListener(v -> hideKeyBoaard());


        swipe = new SwipeController(new SwipeControllerActions() {
            @Override
            public void onLeftClicked(int position) {

                if (position < 0) {
                    Toast.makeText(getApplicationContext(), "Seleccione el item", Toast.LENGTH_SHORT).show();
                    return;

                }
                ProductEntity productClicked = productList.get(position);
                DialogUtils.showOkayNoDialog(getString(R.string.delProductWarningMessage), getString(R.string.delProductWarningTitle), ProductView.this, new DialogUtils.OnOkayNoEvent() {
                    @Override
                    public void onYes() {
                        deleteProduct(productClicked);
                    }

                    @Override
                    public void onNo() {
                        Toast.makeText(getApplicationContext(), "Ok", Toast.LENGTH_SHORT).show();

                    }
                });
            }

            @Override
            public void onRightClicked(int position) {
                if (position < 0) {
                    Toast.makeText(getApplicationContext(), "Seleccione el item", Toast.LENGTH_SHORT).show();
                    return;

                }
                ProductEntity productClicked = productList.get(position);
                int idProduct = productClicked.getId();
//                ProductPriceEntity productPriceEntity = productPriceList.get(position);
                //              goToEditProductPrice(productPriceEntity);
                goToEditProduct(productClicked);

            }
        });
        touchHelper = new ItemTouchHelper(swipe);
        touchHelper.attachToRecyclerView(rvProduct);
        rvProduct.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                swipe.onDraw(c);
            }
        });

        btnAddProduct.setOnClickListener(v -> {
            ProductEntity.instance.clear();
            startActivity(CrudProductView.class);
        });
        mProductCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                searchProduct();
                rvProduct.setAdapter(rvProductAdapter);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        hideKeyboard(this);
    }

    public static void hideKeyboard(Activity activity) {
        View view = activity.findViewById(android.R.id.content);
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }


    @Override
    protected int getPageLayoutId() {
        return R.layout.activity_product_view;
    }

    @Override
    protected String getScreenTitle() {
        return getString(R.string.itemMenu8);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        hideKeyBoaard();
        return super.onTouchEvent(event);
    }

    @Override
    protected void onResume() {
        super.onResume();
        productFactory = Injection.providerProductViewModelFactory(getApplicationContext());
        productViewEntity = ViewModelProviders.of(this, productFactory).get(ProductViewEntity.class);
        searchProduct();


        final IntentFilter intentFilter = new IntentFilter();
        m_Broadcastname = "com.barcode.sendBroadcast";// com.barcode.sendBroadcastScan
        intentFilter.addAction(m_Broadcastname);
        registerReceiver(receiver, intentFilter);

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
                    mProductCode.setText(str);

                }
            }
        }
    };

    @Override
    public void onBackPressed() {
    }

    //endregion
}
