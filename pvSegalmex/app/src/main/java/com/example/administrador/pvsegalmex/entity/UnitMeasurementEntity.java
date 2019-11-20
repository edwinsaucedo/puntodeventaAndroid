package com.example.administrador.pvsegalmex.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import io.reactivex.annotations.NonNull;

@Entity(tableName = "UnidadMedida")
public class UnitMeasurementEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")//*
    private Integer id;
    @ColumnInfo(name = "Clave")//*
    @SerializedName("CLAVE")
    private String key;
    @ColumnInfo(name = "Descripcion")//*
    @SerializedName("DESCRIPCION")
    private String description;
    @ColumnInfo(name = "ClaveSAT")
    @SerializedName("CLAVE_SAT")
    private String kaySAT;
    @ColumnInfo(name = "UUID")
    @SerializedName("UUID")
    private String uuid;
    @ColumnInfo(name = "UltimaActualizacion")
    private String lastDateSync;

    public UnitMeasurementEntity(){
        id = null;
        key = "";
        description = "";
        kaySAT = "";
        uuid = "";
        lastDateSync = "";
    }

    public static UnitMeasurementEntity instance = new UnitMeasurementEntity();

    public final void clear(){
        id = -1;
        key = "";
        description = "";
        kaySAT = "";
        uuid = "";
        lastDateSync = "01/01/2000";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKaySAT() {
        return kaySAT;
    }

    public void setKaySAT(String kaySAT) {
        this.kaySAT = kaySAT;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getLastDateSync() {
        return lastDateSync;
    }

    public void setLastDateSync(String lastDateSync) {
        this.lastDateSync = lastDateSync;
    }

    @Override
    @NonNull
    public String toString() {
        return description;
    }

}
