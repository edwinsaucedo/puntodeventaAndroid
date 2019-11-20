package com.example.administrador.pvsegalmex.view;

public class
DetailReceiptMerchandise {
    private String nameProduct;
    private String quantity;
    private String price;
    private String subtotal;
    private String idProduct;
    private String idUnitMeasurement;
    private String descrioptionUnitMeasurement;
    private String uuidProduct;

    public DetailReceiptMerchandise(String nameProduct, String quantity, String price, String subtotal, String idProduct, String idUnitMeasurement, String descrioptionUnitMeasurement, String uuidProduct) {
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.price = price;
        this.subtotal = subtotal;
        this.idProduct = idProduct;
        this.idUnitMeasurement = idUnitMeasurement;
        this.descrioptionUnitMeasurement = descrioptionUnitMeasurement;
        this.uuidProduct = uuidProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getIdUnitMeasurement() {
        return idUnitMeasurement;
    }

    public void setIdUnitMeasurement(String idUnitMeasurement) {
        this.idUnitMeasurement = idUnitMeasurement;
    }

    public String getDescrioptionUnitMeasurement() {
        return descrioptionUnitMeasurement;
    }

    public void setDescrioptionUnitMeasurement(String descrioptionUnitMeasurement) {
        this.descrioptionUnitMeasurement = descrioptionUnitMeasurement;
    }

    public String getUuidProduct() {
        return uuidProduct;
    }

    public void setUuidProduct(String uuidProduct) {
        this.uuidProduct = uuidProduct;
    }
}
