package com.sportwear.servlet.admin.product;

import com.sportwear.service.product.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/product-index")
public class GetProductServlet extends HttpServlet {

    private ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("products", productService.getAllProduct());
        request.getRequestDispatcher("/jsp/admin/manager/product/add-get-delete.jsp").forward(request, response);
    }
}
