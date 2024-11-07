package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer idProduct;

    @Column(name = "product_name")
    private String name;
    @Column(name = "ma_san_pham")
    private String maSanPham;

    private String description;

    private String price;
    private String category;

    @ManyToOne
    @JoinColumn(name = "id_product_type")
    private ProductType productType;

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public Product(String name, String maSanPham, String description, String price, String category, ProductType productType) {
        this.name = name;
        this.maSanPham = maSanPham;
        this.description = description;
        this.price = price;
        this.category = category;
        this.productType = productType;
    }

    public Product() {
    }

    public Product(Integer idProduct, String name, String maSanPham, String description, String price, String category, ProductType productType) {
        this.idProduct = idProduct;
        this.name = name;
        this.maSanPham = maSanPham;
        this.description = description;
        this.price = price;
        this.category = category;
        this.productType = productType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
