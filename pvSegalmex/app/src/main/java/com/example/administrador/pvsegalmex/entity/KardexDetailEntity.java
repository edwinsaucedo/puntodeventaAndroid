package com.example.administrador.pvsegalmex.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "KardexDetalle",
        foreignKeys = {@ForeignKey(
                entity = ProductEntity.class,
                childColumns = {"Producto"},
                parentColumns = {"Id"}),
                @ForeignKey(
                        entity = KardexEntity.class,
                        childColumns = {"Kardex"},
                        parentColumns = {"Id"})/*,
                @ForeignKey(
                        entity = UnitOfMeasurement.class,
                        childColumns = {"UnidadMedida"},
                        parentColumns = {"Id"})*/
        }
)
public class KardexDetailEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private Integer id;
    @ColumnInfo(name = "Producto")
    @SerializedName("PRODUCTO")
    private Integer product;
    @ColumnInfo(name = "UnidadMedida")
    @SerializedName("UNIDAD_MEDIDA")
    private Integer unitOfMeasure;
    @ColumnInfo(name = "Kardex")
    @SerializedName("KARDEX")
    private Integer kardex;
    @ColumnInfo(name = "Cantidad")
    @SerializedName("CANTIDAD")
    private Double quantity;
    @ColumnInfo(name = "Factor")
    @SerializedName("FACTOR")
    private Double factor;
    @ColumnInfo(name = "Costo")
    @SerializedName("COSTO")
    private Double cost;
    @ColumnInfo(name = "Valor")
    @SerializedName("VALOR")
    private Double value;
    @ColumnInfo(name = "Estatus")
    private int status;
    @ColumnInfo(name = "UUID")
    @SerializedName("UUID")
    private String uuid;
    @ColumnInfo(name = "Fecha")
    @SerializedName("FECHA")
    private String date;
    @ColumnInfo(name = "UUIDKardex")
    @SerializedName("UUID_KARDEX")
    private String uuidKardex;
    @ColumnInfo(name = "UUIDProduct")
    @SerializedName("UUID_PRODUCT")
    private String uuidProduct;

    public KardexDetailEntity() {
        id = null;
        product = null;
        unitOfMeasure = null;
        kardex = null;
        quantity = 0.0;
        factor = 0.0;
        cost = 0.0;
        value = 0.0;
        status = 1;
        uuid = "";
        date = "";
        uuidKardex = "";
        uuidProduct = "";
    }

    public static KardexDetailEntity instance = new KardexDetailEntity();

    public final void clear() {
        id = -1;
        product = null;
        unitOfMeasure = null;
        kardex = null;
        quantity = 0.0;
        factor = 0.0;
        cost = 0.0;
        value = 0.0;
        status = 1;
        uuid = "";
        date = "";
        uuidKardex = "";
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

    public Integer getKardex() {
        return kardex;
    }

    public void setKardex(Integer kardex) {
        this.kardex = kardex;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getFactor() {
        return factor;
    }

    public void setFactor(Double factor) {
        this.factor = factor;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(Integer unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUuidKardex() {
        return uuidKardex;
    }

    public void setUuidKardex(String uuidKardex) {
        this.uuidKardex = uuidKardex;
    }

    public String getUuidProduct() {
        return uuidProduct;
    }

    public void setUuidProduct(String uuidProduct) {
        this.uuidProduct = uuidProduct;
    }

    public static KardexDetailEntity getInstance() {
        return instance;
    }

    public static void setInstance(KardexDetailEntity instance) {
        KardexDetailEntity.instance = instance;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
