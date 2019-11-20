package com.example.administrador.pvsegalmex.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DepartmentApi {

    @SerializedName("DESCRIPCION")
    @Expose
    private String dESCRIPCION;
    @SerializedName("UUID")
    @Expose
    private String uUID;

    public String getDESCRIPCION() {
        return dESCRIPCION;
    }

    public void setDESCRIPCION(String dESCRIPCION) {
        this.dESCRIPCION = dESCRIPCION;
    }

    public String getUUID() {
        return uUID;
    }

    public void setUUID(String uUID) {
        this.uUID = uUID;
    }
}
