package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.administrador.pvsegalmex.entity.ProviderEntity;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface ProviderDao {

    @Insert
    Long insertProvider(ProviderEntity provider);

    @Update
    int updateProvider(ProviderEntity provider);

    @Query("SELECT * FROM Proveedores p where p.Estatus>-1 and p.Nombre glob '*'||:providerName||'*'")
    Flowable<List<ProviderEntity>> getFilterProvider(String providerName);



    @Query("SELECT * FROM Proveedores p where p.Estatus>-1")
    Flowable<List<ProviderEntity>> getFilterProviderReceiptMerchandise();

    @Query("SELECT * FROM Proveedores p INNER JOIN Bitacora b ON b.Tabla='Proveedores' WHERE p.Fecha<=b.Fecha")
    Flowable<List<ProviderEntity>> getRegisterReceiptOfMerchandiseDetailSync();
}
