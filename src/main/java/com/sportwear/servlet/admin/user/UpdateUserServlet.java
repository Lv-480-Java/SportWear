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

@WebServlet("/admin/update-user")
public class UpdateUserServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        final Long id = Long.valueOf(req.getParameter("id"));
        final User user = userService.getOneUser(id);
        req.setAttribute("user", user);

        req.getRequestDispatcher("/jsp/admin/manager/user/update.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        final String first_name = req.getParameter("first_name");
        final String last_name = req.getParameter("last_name");
        final String phone = req.getParameter("phone");
        final Long address_id = Long.valueOf(req.getParameter("address_id"));
        final String email = req.getParameter("email");
        final String password = req.getParameter("password");

        User user = new User();
        user.setFirst_name(first_name);
        user.setLast_name(last_name);
        user.setPhone(phone);
        user.setAddress_id(address_id);
        user.setEmail(email);
        user.setPassword(password);

        final Long id = Long.valueOf(req.getParameter("id"));

        userService.update(user, id);

        resp.sendRedirect("/admin/user-index");
    }
}
