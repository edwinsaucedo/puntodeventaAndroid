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
import com.example.administrador.pvsegalmex.adapter.RvProviderAdapter;
import com.example.administrador.pvsegalmex.controller.SwipeController;
import com.example.administrador.pvsegalmex.controller.SwipeControllerActions;
import com.example.administrador.pvsegalmex.entity.ProviderEntity;
import com.example.administrador.pvsegalmex.utils.DialogUtils;
import com.example.administrador.pvsegalmex.viewEntity.ProviderViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.ProviderViewEntityFactory;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ProviderView extends MenuView {

    //region VARS
    private ArrayList<ProviderEntity> providerList;
    private ProviderViewEntityFactory providerFactory;
    private ProviderViewEntity providerViewEntity;
    private CompositeDisposable compositeDisposable;
    //endregion

    //region VIEWS
    private EditText mProviderName;
    private RecyclerView rvProvider;
    private RvProviderAdapter rvProviderAdapter;
    private FloatingActionButton btnAddProvider, btnSearchProvider;
    ItemTouchHelper touchHelper;
    private SwipeController swipe;
    //endregion

    //region PRIVATE METHODS
    private void initializeViews() {
        mProviderName = findViewById(R.id.edtProvidername);
        btnAddProvider = findViewById(R.id.btnAddProvider);
        btnSearchProvider = findViewById(R.id.btnSearchProvider);
        rvProvider = findViewById(R.id.rvProviders);
    }
    //endregion

    //region PROTECTED METHODS
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeViews();
        providerList = new ArrayList<>();
        rvProviderAdapter = new RvProviderAdapter(providerList, getApplicationContext());
        rvProvider.setLayoutManager(new LinearLayoutManager(this));
        rvProvider.setAdapter(rvProviderAdapter);

        swipe = new SwipeController(new SwipeControllerActions() {
            @Override
            public void onLeftClicked(int position) {
                ProviderEntity providerClicked = providerList.get(position);
                DialogUtils.showOkayNoDialog(getString(R.string.delProviderWarningMessage), getString(R.string.delProviderWarningTitle), ProviderView.this, new DialogUtils.OnOkayNoEvent() {
                    @Override
                    public void onYes() {
                        deleteProvider(providerClicked);
                    }

                    @Override
                    public void onNo() {
                        Toast.makeText(getApplicationContext(), "Ok", Toast.LENGTH_SHORT).show();

                    }
                });


            }

            @Override
            public void onRightClicked(int position) {
                ProviderEntity providerClicked = providerList.get(position);
                goToEditProvider(providerClicked);
            }
        });

        touchHelper = new ItemTouchHelper(swipe);
        touchHelper.attachToRecyclerView(rvProvider);
        rvProvider.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                swipe.onDraw(c);
            }
        });

        btnAddProvider.setOnClickListener(v -> {
            ProviderEntity.instance.clear();
            startActivity(CrudProviderView.class);
        });
        btnSearchProvider.setOnClickListener(v -> searchProvider());
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    protected int getPageLayoutId() {
        return R.layout.activity_provider_view;
    }

    @Override
    protected String getScreenTitle() {
        return getString(R.string.itemMenu6);
    }

    @Override
    protected void onResume() {
        super.onResume();
        providerFactory = Injection.providerProviderViewModelFactory(getApplicationContext());
        providerViewEntity = ViewModelProviders.of(this, providerFactory).get(ProviderViewEntity.class);
        searchProvider();
    }

    private void searchProvider() {
        String provider;
        provider = mProviderName.getText().toString();

        compositeDisposable.add(providerViewEntity.getFilterProvider(provider)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<ProviderEntity>>) providerListSearch -> {
                            providerList = (ArrayList<ProviderEntity>) providerListSearch;
                            if (providerList.isEmpty())
                                Toast.makeText(getApplicationContext(), getString(R.string.noHayRegistros), Toast.LENGTH_SHORT).show();
                            rvProviderAdapter = new RvProviderAdapter(providerList, getApplicationContext());
                            rvProvider.setAdapter(rvProviderAdapter);

                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), getString(R.string.errorConsulta), Toast.LENGTH_SHORT).show();
                            Log.e(getString(R.string.errorSQLITE), "");
                        }
                ));
    }

    private void goToEditProvider(ProviderEntity provider) {
        ProviderEntity.instance.setId(provider.getId());
        ProviderEntity.instance.setName(provider.getName());
        ProviderEntity.instance.setAlias(provider.getAlias());
        ProviderEntity.instance.setRfc(provider.getRfc());
        ProviderEntity.instance.setPhone(provider.getPhone());
        ProviderEntity.instance.setEmail(provider.getEmail());
        ProviderEntity.instance.setCurp(provider.getCurp());
        ProviderEntity.instance.setDatePay(provider.getDatePay());
        ProviderEntity.instance.setCreditDays(provider.getCreditDays());
        ProviderEntity.instance.setCreditLimit(provider.getCreditLimit());
        ProviderEntity.instance.setComments(provider.getComments());
        ProviderEntity.instance.setDiconsa(provider.isDiconsa());
        Intent intent = new Intent(getApplicationContext(), CrudProviderView.class);
        startActivity(intent);
    }

    private void deleteProvider(ProviderEntity provider) {
        provider.setStatus(-1);
        compositeDisposable.add(providerViewEntity.updateProvider(provider)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> DialogUtils.showOkayDialog(ProviderView.this, getString(R.string.messageSuccTitleGlobal), getString(R.string.deleteProviderSuccess), "success"))
        );

    }

    @Override
    public void onBackPressed() {
    }
}
