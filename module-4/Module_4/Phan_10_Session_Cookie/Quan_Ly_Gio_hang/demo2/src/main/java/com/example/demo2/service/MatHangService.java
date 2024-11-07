package com.example.demo2.service;

import com.example.demo2.model.MatHang;
import com.example.demo2.repo.IMatHangRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;



@Service
public class MatHangService implements IMatHangService{
    @Autowired
    private IMatHangRepo matHangRepo;
    @Override
    public Page<MatHang> showList(Pageable pageable) {
        return  matHangRepo.findAll(pageable);
    }

}
