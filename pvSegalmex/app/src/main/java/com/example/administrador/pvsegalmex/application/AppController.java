package com.example.administrador.pvsegalmex.application;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;

import static com.example.administrador.pvsegalmex.pojo.ConstantesRestApi.AUTHORITY;
import static com.example.administrador.pvsegalmex.pojo.ConstantesRestApi.INTERVAL;

import com.example.administrador.pvsegalmex.sync.Synchronization;

public class AppController extends Application {

    public static final String TAG = AppController.class.getSimpleName();

    private static AppController mInstance;
    private static ContentResolver resolvedor;

    public static final String ACCOUNT_TYPE = "com.example.administrador.pvsegalmex";
    public static final String ACCOUNT = "pvSegalmex.db";
    public static final long SYNC_INTERVAL = INTERVAL;

    private Synchronization synchronization;

    Account account;

    @Override
    public void onCreate(){
        super.onCreate();
        mInstance=this;
        resolvedor = getContentResolver();
    }

    public static ContentResolver getResolvedor(){return resolvedor;}

    public static synchronized AppController getInstance(){return  mInstance;}

    //metodos de retrofit

    public static Account createSyncAccount(Context context){
        Account newAccount = new Account( ACCOUNT, ACCOUNT_TYPE);

        AccountManager accountManager = (AccountManager) context.getSystemService(ACCOUNT_SERVICE);

        if (accountManager.addAccountExplicitly(newAccount, null, null)) {
            /*
             * If you don't set android:syncable="true" in
             * in your <provider> element in the manifest,
             * then call context.setIsSyncable(account, AUTHORITY, 1)
             * here.
             */
        } else {
            /*
             * The account exists or some other error occurred. Log this, report it,
             * or handle it internally.
             */
        }
        return newAccount;
    }

    private void activeSync() {
        // Create the dummy account
        account = createSyncAccount(this);
        //Se lanza la sincronización siempre que hay conexión de INTERNET

        //resolvedor.setIsSyncable(mAccount, AUTHORITY, 1); //Creo que no hace falta ponerlo porque ya está en el proveedor en el manifest android:syncable="true"
        resolvedor.setSyncAutomatically(account, AUTHORITY, true);
        resolvedor.setMasterSyncAutomatically(true);
        resolvedor.addPeriodicSync(account, AUTHORITY, Bundle.EMPTY, SYNC_INTERVAL);
    }

    public Synchronization getSynchronization() {
        return synchronization;
    }

    public void setSincronizacion(Synchronization synchronization) {
        this.synchronization = synchronization;
    }
}
