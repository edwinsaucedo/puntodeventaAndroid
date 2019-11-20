package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.administrador.pvsegalmex.entity.CashIncomeDetailEntity;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface CashIncomeDetailDao {

    @Insert
    Long insertCashIncomeDetail(CashIncomeDetailEntity cashIncomeDetailEntity);

    @Update
    int updateCashIncomeDetail(CashIncomeDetailEntity cashIncomeDetailEntity);

    @Query("SELECT * FROM IngresosDetalle id INNER JOIN Bitacora b ON b.Tabla='IngresosDetalle' WHERE id.UltimaActualizacion<=b.Fecha")
    Flowable<List<CashIncomeDetailEntity>> getCashIncomeDetailSync();
}
