package com.example.quan_ly_ky_tuc.controller;

import com.example.quan_ly_ky_tuc.dto.StudentDTO;
import com.example.quan_ly_ky_tuc.model.Student;
import com.example.quan_ly_ky_tuc.model.User;
import com.example.quan_ly_ky_tuc.repository.IRoomRepo;
import com.example.quan_ly_ky_tuc.service.IRoomService;
import com.example.quan_ly_ky_tuc.service.IStudentService;
import com.example.quan_ly_ky_tuc.service.IUserService;
import com.example.quan_ly_ky_tuc.util.DateConverter;
import com.fasterxml.jackson.databind.util.BeanUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

@Controller
@SessionAttributes("user")
@RequestMapping("/")
public class DormitoryController {
    @Autowired
    private IStudentService iStudentService;

    @Autowired
    private IRoomService roomService;

    @Autowired
    private IUserService userService;

        @ModelAttribute("user")
        public User getUser(@CookieValue(value = "account",required = false,defaultValue = "") String account,
                            @CookieValue(value = "password",required = false,defaultValue = "")String password){
            return new User(account,password);
        }
        @GetMapping("")
        public ModelAndView FormLorgin(@ModelAttribute("user") User user){
            if (!Objects.equals(user.getAcount(),"") && !Objects.equals(user.getPassWord(),"")){
                return new ModelAndView("/login","user",new User(user.getAcount(),user.getPassWord()));
            }
            return new ModelAndView("/login","user",new User(user.getAcount(),user.getPassWord()));
        }
        @PostMapping("Log")
        public String Log(@ModelAttribute("user") User user,
                          @RequestParam(value = "remember-me",required = false,defaultValue = "")boolean remember,
                          HttpServletResponse httpServletResponse,
                          RedirectAttributes redirectAttributes){
//            List<User> users = userService.getAllUser();
//            if (user != null && user.getAcount() != null && !user.getAcount().isEmpty() &&
//                    user.getPassWord() != null && !user.getPassWord().isEmpty()){
//                    Boolean user1 = userService.findById(user.getAcount());
//                    if (user1 != false) {
//                        httpSession.setAttribute("lorginUser",user1);
//                        return "redirect:/homepage";
//                    }
//            }
            Boolean flag = userService.findByIds(user.getAcount());
            if (flag) {
                if (remember) {
                    Cookie cookieAccount = new Cookie("account",user.getAcount());
                    Cookie cookiePassWord = new Cookie("password",user.getPassWord());
                    cookieAccount.setMaxAge(24);
                    cookiePassWord.setMaxAge(24);
                    httpServletResponse.addCookie(cookieAccount);
                    httpServletResponse.addCookie(cookiePassWord);
                }
                return "redirect:/homepage";
            }
            return  "/homepage";
        }

        @GetMapping("homepage")
        public String showList(@CookieValue(value = "counter",
                                defaultValue = "0") Long counter,
                               Model model,
                               @RequestParam(required = false,defaultValue = "0") int page){



            Pageable pageable =  PageRequest.of(page,2);
            Page<Student> list = iStudentService.showList(pageable);
//            model.addAttribute("cookie",counter);
            model.addAttribute("list",list);
            model.addAttribute("currentPage",page);

//            List<Student> studentList = iStudentService.showList();
            return "home";
        }

            @GetMapping("/update/{id}")
            public String showFormUpdate(@PathVariable String id,Model model) {
                int ids = Integer.parseInt(id);
                model.addAttribute("student",iStudentService.findById(ids));
                model.addAttribute("listRoom",roomService.getAllRoom());
            return "formUpdate";
        }

        @PostMapping("/updateStudent")
        public String update(@Valid @ModelAttribute("student") StudentDTO studentDTO,
                               BindingResult bindingResult,
                                RedirectAttributes redirectAttributes ,Model model){
                new StudentDTO().validate(studentDTO,bindingResult);
                if (bindingResult.hasErrors()){
                    model.addAttribute("listRoom",roomService.getAllRoom());
                    return "formUpdate";
                }
                Student student = new Student();
                BeanUtils.copyProperties(studentDTO,student);
                iStudentService.delete(student);
                iStudentService.update(student);
            return "redirect:/";
        }

        @GetMapping("/addNew")
        public String showFormAdd(
                                    Model model){
            model.addAttribute("listRoom",roomService.getAllRoom());
            model.addAttribute("student",new Student());
            return "add";
        }

        @PostMapping("/save")
        public String save(@Valid @ModelAttribute("student") StudentDTO studentDTO
                            , BindingResult bindingResult,
                            RedirectAttributes redirectAttributes, Model model) {
            new StudentDTO().validate(studentDTO,bindingResult);
            if (bindingResult.hasErrors()){
                model.addAttribute("listRoom",roomService.getAllRoom());
                return "add";
            }
//            java.sql.Date convertedBirthday =  DateConverter.convertStringToDate(String.valueOf(student.getBirthday()));
//            student.setBirthday(convertedBirthday);
            Student student = new Student();
            BeanUtils.copyProperties(studentDTO,student);
            iStudentService.update(student);
            redirectAttributes.addFlashAttribute("msg","Theem moi thanh cong");
            return "redirect:/home";
        }

        @PostMapping("/delete/{id}")
        public String delete(@PathVariable String id) {
            int ids = Integer.parseInt(id);

            return "redirect:/";
        }

//    int id, String studentId, String studentName, String citizenshipId, String address, String numberPhone, Date birthday, Room room
        @PostMapping("/search")
        public String search(
                            @RequestParam(name = "name", required = false) String name
                            ,@RequestParam (required = false,defaultValue = "0") int page
                            , Model model) {
            Sort sort = Sort.by("id").ascending();
            Pageable pageable = PageRequest.of(page,2,sort);
            Page<Student> studentList =  iStudentService.search(name,pageable);
            model.addAttribute("list",studentList);
//            int currentPage = 0;
            model.addAttribute("searchValue",name);
            model.addAttribute("currentPage",page);
            return "home";
        }
}
