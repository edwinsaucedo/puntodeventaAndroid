package com.example.administrador.pvsegalmex.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "CajaRegistradora")
public class CashRegisterEntity {
    @PrimaryKey
    @ColumnInfo(name = "Id")
    Integer id;
    @ColumnInfo(name = "TotalVentas")
    Double totalSale;
    @ColumnInfo(name = "TotalRetiros")
    Double totalWithdrawal;
    @ColumnInfo(name = "TotalIngresos")
    Double totalIncome;
    @ColumnInfo(name = "TotalCaja")
    Double totalCashRegister;
    @ColumnInfo(name = "Estatus")
    int status;

    public CashRegisterEntity() {
        id = null;
        totalCashRegister = 0.0;
        totalIncome = 0.0;
        totalSale = 0.0;
        totalWithdrawal = 0.0;
        status = 1;
    }

    public static CashRegisterEntity instance = new CashRegisterEntity();

    public final void clear() {
        id = -1;
        totalCashRegister = 0.0;
        totalIncome = 0.0;
        totalSale = 0.0;
        totalWithdrawal = 0.0;
        status = 1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(Double totalSale) {
        this.totalSale = totalSale;
    }

    public Double getTotalWithdrawal() {
        return totalWithdrawal;
    }

    public void setTotalWithdrawal(Double totalWithdrawal) {
        this.totalWithdrawal = totalWithdrawal;
    }

    public Double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(Double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public Double getTotalCashRegister() {
        return totalCashRegister;
    }

    public void setTotalCashRegister(Double totalCashRegister) {
        this.totalCashRegister = totalCashRegister;
    }

    public static CashRegisterEntity getInstance() {
        return instance;
    }

    public static void setInstance(CashRegisterEntity instance) {
        CashRegisterEntity.instance = instance;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
