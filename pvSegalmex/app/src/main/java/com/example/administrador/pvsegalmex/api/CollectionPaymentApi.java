package com.example.administrador.pvsegalmex.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CollectionPaymentApi {
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("response")
    @Expose
    private ResponseCollection response;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ResponseCollection getResponse() {
        return response;
    }

    public void setResponse(ResponseCollection response) {
        this.response = response;
    }

}

class ResponseCollection{
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("dataFail")
    @Expose
    private ArrayList dataFail = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList getDataFail() {
        return dataFail;
    }

    public void setDataFail(ArrayList dataFail) {
        this.dataFail = dataFail;
    }
}