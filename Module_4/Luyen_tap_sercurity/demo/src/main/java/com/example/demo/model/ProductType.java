package com.example.demo.model;

import jakarta.persistence.*;

@Entity(name = "product_type")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProductType;

    @Column(name = "name_product_type")
    private String nameProductType;

    public Integer getIdProductType() {
        return idProductType;
    }

    public void setIdProductType(Integer idProductType) {
        this.idProductType = idProductType;
    }

    public String getNameProductType() {
        return nameProductType;
    }

    public void setNameProductType(String nameProductType) {
        this.nameProductType = nameProductType;
    }

    public ProductType(Integer idProductType, String nameProductType) {
        this.idProductType = idProductType;
        this.nameProductType = nameProductType;
    }

    public ProductType() {
    }

    public ProductType(String nameProductType) {
        this.nameProductType = nameProductType;
    }
}
