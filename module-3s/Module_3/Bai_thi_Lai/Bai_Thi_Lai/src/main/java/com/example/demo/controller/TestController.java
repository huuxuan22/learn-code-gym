package com.example.demo.controller;

import com.example.demo.model.HocSinh;
import com.example.demo.model.MuonSach;
import com.example.demo.model.ThongKe;
import com.example.demo.service.ILibraryService;
import com.example.demo.service.impl.LibraryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/test")
public class TestController extends HttpServlet {
    private ILibraryService libraryService = new LibraryService();
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
            default:
        }
    }

    private void showFormThongKe(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/thongKe.jsp");
        req.setAttribute("thongKe",libraryService.SelectAll());
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) {
//        String messDelete = "xoa thanh cong";
        try {
            resp.sendRedirect("/test");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) {
//        String messUpdate = "cap nhat thanh cong";
        try {
            resp.sendRedirect("/test");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) {
        String messAdd = "Them moi khong thanh cong";
        String maMuonSach = req.getParameter("maMuonSach");
        int idHocSinh = Integer.parseInt(req.getParameter("idHocSinh"));
        int idSach = Integer.parseInt(req.getParameter("idSach"));
        String ngayMuon = req.getParameter("ngayMuonSach");
        String ngayTra = req.getParameter("ngayTraSach");
        String trangThai = "1";
        int idMuonSach = libraryService.idMax();
        boolean flag = libraryService.addMuonSach(new MuonSach(idMuonSach,idSach,idHocSinh,maMuonSach,trangThai,ngayMuon,ngayTra));

        if (flag){
            messAdd = "them thanh cong";
        }
        try {
            resp.sendRedirect("/test?messAdd"+messAdd);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "showFormMuon":
                showFormMuon(req,resp);
                break;
            case "showFormThongKe":
                showFormThongKe(req,resp);
                break;
            default:
                showList(req,resp);
        }
    }

    private void showFormMuon(HttpServletRequest req, HttpServletResponse resp) {
        String maMuonSach = req.getParameter("maMuonSach");
        String tenSach = req.getParameter("tenSach");
        String idSach = req.getParameter("idSach");
        List<HocSinh> hocSinhList = libraryService.selectAllHS();

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/add.jsp");
        req.setAttribute("maMuonSach",maMuonSach);
        req.setAttribute("tenSach",tenSach);
        req.setAttribute("idSach",idSach);
        req.setAttribute("hocSinhList",hocSinhList);
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
        req.setAttribute("sachList",libraryService.selectAllSach());
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
