package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.administrador.pvsegalmex.entity.CollectionOfPaymentEntity;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface CollectionOfPaymentDao {

    @Insert
    Long insertCollectionOfPayment(CollectionOfPaymentEntity collectionOfPaymentEntity);

    @Update
    int updateCollectionOfPayment(CollectionOfPaymentEntity collectionOfPaymentEntity);

    @Query("SELECT * FROM VentaCobro v WHERE v.Estatus>-1")
    Flowable<List<CollectionOfPaymentEntity>> getFilterCollection();

    @Query("SELECT * FROM VentaCobro c INNER JOIN Bitacora b ON b.Tabla='CobroVenta' INNER JOIN Venta v ON c.Venta=v.Id  WHERE c.Fecha<=b.Fecha and v.EstatusVenta = 'CERRADA'")
    Flowable<List<CollectionOfPaymentEntity>> getRegisterCollectionOfPaymentSync();

    @Query("SELECT * FROM VentaCobro c  WHERE c.FormaPago=:id")
    Flowable<List<CollectionOfPaymentEntity>> getWayPayAmount(Integer id);
}
