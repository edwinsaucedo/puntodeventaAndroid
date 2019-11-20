package com.example.administrador.pvsegalmex.api;

import android.content.Context;

import com.example.administrador.pvsegalmex.utils.ReferencesDB;

public class LoginInfo {
    private Integer tipoUsuario = null;
    private String nombreUsuario = "";
    private Integer punto_venta = null;
    private Integer compania = null;
    private Integer userId = null;
    private String authToken = "";
    private String key = "";
    private String email = "";
    private static final String LOGIN_DATA = "login_info";
    private ReferencesDB rDB;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        update();
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public Integer getCompania() {
        return compania;
    }

    public void setCompania(Integer compania) {
        this.compania = compania;
        update();
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        update();
    }


    public void setAuthToken(String authToken) {
        this.authToken = authToken;
        update();
    }

    public Integer getPunto_venta() {
        return punto_venta;
    }

    public void setPunto_venta(Integer punto_venta) {
        this.punto_venta = punto_venta;
        update();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
        update();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
        update();
    }

    public LoginInfo(Context context) {
        rDB = new ReferencesDB(context);
    }


    public LoginInfo() {
    }

    public void update() {
        rDB.putObject(LOGIN_DATA, this);
    }

    public void clear() {
        tipoUsuario = null;
        nombreUsuario = "";
        punto_venta = null;
        authToken = "";
        compania = null;
    }

    public static LoginInfo build(Context context) {
        ReferencesDB rDB = new ReferencesDB(context);
        String LOGIN_DATA = "login_info";
        try {
            return (LoginInfo) rDB.getObject(LOGIN_DATA, LoginInfo.class);
        } catch (NullPointerException e) {
            return new LoginInfo(context);
        }
    }
}
