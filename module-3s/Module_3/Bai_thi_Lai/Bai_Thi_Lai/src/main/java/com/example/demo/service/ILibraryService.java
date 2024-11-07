package com.example.demo.service;

import com.example.demo.model.HocSinh;
import com.example.demo.model.MuonSach;
import com.example.demo.model.Sach;
import com.example.demo.model.ThongKe;

import java.util.List;

public interface ILibraryService {
    List<Sach> selectAllSach();
    int idMax();
    List<HocSinh> selectAllHS();
    boolean addMuonSach(MuonSach muonSach);
    List<ThongKe> SelectAll( );
}
