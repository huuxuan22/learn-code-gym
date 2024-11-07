package com.example.demo.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Integer billId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;

    @Column(name = "bill_code")
    private String billCode;

    @Column(name = "ngay_tao")
    private Date dayCreate;

    @Column(name = "money_sum")
    private Double moneySum;

    public Bill() {

    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public Date getDayCreate() {
        return dayCreate;
    }

    public void setDayCreate(Date dayCreate) {
        this.dayCreate = dayCreate;
    }

    public Double getMoneySum() {
        return moneySum;
    }

    public void setMoneySum(Double moneySum) {
        this.moneySum = moneySum;
    }

    public Bill(Integer billId, Customer customer, Staff staff, String billCode, Date dayCreate, Double moneySum) {
        this.billId = billId;
        this.customer = customer;
        this.staff = staff;
        this.billCode = billCode;
        this.dayCreate = dayCreate;
        this.moneySum = moneySum;
    }

    public Bill(Customer customer, Staff staff, String billCode, Date dayCreate, Double moneySum) {
        this.customer = customer;
        this.staff = staff;
        this.billCode = billCode;
        this.dayCreate = dayCreate;
        this.moneySum = moneySum;
    }
}
