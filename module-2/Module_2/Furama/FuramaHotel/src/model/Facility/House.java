package model.Facility;

import Repository.InterfaceRepository.IFacilityRepository;
import model.Person.Person;

import java.util.ArrayList;
import java.util.List;

public class House extends Facility  {
        private String tieuChuanPhong;
        private int soTang;

        public String getTieuChuanPhong() {
            return tieuChuanPhong;
        }

        public void setTieuChuanPhong(String tieuChuanPhong) {
            this.tieuChuanPhong = tieuChuanPhong;
        }

        public int getSoTang() {
            return soTang;
        }

        public void setSoTang(int soTang) {
            this.soTang = soTang;
        }
        public House(String maDichVu, String tenDichVu, int dienTichSuDung, double chiPhi, int soLuongNguoi, String kieuThue, String tieuChuanPhong, int soTang) {
            super(maDichVu, tenDichVu, dienTichSuDung, chiPhi, soLuongNguoi, kieuThue);
            this.tieuChuanPhong = tieuChuanPhong;
            this.soTang = soTang;
        }
        House(){
            super();
        }

    @Override
    public String toString() {
        return "House{" +
                "tieuChuanPhong='" + tieuChuanPhong + '\'' +
                ", soTang=" + soTang +
                ", maDichVu='" + maDichVu + '\'' +
                ", tenDichVu='" + tenDichVu + '\'' +
                ", dienTichSuDung='" + dienTichSuDung + '\'' +
                ", ChiPhi=" + ChiPhi +
                ", soLuongNguoi=" + soLuongNguoi +
                ", kieuThue='" + kieuThue + '\'' +
                '}';
    }
    public String getInforHouseToTXT(){
            return super.getInforFacilityToTXT()+tieuChuanPhong +","+ soTang;
    }
}

