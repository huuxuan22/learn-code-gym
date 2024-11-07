package com.example.demo2.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class MatHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mat_hang")
    private int idMatHang;


    @Column(name = "ten_mat_hang")
    private String tenMatHang;


    @Column(name = "so_luong")
    private int soLuong;

    @Column(name = "ngay_san_xuat")
    private Date ngaySanXuat;

    @Column(name = "ten_hinh_anh")
    private String tenHinhAnh;

    public MatHang() {
    }

    public MatHang(int idMatHang, String tenMatHang, int soLuong, Date ngaySanXuat, String tenHinhAnh) {
        this.idMatHang = idMatHang;
        this.tenMatHang = tenMatHang;
        this.soLuong = soLuong;
        this.ngaySanXuat = ngaySanXuat;
        this.tenHinhAnh = tenHinhAnh;
    }

    public int getIdMatHang() {
        return idMatHang;
    }

    public void setIdMatHang(int idMatHang) {
        this.idMatHang = idMatHang;
    }

    public String getTenMatHang() {
        return tenMatHang;
    }

    public void setTenMatHang(String tenMatHang) {
        this.tenMatHang = tenMatHang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(Date ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    public String getTenHinhAnh() {
        return tenHinhAnh;
    }

    public void setTenHinhAnh(String tenHinhAnh) {
        this.tenHinhAnh = tenHinhAnh;
    }
}
