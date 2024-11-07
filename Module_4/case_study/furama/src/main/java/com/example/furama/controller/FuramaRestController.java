package com.example.furama.controller;

import com.example.furama.model.Facility;
import com.example.furama.model.dto.FacilityDTO;
import com.example.furama.model.utils.DeleteFacility;
import com.example.furama.service.impl.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FuramaRestController {
    @Autowired
    private IFacilityService facilityService;

    @GetMapping("")
    public ResponseEntity showList(@CookieValue(value = "counter",defaultValue = "0") Long counter,
                                   Model model,
                                   @RequestParam(required = false,defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page,5);
        Page<Facility> list = facilityService.findAll(pageable);
        model.addAttribute("list",list);
        model.addAttribute("currentPage",page);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        Facility facility = facilityService.findById(id);
        if (facility == null ){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        facilityService.deleteFacility(facility);
//        DeleteFacility deleteFacility = new DeleteFacility("Bạn đã xóa thành công",facility);
        String msg = "OK";
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<?> search(@RequestParam("valuesSearch") String valueSearch,
                                    Model model,
                                    @RequestParam(required = false,defaultValue = "0") int page){
        String a = valueSearch;
        Pageable pageable = PageRequest.of(page,3);
        Page<Facility> facilityPage = facilityService.search(valueSearch,pageable);
        model.addAttribute("list",facilityPage);
        return new ResponseEntity<>(facilityPage,HttpStatus.OK);
    }
}
