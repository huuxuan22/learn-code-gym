package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(name = "ten_giang_vien")
    private String tenGiangVien;

    @Column(name = "ma_giang_vien")
    private String maGiangVien;

    @Column(name = "can_cuoc_cong_dan")
    private String canCuocCongDan;

    @OneToOne
    @JoinColumn(name = "class_id")
    private Class clazz;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenGiangVien() {
        return tenGiangVien;
    }

    public void setTenGiangVien(String tenGiangVien) {
        this.tenGiangVien = tenGiangVien;
    }

    public String getMaGiangVien() {
        return maGiangVien;
    }

    public void setMaGiangVien(String maGiangVien) {
        this.maGiangVien = maGiangVien;
    }

    public String getCanCuocCongDan() {
        return canCuocCongDan;
    }

    public void setCanCuocCongDan(String canCuocCongDan) {
        this.canCuocCongDan = canCuocCongDan;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public Teacher(Integer id, String tenGiangVien, String maGiangVien, String canCuocCongDan, Class clazz) {
        this.id = id;
        this.tenGiangVien = tenGiangVien;
        this.maGiangVien = maGiangVien;
        this.canCuocCongDan = canCuocCongDan;
        this.clazz = clazz;
    }

    public Teacher() {
    }
}
