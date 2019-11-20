package com.example.administrador.pvsegalmex.viewEntity;

import android.arch.lifecycle.ViewModel;

import com.example.administrador.pvsegalmex.entity.ProductEntity;
import com.example.administrador.pvsegalmex.percistence.ProductDao;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class ProductViewEntity extends ViewModel {
    private ProductDao dataSource;
    public List idInsertados;
    public int rowCount;

    public ProductViewEntity(ProductDao dataSource) {
        this.dataSource = dataSource;
        idInsertados = new ArrayList<>();
    }

    public final Flowable getFilterProducts(String productDescription) {
        return dataSource.getFilterProducts(productDescription);

    }

    public final Flowable getFilterProductsPrice(String description) {
        return dataSource.getFilterProductsPrice(description);
    }

    public final Flowable getFilterProductsCatalog() {
        return dataSource.getFilterProductsCatalog();

    }

    public final Completable getCountProduct(String productUUID) {
        return Completable.fromAction(() -> rowCount = dataSource.getCountProduct(productUUID));
    }

    public final Flowable getFilterProductsCode(String code) {
        return dataSource.getFilterProductsCode(code);
    }

    public final Completable insertProduct(final ProductEntity product) {
        return Completable.fromAction(() -> ProductEntity.instance.setId(dataSource.insertProduct(product).intValue()));

    }

    public final Completable insertProductDefault(final ArrayList<ProductEntity> product) {
        return Completable.fromAction(() -> idInsertados = dataSource.insertProductDefault(product));
    }

    public final Completable updateProduct(final ProductEntity product) {
        return Completable.fromAction(() -> dataSource.updateProduct(product));
    }
}
