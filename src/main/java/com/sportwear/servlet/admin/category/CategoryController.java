package com.sportwear.servlet.admin.category;

import com.sportwear.entity.Category;
import com.sportwear.entity.User;
import com.sportwear.service.CategoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/category")
//public class CategoryController extends HttpServlet {
//
//    private static final String pageCategory = "/jsp/category.jsp";
//    private CategoryService categoryService = new CategoryService();
//
//    @Override
//    public void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        request.getRequestDispatcher(pageCategory).forward(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF8");
//        final String name = request.getParameter("name");
//
//        Category category = new Category();
//        category.setName(name);
//        categoryService.add(category);
//        response.sendRedirect("/homepage");
//    }
//}
