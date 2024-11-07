package com.example.quan_ly_ky_tuc.repository;

import com.example.quan_ly_ky_tuc.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;


@Repository
public interface IStudentRepo extends JpaRepository<Student,Integer> {
    Page<Student> findByStudentName(Pageable pageable,String name);
@Query(nativeQuery = true, value =
        "SELECT s.id,s.student_id,s.student_name,s.citizenship_id,s.address, s.number_phone,s.birthday ,s.room_id " +
                "FROM student AS s " +
                "INNER JOIN room AS r ON r.room_id = s.room_id " +
                "INNER JOIN floor AS f ON f.floor_id = r.floor_id " +
                "WHERE ( s.address LIKE CONCAT('%', :param1, '%') ) " +
                "   OR ( s.citizenship_id LIKE CONCAT('%', :param1, '%') ) " +
                "   OR ( s.number_phone LIKE CONCAT('%', :param1, '%') ) " +
                "   OR ( s.student_name LIKE CONCAT('%', :param1, '%') ) " +
                "   OR ( r.room_name LIKE CONCAT('%', :param1, '%') ) " +
                "   OR ( f.floor_name LIKE CONCAT('%', :param1, '%') )")
 Page<Student> searchStudent(@Param("param1") String param1, Pageable pageable);
}
