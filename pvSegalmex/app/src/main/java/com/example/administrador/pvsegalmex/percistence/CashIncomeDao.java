package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.administrador.pvsegalmex.entity.CashIncomeEntity;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface CashIncomeDao {

    @Insert
    Long insertIncome(CashIncomeEntity cashIncomeEntity);

    @Update
    int updateIncome(CashIncomeEntity cashIncomeEntity);

    @Query("SELECT * FROM Ingresos i WHERE i.Estatus>-1 AND Fecha glob '*'||:date||'*'")
    Flowable<List<CashIncomeEntity>> getFilterIncome(String date);

    @Query("SELECT * FROM Ingresos i")
    Flowable<List<CashIncomeEntity>> getsSum();

    @Query("SELECT * FROM Ingresos i INNER JOIN Bitacora b ON b.Tabla='IngresosCaja' WHERE i.Fecha<=b.Fecha")
    Flowable<List<CashIncomeEntity>> getRegisterCashIncomeSync();
}
