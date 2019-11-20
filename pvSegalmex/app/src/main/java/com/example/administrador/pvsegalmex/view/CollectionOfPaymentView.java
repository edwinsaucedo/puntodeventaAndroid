package com.example.administrador.pvsegalmex.view;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.adapter.ArrayAdapterSpinner;
import com.example.administrador.pvsegalmex.adapter.GridWayPaySales;
import com.example.administrador.pvsegalmex.adapter.ProductSale;
import com.example.administrador.pvsegalmex.api.LoginInfo;
import com.example.administrador.pvsegalmex.entity.BitacoraEntity;
import com.example.administrador.pvsegalmex.entity.ClienteEntity;
import com.example.administrador.pvsegalmex.entity.CollectionOfPaymentEntity;
import com.example.administrador.pvsegalmex.entity.ExistEntity;
import com.example.administrador.pvsegalmex.entity.SalesEntity;
import com.example.administrador.pvsegalmex.entity.StoreEntity;
import com.example.administrador.pvsegalmex.entity.WayPayEntity;
import com.example.administrador.pvsegalmex.utils.DialogUtils;
import com.example.administrador.pvsegalmex.utils.Utils;
import com.example.administrador.pvsegalmex.viewEntity.BitacoraViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.ClienteViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.CollectionOfPaymentViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.ExistViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.SalesViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.StoreViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.WayPayViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.BitacoraViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.ClienteViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.CollectionOfPaymentViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.ExistViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.SalesViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.StoreViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.WayPayViewEntityFactory;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CollectionOfPaymentView extends AppCompatActivity {

    //region VARS
    private CompositeDisposable compositeDisposable;

    //region BITACORA
    private BitacoraViewEntity bitacoraViewEntity;
    private BitacoraViewEntityFactory bitacoraViewEntityFactory;
    private ArrayList<BitacoraEntity> bitacoraListCollection;
    //endregion

    //region PRODUCT
    private ArrayList<ProductSale> productSalesList;
    //endregion

    //region CLIENT
    private ArrayList<ClienteEntity> clienteListCollection;
    private ClienteViewEntity clienteViewEntity;
    private ClienteViewEntityFactory clienteViewEntityFactory;
    //endregion

    //region STORE
    private StoreViewEntity storeViewEntity;
    private StoreViewEntityFactory storeViewEntityFactory;
    //endregion

    //region WAY PAY
    private ArrayList<WayPayEntity> wayPayListCollection;
    private WayPayViewEntity wayPayViewEntity;
    private Integer wayPayId = 0;
    private WayPayViewEntityFactory wayPayViewEntityFactory;
    //endregion

    //region SALE
    private SalesViewEntity salesViewEntity;
    private SalesViewEntityFactory salesFactory;

    //region EXIST
    private ArrayList<ExistEntity> existListCollection;
    private ExistViewEntity existViewEntity;
    private ExistViewEntityFactory existViewEntityFactory;
    //endregion

    //region VENTA COBRO
    private CollectionOfPaymentViewEntity collectionOfPaymentViewEntity;
    private CollectionOfPaymentViewEntityFactory collectionOfPaymentViewEntityFactory;
    //endregion

    //region SEARCHABLE
    private SearchableSpinner searchableSpinner;
    private ArrayAdapterSpinner adapter;
    //endregion

    private Double total = 0.0;
    private String ammount;
    private String change = "0.0";
    private String tableName;
    private Integer idTabla, idClient;

    //endregion

    //region VIEWS
    private FloatingActionButton btnaddClient;
    private EditText edtCashCap, edtCashDiference;
    private TextView tvTotal;
    private AppCompatButton btnSaveSales;
    private GridWayPaySales rvWayPayAdapter;
    private RecyclerView rvWayPay;
    //endregion

    //region PRIVATE METHODS
    private void inizializateViews() {
        ammount = "0.0";
        wayPayListCollection = new ArrayList<>();
        bitacoraListCollection = new ArrayList<>();
        clienteListCollection = new ArrayList<>();
        productSalesList = new ArrayList<>();
        existListCollection = new ArrayList<>();
        edtCashCap = findViewById(R.id.edtCapturatedCash);
        edtCashDiference = findViewById(R.id.edtDiferenceCash);
        btnSaveSales = findViewById(R.id.btnCompleteSale);
        rvWayPay = findViewById(R.id.gridWayPaySales);
        tvTotal = findViewById(R.id.tvTotalSales);
        btnaddClient = findViewById(R.id.btnAddClientSale);
        searchableSpinner = findViewById(R.id.spinner);
    }

    //region BINNACLE
    @SuppressWarnings("unchecked")
    private void searchBitacora() {
        compositeDisposable.add(bitacoraViewEntity.getFilterBitacora()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<BitacoraEntity>>) bitacoraListSearch -> bitacoraListCollection = (ArrayList<BitacoraEntity>) bitacoraListSearch, throwable -> {

                        }
                )
        );
    }

    //region BINNACLE SALE
    private void clearTableBinacleVenta() {
        String t = "Venta";
        for (int i = 0; i < bitacoraListCollection.size(); i++) {
            tableName = bitacoraListCollection.get(i).getTable();
            if (t.equals(tableName)) {
                idTabla = bitacoraListCollection.get(i).getId();
            }
        }
        if (idTabla == null) {
            BitacoraEntity.instance.clear();
        }
    }

    private void saveBinnacle() {
        try {
            BitacoraEntity bitacoraEntity = new BitacoraEntity();
            java.util.Date utilDate = new java.util.Date();

            Calendar cal = Calendar.getInstance(); // locale-specific
            cal.setTime(utilDate);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            long time = cal.getTimeInMillis();

            java.sql.Timestamp sqlTimestamp = new Timestamp(time);
            bitacoraEntity.setDate(String.valueOf(sqlTimestamp));
            bitacoraEntity.setTable("Venta");
            bitacoraEntity.setIdTable(SalesEntity.instance.getId());

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
    //endregion

    //region BINNACLE COLLECTION SALE
    private void clearTableBinnacleCobro() {
        String t = "CobroVenta";
        for (int i = 0; i < bitacoraListCollection.size(); i++) {
            tableName = bitacoraListCollection.get(i).getTable();
            if (t.equals(tableName)) {
                idTabla = bitacoraListCollection.get(i).getId();
            }
        }
        if (idTabla == null) {
            BitacoraEntity.instance.clear();
        }
    }

    private void saveBinnacleCobro() {
        try {
            BitacoraEntity bitacoraEntity = new BitacoraEntity();
            bitacoraEntity.setDate(getDate());
            bitacoraEntity.setTable("CobroVenta");
            bitacoraEntity.setIdTable(CollectionOfPaymentEntity.instance.getId());

            if (BitacoraEntity.instance.getId() == -1) {
                insertBinnacleCobro(bitacoraEntity);
            } else {
                bitacoraEntity.setId(BitacoraEntity.instance.getId());
                updateBinnacleCobro(bitacoraEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertBinnacleCobro(BitacoraEntity bitacoraEntity) {
        compositeDisposable.add(bitacoraViewEntity.insertBitacora(bitacoraEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                })
        );
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

    //region WAY PAY
    @SuppressWarnings("unchecked")
    private void searchWayPay() {
        compositeDisposable.add(wayPayViewEntity.getFilterWayPayCashShort()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<WayPayEntity>>) wayPayListSearch -> {
                            wayPayListCollection = (ArrayList<WayPayEntity>) wayPayListSearch;
                            rvWayPayAdapter = new GridWayPaySales(wayPayListCollection, getApplicationContext());
                            rvWayPayAdapter.setOnClickListener(onClickListenerWayPaySelected);
                            rvWayPay.setAdapter(rvWayPayAdapter);
                        }, throwable -> {

                        }
                ));
    }
    //endregion

    //region COLLECTION
    private void saveCollection() {
        CollectionOfPaymentEntity collectionOfPaymentEntity = new CollectionOfPaymentEntity();
        String uuid = generateUUID();
        clearTableBinnacleCobro();
        collectionOfPaymentEntity.setSale(SalesEntity.instance.getId());
        collectionOfPaymentEntity.setWayPay(wayPayId);
        collectionOfPaymentEntity.setAmount(Double.parseDouble(tvTotal.getText().toString().trim()));
        collectionOfPaymentEntity.setCashShort(1);
        collectionOfPaymentEntity.setDate(getDate());
        collectionOfPaymentEntity.setUuid(uuid);
        collectionOfPaymentEntity.setUuidSale(SalesEntity.instance.getUuid());
        collectionOfPaymentEntity.setUuidCashShort("UUID");
        collectionOfPaymentEntity.setUuidWayPay(WayPayEntity.instance.getUuid());
        insertCollection(collectionOfPaymentEntity);
    }

    private void insertCollection(CollectionOfPaymentEntity collectionOfPaymentEntity) {
        compositeDisposable.add(collectionOfPaymentViewEntity.insertCollectionOfPayment(collectionOfPaymentEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (CollectionOfPaymentEntity.instance.getId() != -1) {
                        saveBinnacleCobro();
                    } else {
                        Toast.makeText(getApplicationContext(), getString(R.string.ocurrioError), Toast.LENGTH_SHORT).show();
                    }
                }));
    }
    //endregion

    //region EXIST
    @SuppressWarnings("unchecked")
    private void searchExist() {
        compositeDisposable.add(existViewEntity.getFilterExist()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<ExistEntity>>) existListSearch -> existListCollection = (ArrayList<ExistEntity>) existListSearch, throwable -> {
                            Toast.makeText(getApplicationContext(), getString(R.string.errorConsulta), Toast.LENGTH_SHORT).show();
                            Log.e(getString(R.string.errorSQLITE), "");
                        }
                ));
    }

    private void saveExist() {
        for (int j = 0; j < existListCollection.size(); j++) {
            for (int i = 0; i < productSalesList.size(); i++) {
                if (existListCollection.get(j).getProduct().equals(productSalesList.get(i).getProductSaleId())) {
                    Double q = existListCollection.get(j).getExist();
                    Double quantity = Double.valueOf(productSalesList.get(i).getProductQuantity());
                    ExistEntity existEntity = new ExistEntity();
                    existEntity.setExist(q - quantity);
                    existEntity.setUuid(existListCollection.get(j).getUuid());
                    existEntity.setTraffic(existListCollection.get(j).getTraffic());
                    existEntity.setSynced(existListCollection.get(j).getSynced());
                    existEntity.setProduct(existListCollection.get(j).getProduct());
                    existEntity.setLastDate(existListCollection.get(j).getLastDate());
                    existEntity.setEnable(existListCollection.get(j).getEnable());
                    existEntity.setCommitted(existListCollection.get(j).getCommitted());
                    existEntity.setId(existListCollection.get(j).getId());
                    existEntity.setDate(existListCollection.get(i).getDate());
                    existEntity.setUuid(generateUUID());
                    existEntity.setUuidProduct(productSalesList.get(i).getProductUUID());
                    updateExist(existEntity);
                }
            }
        }
    }

    private void updateExist(ExistEntity existEntity) {
        compositeDisposable.add(existViewEntity.updateExist(existEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                })
        );
    }
    //endregion

    @SuppressLint("SimpleDateFormat")
    public String getDate() {
        Date objDate = new Date();
        String strDateFormat = "dd/LL/yyyy KK:mm:ss:SSS";
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
        return String.valueOf(objSDF.format(objDate));
    }

    private void saveSales() {
        if (edtCashCap.getText().toString().isEmpty()) {
            edtCashCap.setError(getString(R.string.fieldRequired));
            return;
        }
        if (wayPayId < 1) {
            DialogUtils.showOkayDialog(CollectionOfPaymentView.this, "Forma de pago", "Ingresa una forma pago", "error");
            return;
        }
        Bundle data = this.getIntent().getExtras();
        assert data != null;
        int noArticles = data.getInt("noArticulos");
        idClient = (int) adapter.getItemId(searchableSpinner.getSelectedItemPosition());
        int folio = SalesEntity.instance.getDocumentFolio();
        int idSale = SalesEntity.instance.getId();
        SalesEntity sales = new SalesEntity();
        clearTableBinacleVenta();

        sales.setDate(getDate());
        sales.setTotal(Double.parseDouble(tvTotal.getText().toString().trim()));
        sales.setClient(idClient);//
        sales.setWayPay(wayPayId);
        sales.setSalesStatus("CERRADA");
        sales.setNoAticles(noArticles);
        sales.setTypeDocumentVta(SalesEntity.instance.getTypeDocumentVta());
        sales.setDocumentFolio(folio);
        sales.setUuidTypeDocument(SalesEntity.instance.getUuidTypeDocument());
        sales.setUuidCashShort(SalesEntity.instance.getUuidCashShort());
        sales.setUuidWayPay(SalesEntity.instance.getUuidWayPay());
        sales.setUuid(SalesEntity.instance.getUuid());
        sales.setId(idSale);
        sales.setCashShort(1);
        sales.setUuid(generateUUID());
        sales.setUtilityAmount(SalesEntity.instance.getUtilityAmount());
        sales.setUtilityPercentage(SalesEntity.instance.getUtilityPercentage());
        updateSale(sales);

        if (Double.parseDouble(change) < 0) {
            DialogUtils.showOkayDialog(CollectionOfPaymentView.this, "No puedes ingresar numeros negativos", "Algo no concuerda!", "error");
            return;
        }

        int idCashShort = 1;

        Intent intent = new Intent(getApplicationContext(), FinallySaleView.class);
        intent.putExtra("vListDetailSale", productSalesList);
        intent.putExtra("vAmount", total);
        intent.putExtra("idCashShort", idCashShort);
        intent.putExtra("vWayPay", wayPayId);

        startActivity(intent);
    }

    private void updateSale(SalesEntity sales) {
        compositeDisposable.add(salesViewEntity.updateSales(sales)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (SalesEntity.instance.getId() != -1) {
                        saveBinnacle();
                        saveCollection();
                        saveExist();
                        getClientInformation();
                    } else {
                        Toast.makeText(getApplicationContext(), getString(R.string.ocurrioError), Toast.LENGTH_SHORT).show();
                    }
                })
        );
    }
    //endregion

    //region CLIENT
    @SuppressWarnings("unchecked")
    private void searchClients() {
        compositeDisposable.add(clienteViewEntity.getFilterClientsSale()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<ClienteEntity>>) clienteListSearch -> {
                            clienteListCollection = (ArrayList<ClienteEntity>) clienteListSearch;
                            adapter = new ArrayAdapterSpinner(CollectionOfPaymentView.this, R.layout.sp_client_sale, clienteListCollection);
                            adapter.setDropDownViewResource(R.layout.sp_client_sale);
                            searchableSpinner.setAdapter(adapter);
                        }, throwable -> {

                        }
                ));
    }

    private void getClientInformation() {
        for (int i = 0; i < clienteListCollection.size(); i++) {
            if (clienteListCollection.get(i).getId().equals(idClient)) {
                ClienteEntity.instance.setDate(clienteListCollection.get(i).getDate());
                ClienteEntity.instance.setPhotoIne(clienteListCollection.get(i).getPhotoIne());
                ClienteEntity.instance.setLastDateSync(clienteListCollection.get(i).getLastDateSync());
                ClienteEntity.instance.setCompany(clienteListCollection.get(i).getCompany());
                ClienteEntity.instance.setAddress(clienteListCollection.get(i).getAddress());
                ClienteEntity.instance.setCreditDays(clienteListCollection.get(i).getCreditDays());
                ClienteEntity.instance.setCreditLimit(clienteListCollection.get(i).getCreditLimit());
                ClienteEntity.instance.setCurp(clienteListCollection.get(i).getCurp());
                ClienteEntity.instance.setGenre(clienteListCollection.get(i).getGenre());
                ClienteEntity.instance.setIneString(clienteListCollection.get(i).getIneString());
                ClienteEntity.instance.setLastName1(clienteListCollection.get(i).getLastName1());
                ClienteEntity.instance.setLastName2(clienteListCollection.get(i).getLastName2());
                ClienteEntity.instance.setLastSellDate(clienteListCollection.get(i).getLastSellDate());
                ClienteEntity.instance.setMail(clienteListCollection.get(i).getMail());
                ClienteEntity.instance.setName(clienteListCollection.get(i).getName());
                ClienteEntity.instance.setPhone(clienteListCollection.get(i).getPhone());
                ClienteEntity.instance.setPhotoClient(clienteListCollection.get(i).getPhotoClient());
                ClienteEntity.instance.setUuid(clienteListCollection.get(i).getUuid());
                ClienteEntity.instance.setId(clienteListCollection.get(i).getId());
                ClienteEntity.instance.setStatus(clienteListCollection.get(i).getStatus());
            }
        }
    }
    //endregion

    //region STORE
    @SuppressWarnings("unchecked")
    private void searchStore() {
        compositeDisposable.add(storeViewEntity.getFilterStore()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<StoreEntity>) storeSearch -> {
                            if (storeSearch.getId() != null) {
                                StoreEntity.instance.setId(storeSearch.getId());
                                StoreEntity.instance.setDirection(storeSearch.getDirection());
                                StoreEntity.instance.setLatitud(storeSearch.getLatitud());
                                StoreEntity.instance.setLongitud(storeSearch.getLongitud());
                                StoreEntity.instance.setOwner(storeSearch.getOwner());
                                StoreEntity.instance.setPhonenumber(storeSearch.getPhonenumber());
                                StoreEntity.instance.setStoreName(storeSearch.getStoreName());
                                StoreEntity.instance.setImage(storeSearch.getImage());
                                StoreEntity.instance.setLocalDirection(storeSearch.getLocalDirection());
                            }
                        }, throwable -> {

                        }
                )
        );
    }

    //endregion
    @SuppressLint("SimpleDateFormat")
    public String generateUUID() {
        Date objDate = new Date();
        String strDateFormat = "yyLLddKKmmssSSS";
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);

        String user = String.valueOf(LoginInfo.build(CollectionOfPaymentView.this).getUserId());
        String u = "";
        if (user.length() == 1) {
            u = "00000" + user;
        } else if (user.length() == 2) {
            u = "0000" + user;
        } else if (user.length() == 3) {
            u = "000" + user;
        } else if (user.length() == 4) {
            u = "00" + user;
        } else if (user.length() == 5) {
            u = "0" + user;
        } else if (user.length() == 6) {
            u = user;
        }
        return (u + (String.valueOf(objSDF.format(objDate))));
    }

    private void getDataPurchase() {
        Bundle data = this.getIntent().getExtras();
        assert data != null;
        total = data.getDouble("vSubtotal");
        productSalesList = data.getParcelableArrayList("vListSale");
        DecimalFormat df = new DecimalFormat("#.00");
        tvTotal.setText(String.valueOf((df.format(total))));
    }

    private void calculateChnage() {
        ammount = total.toString();
        change = String.valueOf(Double.parseDouble(edtCashCap.getText().toString()) - Double.parseDouble(ammount));
        edtCashDiference.setText(String.valueOf(change));
    }

    private void showDialog() {
        DialogUtils.showOkayNoDialog(getString(R.string.dialogAddNewClient), getString(R.string.dialogTitleClient), CollectionOfPaymentView.this, new DialogUtils.OnOkayNoEvent() {
            @Override
            public void onYes() {
                Intent intent = new Intent(getApplicationContext(), CrudClienteView.class);
                ClienteEntity.instance.clear();
                startActivity(intent);
            }

            @Override
            public void onNo() {
                Toast.makeText(getApplicationContext(), "Ok", Toast.LENGTH_SHORT).show();
            }
        });

    }
    //endregion

    //region PROTECTED
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_of_payment_view);
        inizializateViews();
        compositeDisposable = new CompositeDisposable();
        salesFactory = Injection.providerSaleViewModelFactory(getApplicationContext());
        salesViewEntity = ViewModelProviders.of(this, salesFactory).get(SalesViewEntity.class);

        wayPayViewEntityFactory = Injection.providerWayPayViewModelFactory(getApplicationContext());
        wayPayViewEntity = ViewModelProviders.of(this, wayPayViewEntityFactory).get(WayPayViewEntity.class);

        clienteViewEntityFactory = Injection.providerClientViewModelFactory(getApplicationContext());
        clienteViewEntity = ViewModelProviders.of(this, clienteViewEntityFactory).get(ClienteViewEntity.class);

        bitacoraViewEntityFactory = Injection.providerBitacoraViewModelFactory(getApplicationContext());
        bitacoraViewEntity = ViewModelProviders.of(this, bitacoraViewEntityFactory).get(BitacoraViewEntity.class);
        searchBitacora();

        existViewEntityFactory = Injection.providerExistViewModelFactory(getApplicationContext());
        existViewEntity = ViewModelProviders.of(this, existViewEntityFactory).get(ExistViewEntity.class);
        searchExist();

        collectionOfPaymentViewEntityFactory = Injection.providerCollectionOfPaymentViewModelFactory(getApplicationContext());
        collectionOfPaymentViewEntity = ViewModelProviders.of(this, collectionOfPaymentViewEntityFactory).get(CollectionOfPaymentViewEntity.class);

        storeViewEntityFactory = Injection.providerStoreViewModelFactory(getApplicationContext());
        storeViewEntity = ViewModelProviders.of(this, storeViewEntityFactory).get(StoreViewEntity.class);

        tvTotal.setText(String.valueOf("$ " + total));

        rvWayPayAdapter = new GridWayPaySales(wayPayListCollection, getApplicationContext());
        rvWayPay.setLayoutManager(new LinearLayoutManager(this, 0, false));
        rvWayPay.setAdapter(rvWayPayAdapter);
        Utils.visualizacion = Utils.GRID;
        getDataPurchase();

        adapter = new ArrayAdapterSpinner(CollectionOfPaymentView.this, R.layout.sp_client_sale, clienteListCollection);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        searchableSpinner.setAdapter(adapter);
        searchableSpinner.setTitle("Select client");
        searchableSpinner.setPositiveButton("OK");
        searchableSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        edtCashDiference.setFocusable(false);
        edtCashCap.setSelectAllOnFocus(true);

        btnSaveSales.setOnClickListener(v -> saveSales());
        btnaddClient.setOnClickListener(v -> showDialog());
        edtCashCap.setText(String.valueOf(total));

        edtCashCap.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (edtCashCap.length() == 0) {
                    edtCashCap.setHint(" ");
                } else {
                    calculateChnage();
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private View.OnClickListener onClickListenerWayPaySelected = v ->
    {
        wayPayId = wayPayListCollection.get(rvWayPay.getChildAdapterPosition(v)).getId();
        if (wayPayId == 2) {
            edtCashCap.setText(String.valueOf(total));
            edtCashCap.setEnabled(false);
        } else {
            edtCashCap.setText(String.valueOf(total));
            edtCashCap.setEnabled(true);
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        salesFactory = Injection.providerSaleViewModelFactory(getApplicationContext());
        salesViewEntity = ViewModelProviders.of(this, salesFactory).get(SalesViewEntity.class);

        bitacoraViewEntityFactory = Injection.providerBitacoraViewModelFactory(getApplicationContext());
        bitacoraViewEntity = ViewModelProviders.of(this, bitacoraViewEntityFactory).get(BitacoraViewEntity.class);
        searchBitacora();

        existViewEntityFactory = Injection.providerExistViewModelFactory(getApplicationContext());
        existViewEntity = ViewModelProviders.of(this, existViewEntityFactory).get(ExistViewEntity.class);
        searchExist();

        wayPayViewEntityFactory = Injection.providerWayPayViewModelFactory(getApplicationContext());
        wayPayViewEntity = ViewModelProviders.of(this, wayPayViewEntityFactory).get(WayPayViewEntity.class);
        searchWayPay();

        rvWayPayAdapter.setOnClickListener(onClickListenerWayPaySelected);
        clienteViewEntityFactory = Injection.providerClientViewModelFactory(getApplicationContext());
        clienteViewEntity = ViewModelProviders.of(this, clienteViewEntityFactory).get(ClienteViewEntity.class);
        searchClients();

        storeViewEntityFactory = Injection.providerStoreViewModelFactory(getApplicationContext());
        storeViewEntity = ViewModelProviders.of(this, storeViewEntityFactory).get(StoreViewEntity.class);
        searchStore();

        collectionOfPaymentViewEntityFactory = Injection.providerCollectionOfPaymentViewModelFactory(getApplicationContext());
        collectionOfPaymentViewEntity = ViewModelProviders.of(this, collectionOfPaymentViewEntityFactory).get(CollectionOfPaymentViewEntity.class);

        existViewEntityFactory = Injection.providerExistViewModelFactory(getApplicationContext());
        existViewEntity = ViewModelProviders.of(this, existViewEntityFactory).get(ExistViewEntity.class);
    }
    //endregion

    @Override
    public void onBackPressed() {
        DialogUtils.showOkayNoDialog(getString(R.string.askIncompleteSale), getString(R.string.warningIncompleteSale), this, new DialogUtils.OnOkayNoEvent() {
            @Override
            public void onYes() {
                finish();
                Intent intent = new Intent(getApplicationContext(), PointOfSaleView.class);
                startActivity(intent);
            }

            @Override
            public void onNo() {
            }
        });
    }
}
