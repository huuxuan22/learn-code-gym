package com.example.furama.repository;

import com.example.furama.model.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityTypeRepo extends JpaRepository<FacilityType,Integer> {
}
