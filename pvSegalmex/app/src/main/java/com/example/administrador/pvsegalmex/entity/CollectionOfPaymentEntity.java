package com.example.administrador.pvsegalmex.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "VentaCobro",
        foreignKeys = {@ForeignKey(
                entity = SalesEntity.class,
                childColumns = {"Venta"},
                parentColumns = {"Id"}),
                @ForeignKey(
                        entity = WayPayEntity.class,
                        childColumns = {"FormaPago"},
                        parentColumns = {"Id"}),
                @ForeignKey(
                        entity = CashShortEntity.class,
                        childColumns = {"CorteCaja"},
                        parentColumns = {"Id"})
        })
public class CollectionOfPaymentEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private Integer id;
    @ColumnInfo(name = "Venta")
    @SerializedName("VENTA")
    private Integer sale;
    @ColumnInfo(name = "FormaPago")
    @SerializedName("FORMA_PAGO")
    private Integer wayPay;
    @ColumnInfo(name = "CorteCaja")
    @SerializedName("CORTE_CAJA")
    private Integer cashShort;
    @ColumnInfo(name = "Monto")
    @SerializedName("MONTO")
    private Double amount;
    @ColumnInfo(name = "Estatus")
    private int status;
    @ColumnInfo(name = "Fecha")
    @SerializedName("FECHA")
    private String date;
    @ColumnInfo(name="UUID")
    @SerializedName("UUID")
    private String uuid;
    @ColumnInfo(name="UUIDVenta")
    @SerializedName("UUID_VENTA")
    private String uuidSale;
    @ColumnInfo(name="UUIDFormaPago")
    @SerializedName("UUID_FORMA_PAGO")
    private String uuidWayPay;
    @ColumnInfo(name="UUIDCorteCaja")
    @SerializedName("UUID_CORTE_CAJA")
    private String uuidCashShort;

    public CollectionOfPaymentEntity() {
        id = null;
        sale = null;
        wayPay = null;
        cashShort = null;
        amount = 0.0;
        status = 1;
        date = "";
        uuid = "";
        uuidSale = "";
        uuidCashShort = "";
        uuidWayPay = "";
    }

    public static CollectionOfPaymentEntity instance = new CollectionOfPaymentEntity();

    public final void clear() {
        id = -1;
        sale = null;
        wayPay = null;
        cashShort = null;
        amount = 0.0;
        status = 1;
        date = "";
        uuid = "";
        uuidSale = "";
        uuidCashShort = "";
        uuidWayPay = "";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public Integer getWayPay() {
        return wayPay;
    }

    public void setWayPay(Integer wayPay) {
        this.wayPay = wayPay;
    }

    public Integer getCashShort() {
        return cashShort;
    }

    public void setCashShort(Integer cashShort) {
        this.cashShort = cashShort;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuidSale() {
        return uuidSale;
    }

    public void setUuidSale(String uuidSale) {
        this.uuidSale = uuidSale;
    }

    public String getUuidWayPay() {
        return uuidWayPay;
    }

    public void setUuidWayPay(String uuidWayPay) {
        this.uuidWayPay = uuidWayPay;
    }

    public String getUuidCashShort() {
        return uuidCashShort;
    }

    public void setUuidCashShort(String uuidCashShort) {
        this.uuidCashShort = uuidCashShort;
    }

    public static CollectionOfPaymentEntity getInstance() {
        return instance;
    }

    public static void setInstance(CollectionOfPaymentEntity instance) {
        CollectionOfPaymentEntity.instance = instance;
    }
}
