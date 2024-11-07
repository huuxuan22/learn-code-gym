package Model;

public class SanPhamNK extends SanPham{
    private int giaNhapKhau;
    private String tinhThanh;
    private int thueNhapKhau;

    public int getGiaNhapKhau() {
        return giaNhapKhau;
    }

    public void setGiaNhapKhau(int giaNhapKhau) {
        this.giaNhapKhau = giaNhapKhau;
    }

    public String getTinhThanh() {
        return tinhThanh;
    }

    public void setTinhThanh(String tinhThanh) {
        this.tinhThanh = tinhThanh;
    }

    public int getThueNhapKhau() {
        return thueNhapKhau;
    }

    public void setThueNhapKhau(int thueNhapKhau) {
        this.thueNhapKhau = thueNhapKhau;
    }

    public SanPhamNK(String idSanPham, String maSanPham, String tenSanPham, int giaBan, int soLuong, String nhaSanXuat, int giaNhapKhau, String tinhThanh, int thueNhapKhau) {
        super(idSanPham, maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat);
        this.giaNhapKhau = giaNhapKhau;
        this.tinhThanh = tinhThanh;
        this.thueNhapKhau = thueNhapKhau;
    }

    @Override
    public String toString() {
        return "SanPhamNK{" +
                "giaNhapKhau=" + giaNhapKhau +
                ", tinhThanh='" + tinhThanh + '\'' +
                ", thueNhapKhau='" + thueNhapKhau + '\'' +
                "} " + super.toString();
    }
    public String getInforToCSV(){
        return idSanPham+","+ maSanPham+","+tenSanPham +","+ giaBan +","+ soLuong+","+nhaSanXuat+","+giaNhapKhau+","+tinhThanh +","+thueNhapKhau;
    }
}
