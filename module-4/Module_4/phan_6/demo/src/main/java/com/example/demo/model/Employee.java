package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee")
    private int idEmployee;

    @Column(name = "name_employee")
    private String nameEmployee;

    @Column(name = "so_luong")
    private int soLuong;


    public Employee() {
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BoPhan getBoPhan() {
        return boPhan;
    }

    public void setBoPhan(BoPhan boPhan) {
        this.boPhan = boPhan;
    }

    @ManyToOne
    @JoinColumn(name = "id_bo_Phan")
    private BoPhan boPhan;

    public Employee(int idEmployee, String nameEmployee, int soLuong, BoPhan boPhan) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.soLuong = soLuong;
        this.boPhan = boPhan;
    }
}
