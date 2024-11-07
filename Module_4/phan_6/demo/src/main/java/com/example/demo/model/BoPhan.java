package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class BoPhan {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id_bo_phan")
    private int idBoPhan;

    @Column(name = "ten_bo_phan")
    private String tenBoPhan;

    public int getIdBoPhan() {
        return idBoPhan;
    }

    public void setIdBoPhan(int idBoPhan) {
        this.idBoPhan = idBoPhan;
    }

    public String getTenBoPhan() {
        return tenBoPhan;
    }

    public void setTenBoPhan(String tenBoPhan) {
        this.tenBoPhan = tenBoPhan;
    }

    public BoPhan() {

    }
}
