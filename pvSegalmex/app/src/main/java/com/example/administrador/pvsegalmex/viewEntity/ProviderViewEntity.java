package com.example.administrador.pvsegalmex.viewEntity;

import android.arch.lifecycle.ViewModel;

import com.example.administrador.pvsegalmex.entity.ProviderEntity;
import com.example.administrador.pvsegalmex.percistence.ProviderDao;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class ProviderViewEntity extends ViewModel {
    private ProviderDao dataSource;

    public ProviderViewEntity(ProviderDao dataSource) {
        this.dataSource = dataSource;
    }

    public final Flowable getFilterProvider(String providerName) {
        return dataSource.getFilterProvider(providerName);
    }

    public final Flowable getFilterProviderReceiptMerchandise() {
        return dataSource.getFilterProviderReceiptMerchandise();
    }

    public final Flowable getRegisterReceiptOfMerchandiseDetailSync() {
        return dataSource.getRegisterReceiptOfMerchandiseDetailSync();
    }

    public final Completable insertProvider(final ProviderEntity provider) {
        return Completable.fromAction(() -> ProviderEntity.instance.setId(dataSource.insertProvider(provider).intValue()));
    }

    public final Completable updateProvider(final ProviderEntity provider) {
        return Completable.fromAction(() -> dataSource.updateProvider(provider));
    }
}
