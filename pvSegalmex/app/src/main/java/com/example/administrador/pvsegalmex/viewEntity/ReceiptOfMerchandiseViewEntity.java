package com.example.administrador.pvsegalmex.viewEntity;

import android.arch.lifecycle.ViewModel;

import com.example.administrador.pvsegalmex.entity.ReceiptOfMerchandiseEntity;
import com.example.administrador.pvsegalmex.percistence.ReceiptOfMerchandiseDao;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class ReceiptOfMerchandiseViewEntity extends ViewModel {

    private ReceiptOfMerchandiseDao dataSource;

    public ReceiptOfMerchandiseViewEntity(ReceiptOfMerchandiseDao dataSource){
        this.dataSource=dataSource;
    }

    public final Completable insertReceiptOfMerchandise(final ReceiptOfMerchandiseEntity receiptOfMerchandise){
        return Completable.fromAction(()-> ReceiptOfMerchandiseEntity.instance.setId(dataSource.insertReceiptOfMerchandise(receiptOfMerchandise).intValue()));
    }

    public final Completable updateReceiptOfMerchandise(final ReceiptOfMerchandiseEntity receiptOfMerchandise){
        return Completable.fromAction(()->dataSource.updateReceiptOfMerchandise(receiptOfMerchandise));
    }

    public final Flowable getFilterReceiptOfMerchandise(String date){return  dataSource.getFilterReceiptOfMerchandise(date);}

    public final Flowable getFilter(){return  dataSource.getFilter();}

    public final Flowable getRegisterReceiptOfMerchandiseDetailSync(){return  dataSource.getRegisterReceiptOfMerchandiseDetailSync();}
}
