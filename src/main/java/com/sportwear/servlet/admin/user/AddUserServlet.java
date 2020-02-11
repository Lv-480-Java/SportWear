package com.sportwear.servlet.admin.user;

import com.sportwear.entity.Product;
import com.sportwear.entity.User;
import com.sportwear.service.ProductService;
import com.sportwear.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/add-user")
public class AddUserServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final String pageBrand = "/jsp/admin/manager/user/add-get-delete.jsp";
        request.getRequestDispatcher(pageBrand).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");

        User user = new User();
        user.setFirst_name(request.getParameter("first_name"));
        user.setLast_name(request.getParameter("last_name"));
        user.setPhone(request.getParameter("phone"));
        user.setAddress_id(Long.valueOf(request.getParameter("address_id")));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));

        userService.add(user);
        response.sendRedirect("/admin/user-index");
    }
}
