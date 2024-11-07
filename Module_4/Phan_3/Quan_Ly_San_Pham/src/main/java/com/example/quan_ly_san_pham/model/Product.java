package com.example.quan_ly_san_pham.model;

public class Product {
    private int id;
    private String name;
    private String moTa;

    public Product(int id, String name, String moTa) {
        this.id = id;
        this.name = name;
        this.moTa = moTa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product() {
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
