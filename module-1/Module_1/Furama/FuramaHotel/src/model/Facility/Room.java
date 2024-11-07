package model.Facility;

import java.util.ArrayList;

public class Room extends Facility{
        private String dichVuMienPhi;

        public String getDichVuMienPhi() {
            return dichVuMienPhi;
        }

        public void setDichVuMienPhi(String dichVuMienPhi) {
            this.dichVuMienPhi = dichVuMienPhi;
        }

        public Room(String dichVuMienPhi) {
            this.dichVuMienPhi = dichVuMienPhi;
        }

        public Room(String maDichVu, String tenDichVu, int dienTichSuDung, double chiPhi, int soLuongNguoi, String kieuThue, String dichVuMienPhi) {
            super(maDichVu, tenDichVu, dienTichSuDung, chiPhi, soLuongNguoi, kieuThue);
            this.dichVuMienPhi = dichVuMienPhi;
        }
        Room(){
            super();
        }

    @Override
    public String toString() {
        return "Room{" +
                "dichVuMienPhi='" + dichVuMienPhi + '\'' +
                ", maDichVu='" + maDichVu + '\'' +
                ", tenDichVu='" + tenDichVu + '\'' +
                ", dienTichSuDung='" + dienTichSuDung + '\'' +
                ", ChiPhi=" + ChiPhi +
                ", soLuongNguoi=" + soLuongNguoi +
                ", kieuThue='" + kieuThue + '\'' +
                '}';
    }
    public String getInforRoomToTXT(){
        return super.getInforFacilityToTXT()+dichVuMienPhi ;
    }
}

