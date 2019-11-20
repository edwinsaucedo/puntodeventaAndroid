package com.example.administrador.pvsegalmex.percistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.administrador.pvsegalmex.entity.CashShortDetailEntity;
import com.example.administrador.pvsegalmex.entity.ClienteEntity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;


@Dao
public interface ClienteDao {

    @Insert
    Long insertClient(ClienteEntity client);

    @Query("SELECT*FROM Cliente c where c.Estatus>-1")
    Flowable<List<ClienteEntity>> getFilterClientsSale();

    @Insert
    List<Long>insertClientDefault(ArrayList<ClienteEntity> clientList);

    @Update
    int updateClient(ClienteEntity client);

    @Query("SELECT*FROM Cliente c where c.Estatus>-1  and c.Nombre glob '*'||:clientName||'*'")
    Flowable<List<ClienteEntity>> getFilterClients(String clientName);

    @Query("SELECT*FROM Cliente c where c.Estatus>-1  and c.id glob '*'||:idClient||'*'")
    Flowable<ClienteEntity> getFilterClientId(int idClient);

    @Query("SELECT * FROM Cliente c INNER JOIN Bitacora b ON b.Tabla='Cliente' WHERE c.Fecha<=b.Fecha")
    Flowable<List<CashShortDetailEntity>> getRegisterClienteSync();
}
