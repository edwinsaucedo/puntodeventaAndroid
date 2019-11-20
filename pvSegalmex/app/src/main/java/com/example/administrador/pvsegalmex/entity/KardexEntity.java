package com.example.administrador.pvsegalmex.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "Kardex",
        foreignKeys = {@ForeignKey(
                entity = TypeDocumentsEntity.class,
                childColumns = {"TipoDocumento"},
                parentColumns = {"Id"}),
                @ForeignKey(
                        entity = UserEntity.class,
                        childColumns = {"Usuario"},
                        parentColumns = {"Id"}),

        }
)
public class KardexEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private Integer id;
    @ColumnInfo(name = "TipoDocumento")
    @SerializedName("TIPO_DOCUMENTO")
    private Integer typeDocument;
    @ColumnInfo(name = "NumeroDocumento")
    @SerializedName("NUMERO_DOCUMENTO")
    private Integer numberDocument;
    @ColumnInfo(name = "Fecha")
    @SerializedName("FECHA")
    private String date;
    @ColumnInfo(name = "Usuario")
    @SerializedName("USUARIO")
    private Integer user;
    @ColumnInfo(name = "Estatus")
    private int status;
    @ColumnInfo(name = "UUID")
    @SerializedName("UUID")
    private String uuid;
    @ColumnInfo(name = "UUIDTipoDocumento")
    @SerializedName("UUID_TIPO_DOCUMENTO")
    private String uuidTypeDocument;
    @ColumnInfo(name = "UUIDUser")
    @SerializedName("UUID_USUARIO")
    private String uuidUser;

    public KardexEntity() {
        id = null;
        typeDocument = null;
        numberDocument = 0;
        date = "";
        user = null;
        status = 1;
        uuid = "";
        uuidTypeDocument = "";
        uuidUser = "";
    }

    public static KardexEntity instance = new KardexEntity();

    public final void clear() {
        id = -1;
        typeDocument = null;
        numberDocument = 0;
        date = "";
        user = null;
        status = 1;
        uuid = "";
        uuidTypeDocument = "";
        uuidUser = "";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(Integer typeDocument) {
        this.typeDocument = typeDocument;
    }

    public Integer getNumberDocument() {
        return numberDocument;
    }

    public void setNumberDocument(Integer numberDocument) {
        this.numberDocument = numberDocument;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static KardexEntity getInstance() {
        return instance;
    }

    public static void setInstance(KardexEntity instance) {
        KardexEntity.instance = instance;
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

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public String getUuidTypeDocument() {
        return uuidTypeDocument;
    }

    public void setUuidTypeDocument(String uuidTypeDocument) {
        this.uuidTypeDocument = uuidTypeDocument;
    }

    public String getUuidUser() {
        return uuidUser;
    }

    public void setUuidUser(String uuidUser) {
        this.uuidUser = uuidUser;
    }
}
