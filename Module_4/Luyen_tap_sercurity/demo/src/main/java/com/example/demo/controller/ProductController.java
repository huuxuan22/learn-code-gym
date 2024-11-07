package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.model.ProductImage;
import com.example.demo.service.ProductImageService;
import com.example.demo.service.impl.IPIDetailsService;
import com.example.demo.service.impl.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
@CrossOrigin
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private IPIDetailsService ipiDetailsService;

    @Autowired
    private ProductImageService productImageService;
    @GetMapping
    public ResponseEntity showList(@RequestParam(required = false) String keyWord,
                                      @RequestParam(required = false,defaultValue = "0") int page) {
        org.springframework.data.domain.Pageable pageable = PageRequest.of(page, 3);
        Page<Product> list = null;
        Page<ProductImage> listImage = null;
        Map<String, Object> respone = null;
        if (keyWord != null) {

        } else {
            respone = new HashMap<>();
            list = productService.getAllProductService(pageable);
            listImage = productImageService.getAllProductImage(pageable);
            respone.put("product", list);
            respone.put("productImage", listImage);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteById(@RequestParam("idDelete") String idDelete){
        try {
            // Gọi phương thức xóa sản phẩm với id được truyền vào
            int s = ipiDetailsService.deleteByIdProduct((idDelete));
            System.out.println("Xuân đẹp trai");
            productService.deleteById(Integer.parseInt(idDelete));
            return new ResponseEntity<>(HttpStatus.OK); // Trả về mã 200 OK nếu xóa thành công
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi khi xóa sản phẩm: " + e.getMessage());
        }
    }
}
