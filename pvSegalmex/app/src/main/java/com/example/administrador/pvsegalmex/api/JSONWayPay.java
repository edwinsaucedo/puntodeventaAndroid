package com.example.administrador.pvsegalmex.api;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JSONWayPay {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("response")
    @Expose
    private ResponseWayPay response;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ResponseWayPay getResponse() {
        return response;
    }

    public void setResponse(ResponseWayPay response) {
        this.response = response;
    }

}
