package com.example.administrador.pvsegalmex.viewEntityFactory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;

import com.example.administrador.pvsegalmex.entity.SalesDetailEntity;
import com.example.administrador.pvsegalmex.percistence.SalesDetailDao;
import com.example.administrador.pvsegalmex.viewEntity.SalesDetailViewEntity;

public class SalesDetailViewEntityFactory implements ViewModelProvider.Factory {

    private SalesDetailDao datasource;

    public SalesDetailViewEntityFactory(SalesDetailDao datasource) {
        this.datasource = datasource;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

      if(modelClass.isAssignableFrom(SalesDetailViewEntity.class)) {
          return (T) (new SalesDetailViewEntity(datasource));
      }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
