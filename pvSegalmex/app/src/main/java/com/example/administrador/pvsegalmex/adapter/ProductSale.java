package com.example.administrador.pvsegalmex.adapter;

import android.os.Parcel;
import android.os.Parcelable;

//lista que representa carrito
public class ProductSale implements Parcelable {
    private Integer ProductSaleId;
    private String ProductSaleDescription;
    private Double ProductSaleCost;
    private String ProductSaleCode;
    private Integer ProductQuantity;
    private Double ProductSaleCostQuantity;
    private int ProductSaleGranel;
    private String ProductSaleUnit;
    private String ProductUUID;
    private Double ProductPercentage;
    private Double ProductAmountPercentage;
    private Double ProductCost;
    private Integer ProductIdSaleDetail;
    public ProductSale() {
    }

    public ProductSale(Integer productSaleId, String productSaleDescription, Double productSaleCost, String productSaleCode, Integer productQuantity, Double productSaleCostQuantity, int productSaleGranel, String porductSaleUnit, String productUUID, Double productPercentage, Double productAmountPercentage, Double productCost, Integer productIdSaleDetail) {
        ProductSaleDescription = productSaleDescription;
        ProductSaleCost = productSaleCost;
        ProductSaleCode = productSaleCode;
        ProductQuantity = productQuantity;
        ProductSaleCostQuantity = productSaleCostQuantity;
        ProductSaleId = productSaleId;
        ProductSaleGranel = productSaleGranel;
        ProductSaleUnit = porductSaleUnit;
        ProductUUID = productUUID;
        ProductPercentage = productPercentage;
        ProductAmountPercentage = productAmountPercentage;
        ProductCost = productCost;
        ProductIdSaleDetail = productIdSaleDetail;
    }

    public Integer getProductSaleId() {
        return ProductSaleId;
    }

    public void setProductSaleId(Integer productSaleId) {
        ProductSaleId = productSaleId;
    }

    public String getProductSaleDescription() {
        return ProductSaleDescription;
    }

    public void setProductSaleDescription(String productSaleDescription) {
        ProductSaleDescription = productSaleDescription;
    }

    public Double getProductSaleCost() {
        return ProductSaleCost;
    }

    public void setProductSaleCost(Double productSaleCost) {
        ProductSaleCost = productSaleCost;
    }

    public String getProductSaleCode() {
        return ProductSaleCode;
    }

    public void setProductSaleCode(String productSaleCode) {
        ProductSaleCode = productSaleCode;
    }

    public Integer getProductQuantity() {
        return ProductQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        ProductQuantity = productQuantity;
    }

    public Double getProductSaleCostQuantity() {
        return ProductSaleCostQuantity;
    }

    public void setProductSaleCostQuantity(Double productSaleCostQuantity) {
        ProductSaleCostQuantity = productSaleCostQuantity;
    }

    public int getProductSaleGranel() {
        return ProductSaleGranel;
    }

    public String getProductSaleUnit() {
        return ProductSaleUnit;
    }

    public void setProductSaleUnit(String productSaleUnit) {
        ProductSaleUnit = productSaleUnit;
    }

    public void setProductSaleGranel(int productSaleGranel) {
        ProductSaleGranel = productSaleGranel;
    }

    public String getProductUUID() {
        return ProductUUID;
    }

    public void setProductUUID(String productUUID) {
        ProductUUID = productUUID;
    }

    public Double getProductPercentage() {
        return ProductPercentage;
    }

    public void setProductPercentage(Double productPercentage) {
        ProductPercentage = productPercentage;
    }

    public Double getProductAmountPercentage() {
        return ProductAmountPercentage;
    }

    public void setProductAmountPercentage(Double productAmountPercentage) {
        ProductAmountPercentage = productAmountPercentage;
    }

    public Double getProductCost() {
        return ProductCost;
    }

    public void setProductCost(Double productCost) {
        ProductCost = productCost;
    }

    public Integer getProductIdSaleDetail() {
        return ProductIdSaleDetail;
    }

    public void setProductIdSaleDetail(Integer productIdSaleDetail) {
        ProductIdSaleDetail = productIdSaleDetail;
    }

    public ProductSale(Parcel in) {
        ProductSaleDescription = in.readString();
        ProductSaleCost = in.readDouble();
        ProductSaleCode = in.readString();
        ProductQuantity = in.readInt();
        ProductSaleCostQuantity = in.readDouble();
        ProductSaleId = in.readInt();
        ProductSaleGranel = in.readInt();
        ProductSaleUnit = in.readString();
        ProductUUID = in.readString();
        ProductPercentage = in.readDouble();
        ProductAmountPercentage = in.readDouble();
        ProductCost = in.readDouble();
        ProductIdSaleDetail = in.readInt();
    }

    public static final Parcelable.Creator<ProductSale> CREATOR =
            new Parcelable.Creator<ProductSale>() {
                public ProductSale createFromParcel(Parcel in) {
                    return new ProductSale(in);
                }

                public ProductSale[] newArray(int size) {
                    return new ProductSale[size];
                }
            };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.ProductSaleDescription);
        dest.writeDouble(this.ProductSaleCost);
        dest.writeString(this.ProductSaleCode);
        dest.writeInt(this.ProductQuantity);
        dest.writeDouble(this.ProductSaleCostQuantity);
        dest.writeInt(this.ProductSaleId);
        dest.writeInt(this.ProductSaleGranel);
        dest.writeString(this.ProductSaleUnit);
        dest.writeString(this.ProductUUID);
        dest.writeDouble(this.ProductPercentage);
        dest.writeDouble(this.ProductAmountPercentage);
        dest.writeDouble(this.ProductCost);
        dest.writeInt(this.ProductIdSaleDetail);
    }
}