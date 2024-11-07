package com.example.ung_dung_nge_nhac.repository.impl;

import com.example.ung_dung_nge_nhac.model.song;
import com.example.ung_dung_nge_nhac.repository.IMusicAppRepo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.lang.reflect.Type;
import java.util.List;

@Repository
public class MusicAppRepo implements IMusicAppRepo {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<song> selectAllSong() {
        // có 2 cách để sử dụng JPA để thao tác với cơ sở dữ liệu
        // cách 1 dụng JPQL java Persistence query language
        String sql = "select s from song s";
        TypedQuery<song> query = entityManager.createQuery(sql,song.class);
        return query.getResultList();
    }

    @Override
    public boolean add(song songs) {
        return false;
    }
}
