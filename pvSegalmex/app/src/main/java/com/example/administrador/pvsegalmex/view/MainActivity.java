package com.example.administrador.pvsegalmex.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;


import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.api.ApiService;
import com.example.administrador.pvsegalmex.api.JSONLogin;
import com.example.administrador.pvsegalmex.api.LoginInfo;
import com.example.administrador.pvsegalmex.api.ServiceProvider;
import com.example.administrador.pvsegalmex.api.User;
import com.example.administrador.pvsegalmex.entity.CashShortEntity;
import com.example.administrador.pvsegalmex.entity.CategoryEntity;
import com.example.administrador.pvsegalmex.entity.ClienteEntity;
import com.example.administrador.pvsegalmex.entity.DepartmentEntity;
import com.example.administrador.pvsegalmex.entity.ProductEntity;
import com.example.administrador.pvsegalmex.entity.ProviderEntity;
import com.example.administrador.pvsegalmex.entity.UnitMeasurementEntity;
import com.example.administrador.pvsegalmex.entity.UserEntity;
import com.example.administrador.pvsegalmex.entity.WayPayEntity;
import com.example.administrador.pvsegalmex.viewEntity.UserViewEntity;
import com.example.administrador.pvsegalmex.viewEntityFactory.UserViewEntityFactory;

import java.security.MessageDigest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.administrador.pvsegalmex.view.IntroView.getFirstTimeRun;

public class MainActivity extends BaseView {

    //region VARS
    private String user, password;
    private CompositeDisposable compositeDisposable;

    //region USER VARS
    private UserViewEntity userViewEntity;
    private UserViewEntityFactory userViewEntityFactory;
    private ArrayList<UserEntity> userListMain = new ArrayList<>();
    //endregion

    //region API VARS
    private ApiService apiService;
    private HashMap<String, String> hashMap;
    private Call<JSONLogin> callLogin;
    //endregion
    //endregion

    //region VIEWS
    @BindView(R.id.edtUserNick)
    EditText edtUserNick;
    @BindView(R.id.edtUserPassword)
    EditText edtUserPassword;
    @BindView(R.id.btnLogin)
    AppCompatButton btnLogin;
    //endregion

    //region PRIVATE METHODS
    public String generateUUID() {
        Date objDate = new Date();
        String strDateFormat = "yymmddHHmmssSSS";
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);

        java.util.Date utilDate = new java.util.Date();

        Calendar cal = Calendar.getInstance(); // locale-specific
        cal.setTime(utilDate);
        long time = cal.getTimeInMillis();
        java.sql.Timestamp sqlTimestamp = new Timestamp(time);

        String user = String.valueOf(LoginInfo.build(MainActivity.this).getUserId());
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

