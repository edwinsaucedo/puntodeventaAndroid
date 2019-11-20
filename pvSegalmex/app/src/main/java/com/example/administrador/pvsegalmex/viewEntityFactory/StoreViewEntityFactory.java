package com.example.administrador.pvsegalmex.viewEntityFactory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.administrador.pvsegalmex.entity.StoreEntity;
import com.example.administrador.pvsegalmex.percistence.StoreDao;
import com.example.administrador.pvsegalmex.viewEntity.StoreViewEntity;

public class StoreViewEntityFactory implements ViewModelProvider.Factory {

    private StoreDao dataSource;

    public StoreViewEntityFactory(StoreDao dataSource){
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(StoreViewEntity.class)) {
            return (T) (new StoreViewEntity(dataSource));

        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
