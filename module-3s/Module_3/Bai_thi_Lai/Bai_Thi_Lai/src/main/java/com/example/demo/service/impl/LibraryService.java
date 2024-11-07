package com.example.demo.service.impl;

import com.example.demo.model.HocSinh;
import com.example.demo.model.MuonSach;
import com.example.demo.model.Sach;
import com.example.demo.model.ThongKe;
import com.example.demo.repo.ILibraryRepo;
import com.example.demo.repo.impl.LibraryRepo;
import com.example.demo.service.ILibraryService;

import java.util.List;

public class LibraryService implements ILibraryService {
    private ILibraryRepo libraryRepo = new LibraryRepo();
    @Override
    public List<Sach> selectAllSach() {
        return libraryRepo.selectAllSach();
    }

    @Override
    public int idMax() {
        return libraryRepo.idMax();
    }

    @Override
    public List<HocSinh> selectAllHS() {
        return libraryRepo.selectAllHS();
    }

    @Override
    public boolean addMuonSach(MuonSach muonSach) {
        return libraryRepo.addNewMuonSach(muonSach);
    }

    @Override
    public List<ThongKe> SelectAll() {
        return libraryRepo.SelectAll();
    }
}
