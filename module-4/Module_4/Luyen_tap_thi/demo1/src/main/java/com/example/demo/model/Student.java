package com.example.demo.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer id;

    @Column(name = "ma_sinh_vien")
    private String msv;

    @Column(name = "ngay_sinh")
    private Date ngaySinh;

    private String ten;

    @Column(name = "can_cuoc_cong_dan")
    private String canCuocCongDan;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class clazz;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getCanCuocCongDan() {
        return canCuocCongDan;
    }

    public void setCanCuocCongDan(String canCuocCongDan) {
        this.canCuocCongDan = canCuocCongDan;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }
    public String getNgaySinhs(String ngaySinh) {
        return ngaySinh;
    }
    public Student() {
    }

    public Student(Integer id, String msv, Date ngaySinh, String ten, String canCuocCongDan, Class clazz) {
        this.id = id;
        this.msv = msv;
        this.ngaySinh = ngaySinh;
        this.ten = ten;
        this.canCuocCongDan = canCuocCongDan;
        this.clazz = clazz;
    }

    public Student(String msv, Date ngaySinh, String ten, String canCuocCongDan, Class clazz) {
        this.msv = msv;
        this.ngaySinh = ngaySinh;
        this.ten = ten;
        this.canCuocCongDan = canCuocCongDan;
        this.clazz = clazz;
    }
}
