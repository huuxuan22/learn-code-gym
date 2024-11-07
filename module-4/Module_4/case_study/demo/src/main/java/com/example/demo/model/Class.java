package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "class")
public class Class {
    @Id
    @Column(name = "id_class")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClass;

    @Column(name = "ten_lop")
    private String tenLop;

    public Class(int idClass, String tenLop) {
        this.idClass = idClass;
        this.tenLop = tenLop;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public Class(String tenLop) {
        this.tenLop = tenLop;
    }

    public Class() {
    }
}
