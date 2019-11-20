package com.example.administrador.pvsegalmex.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Bitacora")
public class BitacoraEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private Integer id;
    @ColumnInfo(name = "Fecha")
    private String date;
    @ColumnInfo(name = "Estatus")
    private int status;
    @ColumnInfo(name = "Tabla")
    private String table;
    @ColumnInfo(name = "IdTabla")
    private int idTable;

    public BitacoraEntity() {
        id = null;
        date = "";
        status = 1;
        table = "";
        idTable = 0;
    }

    public static BitacoraEntity instance = new BitacoraEntity();

    public final void clear() {
        id = -1;
        date = "";
        status = 1;
        table = "";
        idTable = 0;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public int getIdTable() {
        return idTable;
    }

    public void setIdTable(int idTable) {
        this.idTable = idTable;
    }

    public static BitacoraEntity getInstance() {
        return instance;
    }

    public static void setInstance(BitacoraEntity instance) {
        BitacoraEntity.instance = instance;
    }
}