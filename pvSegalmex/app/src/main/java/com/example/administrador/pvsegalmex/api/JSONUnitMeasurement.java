package com.example.administrador.pvsegalmex.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JSONUnitMeasurement {
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("response")
    @Expose
    private ResponseUnitMeasurement response;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ResponseUnitMeasurement getResponse() {
        return response;
    }

    public void setResponse(ResponseUnitMeasurement response) {
        this.response = response;
    }
}
