package com.sportwear.servlet.admin.brand;

import com.sportwear.entity.Brand;
import com.sportwear.service.brand.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/update-brand")
public class UpdateBrandServlet extends HttpServlet {

    private BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String id = req.getParameter("id");
        Brand brand = brandService.getOneBrand(Long.valueOf(id));
        req.setAttribute("brand", brand);

        req.getRequestDispatcher("/jsp/admin/manager/brand/update.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        final String name = request.getParameter("name");
        Brand brand = new Brand();
        brand.setName(name);

        final Long id = Long.valueOf(request.getParameter("id"));

        brandService.update(brand, id);

        resp.sendRedirect("/admin/brand-index");
    }
}
