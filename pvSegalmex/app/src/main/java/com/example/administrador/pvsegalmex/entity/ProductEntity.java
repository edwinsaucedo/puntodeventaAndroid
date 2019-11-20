package com.example.administrador.pvsegalmex.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import io.reactivex.annotations.NonNull;

@Entity(
        tableName = "Productos",
        foreignKeys = {@ForeignKey(
                entity = CategoryEntity.class,
                childColumns = {"Categoria"},
                parentColumns = {"Id"}
        )}
)

public class
ProductEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private Integer id;
    @ColumnInfo(name = "Codigo")
    private String code;
    @ColumnInfo(name = "CodigoAlterno")
    private String alternateCode;
    @ColumnInfo(name = "Descripcion")//
    private String description;
    @ColumnInfo(name = "Maximo")
    private double maximum;
    @ColumnInfo(name = "Minimo")
    private double minimum;
    @ColumnInfo(name = "PuntoDeReorden")
    private double reorderPoint;
    @ColumnInfo(name = "UnidadMedida")//
    private int unitMeasure;
    @ColumnInfo(name = "UnidadMedidaCompra")
    private int unitMeasurePurchase;
    @ColumnInfo(name = "Factor")
    private double factor;
    @ColumnInfo(name = "Servicio")
    private int service;
    @ColumnInfo(name = "Diconsa")
    private int diconsa;
    @ColumnInfo(name = "Categoria")
    private Integer category;
    @ColumnInfo(name = "Granel")
    private int granel;
    @ColumnInfo(name = "Estatus")
    private int status;
    @ColumnInfo(name = "RowId")
    private String rowId;
    @ColumnInfo(name = "Costo")
    private double cost;
    @ColumnInfo(name = "CostoUC")
    private double costUC;
    @ColumnInfo(name = "FechaUC")
    private String dateUC;
    @ColumnInfo(name = "Imagen")
    private String image;
    @ColumnInfo(name = "UltimaActualizacion")
    private String lastDateSync;
    @ColumnInfo(name = "UUID")
    private String uuid;


    public ProductEntity() {
        id = null;//
        code = "";//
        alternateCode = "";//
        description = "";//
        maximum = 0.0;//
        minimum = 0.0;//
        reorderPoint = 0.0;//
        unitMeasure = 0;//
        unitMeasurePurchase = 0;//
        factor = 0.0;//
        service = 0;//
        diconsa = 0;//
        granel = 0;//
        rowId = "";//
        cost = 0.0;//
        costUC = 0.0;//
        dateUC = "";//
        status = 1;//
        category = null;//
        image = "";
        uuid = "";
        lastDateSync = "";
    }

    public static ProductEntity instance = new ProductEntity();

    public final void clear() {
        id = -1;
        code = "";
        alternateCode = "";
        description = "";
        maximum = 0.0;
        minimum = 0.0;
        reorderPoint = 0.0;
        unitMeasure = 0;
        unitMeasurePurchase = 0;
        factor = 0.0;
        service = 0;
        diconsa = 0;
        granel = 0;
        rowId = "";
        cost = 0.0;
        costUC = 0.0;
        dateUC = "";
        status = 1;
        category = -1;
        image = "";
        uuid = "";
        lastDateSync = "";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAlternateCode() {
        return alternateCode;
    }

    public void setAlternateCode(String alternateCode) {
        this.alternateCode = alternateCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMaximum() {
        return maximum;
    }

    public void setMaximum(double maximum) {
        this.maximum = maximum;
    }

    public double getMinimum() {
        return minimum;
    }

    public void setMinimum(double minimum) {
        this.minimum = minimum;
    }

    public double getReorderPoint() {
        return reorderPoint;
    }

    public void setReorderPoint(double reorderPoint) {
        this.reorderPoint = reorderPoint;
    }

    public int getUnitMeasure() {
        return unitMeasure;
    }

    public void setUnitMeasure(int unitMeasure) {
        this.unitMeasure = unitMeasure;
    }

    public int getUnitMeasurePurchase() {
        return unitMeasurePurchase;
    }

    public void setUnitMeasurePurchase(int unitMeasurePurchase) {
        this.unitMeasurePurchase = unitMeasurePurchase;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getFactor() {
        return factor;
    }

    public void setFactor(double factor) {
        this.factor = factor;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }

    public int getDiconsa() {
        return diconsa;
    }

    public void setDiconsa(int diconsa) {
        this.diconsa = diconsa;
    }

    public int getGranel() {
        return granel;
    }

    public void setGranel(int granel) {
        this.granel = granel;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCostUC() {
        return costUC;
    }

    public void setCostUC(double costUC) {
        this.costUC = costUC;
    }

    public String getDateUC() {
        return dateUC;
    }

    public void setDateUC(String dateUC) {
        this.dateUC = dateUC;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public static ProductEntity getInstance() {
        return instance;
    }

    public static void setInstance(ProductEntity instance) {
        ProductEntity.instance = instance;
    }

    public String getLastDateSync() {
        return lastDateSync;
    }

    public void setLastDateSync(String lastDateSync) {
        this.lastDateSync = lastDateSync;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    @NonNull
    public String toString() {
        return description;
    }
}