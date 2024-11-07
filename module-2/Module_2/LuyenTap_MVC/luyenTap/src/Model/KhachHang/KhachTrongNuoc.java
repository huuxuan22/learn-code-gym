package Model.KhachHang;

public class KhachTrongNuoc extends  KhachHang{
    private String loaiKhach;
    private int dinhMuc;

    public String getLoaiKhach() {
        return loaiKhach;
    }

    public void setLoaiKhach(String loaiKhach) {
        this.loaiKhach = loaiKhach;
    }

    public int getDinhMuc() {
        return dinhMuc;
    }

    public void setDinhMuc(int dinhMuc) {
        this.dinhMuc = dinhMuc;
    }

    public KhachTrongNuoc(String maKhachHang, String hoTen, String loaiKhach, int dinhMuc) {
        super(maKhachHang, hoTen);
        this.loaiKhach = loaiKhach;
        this.dinhMuc = dinhMuc;
    }

    @Override
    public String toString() {
        return "KhachTrongNuoc{" +
                "loaiKhach='" + loaiKhach + '\'' +
                ", dinhMuc=" + dinhMuc +
                ", maKhachHang='" + maKhachHang + '\'' +
                ", hoTen='" + hoTen + '\'' +
                "} " + super.toString();
    }
    public String getInforToCSV(){
        return hoTen + "," + maKhachHang + ","+loaiKhach +","+dinhMuc;
    }
}
