package com.example.administrador.pvsegalmex.viewEntity;

import android.arch.lifecycle.ViewModel;

import com.example.administrador.pvsegalmex.entity.CashShortEntity;
import com.example.administrador.pvsegalmex.percistence.CashShortDao;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class CashShortViewEntity extends ViewModel {

    private CashShortDao dataSource;

    public CashShortViewEntity(CashShortDao dataSource) {
        this.dataSource = dataSource;
    }

    public final Flowable getFilterCashShort() {
        return dataSource.getFilterCashShort();
    }

    public final Flowable getAllCashShort() {
        return dataSource.getAllCashShort();
    }


    public final Flowable getRegisterCashShortSync() {
        return dataSource.getRegisterCashShortSync();
    }

    public final Completable insertCashShort(final CashShortEntity cashShortEntity) {
        return Completable.fromAction(() -> CashShortEntity.instance.setId(dataSource.insertCashShort(cashShortEntity).intValue()));
    }

    public final Completable updateCasShort(final CashShortEntity cashShortEntity) {
        return Completable.fromAction(() -> dataSource.updateCashShort(cashShortEntity));
    }
}
