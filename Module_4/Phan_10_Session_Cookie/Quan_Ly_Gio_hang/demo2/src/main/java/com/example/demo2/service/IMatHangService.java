package com.example.demo2.service;

import com.example.demo2.model.MatHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IMatHangService {
    public Page<MatHang> showList(Pageable pageable);

}
