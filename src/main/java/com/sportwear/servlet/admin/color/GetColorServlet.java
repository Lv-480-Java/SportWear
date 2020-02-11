package com.sportwear.servlet.admin.color;

import com.sportwear.service.CategoryService;
import com.sportwear.service.ColorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/color-index")
public class GetColorServlet extends HttpServlet {

    private ColorService colorService = new ColorService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("colors", colorService.getAllColor());
        request.getRequestDispatcher("/jsp/admin/manager/color/add-get-delete.jsp").forward(request, response);
    }
}
