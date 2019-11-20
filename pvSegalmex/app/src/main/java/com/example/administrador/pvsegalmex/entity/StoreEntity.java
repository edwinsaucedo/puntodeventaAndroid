package com.example.administrador.pvsegalmex.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Tienda")
public class StoreEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private Integer id;
    @ColumnInfo(name = "NumeroTelefono")
    private String phonenumber;
    @ColumnInfo(name = "NombreTienda")
    private String storeName;
    @ColumnInfo(name = "Longitud")
    private Double longitud;
    @ColumnInfo(name = "Latitud")
    private Double latitud;
    @ColumnInfo(name = "Direccion")
    private String direction;
    @ColumnInfo(name = "Propietario")
    private String owner;
    @ColumnInfo(name = "Imagen")
    private String image;
    @ColumnInfo(name = "Nombre")
    private String name;
    @ColumnInfo(name = "RFC")
    private String rfc;
    @ColumnInfo(name = "Regimen")
    private String regimen;
    @ColumnInfo(name = "Password")
    private String password;
    @ColumnInfo(name = "ArchivoCSD")
    private Boolean fileCsd;
    @ColumnInfo(name = "ArchivoKey")
    private Boolean fileKey;
    @ColumnInfo(name = "Facturar")
    private Boolean facturar;
    @ColumnInfo (name = "DireccionLocal")
    String localDirection;
    @ColumnInfo(name = "Estatus")
    int status;

    public StoreEntity() {
        id = null;
        phonenumber = "";
        longitud = 0.0;
        latitud = 0.0;
        owner = "";
        //  rowld = "";
        storeName = "";
        status = 1;
        direction = "";
        image = "";
        name = "";
        rfc = "";
        regimen = "";
        password = "";
        fileCsd = false;
        fileKey = false;
        facturar = false;
        localDirection = "";
    }

    public static StoreEntity instance = new StoreEntity();

    public final void clear() {
        id = -1;
        phonenumber = "";
        longitud = 0.0;
        latitud = 0.0;
        owner = "";
        //   rowld = "";
        storeName = "";
        direction = "";
        status = 1;
        image = "";
        name = "";
        rfc = "";
        regimen = "";
        password = "";
        fileCsd = false;
        fileKey = false;
        facturar = false;
        localDirection = "";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLocalDirection() {
        return localDirection;
    }

    public void setLocalDirection(String localDirection) {
        this.localDirection = localDirection;
    }

    /* public String getRowld() {
        return rowld;
    }

    public void setRowld(String rowld) {
        this.rowld = rowld;
    }*/

    public static StoreEntity getInstance() {
        return instance;
    }

    public static void setInstance(StoreEntity instance) {
        StoreEntity.instance = instance;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getRegimen() {
        return regimen;
    }

    public void setRegimen(String regimen) {
        this.regimen = regimen;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getFileCsd() {
        return fileCsd;
    }

    public void setFileCsd(Boolean fileCsd) {
        this.fileCsd = fileCsd;
    }

    public Boolean getFileKey() {
        return fileKey;
    }

    public void setFileKey(Boolean fileKey) {
        this.fileKey = fileKey;
    }

    public Boolean getFacturar() {
        return facturar;
    }

    public void setFacturar(Boolean facturar) {
        this.facturar = facturar;
    }
}
