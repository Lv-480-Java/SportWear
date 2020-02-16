package com.sportwear.servlet.registration;

import com.sportwear.entity.User;
import com.sportwear.service.registration.RegistrationService;
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
    private RegistrationService registrationService = new RegistrationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/signUp-registration/registration.html");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        user.setFirst_name(first_name);
        user.setLast_name(last_name);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPassword(password);

        if (registrationService.checkRegistrationProperties(phone, email)
                || registrationService.existsEmail(email)
                || registrationService.length(password)
                || registrationService.validateEmail(email)) {
            logger.error("Wrong Parameters");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("jsp/invalidParam/invalidRegistration.jsp");
            requestDispatcher.forward(req, resp);
        } else if (req.getParameter("password").equalsIgnoreCase(confirmPassword)) {
            try {
                userService.add(user);
                HttpSession session = req.getSession();
                session.setAttribute("user", userService.getOneUser(req.getParameter("email")));
                logger.info("Registration ------> OK");
                resp.sendRedirect("/user/user-homepage");
            } catch (IllegalArgumentException e){
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("jsp/invalidParam/invalidRegistration.jsp");
                requestDispatcher.forward(req, resp);
            }
        } else {
            resp.sendRedirect("/signUp");
        }
    }
}
