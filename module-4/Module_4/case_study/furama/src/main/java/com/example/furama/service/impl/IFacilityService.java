package com.example.furama.service.impl;

import com.example.furama.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IFacilityService {
    Page<Facility> findAll(Pageable pageable);
    void deleteOneFacility(int id);
    void deleteFacility(Facility facility);
    Facility findById(int id);
    void updateFacility(Facility facility);
    void add(Facility facility);
    Page<Facility> search(String valueSeach,Pageable pageable);
}
