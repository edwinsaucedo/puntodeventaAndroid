package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.administrador.pvsegalmex.entity.WithdrawalDetailEntity;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface WithdrawalDetailDao {

    @Insert
    Long insertWithdrawalDetail(WithdrawalDetailEntity withdrawalDetailEntity);


    @Query("SELECT * FROM RetiroCajaDetalle rd INNER JOIN Bitacora b ON b.Tabla='RetiroCajaDetalle' WHERE rd.UltimaActualizacion<=b.Fecha")
    Flowable<List<WithdrawalDetailEntity>> getWithdrawalSync();
}
