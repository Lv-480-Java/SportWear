package com.sportwear.service.login;

import com.sportwear.dao.LoginDao;
import com.sportwear.service.validator.EmailValidation;
import com.sportwear.service.validator.PasswordValidation;
import org.apache.log4j.Logger;

public class LoginService {
    private static Logger logger = Logger.getLogger(LoginService.class.getName());
    private LoginDao loginDao = new LoginDao();
    private EmailValidation emailValidation = new EmailValidation();
    private PasswordValidation passwordValidation = new PasswordValidation();


    public boolean checkUserProperties(String email, String password) {


        return loginDao.checkUserProperties(email, password);
    }
}
