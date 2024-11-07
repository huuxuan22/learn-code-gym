package Model;

public class SanPhamXK extends SanPham{
    private int giaXuatKhau;
    private String quocGia;

    public int getGiaXuatKhau() {
        return giaXuatKhau;
    }

    public void setGiaXuatKhau(int giaXuatKhau) {
        this.giaXuatKhau = giaXuatKhau;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public SanPhamXK(String idSanPham, String maSanPham, String tenSanPham, int giaBan, int soLuong, String nhaSanXuat, int giaXuatKhau, String quocGia) {
        super(idSanPham, maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat);
        this.giaXuatKhau = giaXuatKhau;
        this.quocGia = quocGia;
    }

    @Override
    public String toString() {
        return "SanPhamXK{" +
                "giaXuatKhau=" + giaXuatKhau +
                ", quocGia='" + quocGia + '\'' +
                ", idSanPham='" + idSanPham + '\'' +
                ", maSanPham='" + maSanPham + '\'' +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", giaBan=" + giaBan +
                ", soLuong=" + soLuong +
                ", nhaSanXuat='" + nhaSanXuat + '\'' +
                "} " + super.toString();
    }
    public String getInforToCSV(){
        return idSanPham+","+ maSanPham+","+tenSanPham +","+ giaBan +","+ soLuong+","+nhaSanXuat+","+giaXuatKhau+","+quocGia;
    }
}
