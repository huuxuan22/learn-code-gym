package com.example.spring_mvc.repository;

import com.example.spring_mvc.model.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> showList() {
// JPQL
        String sql = "select s from Student s";
//        String sql = "select s from Student s where s.name like ?1";
        TypedQuery<Student> query = entityManager.createQuery(sql, Student.class);
// HQL - hibernate query language
//        TypedQuery<Student> query = entityManager.createQuery("From Student where name like :name",Student.class);
//        query.setParameter(1, "%a%");
        return query.getResultList();
    }

    @Override
    @Transactional
    @Modifying
    public void add(Student student) {
        entityManager.persist(student);
    }
}
