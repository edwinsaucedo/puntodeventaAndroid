package com.example.administrador.pvsegalmex.viewEntity;

import android.arch.lifecycle.ViewModel;

import com.example.administrador.pvsegalmex.entity.KardexDetailEntity;
import com.example.administrador.pvsegalmex.percistence.KardexDetailDao;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class KardexDetailViewEntity extends ViewModel {

    private KardexDetailDao dataSource;

    public KardexDetailViewEntity(KardexDetailDao dataSource) {
        this.dataSource = dataSource;
    }

    public final Completable insertKardexDetail(final KardexDetailEntity kardexDetail){
        return Completable.fromAction(()-> KardexDetailEntity.instance.setId(dataSource.insertKardexDetail(kardexDetail).intValue()));
    }

    public final Completable updateKardexDetail(final KardexDetailEntity kardexDetail){
        return Completable.fromAction(()-> dataSource.updateKardexDetail(kardexDetail));
    }

    public final Flowable getFilterKardexDetail(){return dataSource.getFilterKardexDetail();}

    public final Flowable getRegisterKardexDetailSync(){return dataSource.getRegisterKardexDetailSync();}
}
