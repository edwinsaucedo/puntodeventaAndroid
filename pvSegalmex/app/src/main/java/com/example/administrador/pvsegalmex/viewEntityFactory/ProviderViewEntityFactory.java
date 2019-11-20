package com.example.administrador.pvsegalmex.viewEntityFactory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.administrador.pvsegalmex.entity.ProviderEntity;
import com.example.administrador.pvsegalmex.percistence.ProviderDao;
import com.example.administrador.pvsegalmex.viewEntity.ProviderViewEntity;

public class ProviderViewEntityFactory  implements  ViewModelProvider.Factory {

    private ProviderDao dataSource;

    public ProviderViewEntityFactory(ProviderDao dataSource) {
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ProviderViewEntity.class)) {
            return (T) (new ProviderViewEntity(dataSource));

        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
