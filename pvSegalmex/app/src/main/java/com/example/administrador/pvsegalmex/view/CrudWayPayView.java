package com.example.administrador.pvsegalmex.view;

import android.Manifest;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.pm.PackageManager;
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
import com.example.administrador.pvsegalmex.entity.WayPayEntity;
import com.example.administrador.pvsegalmex.utils.DialogUtils;
import com.example.administrador.pvsegalmex.viewEntity.WayPayViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.WayPayViewEntityFactory;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class CrudWayPayView extends MenuView {
    private EditText edtWayPayDescriptionCrud;
    private ImageView imvImage, imvTakeImage;
    private CompositeDisposable compositeDisposable;
    WayPayViewEntityFactory wayPayFactory;
    private WayPayViewEntity wayPayViewEntity;
    private String imagePath;
    private final int PERMISSION_REQUEST_CODE = 1001;
    private static final int PICK_IMAGE = 100;
    private Uri imageWayPayEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        AppCompatButton btnSave;

        edtWayPayDescriptionCrud = findViewById(R.id.edtWayPayDescriptionCrud);

        imvImage = findViewById(R.id.imvImageWayPay);
        imvTakeImage = findViewById(R.id.imvTakePhoto);

        btnSave = findViewById(R.id.btnSaveWayPay);

        imvTakeImage.setOnClickListener(v -> takePhoto());

        compositeDisposable = new CompositeDisposable();
        wayPayFactory = Injection.providerWayPayViewModelFactory(getApplicationContext());
        wayPayViewEntity = ViewModelProviders.of(this, wayPayFactory).get(WayPayViewEntity.class);

        btnSave.setOnClickListener(v -> saveWayPay());
        updateUid();
    }

    @Override
    protected int getPageLayoutId() {
        return R.layout.activity_crud_way_pay_view;
    }

    @Override
    protected String getScreenTitle() {
        return getString(R.string.pageTitleWayPay);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imagePath = data.getData().toString();
            imvImage.setImageURI(Uri.parse(imagePath));
        }
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
                ActivityCompat.requestPermissions(CrudWayPayView.this,
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
    }

    private void updateUid() {
        String description = WayPayEntity.instance.getDescription();
        edtWayPayDescriptionCrud.setText(description);

        updatePhotos();
    }

    private void updatePhotos() {
        try {
            if (WayPayEntity.instance.getImage().isEmpty() || WayPayEntity.instance.getImage() == "" || WayPayEntity.instance.getImage() == null) {
                imvImage.setImageURI(null);
            } else {
                Picasso.get().load(WayPayEntity.instance.getImage()).into(imvImage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveWayPay() {
        if (edtWayPayDescriptionCrud.getText().toString().isEmpty()) {
            edtWayPayDescriptionCrud.setError(getString(R.string.fieldRequired));
            return;
        }
        if (imvImage.getDrawable() == null) {
            imvImage.setImageResource(R.drawable.advertencia);
        }

        WayPayEntity wayPay = new WayPayEntity();
        wayPay.setDescription(edtWayPayDescriptionCrud.getText().toString().trim().toUpperCase());
        if (imagePath == null) {
            imageWayPayEmpty = Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.sinproducto);
            wayPay.setImage(String.valueOf(imageWayPayEmpty));
        } else {
            wayPay.setImage(imagePath);
        }

        if (WayPayEntity.instance.getId() == -1)
            insertWayPay(wayPay);
        else {
            wayPay.setId(WayPayEntity.instance.getId());
            updateWayPay(wayPay);
        }
    }

    private void insertWayPay(WayPayEntity wayPay) {
        compositeDisposable.add(wayPayViewEntity.insertWayPay(wayPay)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (WayPayEntity.instance.getId() != -1)
                        this.finish();
                    else {
                        Toast.makeText(getApplicationContext(), getString(R.string.ocurrioError), Toast.LENGTH_LONG).show();
                    }
                })
        );
    }

    private void updateWayPay(WayPayEntity wayPay) {
        compositeDisposable.add(wayPayViewEntity.updateWayPay(wayPay)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::finish)
        );
    }
}