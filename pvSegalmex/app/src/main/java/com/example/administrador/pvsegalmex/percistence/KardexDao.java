package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.administrador.pvsegalmex.entity.ExistEntity;
import com.example.administrador.pvsegalmex.entity.KardexEntity;
import com.example.administrador.pvsegalmex.pojo.KardexProductPojo;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface KardexDao {

    @Insert
    Long insertKardex(KardexEntity kardex);

    @Update
    int updateKardex(KardexEntity kardex);

    @Query("SELECT * FROM Kardex k where k.Estatus>-1")
    Flowable<List<KardexEntity>> getFilterKardex();

    @Query("SELECT * FROM Kardex k INNER JOIN Bitacora b ON b.Tabla='Kardex' WHERE k.Fecha<=b.Fecha")
    Flowable<List<ExistEntity>> getRegisterKardexSync();

   }
