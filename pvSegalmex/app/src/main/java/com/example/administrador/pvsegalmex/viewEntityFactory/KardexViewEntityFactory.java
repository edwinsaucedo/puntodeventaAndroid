package com.example.administrador.pvsegalmex.viewEntityFactory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.administrador.pvsegalmex.percistence.KardexDao;
import com.example.administrador.pvsegalmex.viewEntity.KardexViewEntity;

public class KardexViewEntityFactory implements ViewModelProvider.Factory {

    private KardexDao dataSource;

    public KardexViewEntityFactory(KardexDao dataSource) {
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(KardexViewEntity.class)){
            return (T) (new KardexViewEntity(dataSource));
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
