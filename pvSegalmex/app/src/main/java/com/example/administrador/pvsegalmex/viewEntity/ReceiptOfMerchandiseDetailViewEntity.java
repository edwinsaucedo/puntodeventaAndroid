package com.example.administrador.pvsegalmex.viewEntity;

import android.arch.lifecycle.ViewModel;

import com.example.administrador.pvsegalmex.entity.ReceiptOfMerchandiseDetailEntity;
import com.example.administrador.pvsegalmex.percistence.ReceiptOfMerchandiseDetailDao;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class ReceiptOfMerchandiseDetailViewEntity extends ViewModel {

    private ReceiptOfMerchandiseDetailDao dataSource;
    public List idInsertados;

    public ReceiptOfMerchandiseDetailViewEntity(ReceiptOfMerchandiseDetailDao dataSource) {
        this.dataSource = dataSource;
    }

    public final Completable insertReceiptOfMerchandiseDetail(final ReceiptOfMerchandiseDetailEntity receiptOfMerchandiseDetail) {
        return Completable.fromAction(() -> ReceiptOfMerchandiseDetailEntity.instance.setId(dataSource.insertReceiptOfMerchandiseDetail(receiptOfMerchandiseDetail).intValue()));
    }

    public final Completable updateReceiptOfMerchandiseDetail(final ReceiptOfMerchandiseDetailEntity receiptOfMerchandiseDetail) {
        return Completable.fromAction(() -> dataSource.updateReceiptOfMerchandiseDetail(receiptOfMerchandiseDetail));
    }

    public final Flowable getFilterReceiptOfMerchandiseDetail() {
        return dataSource.getFilterReceiptOfMerchandiseDetail();
    }

    public final Flowable getRegisterReceiptOfMerchandiseDetailSync() {
        return dataSource.getRegisterReceiptOfMerchandiseDetailSync();
    }

    public final Completable insertReceiptMerchandiseDefault(final ArrayList<ReceiptOfMerchandiseDetailEntity> receipt) {
        return Completable.fromAction(() -> idInsertados = dataSource.insertReceiptOfMerchandiseDefault(receipt));
    }
}
