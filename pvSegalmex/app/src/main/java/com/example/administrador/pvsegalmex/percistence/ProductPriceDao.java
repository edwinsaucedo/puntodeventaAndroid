package com.example.administrador.pvsegalmex.percistence;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.administrador.pvsegalmex.entity.ProductPriceEntity;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface ProductPriceDao {

    @Insert
    Long insertProductPrice(ProductPriceEntity productPrice);

    @Update
    int updateProductPrice(ProductPriceEntity productPrice);

    @Query("SELECT * FROM ProductoPrecio Where Producto =:idProducto")
    Flowable<List<ProductPriceEntity>> getFilterProductPrice(Integer idProducto);
}
