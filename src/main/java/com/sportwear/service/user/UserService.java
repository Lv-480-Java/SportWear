package com.sportwear.service.user;

import com.sportwear.dao.UserDao;
import com.sportwear.entity.User;
import com.sportwear.entity.UserRole;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class UserService {
    private static Logger logger = Logger.getLogger(UserService.class.getName());
    private UserDao userDao = new UserDao();


    public void add(User user) {
        userDao.create(user);
    }

    public List<User> getAllUser() {
        return userDao.readAll();
    }

    public User getOneUser(Long id) {
        return userDao.readById(id);
    }

    public User getOneUser(String email) {
        return userDao.readByEmail(email);
    }

    public void update(User user, Long id) {
        userDao.update(user, id);
    }

    public void remove(Long id) {
        userDao.delete(id);
    }

    public boolean isAdmin(String userRole) {
        return UserRole.valueOf(userRole) == UserRole.ROLE_ADMIN;
    }

    public boolean isUser(String userRole) {
        return UserRole.valueOf(userRole) == UserRole.ROLE_USER;
    }

    private boolean requestIsValid(final HttpServletRequest request) {
        String first_name = request.getParameter("first_name");
        String surname = request.getParameter("last_name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        return
                first_name != null && first_name.length() > 0 &&
                        surname != null && surname.length() > 0 &&
                        phone != null && phone.length() > 0 &&
                        email != null && email.length() > 0 &&
                        password != null && password.length() > 0 &&
                        password.matches("[+]?\\d+");
    }
}
