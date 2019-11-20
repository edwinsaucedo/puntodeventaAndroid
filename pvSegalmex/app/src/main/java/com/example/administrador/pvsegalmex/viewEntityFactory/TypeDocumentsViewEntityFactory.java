package com.example.administrador.pvsegalmex.viewEntityFactory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;

import com.example.administrador.pvsegalmex.percistence.TypeDocumentsDao;
import com.example.administrador.pvsegalmex.viewEntity.TypeDocumentsViewEntity;

import io.reactivex.annotations.NonNull;

public class TypeDocumentsViewEntityFactory implements ViewModelProvider.Factory {
    private TypeDocumentsDao dataSource;

    public TypeDocumentsViewEntityFactory (TypeDocumentsDao dataSource){
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@android.support.annotation.NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(TypeDocumentsViewEntity.class)){
            return (T) (new TypeDocumentsViewEntity(dataSource));
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
