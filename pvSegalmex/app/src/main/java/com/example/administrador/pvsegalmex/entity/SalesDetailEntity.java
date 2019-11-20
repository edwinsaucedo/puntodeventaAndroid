package com.example.administrador.pvsegalmex.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "VentaDetalle",
        foreignKeys = {@ForeignKey(
                entity = SalesEntity.class,
                childColumns = {"Venta"},
                parentColumns = {"Id"}
        ),
                @ForeignKey(entity = ProductEntity.class,
                        childColumns = {"Producto"},
                        parentColumns = {"Id"})})
public class SalesDetailEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private Integer id;
    @ColumnInfo(name = "Venta")
    @SerializedName("VENTA")
    private Integer sale;
    @ColumnInfo(name = "Producto")
    @SerializedName("PRODUCTO")
    private Integer product;
    @ColumnInfo(name = "Cantidad")
    @SerializedName("CANTIDAD")
    private Double quantity;
    @ColumnInfo(name = "PrecioUnitario")
    @SerializedName("PRECIO_UNITARIO")
    private Double unitPrice;
    @ColumnInfo(name = "DescuentoPorcentaje")
    @SerializedName("DESCUENTO_PORCENTAJE")
    private Double percentageDiscount;
    @ColumnInfo(name = "DescuentoMontoUnitario")
    @SerializedName("DESCUENTO_MONTO_UNITARIO")
    private Double unitAmountDiscount;
    @ColumnInfo(name = "Subtotal")
    @SerializedName("SUBTOTAL")
    private Double subtotal;
    @ColumnInfo(name = "Impuestos")
    @SerializedName("IMPUESTOS")
    private Double taxes;
    @ColumnInfo(name = "Total")
    @SerializedName("TOTAL")
    private Double total;
    @ColumnInfo(name = "Estatus")
    private Integer status;
    @ColumnInfo(name = "Fecha")
    @SerializedName("FECHA")
    private String date;
    @ColumnInfo(name = "UUID")
    @SerializedName("UUID")
    private String uuid;
    @ColumnInfo(name = "UUIDSale")
    @SerializedName("UUID_SALE")
    private String uuidSale;
    @ColumnInfo(name = "UUIDProducto")
    @SerializedName("UUID_PRODUCTO")
    private String uuidProduct;
    @ColumnInfo(name = "Porcentaje_Utilidad")
    private Double percentage;
    @ColumnInfo(name = "Monto_Utilidad")
    private Double utilityAmount;
    @ColumnInfo(name = "Costo_Producto")
    private Double productCost;
    @ColumnInfo(name = "Monto_Unitario_Utilidad")
    private Double utilityUnitAmount;


    public SalesDetailEntity() {
        id = null;
        sale = null;
        product = null;
        quantity = 0.0;
        unitPrice = 0.0;
        percentageDiscount = 0.0;
        unitAmountDiscount = 0.0;
        subtotal = 0.0;
        taxes = 0.0;
        total = 0.0;
        status = 1;
        date = "";
        uuid = "";
        uuidSale = "";
        uuidProduct = "";
        percentage = 0.0;
        utilityAmount = 0.0;
        productCost = 0.0;
        utilityUnitAmount = 0.0;
    }

    public static SalesDetailEntity instance = new SalesDetailEntity();

    public final void clear() {
        id = -1;
        sale = -1;
        product = -1;
        quantity = 0.0;
        unitPrice = 0.0;
        percentageDiscount = 0.0;
        unitAmountDiscount = 0.0;
        subtotal = 0.0;
        taxes = 0.0;
        total = 0.0;
        status = 1;
        date = "";
        uuid = "";
        uuidSale = "";
        uuidProduct = "";
        percentage = 0.0;
        utilityAmount = 0.0;
        productCost = 0.0;
        utilityUnitAmount = 0.0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getPercentageDiscount() {
        return percentageDiscount;
    }

    public void setPercentageDiscount(Double percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
    }

    public Double getUnitAmountDiscount() {
        return unitAmountDiscount;
    }

    public void setUnitAmountDiscount(Double unitAmountDiscount) {
        this.unitAmountDiscount = unitAmountDiscount;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTaxes() {
        return taxes;
    }

    public void setTaxes(Double taxes) {
        this.taxes = taxes;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuidSale() {
        return uuidSale;
    }

    public void setUuidSale(String uuidSale) {
        this.uuidSale = uuidSale;
    }

    public String getUuidProduct() {
        return uuidProduct;
    }

    public void setUuidProduct(String uuidProduct) {
        this.uuidProduct = uuidProduct;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public static SalesDetailEntity getInstance() {
        return instance;
    }

    public static void setInstance(SalesDetailEntity instance) {
        SalesDetailEntity.instance = instance;
    }

    public Double getUtilityAmount() {
        return utilityAmount;
    }

    public void setUtilityAmount(Double utilityAmount) {
        this.utilityAmount = utilityAmount;
    }

    public Double getProductCost() {
        return productCost;
    }

    public void setProductCost(Double productCost) {
        this.productCost = productCost;
    }

    public Double getUtilityUnitAmount() {
        return utilityUnitAmount;
    }

    public void setUtilityUnitAmount(Double utilityUnitAmount) {
        this.utilityUnitAmount = utilityUnitAmount;
    }
}
