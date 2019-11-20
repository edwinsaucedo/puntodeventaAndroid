package com.example.administrador.pvsegalmex.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "IngresosDetalle",
        foreignKeys = {@ForeignKey(
                entity = CashIncomeEntity.class,
                childColumns = {"Ingresos"},
                parentColumns = {"Id"}),
                @ForeignKey(
                        entity = WayPayEntity.class,
                        childColumns = {"FormaPago"},
                        parentColumns = {"Id"})
        })
public class CashIncomeDetailEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private Integer id;
    @ColumnInfo(name = "FormaPago")
    private Integer idWayPay;
    @ColumnInfo(name = "Ingresos")
    private Integer idIncome;
    @ColumnInfo(name = "Monto")
    private Double amount;
    @ColumnInfo(name = "UltimaActualizacion")
    private String lastDateSync;
    @ColumnInfo(name = "UUID")
    private String uuid;

    public CashIncomeDetailEntity() {
        id = null;
        idIncome = null;
        idWayPay = null;
        amount = 0.0;
        lastDateSync = "";
        uuid = "";
    }

    public static CashIncomeDetailEntity instance = new CashIncomeDetailEntity();

    public final void clear(){
        id = -1;
        idIncome = null;
        idWayPay = null;
        amount = 0.0;
        lastDateSync = "";
        uuid = "";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdWayPay() {
        return idWayPay;
    }

    public void setIdWayPay(Integer idWayPay) {
        this.idWayPay = idWayPay;
    }

    public Integer getIdIncome() {
        return idIncome;
    }

    public void setIdIncome(Integer idIncome) {
        this.idIncome = idIncome;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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
}
