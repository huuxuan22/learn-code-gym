package com.example.furama.repository;

import com.example.furama.model.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentTypeRepo extends JpaRepository<RentType,Integer> {
}
