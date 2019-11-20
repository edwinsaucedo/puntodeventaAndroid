package com.example.administrador.pvsegalmex.viewEntityFactory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.administrador.pvsegalmex.percistence.CashShortDetailDao;
import com.example.administrador.pvsegalmex.viewEntity.CashShortDetailViewEntity;

public class CashShortDetailViewEntityFactory implements ViewModelProvider.Factory {

    private CashShortDetailDao datasource;

    public CashShortDetailViewEntityFactory(CashShortDetailDao datasource) {
        this.datasource = datasource;
    }

    @NonNull
    @Override

    public <T extends ViewModel> T create(@NonNull Class<T> modelClass){
        if(modelClass.isAssignableFrom(CashShortDetailViewEntity.class)){
            return  (T) (new CashShortDetailViewEntity(datasource));
        }
        throw new IllegalArgumentException("Unkonow ViewModel class");
    }
}
