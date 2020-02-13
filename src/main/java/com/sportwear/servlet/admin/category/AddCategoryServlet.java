package com.sportwear.servlet.admin.category;

import com.sportwear.entity.Category;
import com.sportwear.service.category.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/add-category")
public class AddCategoryServlet extends HttpServlet {

    private CategoryService categoryService = new CategoryService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final String pageBrand = "/jsp/admin/manager/category/add-get-delete.jsp";
        request.getRequestDispatcher(pageBrand).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");

        Category category = new Category();
        category.setName(request.getParameter("name"));

        categoryService.add(category);
        response.sendRedirect("/admin/category-index");
    }
}
