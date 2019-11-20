package com.example.administrador.pvsegalmex.api;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JSONBitacora {
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("response")
    @Expose
    private ResponseBitacora response;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ResponseBitacora getResponse() {
        return response;
    }

    public void setResponse(ResponseBitacora response) {
        this.response = response;
    }
}