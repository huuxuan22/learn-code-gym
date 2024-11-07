package com.example.quan_ly_ky_tuc.repository;

import com.example.quan_ly_ky_tuc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUserRepo extends JpaRepository<User,String> {
    @Query(nativeQuery = true,value = "select * from quan_ly_ki_tuc_xa.user where id = :param1")
    User findUserByStudentId(@Param("param1") int param1);
}
