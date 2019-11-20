package com.example.administrador.pvsegalmex.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "RetiroCajaDetalle",
        foreignKeys = {@ForeignKey(
                entity = WithdrawalEntity.class,
                childColumns = {"RetiroCaja"},
                parentColumns = {"Id"}),
                @ForeignKey(
                        entity = WayPayEntity.class,
                        childColumns = {"FormaPago"},
                        parentColumns = {"Id"})
        })
public class WithdrawalDetailEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private Integer id;
    @ColumnInfo(name = "FormaPago")
    private Integer idWayPay;
    @ColumnInfo(name = "RetiroCaja")
    private Integer idWithdrawal;
    @ColumnInfo(name = "Monto")
    private Double amount;
    @ColumnInfo(name = "UltimaActualizacion")
    private String lastDateSync;
    @ColumnInfo(name = "UUID")
    private String uuid;

    public WithdrawalDetailEntity() {
        id = null;
        idWayPay = null;
        idWithdrawal = null;
        amount = 0.0;
        lastDateSync = "";
        uuid = "";
    }

    public static WithdrawalDetailEntity instance = new WithdrawalDetailEntity();

    public final void clear() {
        id = -1;
        idWayPay = null;
        idWithdrawal = null;
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

    public Integer getIdWithdrawal() {
        return idWithdrawal;
    }

    public void setIdWithdrawal(Integer idWithdrawal) {
        this.idWithdrawal = idWithdrawal;
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

