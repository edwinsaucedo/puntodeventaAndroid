package com.example.administrador.pvsegalmex.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.adapter.RvDepartmentAdapter;
import com.example.administrador.pvsegalmex.controller.SwipeController;
import com.example.administrador.pvsegalmex.controller.SwipeControllerActions;
import com.example.administrador.pvsegalmex.entity.DepartmentEntity;
import com.example.administrador.pvsegalmex.utils.DialogUtils;
import com.example.administrador.pvsegalmex.viewEntity.DepartmentViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.DepartmentViewEntityFactory;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DepartmentView extends MenuView {

    //region VARS
    private ArrayList<DepartmentEntity> departmentList;
    private DepartmentViewEntityFactory departamentFactory;
    private DepartmentViewEntity departamentViewEntity;
    private CompositeDisposable compositeDisposable;
    private RvDepartmentAdapter rvDepartamentAdapter;
    //endregion

    //region VIEWS
    private EditText mDepartamentDescription;
    private RecyclerView rvDepartaments;
    private FloatingActionButton btnAddDepartament, btnSearchDepartament;
    private ItemTouchHelper touchHelper;
    private SwipeController swipe;
    //endregion

    //region PRIVATE METHODS
    private void inizialiteViews() {
        departmentList = new ArrayList<>();
        mDepartamentDescription = findViewById(R.id.edtxDepartamentDesc);
        rvDepartaments = findViewById(R.id.rvDepartaments);
        btnSearchDepartament = findViewById(R.id.btnSearchDepartament);
        btnAddDepartament = findViewById(R.id.btnAddDepartament);
    }
    @SuppressWarnings("unchecked")
    private void searchDepartament() {
        String description;
        description = mDepartamentDescription.getText().toString();
        compositeDisposable.add(departamentViewEntity.getFilterDepartamentos(description)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<DepartmentEntity>>) departmentListSearch -> {
                            departmentList = (ArrayList<DepartmentEntity>) departmentListSearch;
                            if (departmentList.isEmpty())
                                Toast.makeText(getApplicationContext(), getString(R.string.noHayRegistros), Toast.LENGTH_SHORT).show();
                            rvDepartamentAdapter = new RvDepartmentAdapter(departmentList, getApplicationContext());
                            rvDepartaments.setAdapter(rvDepartamentAdapter);
                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), getString(R.string.errorConsulta), Toast.LENGTH_SHORT).show();
                            Log.e(getString(R.string.errorSQLITE), "");
                        }
                ));
    }

    private void goToEditDepartament(DepartmentEntity department) {
        DepartmentEntity.instance.setId(department.getId());
        DepartmentEntity.instance.setDescription(department.getDescription());
        Intent intent = new Intent(getApplicationContext(), CrudDepartamentView.class);
        startActivity(intent);
    }

    private void deleteDepartment(DepartmentEntity department) {
        department.setStatus(-1);
        compositeDisposable.add(departamentViewEntity.updateDepartamento(department)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() ->
                        DialogUtils.showOkayDialog(DepartmentView.this, getString(R.string.messageSuccTitleGlobal), getString(R.string.deleteDepartamentSuccess), "success"))
        );

    }
    //endregion

    //region PROTECTED METHODS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inizialiteViews();

        rvDepartamentAdapter = new RvDepartmentAdapter(departmentList, getApplicationContext());
        rvDepartaments.setLayoutManager(new LinearLayoutManager(this));
        rvDepartaments.setAdapter(rvDepartamentAdapter);
        touchHelper = new ItemTouchHelper(swipe);

        btnAddDepartament.setOnClickListener(v -> {
            DepartmentEntity.instance.clear();
            startActivity(CrudDepartamentView.class);
        });

        swipe = new SwipeController(new SwipeControllerActions() {
            @Override
            public void onLeftClicked(int position) {
                DepartmentEntity departamentClicked = departmentList.get(position);
                DialogUtils.showOkayNoDialog(getString(R.string.delDepartamentWarningMessage), getString(R.string.delDepartamentWarningTitle), DepartmentView.this, new DialogUtils.OnOkayNoEvent() {
                    @Override
                    public void onYes() {
                        if (departamentClicked.getId() == 1) {
                            Toast.makeText(getApplicationContext(), getString(R.string.noBorrarRegistro), Toast.LENGTH_SHORT).show();
                        } else {
                            deleteDepartment(departamentClicked);
                        }
                    }

                    @Override
                    public void onNo() {
                        Toast.makeText(getApplicationContext(), getString(R.string.dialogOk), Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onRightClicked(int position) {
                DepartmentEntity departamentClicked = departmentList.get(position);
                goToEditDepartament(departamentClicked);
            }
        });

        touchHelper = new ItemTouchHelper(swipe);
        touchHelper.attachToRecyclerView(rvDepartaments);

        rvDepartaments.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                swipe.onDraw(c);
            }
        });

        btnSearchDepartament.setOnClickListener(v -> searchDepartament());
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    protected int getPageLayoutId() {
        return R.layout.activity_departamento_view;
    }

    @Override
    protected String getScreenTitle() {
        return getString(R.string.itemMenu4);
    }

    @Override
    protected void onResume() {
        super.onResume();
        departamentFactory = Injection.providerDepartamentoViewModelFactory(getApplicationContext());
        departamentViewEntity = ViewModelProviders.of(this, departamentFactory).get(DepartmentViewEntity.class);
        searchDepartament();
    }
    //endregion
    @Override
    public void onBackPressed() {
    }
}
