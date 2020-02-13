package com.sportwear.servlet.admin.brand;

import com.sportwear.service.brand.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/brand-index")
public class GetBrandServlet extends HttpServlet {

    private BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("brands", brandService.getAllBrand());
        request.getRequestDispatcher("/jsp/admin/manager/brand/add-get-delete.jsp").forward(request, response);
    }
}
