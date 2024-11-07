package com.example.furama.model.dto;

import com.example.furama.model.FacilityType;
import com.example.furama.model.RentType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class FacilityDTO implements Validator {

    private int id;
    @NotBlank(message = "Vui lòng nhập mã sinh viên")
    private String name;

    @NotNull(message = "Vui lòng nhập diện tích ")
    @Min(value = 1, message = "Diện tích phải lớn hơn 0")
    @Digits(integer = 10, fraction = 0, message = "Diện tích phải là số nguyên dương")
    private Integer area;

    @NotNull(message = "Vui lòng nhập Vào giá cả ")
    @Min(value = 1, message = "Bạn nhập giá cả không đúng")
    @Digits(integer = 10, fraction = 0, message = "Giá tiền là số nguyên dương")
    private Double cost;

    private Integer peopleMax;
    private FacilityType facilityType;

    private RentType rentType;
    @NotBlank(message = "Hãy nhập vào tiêu chuẩn phòng")
    private String standardRoom;

    @NotBlank(message = "Vui lòng nhập các tiện ích khác")
    private String descriptionOtherConvenience;

    @NotNull(message = "Vui lòng nhập diện tích hồ bơi")
    @DecimalMin(value = "0.0", inclusive = false, message = "Diện tích hồ bơi phải lớn hơn 0")
    private Double poolArea;

    @NotNull(message = "Hãy nhập vào số tầng")
    @Min(value = 1, message = "Số tầng phải lớn hơn 0")
    private Integer numberOfFloors;

    private String facilityFree;

    public FacilityDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getPeopleMax() {
        return peopleMax;
    }

    public void setPeopleMax(Integer peopleMax) {
        this.peopleMax = peopleMax;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public FacilityDTO(int id, String name, Integer area, Double cost, Integer peopleMax, FacilityType facilityType, RentType rentType, String standardRoom, String descriptionOtherConvenience, Double poolArea, Integer numberOfFloors, String facilityFree) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.peopleMax = peopleMax;
        this.facilityType = facilityType;
        this.rentType = rentType;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.facilityFree = facilityFree;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDTO facilityDTO = (FacilityDTO) target;
    }
}


