package com.example.demo.model;

public class MuonSach {
    protected int idMuonSach;
    protected int idHocSinh;
    protected int idSach;
    protected String maMuonSach;
    protected String trangThai;
    protected String ngayMuonSach;
    protected String ngayTraSach;

    public MuonSach(int idMuonSach, int idHocSinh, int idSach, String maMuonSach, String trangThai, String ngayMuonSach, String ngayTraSach) {
        this.idMuonSach = idMuonSach;
        this.idHocSinh = idHocSinh;
        this.idSach = idSach;
        this.maMuonSach = maMuonSach;
        this.trangThai = trangThai;
        this.ngayMuonSach = ngayMuonSach;
        this.ngayTraSach = ngayTraSach;
    }

    public int getIdMuonSach() {
        return idMuonSach;
    }

    public void setIdMuonSach(int idMuonSach) {
        this.idMuonSach = idMuonSach;
    }

    public int getIdHocSinh() {
        return idHocSinh;
    }

    public void setIdHocSinh(int idHocSinh) {
        this.idHocSinh = idHocSinh;
    }

    public int getIdSach() {
        return idSach;
    }

    public void setIdSach(int idSach) {
        this.idSach = idSach;
    }

    public String getMaMuonSach() {
        return maMuonSach;
    }

    public void setMaMuonSach(String maMuonSach) {
        this.maMuonSach = maMuonSach;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getNgayMuonSach() {
        return ngayMuonSach;
    }

    public void setNgayMuonSach(String ngayMuonSach) {
        this.ngayMuonSach = ngayMuonSach;
    }

    public String getNgayTraSach() {
        return ngayTraSach;
    }

    public void setNgayTraSach(String ngayTraSach) {
        this.ngayTraSach = ngayTraSach;
    }
}
