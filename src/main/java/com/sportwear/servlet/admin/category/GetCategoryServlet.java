package com.sportwear.servlet.admin.category;

import com.sportwear.service.AddressService;
import com.sportwear.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/category-index")
public class GetCategoryServlet extends HttpServlet {

    private CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("categories", categoryService.getAllCategory());
        request.getRequestDispatcher("/jsp/admin/manager/category/add-get-delete.jsp").forward(request, response);
    }
}
