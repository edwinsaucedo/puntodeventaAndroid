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
import com.example.administrador.pvsegalmex.adapter.RvCategoryAdapter;
import com.example.administrador.pvsegalmex.controller.SwipeController;
import com.example.administrador.pvsegalmex.controller.SwipeControllerActions;
import com.example.administrador.pvsegalmex.entity.CategoryEntity;
import com.example.administrador.pvsegalmex.utils.DialogUtils;
import com.example.administrador.pvsegalmex.viewEntity.CategoryViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.CategoryViewEntityFactory;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CategoryView extends MenuView {

    //region VARS
    private ArrayList<CategoryEntity> categoryList;
    private CategoryViewEntityFactory categoryFactory;
    private CategoryViewEntity categoryViewEntity;
    private CompositeDisposable compositeDisposable;
    private RvCategoryAdapter rvCategoryAdapter;
    //endregion

    //region VARS
    private EditText mCategoryDescription;
    private FloatingActionButton btnAddCategory, btnSearchCategory;
    private RecyclerView rvCategory;
    private SwipeController swipe;
    //endregion

    //region PRIVATE METHODS
    private void inizialiteViews() {
        categoryList = new ArrayList<>();
        mCategoryDescription = findViewById(R.id.edtCategoryDescription);
        btnSearchCategory = findViewById(R.id.btnSearchCategory);
        btnAddCategory = findViewById(R.id.btnAddCategory);
        rvCategory = findViewById(R.id.rvCategory);
    }

    @SuppressWarnings("unchecked")
    private void searchCategory() {
        String description;
        description = mCategoryDescription.getText().toString();
        compositeDisposable.add(categoryViewEntity.getFilterCategory(description)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<CategoryEntity>>) categoryListSearch -> {
                            categoryList = (ArrayList<CategoryEntity>) categoryListSearch;
                            if (categoryList.isEmpty())
                                Toast.makeText(getApplicationContext(), getString(R.string.noHayRegistros), Toast.LENGTH_SHORT).show();
                            rvCategoryAdapter = new RvCategoryAdapter(categoryList, getApplicationContext());
                            rvCategory.setAdapter(rvCategoryAdapter);
                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), getString(R.string.errorConsulta), Toast.LENGTH_SHORT).show();
                            Log.e(getString(R.string.errorSQLITE), "");
                        }
                ));
    }

    private void goToEditCategory(CategoryEntity category) {
        CategoryEntity.instance.setId(category.getId());
        CategoryEntity.instance.setDescription(category.getDescription());
        CategoryEntity.instance.setDepartment(category.getDepartment());
        Intent intent = new Intent(getApplicationContext(), CrudCategoryView.class);
        startActivity(intent);
    }

    private void deleteCategory(CategoryEntity category) {
        category.setStatus(-1);
        compositeDisposable.add(categoryViewEntity.updateCategory(category)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> DialogUtils.showOkayDialog(CategoryView.this, getString(R.string.messageSuccTitleGlobal), getString(R.string.deleteDepartamentSuccess), "success"))
        );
    }
    //endregion

    //region PROTECTED METHODS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inizialiteViews();
        CategoryEntity.instance.clear();
        compositeDisposable = new CompositeDisposable();
        rvCategoryAdapter = new RvCategoryAdapter(categoryList, getApplicationContext());
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        rvCategory.setAdapter(rvCategoryAdapter);

        categoryFactory = Injection.providerCategoryViewModelFactory(getApplicationContext());
        categoryViewEntity = ViewModelProviders.of(this, categoryFactory).get(CategoryViewEntity.class);

        btnAddCategory.setOnClickListener(v -> {
            CategoryEntity.instance.clear();
            startActivity(CrudCategoryView.class);
        });

        swipe = new SwipeController(new SwipeControllerActions() {
            @Override
            public void onLeftClicked(int position) {
                CategoryEntity categoryClicked = categoryList.get(position);
                DialogUtils.showOkayNoDialog(getString(R.string.delDepartamentWarningMessage), getString(R.string.delDepartamentWarningTitle), CategoryView.this, new DialogUtils.OnOkayNoEvent() {
                    @Override
                    public void onYes() {
                        if (categoryClicked.getId() == 1) {
                            Toast.makeText(getApplicationContext(), getString(R.string.noBorrarRegistro), Toast.LENGTH_SHORT).show();
                        } else {
                            deleteCategory(categoryClicked);
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
                CategoryEntity categoryEntityClicked = categoryList.get(position);
                goToEditCategory(categoryEntityClicked);
            }
        });

        ItemTouchHelper touchHelper = new ItemTouchHelper(swipe);
        touchHelper.attachToRecyclerView(rvCategory);

        rvCategory.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                swipe.onDraw(c);
            }
        });

        btnSearchCategory.setOnClickListener(v -> searchCategory());
    }

    @Override
    protected int getPageLayoutId() {
        return R.layout.activity_category_view;
    }

    @Override
    protected String getScreenTitle() {
        return getString(R.string.itemMenu7);
    }

    @Override
    protected void onResume() {
        super.onResume();
        categoryFactory = Injection.providerCategoryViewModelFactory(getApplicationContext());
        categoryViewEntity = ViewModelProviders.of(this, categoryFactory).get(CategoryViewEntity.class);
        searchCategory();
    }
    //endregion

    @Override
    public void onBackPressed() {
    }
}