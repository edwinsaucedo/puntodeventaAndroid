package com.example.administrador.pvsegalmex.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseCategory {


    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("categorias")
    @Expose
    private List<CategoryApi> categorias = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<CategoryApi> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoryApi> categorias) {
        this.categorias = categorias;
    }
}
