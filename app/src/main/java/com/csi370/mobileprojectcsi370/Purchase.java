package com.csi370.mobileprojectcsi370;

public class Purchase {

    private int userId;
    private String productName;
    private int productId;
    private int quantity;
    private double price;
    private int purchaseId;

    public Purchase(int userId, String productName, int productId, int quantity, double price, int purchaseId) {
        this.userId = userId;
        this.productName = productName;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.purchaseId = purchaseId;
    }

    public Purchase() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }
}


