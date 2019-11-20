package com.example.administrador.pvsegalmex.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "ReciboMercancia",
        foreignKeys = {@ForeignKey(
                entity = ProviderEntity.class,
                childColumns = {"Proveedor"},
                parentColumns = {"Id"})}
)
public class ReceiptOfMerchandiseEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private Integer id;
    @ColumnInfo(name = "Diconsa")
    @SerializedName("DICONSA")
    private boolean diconsa;
    @ColumnInfo(name = "Fecha")
    @SerializedName("FECHA")
    private String date;
    @ColumnInfo(name = "Consecutivo")
    @SerializedName("CONSECUTIVO")
    private int consecutive;
    @ColumnInfo(name = "Articulos")
    @SerializedName("ARTICULOS")
    private int articles;
    @ColumnInfo(name = "Subtotal")
    @SerializedName("SUBTOTAL")
    private Double subtotal;
    @ColumnInfo(name = "Total")
    @SerializedName("TOTAL")
    private Double total;
    @ColumnInfo(name = "Folio")
    @SerializedName("FOLIO")
    private String folio;//numero del documento del proveedor, se captura
    @ColumnInfo(name = "Comentario")
    @SerializedName("COMENTARIO")
    private String comment;
    @ColumnInfo(name = "Proveedor")
    @SerializedName("PROVEEDOR")
    private Integer provider;
    @ColumnInfo(name = "Estatus")
    private int status;
    @ColumnInfo(name = "UUID")
    @SerializedName("UUID")
    private String uuid;
    @ColumnInfo(name = "UUIDProveedor")
    @SerializedName("UUID_PROVEEDOR")
    private String uuidProvider;

    public ReceiptOfMerchandiseEntity() {
        id = null;
        diconsa = false;
        date = "";
        articles = 0;
        subtotal = 0.0;
        total = 0.0;
        comment = "";
        provider = null;
        status = 1;
        uuid = "";
        consecutive = 0;
        uuidProvider = "";
        folio = "";
    }

    public static ReceiptOfMerchandiseEntity instance = new ReceiptOfMerchandiseEntity();

    public final void clear() {
        id = -1;
        diconsa = false;
        date = "";
        articles = 0;
        subtotal = 0.0;
        total = 0.0;
        comment = "";
        provider = null;
        status = 1;
        uuid = "";
        consecutive = 0;
        uuidProvider = "";
        folio = "";
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getProvider() {
        return provider;
    }

    public void setProvider(Integer provider) {
        this.provider = provider;
    }

    public boolean isDiconsa() {
        return diconsa;
    }

    public void setDiconsa(boolean diconsa) {
        this.diconsa = diconsa;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getConsecutive() {
        return consecutive;
    }

    public void setConsecutive(int consecutive) {
        this.consecutive = consecutive;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getUuidProvider() {
        return uuidProvider;
    }

    public void setUuidProvider(String uuidProvider) {
        this.uuidProvider = uuidProvider;
    }

    public static ReceiptOfMerchandiseEntity getInstance() {
        return instance;
    }

    public static void setInstance(ReceiptOfMerchandiseEntity instance) {
        ReceiptOfMerchandiseEntity.instance = instance;
    }

    public int getArticles() {
        return articles;
    }

    public void setArticles(int articles) {
        this.articles = articles;
    }
}
