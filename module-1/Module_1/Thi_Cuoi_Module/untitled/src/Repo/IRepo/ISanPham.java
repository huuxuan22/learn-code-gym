package Repo.IRepo;

import Model.SanPhamNK;
import Model.SanPhamXK;

import java.util.ArrayList;

public interface ISanPham<T> {
        ArrayList<SanPhamNK> getAllNK();
        ArrayList<SanPhamXK> getAllXK();

        void addSanPham(T t);
}
