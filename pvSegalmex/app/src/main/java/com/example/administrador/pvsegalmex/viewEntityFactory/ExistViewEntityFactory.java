package com.example.administrador.pvsegalmex.viewEntityFactory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;

import com.example.administrador.pvsegalmex.percistence.ExistDao;
import com.example.administrador.pvsegalmex.viewEntity.ExistViewEntity;

public class ExistViewEntityFactory implements ViewModelProvider.Factory {

    private ExistDao dataSource;

    public ExistViewEntityFactory(ExistDao dataSource){this.dataSource = dataSource;}

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ExistViewEntity.class)) {
            return (T) (new ExistViewEntity(dataSource));
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
