package model.Facility;

import Repository.InterfaceRepository.IFacilityRepository;

public abstract class Facility {
        protected String maDichVu;// mã dịch vụ
        protected String tenDichVu;// họ tên
        protected int dienTichSuDung; // diện tích sử dụng
        protected double ChiPhi; // chi phí sử dụng
        protected int   soLuongNguoi;
        protected String kieuThue;

        public String getMaDichVu() {
            return maDichVu;
        }

        public void setMaDichVu(String maDichVu) {
            this.maDichVu = maDichVu;
        }

        public String getTenDichVu() {
            return tenDichVu;
        }

        public void setTenDichVu(String tenDichVu) {
            this.tenDichVu = tenDichVu;
        }

        public int getDienTichSuDung() {
            return dienTichSuDung;
        }

        public void setDienTichSuDung(int dienTichSuDung) {
            this.dienTichSuDung = dienTichSuDung;
        }

        public double getChiPhi() {
            return ChiPhi;
        }

        public void setChiPhi(double chiPhi) {
            ChiPhi = chiPhi;
        }

        public int getSoLuongNguoi() {
            return soLuongNguoi;
        }

        public void setSoLuongNguoi(int soLuongNguoi) {
            this.soLuongNguoi = soLuongNguoi;
        }

        public String getKieuThue() {
            return kieuThue;
        }

        public void setKieuThue(String kieuThue) {
            this.kieuThue = kieuThue;
        }

        public Facility() {
        }

        public Facility(String maDichVu, String tenDichVu, int dienTichSuDung, double chiPhi, int soLuongNguoi, String kieuThue) {
            this.maDichVu = maDichVu;
            this.tenDichVu = tenDichVu;
            this.dienTichSuDung = dienTichSuDung;
            ChiPhi = chiPhi;
            this.soLuongNguoi = soLuongNguoi;
            this.kieuThue = kieuThue;
        }

        @Override
        public String toString() {
            return "furamaService{" +
                    "maDichVu='" + maDichVu + '\'' +
                    ", tenDichVu='" + tenDichVu + '\'' +
                    ", dienTichSuDung='" + dienTichSuDung + '\'' +
                    ", ChiPhi=" + ChiPhi +
                    ", soLuongNguoi=" + soLuongNguoi +
                    ", kieuThue='" + kieuThue + '\'' +
                    '}';
        }
        public String getInforFacilityToTXT(){
            return maDichVu+ "," + tenDichVu + "," + dienTichSuDung+","+ ChiPhi + "," + soLuongNguoi +","+kieuThue + ",";
        }
}

