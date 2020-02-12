package com.sportwear.service;

import com.sportwear.dao.UserDao;
import com.sportwear.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UserService {
//  бізнес логіка,  валідація
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

    public void update(User user, Long id) {
        userDao.update(user, id);
    }

    public void remove(Long id) {
        userDao.delete(id);
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
