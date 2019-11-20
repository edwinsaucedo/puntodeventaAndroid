package com.example.administrador.pvsegalmex.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Departamentos")
public class DepartmentEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    Integer id;
    @ColumnInfo(name = "Descripcion")
    String description;
    @ColumnInfo(name = "Estatus")
    int status;
    @ColumnInfo(name = "UUID")
    String uuid;
    @ColumnInfo(name = "UltimaActualizacion")
    String lastDateSync;

    public DepartmentEntity() {
        id = null;
        description = "";
        status = 1;
        uuid = "";
        lastDateSync = "01/01/2000";
    }

    public static DepartmentEntity instance = new DepartmentEntity();

    public final void clear() {
        id = -1;
        description = "";
        status = 1;
        uuid = "";
        lastDateSync = "01/01/2000";
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

    public static DepartmentEntity getInstance() {
        return instance;
    }

    public static void setInstance(DepartmentEntity instance) {
        DepartmentEntity.instance = instance;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLastDateSync() {
        return lastDateSync;
    }

    public void setLastDateSync(String lastDateSync) {
        this.lastDateSync = lastDateSync;
    }
}
