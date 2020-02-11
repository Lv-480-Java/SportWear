package com.sportwear.servlet.admin.brand;

import com.sportwear.entity.Brand;
import com.sportwear.service.BrandService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/brand-add")
//public class BrandController extends HttpServlet {
//    private static final String pageBrand = "/jsp/admin/manager/brand.jsp";
//    private BrandService brandService = new BrandService();
//
//    @Override
//    public void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws IOException, ServletException {
//        request.getRequestDispatcher(pageBrand).forward(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF8");
//        final String name = request.getParameter("name");
//
//        Brand brand = new Brand();
//        brand.setName(name);
//        brandService.add(brand);
//        response.sendRedirect("/homepage");
//    }
//}
