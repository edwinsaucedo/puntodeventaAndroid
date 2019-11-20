package com.example.administrador.pvsegalmex.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ExistApi {
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("response")
    @Expose
    private ResponseExist response;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ResponseExist getResponse() {
        return response;
    }

    public void setResponse(ResponseExist response) {
        this.response = response;
    }

}

class ResponseExist{
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
