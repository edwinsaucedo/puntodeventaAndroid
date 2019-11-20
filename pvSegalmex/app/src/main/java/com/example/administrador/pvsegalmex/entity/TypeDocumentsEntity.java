package com.example.administrador.pvsegalmex.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "TipoDocumentoVta")
public class TypeDocumentsEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private Integer id;
    @ColumnInfo(name = "Descripcion")
    @SerializedName("DESCRIPCION")
    private String description;
    @ColumnInfo(name = "Consecutivo")
    @SerializedName("CONSECUTIVO")
    private int consecutive;
    @ColumnInfo(name = "Estus")
    private int status;
    @ColumnInfo(name = "Modulo")
    @SerializedName("MODULO")
    private String module;
    @ColumnInfo(name = "UUID")
    @SerializedName("UUID")
    private String uuid;

    public TypeDocumentsEntity() {
        id = null;
        description = "";
        consecutive = 0;
        status = 1;
        module = "";
        uuid = "";
    }

    public static TypeDocumentsEntity instance = new TypeDocumentsEntity();

    public final void clear() {
        id = -1;
        description = "";
        consecutive = 0;
        status = 1;
        module = "";
        uuid = "";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getConsecutive() {
        return consecutive;
    }

    public void setConsecutive(int consecutive) {
        this.consecutive = consecutive;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public static TypeDocumentsEntity getInstance() {
        return instance;
    }

    public static void setInstance(TypeDocumentsEntity instance) {
        TypeDocumentsEntity.instance = instance;
    }
}
