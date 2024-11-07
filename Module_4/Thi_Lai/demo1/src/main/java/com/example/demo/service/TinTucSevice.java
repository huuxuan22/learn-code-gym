package com.example.demo.service;

import com.example.demo.model.DoanhMuc;
import com.example.demo.model.TinTuc;
import com.example.demo.reporitory.IDoanhMucRepo;
import com.example.demo.reporitory.ITinTucRepo;
import com.example.demo.service.impl.ITinTucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TinTucSevice implements ITinTucService {
    @Autowired
    private ITinTucRepo tinTucRepo;
    @Autowired
    private IDoanhMucRepo doanhMucRepo;

    @Override
    public Page<TinTuc> findAll(Pageable pageable) {
        return tinTucRepo.findAll(pageable);
    }

    @Override
    public void deletedById(Integer id) {
        tinTucRepo.deleteById(id);
    }

    @Override
    public List<DoanhMuc> getAllDoanhMuc() {
        return doanhMucRepo.findAll();
    }

    @Override
    public TinTuc addNew(TinTuc tinTuc) {
        return tinTucRepo.save(tinTuc);
    }

    @Override
    public Page<TinTuc> search(String valueSearch, Pageable pageable) {
        return tinTucRepo.searchTinTucByTieuDe(valueSearch,pageable);
    }

    @Override
    public Page<TinTuc> searchTinTuc(String values, Pageable pageable) {
        return tinTucRepo.searchTinTuc(values, pageable);
    }
}
