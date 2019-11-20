package com.example.administrador.pvsegalmex.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.adapter.RvCDSpinnerAdapter;
import com.example.administrador.pvsegalmex.entity.CategoryEntity;
import com.example.administrador.pvsegalmex.entity.DepartmentEntity;
import com.example.administrador.pvsegalmex.utils.DialogUtils;
import com.example.administrador.pvsegalmex.viewEntity.CategoryViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.DepartmentViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.CategoryViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.DepartmentViewEntityFactory;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CrudCategoryView extends MenuView {

    //region VARS
    private ArrayList<DepartmentEntity> departmentList;
    private RvCDSpinnerAdapter rvCDSpinnerAdapter;
    private CompositeDisposable compositeDisposable;
    private CategoryViewEntity categoryViewEntity;
    private DepartmentViewEntity departmentViewEntity;
    CategoryViewEntityFactory categoryViewEntityFactory;
    DepartmentViewEntityFactory departmentViewEntityFactory;
    //endregion

    //region VIEWS
    private AppCompatSpinner spDepartments;
    private EditText edtCategoryDescription;
    private AppCompatButton btnSaveCategory;
    //endregion

    //region PRIVATE METHODS
    private void inizializateViews() {
        departmentList = new ArrayList<>();
        edtCategoryDescription = findViewById(R.id.edtCatDescription);
        btnSaveCategory = findViewById(R.id.btnSaveCategory);
        spDepartments = findViewById(R.id.spDepartment);
    }

    private void updateUid() {
        int i = 0;
        for (DepartmentEntity department : departmentList) {
            if (department.getId().equals(CategoryEntity.instance.getDepartment())) {
                spDepartments.setSelection(i);
                break;
            } else if (i == departmentList.size() - 1) {
                spDepartments.setAdapter(rvCDSpinnerAdapter);
            }
            i++;
        }
        edtCategoryDescription.setText(CategoryEntity.instance.getDescription());
    }

    private void saveCategory() {
        if (edtCategoryDescription.getText().toString().isEmpty()) {
            edtCategoryDescription.setError(getString(R.string.fieldRequired));
            return;
        }
        if (departmentList.size() < 1) {
            DialogUtils.showOkayNoDialog(getString(R.string.askDepartment), getString(R.string.departmentWarning), this, new DialogUtils.OnOkayNoEvent() {
                @Override
                public void onYes() {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), DepartmentView.class);
                    startActivity(intent);
                }

                @Override
                public void onNo() {
                }
            });
            return;
        }
        CategoryEntity category = new CategoryEntity();
        category.setDescription(edtCategoryDescription.getText().toString().trim().toUpperCase());
        category.setDepartment((int) rvCDSpinnerAdapter.getItemId(spDepartments.getSelectedItemPosition()));
        if (CategoryEntity.instance.getId() == -1) {
            insertCategory(category);
        } else {
            category.setId(CategoryEntity.instance.getId());
            updateCategory(category);
        }
    }

    @SuppressWarnings("unchecked")
    private void searchDepartment() {
        compositeDisposable.add(departmentViewEntity.getFilterCategory()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<DepartmentEntity>>) departmentListSearch -> {
                            departmentList = (ArrayList<DepartmentEntity>) departmentListSearch;
                            if (departmentList.isEmpty())
                                Toast.makeText(getApplicationContext(), getString(R.string.noHayRegistros), Toast.LENGTH_SHORT).show();
                            rvCDSpinnerAdapter = new RvCDSpinnerAdapter(departmentList, getApplicationContext());
                            spDepartments.setAdapter(rvCDSpinnerAdapter);
                            updateUid();
                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), getString(R.string.errorConsulta), Toast.LENGTH_SHORT).show();
                            Log.e(getString(R.string.errorSQLITE), "");
                        }
                ));
    }

    private void insertCategory(CategoryEntity category) {
        compositeDisposable.add(categoryViewEntity.inserCategory(category)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (CategoryEntity.instance.getId() != -1) {
                        this.finish();
                    } else {
                        Toast.makeText(getApplicationContext(), getString(R.string.ocurrioError), Toast.LENGTH_LONG).show();
                    }
                })
        );
    }

    private void updateCategory(CategoryEntity category) {
        compositeDisposable.add(categoryViewEntity.updateCategory(category)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (CategoryEntity.instance.getId() != -1)
                        this.finish();
                    else {
                        Toast.makeText(getApplicationContext(), getString(R.string.ocurrioError), Toast.LENGTH_LONG).show();
                    }
                })
        );
    }
    //endregion

    //region PROTECTED METHODS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inizializateViews();
        compositeDisposable = new CompositeDisposable();
        categoryViewEntityFactory = Injection.providerCategoryViewModelFactory(getApplicationContext());
        categoryViewEntity = ViewModelProviders.of(this, categoryViewEntityFactory).get(CategoryViewEntity.class);
        btnSaveCategory.setOnClickListener(v -> saveCategory());
        rvCDSpinnerAdapter = new RvCDSpinnerAdapter(departmentList, getApplicationContext());
        spDepartments.setAdapter(rvCDSpinnerAdapter);
        updateUid();
    }

    @Override
    protected int getPageLayoutId() {
        return R.layout.activity_crud_category_view;
    }

    @Override
    protected String getScreenTitle() {
        return getString(R.string.itemMenu7);
    }

    @Override
    protected void onResume() {
        super.onResume();
        departmentViewEntityFactory = Injection.providerDepartamentoViewModelFactory(getApplicationContext());
        departmentViewEntity = ViewModelProviders.of(this, departmentViewEntityFactory).get(DepartmentViewEntity.class);
        searchDepartment();
    }

    //endregion
}

