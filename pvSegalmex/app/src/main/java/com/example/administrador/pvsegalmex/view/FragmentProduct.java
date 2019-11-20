package com.example.administrador.pvsegalmex.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.adapter.ArrayAdapterSpinnerMeasure;
import com.example.administrador.pvsegalmex.adapter.RvPCSpinnerAdapter;
import com.example.administrador.pvsegalmex.adapter.SimpleSpinnerUnitMeasurementAdapter;
import com.example.administrador.pvsegalmex.entity.CategoryEntity;
import com.example.administrador.pvsegalmex.entity.ProductEntity;
import com.example.administrador.pvsegalmex.entity.UnitMeasurementEntity;
import com.example.administrador.pvsegalmex.mode.Barcodemode;
import com.example.administrador.pvsegalmex.uint.ScanHelper;
import com.example.administrador.pvsegalmex.uint.SysBarcodeUtil;
import com.example.administrador.pvsegalmex.utils.DialogUtils;
import com.example.administrador.pvsegalmex.viewEntity.CategoryViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.ProductViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.UnitMeasurementViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.CategoryViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.ProductViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.UnitMeasurementViewEntityFactory;
import com.squareup.picasso.Picasso;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class FragmentProduct extends Fragment {

    //region VARS
    private CompositeDisposable compositeDisposable;
    private ProductViewEntityFactory productFactory;
    private ProductViewEntity productViewEntity;

    private UnitMeasurementViewEntity unitMeasurementViewEntity;
    private UnitMeasurementViewEntityFactory unitMeasurementViewEntityFactory;
    private ArrayList<UnitMeasurementEntity> unitMeasurementList;
    private SimpleSpinnerUnitMeasurementAdapter spinnerUnitMeasurementAdapter;
    private ArrayAdapterSpinnerMeasure adapterSpinnerMeasure;
    private CategoryViewEntity categoryViewEntity;
    int scanmode = -1;
    boolean bleft = false, bright = false, bsound = false;
    private String m_Broadcastname;
    private final int PERMISSION_REQUEST_CODE = 1001;
    private static final int PICK_IMAGE = 100;
    private String imagePathProduct = "";
    private ArrayList<CategoryEntity> categoryList;
    private RvPCSpinnerAdapter rvPCSpinnerAdapter;
    private CategoryViewEntityFactory categoryViewEntityFactory;

    View view;
    //endregion

    // test variables camara
    private Uri path;
    private ArrayList<String> permissionsToRequest;
    private ArrayList<String> permissionsRejected = new ArrayList<>();
    private ArrayList<String> permissions = new ArrayList<>();
    private final static int ALL_PERMISSIONS_RESULT = 107;
    private final static int IMAGE_RESULT = 200;

    //fin

    //region VIEWS
    private AppCompatSpinner spCategory;
    public EditText edtCode, edtAlternateCode, edtDescription, edtMax, edtMin, edtReorderPoint, edtFactor, edtCost, edtCostLastPurchase, edtDateLastPurchase;
    private AppCompatCheckBox chbxService, chbxDiconsa, chbxGranel;
    private SearchableSpinner spinnerUnitMeasure, spinnerUnitLastPurchase;
    private AppCompatButton btnSave;
    private ImageView imageProduct, photoProduct;
    //endregion

    //region PRIVATE METHODS
    private void initializeViews(View view) {
        categoryList = new ArrayList<>();
        unitMeasurementList = new ArrayList<>();
        spCategory = view.findViewById(R.id.spCategory);
        edtCode = view.findViewById(R.id.edtProductCode);
        edtAlternateCode = view.findViewById(R.id.edtProductAlternateCode);
        edtDescription = view.findViewById(R.id.edtProductDescription);
        edtMax = view.findViewById(R.id.edtProductMax);
        edtMin = view.findViewById(R.id.edtProductMin);
        edtReorderPoint = view.findViewById(R.id.edtProductReorderPoint);
        spinnerUnitMeasure = view.findViewById(R.id.spinnerMeasurement);
        spinnerUnitLastPurchase = view.findViewById(R.id.spinnerUnitPurchase);
        edtFactor = view.findViewById(R.id.edtProductFactor);
        edtCost = view.findViewById(R.id.edtProductCostSale);
        edtCostLastPurchase = view.findViewById(R.id.edtProductCostLastPurchase);
        edtDateLastPurchase = view.findViewById(R.id.edtProductDateLastPurchase);
        chbxDiconsa = view.findViewById(R.id.chboxProductDiconsa);
        chbxGranel = view.findViewById(R.id.chboxProductGranel);
        chbxService = view.findViewById(R.id.chboxProductService);
        btnSave = view.findViewById(R.id.btnSaveProduct);
        photoProduct = view.findViewById(R.id.imvTakeImageProduct);
        imageProduct = view.findViewById(R.id.imvImageProduct);
    }

    //region Unidad de Medida
    private void searchUnitMeasurement() {
        compositeDisposable.add(unitMeasurementViewEntity.getFitlerUnitMeasurament()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<UnitMeasurementEntity>>) unitMeasurementListSearch -> {
                            unitMeasurementList = (ArrayList<UnitMeasurementEntity>) unitMeasurementListSearch;
                            spinnerUnitMeasurementAdapter = new SimpleSpinnerUnitMeasurementAdapter(getActivity(), R.layout.spinner_provider, unitMeasurementList);
                            adapterSpinnerMeasure = new ArrayAdapterSpinnerMeasure(getActivity(), R.layout.sp_client_sale, unitMeasurementList);
                            adapterSpinnerMeasure.setDropDownViewResource(R.layout.sp_client_sale);
                            spinnerUnitLastPurchase.setAdapter(adapterSpinnerMeasure);
                            updateUid();
                        }, throwable -> {
                            Toast.makeText(getActivity(), "Ocurrio un error al consultar los clientes", Toast.LENGTH_LONG).show();
                            Log.e("PV SEGALMEX error en:", "");
                        }
                ));
    }

    private void searchUnitMeasurementPurchase() {
        compositeDisposable.add(unitMeasurementViewEntity.getFitlerUnitMeasurament()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<UnitMeasurementEntity>>) unitMeasurementListSearch -> {

                            unitMeasurementList = (ArrayList<UnitMeasurementEntity>) unitMeasurementListSearch;

                            spinnerUnitMeasurementAdapter = new SimpleSpinnerUnitMeasurementAdapter(getActivity(), R.layout.spinner_provider, unitMeasurementList);
                            adapterSpinnerMeasure = new ArrayAdapterSpinnerMeasure(getActivity(), R.layout.sp_client_sale, unitMeasurementList);
                            adapterSpinnerMeasure.setDropDownViewResource(R.layout.sp_client_sale);
                            spinnerUnitMeasure.setAdapter(adapterSpinnerMeasure);
                            updateUid();
                        }, throwable -> {
                            Toast.makeText(getActivity(), "Ocurrio un error al consultar los clientes", Toast.LENGTH_LONG).show();
                            Log.e("PV SEGALMEX error en:", "");
                        }
                ));
    }

    //endregion

    private void getCategory() {
        int i = 0;
        for (CategoryEntity category : categoryList) {
            if (category.getId().equals(ProductEntity.instance.getCategory())) {
                spCategory.setSelection(i);
                break;
            } else if (i == categoryList.size() - 1) {
                spCategory.setAdapter(rvPCSpinnerAdapter);
            }
            i++;
        }
    }

    private void getUnitMeseasurement() {
        int k = 0;
        for (UnitMeasurementEntity unitMeasurement : unitMeasurementList) {
            int idUnitMeasurement = ProductEntity.instance.getUnitMeasure();
            if (unitMeasurement.getId() == idUnitMeasurement) {
                spinnerUnitMeasure.setSelection(k);
                break;
            } else if (k == unitMeasurementList.size() - 1) {
                spinnerUnitMeasure.setAdapter(adapterSpinnerMeasure);
            }
            k++;
        }
    }

    private void getUnitMeseasurementPurchase() {
        int j = 0;
        for (UnitMeasurementEntity unitMeasurement : unitMeasurementList) {
            if (unitMeasurement.getId() == ProductEntity.instance.getUnitMeasurePurchase()) {
                spinnerUnitLastPurchase.setSelection(j);
                break;
            } else if (j == unitMeasurementList.size() - 1) {
                spinnerUnitLastPurchase.setAdapter(adapterSpinnerMeasure);
            }
            j++;
        }
    }

    private void updateUid() {
        getCategory();
        getUnitMeseasurement();
        getUnitMeseasurementPurchase();
        String image = ProductEntity.instance.getImage();
        edtCode.setText(ProductEntity.instance.getCode());
        edtDescription.setText(ProductEntity.instance.getDescription());
        edtCost.setText(String.valueOf(ProductEntity.instance.getCost()));
        edtAlternateCode.setText(ProductEntity.instance.getAlternateCode());
        edtMax.setText(String.valueOf(ProductEntity.instance.getMaximum()));
        edtMin.setText(String.valueOf(ProductEntity.instance.getMinimum()));
        edtReorderPoint.setText(String.valueOf(ProductEntity.instance.getReorderPoint()));
        edtFactor.setText(String.valueOf(ProductEntity.instance.getFactor()));
        if (ProductEntity.instance.getDiconsa() == 1) {
            chbxDiconsa.setChecked(true);
        } else {
            chbxDiconsa.setChecked(false);
        }
        if (ProductEntity.instance.getGranel() == 1) {
            chbxGranel.setChecked(true);
        } else {
            chbxGranel.setChecked(false);
        }
        if (ProductEntity.instance.getService() == 1) {
            chbxService.setChecked(true);
        } else {
            chbxService.setChecked(false);
        }
        edtCostLastPurchase.setText(String.valueOf(ProductEntity.instance.getCostUC()));
        edtDateLastPurchase.setText(ProductEntity.instance.getDateUC());

        if (image.isEmpty() || image == "" || image == null) {
            imageProduct.setImageURI(null);
        } else {
            imagePathProduct = ProductEntity.instance.getImage();
            Picasso.get().load(new File(imagePathProduct)).into(imageProduct);

        }
    }

    private void saveProduct() {
        ProductEntity product = new ProductEntity();
        if (edtCode.getText().toString().isEmpty()) {
            edtCode.setError(getString(R.string.fieldRequired));
            return;
        }
        if (edtDescription.getText().toString().isEmpty()) {
            edtDescription.setError(getString(R.string.fieldRequired));
            return;
        }

        if (edtMin.getText().toString().isEmpty() || edtMin.getText() == null) {
            product.setMinimum(0.0);
        }
        if (edtMax.getText().toString().isEmpty() || edtMax.getText() == null) {
            product.setMaximum(0.0);
        }
        if (edtCostLastPurchase.getText().toString().isEmpty() || edtCostLastPurchase.getText() == null) {
            product.setCostUC(0.0);
        }
        if (edtCost.getText().toString().isEmpty() || edtCost.getText() == null) {

            product.setCostUC(0.0);
        }
        if (edtFactor.getText().toString().isEmpty() || edtFactor.getText() == null) {

            product.setFactor(0.0);
        }
        if (edtReorderPoint.getText().toString().isEmpty() || edtReorderPoint.getText() == null) {

            product.setReorderPoint(0.0);
        }
        if (categoryList.size() < 1) {

            DialogUtils.showOkayNoDialog(getString(R.string.askCategory), getString(R.string.categoryWawning), getActivity(), new DialogUtils.OnOkayNoEvent() {
                @Override
                public void onYes() {
                    getActivity().finish();
                    Intent intent = new Intent(getActivity(), CategoryView.class);
                    startActivity(intent);
                    return;
                }

                @Override
                public void onNo() {
                    return;
                }
            });
            return;
        }
        int idUnitMeasure = (int) spinnerUnitMeasure.getSelectedItemId();
        int idUnitMeasurePurchase = (int) spinnerUnitLastPurchase.getSelectedItemId();
        product.setCategory((int) rvPCSpinnerAdapter.getItemId(spCategory.getSelectedItemPosition()));
        product.setDescription(edtDescription.getText().toString().trim().toUpperCase());
        product.setCode(edtCode.getText().toString().trim());
        product.setAlternateCode(edtAlternateCode.getText().toString().trim().toUpperCase());
        product.setMaximum(Double.parseDouble(edtMax.getText().toString().trim()));
        product.setMinimum(Double.parseDouble(edtMin.getText().toString().trim()));
        product.setReorderPoint(Double.parseDouble(edtReorderPoint.getText().toString().trim()));
        product.setUnitMeasure(idUnitMeasure);
        product.setUnitMeasurePurchase(idUnitMeasurePurchase);

        if (product.getImage() == null) {
            imageProduct.setImageResource(R.drawable.sinproducto);
        } else {
            product.setImage(imagePathProduct);
        }

        if (chbxDiconsa.isChecked()) {
            product.setDiconsa(1);
        } else
            product.setDiconsa(0);
        if (chbxService.isChecked()) {
            product.setService(1);
        } else
            product.setService(0);
        if (chbxGranel.isChecked()) {
            product.setGranel(1);
        } else
            product.setGranel(0);

        product.setCost(Double.parseDouble(edtCost.getText().toString().trim()));
        product.setDateUC(edtDateLastPurchase.getText().toString().trim());
        product.setCostUC(Double.parseDouble(edtCostLastPurchase.getText().toString().trim()));

        if (ProductEntity.instance.getId() == -1) {
            insertProduct(product);
        } else {
            product.setId(ProductEntity.instance.getId());
            updateProduct(product);
        }
    }

    private void insertProduct(ProductEntity product) {
        compositeDisposable.add(productViewEntity.insertProduct(product)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (ProductEntity.instance.getId() != -1) {
                        getActivity().finish();
                    } else {
                        Toast.makeText(getContext(), "Ha ocurrido un error.", Toast.LENGTH_LONG).show();

                    }
                })
        );
    }

    private void updateProduct(ProductEntity product) {
        compositeDisposable.add(productViewEntity.updateProduct(product)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getActivity()::finish)
        );
    }

    private void searchCategory() {
        compositeDisposable.add(categoryViewEntity.getFilterProduct()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<CategoryEntity>>) categoryListSearch -> {
                            categoryList = (ArrayList<CategoryEntity>) categoryListSearch;
                            if (categoryList.isEmpty())
                                Toast.makeText(getActivity(), "No hay Categorias registradas", Toast.LENGTH_LONG).show();
                            rvPCSpinnerAdapter = new RvPCSpinnerAdapter(getActivity(), categoryList);
                            spCategory.setAdapter(rvPCSpinnerAdapter);
                            updateUid();
                        }, throwable -> {
                            Toast.makeText(getActivity(), "Ocurrio un error al consultar las categorias", Toast.LENGTH_LONG).show();
                            Log.e("PV SEGALMEX error en:", "");
                        }
                ));
    }

    private void ScanSetting() {
        // 0 : fast; 1 : slow; 2 : broadcast
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (Settings.System.canWrite(getActivity())) {
                String version = android.os.Build.VERSION.RELEASE;
                if (version.equals("4.2.2")) {
                    scanmode = SysBarcodeUtil.getBarcodeSendMode(getActivity());
                    bleft = SysBarcodeUtil.getLeftSwitchState(getActivity());
                    bright = SysBarcodeUtil.getRightSwitchState(getActivity());
                    if (!bleft) {
                        SysBarcodeUtil.setLeftSwitchState(getActivity(), true);
                    }
                    if (!bright) {
                        SysBarcodeUtil.setRightSwitchState(getActivity(), true);
                    }
                    if (scanmode != 2) {
                        SysBarcodeUtil.setBarcodeSendMode(getActivity(), 2);
                    }
                } else {
                    scanmode = ScanHelper.getBarcodeReceiveMode(getActivity());
                    bleft = ScanHelper.getScanSwitchLeft(getActivity());
                    bright = ScanHelper.getScanSwitchRight(getActivity());
                    bsound = ScanHelper.getScanSound(getActivity());
                    if (!bsound) {
                        ScanHelper.setScanSound(getActivity(), true);
                    }
                    if (!bleft) {
                        ScanHelper.setScanSwitchLeft(getActivity(), true);
                    }
                    if (!bright) {
                        ScanHelper.setScanSwitchRight(getActivity(), true);
                    }
                    if (scanmode != 2)
                        ScanHelper.setBarcodeReceiveMode(getActivity(), 2);
                }
            }
        }
    }
    //endregion

   /* private void cameraIntent() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    private void takePhoto() {
        boolean result = permissionCheck();
        if (result)
            cameraIntent();
    }
    */


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScanSetting();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_product, container, false);
        initializeViews(view);

        spinnerUnitLastPurchase.setEnabled(false);
        spinnerUnitLastPurchase.setClickable(false);
        compositeDisposable = new CompositeDisposable();

        productFactory = Injection.providerProductViewModelFactory(getActivity());
        edtCostLastPurchase.setEnabled(false);
        edtDateLastPurchase.setEnabled(false);
        productViewEntity = ViewModelProviders.of(this, productFactory).get(ProductViewEntity.class);

        categoryViewEntityFactory = Injection.providerCategoryViewModelFactory(getActivity());
        categoryViewEntity = ViewModelProviders.of(this, categoryViewEntityFactory).get(CategoryViewEntity.class);
        searchCategory();

        unitMeasurementViewEntityFactory = Injection.providerUnitMeasurementViewModelFactory(getActivity());
        unitMeasurementViewEntity = ViewModelProviders.of(this, unitMeasurementViewEntityFactory).get(UnitMeasurementViewEntity.class);
        searchUnitMeasurementPurchase();
        searchUnitMeasurement();

        photoProduct.setOnClickListener(v ->  {startActivityForResult(getPickImageChooserIntent(), IMAGE_RESULT);
            setpermission();
        });


        btnSave.setOnClickListener(v -> saveProduct());
        updateUid();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        final IntentFilter intentFilter = new IntentFilter();

        m_Broadcastname = "com.barcode.sendBroadcast";// com.barcode.sendBroadcastScan
        intentFilter.addAction(m_Broadcastname);
        getActivity().registerReceiver(receiver, intentFilter);
    }

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context arg0, Intent arg1) {
            if (arg1.getAction().equals(m_Broadcastname)) {
                String str = arg1.getStringExtra("BARCODE");
                if (!"".equals(str)) {
                    Barcodemode code = new Barcodemode();
                    code.setBarcode(str);
                    edtCode.setText(str);
                }
            }
        }
    };

    @Override
    public void onPause() {
        super.onPause();
        getActivity().unregisterReceiver(receiver);
    }

 /*   @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imagePathProduct = data.getData().toString();
            Picasso.get().load(imagePathProduct).into(imageProduct);
        }
    }*/

  /*  @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                Map<String, Integer> perms = new HashMap<>();
                perms.put(Manifest.permission.WRITE_EXTERNAL_STORAGE, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.READ_EXTERNAL_STORAGE, PackageManager.PERMISSION_GRANTED);
                for (int i = 0; i < permissions.length; i++) {
                    perms.put(permissions[i], grantResults[i]);
                }

                if (perms.get(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED ||
                        perms.get(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED ||
                        perms.get(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                ) {
                    cameraIntent();
                } else {
                    DialogUtils.showOkayDialog(getActivity(), "Request Permission", "Some Permission is Denied", "error");
                }

                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }*/

 /*   private boolean permissionCheck() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (getActivity().checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
                    getActivity().checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
            ) {

                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{
                                Manifest.permission.CAMERA,
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
    }*/

    //test metodos camara y galeria

    public void setpermission() {
        permissions.add(CAMERA);
        permissions.add(WRITE_EXTERNAL_STORAGE);
        permissions.add(READ_EXTERNAL_STORAGE);
        permissionsToRequest = findUnAskedPermissions(permissions);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (permissionsToRequest.size() > 0)
                requestPermissions(permissionsToRequest.toArray(new String[permissionsToRequest.size()]), ALL_PERMISSIONS_RESULT);
        }
    }

    private String getImageFromFilePath(Intent data) {
        boolean isCamera = data == null || data.getData() == null;

        if (isCamera) return getCaptureImageOutputUri().getPath();
        else return getPathFromURI(data.getData());
    }

    public String getImageFilePath(Intent data) {
        return getImageFromFilePath(data);
    }

    private String getPathFromURI(Uri contentUri) {
        String[] proj = {MediaStore.Audio.Media.DATA};
        Cursor cursor = getActivity().getContentResolver().query(contentUri, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }//this method obtains the path of the image

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putParcelable("pic_uri", path);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // get the file url
        if(path!= null) {
            path = savedInstanceState.getParcelable("pic_uri");
        }
    }

    private ArrayList<String> findUnAskedPermissions(ArrayList<String> wanted) {
        ArrayList<String> result = new ArrayList<String>();

        for (String perm : wanted) {
            if (!hasPermission(perm)) {
                result.add(perm);
            }
        }

        return result;
    }

    private boolean hasPermission(String permission) {
        if (canMakeSmores()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                return (getActivity().checkSelfPermission(permission)) == PackageManager.PERMISSION_GRANTED ;

            }
        }
        return true;
    }//Valid permits

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(getActivity())
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    } //Show message of intent chooser


    private boolean canMakeSmores() {
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        switch (requestCode) {

            case ALL_PERMISSIONS_RESULT:
                for (String perms : permissionsToRequest) {
                    if (!hasPermission(perms)) {
                        permissionsRejected.add(perms);
                    }
                }

                if (permissionsRejected.size() > 0) {


                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (shouldShowRequestPermissionRationale(permissionsRejected.get(0))) {
                            showMessageOKCancel("These permissions are mandatory for the application. Please allow access.",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {


                                                requestPermissions(permissionsRejected.toArray(new String[permissionsRejected.size()]), ALL_PERMISSIONS_RESULT);
                                            }
                                        }
                                    });
                            return;
                        }
                    }

                }
                break;
        }

    }

    public Intent getPickImageChooserIntent() {

        Uri outputFileUri = getCaptureImageOutputUri();

        List<Intent> allIntents = new ArrayList<>();
        PackageManager packageManager = getActivity().getPackageManager();

        Intent captureIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        List<ResolveInfo> listCam = packageManager.queryIntentActivities(captureIntent, 0);
        for (ResolveInfo res : listCam) {
            Intent intent = new Intent(captureIntent);
            intent.setComponent(new ComponentName(res.activityInfo.packageName, res.activityInfo.name));
            intent.setPackage(res.activityInfo.packageName);
            if (outputFileUri != null) {
                intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
            }
            allIntents.add(intent);
        }

        Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        List<ResolveInfo> listGallery = packageManager.queryIntentActivities(galleryIntent, 0);
        for (ResolveInfo res : listGallery) {
            Intent intent = new Intent(galleryIntent);
            intent.setComponent(new ComponentName(res.activityInfo.packageName, res.activityInfo.name));
            intent.setPackage(res.activityInfo.packageName);
            allIntents.add(intent);
        }

        Intent mainIntent = allIntents.get(allIntents.size() - 1);
        for (Intent intent : allIntents) {
            if (intent.getComponent().getClassName().equals("com.android.documentsui.DocumentsActivity")) {
                mainIntent = intent;
                break;
            }
        }
        allIntents.remove(mainIntent);

        Intent chooserIntent = Intent.createChooser(mainIntent, "Select source");
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, allIntents.toArray(new Parcelable[allIntents.size()]));

        return chooserIntent;
    }// method  you a choice between the camera or gallery

    private Uri getCaptureImageOutputUri() {
        Uri outputFileUri = null;
        File getImage = getActivity().getExternalFilesDir("");
        if (getImage != null) {
            outputFileUri = Uri.fromFile(new File(getImage.getPath(), "profile.png"));
        }
        return outputFileUri;
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            //profileImage = findViewById(R.id.profile_image);

            if (requestCode == IMAGE_RESULT) {
                imagePathProduct = getImageFilePath(data);
                if (imagePathProduct != null) {
                    Picasso.get().load(new File(imagePathProduct)).into(imageProduct);
                    path = Uri.parse(imagePathProduct);




                }
            }
        }

    }
}

// fin

