package com.example.ung_dung_nge_nhac.model;

import javax.persistence.*;

@Entity
public class song {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    @Column(name = "names")
    private String tenBaiHat;
    private String tenTacGia;
    private String fileBaiHat;

    public song() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        this.tenBaiHat = tenBaiHat;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public String getFileBaiHat() {
        return fileBaiHat;
    }

    public void setFileBaiHat(String fileBaiHat) {
        this.fileBaiHat = fileBaiHat;
    }

    public song(int id, String tenBaiHat, String tenTacGia, String fileBaiHat) {
        this.id = id;
        this.tenBaiHat = tenBaiHat;
        this.tenTacGia = tenTacGia;
        this.fileBaiHat = fileBaiHat;
    }
}
