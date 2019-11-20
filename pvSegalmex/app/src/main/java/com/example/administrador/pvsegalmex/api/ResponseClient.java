package com.example.administrador.pvsegalmex.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseClient {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("departamentos")
    @Expose
    private List<ClientApi> departamentos = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ClientApi> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<ClientApi> departamentos) {
        this.departamentos = departamentos;
    }
}
