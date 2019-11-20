package com.example.administrador.pvsegalmex.viewEntity;

import android.arch.lifecycle.ViewModel;

import com.example.administrador.pvsegalmex.entity.CashIncomeDetailEntity;
import com.example.administrador.pvsegalmex.percistence.CashIncomeDetailDao;

import io.reactivex.Completable;

public class CashIncomeDetailViewEntity extends ViewModel {
    private CashIncomeDetailDao dataSource;

    public CashIncomeDetailViewEntity(CashIncomeDetailDao dataSource) {
        this.dataSource = dataSource;
    }

    public final Completable insertIncomeDetail(final CashIncomeDetailEntity cashIncomeDetailEntity) {
        return Completable.fromAction(() -> CashIncomeDetailEntity.instance.setId(dataSource.insertCashIncomeDetail(cashIncomeDetailEntity).intValue()));
    }

    public final Completable updateIncome(final CashIncomeDetailEntity cashIncomeDetailEntity) {
        return Completable.fromAction(() -> dataSource.updateCashIncomeDetail(cashIncomeDetailEntity));
    }

}
