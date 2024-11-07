package com.example.demo.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "tin_tuc")
public class TinTuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tin_tuc")
    private Integer idTinTuc;

    @Column(name = "tieu_de")
    private String tieuDe;

    @Column(name = "noi_dung")
    private String noiDung;

    @Column(name = "ngay_dang_tin")
    private Date ngayDangTin;

    @Column(name = "phong_vien")
    private String phongVien;

    @ManyToOne
    @JoinColumn(name = "id_doanh_muc")
    private DoanhMuc doanhMuc;

    public Integer getIdTinTuc() {
        return idTinTuc;
    }

    public void setIdTinTuc(Integer idTinTuc) {
        this.idTinTuc = idTinTuc;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Date getNgayDangTin() {
        return ngayDangTin;
    }

    public void setNgayDangTin(Date ngayDangTin) {
        this.ngayDangTin = ngayDangTin;
    }

    public String getPhongVien() {
        return phongVien;
    }

    public void setPhongVien(String phongVien) {
        this.phongVien = phongVien;
    }

    public DoanhMuc getDoanhMuc() {
        return doanhMuc;
    }

    public void setDoanhMuc(DoanhMuc doanhMuc) {
        this.doanhMuc = doanhMuc;
    }

    public TinTuc(Integer idTinTuc, String tieuDe, String noiDung, Date ngayDangTin, String phongVien, DoanhMuc doanhMuc) {
        this.idTinTuc = idTinTuc;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.ngayDangTin = ngayDangTin;
        this.phongVien = phongVien;
        this.doanhMuc = doanhMuc;
    }

    public TinTuc() {
    }
}
