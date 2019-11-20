package com.example.administrador.pvsegalmex.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import io.reactivex.annotations.NonNull;

@Entity(tableName = "Cliente")
public class ClienteEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private Integer id;
    @ColumnInfo(name = "Nombre")
    @SerializedName("NOMBRE")
    private String name;
    @ColumnInfo(name = "ApellidoPaterno")
    @SerializedName("APELLIDO_PATERNO")
    private String lastName1;
    @ColumnInfo(name = "ApellidoMaterno")
    @SerializedName("APELLIDO_MATERNO")
    private String lastName2;
    @ColumnInfo(name = "LimiteCredito")
    @SerializedName("LIMITE_CREDITO")
    private double creditLimit;
    @ColumnInfo(name = "DiasCredito")
    @SerializedName("DIAS_CREDITO")
    private int creditDays;
    @ColumnInfo(name = "Genero")
    @SerializedName("GENERO")
    private char genre;
    @ColumnInfo(name = "Direccion")
    @SerializedName("DIRECCION")
    private String address;
    @ColumnInfo(name = "Curp")
    @SerializedName("CURP")
    private String curp;
    @ColumnInfo(name = "CadenaINE")
    @SerializedName("CADENA_INE")
    private String ineString;
    @ColumnInfo(name = "FotoCliente")
    @SerializedName("FOTO_CLIENTE")
    private String photoClient;
    @ColumnInfo(name = "Estatus")
    @SerializedName("ESTATUS")
    private int status;
    @ColumnInfo(name = "FotoINE")
    @SerializedName("FOTO_INE")
    private String photoIne;
    @ColumnInfo(name = "Email")
    @SerializedName("EMAIL")
    private String mail;
    @ColumnInfo(name = "Telefono")
    @SerializedName("TELEFONO")
    private String phone;
    @ColumnInfo(name = "FechaUltimaVenta")
    @SerializedName("FECHA_ULTIMA_VENTA")
    private String lastSellDate;
    @ColumnInfo(name = "UUID")
    @SerializedName("UUID")
    private String uuid;
    @ColumnInfo(name = "UltimaActualizacion")
    @SerializedName("ULTIMA_ACTUALIZACION")
    private String lastDateSync;
    @ColumnInfo(name = "Compania")
    @SerializedName("COMPANIA")
    private Integer company;
    @ColumnInfo(name = "Fecha")
    @SerializedName("FECHA")
    private String date;

    public ClienteEntity() {
        id = null;
        name = "";
        lastName1 = "";
        lastName2 = "";
        creditLimit = 0.0;
        creditDays = 0;
        genre = ' ';
        address = "";
        curp = "";
        ineString = "";
        photoClient = "";
        status = 1;
        photoIne = "";
        mail = "";
        phone = "";
        lastSellDate = "";
        uuid = "";
        lastDateSync = "";
        company = null;
        date = "";
    }

    public static ClienteEntity instance = new ClienteEntity();

    public final void clear() {
        id = -1;
        name = "";
        lastName1 = "";
        lastName2 = "";
        creditLimit = 0.0;
        creditDays = 0;
        genre = ' ';
        address = "";
        curp = "";
        ineString = "";
        photoClient = "";
        status = 1;
        photoIne = "";
        mail = "";
        phone = "";
        lastSellDate = "";
        uuid = "";
        lastDateSync = "";
        company = null;
        date = "";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName1() {
        return lastName1;
    }

    public void setLastName1(String lastName1) {
        this.lastName1 = lastName1;
    }

    public String getLastName2() {
        return lastName2;
    }

    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public int getCreditDays() {
        return creditDays;
    }

    public void setCreditDays(int creditDays) {
        this.creditDays = creditDays;
    }

    public char getGenre() {
        return genre;
    }

    public void setGenre(char genre) {
        this.genre = genre;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getIneString() {
        return ineString;
    }

    public void setIneString(String ineString) {
        this.ineString = ineString;
    }

    public String getPhotoClient() {
        return photoClient;
    }

    public void setPhotoClient(String photoClient) {
        this.photoClient = photoClient;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPhotoIne() {
        return photoIne;
    }

    public void setPhotoIne(String photoIne) {
        this.photoIne = photoIne;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLastSellDate() {
        return lastSellDate;
    }

    public void setLastSellDate(String lastSellDate) {
        this.lastSellDate = lastSellDate;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getLastDateSync() {
        return lastDateSync;
    }

    public void setLastDateSync(String lastDateSync) {
        this.lastDateSync = lastDateSync;
    }

    public Integer getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static ClienteEntity getInstance() {
        return instance;
    }

    public static void setInstance(ClienteEntity instance) {
        ClienteEntity.instance = instance;
    }

    @Override
    @NonNull
    public String toString() {
        return name + " " + lastName1 + " " + " " + lastName2;
    }

}
