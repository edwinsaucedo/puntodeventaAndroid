package com.example.administrador.pvsegalmex.viewEntityFactory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.administrador.pvsegalmex.percistence.WithdrawalDetailDao;
import com.example.administrador.pvsegalmex.viewEntity.WithdrawalDetailViewEntity;

public class WithdrawalDetailViewEntityFactory implements ViewModelProvider.Factory {

    private WithdrawalDetailDao dataSource;

    public WithdrawalDetailViewEntityFactory(WithdrawalDetailDao dataSource) {
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(WithdrawalDetailViewEntity.class)) {
            return (T) (new WithdrawalDetailViewEntity(dataSource));
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
