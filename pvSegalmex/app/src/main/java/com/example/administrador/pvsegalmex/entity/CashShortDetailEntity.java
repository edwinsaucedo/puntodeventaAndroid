package com.example.administrador.pvsegalmex.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "CorteCajaDetalle",
        foreignKeys = {@ForeignKey(
                entity = CashShortEntity.class,
                childColumns = {"CorteCaja"},
                parentColumns = {"Id"}),
                @ForeignKey(
                        entity = WayPayEntity.class,
                        childColumns = {"FormaPago"},
                        parentColumns = {"Id"}),
        })
public class CashShortDetailEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private Integer id;
    @ColumnInfo(name = "CorteCaja")
    @SerializedName("CORTE_CAJA")
    private Integer cashShort;
    @ColumnInfo(name = "FormaPago")
    @SerializedName("FORMA_PAGO")
    private Integer wayPay;
    @ColumnInfo(name = "MontoCalculado")
    @SerializedName("MONTO_CALCULADO")
    private Double amountCal;
    @ColumnInfo(name = "MontoCapturado")
    @SerializedName("MONTO_CAPTURADO")
    private Double amountCap;
    @ColumnInfo(name = "Diference")
    @SerializedName("DIFERENCIA")
    private Double diference;
    @ColumnInfo(name = "Estatus")
    private int status;
    @ColumnInfo(name = "Fecha")
    @SerializedName("FECHA")
    private String date;
    @ColumnInfo(name="UUID")
    @SerializedName("UUID")
    private String uuid;
    @ColumnInfo(name="UUIDCorteCaja")
    @SerializedName("UUID_CORTE_CAJA")
    private String uuidCashShort;
    @ColumnInfo(name="UUIDFormaPago")
    @SerializedName("UUID_FORMA_PAGO")
    private String uuidWayPay;

    public CashShortDetailEntity() {
        id = null;
        cashShort = null;
        wayPay = null;
        amountCal = 0.0;
        amountCap = 0.0;
        diference = 0.0;
        status = 1;
        date = "";
        uuid = "";
        uuidCashShort = "";
        uuidWayPay = "";
    }

    public static CashShortDetailEntity instance = new CashShortDetailEntity();

    public final void clear() {
        id = -1;
        cashShort = null;
        wayPay = null;
        amountCal = 0.0;
        amountCap = 0.0;
        diference = 0.0;
        status = 1;
        date = "";
        uuid = "";
        uuidCashShort = "";
        uuidWayPay = "";
    }

    public Integer getId() {
        return id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmountCal() {
        return amountCal;
    }

    public void setAmountCal(Double amountCal) {
        this.amountCal = amountCal;
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

    public Integer getCashShort() {
        return cashShort;
    }

    public void setCashShort(Integer cashShort) {
        this.cashShort = cashShort;
    }

    public Integer getWayPay() {
        return wayPay;
    }

    public void setWayPay(Integer wayPay) {
        this.wayPay = wayPay;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUuidCashShort() {
        return uuidCashShort;
    }

    public void setUuidCashShort(String uuidCashShort) {
        this.uuidCashShort = uuidCashShort;
    }

    public String getUuidWayPay() {
        return uuidWayPay;
    }

    public void setUuidWayPay(String uuidWayPay) {
        this.uuidWayPay = uuidWayPay;
    }

    public static CashShortDetailEntity getInstance() {
        return instance;
    }

    public static void setInstance(CashShortDetailEntity instance) {
        CashShortDetailEntity.instance = instance;
    }
}
