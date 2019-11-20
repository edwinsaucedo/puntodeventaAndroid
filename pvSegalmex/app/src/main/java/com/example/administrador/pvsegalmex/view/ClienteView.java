package com.example.administrador.pvsegalmex.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.adapter.RvClientAdapter;
import com.example.administrador.pvsegalmex.controller.SwipeController;
import com.example.administrador.pvsegalmex.controller.SwipeControllerActions;
import com.example.administrador.pvsegalmex.entity.ClienteEntity;
import com.example.administrador.pvsegalmex.utils.DialogUtils;
import com.example.administrador.pvsegalmex.viewEntity.ClienteViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.ClienteViewEntityFactory;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ClienteView extends MenuView {
    private ArrayList<ClienteEntity> clientList;
    private ClienteViewEntityFactory clientFactory;
    private ClienteViewEntity clientViewEntity;
    private EditText clientName;
    private CompositeDisposable compositeDisposable;
    private RecyclerView rvClients;
    private RvClientAdapter rvClientAdapter;
    private SwipeController swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        clientList = new ArrayList<>();
        clientName = findViewById(R.id.edtClientName);
        rvClients = findViewById(R.id.rvClients);
        FloatingActionButton btnSearch = findViewById(R.id.btnSearch);
        rvClientAdapter = new RvClientAdapter(clientList, getApplicationContext());
        rvClients.setLayoutManager(new LinearLayoutManager(this));
        rvClients.setAdapter(rvClientAdapter);

        clientFactory = Injection.providerClientViewModelFactory(getApplicationContext());
        clientViewEntity = ViewModelProviders.of(this, clientFactory).get(ClienteViewEntity.class);

        swipe = new SwipeController(new SwipeControllerActions() {
            @Override
            public void onLeftClicked(int position) {
                ClienteEntity clientClicked = clientList.get(position);
                DialogUtils.showOkayNoDialog(getString(R.string.delClientWarningMessage), getString(R.string.delClientWarningTitle), ClienteView.this, new DialogUtils.OnOkayNoEvent() {
                    @Override
                    public void onYes() {

                        if (clientClicked.getId() == 1) {

                            Toast.makeText(getApplicationContext(), getString(R.string.noBorrarRegistro), Toast.LENGTH_SHORT).show();
                        } else {
                            deleteClient(clientClicked);
                        }
                    }

                    @Override
                    public void onNo() {
                        Toast.makeText(getApplicationContext(), getString(R.string.dialogOk), Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onRightClicked(int position) {
                ClienteEntity clientClicked = clientList.get(position);
                goToEditClient(clientClicked);
            }
        });
        ItemTouchHelper touchHelper = new ItemTouchHelper(swipe);
        touchHelper.attachToRecyclerView(rvClients);
        rvClients.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                swipe.onDraw(c);
            }
        });
        FloatingActionButton btnAddClient = findViewById(R.id.btnAddClient);
        btnAddClient.setOnClickListener(v -> {
            ClienteEntity.instance.clear();
            startActivity(CrudClienteView.class);
        });
        btnSearch.setOnClickListener(v -> searchClient());
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    protected int getPageLayoutId() {
        return R.layout.activity_cliente_view;
    }

    @Override
    protected String getScreenTitle() {
        return getString(R.string.itemMenu2);
    }

    @Override
    protected void onResume() {
        super.onResume();
        clientFactory = Injection.providerClientViewModelFactory(getApplicationContext());
        clientViewEntity = ViewModelProviders.of(this, clientFactory).get(ClienteViewEntity.class);
        searchClient();
    }

    //region PRIVATE METHODS
    @SuppressWarnings("unchecked")
    private void searchClient() {
        String client;
        client = clientName.getText().toString();
        compositeDisposable.add(clientViewEntity.getFilterClients(client)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<ClienteEntity>>) clientListSearch -> {
                            clientList = (ArrayList<ClienteEntity>) clientListSearch;
                            if (clientList.isEmpty())
                                Toast.makeText(getApplicationContext(), getString(R.string.noHayRegistros), Toast.LENGTH_SHORT).show();
                            rvClientAdapter = new RvClientAdapter(clientList, getApplicationContext());
                            rvClients.setAdapter(rvClientAdapter);
                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), getString(R.string.errorConsulta), Toast.LENGTH_SHORT).show();
                            Log.e(getString(R.string.errorSQLITE), "");
                        }
                ));
    }

    private void goToEditClient(ClienteEntity client) {
        ClienteEntity.instance.setId(client.getId());
        ClienteEntity.instance.setName(client.getName());
        ClienteEntity.instance.setLastName1(client.getLastName1());
        ClienteEntity.instance.setLastName2(client.getLastName2());
        ClienteEntity.instance.setCurp(client.getCurp());
        ClienteEntity.instance.setAddress(client.getAddress());
        ClienteEntity.instance.setPhone(client.getPhone());
        ClienteEntity.instance.setMail(client.getMail());
        ClienteEntity.instance.setCreditDays(client.getCreditDays());
        ClienteEntity.instance.setCreditLimit(client.getCreditLimit());
        ClienteEntity.instance.setGenre(client.getGenre());
        ClienteEntity.instance.setIneString(client.getIneString());
        ClienteEntity.instance.setPhotoClient(client.getPhotoClient());
        ClienteEntity.instance.setPhotoIne(client.getPhotoIne());
        Intent intent = new Intent(getApplicationContext(), CrudClienteView.class);
        startActivity(intent);
    }

    private void deleteClient(ClienteEntity client) {
        client.setStatus(-1);
        compositeDisposable.add(clientViewEntity.updateClient(client)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> DialogUtils.showOkayDialog(ClienteView.this, getString(R.string.messageSuccTitleGlobal), getString(R.string.deleteClientSuccess), "success"))
        );
    }
    //endregion

    @Override
    public void onBackPressed() {
    }
}
