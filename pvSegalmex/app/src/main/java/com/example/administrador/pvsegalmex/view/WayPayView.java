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
import com.example.administrador.pvsegalmex.adapter.RvWayPayAdapter;
import com.example.administrador.pvsegalmex.controller.SwipeController;
import com.example.administrador.pvsegalmex.controller.SwipeControllerActions;
import com.example.administrador.pvsegalmex.entity.WayPayEntity;
import com.example.administrador.pvsegalmex.utils.DialogUtils;
import com.example.administrador.pvsegalmex.viewEntity.WayPayViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.WayPayViewEntityFactory;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class WayPayView extends MenuView {
    private ArrayList<WayPayEntity> wayPayList;
    WayPayViewEntityFactory wayPayFactory;
    private WayPayViewEntity wayPayViewEntity;
    private EditText wayPayDescription;
    private CompositeDisposable compositeDisposable;
    private FloatingActionButton btnAddWayPay, btnSearchWayPay;
    private RecyclerView rvWayPay;
    private RvWayPayAdapter rvWayPayAdapter;
    ItemTouchHelper touchHelper;
    private SwipeController swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wayPayList = new ArrayList<>();
        wayPayDescription = findViewById(R.id.edtWayPayDescription);
        btnAddWayPay = findViewById(R.id.btnAddWayPay);
        rvWayPay = findViewById(R.id.rvWayPay);
        btnSearchWayPay = findViewById(R.id.btnSearchWayPay);
        compositeDisposable = new CompositeDisposable();
        rvWayPayAdapter = new RvWayPayAdapter(wayPayList, getApplicationContext());
        rvWayPay.setLayoutManager(new LinearLayoutManager(this));
        rvWayPay.setAdapter(rvWayPayAdapter);
        swipe = new SwipeController(new SwipeControllerActions() {
            //Acciones correspondientes.
            @Override
            public void onLeftClicked(int position) {

                WayPayEntity wayPayClicked = wayPayList.get(position);
                DialogUtils.showOkayNoDialog(getString(R.string.delWayPayWarningMessage), getString(R.string.delWayPayWarningTitle), WayPayView.this, new DialogUtils.OnOkayNoEvent() {
                    @Override
                    public void onYes() {
                        deleteWayPay(wayPayClicked);
                    }

                    @Override
                    public void onNo() {
                        Toast.makeText(getApplicationContext(), "Ok", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onRightClicked(int position) {
                WayPayEntity wayPayClicked = wayPayList.get(position);
                goToEditWayPay(wayPayClicked);
            }
        });
        touchHelper = new ItemTouchHelper(swipe);
        touchHelper.attachToRecyclerView(rvWayPay);
        rvWayPay.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                swipe.onDraw(c);
            }
        });
        btnAddWayPay = findViewById(R.id.btnAddWayPay);
        btnAddWayPay.setOnClickListener(v -> {
            WayPayEntity.instance.clear();
            startActivity(CrudWayPayView.class);
        });
        btnSearchWayPay.setOnClickListener(v -> searchWayPay());
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    protected int getPageLayoutId() {
        return R.layout.activity_way_pay_view;
    }

    @Override
    protected String getScreenTitle() {
        return getString(R.string.itemMenu3);
    }

    @Override
    protected void onResume() {
        super.onResume();
        wayPayFactory = Injection.providerWayPayViewModelFactory(getApplicationContext());
        wayPayViewEntity = ViewModelProviders.of(this, wayPayFactory).get(WayPayViewEntity.class);
        searchWayPay();
    }

    @SuppressWarnings("unchecked")
    private void searchWayPay() {
        String description;
        description = wayPayDescription.getText().toString();
        compositeDisposable.add(wayPayViewEntity.getFilterWayPay(description)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<WayPayEntity>>) wayPayListSearch -> {
                            wayPayList = (ArrayList<WayPayEntity>) wayPayListSearch;
                            if (wayPayList.isEmpty())
                                Toast.makeText(getApplicationContext(), getString(R.string.noHayRegistros), Toast.LENGTH_SHORT).show();
                            rvWayPayAdapter = new RvWayPayAdapter(wayPayList, getApplicationContext());
                            rvWayPay.setAdapter(rvWayPayAdapter);

                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), getString(R.string.errorConsulta), Toast.LENGTH_SHORT).show();
                            Log.e(getString(R.string.errorSQLITE), "");
                        }
                ));
    }

    private void deleteWayPay(WayPayEntity wayPay) {
        wayPay.setStatus(-1);
        compositeDisposable.add(wayPayViewEntity.updateWayPay(wayPay)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> DialogUtils.showOkayDialog(WayPayView.this, getString(R.string.messageSuccTitleGlobal), getString(R.string.deleteWayPaySuccess), "success"))
        );
    }

    private void goToEditWayPay(WayPayEntity wayPay) {
        WayPayEntity.instance.setId(wayPay.getId());
        WayPayEntity.instance.setDescription(wayPay.getDescription());
        WayPayEntity.instance.setImage(wayPay.getImage());
        Intent intent = new Intent(getApplicationContext(), CrudWayPayView.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
    }
}

