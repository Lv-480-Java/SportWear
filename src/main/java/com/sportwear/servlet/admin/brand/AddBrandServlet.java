package com.sportwear.servlet.admin.brand;

import com.sportwear.entity.Brand;
import com.sportwear.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/add-brand")
public class AddBrandServlet extends HttpServlet {

    private BrandService brandService = new BrandService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final String pageBrand = "/jsp/admin/manager/brand/add-get-delete.jsp";
        request.getRequestDispatcher(pageBrand).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");

        Brand brand = new Brand();
        brand.setName(request.getParameter("name"));

        brandService.add(brand);
        response.sendRedirect("/admin/brand-index");
    }
}
