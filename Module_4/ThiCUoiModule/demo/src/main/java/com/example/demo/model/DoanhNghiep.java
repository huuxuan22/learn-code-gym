package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "doanh_nghiep")
public class DoanhNghiep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_doanh_nghiep")
    private Integer idDoanhNghiep;

    @Column(name = "ten_doanh_nghiep")
    private String tenDoanhNghiep;

    @Column(name = "linh_vuc")
    private String linhVuc;

    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @Column(name = "email")
    private String email;

    @Column(name = "dia_chi")
    private String diaChi;

    public int getIdDoanhNghiep() {
        return idDoanhNghiep;
    }

    public void setIdDoanhNghiep(int idDoanhNghiep) {
        this.idDoanhNghiep = idDoanhNghiep;
    }

    public String getTenDoanhNghiep() {
        return tenDoanhNghiep;
    }

    public void setTenDoanhNghiep(String tenDoanhNghiep) {
        this.tenDoanhNghiep = tenDoanhNghiep;
    }

    public String getLinhVuc() {
        return linhVuc;
    }

    public void setLinhVuc(String linhVuc) {
        this.linhVuc = linhVuc;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public DoanhNghiep(int idDoanhNghiep, String tenDoanhNghiep, String linhVuc, String soDienThoai, String email, String diaChi) {
        this.idDoanhNghiep = idDoanhNghiep;
        this.tenDoanhNghiep = tenDoanhNghiep;
        this.linhVuc = linhVuc;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
    }

    public DoanhNghiep() {
    }

    public DoanhNghiep(String tenDoanhNghiep, String linhVuc, String soDienThoai, String email, String diaChi) {
        this.tenDoanhNghiep = tenDoanhNghiep;
        this.linhVuc = linhVuc;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
    }
}