        String uuid = (u + (String.valueOf(objSDF.format(objDate))));
        return uuid;
    }

    //region USER
    //region USER WEBSERVICES
    private void validationUsers() {
        hashMap = new HashMap<>();
        apiService = ServiceProvider.getApiServiceInstance();
        hashMap.put("usuario", edtUserNick.getText().toString());
        hashMap.put("contrasenia", edtUserPassword.getText().toString());
        hashMap.put("aplicacion", "pvCytruss");
        callLogin = apiService.login(hashMap);

        callLogin.enqueue(new Callback<JSONLogin>() {
            @Override
            public void onResponse(Call<JSONLogin> call, Response<JSONLogin> response) {
                if (response.body() == null) {
                    Toast.makeText(MainActivity.this, getString(R.string.errorServidor), Toast.LENGTH_SHORT).show();
                } else if (response.body().getCode().equals("200")) {
                    LoginInfo loginInfo = new LoginInfo(MainActivity.this);
                    int company = response.body().getResponse().getLogin().getCompania();
                    loginInfo.setAuthToken(response.body().getResponse().getAuthToken());
                    loginInfo.setPunto_venta(response.body().getResponse().getLogin().getPuntoVenta());
                    loginInfo.setNombreUsuario(response.body().getResponse().getLogin().getNombreUsuario());
                    loginInfo.setCompania(company);
                    loginInfo.setKey(response.body().getResponse().getLogin().getLlave());
                    loginInfo.setEmail(response.body().getResponse().getLogin().getCorreo());
                    loginInfo.setUserId(response.body().getResponse().getLogin().getId());
                    LoginInfo.build(MainActivity.this);

                    UserEntity userEntity = new UserEntity();
                    if (userListMain.isEmpty()) {
                        UserEntity.instance.clear();
                        userEntity.setAccessKey(response.body().getResponse().getLogin().getLlave());
                        userEntity.setCompany(response.body().getResponse().getLogin().getCompania());
                        userEntity.setEmail(response.body().getResponse().getLogin().getCorreo());
                        userEntity.setIdws(response.body().getResponse().getLogin().getId());
                        userEntity.setName(response.body().getResponse().getLogin().getNombreUsuario());
                        userEntity.setPassword(response.body().getResponse().getLogin().getContrasenia());
                        userEntity.setUser(response.body().getResponse().getLogin().getUsuario());
                        userEntity.setUserPV(response.body().getResponse().getLogin().getPuntoVenta());
                        userEntity.setUuid(generateUUID());
                        if (UserEntity.instance.getId() == -1) {
                            insertUser(userEntity);
                        }
                    }

                    for (int j = 0; j < userListMain.size(); j++) {
                        if (userListMain.get(j).getIdws() != response.body().getResponse().getLogin().getId()) {
                            UserEntity.instance.clear();
                            userEntity.setAccessKey(response.body().getResponse().getLogin().getLlave());
                            userEntity.setCompany(response.body().getResponse().getLogin().getCompania());
                            userEntity.setEmail(response.body().getResponse().getLogin().getCorreo());
                            userEntity.setIdws(response.body().getResponse().getLogin().getId());
                            userEntity.setName(response.body().getResponse().getLogin().getNombreUsuario());
                            userEntity.setPassword(response.body().getResponse().getLogin().getContrasenia());
                            userEntity.setUser(response.body().getResponse().getLogin().getUsuario());
                            userEntity.setUserPV(response.body().getResponse().getLogin().getPuntoVenta());
                            userEntity.setUuid(generateUUID());
                            if (UserEntity.instance.getId() == -1) {
                                insertUser(userEntity);
                            } else if (UserEntity.instance.getIdws() == response.body().getResponse().getLogin().getId()) {

                            }
                        }
                    }
                    Intent intento = new Intent(getApplicationContext(), InicioView.class);
                    startActivity(intento);
                } else {
                    Toast.makeText(MainActivity.this, getString(R.string.userPasswordError), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JSONLogin> call, Throwable t) {
                Toast.makeText(MainActivity.this, getString(R.string.errorServidor), Toast.LENGTH_SHORT).show();
                Log.e("Error: ", getString(R.string.errorServidor), t);
            }
        });
    }
    //endregion

    //region USER DATABASE LOCAL
    private void searchUser() {
        compositeDisposable.add(userViewEntity.getUser()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<UserEntity>>) userListSearch -> {
                            userListMain = (ArrayList<UserEntity>) userListSearch;
                        }, throwable -> {
                            Toast.makeText(getApplicationContext(), "Ocurrio un error al consultar los departamentos", Toast.LENGTH_LONG).show();
                            Log.e("PV SEGALMEX error en:", "");
                        }
                ));
    }

    private void insertUser(UserEntity userEntity) {
        compositeDisposable.add(userViewEntity.insertUser(userEntity)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    if (UserEntity.instance.getId() != -1) {
                        User user = new User(MainActivity.this);
                        user.setUser(UserEntity.instance.getId());
                        User.build(MainActivity.this);
                    }
                })
        );
    }
    //endregion
    //endregion
    //endregion

    //region PROTECTED METHODS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        compositeDisposable = new CompositeDisposable();
        apiService = ServiceProvider.getApiServiceInstance();

        userViewEntityFactory = Injection.providerUserViewModelFactory(getApplicationContext());
        userViewEntity = ViewModelProviders.of(this, userViewEntityFactory).get(UserViewEntity.class);
        searchUser();

        btnLogin.setOnClickListener(v -> {
            CashShortEntity.instance.clear();
            ClienteEntity.instance.clear();
            ProductEntity.instance.clear();
            CategoryEntity.instance.clear();
            DepartmentEntity.instance.clear();
            WayPayEntity.instance.clear();
            ProviderEntity.instance.clear();
            UnitMeasurementEntity.instance.clear();
            Intent intento = new Intent(getApplicationContext(), InicioView.class);
            startActivity(intento);
          /*  user = edtUserNick.getText().toString();
            password = edtUserPassword.getText().toString();
            String pass = getHash(password, "pvApi1.1");
            if (userList.isEmpty()) {
                CashShortEntity.instance.clear();
                ClienteEntity.instance.clear();
                ProductEntity.instance.clear();
                CategoryEntity.instance.clear();
                DepartmentEntity.instance.clear();
                WayPayEntity.instance.clear();
                ProviderEntity.instance.clear();
                UnitMeasurementEntity.instance.clear();
                validationUsers();
            } else {
                for (int i = 0; i < userList.size(); i++) {
                    if (pass.equals(userList.get(i).getPassword()) && user.equals(userList.get(i).getName())) {
                        CashShortEntity.instance.clear();
                        ClienteEntity.instance.clear();
                        ProductEntity.instance.clear();
                        CategoryEntity.instance.clear();
                        DepartmentEntity.instance.clear();
                        WayPayEntity.instance.clear();
                        ProviderEntity.instance.clear();
                        UnitMeasurementEntity.instance.clear();
                        Intent intento = new Intent(getApplicationContext(), InicioView.class);
                        startActivity(intento);
                    }
                     else{
                        CashShortEntity.instance.clear();
                        ClienteEntity.instance.clear();
                        ProductEntity.instance.clear();
                        CategoryEntity.instance.clear();
                        DepartmentEntity.instance.clear();
                        WayPayEntity.instance.clear();
                        ProviderEntity.instance.clear();
                        UnitMeasurementEntity.instance.clear();
                       validationUsers();
                    }
                }
            }*/
        });

        switch (getFirstTimeRun(this)) {
            case 0:
                // acá haces el intent a tu activity especial
                Intent intento = new Intent(getApplicationContext(), IntroView.class);
                startActivity(intento);
                break;
            case 1:
                //
                break;
            case 2:
                //
                break;
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        userViewEntityFactory = Injection.providerUserViewModelFactory(getApplicationContext());
        userViewEntity = ViewModelProviders.of(this, userViewEntityFactory).get(UserViewEntity.class);
        searchUser();
    }

    @Override
    public void onBackPressed() {
    }
    //endregion

    //region PUBLIC METHODS

    /**
     * getHash                  Cifrar cadena de texto.
     *
     * @param object String  Objeto a cifrar.
     * @param salt   String  clave del cifrado.
     * @return String          Objeto Cifrado
     */
    public String getHash(String object, String salt) {
        MessageDigest tCifrado;
        StringBuilder sb = new StringBuilder();
        byte[] objectByte, objectHash;
        try {
            tCifrado = MessageDigest.getInstance("SHA-256");
            objectByte = (salt + object).getBytes();
            objectHash = tCifrado.digest(objectByte);
            for (byte b : objectHash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception ex) {
            Log.e("Error: ", ex.getMessage());
            return "";
        }
    }
    //endregion
}
