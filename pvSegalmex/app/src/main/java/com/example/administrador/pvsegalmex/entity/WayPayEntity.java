package com.example.administrador.pvsegalmex.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "FormaPago")
public class WayPayEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    Integer id;
    @ColumnInfo(name = "Description")
    String description;
    @ColumnInfo(name = "Image")
    String image;
    @ColumnInfo(name = "Estus")
    int status;
    @ColumnInfo(name = "UltimaActualizacion")
    private String lastDateSync;
    @ColumnInfo(name = "UUID")
    private String uuid;

    public WayPayEntity() {
        id = null;
        description = "";
        status = 1;
        lastDateSync = "";
        uuid = "";
    }

    public static WayPayEntity instance = new WayPayEntity();

    public final void clear() {
        id = -1;
        description = "";
        status = 1;
        lastDateSync = "";
        uuid = "";
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
}


