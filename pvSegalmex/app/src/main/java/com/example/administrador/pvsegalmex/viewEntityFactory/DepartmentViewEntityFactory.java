package com.example.administrador.pvsegalmex.viewEntityFactory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.administrador.pvsegalmex.percistence.DepartmentDao;
import com.example.administrador.pvsegalmex.viewEntity.DepartmentViewEntity;

public class DepartmentViewEntityFactory implements ViewModelProvider.Factory {

    private DepartmentDao dataSource;

    public DepartmentViewEntityFactory(DepartmentDao dataSource) {
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(DepartmentViewEntity.class)) {
            return (T) (new DepartmentViewEntity(dataSource));
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
