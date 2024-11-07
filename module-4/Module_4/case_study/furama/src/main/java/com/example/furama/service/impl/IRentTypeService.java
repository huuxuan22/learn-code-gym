package com.example.furama.service.impl;

import com.example.furama.model.FacilityType;
import com.example.furama.model.RentType;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IRentTypeService {
    List<RentType> findAllRentType();
}
