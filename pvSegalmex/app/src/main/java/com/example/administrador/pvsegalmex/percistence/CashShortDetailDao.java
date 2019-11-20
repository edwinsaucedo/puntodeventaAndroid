package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.administrador.pvsegalmex.entity.CashShortDetailEntity;
import com.example.administrador.pvsegalmex.pojo.CashShortDetailWayPayPojo;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface CashShortDetailDao {
    @Insert
    Long insertCashShortDetail(CashShortDetailEntity cashShortDetail);

    @Update
    int updateCashShortDetail(CashShortDetailEntity cashShortDetail);

    @Query("SELECT*FROM CorteCajaDetalle d where d.Estatus>-1")
    Flowable<List<CashShortDetailEntity>> getFilterCashShortDetail();

    @Query("SELECT * FROM CorteCajaDetalle c INNER JOIN Bitacora b ON b.Tabla='CorteCajaDetalle' WHERE c.Fecha<=b.Fecha")
    Flowable<List<CashShortDetailEntity>> getRegisterCashShortDetailSync();

    @Query("SELECT c.FormaPago wayPay,c.MontoCalculado amountCalculate, c.MontoCapturado amountCapturate, c.Diference amoutDiference, f.Description wayPayDescription FROM CorteCajaDetalle c INNER JOIN FormaPago f ON c.FormaPago=f.Id WHERE c.CorteCaja=:idCashShort")
    Flowable<List<CashShortDetailWayPayPojo>> getCashShortDetailWayPay(Integer idCashShort);
}