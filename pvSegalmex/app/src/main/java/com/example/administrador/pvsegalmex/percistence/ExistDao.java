package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.administrador.pvsegalmex.entity.CollectionOfPaymentEntity;
import com.example.administrador.pvsegalmex.entity.ExistEntity;
import com.example.administrador.pvsegalmex.pojo.ExistProductPojo;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface ExistDao {

    @Insert
    Long insertExist(ExistEntity existEntity);

    @Update
    int updateExist(ExistEntity existEntity);

    @Query("SELECT * FROM Existencia e")
    Flowable<List<ExistEntity>> getFilterExist();

    @Query("SELECT e.Existencia exist, e.Producto product, e.Id id, p.Id idproduct, p.Descripcion description FROM Existencia e INNER JOIN Productos p ON e.Producto=p.Id")
    Flowable<List<ExistProductPojo>> getFilterExistPojo();

    @Query("SELECT * FROM Existencia e INNER JOIN Bitacora b ON b.Tabla='Existencia' WHERE e.Fecha<=b.Fecha")
    Flowable<List<ExistEntity>> getRegisterExistSync();


    @Query("SELECT e.Existencia exist, e.Producto product, e.Id id, p.Id idproduct, p.Descripcion description FROM Existencia e INNER JOIN Productos p ON e.Producto=p.Id WHERE p.Descripcion glob '*'||:productDescription||'*'")
    Flowable<List<ExistProductPojo>> getFilterExistProductPojo(String productDescription);
}
