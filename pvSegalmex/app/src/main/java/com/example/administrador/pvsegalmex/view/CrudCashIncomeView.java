package com.example.administrador.pvsegalmex.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.adapter.RvWayPayInCashShortAdapter;
import com.example.administrador.pvsegalmex.entity.BitacoraEntity;
import com.example.administrador.pvsegalmex.entity.CashIncomeDetailEntity;
import com.example.administrador.pvsegalmex.entity.CashIncomeEntity;
import com.example.administrador.pvsegalmex.entity.WayPayEntity;
import com.example.administrador.pvsegalmex.utils.DialogUtils;
import com.example.administrador.pvsegalmex.viewEntity.BitacoraViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.CashIncomeDetailViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.CashIncomeViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.WayPayViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.BitacoraViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.CashIncomeDetailViewEntitiyFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.CashIncomeViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.WayPayViewEntityFactory;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CrudCashIncomeView extends MenuView {

    //region VARS
    private CompositeDisposable compositeDisposable;
    private String tableName;
    private ArrayList<BitacoraEntity> bitacoraListCashIncome;

    //region CASH INCOME
    private CashIncomeViewEntity cashIncomeViewEntity;
    CashIncomeViewEntityFactory cashIncomeViewEntityFactory;
    //endregion

    //region CASH INCOME DETAIL
    CashIncomeDetailViewEntitiyFactory cashIncomeDetailViewEntitiyFactory;
    private CashIncomeDetailViewEntity cashIncomeDetailViewEntity;
    //endregion

    //region WAY PAY
    private WayPayViewEntity wayPayViewEntity;
    WayPayViewEntityFactory wayPayViewEntityFactory;
    private ArrayList<WayPayEntity> wayPayListCashIncome;
    private Double[] total;
    private RvWayPayInCashShortAdapter rvWayPayInCashShortAdapter;
    //endregion

    //region BINNACLE
    private BitacoraViewEntity bitacoraViewEntity;
    private BitacoraViewEntityFactory bitacoraViewEntityFactory;
    //endregion

    //endregion

    //region VIEWS
    private EditText edtComment;
    private AppCompatButton btnSaveIncome;
    private RecyclerView rvWayPayList;
    //endregion

    Double sumWayPay;
    Integer idTabla;

    //region PRIVATE METHODS
    private void inizializateViews() {
        edtComment = findViewById(R.id.edtCommentsIncome);
        btnSaveIncome = findViewById(R.id.btnSaveIncome);
        wayPayListCashIncome = new ArrayList<>();
        rvWayPayList = findViewById(R.id.rvWayPayInCashIncome);
        bitacoraListCashIncome = new ArrayList<>();
    }

    //region WAY PAY
    @SuppressWarnings("unchecked")
    private void searchWayPay() {
        compositeDisposable.add(wayPayViewEntity.getFilterWayPayCashShort()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<WayPayEntity>>) wayPayListSearch -> {
                            wayPayListCashIncome = (ArrayList<WayPayEntity>) wayPayListSearch;
                            if (wayPayListCashIncome.isEmpty())
                                Toast.makeText(getApplicationContext(), getString(R.string.noHayRegistros), Toast.LENGTH_SHORT).show();
                            total = new Double[wayPayListCashIncome.size()];
                            //obtiene el monto de forma de pago mientras se modifica
                            rvWayPayInCashShortAdapter = new RvWayPayInCashShortAdapter(wayPayListCashIncome, (position, charSeq) -> {

                                if (charSeq.isEmpty())
                                    charSeq = "0.0";
                                total[position] = Double.valueOf(charSeq);
                                updateTotalValue();
                            }, getApplicationContext()
                            );
                            rvWayPayList.setAdapter(rvWayPayInCashShortAdapter);
                        }, throwable -> {
                        }
                ));
    }

    private void updateTotalValue() {
        Double sum = 0.0;
        for (Double aTotal : total) {
            if (aTotal != null)
                sum += aTotal;
        }
        sumWayPay = sum;
    }
    //endregion

    //region CASH INCOME
    private void saveIncome() {
        clear();

        if (edtComment.getText().toString().isEmpty()) {
            edtComment.setError(getString(R.string.fieldRequired));
            return;
        }
        CashIncomeEntity cashIncomeEntity = new CashIncomeEntity();


        cashIncomeEntity.setComments(edtComment.getText().toString().trim());
        cashIncomeEntity.setAmount(sumWayPay);
        cashIncomeEntity.setDate(getDate());
        cashIncomeEntity.setUuid(generateUUID());
        cashIncomeEntity.setCashShort(1);
        cashIncomeEntity.setUuidCashShort("UUID");

        DialogUtils.showOkayNoDialog(getString(R.string.delIncomeWarningMessage), getString(R.string.delIncomeWarningTitle), this, new DialogUtils.OnOkayNoEvent() {
            @Override
            public void onYes() {
                if (CashIncomeEntity.instance.getId() == -1) {
                    insertCashIncome(cashIncomeEntity);
                }
                finish();
            }

            @Override
            public void onNo() {
            }
        });
    }

    private void insertCashIncome(CashIncomeEntity cashIncomeEntity) {
        compositeDisposable.add(cashIncomeViewEntity.insertIncome(cashIncomeEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (CashIncomeEntity.instance.getId() != -1) {
                        saveBinnacle();
                        saveCashIncomeDetail();
                    } else {
                        Toast.makeText(getApplicationContext(), "Ha ocurrido un error.", Toast.LENGTH_LONG).show();
                    }
                }));
    }

    //endregion

    //region CASH INCOME DETAIL
    private void saveCashIncomeDetail() {
        clearDetail();
        for (int i = 0; i < wayPayListCashIncome.size(); i++) {
            CashIncomeDetailEntity cashIncomeDetailEntity = new CashIncomeDetailEntity();
            cashIncomeDetailEntity.setAmount(total[i]);
            cashIncomeDetailEntity.setIdIncome(CashIncomeEntity.instance.getId());
            cashIncomeDetailEntity.setIdWayPay(wayPayListCashIncome.get(i).getId());
            cashIncomeDetailEntity.setLastDateSync(getDate());
            cashIncomeDetailEntity.setUuid(generateUUID());
            insertCashIncomeDetail(cashIncomeDetailEntity);
        }
    }

    private void insertCashIncomeDetail(CashIncomeDetailEntity cashIncomeDetailEntity) {
        compositeDisposable.add(cashIncomeDetailViewEntity.insertIncomeDetail(cashIncomeDetailEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (CashIncomeDetailEntity.instance.getId() != -1) {
                        saveBinnacleDetail();
                        this.finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Ha ocurrido un error.", Toast.LENGTH_LONG).show();
                    }
                }));
    }
    //endregion

    //region BINNACLE

    private void clear() {
        String t = "IngresosCaja";
        for (int i = 0; i < bitacoraListCashIncome.size(); i++) {
            tableName = bitacoraListCashIncome.get(i).getTable();
            if (t.equals(tableName)) {
                idTabla = bitacoraListCashIncome.get(i).getId();
            }
        }
        if (idTabla == null) {
            BitacoraEntity.instance.clear();
        }
    }

    private void clearDetail() {
        String t = "IngresosCajaDetalle";
        for (int i = 0; i < bitacoraListCashIncome.size(); i++) {
            tableName = bitacoraListCashIncome.get(i).getTable();
            if (t.equals(tableName)) {
                idTabla = bitacoraListCashIncome.get(i).getId();
            }
        }
        if (idTabla == null) {
            BitacoraEntity.instance.clear();
        }
    }

    private void saveBinnacle() {
        try {
            BitacoraEntity bitacoraEntity = new BitacoraEntity();
            bitacoraEntity.setDate(getDate());
            bitacoraEntity.setTable("IngresosCaja");
            bitacoraEntity.setIdTable(CashIncomeEntity.instance.getId());

            if (BitacoraEntity.instance.getId() == -1) {
                insertBinnacle(bitacoraEntity);
            } else {
                bitacoraEntity.setId(BitacoraEntity.instance.getId());
                updateBinnacle(bitacoraEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveBinnacleDetail() {
        try {
            BitacoraEntity bitacoraEntity = new BitacoraEntity();
            bitacoraEntity.setDate(getDate());
            bitacoraEntity.setTable("IngresosCajaDetalle");
            bitacoraEntity.setIdTable(CashIncomeEntity.instance.getId());

            if (BitacoraEntity.instance.getId() == -1) {
                insertBinnacleDetail(bitacoraEntity);
            } else {
                bitacoraEntity.setId(BitacoraEntity.instance.getId());
                updateBinnacleDetail(bitacoraEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void searchBitacora() {
        compositeDisposable.add(bitacoraViewEntity.getFilterBitacora()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<BitacoraEntity>>) bitacoraListSearch -> bitacoraListCashIncome = (ArrayList<BitacoraEntity>) bitacoraListSearch, throwable -> {
                            Toast.makeText(getApplicationContext(), getString(R.string.errorConsulta), Toast.LENGTH_LONG).show();
                            Log.e(getString(R.string.errorSQLITE), "");
                        }
                )
        );
    }

    private void insertBinnacle(BitacoraEntity bitacoraEntity) {
        compositeDisposable.add(bitacoraViewEntity.insertBitacora(bitacoraEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                })
        );
    }

    private void updateBinnacle(BitacoraEntity bitacoraEntity) {
        compositeDisposable.add(bitacoraViewEntity.updateBitacora(bitacoraEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                })
        );
    }

    private void insertBinnacleDetail(BitacoraEntity bitacoraEntity) {
        compositeDisposable.add(bitacoraViewEntity.insertBitacora(bitacoraEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                })
        );
    }

    private void updateBinnacleDetail(BitacoraEntity bitacoraEntity) {
        compositeDisposable.add(bitacoraViewEntity.updateBitacora(bitacoraEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                })
        );
    }

    //endregion
    //endregion

    //region PROTECTED METHODS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        inizializateViews();

        compositeDisposable = new CompositeDisposable();

        rvWayPayInCashShortAdapter = new RvWayPayInCashShortAdapter(wayPayListCashIncome, getApplicationContext());
        rvWayPayList.setLayoutManager(new LinearLayoutManager(this));
        rvWayPayList.setAdapter(rvWayPayInCashShortAdapter);

        bitacoraViewEntityFactory = Injection.providerBitacoraViewModelFactory(getApplicationContext());
        bitacoraViewEntity = ViewModelProviders.of(this, bitacoraViewEntityFactory).get(BitacoraViewEntity.class);
        searchBitacora();

        cashIncomeViewEntityFactory = Injection.providerCashIncomeViewModelFactory(getApplicationContext());
        cashIncomeViewEntity = ViewModelProviders.of(this, cashIncomeViewEntityFactory).get(CashIncomeViewEntity.class);

        cashIncomeDetailViewEntitiyFactory = Injection.providerCashIncomeDetailViewModelFactory(getApplicationContext());
        cashIncomeDetailViewEntity = ViewModelProviders.of(this, cashIncomeDetailViewEntitiyFactory).get(CashIncomeDetailViewEntity.class);

        btnSaveIncome.setOnClickListener(v -> saveIncome());
    }

    @Override
    protected int getPageLayoutId() {
        return R.layout.activity_crud_cash_income_view;
    }

    @Override
    protected String getScreenTitle() {
        return getString(R.string.itemMenu15);
    }

    @Override
    protected void onResume() {
        super.onResume();
        bitacoraViewEntityFactory = Injection.providerBitacoraViewModelFactory(getApplicationContext());
        bitacoraViewEntity = ViewModelProviders.of(this, bitacoraViewEntityFactory).get(BitacoraViewEntity.class);

        wayPayViewEntityFactory = Injection.providerWayPayViewModelFactory(getApplicationContext());
        wayPayViewEntity = ViewModelProviders.of(this, wayPayViewEntityFactory).get(WayPayViewEntity.class);
        searchWayPay();
    }

    //endregion
}