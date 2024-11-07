package com.example.demo.model;

public class HocSinh {
    protected int idHocSinh;
    protected String hoTen;

    public HocSinh(int idHocSinh, String hoTen) {
        this.idHocSinh = idHocSinh;
        this.hoTen = hoTen;
    }

    public int getIdHocSinh() {
        return idHocSinh;
    }

    public void setIdHocSinh(int idHocSinh) {
        this.idHocSinh = idHocSinh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
}
