package com.example.administrador.pvsegalmex.viewEntity;

import android.arch.lifecycle.ViewModel;

import com.example.administrador.pvsegalmex.entity.CollectionOfPaymentEntity;
import com.example.administrador.pvsegalmex.percistence.CollectionOfPaymentDao;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class CollectionOfPaymentViewEntity extends ViewModel {

    private CollectionOfPaymentDao dataSource;

    public CollectionOfPaymentViewEntity(CollectionOfPaymentDao dataSource){
        this.dataSource = dataSource;
    }

    public final Completable insertCollectionOfPayment(final CollectionOfPaymentEntity collectionOfPaymentEntity)
    {
        return Completable.fromAction(()-> CollectionOfPaymentEntity.instance.setId(dataSource.insertCollectionOfPayment(collectionOfPaymentEntity).intValue()));
    }

    public final Completable updateCollectionOfPayment(final  CollectionOfPaymentEntity collectionOfPaymentEntity){
        return Completable.fromAction(()-> dataSource.updateCollectionOfPayment(collectionOfPaymentEntity));
    }

    public final Flowable getFilterCollection(){return dataSource.getFilterCollection();}

    public final Flowable getRegisterCollectionOfPaymentSync(){return dataSource.getRegisterCollectionOfPaymentSync();}

    public final Flowable getWayPayAmount(Integer id){return dataSource.getWayPayAmount(id);}
}
