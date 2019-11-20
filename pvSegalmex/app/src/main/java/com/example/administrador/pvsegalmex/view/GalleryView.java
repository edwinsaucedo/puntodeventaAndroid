package com.example.administrador.pvsegalmex.view;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.AppCompatButton;
import android.widget.ImageView;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.utils.DialogUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GalleryView extends BaseView {

    @BindView(R.id.imvBackCrud)
    ImageView imvBackCrud;
    @BindView(R.id.imvImageViewer)
    ImageView imvImageViewer;
    @BindView(R.id.btnAddImage)
    AppCompatButton btnAddImage;
    @BindView(R.id.btnSave)
    FloatingActionButton btnSave;

    private String imagePath;
    private final int PERMISSION_REQUEST_CODE = 1001;
    private static final int PICK_IMAGE = 100;
    private String typePhoto = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_view);
        ButterKnife.bind(this);

        imvBackCrud.setOnClickListener(v -> onBackPressed());
        btnAddImage.setOnClickListener(v -> takePhoto());
        btnSave.setOnClickListener(v -> takePhotoEnd());
        Intent intent = getIntent();
        typePhoto = intent.getStringExtra("typePhoto");


    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private void takePhoto() {
        boolean result = permissionCheck();
        if (result)
            cameraIntent();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imagePath = data.getData().toString();
            imvImageViewer.setImageURI(Uri.parse(imagePath));
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                Map<String, Integer> perms = new HashMap<>();
                perms.put(Manifest.permission.CAMERA, PackageManager.PERMISSION_GRANTED);
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
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ||
                    checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
                    checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
            ) {

                ActivityCompat.requestPermissions(GalleryView.this,
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

    private void cameraIntent() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    private void takePhotoEnd() {

        Intent returnIntent = new Intent();
        returnIntent.putExtra("imagePath", imagePath);
        returnIntent.putExtra("typePhoto", typePhoto);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();

    }

}