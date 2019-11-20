package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.administrador.pvsegalmex.entity.StoreEntity;

import io.reactivex.Flowable;

@Dao
public interface StoreDao {

    @Insert
    Long insertStore(StoreEntity store);

    @Update
    int updateStore(StoreEntity store);

    @Query("SELECT * FROM Tienda t where t.Estatus>-1")
    Flowable<StoreEntity> getFilterStore();
}
