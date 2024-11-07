package com.example.demo.repository;

import com.example.demo.model.ProductImageDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface IProductImageDetails extends JpaRepository<ProductImageDetails,Integer> {
    @Modifying
    @Transactional
    @Query(value ="UPDATE product_image_details SET so_luong = 4 WHERE id_product LIKE CONCAT(:param, '%')",nativeQuery = true)
    int updateProductImageDetailsLike(@Param("param") String param);
}
