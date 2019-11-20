package com.example.administrador.pvsegalmex.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class SaleApi {
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("response")
    @Expose
    private ResponseSale response;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ResponseSale getResponse() {
        return response;
    }

    public void setResponse(ResponseSale response) {
        this.response = response;
    }

}

class ResponseSale{
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
