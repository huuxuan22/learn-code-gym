package com.example.demo2.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class ChiTietDonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ngay_dat_hang")
    private Date ngayDatHang;

    @ManyToOne
    @JoinColumn(name = "id_don_dat_hang")
    private DonDatHang donDatHang;

    @ManyToOne
    @JoinColumn(name = "id_mat_hang")
    private MatHang matHang;

    public ChiTietDonHang(int id, Date ngayDatHang, DonDatHang donDatHang, MatHang matHang) {
        this.id = id;
        this.ngayDatHang = ngayDatHang;
        this.donDatHang = donDatHang;
        this.matHang = matHang;
    }

    public ChiTietDonHang() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNgayDatHang() {
        return ngayDatHang;
    }

    public void setNgayDatHang(Date ngayDatHang) {
        this.ngayDatHang = ngayDatHang;
    }

    public DonDatHang getDonDatHang() {
        return donDatHang;
    }

    public void setDonDatHang(DonDatHang donDatHang) {
        this.donDatHang = donDatHang;
    }

    public MatHang getMatHang() {
        return matHang;
    }

    public void setMatHang(MatHang matHang) {
        this.matHang = matHang;
    }
}
