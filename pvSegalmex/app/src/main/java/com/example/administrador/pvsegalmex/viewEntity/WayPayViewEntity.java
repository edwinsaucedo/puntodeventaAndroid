package com.example.administrador.pvsegalmex.viewEntity;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.administrador.pvsegalmex.entity.WayPayEntity;
import com.example.administrador.pvsegalmex.percistence.WayPayDao;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.functions.Action;

public class WayPayViewEntity extends ViewModel {
    private WayPayDao dataSource;
    public List idInsertWayPay;
    public int rowCount;


    public WayPayViewEntity(WayPayDao dataSource) {
        this.dataSource = dataSource;
        idInsertWayPay=new ArrayList<>();
    }

    public final Flowable getFilterWayPay(String wayPayDescription)
    {
        return dataSource.getFilterWayPay(wayPayDescription);
    }

    public final Completable getCountWayPay(String wayPayUUID)
    {
        return Completable.fromAction(()-> rowCount = dataSource.getCountWayPay(wayPayUUID));
    }

    public final Flowable getUUIDWayPay(String wayPayUUID)
    {
        return dataSource.getUUIDWayPay(wayPayUUID);
    }

    public final Flowable getFilterWayPayCashShort()
    {
        return dataSource.getFilterWayPayinCashShort();
    }

    public final Completable insertWayPay (final WayPayEntity wayPay)
    {
        return Completable.fromAction(() -> WayPayEntity.instance.setId(dataSource.insertWayPay(wayPay).intValue()));

    }

    public final Completable insertWayPayDefault (final ArrayList<WayPayEntity> wayPay)
    {
        return Completable.fromAction(() -> idInsertWayPay=  dataSource.insertWayPayDefault(wayPay));
    }

    public final Completable updateWayPay(final WayPayEntity wayPay)
    {
        return Completable.fromAction(() -> dataSource.updateWayPay(wayPay));
    }

}
