package com.example.demo.model;

import jakarta.persistence.*;
import jdk.jfr.Threshold;

@Entity
@Table(name = "order_details")
public class OrderDetails {
    @Id
    @Column(name = "order_details_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderDetailsId;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Integer getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(Integer orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public OrderDetails(Integer orderDetailsId, Bill bill, Product product) {
        this.orderDetailsId = orderDetailsId;
        this.bill = bill;
        this.product = product;
    }

    public OrderDetails(Bill bill, Product product) {
        this.bill = bill;
        this.product = product;
    }

    public OrderDetails() {
    }
}
