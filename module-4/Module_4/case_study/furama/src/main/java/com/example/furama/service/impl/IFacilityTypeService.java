package com.example.furama.service.impl;

import com.example.furama.model.FacilityType;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IFacilityTypeService {
    List<FacilityType> findAllFacilityType();

}
