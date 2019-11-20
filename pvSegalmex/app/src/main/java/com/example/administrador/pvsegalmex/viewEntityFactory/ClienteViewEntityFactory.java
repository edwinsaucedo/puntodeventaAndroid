package com.example.administrador.pvsegalmex.viewEntityFactory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.administrador.pvsegalmex.percistence.ClienteDao;
import com.example.administrador.pvsegalmex.viewEntity.ClienteViewEntity;

public class ClienteViewEntityFactory implements ViewModelProvider.Factory {

    private ClienteDao dataSource;

    public ClienteViewEntityFactory(ClienteDao dataSource) {
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(ClienteViewEntity.class)){
            return (T) (new ClienteViewEntity(dataSource));
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
