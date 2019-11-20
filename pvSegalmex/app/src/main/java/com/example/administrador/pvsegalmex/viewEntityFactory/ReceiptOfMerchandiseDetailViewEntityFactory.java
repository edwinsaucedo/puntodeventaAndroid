package com.example.administrador.pvsegalmex.viewEntityFactory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.administrador.pvsegalmex.percistence.ReceiptOfMerchandiseDetailDao;
import com.example.administrador.pvsegalmex.viewEntity.ReceiptOfMerchandiseDetailViewEntity;

public class ReceiptOfMerchandiseDetailViewEntityFactory implements ViewModelProvider.Factory {

    private ReceiptOfMerchandiseDetailDao dataSource;

    public ReceiptOfMerchandiseDetailViewEntityFactory(ReceiptOfMerchandiseDetailDao dataSource){this.dataSource=dataSource;}

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(ReceiptOfMerchandiseDetailViewEntity.class)){
            return (T) (new ReceiptOfMerchandiseDetailViewEntity(dataSource));
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
