package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.administrador.pvsegalmex.entity.BitacoraEntity;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface  BitacoraDao {
    @Insert
    Long insertBitacora(BitacoraEntity bitacoraEntity);

    @Update
    int updateBitacora(BitacoraEntity bitacoraEntity);

    @Query("SELECT * FROM Bitacora i WHERE i.Tabla='*'||:table||'*'")
    Flowable<BitacoraEntity> getFilterBitacoraTable(String table);

    @Query("SELECT * FROM Bitacora i")
    Flowable<List<BitacoraEntity>> getFilterBitacora();

}
