package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.IProductService;
import com.example.demo.service.impl.ProductService;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@WebServlet(urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
//    private Connection con;
//    Statement stmt = con.createStatement();
    private IProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            action = "";
        }
        switch (action){
            case "add":
                showAddForm(req,resp);
                // thêm mới
                break;
            case "delete":
                showDeleteForm(req,resp);
                // xóa
                break;
            case "update":
                showUpdateForm(req,resp);
                break;
            default:
                showList(req,resp);
        }
    }

    private void showUpdateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/Product/update.jsp");
        requestDispatcher.forward(req,resp);

    }


    private void showDeleteForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/Product/delete.jsp");
        requestDispatcher.forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "add":
                Save(req,resp);
                break;
            case "delete":
                Delete(req,resp);
                break;
                // xóa
            case "update":
                Update(req,resp);
                break;
            default:
        }
    }

    private void Update(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String name = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));
        String producer = req.getParameter("producer");
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = new Product(id,name,price,producer);

        Product productList = productService.findById(id);
        String mess = "object not in list";
        if (productList != null){
            mess = "add new succes!!!";
            productService.update(product);
        }
        try {
            resp.sendRedirect("/product?mess="+ mess);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void Delete(HttpServletRequest req, HttpServletResponse resp) {
        int idProduct = Integer.parseInt(req.getParameter("idDelete"));
        boolean isSucces = productService.delete(idProduct);
        String mess = "Them moi thanh cong";
        if (!isSucces){
            mess = "Them moi khong thanh cong";
        } try {
            resp.sendRedirect("/product?message="+ mess);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void Save(HttpServletRequest req, HttpServletResponse resp) {
        int idProduct = Integer.parseInt(req.getParameter("id"));
        String nameProduct = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));
        String producer = req.getParameter("producer");
        Product product = new Product(idProduct,nameProduct,price,producer);
        boolean isSuccess = productService.add(product);
        String message = "thanh công";
        if (!isSuccess){
            message = "thất bại";
        }
        try {
            resp.sendRedirect("/product?mess="+message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/Product/list.jsp");
        req.setAttribute("productList",productService.findAll());
        try {
            requestDispatcher.forward(req,resp);
        }catch (IOException e){
            throw  new RuntimeException();
        }catch (ServletException e){
            throw new RuntimeException();
        }
    }

    private void showAddForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/Product/add.jsp");
        requestDispatcher.forward(req,resp);
    }
}

