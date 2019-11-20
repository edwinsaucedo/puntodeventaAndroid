package com.example.administrador.pvsegalmex.viewEntity;

import android.arch.lifecycle.ViewModel;

import com.example.administrador.pvsegalmex.entity.ExistEntity;
import com.example.administrador.pvsegalmex.percistence.ExistDao;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class ExistViewEntity  extends ViewModel {
    private ExistDao dataSource;

    public ExistViewEntity(ExistDao dataSource){
        this.dataSource = dataSource;
    }

    public final Flowable getFilterExist(){
        return dataSource.getFilterExist();
    }

    public final Flowable getRegisterExistSync(){
        return dataSource.getRegisterExistSync();
    }

    public final Flowable getFilterExistPojo(){
        return dataSource.getFilterExistPojo();
    }

    public final Flowable getFilterExistProductPojo(String productDescription){
        return dataSource.getFilterExistProductPojo(productDescription);
    }

    public final Completable insertExist(final ExistEntity existEntity){
        return Completable.fromAction(()-> ExistEntity.instance.setId(dataSource.insertExist(existEntity).intValue()));
    }

    public final Completable updateExist(ExistEntity existEntity){
        return Completable.fromAction(()-> dataSource.updateExist(existEntity));
    }
}
