package com.example.administrador.pvsegalmex.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(
        tableName = "Categorias",
        foreignKeys = {@ForeignKey(
                entity = DepartmentEntity.class,
                childColumns = {"Departamento"},
                parentColumns = {"Id"}
        )}
)
public class CategoryEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private Integer id;
    @ColumnInfo(name = "Departamento")
    private Integer department;
    @ColumnInfo(name = "Descripcion")
    private String description;
    @ColumnInfo(name = "Estatus")
    private int status;
    @ColumnInfo(name = "UUID")
    private String uuid;
    @ColumnInfo(name = "UltimaActualizacion")
    private String lastDateSync;

    public CategoryEntity() {
        id = null;
        department = null;
        description = "";
        uuid = "";
        lastDateSync = "";
    }

    public static CategoryEntity instance = new CategoryEntity();

    public final void clear() {
        id = -1;
        department = null;
        description = "";
        uuid = "";
        lastDateSync = "01/01/2000";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static CategoryEntity getInstance() {
        return instance;
    }

    public static void setInstance(CategoryEntity instance) {
        CategoryEntity.instance = instance;
    }

    public int getStatus() {
        return status;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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
