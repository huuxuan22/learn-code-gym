package model;

public abstract class KhachHang implements IThanhTien{
    protected String maKhachHang;
    protected String hoTen;
    protected String ngayRaHoaDon;
    protected String SDT;
    protected String email;

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgayRaHoaDon() {
        return ngayRaHoaDon;
    }

    public void setNgayRaHoaDon(String ngayRaHoaDon) {
        this.ngayRaHoaDon = ngayRaHoaDon;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public KhachHang(String maKhachHang, String hoTen, String ngayRaHoaDon, String SDT, String email) {
        this.maKhachHang = maKhachHang;
        this.hoTen = hoTen;
        this.ngayRaHoaDon = ngayRaHoaDon;
        this.SDT = SDT;
        this.email = email;
    }

    public  String getInforToTXT(){
        return maKhachHang+","+hoTen+","+ngayRaHoaDon+","+SDT+","+email+",";
    }

}
