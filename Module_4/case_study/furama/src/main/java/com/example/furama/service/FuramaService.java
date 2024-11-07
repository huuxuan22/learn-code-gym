package com.example.furama.service;

import com.example.furama.model.Facility;
import com.example.furama.model.FacilityType;
import com.example.furama.model.RentType;
import com.example.furama.repository.IFacilityRepository;
import com.example.furama.repository.IFacilityTypeRepo;
import com.example.furama.repository.IRentTypeRepo;
import com.example.furama.service.impl.IFacilityService;
import com.example.furama.service.impl.IFacilityTypeService;
import com.example.furama.service.impl.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FuramaService implements IFacilityService, IFacilityTypeService,IRentTypeService {
    @Autowired
    private IFacilityRepository facilityRepository;
    @Autowired
    private IFacilityTypeRepo facilityTypeRepo;
    @Autowired
    private IRentTypeRepo rentTypeRepo;
    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return facilityRepository.findAll(pageable);
    }

    @Override
    public void deleteOneFacility(int id) {
        facilityRepository.deleteById(id);
    }

    @Override
    public void deleteFacility(Facility facility) {
        facilityRepository.delete(facility);
    }

    @Override
    public Facility findById(int id) {
        return facilityRepository.findById(id).orElse(null);
    }

    @Override
    public void updateFacility(Facility facility) {
         facilityRepository.save(facility);
    }

    @Override
    public void add(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public Page<Facility> search(String valueSeach,Pageable pageable) {
        return facilityRepository.search(valueSeach,pageable);
    }


    @Override
    public List<FacilityType> findAllFacilityType() {
        return facilityTypeRepo.findAll();
    }

    @Override
    public List<RentType> findAllRentType() {
        return rentTypeRepo.findAll();
    }
}
