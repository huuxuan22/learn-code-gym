package com.example.demo.reporitory;

import com.example.demo.model.TinTuc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITinTucRepo extends JpaRepository<TinTuc,Integer> {
    @Override
    void deleteById(Integer integer);
    Page<TinTuc> searchTinTucByTieuDe(String tieuDe, Pageable pageable);

    @Query(nativeQuery = true, value ="select tt.*  from tin_tuc as tt \n" +
            "inner join doanh_muc as dm where tt.tieu_de like concat('%',:param,'%') or  dm.ten_doanh_muc like concat('%',:param,'%') or (tt.tieu_de like concat('%',:param,'%') and  dm.ten_doanh_muc like concat('%',:param,'%'))")
    Page<TinTuc> searchTinTuc(@Param("param") String param, Pageable pageable);
}
