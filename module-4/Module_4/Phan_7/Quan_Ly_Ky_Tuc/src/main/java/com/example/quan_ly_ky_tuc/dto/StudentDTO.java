package com.example.quan_ly_ky_tuc.dto;

import com.example.quan_ly_ky_tuc.model.Room;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.sql.Date;

public class StudentDTO implements Validator {
    private int id;

    @NotBlank(message = "Vui lòng nhập mã sinh viên")
    @Pattern(regexp = "^\\d{10}$", message = "vui lòng nhập đúng định dạng mã sinh viên gồm 10 số")
    private String studentId;

    @NotBlank(message = "vui lòng nhập tên sinh viên")
    private String studentName;

    @NotBlank(message = "Vui lòng nhập căn cước công dân")
    @Pattern(regexp = "^\\d{10}$", message = "vui lòng nhập đúng định dạng căn cước công dân gồm có 10 số ")
    private String citizenshipId;

    @NotEmpty(message = "Vui lòng nhập địa chỉ")
    private String address;

    @NotBlank(message = "Vui lòng nhập Số điện thoại")
    @Pattern(regexp = "^\\d{10}$", message = "vui lòng nhập đúng định dạng số điện thoại")
    private String numberPhone;


    private Date birthday;

    @NotNull(message = "vui lòng nhập lại")
    private Room room;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public StudentDTO(int id, String studentId, String studentName, String citizenshipId, String address, String numberPhone, Date birthday, Room room) {
        this.id = id;
        this.studentId = studentId;
        this.studentName = studentName;
        this.citizenshipId = citizenshipId;
        this.address = address;
        this.numberPhone = numberPhone;
        this.birthday = birthday;
        this.room = room;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCitizenshipId() {
        return citizenshipId;
    }

    public void setCitizenshipId(String citizenshipId) {
        this.citizenshipId = citizenshipId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public boolean supports(Class<?> clazz) {
        return false;
    }

    public StudentDTO() {
    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentDTO studentDTO = (StudentDTO) target;
        if ("".equals(studentDTO.getAddress())){
            errors.rejectValue("address","","Vui lòng nhập lại địa chỉ");
        }
    }
}
