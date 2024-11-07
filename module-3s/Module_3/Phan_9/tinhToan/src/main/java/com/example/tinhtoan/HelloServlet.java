package com.example.tinhtoan;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String num1Str = request.getParameter("num1");
        String num2Str = request.getParameter("num2");

        try {
            // Chuyển đổi giá trị từ chuỗi sang số
            int num1 = Integer.parseInt(num1Str);
            int num2 = Integer.parseInt(num2Str);

            // Thực hiện phép cộng
            int sum = num1 + num2;

            // Lưu kết quả vào request để hiển thị trên trang result.jsp
            request.setAttribute("sumResult", sum);

            // Chuyển hướng đến trang result.jsp
            request.getRequestDispatcher("result1.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            // Xử lý lỗi nếu nhập liệu không phải là số
            response.getWriter().println("Vui lòng nhập số hợp lệ.");
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

    }

    public void destroy() {
    }
}