package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.administrador.pvsegalmex.entity.TypeDocumentsEntity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface TypeDocumentsDao {

    @Insert
    Long insertTypeDocuments(TypeDocumentsEntity typeDocument);

    @Insert
    List<Long> insertTypeDocumentDefault(ArrayList<TypeDocumentsEntity> list);

    @Update
    int updateTypeDocuments(TypeDocumentsEntity typeDocuments);

    @Query("SELECT * FROM TipoDocumentoVta t where t.Estus>-1 and t.Descripcion glob '*'||:description||'*'")
    Flowable<List<TypeDocumentsEntity>> getFilterTypeDocuments(String description);

    @Query("SELECT * FROM TipoDocumentoVta t where t.Estus>-1 and t.Descripcion = 'VENTA'")
    Flowable<List<TypeDocumentsEntity>> getFilterTypeDoc();
}
