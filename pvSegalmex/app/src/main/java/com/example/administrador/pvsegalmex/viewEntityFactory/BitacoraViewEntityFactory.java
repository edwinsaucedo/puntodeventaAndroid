package com.example.administrador.pvsegalmex.viewEntityFactory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.administrador.pvsegalmex.entity.BitacoraEntity;
import com.example.administrador.pvsegalmex.percistence.BitacoraDao;
import com.example.administrador.pvsegalmex.viewEntity.BitacoraViewEntity;

import io.reactivex.Completable;
import io.reactivex.annotations.NonNull;

public class BitacoraViewEntityFactory implements ViewModelProvider.Factory{
    private BitacoraDao dataSource;

    public BitacoraViewEntityFactory(BitacoraDao dataSource){this.dataSource=dataSource;}

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass){
        if(modelClass.isAssignableFrom(BitacoraViewEntity.class)){
            return (T) (new BitacoraViewEntity(dataSource));
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
