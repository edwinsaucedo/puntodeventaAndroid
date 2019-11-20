package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.administrador.pvsegalmex.entity.UserEntity;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface UserDao {

    @Insert
    Long insertUser(UserEntity userEntity);

    @Update
    int updateUser(UserEntity userEntity);

    @Query("SELECT * FROM Usuario u WHERE u.Estatus>-1")
    Flowable<List<UserEntity>> getUsers();

    @Query("SELECT * FROM Usuario u WHERE u.IdWs glob '*'||:id||'*'")
    Flowable<UserEntity> getUser(Integer id);
}
