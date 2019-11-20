package com.example.administrador.pvsegalmex.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseProduct {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("productos")
    @Expose
    private List<ProductApi> productos = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ProductApi> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductApi> productos) {
        this.productos = productos;
    }

}

