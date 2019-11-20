package com.example.administrador.pvsegalmex.viewEntityFactory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.administrador.pvsegalmex.percistence.ProductPriceDao;
import com.example.administrador.pvsegalmex.viewEntity.ProductPriceViewEntity;

public class ProductPriceViewEntityFactory implements ViewModelProvider.Factory {

    private ProductPriceDao dataSource;

    public ProductPriceViewEntityFactory(ProductPriceDao dataSource) {
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ProductPriceViewEntity.class)) {
            return (T) (new ProductPriceViewEntity(dataSource));
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}