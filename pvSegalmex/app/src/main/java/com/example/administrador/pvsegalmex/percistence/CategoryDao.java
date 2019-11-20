package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.administrador.pvsegalmex.entity.CategoryEntity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface CategoryDao {

    @Insert
    Long insertCategory(CategoryEntity category);

    @Insert
    List<Long> insertCategoryDefault(ArrayList<CategoryEntity> categoryList);

    @Update
    int updateCategory(CategoryEntity category);

    @Query("SELECT*FROM Categorias d where d.Estatus>-1 and d.Descripcion glob '*'||:description||'*' ")
    Flowable<List<CategoryEntity>> getFilterCategory(String description);

    @Query("SELECT*FROM Categorias d where d.Estatus>-1")
    Flowable<List<CategoryEntity>> getFilterProduct();

    @Query("SELECT COUNT(*) FROM Categorias c where c.UUID=:categoryUUID")
    int getCountCategory(String categoryUUID);
}
