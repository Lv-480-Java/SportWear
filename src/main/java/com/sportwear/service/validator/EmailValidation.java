package com.sportwear.service.validator;

import com.sportwear.dao.UserDao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {
    private UserDao userDao = new UserDao();

    public void validate(String email) {
        String emailString = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
        Pattern emailPattern = Pattern.compile(emailString);
        Matcher emailMatcher = emailPattern.matcher(email);
        if (!emailMatcher.matches()) {
            throw new IllegalArgumentException("Email is not valid.");
        }
        exists(email);
    }

    private void exists(String email) {
        if (userDao.readByEmail(email) != null) {
            throw new IllegalArgumentException("This mail is already registered. Please type another.");
        }
    }
}
