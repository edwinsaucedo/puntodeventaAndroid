package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.administrador.pvsegalmex.entity.WayPayEntity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface WayPayDao {
    @Insert
    Long insertWayPay(WayPayEntity wayPay);

    @Insert
    List<Long> insertWayPayDefault(ArrayList<WayPayEntity> wayPayList);

    @Update
    int updateWayPay(WayPayEntity wayPay);

    @Query("SELECT*FROM FormaPago w where w.Estus>-1 and w.Description glob '*'||:wayPayDescription||'*'")
    Flowable<List<WayPayEntity>> getFilterWayPay(String wayPayDescription);

    @Query("SELECT*FROM FormaPago w where w.Estus>-1")
    Flowable<List<WayPayEntity>> getFilterWayPayinCashShort();

    @Query("SELECT*FROM FormaPago w where w.UUID=:wayPayUUID")
    Flowable<List<WayPayEntity>> getUUIDWayPay(String wayPayUUID);

    @Query("SELECT COUNT(*) FROM FormaPago w where w.UUID=:wayPayUUID")
    int getCountWayPay(String wayPayUUID);
}
