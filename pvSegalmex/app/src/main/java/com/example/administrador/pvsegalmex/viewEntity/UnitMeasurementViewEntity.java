package com.example.administrador.pvsegalmex.viewEntity;

import android.arch.lifecycle.ViewModel;

import com.example.administrador.pvsegalmex.entity.CategoryEntity;
import com.example.administrador.pvsegalmex.entity.UnitMeasurementEntity;
import com.example.administrador.pvsegalmex.percistence.UnitMeasurementDao;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class UnitMeasurementViewEntity extends ViewModel {
    private UnitMeasurementDao dataSource;
    public List idUnitMeasurement;
    public int rowCount;

    public UnitMeasurementViewEntity(UnitMeasurementDao dataSource){
        this.dataSource = dataSource;
        idUnitMeasurement = new ArrayList<>();
    }

    public final Flowable getFitlerUnitMeasurament() {
        return dataSource.getUnitMeasurement();
    }

    public final Completable getCountUnitMeasure(String unitMeasureUUID) {
        return Completable.fromAction(() -> rowCount = dataSource.getCountUnitMeasure(unitMeasureUUID));
    }

    public final Completable insertUnitMeasurement(final UnitMeasurementEntity unitMeasurementEntity) {
        return Completable.fromAction(() -> UnitMeasurementEntity.instance.setId(dataSource.insertUnitMeasurement(unitMeasurementEntity).intValue()));
    }

    public final Completable insertUnitMeasurementDefault (final ArrayList<UnitMeasurementEntity> unitMeasurementEntity)
    {
        return Completable.fromAction(() -> idUnitMeasurement=  dataSource.insertUnitMeasurementDefault(unitMeasurementEntity));
    }

    public final Completable updateUnitMeasurement(final UnitMeasurementEntity unitMeasurementEntity) {
        return Completable.fromAction(() -> dataSource.updateUnitMeasurement(unitMeasurementEntity));
    }
}