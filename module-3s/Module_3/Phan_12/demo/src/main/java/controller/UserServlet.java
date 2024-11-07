package controller;

import model.User;
import service.IUserService;
import service.impl.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    private IUserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action) {
            case "add":
                showAddForm(req,resp);
                break;
            case "update":
                showUpdateForm(req,resp);
                break;

            default:
                showList(req,resp);
        }
    }

    private void showUpdateForm(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/update.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showAddForm(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/add.jsp");
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
        req.setAttribute("userList",userService.findAll());
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
        if(action == null){
            action = "";
        }
        switch (action){
            case "save":
                save(req,resp);
                break;
            case "update":
                update(req,resp);
                break;
            case "delete":
                deleteUsers(req,resp);
                break;
            case "search":
//                searchById(req,resp);
                  searchByName(req,resp);
                break;
            default:
                showList(req,resp);

        }
    }

    private void searchByName(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        List<User> userList = userService.searchByName(name);
        req.setAttribute("userList",userList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/searchById.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        int flag = 0;
//        if (userList.size() != 0){
//            flag = 1;
//        }
//        try {
//            resp.sendRedirect("/user?flag="+flag);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    private void searchById(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("idSearch"));
        List<User> userList =  userService.searchUserById(id);
        req.setAttribute("userList",userList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/searchById.jsp");
        try {
            try {
                requestDispatcher.forward(req,resp);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteUsers(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("idDelete"));
        userService.deleteUser(id);
        req.setAttribute("userList",userService.findAll());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/list.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) {
        resp.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("idUpdate"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        User user = new User(id,name,email,country);

        Boolean isSucces = userService.userUpdate(user);
        String mess = "Thành công";
        if (isSucces){
            mess = "Không thành công";
        }
        try {
            resp.sendRedirect("/user?mess="+ mess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name  = req.getParameter("name");
        String country = req.getParameter("country");
        String email = req.getParameter("email");
        User user = new User(id,name,email ,country);
        boolean isSucces = userService.insertUser(user);
        String mess = "add New not succes ";
        if (isSucces){
            mess = "add new succes";
        }
        try {
            resp.sendRedirect("/user?mess=" + mess);

        }catch (IOException e){
            throw  new RuntimeException();
        }
    }
}
