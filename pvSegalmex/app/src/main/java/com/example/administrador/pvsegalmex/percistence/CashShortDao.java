package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.administrador.pvsegalmex.entity.CashShortEntity;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface CashShortDao {
    @Insert
    Long insertCashShort(CashShortEntity cashShort);

    @Update
    int updateCashShort(CashShortEntity cashShort);

    @Query("SELECT*FROM CorteCaja d WHERE d.Id>1")
    Flowable<List<CashShortEntity>> getFilterCashShort();

    @Query("SELECT*FROM CorteCaja d")
    Flowable<List<CashShortEntity>> getAllCashShort();

    @Query("SELECT * FROM CorteCaja c INNER JOIN Bitacora b ON b.Tabla='CorteCaja' WHERE c.Fecha<=b.Fecha")
    Flowable<List<CashShortEntity>> getRegisterCashShortSync();
}