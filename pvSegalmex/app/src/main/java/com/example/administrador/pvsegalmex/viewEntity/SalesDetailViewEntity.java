package com.example.administrador.pvsegalmex.viewEntity;

import android.arch.lifecycle.ViewModel;

import com.example.administrador.pvsegalmex.entity.SalesDetailEntity;
import com.example.administrador.pvsegalmex.percistence.SalesDetailDao;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class SalesDetailViewEntity extends ViewModel {

    private SalesDetailDao dataSource;

    public SalesDetailViewEntity(SalesDetailDao dataSource) {
        this.dataSource = dataSource;
    }

    public final Flowable getFilterSaleDetail(Integer idVenta) {
        return dataSource.getFilterDetail(idVenta);
    }

    public final Flowable getSalesDetail(Integer idVenta) {
        return dataSource.getSalesDetail(idVenta);
    }

    public final Flowable getRegisterSalesDetailSync() {
        return dataSource.getRegisterSalesDetailSync();
    }

    public final Completable inserSalesDetail(final SalesDetailEntity salesDetail) {
        return Completable.fromAction(() -> SalesDetailEntity.instance.setId(dataSource.insertSalesDetail(salesDetail).intValue()));
    }

    public final Completable updateSales(final SalesDetailEntity salesDetail) {
        return Completable.fromAction(() -> dataSource.updateSalesDetail(salesDetail));
    }
}
