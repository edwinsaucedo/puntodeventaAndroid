package com.example.administrador.pvsegalmex.viewEntity;

import android.arch.lifecycle.ViewModel;

import com.example.administrador.pvsegalmex.entity.WithdrawalDetailEntity;
import com.example.administrador.pvsegalmex.percistence.WithdrawalDetailDao;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class WithdrawalDetailViewEntity extends ViewModel {
    private WithdrawalDetailDao dataSource;

    public WithdrawalDetailViewEntity(WithdrawalDetailDao dataSource) {
        this.dataSource = dataSource;
    }

    public final Flowable getWithdrawalSync(){
        return  dataSource.getWithdrawalSync();
    }

    public final Completable insertWithdrawalDetail(final WithdrawalDetailEntity withdrawalDetailEntity){
        return Completable.fromAction(()-> WithdrawalDetailEntity.instance.setId(dataSource.insertWithdrawalDetail(withdrawalDetailEntity).intValue()));
    }
}
