package com.sportwear.service.validator;

import com.sportwear.dao.UserDao;

public class UserFullNameValidation {
    private UserDao userDao = new UserDao();

    public void validate (String first_name, String last_name) {
        if (first_name.isEmpty() || last_name.isEmpty()){
            throw new IllegalArgumentException("\"" + first_name + "\"" +
                    " username already exist. Please choose another");
        }
    }
}
