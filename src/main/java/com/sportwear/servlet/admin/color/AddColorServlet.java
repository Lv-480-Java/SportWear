package com.sportwear.servlet.admin.color;

import com.sportwear.entity.Category;
import com.sportwear.entity.Color;
import com.sportwear.service.CategoryService;
import com.sportwear.service.ColorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/add-color")
public class AddColorServlet extends HttpServlet {

    private ColorService colorService = new ColorService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final String pageBrand = "/jsp/admin/manager/color/add-get-delete.jsp";
        request.getRequestDispatcher(pageBrand).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");

        Color color = new Color();
        color.setName(request.getParameter("name"));

        colorService.add(color);
        response.sendRedirect("/admin/color-index");
    }
}
