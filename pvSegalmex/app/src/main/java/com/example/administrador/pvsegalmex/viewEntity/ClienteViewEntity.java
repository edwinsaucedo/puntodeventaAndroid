package com.example.administrador.pvsegalmex.viewEntity;

import android.arch.lifecycle.ViewModel;

import com.example.administrador.pvsegalmex.entity.ClienteEntity;
import com.example.administrador.pvsegalmex.percistence.ClienteDao;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class ClienteViewEntity extends ViewModel {
    private ClienteDao dataSource;
    public List idInsertClient;


    public ClienteViewEntity(ClienteDao dataSource) {
        this.dataSource = dataSource;
        idInsertClient = new ArrayList<>();
    }

    public final Flowable getFilterClients(String clientName) {
        return dataSource.getFilterClients(clientName);
    }

    public final Flowable getRegisterClienteSync() {
        return dataSource.getRegisterClienteSync();
    }

    public final Flowable getFilterClientsSale() {
        return dataSource.getFilterClientsSale();
    }

    public final Flowable getFilterClientId(int id) {
        return dataSource.getFilterClientId(id);
    }

    public final Completable insertClient(final ClienteEntity client) {
        return Completable.fromAction(() -> ClienteEntity.instance.setId(dataSource.insertClient(client).intValue()));
    }

    public final Completable insertClientDefault(final ArrayList<ClienteEntity> client) {
        return Completable.fromAction(() -> idInsertClient = dataSource.insertClientDefault(client));
    }

    public final Completable updateClient(final ClienteEntity client) {
        return Completable.fromAction(() -> dataSource.updateClient(client));
    }
}
