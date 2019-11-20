package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.administrador.pvsegalmex.entity.CashRegisterEntity;

import io.reactivex.Flowable;

@Dao
public interface CashRegisterDao {

    @Insert
    Long insertCashRegister(CashRegisterEntity cashRegisterEntity);

    @Update
    int updateCashRester(CashRegisterEntity cashRegisterEntity);

    @Query("SELECT * FROM CajaRegistradora c where c.Estatus>-1")
    Flowable<CashRegisterEntity> getFilterCashRegister();
}
