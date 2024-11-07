package Model.HoaDon;

public class HoaDon {
    private String maHoaDon;
    private String maKhachHang;
    private String ngayRaHoaDon;
    private int soLuong;
    private int donGia;
    private int thanhTien;

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getNgayRaHoaDon() {
        return ngayRaHoaDon;
    }

    public void setNgayRaHoaDon(String ngayRaHoaDon) {
        this.ngayRaHoaDon = ngayRaHoaDon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public HoaDon(String maHoaDon, String maKhachHang, String ngayRaHoaDon, int soLuong, int donGia, int thanhTien) {
        this.maHoaDon = maHoaDon;
        this.maKhachHang = maKhachHang;
        this.ngayRaHoaDon = ngayRaHoaDon;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    @Override
    public String toString() {
        return "HoaDon{" +
                "maHoaDon='" + maHoaDon + '\'' +
                ", maKhachHang='" + maKhachHang + '\'' +
                ", ngayRaHoaDon='" + ngayRaHoaDon + '\'' +
                ", soLuong=" + soLuong +
                ", donGia=" + donGia +
                ", thanhTien=" + thanhTien +
                '}';
    }
    public String getInforToCSV(){
        return maHoaDon+","+maKhachHang+","+ ngayRaHoaDon+","+soLuong+","+donGia+","+thanhTien;
    }

}
