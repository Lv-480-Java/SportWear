package com.sportwear.servlet.admin.user;

import com.sportwear.service.user.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/user-index")
public class GetUserServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("users", userService.getAllUser());
        request.getRequestDispatcher("/jsp/admin/manager/user/add-get-delete.jsp").forward(request, response);
    }
}
