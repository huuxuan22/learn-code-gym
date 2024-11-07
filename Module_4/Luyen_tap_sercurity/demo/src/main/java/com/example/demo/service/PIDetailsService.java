package com.example.demo.service;

import com.example.demo.model.ProductImageDetails;
import com.example.demo.repository.IProductImageDetails;
import com.example.demo.service.impl.IPIDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PIDetailsService implements IPIDetailsService {
    @Autowired
    private IProductImageDetails productImageDetails;

    @Override
    public Page<ProductImageDetails> getAllPID(Pageable pageable) {
        return productImageDetails.findAll(pageable);
    }

    @Override
    public int deleteByIdProduct(String idProduct) {
        return productImageDetails.updateProductImageDetailsLike(idProduct);
    }

//    @Override
//    public void deleteByIdProduct(Integer idProduct) {
//        productImageDetails.deleteById(idProduct);
//    }
}
