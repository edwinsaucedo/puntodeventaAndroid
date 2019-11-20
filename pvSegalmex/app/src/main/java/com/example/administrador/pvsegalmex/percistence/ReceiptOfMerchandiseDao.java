package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.administrador.pvsegalmex.entity.CategoryEntity;
import com.example.administrador.pvsegalmex.entity.ReceiptOfMerchandiseEntity;
import com.example.administrador.pvsegalmex.pojo.ReceiptMerchandiseProviderPojo;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface ReceiptOfMerchandiseDao {

    @Insert
    Long insertReceiptOfMerchandise(ReceiptOfMerchandiseEntity receiptOfMerchandise);

    @Update
    int updateReceiptOfMerchandise(ReceiptOfMerchandiseEntity receiptOfMerchandise);

    @Query("SELECT rm.Id id, rm.Estatus status, rm.Diconsa diconsa, rm.Fecha date, rm.Total total, rm.Articulos articles, rm.Comentario comment, rm.Proveedor provider, p.Id idProvider, p.Nombre name FROM ReciboMercancia rm, Proveedores p where rm.Proveedor=p.Id and rm.Estatus>-1 and rm.Fecha glob '*'||:date||'*'")
    Flowable<List<ReceiptMerchandiseProviderPojo>> getFilterReceiptOfMerchandise(String date);

    @Query("SELECT*FROM ReciboMercancia d where d.Estatus>-1")
    Flowable<List<ReceiptOfMerchandiseEntity>> getFilter();

    @Query("SELECT * FROM ReciboMercancia r INNER JOIN Bitacora b ON b.Tabla='ReciboMercancia' WHERE r.Fecha<=b.Fecha")
    Flowable<List<ReceiptOfMerchandiseEntity>> getRegisterReceiptOfMerchandiseDetailSync();
}
