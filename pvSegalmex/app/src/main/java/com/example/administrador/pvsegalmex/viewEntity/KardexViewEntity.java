package com.example.administrador.pvsegalmex.viewEntity;

import android.arch.lifecycle.ViewModel;

import com.example.administrador.pvsegalmex.entity.KardexEntity;
import com.example.administrador.pvsegalmex.percistence.KardexDao;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class KardexViewEntity extends ViewModel {
    private KardexDao dataSource;

    public KardexViewEntity (KardexDao dataSource){
        this.dataSource = dataSource;
    }

    public final Completable insertKardex(final KardexEntity kardex){
         return Completable.fromAction(()-> KardexEntity.instance.setId(dataSource.insertKardex(kardex).intValue()));
    }

    public final Completable updateKardex(final KardexEntity kardex){
        return Completable.fromAction(()-> dataSource.updateKardex(kardex));
    }

    public final Flowable getFilterKardex(){return dataSource.getFilterKardex();}

    public final Flowable getRegisterKardexSync(){return dataSource.getRegisterKardexSync();}
}
