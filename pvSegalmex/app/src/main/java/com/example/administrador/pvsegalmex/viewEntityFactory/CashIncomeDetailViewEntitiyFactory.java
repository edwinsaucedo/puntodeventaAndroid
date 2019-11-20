package com.example.administrador.pvsegalmex.viewEntityFactory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.administrador.pvsegalmex.percistence.CashIncomeDetailDao;
import com.example.administrador.pvsegalmex.viewEntity.CashIncomeDetailViewEntity;

public class CashIncomeDetailViewEntitiyFactory implements ViewModelProvider.Factory {
    private CashIncomeDetailDao dataSource;

    public CashIncomeDetailViewEntitiyFactory(CashIncomeDetailDao dataSource) {
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(CashIncomeDetailViewEntity.class)) {
            return (T) (new CashIncomeDetailViewEntity(dataSource));
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
