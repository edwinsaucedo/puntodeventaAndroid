package com.example.administrador.pvsegalmex.api;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseBitacora {
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("tablas")
    @Expose
    private List<BitacoraApi> tablas = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<BitacoraApi> getTablas() {
        return tablas;
    }

    public void setTablas(List<BitacoraApi> tablas) {
        this.tablas = tablas;
    }

}
