package com.example.administrador.pvsegalmex.viewEntityFactory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.administrador.pvsegalmex.percistence.SalesDao;
import com.example.administrador.pvsegalmex.viewEntity.SalesViewEntity;

public class SalesViewEntityFactory implements ViewModelProvider.Factory {

    private SalesDao datasource;

    public SalesViewEntityFactory(SalesDao datasource){
        this.datasource = datasource;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(SalesViewEntity.class)) {
            return (T) (new SalesViewEntity(datasource));

        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
