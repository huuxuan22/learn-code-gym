package com.example.demo.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @Column(name = "teacher_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "ma_giang_vien")
    private String maGiangVien;


    @Column(name = "ten_giang_vien")
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_class")
    private Class aClass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaGiangVien() {
        return maGiangVien;
    }

    public void setMaGiangVien(String maGiangVien) {
        this.maGiangVien = maGiangVien;
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

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public Teacher() {
    }

    public Teacher(int id, String maGiangVien, String tenSinhVien, String soDienThoai, String canCuocCongDan, String diaChi, Date ngaySinh, Boolean gioiTinh, Class aClass) {
        this.id = id;
        this.maGiangVien = maGiangVien;
        this.tenSinhVien = tenSinhVien;
        this.soDienThoai = soDienThoai;
        this.canCuocCongDan = canCuocCongDan;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.aClass = aClass;
    }

    public Teacher(String maGiangVien, String tenSinhVien, String soDienThoai, String canCuocCongDan, String diaChi, Date ngaySinh, Boolean gioiTinh, Class aClass) {
        this.maGiangVien = maGiangVien;
        this.tenSinhVien = tenSinhVien;
        this.soDienThoai = soDienThoai;
        this.canCuocCongDan = canCuocCongDan;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.aClass = aClass;
    }
}
