package com.sportwear.servlet.login;

import com.sportwear.entity.User;
import com.sportwear.entity.UserRole;
import com.sportwear.service.user.UserService;
import com.sportwear.service.login.LoginService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(LoginServlet.class.getName());
    private LoginService loginService = new LoginService();
    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        RequestDispatcher requestDispatcher = null;

        if (loginService.checkUserProperties(email, password)) {
            User user = userService.getOneUser(email);
            if (userService.isUser(user.getUserRole())) {
                logger.info("Login like just user successful");
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                requestDispatcher = req.getRequestDispatcher("/jsp/user/user-homepage.jsp");
                requestDispatcher.forward(req, resp);
            } else if (userService.isAdmin(user.getUserRole())) {
                logger.info("Login like admin successful");
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                requestDispatcher = req.getRequestDispatcher("/jsp/admin/adminHomePage.jsp");
                requestDispatcher.forward(req, resp);
            }
        } else {
            logger.error("Invalid login");
            requestDispatcher = req.getRequestDispatcher("jsp/invalid/invalidLogin.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
