package com.example.administrador.pvsegalmex.api;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JSONProduct {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("response")
    @Expose
    private ResponseProduct response;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ResponseProduct getResponse() {
        return response;
    }

    public void setResponse(ResponseProduct response) {
        this.response = response;
    }

}
