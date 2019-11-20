package com.example.administrador.pvsegalmex.viewEntityFactory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.administrador.pvsegalmex.percistence.CashRegisterDao;
import com.example.administrador.pvsegalmex.viewEntity.CashRegisterViewEntity;

public class CashRegistrerViewEntityFactory implements ViewModelProvider.Factory {

    private CashRegisterDao dataSource;

    public CashRegistrerViewEntityFactory(CashRegisterDao dataSource){this.dataSource=dataSource;}

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass){
        if (modelClass.isAssignableFrom(CashRegisterViewEntity.class)) {
            return (T) (new CashRegisterViewEntity(dataSource));
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }






}
