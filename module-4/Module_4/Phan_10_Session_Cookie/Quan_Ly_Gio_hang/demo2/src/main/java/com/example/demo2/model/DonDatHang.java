package com.example.demo2.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class DonDatHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_don_dat_hang")
    private int id;

    @Column(name = "ma_don_hang")
    private String maDonHang;

    @Column(name = "ten_don_hang")
    private String tenDongHang;



}
