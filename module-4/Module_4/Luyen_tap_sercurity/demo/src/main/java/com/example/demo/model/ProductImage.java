package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product_image")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prpduct_image")
    private Integer idProductImage;

    private String link;

    public ProductImage(Integer idProductImage, String link) {
        this.idProductImage = idProductImage;
        this.link = link;
    }

    public ProductImage(String link) {
        this.link = link;
    }

    public ProductImage() {
    }

    public Integer getIdProductImage() {
        return idProductImage;
    }

    public void setIdProductImage(Integer idProductImage) {
        this.idProductImage = idProductImage;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
