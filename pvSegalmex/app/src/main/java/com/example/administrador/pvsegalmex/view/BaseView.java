package com.example.administrador.pvsegalmex.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

@SuppressLint("Registered")
public class BaseView extends AppCompatActivity {
    //Metodos globales de las diferentes vistas.

    protected final void restartActivity(Class cls) {
        if (cls != null) {
            Intent intent = new Intent((Context) this, cls);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            finish();
        }
    }

    protected final void startActivity(Class cls) {
        if (cls != null) {
            Intent intent = new Intent(this, cls);
            startActivity(intent);
        }
    }
}
