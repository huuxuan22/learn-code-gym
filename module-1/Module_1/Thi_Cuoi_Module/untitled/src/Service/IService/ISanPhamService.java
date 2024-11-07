package Service.IService;

import Model.SanPhamNK;
import Model.SanPhamXK;

import java.util.ArrayList;

public interface ISanPhamService<T> {
    ArrayList<SanPhamNK> getAllNK();
    ArrayList<SanPhamXK> getAllXK();
    void addSPNK();
    void addSPXK();
    void display();
    void search();
    void delete();
}
