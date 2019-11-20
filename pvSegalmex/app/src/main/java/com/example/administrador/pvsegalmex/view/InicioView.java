package com.example.administrador.pvsegalmex.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.entity.CashShortEntity;
import com.example.administrador.pvsegalmex.entity.CategoryEntity;
import com.example.administrador.pvsegalmex.entity.ClienteEntity;
import com.example.administrador.pvsegalmex.entity.DepartmentEntity;
import com.example.administrador.pvsegalmex.entity.ProductEntity;
import com.example.administrador.pvsegalmex.entity.ProviderEntity;
import com.example.administrador.pvsegalmex.entity.UnitMeasurementEntity;
import com.example.administrador.pvsegalmex.entity.UserEntity;
import com.example.administrador.pvsegalmex.entity.WayPayEntity;
import com.example.administrador.pvsegalmex.utils.DialogUtils;
import com.example.administrador.pvsegalmex.viewEntity.CashShortViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.CategoryViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.ClienteViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.DepartmentViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.ProductViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.ProviderViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.UnitMeasurementViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.UserViewEntity;
import com.example.administrador.pvsegalmex.viewEntity.WayPayViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.CashShortViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.CategoryViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.ClienteViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.DepartmentViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.ProductViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.ProviderViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.UnitMeasurementViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.UserViewEntityFactory;
import com.example.administrador.pvsegalmex.viewEntityFactory.WayPayViewEntityFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class InicioView extends MenuView {
    //region VARS
    private CompositeDisposable compositeDisposable;

    //region USER
    private UserViewEntityFactory userViewEntityFactory;
    private UserViewEntity userViewEntity;
    private ArrayList<UserEntity> userEntityArrayList;
    //endregion

    //region PRODUCT VARS
    private ArrayList<ProductEntity> productListInicio;
    private ProductViewEntityFactory productFactory;
    private ProductViewEntity productViewEntity;
    //endregion

    //region Unit Measurement
    private ArrayList<UnitMeasurementEntity> unitMeasurementListInicio;
    private UnitMeasurementViewEntity unitMeasurementViewEntity;
    private UnitMeasurementViewEntityFactory unitMeasurementViewEntityFactory;

    //region WAY PAYS VARS
    private ArrayList<WayPayEntity> wayPayListInicio;
    private WayPayViewEntity wayPayViewEntity;
    private WayPayViewEntityFactory wayPayViewEntityFactory;
    //endregion

    //region CATEGORY VARS
    private ArrayList<CategoryEntity> categoryListInicio;
    private CategoryViewEntity categoryViewEntity;
    private CategoryViewEntityFactory categoryViewEntityFactory;
    //endregion

    //region PROVIDER
    private ArrayList<ProviderEntity> providerListInicio;
    private ProviderViewEntityFactory providerViewEntityFactory;
    private ProviderViewEntity providerViewEntity;
    //endregion

    //region DEPARTMENT VARS
    private DepartmentViewEntity departmentViewEntity;
    private DepartmentViewEntityFactory departmentViewEntityFactory;
    private ArrayList<DepartmentEntity> departmentListInicio;
    //endregion

    //region CLIENT VARS
    private ArrayList<ClienteEntity> clientListInicio;
    private ClienteViewEntityFactory clienteViewEntityFactory;
    private ClienteViewEntity clienteViewEntity;
    //endregion

    //region CASH SHORT
    private CashShortViewEntity cashShortViewEntity;
    private CashShortViewEntityFactory cashShortViewEntityFactory;
    private ArrayList<CashShortEntity> cashShortDetailList;
    //endregion
    //endregion

    //region PROTECTED METHODS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        compositeDisposable = new CompositeDisposable();
        clienteViewEntityFactory = Injection.providerClientViewModelFactory(getApplicationContext());
        clienteViewEntity = ViewModelProviders.of(this, clienteViewEntityFactory).get(ClienteViewEntity.class);
        searchClient();

        cashShortViewEntityFactory = Injection.providerCashShortViewModelFactory(getApplicationContext());
        cashShortViewEntity = ViewModelProviders.of(this, cashShortViewEntityFactory).get(CashShortViewEntity.class);
        searchCashShort();

        userViewEntityFactory = Injection.providerUserViewModelFactory(getApplicationContext());
        userViewEntity = ViewModelProviders.of(this, userViewEntityFactory).get(UserViewEntity.class);
        searchUser();

        unitMeasurementViewEntityFactory = Injection.providerUnitMeasurementViewModelFactory(getApplicationContext());
        unitMeasurementViewEntity = ViewModelProviders.of(this, unitMeasurementViewEntityFactory).get(UnitMeasurementViewEntity.class);
        searchUnitMeasurement();
        departmentViewEntityFactory = Injection.providerDepartamentoViewModelFactory(getApplicationContext());
        departmentViewEntity = ViewModelProviders.of(this, departmentViewEntityFactory).get(DepartmentViewEntity.class);
        searchDepartmentLocal();
        categoryViewEntityFactory = Injection.providerCategoryViewModelFactory(getApplicationContext());
        categoryViewEntity = ViewModelProviders.of(this, categoryViewEntityFactory).get(CategoryViewEntity.class);
        productFactory = Injection.providerProductViewModelFactory(getApplicationContext());
        productViewEntity = ViewModelProviders.of(this, productFactory).get(ProductViewEntity.class);

        providerViewEntityFactory = Injection.providerProviderViewModelFactory(getApplicationContext());
        providerViewEntity = ViewModelProviders.of(this, providerViewEntityFactory).get(ProviderViewEntity.class);
        searchProvider();
        wayPayViewEntityFactory = Injection.providerWayPayViewModelFactory(getApplicationContext());
        wayPayViewEntity = ViewModelProviders.of(this, wayPayViewEntityFactory).get(WayPayViewEntity.class);
        searchWayPayLocal();
    }

    @Override
    protected int getPageLayoutId() {
        return R.layout.activity_inicio_view;
    }

    @Override
    protected String getScreenTitle() {
        return getString(R.string.itemMenu1);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
    //endregion

    //region LOCAL
    //region RECEIPT MERCHANDISE
    private void showDialog() {
        DialogUtils.showOkayNoDialog(getString(R.string.askReceiptMerchandise), getString(R.string.warningReceipMerchandise), this, new DialogUtils.OnOkayNoEvent() {
            @Override
            public void onYes() {
                finish();
                Intent intent = new Intent(getApplicationContext(), CrudReceiptMerchandiseView.class);
                startActivity(intent);
                return;
            }

            @Override
            public void onNo() {
                return;
            }
        });
        return;
    }

    //endregion
    private void searchUser(){
        compositeDisposable.add(userViewEntity.getUser()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<UserEntity>>) productListSearch -> {
                            userEntityArrayList = (ArrayList<UserEntity>) productListSearch;
                            if (userEntityArrayList.isEmpty()) {
                                saveUserLocal();
                            }
                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), "Ocurrio un error al consultar los clientes", Toast.LENGTH_LONG).show();
                            Log.e("PV SEGALMEX error en:", "");
                        }
                ));
    }

    private void saveUserLocal(){
        UserEntity userEntity = new UserEntity();
        userEntity.setTypeUser(1);
        userEntity.setStatus(1);
        userEntity.setAccessKey("dcvhfvheuvh");
        userEntity.setCompany(1);
        userEntity.setEmail("user@mail.com");
        userEntity.setName("Usuario");
        userEntity.setUser(1);
        userEntity.setPassword("123");
        userEntity.setUuid(generateUUID());
        insertUssrLocal(userEntity);
    }

    private void insertUssrLocal(UserEntity userEntity) {
        compositeDisposable.add(userViewEntity.insertUser(userEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                }));
    }

    private void searchProductLocal() {
        compositeDisposable.add(productViewEntity.getFilterProductsCatalog()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<ProductEntity>>) productListSearch -> {
                            productListInicio = (ArrayList<ProductEntity>) productListSearch;
                            if (productListInicio.isEmpty()) {
                                saveProductLocal();
                            }
                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), "Ocurrio un error al consultar los clientes", Toast.LENGTH_LONG).show();
                            Log.e("PV SEGALMEX error en:", "");
                        }
                ));
    }

    private void saveProductLocal() {
        Uri martillo = Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.descarga);
        Uri desarmador = Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.desarmador);
        Uri taladro = Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.taladro);
        Uri tornillos = Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.tornillos);
        ProductEntity productEntity;
        productEntity = new ProductEntity();
        productEntity.setLastDateSync("01/01/00");
        productEntity.setUuid(generateUUID());
        productEntity.setCode("135641651");
        productEntity.setCategory(1);
        productEntity.setCost(10.50);
        productEntity.setCostUC(0.0);
        productEntity.setAlternateCode("51480231");
        productEntity.setDescription("MARTILLO");
        productEntity.setImage(String.valueOf(martillo));
        productListInicio.add(productEntity);

        productEntity = new ProductEntity();
        productEntity.setLastDateSync("01/01/00");
        productEntity.setUuid(generateUUID());
        productEntity.setCode("135641652");
        productEntity.setCategory(1);
        productEntity.setCost(29.50);
        productEntity.setCostUC(0.0);
        productEntity.setAlternateCode("51480232");
        productEntity.setDescription("DESARMADOR");
        productEntity.setImage(String.valueOf(desarmador));
        productListInicio.add(productEntity);

        productEntity = new ProductEntity();
        productEntity.setLastDateSync("01/01/00");
        productEntity.setUuid(generateUUID());
        productEntity.setCode("135641653");
        productEntity.setCategory(1);
        productEntity.setCost(0.75);
        productEntity.setCostUC(0.0);
        productEntity.setAlternateCode("51480233");
        productEntity.setDescription("TORNILLOS 45MM");
        productEntity.setImage(String.valueOf(tornillos));
        productListInicio.add(productEntity);

        productEntity = new ProductEntity();
        productEntity.setLastDateSync("01/01/00");
        productEntity.setUuid(generateUUID());
        productEntity.setCode("135641654");
        productEntity.setCategory(1);
        productEntity.setCost(543.50);
        productEntity.setCostUC(0.0);
        productEntity.setAlternateCode("51480234");
        productEntity.setDescription("TALADRO 3/8 10MM");
        productEntity.setImage(String.valueOf(taladro));
        productListInicio.add(productEntity);

        if (ProductEntity.instance.getId() == -1) {
            insertProductLocal(productListInicio);
        } else {
            Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
        }
    }

    private void insertProductLocal(ArrayList<ProductEntity> productEntity) {
        compositeDisposable.add(productViewEntity.insertProductDefault(productEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                }));
    }

    private void searchWayPayLocal() {
        compositeDisposable.add(wayPayViewEntity.getFilterWayPayCashShort()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<WayPayEntity>>) wayPayListSearch -> {
                            wayPayListInicio = (ArrayList<WayPayEntity>) wayPayListSearch;
                            if (wayPayListInicio.isEmpty()) {
                                saveWayPayLocal();
                            }
                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), "Ocurrio un error al consultar las formas de pago", Toast.LENGTH_LONG).show();
                            Log.e("PV SEGALMEX error en:", "");
                        }
                ));
    }

    private void saveWayPayLocal() {
        Uri efectivo = Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.efectivo);
        WayPayEntity wayPayEntity = new WayPayEntity();

        wayPayEntity.setLastDateSync("01/01/00");
        wayPayEntity.setDescription("EFECTIVO");
        wayPayEntity.setUuid(generateUUID());
        wayPayEntity.setImage(String.valueOf(efectivo));

        if (WayPayEntity.instance.getId() == -1) {
            insertWayPayLocal(wayPayEntity);
        } else {
            Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
        }
    }

    private void insertWayPayLocal(WayPayEntity wayPayEntity) {
        compositeDisposable.add(wayPayViewEntity.insertWayPay(wayPayEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                }));
    }

    private void searchDepartmentLocal() {
        compositeDisposable.add(departmentViewEntity.getFilterCategory()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<DepartmentEntity>>) departmentListSearch -> {
                            departmentListInicio = (ArrayList<DepartmentEntity>) departmentListSearch;
                            if (departmentListInicio.isEmpty()) {
                                saveDepartmentLocal();
                            }

                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), "Ocurrio un error al consultar los departamentos", Toast.LENGTH_LONG).show();
                            Log.e("PV SEGALMEX error en:", "");
                        }
                ));
    }

    private void saveDepartmentLocal() {
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setLastDateSync("01/01/00");
        departmentEntity.setUuid(generateUUID());
        departmentEntity.setDescription("FERRETERIA");

        if (DepartmentEntity.instance.getId() == -1) {
            insertDepartmentLocal(departmentEntity);
        } else {
            Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
        }
    }

    private void insertDepartmentLocal(DepartmentEntity departmentEntity) {
        compositeDisposable.add(departmentViewEntity.insertDepartamento(departmentEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (DepartmentEntity.instance.getId() != -1) {
                        searchCategory();
                    } else {
                        Toast.makeText(getApplicationContext(), "Ha ocurrido un error.", Toast.LENGTH_LONG).show();
                    }
                }));
    }

    private void searchCategory() {
        compositeDisposable.add(categoryViewEntity.getFilterProduct()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<CategoryEntity>>) categoryListSearch -> {
                            categoryListInicio = (ArrayList<CategoryEntity>) categoryListSearch;
                            if (categoryListInicio.isEmpty()) {
                                saveCategoryLocal();
                            }

                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), "Ocurrio un error al consultar las categorias", Toast.LENGTH_LONG).show();
                            Log.e("PV SEGALMEX error en:", "");
                        }
                ));
    }

    private void saveCategoryLocal() {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setDepartment(1);
        categoryEntity.setDescription("HERRAMIENTAS");
        categoryEntity.setLastDateSync("01/01/00");
        categoryEntity.setUuid(generateUUID());

        if (CategoryEntity.instance.getId() == -1) {
            insertCategoryLocal(categoryEntity);
        } else {
            Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
        }
    }

    private void insertCategoryLocal(CategoryEntity categoryEntity) {
        compositeDisposable.add(categoryViewEntity.inserCategory(categoryEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (CategoryEntity.instance.getId() != -1) {
                        searchProductLocal();
                    } else {
                        Toast.makeText(getApplicationContext(), "Ha ocurrido un error.", Toast.LENGTH_LONG).show();
                    }
                }));
    }

    private void searchClient() {
        compositeDisposable.add(clienteViewEntity.getFilterClientsSale()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<ClienteEntity>>) clientListSearch -> {
                            clientListInicio = (ArrayList<ClienteEntity>) clientListSearch;
                            if (clientListInicio.isEmpty()) {
                                //downloadClient();
                                saveClientLocal();
                            }

                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), "Ocurrio un error al consultar los clientes", Toast.LENGTH_LONG).show();
                            Log.e("PV SEGALMEX error en:", "");
                        }
                ));
    }

    private void saveClientLocal() {
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setUuid(generateUUID());
        clienteEntity.setPhotoClient("");
        clienteEntity.setPhone("87-11-11-11-11");
        clienteEntity.setName("JOSE");
        clienteEntity.setMail("jose@mail.com");
        clienteEntity.setLastSellDate("");
        clienteEntity.setLastName2("REYES");
        clienteEntity.setLastName1("RAMIREZ");
        clienteEntity.setIneString("");
        clienteEntity.setGenre('M');
        clienteEntity.setCurp("DBCGVC564QSCD54");
        clienteEntity.setCreditLimit(789898);
        clienteEntity.setCreditDays(25);
        clienteEntity.setAddress("CALLE BENITO JUAREZ");
        clienteEntity.setCompany(1);
        clienteEntity.setLastDateSync("01/01/00");
        clienteEntity.setPhotoIne("");

        if (ClienteEntity.instance.getId() == -1) {
            insertClientLocal(clienteEntity);
        } else {
            Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
        }
    }

    private void insertClientLocal(ClienteEntity clienteEntity) {
        compositeDisposable.add(clienteViewEntity.insertClient(clienteEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                }));
    }

    private void searchProvider() {
        compositeDisposable.add(providerViewEntity.getFilterProviderReceiptMerchandise()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<ProviderEntity>>) departmentListSearch -> {
                            providerListInicio = (ArrayList<ProviderEntity>) departmentListSearch;
                            if (providerListInicio.isEmpty()) {
                                saveProvider();
                            }
                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), "Ocurrio un error al consultar los departamentos", Toast.LENGTH_LONG).show();
                            Log.e("PV SEGALMEX error en:", "");
                        }
                ));
    }

    private void saveProvider() {
        ProviderEntity providerEntity = new ProviderEntity();
        providerEntity.setUuid(generateUUID());
        providerEntity.setAlias("COCA-COLA");
        providerEntity.setComments("");
        providerEntity.setCreditDays(28);
        providerEntity.setCreditLimit(5000.00);
        providerEntity.setCurp("JMLP840609MDGSLN04");
        providerEntity.setDatePay("01/01/2020");
        providerEntity.setDiconsa(false);
        providerEntity.setEmail("cocacola@mail.com");
        providerEntity.setLastDateSync("01/01/00");
        providerEntity.setName("GRUPO COCA COLA");
        providerEntity.setPhone("87-11-11-11-11");
        providerEntity.setRfc("JMLP840609M");
        providerEntity.setStatus(1);

        if (ProviderEntity.instance.getId() == -1) {
            insertProviderLocal(providerEntity);
        } else {
            Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
        }
    }

    private void insertProviderLocal(ProviderEntity providerEntity) {
        compositeDisposable.add(providerViewEntity.insertProvider(providerEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                }));
    }

    private void searchUnitMeasurement() {
        compositeDisposable.add(unitMeasurementViewEntity.getFitlerUnitMeasurament()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<UnitMeasurementEntity>>) unitMeasurementListSearch -> {
                            unitMeasurementListInicio = (ArrayList<UnitMeasurementEntity>) unitMeasurementListSearch;
                            if (unitMeasurementListInicio.isEmpty()) {
                                saveUnitMeasurement();
                            }
                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), "Ocurrio un error al consultar los departamentos", Toast.LENGTH_LONG).show();
                            Log.e("PV SEGALMEX error en:", "");
                        }
                ));
    }

    private void saveUnitMeasurement() {
        UnitMeasurementEntity unitMeasurementEntity;

        unitMeasurementEntity = new UnitMeasurementEntity();
        unitMeasurementEntity.setDescription("kg");
        unitMeasurementEntity.setKaySAT("kgSAT");
        unitMeasurementEntity.setKey("KEY");
        unitMeasurementListInicio.add(unitMeasurementEntity);

        unitMeasurementEntity = new UnitMeasurementEntity();
        unitMeasurementEntity.setDescription("grs");
        unitMeasurementEntity.setKaySAT("grsSAT");
        unitMeasurementEntity.setKey("KEY");
        unitMeasurementListInicio.add(unitMeasurementEntity);

        unitMeasurementEntity = new UnitMeasurementEntity();
        unitMeasurementEntity.setDescription("mgrs");
        unitMeasurementEntity.setKaySAT("mgrsSAT");
        unitMeasurementEntity.setKey("KEY");
        unitMeasurementListInicio.add(unitMeasurementEntity);

        unitMeasurementEntity = new UnitMeasurementEntity();
        unitMeasurementEntity.setDescription("mlt");
        unitMeasurementEntity.setKaySAT("mltSAT");
        unitMeasurementEntity.setKey("KEY");
        unitMeasurementListInicio.add(unitMeasurementEntity);

        unitMeasurementEntity = new UnitMeasurementEntity();
        unitMeasurementEntity.setDescription("ltr");
        unitMeasurementEntity.setKaySAT("ltrSAT");
        unitMeasurementEntity.setKey("KEY");
        unitMeasurementListInicio.add(unitMeasurementEntity);

        unitMeasurementEntity = new UnitMeasurementEntity();
        unitMeasurementEntity.setDescription("fl. oz");
        unitMeasurementEntity.setKaySAT("flozSAT");
        unitMeasurementEntity.setKey("KEY");
        unitMeasurementListInicio.add(unitMeasurementEntity);

        unitMeasurementEntity = new UnitMeasurementEntity();
        unitMeasurementEntity.setDescription("lb");
        unitMeasurementEntity.setKaySAT("lbSAT");
        unitMeasurementEntity.setKey("KEY");
        unitMeasurementListInicio.add(unitMeasurementEntity);

        unitMeasurementEntity = new UnitMeasurementEntity();
        unitMeasurementEntity.setDescription("pz");
        unitMeasurementEntity.setKaySAT("lbSAT");
        unitMeasurementEntity.setKey("H87");
        unitMeasurementListInicio.add(unitMeasurementEntity);

        if (UnitMeasurementEntity.instance.getId() == -1) {
            insertUnitMeasuremnet(unitMeasurementListInicio);
        } else {
            Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
        }
    }

    private void insertUnitMeasuremnet(ArrayList<UnitMeasurementEntity> unitMeasurementEntity) {
        compositeDisposable.add(unitMeasurementViewEntity.insertUnitMeasurementDefault(unitMeasurementEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {

                }));
    }

  /*  private void insertUnitMeasuremnet(UnitMeasurementEntity unitMeasurementEntity){
        compositeDisposable.add(unitMeasurementViewEntity.insertUnitMeasurement(unitMeasurementEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (UnitMeasurementEntity.instance.getId() != -1) {
                    } else {
                        Toast.makeText(getApplicationContext(), "Ha ocurrido un error.", Toast.LENGTH_LONG).show();
                    }
                }));
    }*/

    //region CASH SHORT
    private void searchCashShort() {
        compositeDisposable.add(cashShortViewEntity.getAllCashShort()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<CashShortEntity>>) cashShortDetailListSearch -> {
                            cashShortDetailList = (ArrayList<CashShortEntity>) cashShortDetailListSearch;
                            if (cashShortDetailList.isEmpty()) {
                                saveCashShort();
                            }
                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), getString(R.string.errorConsulta), Toast.LENGTH_LONG).show();
                            Log.e(getString(R.string.errorSQLITE), "");
                        }
                ));
    }

    private void saveCashShort() {
        CashShortEntity cashShortEntity = new CashShortEntity();
        cashShortEntity.setDate(getDate());
        cashShortEntity.setAmountCap(0.0);
        cashShortEntity.setDiference(0.0);
        cashShortEntity.setTotalCal(0.0);
        cashShortEntity.setUuid(generateUUID());
        if (CashShortEntity.instance.getId() == -1) {
            insertCashShort(cashShortEntity);
        }
    }

    private void insertCashShort(CashShortEntity cashShort) {
        compositeDisposable.add(cashShortViewEntity.insertCashShort(cashShort)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                }));
    }
    //endregion

    //endregion
    @Override
    public void onBackPressed() {

    }
}
