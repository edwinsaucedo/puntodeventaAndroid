package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.administrador.pvsegalmex.entity.CategoryEntity;
import com.example.administrador.pvsegalmex.entity.UnitMeasurementEntity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface UnitMeasurementDao {

    @Insert
    Long insertUnitMeasurement(UnitMeasurementEntity unitMeasurementEntity);

    @Insert
    List<Long> insertUnitMeasurementDefault(ArrayList<UnitMeasurementEntity> unitMeasurementList);

    @Update
    int updateUnitMeasurement(UnitMeasurementEntity unitMeasurementEntity);

    @Query("SELECT * FROM UnidadMedida u")
    Flowable<List<UnitMeasurementEntity>> getUnitMeasurement();

    @Query("SELECT COUNT(*) FROM UnidadMedida u where u.UUID=:unitMeasureUUID")
    int getCountUnitMeasure(String unitMeasureUUID);
}
