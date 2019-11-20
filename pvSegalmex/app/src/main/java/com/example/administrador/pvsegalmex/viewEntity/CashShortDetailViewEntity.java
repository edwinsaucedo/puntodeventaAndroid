package com.example.administrador.pvsegalmex.viewEntity;

import android.arch.lifecycle.ViewModel;

import com.example.administrador.pvsegalmex.entity.CashShortDetailEntity;
import com.example.administrador.pvsegalmex.percistence.CashShortDetailDao;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class CashShortDetailViewEntity extends ViewModel {

    private CashShortDetailDao dataSource;

    public CashShortDetailViewEntity(CashShortDetailDao dataSource) {
        this.dataSource = dataSource;
    }

    public final Flowable getFilterCashShortDetail() {
        return dataSource.getFilterCashShortDetail();
    }

    public final Flowable getRegisterCashShortDetailSync() {
        return dataSource.getRegisterCashShortDetailSync();
    }

    public final Flowable getCashShortDetailWayPay(Integer id) {
        return dataSource.getCashShortDetailWayPay(id);
    }

    public final Completable insertCashShortDetail(final CashShortDetailEntity cashShortDetailEntity) {
        return Completable.fromAction(() -> CashShortDetailEntity.instance.setId(dataSource.insertCashShortDetail(cashShortDetailEntity).intValue()));
    }

    public final Completable updateCasShortDetail(final CashShortDetailEntity cashShortDetailEntity) {
        return Completable.fromAction(() -> dataSource.updateCashShortDetail(cashShortDetailEntity));
    }
}
