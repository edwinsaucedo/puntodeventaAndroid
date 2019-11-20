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
import com.example.administrador.pvsegalmex.adapter.OnEditTextChanged;
import com.example.administrador.pvsegalmex.adapter.RvWayPayInCashShortAdapter;
import com.example.administrador.pvsegalmex.api.User;
import com.example.administrador.pvsegalmex.entity.BitacoraEntity;
import com.example.administrador.pvsegalmex.entity.WayPayEntity;
import com.example.administrador.pvsegalmex.entity.WithdrawalDetailEntity;
import com.example.administrador.pvsegalmex.entity.WithdrawalEntity;
import com.example.administrador.pvsegalmex.utils.DialogUtils;
import com.example.administrador.pvsegalmex.viewEntity.BitacoraViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.WayPayViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.WithdrawalDetailViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.WithdrawalViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.BitacoraViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.WayPayViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.WithdrawalDetailViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.WithdrawalViewEntityFactory;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CrudWithdrawalView extends MenuView {

    //region VARS
    private CompositeDisposable compositeDisposable;
    //region WITHDRAWAL
    private WithdrawalViewEntity withdrawalViewEntity;
    WithdrawalViewEntityFactory withdrawalViewEntityFactory;
    //endregion

    //region WITHDRAWALDETAIL
    private WithdrawalDetailViewEntity withdrawalDetailViewEntity;
    WithdrawalDetailViewEntityFactory withdrawalDetailViewEntityFactory;
    //endregion

    //region WAY PAY
    private WayPayViewEntity wayPayViewEntity;
    WayPayViewEntityFactory wayPayViewEntityFactory;
    private ArrayList<WayPayEntity> wayPayList;
    private Double[] total;
    private RvWayPayInCashShortAdapter rvWayPayInCashShortAdapter;
    //endregion

    //region BINNACLE
    private BitacoraViewEntity bitacoraViewEntity;
    BitacoraViewEntityFactory bitacoraViewEntityFactory;
    private ArrayList<BitacoraEntity> bitacoraList;
    //endregion

    //region WITHDRAWAL
    //endregion
    private String tableName;
    private Double sumWayPay;
    private Integer idTabla;
    private RecyclerView rvWayPayList;
    //endregion

    //endregion

    //region VIEWS
    private EditText edtComment;
    private AppCompatButton btnSaveWithdrawal;
    //endregion

    //region PRIVATE METHODS
    private void inizializateViews() {
        edtComment = findViewById(R.id.edtCommentsWithdrawal);
        btnSaveWithdrawal = findViewById(R.id.btnSaveWithdrawal);
        bitacoraList = new ArrayList<>();
        rvWayPayList = findViewById(R.id.rvWayPayInwithdrawal);
        wayPayList = new ArrayList<>();
    }

    //region BINNACLE
    private void searchBitacora() {
        compositeDisposable.add(bitacoraViewEntity.getFilterBitacora()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<BitacoraEntity>>) bitacoraListSearch -> {
                            bitacoraList = (ArrayList<BitacoraEntity>) bitacoraListSearch;
                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), getString(R.string.errorConsulta), Toast.LENGTH_LONG).show();
                            Log.e(getString(R.string.errorSQLITE), "");
                        }
                )
        );
    }

    private void clear() {
        String t = "RetiroCaja";
        for (int i = 0; i < bitacoraList.size(); i++) {
            tableName = bitacoraList.get(i).getTable();
            if (t.equals(tableName)) {
                idTabla = bitacoraList.get(i).getId();
            }
        }
        if (idTabla == null) {
            BitacoraEntity.instance.clear();
        }
    }

    private void clearDetalle() {
        String t = "RetiroCajaDetalle";
        for (int i = 0; i < bitacoraList.size(); i++) {
            tableName = bitacoraList.get(i).getTable();
            if (t.equals(tableName)) {
                idTabla = bitacoraList.get(i).getId();
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
            bitacoraEntity.setTable("RetiroCaja");
            bitacoraEntity.setIdTable(WithdrawalEntity.instance.getId());

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

    private void saveBinnacleDetalle() {
        try {
            BitacoraEntity bitacoraEntity = new BitacoraEntity();
            bitacoraEntity.setDate(getDate());
            bitacoraEntity.setTable("RetiroCajaDetalle");
            bitacoraEntity.setIdTable(WithdrawalEntity.instance.getId());

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

    //region WAY PAY
    //Busca FormasPago para calcular el MontoCapturado
    private void searchWayPay() {
        compositeDisposable.add(wayPayViewEntity.getFilterWayPayCashShort()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<WayPayEntity>>) wayPayListSearch -> {
                            wayPayList = (ArrayList<WayPayEntity>) wayPayListSearch;
                            if (wayPayList.isEmpty())
                                Toast.makeText(getApplicationContext(), getString(R.string.noHayRegistros), Toast.LENGTH_SHORT).show();
                            total = new Double[wayPayList.size()];
                            rvWayPayInCashShortAdapter = new RvWayPayInCashShortAdapter(wayPayList, new OnEditTextChanged() {
                                @Override//obtiene el monto de forma de pago mientras se modifica
                                public void onTextChanged(int position, String charSeq) {

                                    if (charSeq.isEmpty())
                                        charSeq = "0.0";
                                    total[position] = Double.valueOf(charSeq);
                                    updateTotalValue();
                                }
                            }, getApplicationContext()
                            );
                            rvWayPayList.setAdapter(rvWayPayInCashShortAdapter);
                        }, throwable -> {
                        }
                ));
    }

    private void updateTotalValue() {
        Double sum = 0.0;
        for (int i = 0; i < total.length; i++) {
            if (total[i] != null)
                sum += total[i];
        }
        sumWayPay = sum;
    }
    //endregion

    //region SALE
    private void searchSumWithdrawal() {
        compositeDisposable.add(withdrawalViewEntity.getSum()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<WithdrawalEntity>>) withdrawalListSearch -> {
                        }, throwable -> {

                        }
                ));
    }
    //endregion

    //region WITHDRAWAL

    private void saveWithdrawal() {
        try {
            if (edtComment.getText().toString().isEmpty()) {
                edtComment.setError(getString(R.string.fieldRequired));
                return;
            }

            String uuid = generateUUID();
            WithdrawalEntity withdrawal = new WithdrawalEntity();
            clear();
            withdrawal.setComments(edtComment.getText().toString().trim());
            withdrawal.setUser(User.build(CrudWithdrawalView.this).getUser());
            withdrawal.setAmount(sumWayPay);
            withdrawal.setDate(getDate());
            withdrawal.setUuid(uuid);
            withdrawal.setCashShort(1);
            withdrawal.setUuidCashShort("UUID");

            DialogUtils.showOkayNoDialog(getString(R.string.delWithdrawalWarningMessage), getString(R.string.delWithdrawalWarningTitle), this, new DialogUtils.OnOkayNoEvent() {
                @Override
                public void onYes() {
                    if (WithdrawalEntity.instance.getId() == -1) {
                        insertWithdrawal(withdrawal);
                    }
                }

                @Override
                public void onNo() {
                    return;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertWithdrawal(WithdrawalEntity withdrawal) {
        compositeDisposable.add(withdrawalViewEntity.insertWhitdrawal(withdrawal)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (WithdrawalEntity.instance.getId() != -1) {
                        saveBinnacle();
                        saveWithdrawalDetail();
                    } else {
                        Toast.makeText(getApplicationContext(), getString(R.string.ocurrioError), Toast.LENGTH_LONG).show();

                    }
                })
        );
    }

    //DETAIL
    private void saveWithdrawalDetail() {
        clearDetalle();
        for (int i = 0; i < wayPayList.size(); i++) {
            WithdrawalDetailEntity withdrawalDetailEntity = new WithdrawalDetailEntity();
            withdrawalDetailEntity.setIdWithdrawal(WithdrawalEntity.instance.getId());
            withdrawalDetailEntity.setAmount(total[i]);
            withdrawalDetailEntity.setIdWayPay(wayPayList.get(i).getId());
            withdrawalDetailEntity.setLastDateSync(getDate());
            withdrawalDetailEntity.setUuid(generateUUID());
            insertWithdrawalDetail(withdrawalDetailEntity);
        }
    }

    private void insertWithdrawalDetail(WithdrawalDetailEntity withdrawalDetailEntity) {
        compositeDisposable.add(withdrawalDetailViewEntity.insertWithdrawalDetail(withdrawalDetailEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    try {
                        if (WithdrawalDetailEntity.instance.getId() != -1) {
                            saveBinnacleDetalle();
                            finish();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }));

    }
    //endregion

    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        inizializateViews();

        compositeDisposable = new CompositeDisposable();

        rvWayPayInCashShortAdapter = new RvWayPayInCashShortAdapter(wayPayList, getApplicationContext());
        rvWayPayList.setLayoutManager(new LinearLayoutManager(this));
        rvWayPayList.setAdapter(rvWayPayInCashShortAdapter);

        withdrawalViewEntityFactory = Injection.providerWithdrawalViewModelFactory(getApplicationContext());
        withdrawalViewEntity = ViewModelProviders.of(this, withdrawalViewEntityFactory).get(WithdrawalViewEntity.class);

        btnSaveWithdrawal.setOnClickListener(v -> saveWithdrawal());
        withdrawalViewEntityFactory = Injection.providerWithdrawalViewModelFactory(getApplicationContext());
        withdrawalViewEntity = ViewModelProviders.of(this, withdrawalViewEntityFactory).get(WithdrawalViewEntity.class);
        searchSumWithdrawal();

        withdrawalDetailViewEntityFactory = Injection.providerWithdrawalDetailViewModelFactory(getApplicationContext());
        withdrawalDetailViewEntity = ViewModelProviders.of(this, withdrawalDetailViewEntityFactory).get(WithdrawalDetailViewEntity.class);
    }

    @Override
    protected int getPageLayoutId() {
        return R.layout.activity_crud_withdrawal_view;
    }

    @Override
    protected String getScreenTitle() {
        return getString(R.string.itemMenu11);
    }

    @Override
    protected void onResume() {
        super.onResume();
        withdrawalViewEntityFactory = Injection.providerWithdrawalViewModelFactory(getApplicationContext());
        withdrawalViewEntity = ViewModelProviders.of(this, withdrawalViewEntityFactory).get(WithdrawalViewEntity.class);
        searchSumWithdrawal();
        bitacoraViewEntityFactory = Injection.providerBitacoraViewModelFactory(getApplicationContext());
        bitacoraViewEntity = ViewModelProviders.of(this, bitacoraViewEntityFactory).get(BitacoraViewEntity.class);
        searchBitacora();
        wayPayViewEntityFactory = Injection.providerWayPayViewModelFactory(getApplicationContext());
        wayPayViewEntity = ViewModelProviders.of(this, wayPayViewEntityFactory).get(WayPayViewEntity.class);
        searchWayPay();
    }
}