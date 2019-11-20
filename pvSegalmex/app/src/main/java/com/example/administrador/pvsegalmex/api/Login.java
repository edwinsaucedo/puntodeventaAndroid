package com.example.administrador.pvsegalmex.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Login {

    @SerializedName("nombreUsuario")
    @Expose
    private String nombreUsuario;

    @SerializedName("compania")
    @Expose
    private Integer compania;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("usuario")
    @Expose
    private Integer usuario;

    @SerializedName("contrasenia")
    @Expose
    private String contrasenia;

    @SerializedName("correo")
    @Expose
    private String correo;

    @SerializedName("llave")
    @Expose
    private String llave;

    @SerializedName("punto_venta")
    @Expose
    private Integer puntoVenta;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getLlave() {
        return llave;
    }

    public void setLlave(String llave) {
        this.llave = llave;
    }

    public Integer getCompania() {
        return compania;
    }

    public void setCompania(Integer compania) {
        this.compania = compania;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Integer getPuntoVenta() {
        return puntoVenta;
    }

    public void setPuntoVenta(Integer puntoVenta) {
        this.puntoVenta = puntoVenta;
    }
}

