package com.sportwear.servlet.admin.color;

import com.sportwear.entity.Color;
import com.sportwear.service.color.ColorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/update-color")
public class UpdateColorServlet extends HttpServlet {

    private ColorService colorService = new ColorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String id = req.getParameter("id");
        Color color = colorService.getOneColor(Long.valueOf(id));
        req.setAttribute("color", color);

        req.getRequestDispatcher("/jsp/admin/manager/color/update.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        final String name = req.getParameter("name");
        Color color = new Color();
        color.setName(name);
        final Long id = Long.valueOf(req.getParameter("id"));

        colorService.update(color, id);

        resp.sendRedirect("/admin/color-index");
    }
}
