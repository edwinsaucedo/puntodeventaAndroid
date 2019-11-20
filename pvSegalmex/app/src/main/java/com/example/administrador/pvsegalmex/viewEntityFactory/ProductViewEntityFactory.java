package com.example.administrador.pvsegalmex.viewEntityFactory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;

import com.example.administrador.pvsegalmex.percistence.ProductDao;
import com.example.administrador.pvsegalmex.viewEntity.ProductViewEntity;

public class ProductViewEntityFactory implements ViewModelProvider.Factory {

    private ProductDao dataSource;

    public ProductViewEntityFactory(ProductDao dataSource) {
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ProductViewEntity.class)) {
            return (T) (new ProductViewEntity(dataSource));
        }
        throw new IllegalArgumentException("Unknown ViewModel class");


    }
}

