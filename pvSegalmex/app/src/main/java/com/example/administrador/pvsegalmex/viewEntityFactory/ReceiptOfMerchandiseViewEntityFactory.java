package com.example.administrador.pvsegalmex.viewEntityFactory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.administrador.pvsegalmex.percistence.ReceiptOfMerchandiseDao;
import com.example.administrador.pvsegalmex.viewEntity.ReceiptOfMerchandiseViewEntity;

public class ReceiptOfMerchandiseViewEntityFactory implements ViewModelProvider.Factory {

    private ReceiptOfMerchandiseDao dataSource;

    public ReceiptOfMerchandiseViewEntityFactory(ReceiptOfMerchandiseDao dataSource){this.dataSource=dataSource;}

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(ReceiptOfMerchandiseViewEntity.class)){
            return (T) (new ReceiptOfMerchandiseViewEntity(dataSource));
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
