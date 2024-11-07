package model.Interface;

import java.util.ArrayList;

public interface IManager<T> {
    void add(T t); // dùng để thêm
    T search(int id); // tìm kiếm theo id
    void remove(int id);  // xóa 1 sản phẩm theo id
    ArrayList<T> search(String name); // tìm kiếm theo tên
    ArrayList<T> getAll(); // dùng để lấy tất cả danh sách
    void displayAll(); // hiển thị tất cả dang sách
}
