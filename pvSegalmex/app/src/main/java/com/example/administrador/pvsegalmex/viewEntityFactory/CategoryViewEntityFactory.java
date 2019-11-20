package com.example.administrador.pvsegalmex.viewEntityFactory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.administrador.pvsegalmex.percistence.CategoryDao;
import com.example.administrador.pvsegalmex.viewEntity.CategoryViewEntity;

public class CategoryViewEntityFactory implements ViewModelProvider.Factory {

    private CategoryDao dataSource;

    public CategoryViewEntityFactory(CategoryDao dataSource) {this.dataSource = dataSource;}

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(CategoryViewEntity.class)) {
            return (T) (new CategoryViewEntity(dataSource));
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
