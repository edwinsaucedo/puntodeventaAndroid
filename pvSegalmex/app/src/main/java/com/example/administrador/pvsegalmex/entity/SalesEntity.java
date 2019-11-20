package com.example.administrador.pvsegalmex.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "Venta",
        foreignKeys = {@ForeignKey(
                entity = ClienteEntity.class,
                childColumns = {"Cliente"},
                parentColumns = {"Id"}),
                @ForeignKey(
                        entity = WayPayEntity.class,
                        childColumns = {"FormaPago"},
                        parentColumns = {"Id"}),
                @ForeignKey(
                        entity = TypeDocumentsEntity.class,
                        childColumns = {"TipoDocumentoVta"},
                        parentColumns = {"Id"}),
                @ForeignKey(
                        entity = CashShortEntity.class,
                        childColumns = {"CorteCaja"},
                        parentColumns = {"Id"})
        }
)
public class SalesEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    @SerializedName("ID")
    private Integer id;
    @ColumnInfo(name = "Fecha")
    @SerializedName("FECHA")
    private String date;
    @Ignore
    private Double sumaTotal;
    @ColumnInfo(name = "NoArticles")
    @SerializedName("NUMERO_ARTICULOS")
    private int noAticles;
    @ColumnInfo(name = "Total")
    @SerializedName("TOTAL")
    private Double total;
    @ColumnInfo(name = "Estatus")
    @SerializedName("ESTATUS")
    private int status;
    @ColumnInfo(name = "FormaPago")
    @SerializedName("FORMA_PAGO")
    private Integer wayPay;
    @ColumnInfo(name = "TipoDocumentoVta")
    @SerializedName("TIPO_DOCUMENTO")
    private Integer typeDocumentVta;
    @ColumnInfo(name = "Cliente")
    @SerializedName("CLIENTE")
    private Integer client;
    @ColumnInfo(name = "EstatusVenta")
    @SerializedName("ESTATUS_VENTA")
    private String salesStatus;
    @ColumnInfo(name = "CorteCaja")
    @SerializedName("CORTE_CAJA")
    private Integer cashShort;
    @ColumnInfo(name = "DocumentFolio")
    @SerializedName("DCUMENTO_FOLIO")
    private int documentFolio;
    @ColumnInfo(name = "UUID")
    @SerializedName("UUID")
    private String uuid;
    @ColumnInfo(name = "UUIDCorteCaja")
    @SerializedName("UUID_CORTE_CAJA")
    private String uuidCashShort;
    @ColumnInfo(name = "UUIDTipoDocumento")
    @SerializedName("UUID_TIPO_DOCUMENTO")
    private String uuidTypeDocument;
    @ColumnInfo(name = "UUIDCliente")
    @SerializedName("UUID_CLIENTE")
    private String uuidClient;
    @ColumnInfo(name = "UUIDWayPay")
    @SerializedName("UUID_FORMA_PAGO")
    private String uuidWayPay;
    @ColumnInfo(name = "Monto_Utilidad")
    private Double utilityAmount;
    @ColumnInfo(name = "Porcentaje_Utilidad")
    private Double utilityPercentage;

    //No se han establecido impuestos o descuentos
  /*  @ColumnInfo(name = "Descuento")
    Double desc;
    @ColumnInfo(name = "ImpuestoTraslado")
    Double taxTraslated;
    @ColumnInfo(name = "ImpuestoRetenido")
    Double taxDetained;
        @ColumnInfo(name = "Sincroniza")
    Boolean synchronize;*/
     /*@ColumnInfo(name = "Subtotal")
    Double subtotal;*/

    public SalesEntity() {
        id = null;
        date = "";
        noAticles = 0;
        salesStatus = "";
        total = 0.0;
        status = 1;
        client = null;
        wayPay = null;
        sumaTotal = 0.0;
        typeDocumentVta = null;
        cashShort = null;
        documentFolio = 0;
        uuid = "";
        uuidCashShort = "";
        uuidClient = "";
        uuidTypeDocument = "";
        uuidWayPay = "";
        utilityAmount = 0.0;
        utilityPercentage = 0.0;
    }

    public static SalesEntity instance = new SalesEntity();

    public final void clear() {
        id = -1;
        date = "";
        noAticles = 0;
        salesStatus = "";
        total = 0.0;
        status = 1;
        client = null;
        wayPay = null;
        sumaTotal = 0.0;
        typeDocumentVta = null;
        cashShort = null;
        documentFolio = 0;
        uuid = "";
        uuidCashShort = "";
        uuidClient = "";
        uuidTypeDocument = "";
        uuidWayPay = "";
        utilityAmount = 0.0;
        utilityPercentage = 0.0;
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

    public Double getSumaTotal() {
        return sumaTotal;
    }

    public void setSumaTotal(Double sumaTotal) {
        this.sumaTotal = sumaTotal;
    }

    public int getNoAticles() {
        return noAticles;
    }

    public void setNoAticles(int noAticles) {
        this.noAticles = noAticles;
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

    public Integer getWayPay() {
        return wayPay;
    }

    public void setWayPay(Integer wayPay) {
        this.wayPay = wayPay;
    }

    public Integer getTypeDocumentVta() {
        return typeDocumentVta;
    }

    public void setTypeDocumentVta(Integer typeDocumentVta) {
        this.typeDocumentVta = typeDocumentVta;
    }

    public Integer getCashShort() {
        return cashShort;
    }

    public void setCashShort(Integer cashShort) {
        this.cashShort = cashShort;
    }

    public int getDocumentFolio() {
        return documentFolio;
    }

    public void setDocumentFolio(int documentFolio) {
        this.documentFolio = documentFolio;
    }

    public Integer getClient() {
        return client;
    }

    public void setClient(Integer client) {
        this.client = client;
    }

    public String getSalesStatus() {
        return salesStatus;
    }

    public void setSalesStatus(String salesStatus) {
        this.salesStatus = salesStatus;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuidCashShort() {
        return uuidCashShort;
    }

    public void setUuidCashShort(String uuidCashShort) {
        this.uuidCashShort = uuidCashShort;
    }

    public String getUuidTypeDocument() {
        return uuidTypeDocument;
    }

    public void setUuidTypeDocument(String uuidTypeDocument) {
        this.uuidTypeDocument = uuidTypeDocument;
    }

    public String getUuidClient() {
        return uuidClient;
    }

    public void setUuidClient(String uuidClient) {
        this.uuidClient = uuidClient;
    }

    public String getUuidWayPay() {
        return uuidWayPay;
    }

    public void setUuidWayPay(String uuidWayPay) {
        this.uuidWayPay = uuidWayPay;
    }

    public Double getUtilityAmount() {
        return utilityAmount;
    }

    public void setUtilityAmount(Double utilityAmount) {
        this.utilityAmount = utilityAmount;
    }

    public Double getUtilityPercentage() {
        return utilityPercentage;
    }

    public void setUtilityPercentage(Double utilityPercentage) {
        this.utilityPercentage = utilityPercentage;
    }

    public static SalesEntity getInstance() {
        return instance;
    }

    public static void setInstance(SalesEntity instance) {
        SalesEntity.instance = instance;
    }
}
