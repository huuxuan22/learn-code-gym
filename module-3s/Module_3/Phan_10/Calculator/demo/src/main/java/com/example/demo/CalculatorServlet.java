package com.example.demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/calculator")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
    float add(int num1,int num2){
       return (float) (num1+num2) ;
    }

    float minus(int num1,int num2){
        return (float) (num1-num2) ;
    }

    float mutyl(int num1,int num2){
        return (float) (num1*num2) ;
    }

    float div(int num1,int num2){
        return (float) (num1/num2) ;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int number1 = Integer.parseInt(req.getParameter("number1"));
       int number2 = Integer.parseInt(req.getParameter("number2"));
       req.setAttribute("num1",number1);
       req.setAttribute("num2",number2);

       float result = 0;
       String choose = req.getParameter("choose");
       if (choose.equals("add")){
           result = add(number1,number2);
       } else if (choose.equals("minus")) {
           result = minus(number1,number2);
       }else if (choose.equals("mutyl")){
           result = mutyl(number1,number2);
       }else {
           result = div(number1,number2);
       }
        req.setAttribute("result",result);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("result.jsp");
        requestDispatcher.forward(req,resp);
    }
}
