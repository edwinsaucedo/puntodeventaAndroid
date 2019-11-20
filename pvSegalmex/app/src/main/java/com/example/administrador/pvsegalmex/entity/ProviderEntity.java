package com.example.administrador.pvsegalmex.entity;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import io.reactivex.annotations.NonNull;

@Entity(tableName = "Proveedores")
public class ProviderEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private Integer id;
    @ColumnInfo(name = "Nombre")
    @SerializedName("NOMBRE")
    private String name;
    @ColumnInfo(name = "Rfc")
    @SerializedName("RFC")
    private String rfc;
    @ColumnInfo(name = "FechaPago")
    @SerializedName("FECHA_PAGO")
    private String datePay;
    @ColumnInfo(name = "Alias")
    @SerializedName("ALIAS")
    private String alias;
    @ColumnInfo(name = "Curp")
    @SerializedName("CURP")
    private String curp;
    @ColumnInfo(name = "Telefono")
    @SerializedName("TELEFONO")
    private String phone;
    @ColumnInfo(name = "Email")
    @SerializedName("EMAIL")
    private String email;
    @ColumnInfo(name = "Comentarios")
    @SerializedName("COMENTARIOS")
    private String comments;
    @ColumnInfo(name = "LimiteCredito")
    @SerializedName("LIMITE_CREDITO")
    private double creditLimit;
    @ColumnInfo(name = "DiasCredito")
    @SerializedName("DIAS_CREDITO")
    private int creditDays;
    @ColumnInfo(name = "Diconsa")
    @SerializedName("DICONSA")
    private boolean diconsa;
    @ColumnInfo(name = "Estatus")
    private int status;
    @ColumnInfo(name = "UltimaActualizacion")
    @SerializedName("ULTIMA_ACTUALIZACION")
    private String lastDateSync;
    @ColumnInfo(name = "UUID")
    @SerializedName("UUID")
    private String uuid;
    @ColumnInfo(name = "Fecha")
    @SerializedName("FECHA")
    private String date;

    public ProviderEntity() {
        id = null;
        name = "";
        rfc = "";
        datePay = "";
        alias = "";
        curp = "";
        phone = "";
        email = "";
        comments = "";
        creditLimit = 0.0;
        creditDays = 0;
        diconsa = false;
        status = 1;
        lastDateSync = "";
        uuid = "";
        date = "";
    }

    public static ProviderEntity instance = new ProviderEntity();

    public final void clear() {
        id = -1;
        name = "";
        rfc = "";
        datePay = "";
        alias = "";
        curp = "";
        phone = "";
        email = "";
        comments = "";
        creditLimit = 0.0;
        creditDays = 0;
        diconsa = false;
        status = 1;
        lastDateSync = "";
        uuid = "";
        date = "";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getDatePay() {
        return datePay;
    }

    public void setDatePay(String datePay) {
        this.datePay = datePay;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public int getCreditDays() {
        return creditDays;
    }

    public void setCreditDays(int creditDays) {
        this.creditDays = creditDays;
    }

    public boolean isDiconsa() {
        return diconsa;
    }

    public void setDiconsa(boolean diconsa) {
        this.diconsa = diconsa;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static ProviderEntity getInstance() {
        return instance;
    }

    public static void setInstance(ProviderEntity instance) {
        ProviderEntity.instance = instance;
    }

    public String getLastDateSync() {
        return lastDateSync;
    }

    public void setLastDateSync(String lastDateSync) {
        this.lastDateSync = lastDateSync;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    @NonNull
    public String toString() {
        return name;
    }
}
