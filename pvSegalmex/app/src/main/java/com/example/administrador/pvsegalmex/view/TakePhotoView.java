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
import android.support.v4.content.FileProvider;
import android.support.v7.widget.AppCompatButton;
import android.widget.ImageView;

import com.example.administrador.pvsegalmex.BuildConfig;
import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.utils.DialogUtils;
import com.example.administrador.pvsegalmex.utils.Functions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TakePhotoView extends BaseView {

    @BindView(R.id.imvBack)
    ImageView imvBack;
    @BindView(R.id.imvPhotoViewer)
    ImageView imvPhotoViewer;
    @BindView(R.id.btnTakePhoto)
    AppCompatButton btnTakePhoto;
    @BindView(R.id.btnDone)
    FloatingActionButton btnDone;

    private File imageSaveFile;
    private String imagePath = "";
    private int REQUEST_CAMERA = 0;
    private final int PERMISSION_REQUEST_CODE = 1001;
    private String typePhoto = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_photo_view);
        ButterKnife.bind(this);

        imvBack.setOnClickListener(v -> onBackPressed());
        btnTakePhoto.setOnClickListener(v -> takePhoto());
        btnDone.setOnClickListener(v -> takePhotoEnd());
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
        imagePath = Functions.getCameraTempFilePath(imageSaveFile.getName());
        if (resultCode != RESULT_OK) return;
        if (requestCode == REQUEST_CAMERA) {
            imvPhotoViewer.setImageBitmap(Functions.getSafeDecodeBitmap(imagePath, 1000));
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

                ActivityCompat.requestPermissions(TakePhotoView.this,
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
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        imageSaveFile = Functions.getCameraTempFile("");
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT_WATCH)
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imageSaveFile));  //gradle targetSDKVersion 20
        else
            intent.putExtra(MediaStore.EXTRA_OUTPUT, FileProvider.getUriForFile(getApplicationContext(), BuildConfig.APPLICATION_ID + ".provider", imageSaveFile));
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    private void takePhotoEnd() {
        if (!Functions.isEmpty(imagePath)) {
            Intent returnIntent = new Intent();
            returnIntent.putExtra("imagePath", imagePath);
            returnIntent.putExtra("typePhoto", typePhoto);
            setResult(Activity.RESULT_OK, returnIntent);
            finish();
        }
    }
}
