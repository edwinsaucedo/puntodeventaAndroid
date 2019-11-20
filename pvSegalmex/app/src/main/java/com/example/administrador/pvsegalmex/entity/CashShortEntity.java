package com.example.administrador.pvsegalmex.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "CorteCaja",
        foreignKeys = {@ForeignKey(
                entity = UserEntity.class,
                childColumns = {"Usuario"},
                parentColumns = {"Id"})
        })
public class CashShortEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private Integer id;
    @ColumnInfo(name = "Usuario")
    @SerializedName("USUARIO")
    private Integer user;
    @ColumnInfo(name = "Fecha")
    @SerializedName("FECHA")
    private String date;
    @ColumnInfo(name = "TotalCalculado")
    @SerializedName("TOTAL_CALCULADO")
    private Double totalCal;
    @ColumnInfo(name = "MontoCapturado")
    @SerializedName("MONTO_CAPTURADO")
    private Double amountCap;
    @ColumnInfo(name = "Diferencia")
    @SerializedName("DIFERENCIA")
    private Double diference;
    @ColumnInfo(name="UUID")
    @SerializedName("UUID")
    private String uuid;
    @ColumnInfo(name="UUIDUser")
    @SerializedName("UUID_User")
    private String uuidUser;
    @ColumnInfo(name = "Estatus")
    private int status;

    public CashShortEntity() {
        id = null;
        user = null;
        date = "";
        totalCal = 0.0;
        amountCap = 0.0;
        diference = 0.0;
        uuid = "";
        status = 0;
        uuidUser = "";
    }

    public static CashShortEntity instance = new CashShortEntity();

    public final void clear() {
        id = -1;
        user = null;
        date = "";
        totalCal = 0.0;
        amountCap = 0.0;
        diference = 0.0;
        uuid = "";
        status = 1;
        uuidUser = "";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getTotalCal() {
        return totalCal;
    }

    public void setTotalCal(Double totalCal) {
        this.totalCal = totalCal;
    }

    public Double getAmountCap() {
        return amountCap;
    }

    public void setAmountCap(Double amountCap) {
        this.amountCap = amountCap;
    }

    public Double getDiference() {
        return diference;
    }

    public void setDiference(Double diference) {
        this.diference = diference;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUuidUser() {
        return uuidUser;
    }

    public void setUuidUser(String uuidUser) {
        this.uuidUser = uuidUser;
    }

    public static CashShortEntity getInstance() {
        return instance;
    }

    public static void setInstance(CashShortEntity instance) {
        CashShortEntity.instance = instance;
    }
}
