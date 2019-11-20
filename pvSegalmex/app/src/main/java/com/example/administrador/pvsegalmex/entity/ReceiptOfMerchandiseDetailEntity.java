package com.example.administrador.pvsegalmex.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "ReciboMercanciaDetalle",
        foreignKeys = {@ForeignKey(
                entity = ReceiptOfMerchandiseEntity.class,
                childColumns = {"ReciboMercancia"},
                parentColumns = {"Id"}),
                @ForeignKey(
                        entity = ProductEntity.class,
                        childColumns = {"Producto"},
                        parentColumns = {"Id"}),
                @ForeignKey(
                        entity = UnitMeasurementEntity.class,
                        childColumns = {"UnidadMedida"},
                        parentColumns = {"Id"})
        })
public class ReceiptOfMerchandiseDetailEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private Integer id;
    @ColumnInfo(name = "ReciboMercancia")
    @SerializedName("RECIBO_MERCANCIA")
    private Integer receiptOfMerchandise;
    @ColumnInfo(name = "UnidadMedida")
    @SerializedName("UNIDAD_MEDIDA")
    private Integer unitMeasure;
    @ColumnInfo(name = "Producto")
    @SerializedName("PRODUCTO")
    private Integer product;
    @ColumnInfo(name = "Partida")
    @SerializedName("PARTIDA")
    private int departure;
    @ColumnInfo(name = "Cantidad")
    @SerializedName("CANTIDAD")
    private Double quantity;
    @ColumnInfo(name = "Precio")
    @SerializedName("PRECIO")
    private Double price;
    @ColumnInfo(name = "Subtotal")
    @SerializedName("SUBTOTAL")
    private Double subtotal;
    @ColumnInfo(name = "Total")
    @SerializedName("TOTAL")
    private Double total;
    @ColumnInfo(name = "Factor")
    @SerializedName("FACTOR")
    private Double factor;
    @ColumnInfo(name = "Estatus")
    private int status;
    @ColumnInfo(name = "UUID")
    @SerializedName("UUID")
    private String uuid;
    @ColumnInfo(name = "Fecha")
    @SerializedName("FECHA")
    private String date;
    @ColumnInfo(name = "UUIDReciboMercancia")
    @SerializedName("UUID_RECIBO_MERCANCIA")
    private String uuidReceiptOfMerchandise;
    @ColumnInfo(name = "UUIDProduct")
    @SerializedName("UUID_PRODUCTO")
    private String uuidProduct;


    public ReceiptOfMerchandiseDetailEntity() {
        id = null;
        receiptOfMerchandise = null;
        product = null;
        unitMeasure = null;
        departure = 0;
        quantity = 0.0;
        price = 0.0;
        subtotal = 0.0;
        total = 0.0;
        factor = 0.0;
        status = 1;
        uuid = "";
        date = "";
        uuidReceiptOfMerchandise = "";
        uuidProduct = "";
    }

    public static ReceiptOfMerchandiseDetailEntity instance = new ReceiptOfMerchandiseDetailEntity();

    public final void clear() {
        id = -1;
        receiptOfMerchandise = null;
        product = null;
        unitMeasure = null;
        departure = 0;
        quantity = 0.0;
        price = 0.0;
        subtotal = 0.0;
        total = 0.0;
        factor = 0.0;
        status = 1;
        uuid = "";
        date = "";
        uuidReceiptOfMerchandise = "";
        uuidProduct = "";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReceiptOfMerchandise() {
        return receiptOfMerchandise;
    }

    public void setReceiptOfMerchandise(Integer receiptOfMerchandise) {
        this.receiptOfMerchandise = receiptOfMerchandise;
    }

    public Integer getUnitMeasure() {
        return unitMeasure;
    }

    public void setUnitMeasure(Integer unitMeasure) {
        this.unitMeasure = unitMeasure;
    }

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }

    public int getDeparture() {
        return departure;
    }

    public void setDeparture(int departure) {
        this.departure = departure;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getFactor() {
        return factor;
    }

    public void setFactor(Double factor) {
        this.factor = factor;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUuidReceiptOfMerchandise() {
        return uuidReceiptOfMerchandise;
    }

    public void setUuidReceiptOfMerchandise(String uuidReceiptOfMerchandise) {
        this.uuidReceiptOfMerchandise = uuidReceiptOfMerchandise;
    }

    public static ReceiptOfMerchandiseDetailEntity getInstance() {
        return instance;
    }

    public static void setInstance(ReceiptOfMerchandiseDetailEntity instance) {
        ReceiptOfMerchandiseDetailEntity.instance = instance;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getUuidProduct() {
        return uuidProduct;
    }

    public void setUuidProduct(String uuidProduct) {
        this.uuidProduct = uuidProduct;
    }
}
