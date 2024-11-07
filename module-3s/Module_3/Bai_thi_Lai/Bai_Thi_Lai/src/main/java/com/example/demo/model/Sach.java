package com.example.demo.model;

public class Sach {
    protected int idSach;
    protected int idMuonSach;
    protected String maSach;
    protected String tenSach;
    protected String tenTacGia;
    protected String moTa;
    protected int soLuong;
    protected String maMuonSach;

    public Sach(int idSach, int idMuonSach, String maSach, String tenSach, String tenTacGia, String moTa, int soLuong, String maMuonSach) {
        this.idSach = idSach;
        this.idMuonSach = idMuonSach;
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tenTacGia = tenTacGia;
        this.moTa = moTa;
        this.soLuong = soLuong;
        this.maMuonSach = maMuonSach;
    }

    public int getIdSach() {
        return idSach;
    }

    public void setIdSach(int idSach) {
        this.idSach = idSach;
    }

    public int getIdMuonSach() {
        return idMuonSach;
    }

    public void setIdMuonSach(int idMuonSach) {
        this.idMuonSach = idMuonSach;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMaMuonSach() {
        return maMuonSach;
    }

    public void setMaMuonSach(String maMuonSach) {
        this.maMuonSach = maMuonSach;
    }
}
