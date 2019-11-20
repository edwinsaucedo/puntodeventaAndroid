package com.example.administrador.pvsegalmex.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductApi {
    @SerializedName("unidadMedida")
    @Expose
    private Integer unidadMedida;
    @SerializedName("unidadMedidaCompra")
    @Expose
    private Integer unidadMedidaCompra;
    @SerializedName("categoria")
    @Expose
    private Integer categoria;
    @SerializedName("codigo")
    @Expose
    private String codigo;
    @SerializedName("descripcion")
    @Expose
    private String descripcion;
    @SerializedName("fechaUc")
    @Expose
    private String fechaUc;
    @SerializedName("uuid")
    @Expose
    private String uuid;
    @SerializedName("maximo")
    @Expose
    private Integer maximo;
    @SerializedName("minimo")
    @Expose
    private Integer minimo;
    @SerializedName("puntoReorden")
    @Expose
    private Integer puntoReorden;
    @SerializedName("factor")
    @Expose
    private Integer factor;
    @SerializedName("costo")
    @Expose
    private Double costo;
    @SerializedName("costoUc")
    @Expose
    private Double costoUc;
    @SerializedName("granel")
    @Expose
    private Boolean granel;
    @SerializedName("diconsa")
    @Expose
    private Boolean diconsa;
    @SerializedName("servicio")
    @Expose
    private Boolean servicio;

    public Integer getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(Integer unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Integer getUnidadMedidaCompra() {
        return unidadMedidaCompra;
    }

    public void setUnidadMedidaCompra(Integer unidadMedidaCompra) {
        this.unidadMedidaCompra = unidadMedidaCompra;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaUc() {
        return fechaUc;
    }

    public void setFechaUc(String fechaUc) {
        this.fechaUc = fechaUc;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getMaximo() {
        return maximo;
    }

    public void setMaximo(Integer maximo) {
        this.maximo = maximo;
    }

    public Integer getMinimo() {
        return minimo;
    }

    public void setMinimo(Integer minimo) {
        this.minimo = minimo;
    }

    public Integer getPuntoReorden() {
        return puntoReorden;
    }

    public void setPuntoReorden(Integer puntoReorden) {
        this.puntoReorden = puntoReorden;
    }

    public Integer getFactor() {
        return factor;
    }

    public void setFactor(Integer factor) {
        this.factor = factor;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Double getCostoUc() {
        return costoUc;
    }

    public void setCostoUc(Double costoUc) {
        this.costoUc = costoUc;
    }

    public Boolean getGranel() {
        return granel;
    }

    public void setGranel(Boolean granel) {
        this.granel = granel;
    }

    public Boolean getDiconsa() {
        return diconsa;
    }

    public void setDiconsa(Boolean diconsa) {
        this.diconsa = diconsa;
    }

    public Boolean getServicio() {
        return servicio;
    }

    public void setServicio(Boolean servicio) {
        this.servicio = servicio;
    }

}
