package com.example.administrador.pvsegalmex.viewEntity;

import android.arch.lifecycle.ViewModel;

import com.example.administrador.pvsegalmex.entity.CategoryEntity;
import com.example.administrador.pvsegalmex.percistence.CategoryDao;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class CategoryViewEntity extends ViewModel {

    private CategoryDao dataSource;
    public List idInsertCategory;
    public int rowCount;

    public CategoryViewEntity(CategoryDao dataSource) {
        this.dataSource = dataSource;
        idInsertCategory = new ArrayList<>();
    }

    public final Flowable getFilterCategory(String description) {
        return dataSource.getFilterCategory(description);
    }

    public final Flowable getFilterProduct() {
        return dataSource.getFilterProduct();
    }

    public final Completable getCountCategory(String categoryUUID) {
        return Completable.fromAction(() -> rowCount = dataSource.getCountCategory(categoryUUID));
    }

    public final Completable inserCategory(final CategoryEntity category) {
        return Completable.fromAction(() -> CategoryEntity.instance.setId(dataSource.insertCategory(category).intValue()));
    }

    public final Completable insertCategoryDefault(final ArrayList<CategoryEntity> category) {
        return Completable.fromAction(() -> idInsertCategory = dataSource.insertCategoryDefault(category));
    }

    public final Completable updateCategory(final CategoryEntity category) {
        return Completable.fromAction(() -> dataSource.updateCategory(category));
    }
}
