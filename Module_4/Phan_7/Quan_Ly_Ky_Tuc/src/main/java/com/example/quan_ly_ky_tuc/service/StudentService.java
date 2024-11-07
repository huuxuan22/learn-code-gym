package com.example.quan_ly_ky_tuc.service;

import com.example.quan_ly_ky_tuc.model.Student;
import com.example.quan_ly_ky_tuc.model.User;
import com.example.quan_ly_ky_tuc.repository.IStudentRepo;
import com.example.quan_ly_ky_tuc.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class StudentService  implements IStudentService{

    @Autowired
    private IStudentRepo iStudentRepo;

    @Autowired
    private IUserRepo iUserRepo;

//    @Override
//    public List<Student> showList() {
//        return iStudentRepo.findAll();
//    }

    @Override
    public Student findById(int id) {
        return iStudentRepo.findById(id).orElse(null);
    }

    @Override
    public Student  update(Student student) {
        return this.iStudentRepo.save(student);
    }
    @Override
    public void add(Student student) {
        iStudentRepo.save(student);
    }

    @Override
    public Page<Student> searchByName(String name,Pageable pageable) {
        return iStudentRepo.findByStudentName(pageable,name);
    }


    @Override
    public Page<Student> showList(Pageable pageable) {
        return iStudentRepo.findAll((org.springframework.data.domain.Pageable) pageable);
    }

    @Override
    public Page<Student> search(String param1, Pageable pageable) {
        return iStudentRepo.searchStudent(param1,pageable);
    }

    @Override
    public void delete(Student student){
        User user = iUserRepo.findUserByStudentId(student.getId());
        if (user != null) {
            iUserRepo.delete(user);
            iStudentRepo.delete(student);
        }
    }
}
