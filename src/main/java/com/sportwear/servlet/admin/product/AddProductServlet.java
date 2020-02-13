package com.sportwear.servlet.admin.product;

import com.sportwear.entity.Product;
import com.sportwear.service.product.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/add-product")
public class AddProductServlet extends HttpServlet {

    private ProductService productService = new ProductService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final String pageBrand = "/jsp/admin/manager/product/add-get-delete.jsp";
        request.getRequestDispatcher(pageBrand).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");

        Product product = new Product();
        product.setName(request.getParameter("name"));
        product.setModel(request.getParameter("model"));
        product.setSex(request.getParameter("sex"));
        product.setSize(Byte.valueOf(request.getParameter("size")));
        product.setColor_id(Long.valueOf(request.getParameter("color_id")));
        product.setPrice(Double.valueOf(request.getParameter("price")));
        product.setCategory_id(Long.valueOf(request.getParameter("category_id")));
        product.setBrand_id(Long.valueOf(request.getParameter("brand_id")));


        productService.add(product);
        response.sendRedirect("/admin/product-index");
    }
}
