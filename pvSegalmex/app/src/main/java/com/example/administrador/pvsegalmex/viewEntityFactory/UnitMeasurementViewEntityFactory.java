package com.example.administrador.pvsegalmex.viewEntityFactory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.administrador.pvsegalmex.percistence.UnitMeasurementDao;
import com.example.administrador.pvsegalmex.viewEntity.UnitMeasurementViewEntity;

public class UnitMeasurementViewEntityFactory implements ViewModelProvider.Factory {

    private UnitMeasurementDao unitMeasurementDao;

    public UnitMeasurementViewEntityFactory(UnitMeasurementDao unitMeasurementDao){this.unitMeasurementDao = unitMeasurementDao;}

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(UnitMeasurementViewEntity.class)){
            return (T) (new UnitMeasurementViewEntity(unitMeasurementDao));
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
