package com.example.administrador.pvsegalmex.api;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseWayPay {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("formasPago")
    @Expose
    private List<WayPayApi> formasPago = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<WayPayApi> getFormasPago() {
        return formasPago;
    }

    public void setFormasPago(List<WayPayApi> formasPago) {
        this.formasPago = formasPago;
    }

}
