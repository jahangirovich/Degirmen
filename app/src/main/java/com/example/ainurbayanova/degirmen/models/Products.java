package com.example.ainurbayanova.degirmen.models;

public class Products {
    String nameOfProduct;
    String imageOfProduct;
    int amount;
    String measure;

    public Products(String nameOfProduct, String imageOfProduct, int amount, String measure) {
        this.nameOfProduct = nameOfProduct;
        this.imageOfProduct = imageOfProduct;
        this.amount = amount;
        this.measure = measure;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public String getImageOfProduct() {
        return imageOfProduct;
    }

    public void setImageOfProduct(String imageOfProduct) {
        this.imageOfProduct = imageOfProduct;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }
}
