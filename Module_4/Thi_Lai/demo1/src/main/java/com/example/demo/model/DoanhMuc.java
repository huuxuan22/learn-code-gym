package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "doanh_muc")
public class DoanhMuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_doanh_muc")
    private Integer idDoanhMuc;


    @Column(name = "doanh_muc")
    private String doanhMuc;

    public Integer getIdDoanhMuc() {
        return idDoanhMuc;
    }

    public void setIdDoanhMuc(Integer idDoanhMuc) {
        this.idDoanhMuc = idDoanhMuc;
    }

    public String getDoanhMuc() {
        return doanhMuc;
    }

    public void setDoanhMuc(String doanhMuc) {
        this.doanhMuc = doanhMuc;
    }

    public DoanhMuc(Integer idDoanhMuc, String doanhMuc) {
        this.idDoanhMuc = idDoanhMuc;
        this.doanhMuc = doanhMuc;
    }

    public DoanhMuc() {
    }
}
