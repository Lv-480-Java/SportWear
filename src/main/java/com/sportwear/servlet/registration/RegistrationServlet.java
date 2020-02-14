package com.sportwear.servlet.registration;

import com.sportwear.entity.User;
import com.sportwear.service.user.UserService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(RegistrationServlet.class.getName());
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/signUp-registration/registration.html");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setFirst_name(req.getParameter("first_name"));
        user.setLast_name(req.getParameter("last_name"));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        String confirmPassword = req.getParameter("confirmPassword");
        if (req.getParameter("password").equalsIgnoreCase(confirmPassword)) {
            try {
                userService.add(user);
                HttpSession session = req.getSession();
                session.setAttribute("user", userService.getOneUser(req.getParameter("email")));
                resp.sendRedirect("/user/user-homepage");
            } catch (IllegalArgumentException e){
                req.setAttribute("error-msg", e.getMessage());
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("jsp/registrationForm.jsp");
                requestDispatcher.forward(req, resp);
            }
        } else {
            resp.sendRedirect("/signUp");
        }
    }
}
