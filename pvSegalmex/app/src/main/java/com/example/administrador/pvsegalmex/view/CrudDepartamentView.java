package com.example.administrador.pvsegalmex.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.entity.DepartmentEntity;
import com.example.administrador.pvsegalmex.viewEntity.DepartmentViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.DepartmentViewEntityFactory;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class CrudDepartamentView extends MenuView {

    //region VARS
    private CompositeDisposable compositeDisposable;
    private DepartmentViewEntity departmentViewEntity;
    DepartmentViewEntityFactory departmentViewEntityFactory;
    ///endregion

    //region VIEWS
    private EditText edtDepartamentDescription;
    private AppCompatButton btnSaveDepartament;
    //endregion

    //region PRIVATE METHODS
    private void inizialiteViews() {
        edtDepartamentDescription = findViewById(R.id.edtDepartamentDescription);
        btnSaveDepartament = findViewById(R.id.btnSaveDepartament);
    }

    private void updateUid() {
        edtDepartamentDescription.setText(DepartmentEntity.instance.getDescription());
    }

    private void saveDepartament() {
        if (edtDepartamentDescription.getText().toString().isEmpty()) {
            edtDepartamentDescription.setError(getString(R.string.fieldRequired));
            return;
        }
        DepartmentEntity department = new DepartmentEntity();
        department.setDescription(edtDepartamentDescription.getText().toString().trim().toUpperCase());
        if (DepartmentEntity.instance.getId() == -1) {
            insertDepartament(department);

        } else {
            department.setId(DepartmentEntity.instance.getId());
            updateDepartament(department);
        }
    }

    private void insertDepartament(DepartmentEntity department) {
        compositeDisposable.add(departmentViewEntity.insertDepartamento(department)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (DepartmentEntity.instance.getId() != -1) {
                        this.finish();
                    } else {
                        Toast.makeText(getApplicationContext(), getString(R.string.ocurrioError), Toast.LENGTH_LONG).show();
                    }
                })
        );
    }

    private void updateDepartament(DepartmentEntity department) {
        compositeDisposable.add(departmentViewEntity.updateDepartamento(department)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (DepartmentEntity.instance.getId() != -1)
                        this.finish();
                    else {
                        Toast.makeText(getApplicationContext(), getString(R.string.ocurrioError), Toast.LENGTH_LONG).show();
                    }
                })
        );
    }
    //endregion


    //region PROTECTED METHODS
    //endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inizialiteViews();
        compositeDisposable = new CompositeDisposable();
        departmentViewEntityFactory = Injection.providerDepartamentoViewModelFactory(getApplicationContext());
        departmentViewEntity = ViewModelProviders.of(this, departmentViewEntityFactory).get(DepartmentViewEntity.class);
        btnSaveDepartament.setOnClickListener(v -> saveDepartament());
        updateUid();
    }

    @Override
    protected int getPageLayoutId() {
        return R.layout.activity_crud_departament_view;
    }

    @Override
    protected String getScreenTitle() {
        return getString(R.string.itemMenu4);
    }

}
