package com.example.administrador.pvsegalmex.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.example.administrador.pvsegalmex.authenticator.Authenticator;

public class AuthenticatorService extends Service {

    private Authenticator authenticator;

    @Override
    public void onCreate(){
        authenticator = new Authenticator(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return authenticator.getIBinder();
    }
}
