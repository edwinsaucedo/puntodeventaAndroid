package com.example.administrador.pvsegalmex.view;

import android.Manifest;
import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.adapter.RvWayPayInCashShortAdapter;
import com.example.administrador.pvsegalmex.entity.BitacoraEntity;
import com.example.administrador.pvsegalmex.entity.CashIncomeEntity;
import com.example.administrador.pvsegalmex.entity.CashShortDetailEntity;
import com.example.administrador.pvsegalmex.entity.CashShortEntity;
import com.example.administrador.pvsegalmex.entity.CollectionOfPaymentEntity;
import com.example.administrador.pvsegalmex.entity.SalesEntity;
import com.example.administrador.pvsegalmex.entity.UserEntity;
import com.example.administrador.pvsegalmex.entity.WayPayEntity;
import com.example.administrador.pvsegalmex.entity.WithdrawalEntity;
import com.example.administrador.pvsegalmex.utils.TemplatePDF;
import com.example.administrador.pvsegalmex.viewEntity.BitacoraViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.CashIncomeViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.CashShortDetailViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.CashShortViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.CollectionOfPaymentViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.SalesViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.WayPayViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.WithdrawalViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.BitacoraViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.CashIncomeViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.CashShortDetailViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.CashShortViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.CollectionOfPaymentViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.SalesViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.WayPayViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.WithdrawalViewEntityFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CrudCashShortDetailView extends MenuView {

    //region TICKET
    private TemplatePDF templatePDF;
    private String[] header = {"Descripción", "Monto"};
    private String titleTicket;
    final int PERMISSION_REQUEST_CODE = 1001;
    //endregion

    //region VARS
    private CompositeDisposable compositeDisposable;
    private Integer idTabla;
    private String tableName;
    private Double sumSale, sumWithdrawal, sumIncome, sumTotal;

    //region CASH SHORT
    private CashShortViewEntity cashShortViewEntity;
    private CashShortViewEntityFactory cashShortViewEntityFactory;
    //endregion

    //region VENTA COBRO
    private CollectionOfPaymentViewEntity collectionOfPaymentViewEntity;
    private CollectionOfPaymentViewEntityFactory collectionOfPaymentViewEntityFactory;
    private ArrayList<CollectionOfPaymentEntity> collectionOfPaymentListCashShort;
    //endregion

    //region WAY PAY
    private ArrayList<WayPayEntity> wayPayListCashShort;
    private Double[] total;
    private WayPayViewEntity wayPayViewEntity;
    WayPayViewEntityFactory wayPayViewEntityFactory;
    private RvWayPayInCashShortAdapter rvWayPayInCashShortAdapter;
    //endregion

    //region CASH SHORT DETAIL
    private CashShortDetailViewEntity cashShortDetailViewEntity;
    CashShortDetailViewEntityFactory cashShortDetailViewEntityFactory;
    //endregion

    //region BITACORA
    private BitacoraViewEntity bitacoraViewEntity;
    private BitacoraViewEntityFactory bitacoraViewEntityFactory;
    private ArrayList<BitacoraEntity> bitacoraListCashShort;
    //endregion

    //region SALE
    private SalesViewEntity salesViewEntity;
    private SalesViewEntityFactory salesViewEntityFactory;
    private ArrayList<SalesEntity> salesListCashShort;
    //endregion

    //region INCOME
    private CashIncomeViewEntity cashIncomeViewEntity;
    private CashIncomeViewEntityFactory cashIncomeViewEntityFactory;
    private ArrayList<CashIncomeEntity> cashIncomeListCashShort;
    //endregion

    //region WITHDRAWAL
    private WithdrawalViewEntity withdrawalViewEntity;
    private WithdrawalViewEntityFactory withdrawalViewEntityFactory;
    private ArrayList<WithdrawalEntity> withdrawalListCashShort;
    //endregion

    private Boolean insertCashShort = false;
    //endregion

    //region VIEWS
    private TextView edtAmountCap, edtAmountCal, edtDiference;
    private AppCompatButton btnSaveCashShort;
    private RecyclerView rvWayPayList;
    //endregion

    //region PRIVATE METHODS
    private void initializeViews() {
        wayPayListCashShort = new ArrayList<>();
        salesListCashShort = new ArrayList<>();
        withdrawalListCashShort = new ArrayList<>();
        cashIncomeListCashShort = new ArrayList<>();
        collectionOfPaymentListCashShort = new ArrayList<>();
        rvWayPayList = findViewById(R.id.rvWayPayInCashShort);
        edtDiference = findViewById(R.id.edtCashShortDiference);
        edtAmountCal = findViewById(R.id.edtCashShortAmoiuntCal);
        edtAmountCap = findViewById(R.id.edtCashShortAmoiuntCap);
        btnSaveCashShort = findViewById(R.id.btnSaveCashShort);
    }

    private void initializeEditText() {
        edtAmountCap.setText("0");

        if (edtAmountCap.getText().toString().equals("0")) {
            edtAmountCap.setSelectAllOnFocus(true);
        }
        edtAmountCap.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (edtAmountCap.getText().toString().isEmpty() || edtAmountCap.getText().toString().equals(" ")) {
                    edtAmountCap.setText(String.valueOf(0));
                    if (edtAmountCap.getText().toString().equals("0")) {
                        edtAmountCap.setSelectAllOnFocus(true);
                    }
                }
                Double diference = Double.parseDouble(edtAmountCal.getText().toString()) - Double.parseDouble(edtAmountCap.getText().toString());
                edtDiference.setText(String.valueOf(diference));
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    //region TICKET
    private void dataPDF() {

        if (titleTicket == null || titleTicket.isEmpty()) {
            titleTicket = "Punto Cytruss";
        }
        templatePDF = new TemplatePDF(getApplicationContext());
        templatePDF.openDocumente();

        String shortText = "Corte de Caja";
        String longTex = "___________________________";
        String addressTicket = "";

        templatePDF.addTitles(titleTicket, addressTicket);
        templatePDF.addParagraph(shortText);
        templatePDF.createTable(header, getProduct());
        templatePDF.addParagraph(longTex);
        templatePDF.addParagraph("Total: " + edtAmountCap.getText().toString());
        templatePDF.closeDocumente();
    }

    @SuppressLint("SimpleDateFormat")
    public String getDate() {
        Date objDate = new Date();
        String strDateFormat = "dd/mm/yyyy KK:mm:ss";
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
        return String.valueOf(objSDF.format(objDate));
    }

    private void openPDF() {
        boolean result = permissionCheck();
        if (result)
            templatePDF.appViewPDF(this);
    }

    private boolean permissionCheck() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
                    checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
            ) {

                ActivityCompat.requestPermissions(CrudCashShortDetailView.this,
                        new String[]{

                                Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE
                        },
                        PERMISSION_REQUEST_CODE);
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    private ArrayList<String[]> getProduct() {
        ArrayList<String[]> rows = new ArrayList<>();
        for (int i = 0; i < wayPayListCashShort.size(); i++) {
            Double amountCap;
            if (total[i] == null) {
                amountCap = 0.0;
            } else {
                amountCap = total[i];
            }
            rows.add(new String[]{wayPayListCashShort.get(i).getDescription(), String.valueOf(amountCap)});
        }
        return rows;
    }
    //endregion

    //region WAY PAY
    //Busca FormasPago para calcular el MontoCapturado
    @SuppressWarnings("unchecked")
    private void searchWayPay() {
        compositeDisposable.add(wayPayViewEntity.getFilterWayPayCashShort()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<WayPayEntity>>) wayPayListSearch -> {
                            wayPayListCashShort = (ArrayList<WayPayEntity>) wayPayListSearch;
                            if (wayPayListCashShort.isEmpty())
                                Toast.makeText(getApplicationContext(), getString(R.string.noHayRegistros), Toast.LENGTH_SHORT).show();
                            total = new Double[wayPayListCashShort.size()];
                            //obtiene el monto de forma de pago mientras se modifica
                            rvWayPayInCashShortAdapter = new RvWayPayInCashShortAdapter(wayPayListCashShort, (position, charSeq) -> {

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
    //endregion

    //region BINNACLE
    @SuppressWarnings("unchecked")
    private void searchBitacora() {
        compositeDisposable.add(bitacoraViewEntity.getFilterBitacora()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<BitacoraEntity>>) bitacoraListSearch -> bitacoraListCashShort = (ArrayList<BitacoraEntity>) bitacoraListSearch, throwable -> {

                        }
                )
        );
    }

    //region CASH SHORT
    private void clearCashShort() {
        String t = "CorteCaja";
        for (int i = 0; i < bitacoraListCashShort.size(); i++) {
            tableName = bitacoraListCashShort.get(i).getTable();
            if (t.equals(tableName)) {
                idTabla = bitacoraListCashShort.get(i).getId();
            }
        }
        if (idTabla == null) {
            BitacoraEntity.instance.clear();
        }
    }

    private void saveBinnacleCashShort() {
        try {
            BitacoraEntity bitacoraEntity = new BitacoraEntity();
            clearCashShort();
            bitacoraEntity.setDate(getDate());
            bitacoraEntity.setTable("CorteCaja");
            bitacoraEntity.setIdTable(CashIncomeEntity.instance.getId());

            if (BitacoraEntity.instance.getId() == -1) {
                insertBinnacleCashShort(bitacoraEntity);
            } else {
                bitacoraEntity.setId(BitacoraEntity.instance.getId());
                updateBinnacleCashShort(bitacoraEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertBinnacleCashShort(BitacoraEntity bitacoraEntity) {
        compositeDisposable.add(bitacoraViewEntity.insertBitacora(bitacoraEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                })
        );
    }

    private void updateBinnacleCashShort(BitacoraEntity bitacoraEntity) {
        compositeDisposable.add(bitacoraViewEntity.updateBitacora(bitacoraEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                })
        );
    }
    //endregion

    //region CASH SHORT DETAIL
    private void clearCashShortDetail() {
        String t = "CorteCajaDetalle";
        for (int i = 0; i < bitacoraListCashShort.size(); i++) {
            tableName = bitacoraListCashShort.get(i).getTable();
            if (t.equals(tableName)) {
                idTabla = bitacoraListCashShort.get(i).getId();
            }
        }
        if (idTabla == null) {
            BitacoraEntity.instance.clear();
        }
    }

    private void saveBinnacleDetalle() {
        try {
            BitacoraEntity bitacoraEntity = new BitacoraEntity();
            clearCashShortDetail();
            bitacoraEntity.setDate(getDate());
            bitacoraEntity.setTable("CorteCajaDetalle");
            bitacoraEntity.setIdTable(CashIncomeEntity.instance.getId());

            if (BitacoraEntity.instance.getId() == -1) {
                insertBinnacleDetalle(bitacoraEntity);
            } else {
                bitacoraEntity.setId(BitacoraEntity.instance.getId());
                updateBinnacleDetalle(bitacoraEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertBinnacleDetalle(BitacoraEntity bitacoraEntity) {
        compositeDisposable.add(bitacoraViewEntity.insertBitacora(bitacoraEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                })
        );
    }

    private void updateBinnacleDetalle(BitacoraEntity bitacoraEntity) {
        compositeDisposable.add(bitacoraViewEntity.updateBitacora(bitacoraEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                })
        );
    }
    //endregion

    //region BINNACLE INCOME
    private void clearIncome() {
        String t = "IngresosCaja";
        for (int i = 0; i < bitacoraListCashShort.size(); i++) {
            tableName = bitacoraListCashShort.get(i).getTable();
            if (t.equals(tableName)) {
                idTabla = bitacoraListCashShort.get(i).getId();
            }
        }
        if (idTabla == null) {
            BitacoraEntity.instance.clear();
        }
    }

    private void saveBinnacleIncome() {
        try {
            BitacoraEntity bitacoraEntity = new BitacoraEntity();
            clearIncome();
            bitacoraEntity.setDate(getDate());
            bitacoraEntity.setTable("IngresosCaja");
            bitacoraEntity.setIdTable(CashIncomeEntity.instance.getId());
            bitacoraEntity.setId(BitacoraEntity.instance.getId());
            updateBinnacleIncome(bitacoraEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateBinnacleIncome(BitacoraEntity bitacoraEntity) {
        compositeDisposable.add(bitacoraViewEntity.updateBitacora(bitacoraEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                })
        );
    }
    //endregion

    //region BINNACLE WITHDRAWAL
    private void clearWithdrawal() {
        String t = "RetiroCaja";
        for (int i = 0; i < bitacoraListCashShort.size(); i++) {
            tableName = bitacoraListCashShort.get(i).getTable();
            if (t.equals(tableName)) {
                idTabla = bitacoraListCashShort.get(i).getId();
            }
        }
        if (idTabla == null) {
            BitacoraEntity.instance.clear();
        }
    }

    private void saveBinnacleWithdrawal() {
        try {
            BitacoraEntity bitacoraEntity = new BitacoraEntity();
            clearWithdrawal();
            bitacoraEntity.setDate(getDate());
            bitacoraEntity.setTable("RetiroCaja");
            bitacoraEntity.setIdTable(WithdrawalEntity.instance.getId());
            bitacoraEntity.setId(BitacoraEntity.instance.getId());
            updateBinnacleWithdrawal(bitacoraEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateBinnacleWithdrawal(BitacoraEntity bitacoraEntity) {
        compositeDisposable.add(bitacoraViewEntity.updateBitacora(bitacoraEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                })
        );
    }
    //endregion

    //region SALE
    private void clearTableBinacleVenta() {
        String t = "Venta";
        for (int i = 0; i < bitacoraListCashShort.size(); i++) {
            tableName = bitacoraListCashShort.get(i).getTable();
            if (t.equals(tableName)) {
                idTabla = bitacoraListCashShort.get(i).getId();
            }
        }
        if (idTabla == null) {
            BitacoraEntity.instance.clear();
        }
    }

    private void saveBinnacleSale() {
        try {
            BitacoraEntity bitacoraEntity = new BitacoraEntity();
            clearTableBinacleVenta();
            bitacoraEntity.setDate(getDate());
            bitacoraEntity.setTable("Venta");
            bitacoraEntity.setIdTable(SalesEntity.instance.getId());
            bitacoraEntity.setId(BitacoraEntity.instance.getId());
            updateBinnacleSale(bitacoraEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateBinnacleSale(BitacoraEntity bitacoraEntity) {
        compositeDisposable.add(bitacoraViewEntity.updateBitacora(bitacoraEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                })
        );
    }
    //endregion

    private void clearTableBinnacleCobro() {
        String t = "CobroVenta";
        for (int i = 0; i < bitacoraListCashShort.size(); i++) {
            tableName = bitacoraListCashShort.get(i).getTable();
            if (t.equals(tableName)) {
                idTabla = bitacoraListCashShort.get(i).getId();
            }
        }
        if (idTabla == null) {
            BitacoraEntity.instance.clear();
        }
    }

    private void saveBinnacleCobro() {
        try {
            BitacoraEntity bitacoraEntity = new BitacoraEntity();
            clearTableBinnacleCobro();
            bitacoraEntity.setDate(getDate());
            bitacoraEntity.setTable("CobroVenta");
            bitacoraEntity.setIdTable(CollectionOfPaymentEntity.instance.getId());
            bitacoraEntity.setId(BitacoraEntity.instance.getId());
            updateBinnacleCobro(bitacoraEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateBinnacleCobro(BitacoraEntity bitacoraEntity) {
        compositeDisposable.add(bitacoraViewEntity.updateBitacora(bitacoraEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                })
        );
    }
    //endregion
    //endregion

    //region OPERATIONS
    //suma el total en MontoCapturado
    private void updateTotalValue() {
        Double sum = 0.0;
        for (Double aTotal : total) {
            if (aTotal != null)
                sum += aTotal;
        }
        edtAmountCap.setText(String.valueOf(sum));
    }

    //endregion

    //region COLLECTION

    //endregion

    //region CASH SHORT
    private void saveCashShort() {
        String uuid = generateUUID();
        CashShortEntity cashShortEntity = new CashShortEntity();
        cashShortEntity.setDate(getDate());
        cashShortEntity.setUser(UserEntity.instance.getId());
        cashShortEntity.setAmountCap(Double.parseDouble(edtAmountCap.getText().toString()));
        cashShortEntity.setDiference(Double.parseDouble(edtDiference.getText().toString()));
        cashShortEntity.setTotalCal(Double.parseDouble(edtAmountCal.getText().toString()));
        cashShortEntity.setUuid(uuid);
        insertCashShort = true;

        if (CashShortEntity.instance.getId() == -1) {
            insertCashShort(cashShortEntity);
        } else {
            Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
        }
    }

    private void insertCashShort(CashShortEntity cashShort) {
        compositeDisposable.add(cashShortViewEntity.insertCashShort(cashShort)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    try {
                        if (CashShortEntity.instance.getId() != -1) {
                            dataPDF();
                            saveCashShortDetail();
                            saveBinnacleCashShort();
                            saveIncome();
                            saveSales();
                            saveWithdrawal();
                            saveCollection();

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }));
    }
    //endregion

    //region CASH SHORT DETAIL
    //Guarda CorteCaja
    @SuppressWarnings("unchecked")
    private void saveCashShortDetail() {
        if (edtAmountCap.getText().toString().equals("0.0")) {
            edtAmountCap.setError(getString(R.string.fieldRequired));
            return;
        }
        String uuid = generateUUID();
        if (insertCashShort) {
            for (int i = 0; i < wayPayListCashShort.size(); i++) {
                Integer id = wayPayListCashShort.get(i).getId();
                Double sumTotal = total[i];
                compositeDisposable.add(collectionOfPaymentViewEntity.getWayPayAmount(id)
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe((Consumer<List<CollectionOfPaymentEntity>>) collectionOfPaymentSearch -> {
                                    Double sumAmountWayPay = 0.0;
                                    if (collectionOfPaymentSearch.size() > 0) {
                                        CashShortDetailEntity cashShort = new CashShortDetailEntity();
                                        for (int j = 0; j < collectionOfPaymentSearch.size(); j++) {
                                            Integer idCollection = collectionOfPaymentSearch.get(j).getWayPay();
                                            if (id.equals(idCollection)) {
                                                Double amount = collectionOfPaymentSearch.get(j).getAmount();
                                                sumAmountWayPay = sumAmountWayPay + amount;
                                                if (sumAmountWayPay > 0) {
                                                    double difference = sumAmountWayPay - sumTotal;

                                                    cashShort.setWayPay(id);
                                                    cashShort.setCashShort(CashShortEntity.instance.getId());
                                                    cashShort.setAmountCal(sumAmountWayPay);
                                                    if (sumTotal == 0.0) {
                                                        cashShort.setAmountCap(0.0);
                                                    } else {
                                                        cashShort.setAmountCap(sumTotal);
                                                    }
                                                    cashShort.setDiference(difference);
                                                    cashShort.setUuid(uuid);

                                                }
                                            }
                                        }
                                        insertCashShortDetail(cashShort);
                                    } else {
                                        double difference = sumAmountWayPay - sumTotal;
                                        CashShortDetailEntity cashShort = new CashShortDetailEntity();
                                        cashShort.setWayPay(id);
                                        cashShort.setCashShort(CashShortEntity.instance.getId());
                                        cashShort.setAmountCal(sumAmountWayPay);
                                        cashShort.setAmountCap(sumTotal);
                                        cashShort.setDiference(difference);
                                        cashShort.setUuid(uuid);
                                        insertCashShortDetail(cashShort);
                                    }
                                }, throwable -> {

                                }
                        ));
            }
        }
    }

    private void insertCashShortDetail(CashShortDetailEntity cashShort) {
        compositeDisposable.add(cashShortDetailViewEntity.insertCashShortDetail(cashShort)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    try {
                        if (CashShortDetailEntity.instance.getId() != -1) {
                            openPDF();
                            saveBinnacleDetalle();
                            this.finish();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }));
    }
    //endregion

    //region WITHDRAWAL
    @SuppressWarnings("unchecked")
    private void searchSumWithdrawal() {
        compositeDisposable.add(withdrawalViewEntity.getSum()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<WithdrawalEntity>>) withdrawalListSearch -> {
                            withdrawalListCashShort = (ArrayList<WithdrawalEntity>) withdrawalListSearch;
                            Double withdrawal = 0.0;
                            sumWithdrawal = 0.0;
                            for (int i = 0; i < withdrawalListCashShort.size(); i++) {
                                withdrawal = withdrawalListCashShort.get(i).getAmount();
                            }
                            sumWithdrawal = withdrawal;
                            sumTotal = (sumIncome + sumSale) - sumWithdrawal;
                            edtAmountCal.setText(String.valueOf(sumTotal));
                        }, throwable -> {
                        }
                ));
    }

    private void saveWithdrawal() {
        for (int i = 0; i < withdrawalListCashShort.size(); i++) {
            if (withdrawalListCashShort.get(i).getCashShort() == 1) {
                WithdrawalEntity withdrawal = new WithdrawalEntity();
                withdrawal.setCashShort(CashShortEntity.instance.getId());
                withdrawal.setDate(withdrawalListCashShort.get(i).getDate());
                withdrawal.setComments(withdrawalListCashShort.get(i).getComments());
                withdrawal.setAmount(withdrawalListCashShort.get(i).getAmount());
                withdrawal.setUser(withdrawalListCashShort.get(i).getUser());
                withdrawal.setId(withdrawalListCashShort.get(i).getId());
                withdrawal.setUuid(withdrawalListCashShort.get(i).getUuid());
                withdrawal.setUuidCashShort(withdrawalListCashShort.get(i).getUuidCashShort());
                updateWithdrawal(withdrawal);
            }
        }
    }

    private void updateWithdrawal(WithdrawalEntity withdrawal) {
        compositeDisposable.add(withdrawalViewEntity.updateWithdrawal(withdrawal)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    try {
                        if (WithdrawalEntity.instance.getId() != -1) {
                            saveBinnacleWithdrawal();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                })
        );
    }
    //endregion

    //region SALE
    @SuppressWarnings("unchecked")
    private void searchSumSale() {
        compositeDisposable.add(salesViewEntity.getSum()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<SalesEntity>>) saleListSearch -> {
                            salesListCashShort = (ArrayList<SalesEntity>) saleListSearch;
                            Double sale = 0.0;
                            sumSale = 0.0;
                            for (int i = 0; i < salesListCashShort.size(); i++) {
                                sale = salesListCashShort.get(i).getTotal();
                            }
                            sumSale = sale;
                            sumTotal = (sumIncome + sumSale) - sumWithdrawal;
                            edtAmountCal.setText(String.valueOf(sumTotal));
                        }, throwable -> {

                        }
                ));
    }

    private void saveSales() {
        for (int i = 0; i < salesListCashShort.size(); i++) {
            if (salesListCashShort.get(i).getCashShort() == 1) {
                SalesEntity sales = new SalesEntity();
                sales.setCashShort(CashShortEntity.instance.getId());
                sales.setUuidWayPay(salesListCashShort.get(i).getUuidWayPay());
                sales.setUuid(salesListCashShort.get(i).getUuid());
                sales.setUuidCashShort(CashShortEntity.instance.getUuid());
                sales.setUuidTypeDocument(salesListCashShort.get(i).getUuidTypeDocument());
                sales.setUuidClient(salesListCashShort.get(i).getUuidClient());
                sales.setDocumentFolio(salesListCashShort.get(i).getDocumentFolio());
                sales.setId(salesListCashShort.get(i).getId());
                sales.setClient(salesListCashShort.get(i).getClient());
                sales.setWayPay(salesListCashShort.get(i).getWayPay());
                sales.setNoAticles(salesListCashShort.get(i).getNoAticles());
                sales.setSalesStatus(salesListCashShort.get(i).getSalesStatus());
                sales.setDate(salesListCashShort.get(i).getDate());
                sales.setTotal(salesListCashShort.get(i).getTotal());
                sales.setTypeDocumentVta(salesListCashShort.get(i).getTypeDocumentVta());
                sales.setSumaTotal(salesListCashShort.get(i).getSumaTotal());
                updateSale(sales);
            }
        }
    }

    private void updateSale(SalesEntity sales) {
        compositeDisposable.add(salesViewEntity.updateSales(sales)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    try {
                        if (SalesEntity.instance.getId() != -1) {
                            saveBinnacleSale();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                })
        );
    }
    //endregion

    //region INCOME
    @SuppressWarnings("unchecked")
    private void searchSumIncome() {
        compositeDisposable.add(cashIncomeViewEntity.getSum()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<CashIncomeEntity>>) incomeSearch -> {
                            cashIncomeListCashShort = (ArrayList<CashIncomeEntity>) incomeSearch;
                            Double income = 0.0;
                            sumIncome = 0.0;
                            for (int i = 0; i < cashIncomeListCashShort.size(); i++) {
                                income = cashIncomeListCashShort.get(i).getAmount();
                            }
                            sumIncome = income;
                            sumTotal = (sumIncome + sumSale) - sumWithdrawal;
                            edtAmountCal.setText(String.valueOf(sumTotal));
                        }, throwable -> {

                        }
                ));
    }

    private void saveIncome() {
        for (int i = 0; i < cashIncomeListCashShort.size(); i++) {
            if (cashIncomeListCashShort.get(i).getCashShort() == 1) {
                CashIncomeEntity cashIncomeEntity = new CashIncomeEntity();
                cashIncomeEntity.setCashShort(CashShortEntity.instance.getId());
                cashIncomeEntity.setAmount(cashIncomeListCashShort.get(i).getAmount());
                cashIncomeEntity.setDate(cashIncomeListCashShort.get(i).getDate());
                cashIncomeEntity.setComments(cashIncomeListCashShort.get(i).getComments());
                cashIncomeEntity.setId(cashIncomeListCashShort.get(i).getId());
                cashIncomeEntity.setUuidCashShort(CashShortEntity.instance.getUuid());
                cashIncomeEntity.setUuid(cashIncomeListCashShort.get(i).getUuid());
                updateIncome(cashIncomeEntity);
            }
        }
    }

    private void updateIncome(CashIncomeEntity cashIncomeEntity) {
        compositeDisposable.add(cashIncomeViewEntity.updateIncome(cashIncomeEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    try {
                        if (CashIncomeEntity.instance.getId() != -1) {
                            saveBinnacleIncome();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }));
    }
    //endregion

    //region COLLECTION OF PAYMENT
    @SuppressWarnings("unchecked")
    private void searchCollectionPayment() {
        compositeDisposable.add(collectionOfPaymentViewEntity.getFilterCollection()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<CollectionOfPaymentEntity>>) collectionOfPaymentSearch -> collectionOfPaymentListCashShort = (ArrayList<CollectionOfPaymentEntity>) collectionOfPaymentSearch, throwable -> {

                        }
                ));
    }

    private void saveCollection() {
        for (int i = 0; i < collectionOfPaymentListCashShort.size(); i++) {
            if (collectionOfPaymentListCashShort.get(i).getCashShort() == 1) {
                CollectionOfPaymentEntity collectionOfPaymentEntity = new CollectionOfPaymentEntity();
                collectionOfPaymentEntity.setSale(collectionOfPaymentListCashShort.get(i).getSale());
                collectionOfPaymentEntity.setWayPay(collectionOfPaymentListCashShort.get(i).getWayPay());
                collectionOfPaymentEntity.setAmount(collectionOfPaymentListCashShort.get(i).getAmount());
                collectionOfPaymentEntity.setCashShort(CashShortEntity.instance.getId());
                collectionOfPaymentEntity.setDate(collectionOfPaymentListCashShort.get(i).getDate());
                collectionOfPaymentEntity.setUuid(collectionOfPaymentListCashShort.get(i).getUuid());
                collectionOfPaymentEntity.setUuidSale(collectionOfPaymentListCashShort.get(i).getUuidSale());
                collectionOfPaymentEntity.setUuidCashShort(CashShortEntity.instance.getUuid());
                collectionOfPaymentEntity.setUuidWayPay(collectionOfPaymentListCashShort.get(i).getUuidWayPay());
                updateCollectionOfPayment(collectionOfPaymentEntity);
            }
        }
    }

    private void updateCollectionOfPayment(CollectionOfPaymentEntity collectionOfPaymentEntity) {
        compositeDisposable.add(collectionOfPaymentViewEntity.updateCollectionOfPayment(collectionOfPaymentEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    try {
                        if (CollectionOfPaymentEntity.instance.getId() != -1) {
                            saveBinnacleCobro();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }));
    }
    //endregion
    //endregion

    //region PROTECTED METHODS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeViews();
        compositeDisposable = new CompositeDisposable();

        rvWayPayInCashShortAdapter = new RvWayPayInCashShortAdapter(wayPayListCashShort, getApplicationContext());
        rvWayPayList.setLayoutManager(new LinearLayoutManager(this));
        rvWayPayList.setAdapter(rvWayPayInCashShortAdapter);

        bitacoraViewEntityFactory = Injection.providerBitacoraViewModelFactory(getApplicationContext());
        bitacoraViewEntity = ViewModelProviders.of(this, bitacoraViewEntityFactory).get(BitacoraViewEntity.class);

        cashShortViewEntityFactory = Injection.providerCashShortViewModelFactory(getApplicationContext());
        cashShortViewEntity = ViewModelProviders.of(this, cashShortViewEntityFactory).get(CashShortViewEntity.class);

        cashShortDetailViewEntityFactory = Injection.providerCashShortDetailViewModelFactory(getApplicationContext());
        cashShortDetailViewEntity = ViewModelProviders.of(this, cashShortDetailViewEntityFactory).get(CashShortDetailViewEntity.class);

        cashIncomeViewEntityFactory = Injection.providerCashIncomeViewModelFactory(getApplicationContext());
        cashIncomeViewEntity = ViewModelProviders.of(this, cashIncomeViewEntityFactory).get(CashIncomeViewEntity.class);
        searchSumIncome();

        withdrawalViewEntityFactory = Injection.providerWithdrawalViewModelFactory(getApplicationContext());
        withdrawalViewEntity = ViewModelProviders.of(this, withdrawalViewEntityFactory).get(WithdrawalViewEntity.class);
        searchSumWithdrawal();

        salesViewEntityFactory = Injection.providerSaleViewModelFactory(getApplicationContext());
        salesViewEntity = ViewModelProviders.of(this, salesViewEntityFactory).get(SalesViewEntity.class);
        searchSumSale();

        collectionOfPaymentViewEntityFactory = Injection.providerCollectionOfPaymentViewModelFactory(getApplicationContext());
        collectionOfPaymentViewEntity = ViewModelProviders.of(this, collectionOfPaymentViewEntityFactory).get(CollectionOfPaymentViewEntity.class);

        btnSaveCashShort.setOnClickListener(v -> saveCashShort()
        );
    }

    @Override
    protected int getPageLayoutId() {
        return R.layout.activity_crud_cash_short;
    }

    @Override
    protected String getScreenTitle() {
        return getString(R.string.itemMenu12);
    }

    @Override
    protected void onResume() {
        super.onResume();
        wayPayViewEntityFactory = Injection.providerWayPayViewModelFactory(getApplicationContext());
        wayPayViewEntity = ViewModelProviders.of(this, wayPayViewEntityFactory).get(WayPayViewEntity.class);
        searchWayPay();

        cashShortViewEntityFactory = Injection.providerCashShortViewModelFactory(getApplicationContext());
        cashShortViewEntity = ViewModelProviders.of(this, cashShortViewEntityFactory).get(CashShortViewEntity.class);

        collectionOfPaymentViewEntityFactory = Injection.providerCollectionOfPaymentViewModelFactory(getApplicationContext());
        collectionOfPaymentViewEntity = ViewModelProviders.of(this, collectionOfPaymentViewEntityFactory).get(CollectionOfPaymentViewEntity.class);
        searchCollectionPayment();

        cashIncomeViewEntityFactory = Injection.providerCashIncomeViewModelFactory(getApplicationContext());
        cashIncomeViewEntity = ViewModelProviders.of(this, cashIncomeViewEntityFactory).get(CashIncomeViewEntity.class);
        searchSumIncome();

        withdrawalViewEntityFactory = Injection.providerWithdrawalViewModelFactory(getApplicationContext());
        withdrawalViewEntity = ViewModelProviders.of(this, withdrawalViewEntityFactory).get(WithdrawalViewEntity.class);
        searchSumWithdrawal();

        salesViewEntityFactory = Injection.providerSaleViewModelFactory(getApplicationContext());
        salesViewEntity = ViewModelProviders.of(this, salesViewEntityFactory).get(SalesViewEntity.class);
        searchSumSale();

        bitacoraViewEntityFactory = Injection.providerBitacoraViewModelFactory(getApplicationContext());
        bitacoraViewEntity = ViewModelProviders.of(this, bitacoraViewEntityFactory).get(BitacoraViewEntity.class);
        searchBitacora();

        initializeEditText();
    }

    //endregion
}