package com.example.administrador.pvsegalmex.viewEntity;

import android.arch.lifecycle.ViewModel;

import com.example.administrador.pvsegalmex.entity.StoreEntity;
import com.example.administrador.pvsegalmex.percistence.StoreDao;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class StoreViewEntity extends ViewModel {
    private StoreDao dataSource;

    public StoreViewEntity(StoreDao dataSource){this.dataSource = dataSource;}

    public final Completable insertStore(final StoreEntity store){
        return Completable.fromAction(()-> StoreEntity.instance.setId(dataSource.insertStore(store).intValue()));
    }

    public final Completable updateStore(final StoreEntity store){
        return  Completable.fromAction(() -> dataSource.updateStore(store));
    }

    public final Flowable getFilterStore()
    {
        return dataSource.getFilterStore();
    }
}
