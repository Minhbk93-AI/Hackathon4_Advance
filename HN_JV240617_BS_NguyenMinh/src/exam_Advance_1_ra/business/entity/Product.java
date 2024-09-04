package exam_Advance_1_ra.business.entity;

import exam_Advance_1_ra.validate.ProductValidate;

import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private Double productPrice;
    private String descriptions;
    private int stock;
    private Catalog catalog;
    private boolean status;

    public Product() {
    }

    public Product(String productId, String productName, Double productPrice, String descriptions, int stock, Catalog catalog, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.descriptions = descriptions;
        this.stock = stock;
        this.catalog = catalog;
        this.status = status;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    //Input Data Product
    public void inputData(Scanner sc){
        this.productId = ProductValidate.inputProductId(sc);
        this.productName = ProductValidate.inputProductName(sc);
        this.productPrice = ProductValidate.inputProductPrice(sc);
        this.descriptions = ProductValidate.inputProductDescriptions(sc);
        this.catalog = ProductValidate.inputProductCatalog(sc);
        this.stock = ProductValidate.inputProductStock(sc);
        this.status = true;
    }

    //Update Data Product
    public void saveData(Scanner sc){
        this.productName = ProductValidate.inputProductName(sc);
        this.productPrice = ProductValidate.inputProductPrice(sc);
        this.descriptions = ProductValidate.inputProductDescriptions(sc);
        this.catalog = ProductValidate.inputProductCatalog(sc);
        this.stock = ProductValidate.inputProductStock(sc);
        this.status = ProductValidate.inputProductStatus(sc);
    }

    //Display Prduct
    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", description='" + descriptions + '\'' +
                ", productPrice=" + productPrice +
                ", stock=" + stock +
                ", catalog=" + catalog.getCatalogName() +
                ", status=" + (status ?"Sell":"notSell") +
                '}';
    }

}
