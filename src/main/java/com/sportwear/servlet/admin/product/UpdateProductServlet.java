package com.sportwear.servlet.admin.product;

import com.sportwear.entity.Product;
import com.sportwear.service.product.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/update-product")
public class UpdateProductServlet extends HttpServlet {

    private ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String id = req.getParameter("id");
        Product product = productService.getOneProduct(Long.valueOf(id));
        req.setAttribute("product", product);

        req.getRequestDispatcher("/jsp/admin/manager/product/update.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        final String name = req.getParameter("name");
        final String model = req.getParameter("model");
        final String sex = req.getParameter("sex");
        final Byte size = Byte.valueOf(req.getParameter("size"));
        final Long color_id = Long.valueOf(req.getParameter("color_id"));
        final Double price = Double.valueOf(req.getParameter("price"));
        final Long category_id = Long.valueOf(req.getParameter("category_id"));
        final Long brand_id = Long.valueOf(req.getParameter("brand_id"));

        Product product = new Product();
        product.setName(name);
        product.setModel(model);
        product.setSex(sex);
        product.setSize(size);
        product.setColor_id(color_id);
        product.setPrice(price);
        product.setCategory_id(category_id);
        product.setBrand_id(brand_id);

        Long id = Long.valueOf(req.getParameter("id"));

        productService.update(product, id);

        resp.sendRedirect("/admin/product-index");
    }
}
