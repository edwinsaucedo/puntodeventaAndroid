package com.example.administrador.pvsegalmex.viewEntityFactory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.administrador.pvsegalmex.entity.UserEntity;
import com.example.administrador.pvsegalmex.percistence.UserDao;
import com.example.administrador.pvsegalmex.viewEntity.StoreViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.UserViewEntity;

public class UserViewEntityFactory implements ViewModelProvider.Factory {

    private UserDao userDao;

    public UserViewEntityFactory(UserDao userDao) {
        this.userDao = userDao;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(UserViewEntity.class)){
            return (T) (new UserViewEntity(userDao));
    }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
