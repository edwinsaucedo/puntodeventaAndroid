package com.example.administrador.pvsegalmex.viewEntity;

import android.arch.lifecycle.ViewModel;

import com.example.administrador.pvsegalmex.entity.WithdrawalEntity;
import com.example.administrador.pvsegalmex.percistence.WithdrawalDao;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class WithdrawalViewEntity extends ViewModel {

    private WithdrawalDao dataSource;

    public WithdrawalViewEntity(WithdrawalDao dataSource){this.dataSource=dataSource;}

    public final Flowable getFilterWithdrawal(String date){
        return dataSource.getFilterWithdrawal(date);
    }

    public final Flowable getSum(){return dataSource.getsSum();}

    public final Flowable getRegisterWithdrawalSync(){return dataSource.getRegisterWithdrawalSync();}

    public final Completable insertWhitdrawal(final WithdrawalEntity withdrawal){
        return Completable.fromAction( ()-> WithdrawalEntity.instance.setId(dataSource.insertWithdrawal(withdrawal).intValue()));
    }

    public final Completable updateWithdrawal(final WithdrawalEntity withdrawal){
        return Completable.fromAction(()-> dataSource.updateWithdrawal(withdrawal));
    }
}
