package com.example.administrador.pvsegalmex.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Usuario")
public class UserEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")//*
    private Integer id;
    @ColumnInfo(name = "IdWs")//*
    private Integer idws;
    @ColumnInfo(name = "Nombre")//*
    private String name;
    @ColumnInfo(name = "TipoUsuario")
    private Integer typeUser;
    @ColumnInfo(name = "Compania")
    private Integer company;
    @ColumnInfo(name = "Usuario")
    private Integer user;
    @ColumnInfo(name = "Password")//*
    private String password;
    @ColumnInfo(name = "Email")//*
    private String email;
    @ColumnInfo(name = "ClaveAcceso")//*
    private String accessKey;
    @ColumnInfo(name = "UsuarioPV")//*
    private int userPV;
    @ColumnInfo(name = "Estatus")
    private int status;
    @ColumnInfo(name = "UUID")
    private String uuid;


    public UserEntity() {
        id = null;
        idws = null;
        name = "";
        email = "";
        password = "";
        accessKey = "";
        status = 1;
        userPV = 0;
        typeUser = null;
        user = null;
        company = null;
        uuid = "";
    }

    public static UserEntity instance = new UserEntity();

    public final void clear() {
        id = -1;
        idws = null;
        name = "";
        email = "";
        password = "";
        accessKey = "";
        status = 1;
        userPV = 0;
        typeUser = null;
        user = null;
        company = null;
        uuid = "";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdws() {
        return idws;
    }

    public void setIdws(Integer idws) {
        this.idws = idws;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(Integer typeUser) {
        this.typeUser = typeUser;
    }

    public Integer getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public int getUserPV() {
        return userPV;
    }

    public void setUserPV(int userPV) {
        this.userPV = userPV;
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
}
