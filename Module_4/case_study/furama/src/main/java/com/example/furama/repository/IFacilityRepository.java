package com.example.furama.repository;

import com.example.furama.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IFacilityRepository extends JpaRepository<Facility,Integer> {
    Page<Facility> findAll(Pageable pageable);

    @Override
    void deleteById(Integer integer);

    @Query(nativeQuery = true, value =
            "select f.* from facility as f \n" +
                    "\tinner join facility_type as ft on f.facility_type_id = ft.facility_type_id\n" +
                    "\tinner join rent_type as rt on rt.rent_type_id = f.rent_type_id\n" +
                    "\twhere f.description_other_convenience like concat('%',:param,'%')\n" +
                    "\tor\t\tf.number_of_floors like :param\n" +
                    "\tor\t\tf.standard_room like concat('%',:param,'%')\n" +
                    "\tor \t\trt.name like concat('%',:param,'%')\n" +
                    "\tor \t\tft.name like concat('%',:param,'%')\t ")
    Page<Facility> search(@Param("param") String param, Pageable pageable);



}
