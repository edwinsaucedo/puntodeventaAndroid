package com.example.administrador.pvsegalmex.viewEntity;

import android.arch.lifecycle.ViewModel;

import com.example.administrador.pvsegalmex.entity.CashRegisterEntity;
import com.example.administrador.pvsegalmex.percistence.CashRegisterDao;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class CashRegisterViewEntity extends ViewModel {
    private CashRegisterDao dataSource;

    public CashRegisterViewEntity(CashRegisterDao dataSource){this.dataSource=dataSource;}

    public final Completable insertCashRegistrer(final CashRegisterEntity cashRegisterEntity){
        return Completable.fromAction(()-> CashRegisterEntity.instance.setId(dataSource.insertCashRegister(cashRegisterEntity).intValue()));
    }

    public final Completable updateCashRegister(final CashRegisterEntity cashRegisterEntity){
        return Completable.fromAction(()-> dataSource.updateCashRester(cashRegisterEntity));
    }

    public final Flowable getFilterCashRegister(){return dataSource.getFilterCashRegister();}



}
