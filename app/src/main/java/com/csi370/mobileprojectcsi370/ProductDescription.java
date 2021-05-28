package com.csi370.mobileprojectcsi370;

public class ProductDescription {


    private int productId;
    private String name;
    private String brand;
    private String cpu;
    private String ram;
    private String hdd;
    private String ssd;
    private String graphics;
    private String os;
    private double price;



    public ProductDescription() { }

    public ProductDescription(int productId, String name, String brand, String cpu, String ram, String hdd, String ssd, String graphics, String os, double price)
    {
        this.productId = productId;
        this.name = name;
        this.brand = brand;
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
        this.ssd = ssd;
        this.graphics = graphics;
        this.os= os;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public String getSsd() {
        return ssd;
    }

    public void setSsd(String ssd) {
        this.ssd = ssd;
    }

    public String getGraphics() {
        return graphics;
    }

    public void setGraphics(String graphics) {
        this.graphics = graphics;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}