package com.sportwear.servlet.admin.user;

import com.sportwear.service.ProductService;
import com.sportwear.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/delete-user")
public class DeleteUserServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        final Long id = Long.valueOf(request.getParameter("id"));
        userService.remove(id);
        response.sendRedirect("/admin/user-index");
    }
}
