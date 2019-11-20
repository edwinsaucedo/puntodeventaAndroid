package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.administrador.pvsegalmex.entity.DepartmentEntity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface DepartmentDao {

    @Insert
    Long insertDepartamento(DepartmentEntity departamento);

    @Insert
    List<Long> insertDepartmentDefault(ArrayList<DepartmentEntity> departmentList);

    @Update
    int updateDepartamento(DepartmentEntity departamento);

    @Query("SELECT*FROM Departamentos d where d.Estatus>-1 and d.Descripcion glob '*'||:description||'*' ")
    Flowable<List<DepartmentEntity>> getFilterDepartamentos(String description);

    @Query("SELECT*FROM Departamentos d where d.Estatus>-1")
    Flowable<List<DepartmentEntity>> getFilterCategory();

    @Query("SELECT COUNT(*) FROM Departamentos d where d.UUID=:departmentUUID")
    int getCountDepartment(String departmentUUID);
}
