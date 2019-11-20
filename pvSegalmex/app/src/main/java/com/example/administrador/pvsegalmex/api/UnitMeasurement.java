package com.example.administrador.pvsegalmex.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UnitMeasurement {
    @SerializedName("clave")
    @Expose
    private String clave;
    @SerializedName("descripcion")
    @Expose
    private String descripcion;
    @SerializedName("claveSat")
    @Expose
    private String claveSat;
    @SerializedName("uuid")
    @Expose
    private String uuid;

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getClaveSat() {
        return claveSat;
    }

    public void setClaveSat(String claveSat) {
        this.claveSat = claveSat;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
