package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

public interface IProductRepository extends JpaRepository<Product,Integer>{
    @Modifying
    @Query(nativeQuery = true,value = "update product \n" +
            "set statuss = 0 where product_id = :param")
    public void deleteProductByIdProduct(@Param("param")int idProduct);


}
