package com.example.administrador.pvsegalmex.viewEntity;

import android.arch.lifecycle.ViewModel;

import com.example.administrador.pvsegalmex.entity.BitacoraEntity;
import com.example.administrador.pvsegalmex.percistence.BitacoraDao;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class BitacoraViewEntity extends ViewModel {
    private BitacoraDao dataSource;

    public BitacoraViewEntity(BitacoraDao dataSource){this.dataSource=dataSource;}

    public final Flowable getFilterBitacora(){return dataSource.getFilterBitacora();}

    public final Flowable getFilterBitacoraTable(String table){return dataSource.getFilterBitacoraTable(table);}

    public final Completable insertBitacora(final BitacoraEntity bitacoraEntity){
        return Completable.fromAction(()-> BitacoraEntity.instance.setId(dataSource.insertBitacora(bitacoraEntity).intValue()));
    }

    public final Completable updateBitacora(final BitacoraEntity bitacoraEntity){
        return Completable.fromAction(()-> dataSource.updateBitacora(bitacoraEntity));
    }
}
