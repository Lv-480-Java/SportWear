package com.sportwear.servlet.admin.category;

import com.sportwear.entity.Category;
import com.sportwear.service.category.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/update-category")
public class UpdateCategoryServlet extends HttpServlet {

    private CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String id = req.getParameter("id");
        Category category = categoryService.getOneCategory(Long.valueOf(id));
        req.setAttribute("category", category);

        req.getRequestDispatcher("/jsp/admin/manager/category/update.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        Long category_id = Long.valueOf(req.getParameter("category_id"));
        Category category = new Category();
        category.setName(name);
        category.setCategory_id(category_id);
        final Long id = Long.valueOf(req.getParameter("id"));

        categoryService.update(category, id);

        resp.sendRedirect("/admin/category-index");
    }
}
