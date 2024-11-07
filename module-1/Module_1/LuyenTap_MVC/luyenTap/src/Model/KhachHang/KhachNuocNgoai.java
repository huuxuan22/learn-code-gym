package Model.KhachHang;

public class KhachNuocNgoai extends KhachHang{
    private String quocTich;

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public KhachNuocNgoai(String maKhachHang, String hoTen, String quocTich) {
        super(maKhachHang, hoTen);
        this.quocTich = quocTich;
    }

    @Override
    public String toString() {
        return "KhachNuocNgoai{" +
                "quocTich='" + quocTich + '\'' +
                "} " + super.toString();
    }
    public String getInforToCSV() {
        return hoTen + "," + maKhachHang + ","+quocTich;
    }
}
