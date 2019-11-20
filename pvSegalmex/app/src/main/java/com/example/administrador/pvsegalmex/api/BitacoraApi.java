package com.example.administrador.pvsegalmex.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BitacoraApi {
    @SerializedName("tabla")
    @Expose
    private String tabla;

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }
}
