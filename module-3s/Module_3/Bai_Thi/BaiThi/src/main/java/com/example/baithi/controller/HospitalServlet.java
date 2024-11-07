package com.example.baithi.controller;

import com.example.baithi.model.BenhAn;
import com.example.baithi.service.IHospitalService;
import com.example.baithi.service.impl.HospitalService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/test")
public class HospitalServlet extends HttpServlet {
    private IHospitalService hospitalService = new HospitalService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action== null) {
            action = "";
        }
        switch (action) {
            case "add":
                showFormAdd(req,resp);
                break;
            case "showFormUpdate":
                // hiển thị form cập nhật
                showFormUpdate(req,resp);
                break;

            default:
                showList(req,resp);
        }
    }

    private void showFormAdd(HttpServletRequest req, HttpServletResponse resp) {
       RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/add.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showFormUpdate(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/update.jsp");
        String idBenhAn = req.getParameter("idUpdate");
        String idBenhNhan = req.getParameter("idBenhNhan");
        req.setAttribute("idMaxBN",hospitalService.findIdMaxBN());
        req.setAttribute("idUpdate",idBenhAn);
        req.setAttribute("idBenhNhan",idBenhNhan);
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/list.jsp");
        req.setAttribute("benhAnList",hospitalService.selectAll());
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "save":
                save(req,resp);
                break;
            case "update":
                // cập nhật
                update(req,resp);
                break;
            case "delete":
                delete(req,resp);
                // xóa
                break;
            case "search":
                // tìm kiếm
                search(req,resp);
                break;
            default:
        }
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) {
//        int idBenhNhan = hospitalService.findIdMaxBN();
//        int idBenhAn = hospitalService.findIdMaxBA();
//        String maBenhNhan = req.getParameter("maBenhAn");
//        String maBenhAn = req.getParameter("maBenhNhan");
//        String tenBenhNhan = req.getParameter("tenBenhNhan");
//        String ngayNhapVien = req.getParameter("ngayNhapVien");
//        String ngayRaVien = req.getParameter("ngayRaVien");
//        String lyDo = req.getParameter("lyDo");
//
//        boolean flag = hospitalService.add(new BenhAn(idBenhAn,idBenhNhan,maBenhAn,maBenhNhan,tenBenhNhan,ngayNhapVien,ngayRaVien,lyDo));
        String messAdd = "then noi khong thanh cong";
//        if (flag){
//            messAdd = "them moi thanh cong";
//        }
        try {
            resp.sendRedirect("/test?messAdd"+messAdd);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void update(HttpServletRequest req, HttpServletResponse resp) {
        int idBenhAn = Integer.parseInt(req.getParameter("idBenhAn"));
        int idBenhNhan = Integer.parseInt(req.getParameter("idBenhNhan"));
        String maBenhNhan = req.getParameter("maBenhNhan");
        String maBenhAn = req.getParameter("maBenhAn");
        String tenBenhNhan = req.getParameter("tenBenhNhan");
//        String tenBenhAn = req.getParameter("tenBenhAn");
        String ngayNhapVien = req.getParameter("ngayNhapVien");
        String ngayRaVien =req.getParameter("ngayRaVien");
        String lyDo = req.getParameter("lyDo");
        boolean check = hospitalService.update(idBenhAn,idBenhNhan,maBenhAn,maBenhNhan,tenBenhNhan,ngayNhapVien,ngayRaVien,lyDo);
        String mess = "them moi khong thanh cong";
        if (check){
            mess = "them moi khong thanh cong";
        }

        try {
            resp.sendRedirect("/test?messUpdate="+mess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) {
        int idBenhAn = Integer.parseInt(req.getParameter("idBenhAn"));
        boolean flag = hospitalService.delete(idBenhAn);
        String mess = "xoa khong thanh cong";
        if (flag) {
            mess = "Xoa thanh cong";
        }
        try {
            resp.sendRedirect("/test?mess="+mess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/search.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
