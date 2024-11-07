package com.example.demo.service;

import com.example.demo.model.DoanhNghiep;
import com.example.demo.model.DuAn;
import com.example.demo.repository.IDoanhNghiepRepo;
import com.example.demo.repository.IDuAnRepository;
import com.example.demo.service.impl.IDuAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuAnService implements IDuAnService {
    @Autowired
    private IDuAnRepository duAnRepository;
    @Autowired
    private IDoanhNghiepRepo doanhNghiepRepo;

    @Override
    public Page<DuAn> findAll(Pageable pageable) {
        return duAnRepository.findAll(pageable);
    }

    @Override
    public List<DoanhNghiep> findAllDoanhNghiep() {
        return doanhNghiepRepo.findAll();
    }

    @Override
    public void save(DuAn duAn) {
        duAnRepository.save(duAn);
    }

    @Override
    public Page<DuAn> findByTenDuAn(String name) {
        return (Page<DuAn>) duAnRepository.findByTenDuAn(name);
    }


}
