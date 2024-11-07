package com.example.furama.controller;

import com.example.furama.model.Facility;
import com.example.furama.model.dto.FacilityDTO;
import com.example.furama.service.impl.IFacilityService;
import com.example.furama.service.impl.IFacilityTypeService;
import com.example.furama.service.impl.IRentTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
public class FuramaController {
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IRentTypeService rentTypeService;
    @Autowired
    private IFacilityTypeService facilityTypeService;
    @GetMapping({"","/"})
    public String showAllFacility(Model model, @RequestParam(required = false,defaultValue = "0")int page) {
        Sort sort  = Sort.by("id").descending();
        Pageable pageable = PageRequest.of(page,5,sort);
        Page<Facility> list = facilityService.findAll(pageable);
        model.addAttribute("list",list);
        model.addAttribute("currentPage",page);
        return "facility-page";
    }

    @PostMapping("/delete/")
    public String deleteService(@RequestParam("id") String  id, RedirectAttributes redirectAttributes){
        facilityService.deleteOneFacility(Integer.parseInt(id));
        redirectAttributes.addFlashAttribute("mess","ok");
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable String id,Model model){
        model.addAttribute("listFacilityType",facilityTypeService.findAllFacilityType());
        model.addAttribute("listRentType",rentTypeService.findAllRentType());
        Facility facility = facilityService.findById(Integer.parseInt(id));
//        model.addAttribute("facility",facility);
        FacilityDTO facilityDTO = new FacilityDTO();
        BeanUtils.copyProperties(facility,facilityDTO);
        model.addAttribute("facilityDTO",facilityDTO);

        return "facility-update";
    }
    @PostMapping("/updateFacility")
    public String update(@Valid @ModelAttribute("facilityDTO")FacilityDTO facilityDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,Model model){
        new FacilityDTO().validate(facilityDTO,bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("listFacilityType",facilityTypeService.findAllFacilityType());
            model.addAttribute("listRentType",rentTypeService.findAllRentType());
            return "facility-update";
        }
        Facility facilitys = new Facility();
        BeanUtils.copyProperties(facilityDTO,facilitys);
        facilityService.updateFacility(facilitys);
        redirectAttributes.addFlashAttribute("msgUpdate","Bạn đã cập nhật thành công");
        return  "redirect:/";
    }


//    đây là phần thêm mới
    @GetMapping("addNew")
    public String addNewService(Model model){
        model.addAttribute("listFacilityType",facilityTypeService.findAllFacilityType());
        model.addAttribute("listRentType",rentTypeService.findAllRentType());
        model.addAttribute("facility",new Facility());
        model.addAttribute("facilityDTO", new FacilityDTO());
        return "facility-addNew";
    }
    @PostMapping("/addNewService")
    public String addNewService(@Valid @ModelAttribute("facilityDTO") FacilityDTO facilityDTO,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                Model model){
        new FacilityDTO().validate(facilityDTO,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("listFacilityType",facilityTypeService.findAllFacilityType());
            model.addAttribute("listRentType",rentTypeService.findAllRentType());
            model.addAttribute("facility",new Facility());
            return "facility-addNew";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDTO,facility);
        facilityService.add(facility);
        redirectAttributes.addFlashAttribute("msg","thêm mới thành công");
        return "redirect:/";
    }

    @PostMapping("/search/{valuesSearch}")
    public String search(Model model,@RequestParam("valuesSearch") String valuesSearch, @RequestParam(required = false,defaultValue = "0")int page) {
        Sort sort = Sort.by("id").descending();
        Pageable pageable = PageRequest.of(page,5,sort);
        Page<Facility> facilityPage = facilityService.search(valuesSearch,pageable);
        model.addAttribute("list",facilityPage);
        model.addAttribute("currentPage",page);
        return "facility-page";
    }
}
