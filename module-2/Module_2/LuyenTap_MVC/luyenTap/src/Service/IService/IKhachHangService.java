package Service.IService;

public interface IKhachHangService<T> extends  IService<T>{
    void addKhachTrongNuoc();
    void addKhachNgoaiNuoc();
    void displayKhachHang();
    void timKiemKhachHang();
}
