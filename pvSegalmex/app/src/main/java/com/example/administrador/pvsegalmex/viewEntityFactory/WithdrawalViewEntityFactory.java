package com.example.administrador.pvsegalmex.viewEntityFactory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.administrador.pvsegalmex.percistence.WithdrawalDao;
import com.example.administrador.pvsegalmex.viewEntity.WithdrawalViewEntity;

public class WithdrawalViewEntityFactory implements ViewModelProvider.Factory {

    private WithdrawalDao dataSource;

    public WithdrawalViewEntityFactory(WithdrawalDao dataSource){this.dataSource = dataSource;}

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(WithdrawalViewEntity.class)) {
            return (T) (new WithdrawalViewEntity(dataSource));
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
