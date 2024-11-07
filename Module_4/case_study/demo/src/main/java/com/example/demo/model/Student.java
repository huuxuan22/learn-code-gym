package com.example.demo.model;

import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    @Column(name = "ma_sinh_vien")
    private String maSinhVien;


    @Column(name = "ten_sinh_vien")
    private String tenSinhVien;


    @Column(name = "so_dien_thoai")
    private String soDienThoai;


    @Column(name = "can_cuoc_cong_dan")
    private String canCuocCongDan;

    @Column(name = "dia_chi")
    private String diaChi;


    @Column(name = "ngay_sinh")
    private Date ngaySinh;


    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

    public Student() {
    }

    @ManyToOne
    @JoinColumn(name = "id_class")
    private Class Clazz;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account",referencedColumnName = "account")
    private User user;

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getCanCuocCongDan() {
        return canCuocCongDan;
    }

    public void setCanCuocCongDan(String canCuocCongDan) {
        this.canCuocCongDan = canCuocCongDan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Class getClazz() {
        return Clazz;
    }

    public void setClazz(Class clazz) {
        Clazz = clazz;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Student(String maSinhVien, String tenSinhVien, String soDienThoai, String canCuocCongDan, String diaChi, Date ngaySinh, Boolean gioiTinh, Class clazz, User user) {
        this.maSinhVien = maSinhVien;
        this.tenSinhVien = tenSinhVien;
        this.soDienThoai = soDienThoai;
        this.canCuocCongDan = canCuocCongDan;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        Clazz = clazz;
        this.user = user;
    }

    public Student(int id, String maSinhVien, String tenSinhVien, String soDienThoai, String canCuocCongDan, String diaChi, Date ngaySinh, Boolean gioiTinh, Class clazz, User user) {
        this.id = id;
        this.maSinhVien = maSinhVien;
        this.tenSinhVien = tenSinhVien;
        this.soDienThoai = soDienThoai;
        this.canCuocCongDan = canCuocCongDan;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        Clazz = clazz;
        this.user = user;
    }
}
