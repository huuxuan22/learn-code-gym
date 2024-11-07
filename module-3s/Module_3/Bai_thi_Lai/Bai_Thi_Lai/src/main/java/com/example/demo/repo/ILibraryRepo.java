package com.example.demo.repo;

import com.example.demo.model.HocSinh;
import com.example.demo.model.MuonSach;
import com.example.demo.model.Sach;
import com.example.demo.model.ThongKe;

import java.util.List;

public interface ILibraryRepo {
    public List<Sach> selectAllSach();
    public int idMax();
    List<HocSinh> selectAllHS();
    boolean addNewMuonSach(MuonSach muonSach);
    List<ThongKe> SelectAll();
}
