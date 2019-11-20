package com.example.administrador.pvsegalmex.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "Ingresos",
        foreignKeys = {@ForeignKey(
                entity = CashShortEntity.class,
                childColumns = {"CorteCaja"},
                parentColumns = {"Id"})
        })
public class CashIncomeEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private Integer id;
    @ColumnInfo(name = "Fecha")
    @SerializedName("FECHA")
    private String date;
    @ColumnInfo(name = "Comentarios")
    @SerializedName("COMENTARIOS")
    private String comments;
    @ColumnInfo(name = "Monto")
    @SerializedName("MONTO")
    private Double amount;
    @ColumnInfo(name = "Estatus")
    @SerializedName("ESTATUS")
    private int status;
    @ColumnInfo(name="UUID")
    @SerializedName("UUID")
    private String uuid;
    @ColumnInfo(name = "CorteCaja")
    @SerializedName("CORTE_CAJA")
    private Integer cashShort;
    @ColumnInfo(name = "UUIDCorteCaja")
    @SerializedName("UUID_CORTE_CAJA")
    private String uuidCashShort;


    public CashIncomeEntity() {
        id = null;
        date = "";
        comments = "";
        amount = 0.0;
        status = 0;
        uuid="";
        cashShort = null;
        uuidCashShort = "";
    }

    public static CashIncomeEntity instance = new CashIncomeEntity();

    public final void clear() {
        id = -1;
        date = "";
        comments = "";
        amount = 0.0;
        status = 0;
        uuid="";
        cashShort = null;
        uuidCashShort = "";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

    public String getUuidCashShort() {
        return uuidCashShort;
    }

    public void setUuidCashShort(String uuidCashShort) {
        this.uuidCashShort = uuidCashShort;
    }

    public static CashIncomeEntity getInstance() {
        return instance;
    }

    public static void setInstance(CashIncomeEntity instance) {
        CashIncomeEntity.instance = instance;
    }
}
