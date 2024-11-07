package com.example.demo.model;

public class Product {
    private int idProduct;
    private String nameProduct;
    private int Price;
    private String producer;

    public Product(int idProduct, String nameProduct, int price, String producer) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        Price = price;
        this.producer = producer;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
