package com.example.administrador.pvsegalmex.viewEntity;

import android.arch.lifecycle.ViewModel;

import com.example.administrador.pvsegalmex.entity.CashIncomeEntity;
import com.example.administrador.pvsegalmex.percistence.CashIncomeDao;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class CashIncomeViewEntity extends ViewModel {
    private CashIncomeDao dataSource;

    public CashIncomeViewEntity(CashIncomeDao dataSource){this.dataSource=dataSource;}

    public final Flowable getFilterIncome(String date){return dataSource.getFilterIncome(date);}

    public final Flowable getSum(){return dataSource.getsSum();}

    public final Flowable getRegisterCashIncomeSync(){return dataSource.getRegisterCashIncomeSync();}

    public final Completable insertIncome(final CashIncomeEntity cashIncomeEntity){
        return Completable.fromAction(()-> CashIncomeEntity.instance.setId(dataSource.insertIncome(cashIncomeEntity).intValue()));
    }

    public final Completable updateIncome(final CashIncomeEntity cashIncomeEntity){
        return Completable.fromAction(()-> dataSource.updateIncome(cashIncomeEntity));
    }
}
