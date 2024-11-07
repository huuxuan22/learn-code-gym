package Model.KhachHang;

public abstract class KhachHang {
    protected String maKhachHang;
    protected String hoTen;

    public KhachHang(String maKhachHang, String hoTen) {
        this.maKhachHang = maKhachHang;
        this.hoTen = hoTen;
    }

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

    @Override
    public String toString() {
        return "KhachHang{" +
                "maKhachHang='" + maKhachHang + '\'' +
                ", hoTen='" + hoTen + '\'' +
                '}';
    }
    public String getInforToCSV(){
        return hoTen + "," + maKhachHang + ",";
    }
}
