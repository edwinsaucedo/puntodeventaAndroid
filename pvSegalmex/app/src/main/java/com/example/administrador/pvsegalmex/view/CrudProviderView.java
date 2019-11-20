package com.example.administrador.pvsegalmex.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.entity.BitacoraEntity;
import com.example.administrador.pvsegalmex.entity.ProviderEntity;
import com.example.administrador.pvsegalmex.viewEntity.BitacoraViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.ProviderViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.BitacoraViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.ProviderViewEntityFactory;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CrudProviderView extends MenuView {
    //region VARS
    private CompositeDisposable compositeDisposable;
    private ProviderViewEntity providerViewEntity;
    ProviderViewEntityFactory providerFactory;

    //region BINNACLE
    private BitacoraViewEntity bitacoraViewEntity;
    BitacoraViewEntityFactory bitacoraViewEntityFactory;
    private ArrayList<BitacoraEntity> bitacoraListProvider;
    //endregion
    private Integer idProvider;
    //endregion

    //region VIEWS
    private EditText edtProviderName, edtProviderRfc, edtProviderDatePay, edtProviderAlias, edtProviderCurp, edtProviderPhone, edtProviderEmail, edtProviderComments, edtProviderCreditLimit, edtProviderCreditDays;
    private AppCompatCheckBox chboxDiconsa;
    private AppCompatButton btnProviderSave;
    //endregion

    //region PRIVATE METHODS
    private void initializeViews() {
        edtProviderName = findViewById(R.id.edtProviderName);
        edtProviderRfc = findViewById(R.id.edtProviderRfc);
        edtProviderDatePay = findViewById(R.id.edtProviderDatePay);
        edtProviderAlias = findViewById(R.id.edtProviderAlias);
        edtProviderCurp = findViewById(R.id.edtProviderCurp);
        edtProviderPhone = findViewById(R.id.edtProviderPhone);
        edtProviderEmail = findViewById(R.id.edtProviderEmail);
        edtProviderComments = findViewById(R.id.edtProviderComments);
        edtProviderCreditLimit = findViewById(R.id.edtProviderCreditLimit);
        edtProviderCreditDays = findViewById(R.id.edtProviderCreditDays);
        chboxDiconsa = findViewById(R.id.chboxDiconsa);
        btnProviderSave = findViewById(R.id.btnSaveProvider);
    }

    //region BINNACLE
    private void clearProvider() {
        String tableProvider;
        String t = "Proveedores";
        for (int i = 0; i < bitacoraListProvider.size(); i++) {
            tableProvider = bitacoraListProvider.get(i).getTable();
            if (t.equals(tableProvider)) {
                idProvider = bitacoraListProvider.get(i).getId();
            }
        }
        if (idProvider == null) {
            BitacoraEntity.instance.clear();
        }
    }

    private void saveBinnacle() {
        try {
            BitacoraEntity bitacoraEntity = new BitacoraEntity();
            bitacoraEntity.setDate(getDate());
            bitacoraEntity.setTable("Proveedores");
            bitacoraEntity.setIdTable(ProviderEntity.instance.getId());

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

    private void searchBitacora() {
        compositeDisposable.add(bitacoraViewEntity.getFilterBitacora()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<BitacoraEntity>>) bitacoraListSearch -> {
                            bitacoraListProvider = (ArrayList<BitacoraEntity>) bitacoraListSearch;
                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), getString(R.string.errorConsulta), Toast.LENGTH_LONG).show();
                            Log.e(getString(R.string.errorSQLITE), "");
                        }
                )
        );
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

    private void saveProvider() {
        clearProvider();
        if (edtProviderName.getText().toString().isEmpty()) {
            edtProviderName.setError(getString(R.string.fieldRequired));
            return;
        }
        if (edtProviderAlias.getText().toString().isEmpty()) {
            edtProviderAlias.setError(getString(R.string.fieldRequired));
            return;
        }
        if (edtProviderCreditDays.getText().toString().isEmpty()) {
            edtProviderCreditDays.setText("0");
            return;
        }
        if (edtProviderCreditLimit.getText().toString().isEmpty()) {
            edtProviderCreditLimit.setText("0.0");
            return;
        }
        ProviderEntity provider = new ProviderEntity();
        provider.setName(edtProviderName.getText().toString().trim().toUpperCase());
        provider.setAlias(edtProviderAlias.getText().toString().trim().toUpperCase());
        provider.setRfc(edtProviderRfc.getText().toString().trim().toUpperCase());
        provider.setCurp(edtProviderCurp.getText().toString().trim().toUpperCase());
        provider.setDatePay(edtProviderDatePay.getText().toString().trim().toUpperCase());
        provider.setPhone(edtProviderPhone.getText().toString().trim().toUpperCase());
        provider.setEmail(edtProviderEmail.getText().toString().trim().toUpperCase());
        provider.setComments(edtProviderComments.getText().toString().trim().toUpperCase());
        provider.setCreditLimit(Double.parseDouble(edtProviderCreditLimit.getText().toString().trim()));
        provider.setCreditDays(Integer.parseInt(edtProviderCreditDays.getText().toString().trim()));
        provider.setUuid(generateUUID());
        provider.setDate(getDate());
        if (chboxDiconsa.isChecked()) {
            provider.setDiconsa(true);
        } else if (!chboxDiconsa.isChecked()) {
            provider.setDiconsa(false);
        }

        if (ProviderEntity.instance.getId() == -1) {
            insertProvider(provider);
        } else {
            provider.setId(ProviderEntity.instance.getId());
            updateProvider(provider);
        }
    }

    private void updateUid() {
        edtProviderName.setText(ProviderEntity.instance.getName());
        edtProviderAlias.setText(ProviderEntity.instance.getAlias());
        edtProviderRfc.setText(ProviderEntity.instance.getRfc());
        edtProviderEmail.setText(ProviderEntity.instance.getEmail());
        edtProviderCurp.setText(ProviderEntity.instance.getCurp());
        edtProviderPhone.setText(ProviderEntity.instance.getPhone());
        edtProviderComments.setText(ProviderEntity.instance.getComments());
        edtProviderDatePay.setText(ProviderEntity.instance.getDatePay());
        edtProviderCreditLimit.setText(String.valueOf(ProviderEntity.instance.getCreditLimit()));
        edtProviderCreditDays.setText(String.valueOf(ProviderEntity.instance.getCreditDays()));
        if (ProviderEntity.instance.isDiconsa()) {
            chboxDiconsa.setChecked(true);
        } else if (!ProviderEntity.instance.isDiconsa()) {
            chboxDiconsa.setChecked(false);
        }
    }

    private void insertProvider(ProviderEntity provider) {
        compositeDisposable.add(providerViewEntity.insertProvider(provider)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (ProviderEntity.instance.getId() != -1) {
                        saveBinnacle();
                        this.finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Ha ocurrido un error.", Toast.LENGTH_LONG).show();
                    }
                })
        );
    }

    private void updateProvider(ProviderEntity provider) {
        compositeDisposable.add(providerViewEntity.updateProvider(provider)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (ProviderEntity.instance.getId() != -1) {
                        saveBinnacle();
                        this.finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Ha ocurrido un error.", Toast.LENGTH_LONG).show();
                    }
                })
        );
    }
    //endregion

    //region PROTECTED METHODS
    @Override
    protected int getPageLayoutId() {
        return R.layout.activity_crud_provider_view;
    }

    @Override
    protected String getScreenTitle() {
        return getString(R.string.pageTitleSupplier);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeViews();
        compositeDisposable = new CompositeDisposable();
        bitacoraViewEntityFactory = Injection.providerBitacoraViewModelFactory(getApplicationContext());
        bitacoraViewEntity = ViewModelProviders.of(this, bitacoraViewEntityFactory).get(BitacoraViewEntity.class);
        searchBitacora();
        providerFactory = Injection.providerProviderViewModelFactory(getApplicationContext());
        providerViewEntity = ViewModelProviders.of(this, providerFactory).get(ProviderViewEntity.class);
        btnProviderSave.setOnClickListener(v -> saveProvider());
        updateUid();
    }
    //endregion
}
