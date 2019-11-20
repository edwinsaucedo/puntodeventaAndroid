package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.administrador.pvsegalmex.entity.WithdrawalEntity;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface WithdrawalDao {

    @Insert
    Long insertWithdrawal(WithdrawalEntity withdrawal);

    @Update
    int updateWithdrawal(WithdrawalEntity withdrawal);

    @Query("SELECT * FROM RetiroCaja r where Fecha glob '*'||:date||'*'")
    Flowable<List<WithdrawalEntity>> getFilterWithdrawal(String date);

    @Query("SELECT * FROM RetiroCaja r")
    Flowable<List<WithdrawalEntity>> getsSum();

    @Query("SELECT * FROM RetiroCaja r INNER JOIN Bitacora b ON b.Tabla='RetiroCaja' WHERE r.Fecha<=b.Fecha")
    Flowable<List<WithdrawalEntity>> getRegisterWithdrawalSync();
}
