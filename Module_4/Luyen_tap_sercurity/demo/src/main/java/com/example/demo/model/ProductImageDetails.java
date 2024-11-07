package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product_image_details")
public class ProductImageDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product_image_details")
    private Integer idProductImageDetails;

    @ManyToOne
    @JoinColumn(name = "id_product_image")
    private ProductImage productImage;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    private Integer soLuong;

    public Integer getIdProductImageDetails() {
        return idProductImageDetails;
    }

    public void setIdProductImageDetails(Integer idProductImageDetails) {
        this.idProductImageDetails = idProductImageDetails;
    }

    public ProductImage getProductImage() {
        return productImage;
    }

    public void setProductImage(ProductImage productImage) {
        this.productImage = productImage;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public ProductImageDetails(ProductImage productImage, Product product, Integer soLuong) {
        this.productImage = productImage;
        this.product = product;
        this.soLuong = soLuong;
    }

    public ProductImageDetails(Integer idProductImageDetails, ProductImage productImage, Product product, Integer soLuong) {
        this.idProductImageDetails = idProductImageDetails;
        this.productImage = productImage;
        this.product = product;
        this.soLuong = soLuong;
    }

    public ProductImageDetails() {
    }
}
