package com.sportwear.servlet.admin.user;

import com.sportwear.entity.User;
import com.sportwear.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@WebServlet("/registration")
//public class UserController extends HttpServlet {
//
//    final String pageRegistration = "/jsp/users.jsp";
//    private UserService userService = new UserService();
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        List<User> users = new ArrayList<>(userService.getAllUser());
//        request.setAttribute("users", users);
//        request.getRequestDispatcher(pageRegistration).forward(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws IOException, ServletException {
//
//        request.setCharacterEncoding("UTF8");
//        final String first_name = request.getParameter("first_name");
//        final String last_name = request.getParameter("last_name");
//        final String email = request.getParameter("email");
//        final String password = request.getParameter("password");
//
//        User user = new User();
//        user.setFirst_name(first_name);
//        user.setLast_name(last_name);
//        user.setEmail(email);
//        user.setPassword(password);
//        userService.add(user);
//        doGet(request, response);
////        response.sendRedirect("/homepage");
//    }
//
//}
