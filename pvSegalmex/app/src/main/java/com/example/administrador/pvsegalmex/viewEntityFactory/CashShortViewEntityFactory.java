package com.example.administrador.pvsegalmex.viewEntityFactory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.administrador.pvsegalmex.percistence.CashShortDao;
import com.example.administrador.pvsegalmex.viewEntity.CashShortViewEntity;

public class CashShortViewEntityFactory implements ViewModelProvider.Factory {
    private CashShortDao datasource;

    public CashShortViewEntityFactory(CashShortDao datasource) {
        this.datasource = datasource;
    }

    @NonNull
    @Override

    public <T extends ViewModel> T create(@NonNull Class<T> modelClass){
        if(modelClass.isAssignableFrom(CashShortViewEntity.class)){
            return  (T) (new CashShortViewEntity(datasource));
        }
        throw new IllegalArgumentException("Unkonow ViewModel class");
    }
}
