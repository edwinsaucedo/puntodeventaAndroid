package com.example.administrador.pvsegalmex.api;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JSONDepartment {
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("response")
    @Expose
    private ResponseDepartment response;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ResponseDepartment getResponse() {
        return response;
    }

    public void setResponse(ResponseDepartment response) {
        this.response = response;
    }
}

