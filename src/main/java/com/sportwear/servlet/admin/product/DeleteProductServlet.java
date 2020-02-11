package com.sportwear.servlet.admin.product;

import com.sportwear.service.OrderService;
import com.sportwear.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/delete-product")
public class DeleteProductServlet extends HttpServlet {

    private ProductService productService = new ProductService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        final Long id = Long.valueOf(request.getParameter("id"));
        productService.remove(id);
        response.sendRedirect("/admin/product-index");
    }
}
