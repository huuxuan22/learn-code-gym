package model;

public class KhachHangNN extends KhachHang{
    private String quocTich;
    private int soLuong;
    private int donGia;

    public KhachHangNN(String maKhachHang, String hoTen, String ngayRaHoaDon, String SDT, String email, String quocTich, int soLuong, int donGia) {
        super(maKhachHang, hoTen, ngayRaHoaDon, SDT, email);
        this.quocTich = quocTich;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
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

    @Override
    public float tinhThanhTien() {
        return soLuong*donGia;
    }

    @Override
    public String toString() {
        return "KhachHangNN{" +
                "quocTich='" + quocTich + '\'' +
                ", soLuong=" + soLuong +
                ", donGia=" + donGia +
                ", maKhachHang='" + maKhachHang + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", ngayRaHoaDon='" + ngayRaHoaDon + '\'' +
                ", SDT='" + SDT + '\'' +
                ", email='" + email + '\'' +
                "} " + super.toString();
    }
    public String getInforToTXT(){
        return maKhachHang+","+hoTen+","+ngayRaHoaDon+","+SDT+","+email+","+quocTich+","+soLuong+","+donGia;
    }
}
