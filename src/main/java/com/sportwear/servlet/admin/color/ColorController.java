package com.sportwear.servlet.admin.color;

import com.sportwear.entity.Color;
import com.sportwear.service.ColorService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/color")
//public class ColorController extends HttpServlet {
//    private static final String pageColor = "/jsp/color.jsp";
//    private ColorService colorService = new ColorService();
//
//    @Override
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        request.getRequestDispatcher(pageColor).forward(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF8");
//        final String name = request.getParameter("name");
//
//        Color color = new Color();
//        color.setName(name);
//        colorService.add(color);
//        response.sendRedirect("/homepage");
//    }
//}
