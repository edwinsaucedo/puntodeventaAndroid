package com.example.administrador.pvsegalmex.viewEntityFactory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.administrador.pvsegalmex.percistence.CollectionOfPaymentDao;
import com.example.administrador.pvsegalmex.viewEntity.CollectionOfPaymentViewEntity;

public class CollectionOfPaymentViewEntityFactory implements ViewModelProvider.Factory {

    private CollectionOfPaymentDao dataSource;

    public CollectionOfPaymentViewEntityFactory(CollectionOfPaymentDao dataSource){this.dataSource=dataSource;}

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(CollectionOfPaymentViewEntity.class)){
            return (T) (new CollectionOfPaymentViewEntity(dataSource));
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
