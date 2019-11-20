package com.example.administrador.pvsegalmex.view;

import android.Manifest;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.AppCompatButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.entity.StoreEntity;
import com.example.administrador.pvsegalmex.utils.DialogUtils;
import com.example.administrador.pvsegalmex.viewEntity.StoreViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.StoreViewEntityFactory;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class EditStoreView extends MenuView {

    //region VARS
    private CompositeDisposable compositeDisposable;
    private StoreViewEntity storeViewEntity;
    StoreViewEntityFactory storeViewEntityFactory;
    //endregion

    //region VIEWS
    private EditText edtNameOwner, edtPhoneOwner, edtStoreName, edtAddressStore;
    private AppCompatButton btnSaveStore;
    private String imagePath, imageLocal;
    Uri localimage;
    private final int PERMISSION_REQUEST_CODE = 1001;
    private static final int PICK_IMAGE = 100;
    ImageView imvImage, imvStore;
    //endregion

    //region PRIVATE METHODS
    private void inizializateViews() {
        edtNameOwner = findViewById(R.id.edtNameOwner);
        edtAddressStore = findViewById(R.id.edtDirectionStore);
        edtStoreName = findViewById(R.id.edtNameStore);
        imvImage = findViewById(R.id.imvTakeImage);
        imvStore = findViewById(R.id.imvImageStore);
        edtPhoneOwner = findViewById(R.id.edtPhoneOwner);
        btnSaveStore = findViewById(R.id.btnSaveStore);
    }

    private void updateUid() {
        edtAddressStore.setText(StoreEntity.instance.getDirection());
        edtPhoneOwner.setText(StoreEntity.instance.getPhonenumber());
        edtStoreName.setText(StoreEntity.instance.getStoreName());

        edtNameOwner.setText(String.valueOf(StoreEntity.instance.getStoreName()));
        if (StoreEntity.instance.getImage() == null || StoreEntity.instance.getImage().isEmpty()) {
            imvStore.setImageURI(null);
        } else {
            Picasso.get().load(StoreEntity.instance.getImage()).into(imvStore);
        }
    }

    private void saveStore() {
        if (edtNameOwner.getText().toString().isEmpty()) {
            edtNameOwner.setError(getString(R.string.fieldRequired));
            return;
        }

        if (edtPhoneOwner.getText().toString().isEmpty()) {
            edtPhoneOwner.setError(getString(R.string.fieldRequired));
            return;
        }
        if (edtStoreName.getText().toString().isEmpty()) {
            edtStoreName.setError(getString(R.string.fieldRequired));
            return;
        }


        if (edtAddressStore.getText().toString().isEmpty()) {
            edtAddressStore.setError(getString(R.string.fieldRequired));
            return;
        }

        if (imvStore.getDrawable() == null) {
            imvStore.setImageResource(R.drawable.advertencia);
        }

        StoreEntity store = new StoreEntity();
        store.setOwner(edtNameOwner.getText().toString().trim());
        store.setPhonenumber(edtPhoneOwner.getText().toString().trim());
        store.setDirection(edtAddressStore.getText().toString().trim());
        store.setStoreName(edtStoreName.getText().toString().trim());
        store.setLocalDirection(imageLocal);
        store.setImage(imagePath);

        if (StoreEntity.instance.getId() == -1) {
            insertStore(store);
        } else {
            store.setId(StoreEntity.instance.getId());
            updateStore(store);
        }
    }

    private void insertStore(StoreEntity store) {
        compositeDisposable.add(storeViewEntity.insertStore(store)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (StoreEntity.instance.getId() != -1) {
                        this.finish();
                    } else {
                        Toast.makeText(getApplicationContext(), getString(R.string.ocurrioError), Toast.LENGTH_LONG).show();
                    }
                })
        );
    }

    private void updateStore(StoreEntity store) {
        compositeDisposable.add(storeViewEntity.updateStore(store)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (StoreEntity.instance.getId() != -1)
                        this.finish();
                    else {
                        Toast.makeText(getApplicationContext(), getString(R.string.ocurrioError), Toast.LENGTH_LONG).show();
                    }
                })
        );
    }
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        inizializateViews();

        compositeDisposable = new CompositeDisposable();

        storeViewEntityFactory = Injection.providerStoreViewModelFactory(getApplicationContext());
        storeViewEntity = ViewModelProviders.of(this, storeViewEntityFactory).get(StoreViewEntity.class);

        imvImage.setOnClickListener(v -> takePhoto());

        btnSaveStore.setOnClickListener(v -> saveStore());

        updateUid();
    }

    @Override
    protected int getPageLayoutId() {
        return R.layout.activity_edit_store_view;
    }

    @Override
    protected String getScreenTitle() {
        return getString(R.string.itemMenu13);
    }

    //region Gallery

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imagePath = data.getData().toString();
            imvStore.setImageURI(Uri.parse(imagePath));
            localimage = data.getData();
            imageLocal = getRealPathFromURI(localimage);
        }
    }

    public String getRealPathFromURI(Uri uri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        @SuppressWarnings("deprecation") Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }


    private void cameraIntent() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    private void takePhoto() {
        boolean result = permissionCheck();
        if (result)
            cameraIntent();
    }

    @Override
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
                    DialogUtils.showOkayDialog(this, "Request Permission", "Some Permission is Denied", "error");
                }

                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private boolean permissionCheck() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
                    checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
            ) {

                ActivityCompat.requestPermissions(EditStoreView.this,
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
    }//endregion
}
