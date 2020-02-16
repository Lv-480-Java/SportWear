package com.sportwear.service.user;

import com.sportwear.dao.UserDao;
import com.sportwear.entity.User;
import com.sportwear.entity.UserRole;
import org.apache.log4j.Logger;

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

    public boolean isAdmin(UserRole userRole) {
        return userRole == UserRole.ROLE_ADMIN;
    }

    public boolean isUser(UserRole userRole) {
        return userRole == UserRole.ROLE_USER;
    }

}
