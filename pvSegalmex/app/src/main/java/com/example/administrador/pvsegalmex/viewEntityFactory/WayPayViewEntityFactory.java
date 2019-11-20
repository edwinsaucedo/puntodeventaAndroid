package com.example.administrador.pvsegalmex.viewEntityFactory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.administrador.pvsegalmex.percistence.WayPayDao;
import com.example.administrador.pvsegalmex.viewEntity.WayPayViewEntity;

public class WayPayViewEntityFactory implements ViewModelProvider.Factory {
    private WayPayDao dataSource;

    public WayPayViewEntityFactory(WayPayDao dataSource) {
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(WayPayViewEntity.class)){
            return (T) (new WayPayViewEntity(dataSource));
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
