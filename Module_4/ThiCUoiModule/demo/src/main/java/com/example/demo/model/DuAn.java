package com.example.demo.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "du_an")
public class DuAn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_du_an")
    private Integer idDuAn;


    @Column(name = "ma_du_an")
    private String maDuAn;

    @Column(name = "ten_du_an")
    private String tenDuAn;

    @Column(name = "kinh_phi")
    private Long kinhPhi;

    @Column(name = "mo_ta_du_an")
    private String moTaDuAn;

    @Column(name = "thoi_gian_Dang_ki")
    private Integer thoiGianDangKi;

    @Column(name = "ngay_dang_ki")
    private Date ngayDangKi;

    @ManyToOne
    @JoinColumn(name = "id_doanh_nghiep")
    private DoanhNghiep doanhNghiep;

    public DuAn() {
    }

    public Integer getIdDuAn() {
        return idDuAn;
    }

    public DuAn(String maDuAn, String tenDuAn, Long kinhPhi, String moTaDuAn, Integer thoiGianDangKi, Date ngayDangKi, DoanhNghiep doanhNghiep) {
        this.maDuAn = maDuAn;
        this.tenDuAn = tenDuAn;
        this.kinhPhi = kinhPhi;
        this.moTaDuAn = moTaDuAn;
        this.thoiGianDangKi = thoiGianDangKi;
        this.ngayDangKi = ngayDangKi;
        this.doanhNghiep = doanhNghiep;
    }

    public DuAn(Integer idDuAn, String maDuAn, String tenDuAn, Long kinhPhi, String moTaDuAn, Integer thoiGianDangKi, Date ngayDangKi, DoanhNghiep doanhNghiep) {
        this.idDuAn = idDuAn;
        this.maDuAn = maDuAn;
        this.tenDuAn = tenDuAn;
        this.kinhPhi = kinhPhi;
        this.moTaDuAn = moTaDuAn;
        this.thoiGianDangKi = thoiGianDangKi;
        this.ngayDangKi = ngayDangKi;
        this.doanhNghiep = doanhNghiep;
    }

    public void setIdDuAn(Integer idDuAn) {
        this.idDuAn = idDuAn;
    }

    public String getMaDuAn() {
        return maDuAn;
    }

    public void setMaDuAn(String maDuAn) {
        this.maDuAn = maDuAn;
    }

    public String getTenDuAn() {
        return tenDuAn;
    }

    public void setTenDuAn(String tenDuAn) {
        this.tenDuAn = tenDuAn;
    }

    public Long getKinhPhi() {
        return kinhPhi;
    }

    public void setKinhPhi(Long kinhPhi) {
        this.kinhPhi = kinhPhi;
    }

    public String getMoTaDuAn() {
        return moTaDuAn;
    }

    public void setMoTaDuAn(String moTaDuAn) {
        this.moTaDuAn = moTaDuAn;
    }

    public Integer getThoiGianDangKi() {
        return thoiGianDangKi;
    }

    public void setThoiGianDangKi(Integer thoiGianDangKi) {
        this.thoiGianDangKi = thoiGianDangKi;
    }

    public Date getNgayDangKi() {
        return ngayDangKi;
    }

    public void setNgayDangKi(Date ngayDangKi) {
        this.ngayDangKi = ngayDangKi;
    }

    public DoanhNghiep getDoanhNghiep() {
        return doanhNghiep;
    }

    public void setDoanhNghiep(DoanhNghiep doanhNghiep) {
        this.doanhNghiep = doanhNghiep;
    }
}
