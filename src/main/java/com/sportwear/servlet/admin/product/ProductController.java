package com.sportwear.servlet.admin.product;

import com.sportwear.entity.Product;
import com.sportwear.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//@WebServlet("/product")
//public class ProductController extends HttpServlet {
//
//    private static final String pageProduct = "/jsp/product.jsp";
//    private ProductService productService = new ProductService();
//
//    @Override
//    public void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws IOException, ServletException {
//        request.getRequestDispatcher(pageProduct).forward(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF8");
//
//        final String name = request.getParameter("name");
//        final String model = request.getParameter("model");
//        final String sex = request.getParameter("sex");
//        final Byte size = Byte.parseByte(request.getParameter("size"));
//        final Double price = Double.parseDouble(request.getParameter("price"));
//
//        Product product = new Product();
//        product.setName(name);
//        product.setModel(model);
//        product.setSex(sex);
//        product.setSize(size);
//        product.setPrice(price);
//        productService.add(product);
//        response.sendRedirect("/homepage");
//    }
//}
