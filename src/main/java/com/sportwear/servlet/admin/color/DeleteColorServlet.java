package com.sportwear.servlet.admin.color;

import com.sportwear.service.CategoryService;
import com.sportwear.service.ColorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/delete-color")
public class DeleteColorServlet extends HttpServlet {

    private ColorService colorService = new ColorService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        Long id = Long.valueOf(request.getParameter("id"));
        colorService.remove(id);
        response.sendRedirect("/admin/color-index");
    }
}
