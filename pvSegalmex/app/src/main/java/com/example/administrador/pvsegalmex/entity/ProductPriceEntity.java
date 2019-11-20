package com.example.administrador.pvsegalmex.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(
        tableName = "ProductoPrecio",
        foreignKeys = {@ForeignKey(
                entity = ProductEntity.class,
                childColumns = {"Producto"},
                parentColumns = {"Id"}
        )}
)
public class ProductPriceEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private Integer id;
    @ColumnInfo(name = "Nivel")
    private Integer level;
    @ColumnInfo(name = "Precio")
    private double price;
    @ColumnInfo(name = "PorcentajeUtilidad")
    private double percentage;
    @ColumnInfo(name = "Costo")
    private double cost;
    @ColumnInfo(name = "Cantidad")
    private double quantity;
    @ColumnInfo(name = "Producto")
    private int product;
    @ColumnInfo(name = "UUID")
    private String uuid;
    @ColumnInfo(name = "UUIDProducto")
    private String uuidProduct;
    @ColumnInfo(name = "Monto_Utilidad")
    private Double utilityAmount;

    public ProductPriceEntity() {
        id = null;
        level = 0;
        price = 0.0;
        percentage = 0.0;
        cost = 0.0;
        quantity = 0.0;
        product = 0;
        uuid = "";
        uuidProduct = "";
        utilityAmount = 0.0;
    }

    public static ProductPriceEntity instance = new ProductPriceEntity();

    public final void clear() {
        id = -1;
        level = 0;
        price = 0.0;
        percentage = 0.0;
        cost = 0.0;
        quantity = 0.0;
        product = 0;
        uuid = "";
        uuidProduct = "";
        utilityAmount = 0.0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
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

    public static ProductPriceEntity getInstance() {
        return instance;
    }

    public static void setInstance(ProductPriceEntity instance) {
        ProductPriceEntity.instance = instance;
    }

    public Double getUtilityAmount() {
        return utilityAmount;
    }

    public void setUtilityAmount(Double utilityAmount) {
        this.utilityAmount = utilityAmount;
    }
}
