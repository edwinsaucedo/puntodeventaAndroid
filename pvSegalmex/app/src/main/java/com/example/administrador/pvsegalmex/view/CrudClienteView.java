package com.example.administrador.pvsegalmex.view;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.adapter.SimpleSpinnerGenderAdapter;
import com.example.administrador.pvsegalmex.entity.BitacoraEntity;
import com.example.administrador.pvsegalmex.entity.ClienteEntity;
import com.example.administrador.pvsegalmex.utils.Functions;
import com.example.administrador.pvsegalmex.viewEntity.BitacoraViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.ClienteViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.BitacoraViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.ClienteViewEntityFactory;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CrudClienteView extends MenuView {

    //region VARS
    private CompositeDisposable compositeDisposable;
    ClienteViewEntityFactory clientFactory;
    private ClienteViewEntity clientViewEntity;
    private int REQUEST_CODE_ADD_PHOTO = 1001;
    private String typePhoto, imagePathClient = "", imagePathIne = "";
    private String[] listGenre;
    private Integer idClient;
    //endregion

    //region BINNACLE
    private BitacoraViewEntity bitacoraViewEntity;
    BitacoraViewEntityFactory bitacoraViewEntityFactory;
    private ArrayList<BitacoraEntity> bitacoraListClient;
    //endregion

    //region VIEWS
    private AppCompatButton btnSave;
    private AppCompatSpinner spGenre;
    private EditText edtClientName, edtLastName1, edtLastName2, edtCurp, edtAddress, edtPhone, edtEmail, edtCreditDays, edtCreditLimit, edtIneString;
    private ImageView imvClientPhoto, imvInePhoto, imvTakePhoto1, imvTakePhoto2;
    //endregion

    //region PRIVATE METHODS
    private void inizialite() {
        spGenre = findViewById(R.id.spGenre);
        edtClientName = findViewById(R.id.edtClientName);
        edtLastName1 = findViewById(R.id.edtClientLastName1);
        edtLastName2 = findViewById(R.id.edtClientLastName2);
        edtCurp = findViewById(R.id.edtClientCurp);
        edtAddress = findViewById(R.id.edtAddress);
        edtPhone = findViewById(R.id.edtPhone);
        edtEmail = findViewById(R.id.edtMail);
        edtCreditDays = findViewById(R.id.edtCreditDays);
        edtCreditLimit = findViewById(R.id.edtCreditLimit);
        edtIneString = findViewById(R.id.edtIneString);
        imvClientPhoto = findViewById(R.id.imvClientPhoto);
        imvInePhoto = findViewById(R.id.imvInePhoto);
        imvTakePhoto1 = findViewById(R.id.imvTakePhoto1);
        imvTakePhoto2 = findViewById(R.id.imvTakePhoto2);
        btnSave = findViewById(R.id.btnSave);
    }

    //region BINNACLE
    private void saveBinnacle() {
        try {
            BitacoraEntity bitacoraEntity = new BitacoraEntity();
            java.util.Date utilDate = new java.util.Date();

            Calendar cal = Calendar.getInstance(); // locale-specific
            cal.setTime(utilDate);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            long time = cal.getTimeInMillis();

            java.sql.Timestamp sqlTimestamp = new Timestamp(time);
            bitacoraEntity.setDate(String.valueOf(sqlTimestamp));
            bitacoraEntity.setTable("Cliente");
            bitacoraEntity.setIdTable(ClienteEntity.instance.getId());

            if (BitacoraEntity.instance.getId() == -1) {
                insertBinnacle(bitacoraEntity);
            } else {
                bitacoraEntity.setId(BitacoraEntity.instance.getId());
                updateBinnacle(bitacoraEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void insertBinnacle(BitacoraEntity bitacoraEntity) {
        compositeDisposable.add(bitacoraViewEntity.insertBitacora(bitacoraEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                })
        );
    }

    private void updateBinnacle(BitacoraEntity bitacoraEntity) {
        compositeDisposable.add(bitacoraViewEntity.updateBitacora(bitacoraEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                })
        );
    }

    //endregion

    private void updateUid() {
        int i = 0;
        for (String genre : listGenre) {
            if (genre.charAt(0) == ClienteEntity.instance.getGenre()) {
                spGenre.setSelection(i);
                break;
            } else if (i == listGenre.length - 1) {
                spGenre.setSelection(0);
            }
            i++;
        }
        edtClientName.setText(ClienteEntity.instance.getName());
        edtLastName1.setText(ClienteEntity.instance.getLastName1());
        edtLastName2.setText(ClienteEntity.instance.getLastName2());
        edtCurp.setText(ClienteEntity.instance.getCurp());
        edtAddress.setText(ClienteEntity.instance.getAddress());
        edtPhone.setText(ClienteEntity.instance.getPhone());
        edtEmail.setText(ClienteEntity.instance.getMail());
        edtCreditDays.setText(String.valueOf(ClienteEntity.instance.getCreditDays()));
        edtCreditLimit.setText(String.valueOf(ClienteEntity.instance.getCreditLimit()));
        edtIneString.setText(String.valueOf(ClienteEntity.instance.getIneString()));
        updatePhotos();
    }

    private void updatePhotos() {
        Bitmap bmIne, bmClient;
        if (ClienteEntity.instance.getPhotoIne() != null && !ClienteEntity.instance.getPhotoIne().isEmpty()) {
            imagePathIne = ClienteEntity.instance.getPhotoIne();
            bmIne = Functions.getSafeDecodeBitmap(imagePathIne, 1000);
            imvInePhoto.setImageBitmap(bmIne);
        }
        if (ClienteEntity.instance.getPhotoClient() != null && !ClienteEntity.instance.getPhotoClient().isEmpty()) {
            imagePathClient = ClienteEntity.instance.getPhotoClient();
            bmClient = Functions.getSafeDecodeBitmap(imagePathClient, 1000);
            imvClientPhoto.setImageBitmap(bmClient);
        }
    }

    private void saveClient() {
        String genreAux;
        clearClient();
        char genre;
        if (edtClientName.getText().toString().isEmpty()) {
            edtClientName.setError(getString(R.string.fieldRequired));
            return;
        }
        if (edtLastName1.getText().toString().isEmpty()) {
            edtLastName1.setError(getString(R.string.fieldRequired));
            return;
        }
        if (edtLastName2.getText().toString().isEmpty()) {
            edtLastName2.setError(getString(R.string.fieldRequired));
            return;
        }
        String uuid = generateUUID();
        genreAux = spGenre.getSelectedItem().toString();
        genre = (genreAux.equals("Select:") || genreAux.equals("Selecciona:")) ? ' ' : genreAux.charAt(0);
        ClienteEntity client = new ClienteEntity();
        client.setName(edtClientName.getText().toString().trim().toUpperCase());
        client.setLastName1(edtLastName1.getText().toString().trim().toUpperCase());
        client.setLastName2(edtLastName2.getText().toString().trim().toUpperCase());
        client.setCurp(edtCurp.getText().toString().toUpperCase().trim().toUpperCase());
        client.setAddress(edtAddress.getText().toString().trim().toUpperCase());
        client.setPhone(edtPhone.getText().toString().trim().toUpperCase());
        client.setMail(edtEmail.getText().toString().trim());
        client.setCreditDays(Integer.parseInt(edtCreditDays.getText().toString().trim()));
        client.setCreditLimit(Double.parseDouble(edtCreditLimit.getText().toString().trim()));
        client.setPhotoClient(imagePathClient);
        client.setPhotoIne(imagePathIne);
        client.setUuid(uuid);
        client.setGenre(genre);
        client.setDate(getDate());
        if (ClienteEntity.instance.getId() == -1)
            insertClient(client);
        else {
            client.setId(ClienteEntity.instance.getId());
            updateClient(client);
        }
    }

    private void insertClient(ClienteEntity client) {
        compositeDisposable.add(clientViewEntity.insertClient(client)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (ClienteEntity.instance.getId() != -1) {
                        saveBinnacle();
                        this.finish();
                    } else {
                        Toast.makeText(getApplicationContext(), getString(R.string.ocurrioError), Toast.LENGTH_LONG).show();
                    }
                })
        );
    }

    private void updateClient(ClienteEntity client) {
        compositeDisposable.add(clientViewEntity.updateClient(client)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (ClienteEntity.instance.getId() != -1) {
                        //saveBinnacle();
                        this.finish();
                    } else {
                        Toast.makeText(getApplicationContext(), getString(R.string.ocurrioError), Toast.LENGTH_LONG).show();
                    }
                })
        );
    }

    private void clearClient() {
        String tableClient;
        String t = "Cliente";
        for (int i = 0; i < bitacoraListClient.size(); i++) {
            tableClient = bitacoraListClient.get(i).getTable();
            if (t.equals(tableClient)) {
                idClient = bitacoraListClient.get(i).getId();
            }
        }
        if (idClient == null) {
            BitacoraEntity.instance.clear();
        }
    }

    @SuppressWarnings("unchecked")
    private void searchBitacora() {
        compositeDisposable.add(bitacoraViewEntity.getFilterBitacora()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<BitacoraEntity>>) bitacoraListSearch -> bitacoraListClient = (ArrayList<BitacoraEntity>) bitacoraListSearch, throwable -> {
                            Toast.makeText(getApplicationContext(), getString(R.string.errorConsulta), Toast.LENGTH_LONG).show();
                            Log.e(getString(R.string.errorSQLITE), "");
                        }
                )
        );
    }
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SimpleSpinnerGenderAdapter spAdapter;
        inizialite();

        imvTakePhoto1.setOnClickListener(v -> {
            typePhoto = "client";
            startActivityForResult(new Intent(CrudClienteView.this, TakePhotoView.class).putExtra("typePhoto", typePhoto), REQUEST_CODE_ADD_PHOTO);
        });
        imvTakePhoto2.setOnClickListener(v -> {
            typePhoto = "ine";
            startActivityForResult(new Intent(CrudClienteView.this, TakePhotoView.class).putExtra("typePhoto", typePhoto), REQUEST_CODE_ADD_PHOTO);
        });
        compositeDisposable = new CompositeDisposable();
        clientFactory = Injection.providerClientViewModelFactory(getApplicationContext());
        clientViewEntity = ViewModelProviders.of(this, clientFactory).get(ClienteViewEntity.class);

        listGenre = getResources().getStringArray(R.array.genres);
        spAdapter = new SimpleSpinnerGenderAdapter(this, R.array.genres, listGenre);
        spGenre.setAdapter(spAdapter);
        btnSave.setOnClickListener(v -> saveClient());
        updateUid();

        bitacoraViewEntityFactory = Injection.providerBitacoraViewModelFactory(getApplicationContext());
        bitacoraViewEntity = ViewModelProviders.of(this, bitacoraViewEntityFactory).get(BitacoraViewEntity.class);
        searchBitacora();
    }

    @Override
    protected int getPageLayoutId() {
        return R.layout.activity_crud_cliente_view;
    }

    @Override
    protected String getScreenTitle() {
        return getString(R.string.pageTitle);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_ADD_PHOTO && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                if (data.getStringExtra("typePhoto").equals("client"))
                    imagePathClient = data.getStringExtra("imagePath");
                else
                    imagePathIne = data.getStringExtra("imagePath");
                typePhoto = data.getStringExtra("typePhoto");
            }
            if (typePhoto.equals("client")) {
                imvClientPhoto.setImageBitmap(Functions.getSafeDecodeBitmap(imagePathClient, 1000));
            } else
                imvInePhoto.setImageBitmap(Functions.getSafeDecodeBitmap(imagePathIne, 1000));
        }
    }

}
