package com.example.administrador.pvsegalmex.viewEntity;

import android.arch.lifecycle.ViewModel;

import com.example.administrador.pvsegalmex.entity.CategoryEntity;
import com.example.administrador.pvsegalmex.entity.ProductPriceEntity;
import com.example.administrador.pvsegalmex.percistence.ProductPriceDao;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class ProductPriceViewEntity extends ViewModel {
    private ProductPriceDao dataSource;

    public ProductPriceViewEntity(ProductPriceDao dataSource) {
        this.dataSource = dataSource;
    }

    public final Flowable getFilterProductPrice(Integer idProducto)
    {
        return dataSource.getFilterProductPrice(idProducto);
    }

    public final Completable insertProductPrice (final ProductPriceEntity productPrice)
    {
        return Completable.fromAction( ()-> ProductPriceEntity.instance.setId(dataSource.insertProductPrice(productPrice).intValue()));
    }

    public final Completable updateProductPrice (final ProductPriceEntity productPrice)
    {
        return Completable.fromAction(() -> dataSource.updateProductPrice(productPrice));
    }
}
