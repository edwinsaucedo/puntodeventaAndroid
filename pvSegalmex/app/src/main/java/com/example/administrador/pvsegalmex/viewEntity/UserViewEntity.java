package com.example.administrador.pvsegalmex.viewEntity;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.administrador.pvsegalmex.entity.UserEntity;
import com.example.administrador.pvsegalmex.percistence.UserDao;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class UserViewEntity extends ViewModel {
    private UserDao dataSource;

    public UserViewEntity(UserDao dataSource) {
        this.dataSource = dataSource;
    }

    public final Completable insertUser(final UserEntity user){
        return Completable.fromAction(()-> UserEntity.instance.setId(dataSource.insertUser(user).intValue()));
    }

    public final Completable update(final  UserEntity user){
        return Completable.fromAction(()-> dataSource.updateUser(user));
    }

    public final Flowable getUser(){
        return dataSource.getUsers();
    }

    public final Flowable getFilterUser(Integer id){
        return dataSource.getUser(id);
    }
}
