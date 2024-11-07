package model.Facility;

import java.util.ArrayList;

public class Villa extends Facility {

    private String tieuChuanPhong;
    private int dienTich;
    private int soTang;

    public String getTieuChuanPhong() {
        return tieuChuanPhong;
    }

    public void setTieuChuanPhong(String tieuChuanPhong) {
        this.tieuChuanPhong = tieuChuanPhong;
    }

    public int getDienTich() {
        return dienTich;
    }

    public void setDienTich(int dienTich) {
        this.dienTich = dienTich;
    }

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }


    public Villa(String maDichVu, String tenDichVu, int dienTichSuDung, double chiPhi, int soLuongNguoi, String kieuThue, String tieuChuanPhong, int dienTich, int soTang) {
        super(maDichVu, tenDichVu, dienTichSuDung, chiPhi, soLuongNguoi, kieuThue);
        this.tieuChuanPhong = tieuChuanPhong;
        this.dienTich = dienTich;
        this.soTang = soTang;
    }

    Villa() {
        super();
    }

    @Override
    public String toString() {
        return "Villa{" +
                "tieuChuanPhong='" + tieuChuanPhong + '\'' +
                ", dienTich='" + dienTich + '\'' +
                ", soTang=" + soTang +
                ", maDichVu='" + maDichVu + '\'' +
                ", tenDichVu='" + tenDichVu + '\'' +
                ", dienTichSuDung='" + dienTichSuDung + '\'' +
                ", ChiPhi=" + ChiPhi +
                ", soLuongNguoi=" + soLuongNguoi +
                ", kieuThue='" + kieuThue + '\'' +
                '}';
    }
    public String getInforFacilityToTXT(){
        return super.getInforFacilityToTXT() + tieuChuanPhong + "," + dienTich + "," + soTang;
    }
}

