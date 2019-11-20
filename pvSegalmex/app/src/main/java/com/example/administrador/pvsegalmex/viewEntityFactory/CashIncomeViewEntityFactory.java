package com.example.administrador.pvsegalmex.viewEntityFactory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.administrador.pvsegalmex.percistence.CashIncomeDao;
import com.example.administrador.pvsegalmex.viewEntity.CashIncomeViewEntity;

import io.reactivex.annotations.NonNull;

public class CashIncomeViewEntityFactory implements ViewModelProvider.Factory {

    private CashIncomeDao dataSource;

    public CashIncomeViewEntityFactory(CashIncomeDao dataSource){this.dataSource=dataSource;}

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass){
        if(modelClass.isAssignableFrom(CashIncomeViewEntity.class)){
            return (T) (new CashIncomeViewEntity(dataSource));
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
