package com.example.demo1;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "HelloServlet", value = "/CalculateServlet")
public class HelloServlet extends HttpServlet {
    private String message;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num1Str = req.getParameter("num1");
        String num2Str = req.getParameter("num2");

        try {
            // Chuyển đổi giá trị từ chuỗi sang số
            int num1 = Integer.parseInt(num1Str);
            int num2 = Integer.parseInt(num2Str);

            // Thực hiện phép cộng
            int sum = num1 + num2;

            // Lưu kết quả vào request để hiển thị trên trang result.jsp
            req.setAttribute("sum", sum);

            // Chuyển hướng đến trang result.jsp
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("result.jsp");
            requestDispatcher.forward(req,resp);
        } catch (NumberFormatException | ServletException e) {
            // Xử lý lỗi nếu nhập liệu không phải là số
            resp.getWriter().println("Vui lòng nhập số hợp lệ.");
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

}