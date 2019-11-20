package com.example.administrador.pvsegalmex.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "Existencia",
        foreignKeys = {@ForeignKey(
                entity = ProductEntity.class,
                childColumns = {"Producto"},
                parentColumns = {"Id"})
        })
public class ExistEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private Integer id;
    @ColumnInfo(name = "Producto")
    @SerializedName("PRODUCTO")
    private Integer product;
    @ColumnInfo(name = "Disponible")
    @SerializedName("DISPONIBLE")
    private Double enable;
    @ColumnInfo(name = "Transito")
    @SerializedName("TRANSITO")
    private Double traffic;
    @ColumnInfo(name = "Existencia")
    @SerializedName("EXISTENCIA")
    private Double exist;
    @ColumnInfo(name = "Comprometida")
    @SerializedName("COMPROMETIDA")
    private Double committed;
    @ColumnInfo(name = "Sicroniza")
    @SerializedName("SINCRONIZA")
    private Boolean synced;
    @ColumnInfo(name = "FechaActualizacion")
    @SerializedName("FECHA_ACTUALIZACION")
    private String lastDate;
    @ColumnInfo(name = "UUID")
    @SerializedName("UUID")
    private String uuid;
    @ColumnInfo(name = "Estatus")
    private int status;
    @ColumnInfo(name = "Fecha")
    @SerializedName("FECHA")
    private String date;
    @ColumnInfo(name = "UUIDProducto")
    @SerializedName("UUID_PRODUCTO")
    private String uuidProduct;


    public ExistEntity() {
        id = null;
        product = null;
        enable = 0.0;
        traffic = 0.0;
        exist = 0.0;
        committed = 0.0;
        synced = false;
        lastDate = "";
        uuid = "";
        status = 1;
        date = "";
        uuidProduct = "";
    }

    public static ExistEntity instance = new ExistEntity();

    public final void clear(){
        id = -1;
        product = null;
        enable = 0.0;
        traffic = 0.0;
        exist = 0.0;
        committed = 0.0;
        synced = false;
        lastDate = "";
        uuid = "";
        status = 1;
        date = "";
        uuidProduct = "";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }

    public Double getEnable() {
        return enable;
    }

    public void setEnable(Double enable) {
        this.enable = enable;
    }

    public Double getTraffic() {
        return traffic;
    }

    public void setTraffic(Double traffic) {
        this.traffic = traffic;
    }

    public Double getExist() {
        return exist;
    }

    public void setExist(Double exist) {
        this.exist = exist;
    }

    public Double getCommitted() {
        return committed;
    }

    public void setCommitted(Double committed) {
        this.committed = committed;
    }

    public Boolean getSynced() {
        return synced;
    }

    public void setSynced(Boolean synced) {
        this.synced = synced;
    }

    public String getLastDate() {
        return lastDate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuidProduct() {
        return uuidProduct;
    }

    public void setUuidProduct(String uuidProduct) {
        this.uuidProduct = uuidProduct;
    }

    public static ExistEntity getInstance() {
        return instance;
    }

    public static void setInstance(ExistEntity instance) {
        ExistEntity.instance = instance;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
