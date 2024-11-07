package model;

public class KhachHangVN extends KhachHang{
    private String doiTuongKH;
    private int soLuong;
    private int donGia;
    private int dinhMuc;

    public String getDoiTuongKH() {
        return doiTuongKH;
    }

    public void setDoiTuongKH(String doiTuongKH) {
        this.doiTuongKH = doiTuongKH;
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

    public int getDinhMuc() {
        return dinhMuc;
    }

    public void setDinhMuc(int dinhMuc) {
        this.dinhMuc = dinhMuc;
    }

    public KhachHangVN(String maKhachHang, String hoTen,String ngayRaHoaDon, String SDT, String email, String doiTuongKH, int soLuong, int donGia, int dinhMuc) {
        super(maKhachHang, hoTen,ngayRaHoaDon, SDT, email);
        this.doiTuongKH = doiTuongKH;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.dinhMuc = dinhMuc;
    }

    @Override
    public String toString() {
        return "KhachHangVN{" +
                "doiTuongKH='" + doiTuongKH + '\'' +
                ", soLuong=" + soLuong +
                ", donGia=" + donGia +
                ", dinhMuc=" + dinhMuc +
                ", maKhachHang='" + maKhachHang + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", SDT='" + SDT + '\'' +
                ", email='" + email + '\'' +
                "} " + super.toString();
    }

    public String getInforToTXT() {
        return maKhachHang + "," + hoTen + ","+ngayRaHoaDon+"," + SDT + "," + email + "," + doiTuongKH + "," + soLuong + "," + donGia + "," + dinhMuc;
    }

    @Override
    public float tinhThanhTien() {
        if(soLuong <= dinhMuc){
            return soLuong*donGia;
        }
        return (float) (soLuong*donGia*dinhMuc+soLuong*(soLuong-dinhMuc)*2.5);
    }

}
