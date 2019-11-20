package com.example.administrador.pvsegalmex.viewEntity;

import android.arch.lifecycle.ViewModel;

import com.example.administrador.pvsegalmex.entity.SalesEntity;
import com.example.administrador.pvsegalmex.percistence.SalesDao;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class SalesViewEntity extends ViewModel {

    private SalesDao dataSource;
    public SalesEntity salesEntity;

    public SalesViewEntity(SalesDao dataSource) {
        this.dataSource = dataSource;
    }

    public final Flowable getFilterSale(String saleDate) {
        return dataSource.getFilterSale(saleDate);
    }

    public final Flowable getSum() {
        return dataSource.getsSum();
    }

    public final Flowable getRegisterSalesSync() {
        return dataSource.getRegisterSalesSync();
    }

    public final Flowable getFilterSaleIncomplete() {
        return dataSource.getFilterSaleIncomplete();
    }

    public final Completable inserSales(final SalesEntity sales) {
        return Completable.fromAction(() -> SalesEntity.instance.setId(dataSource.insertSales(sales).intValue()));
    }

    public final Completable updateSales(final SalesEntity sales) {
        return Completable.fromAction(() -> dataSource.updateSales(sales));
    }
}
