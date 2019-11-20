package com.example.administrador.pvsegalmex.viewEntityFactory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.administrador.pvsegalmex.percistence.KardexDetailDao;
import com.example.administrador.pvsegalmex.viewEntity.KardexDetailViewEntity;

public class KardexDetailViewEntityFactory implements ViewModelProvider.Factory {

    private KardexDetailDao dataSource;

    public KardexDetailViewEntityFactory(KardexDetailDao dataSource) {
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(KardexDetailViewEntity.class)){
            return (T) (new KardexDetailViewEntity(dataSource));
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }

}
