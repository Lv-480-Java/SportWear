package com.sportwear.service.registration;

import com.sportwear.dao.LoginDao;
import com.sportwear.dao.UserDao;
import com.sportwear.service.validator.EmailValidation;
import com.sportwear.service.validator.PasswordValidation;
import com.sportwear.service.validator.PhoneValidation;
import org.apache.log4j.Logger;


public class RegistrationService {
    private static Logger logger = Logger.getLogger(RegistrationService.class.getName());
    private LoginDao loginDao = new LoginDao();
    private UserDao userDao = new UserDao();
    private EmailValidation emailValidation = new EmailValidation();
    private PasswordValidation passwordValidation = new PasswordValidation();
    private PhoneValidation phoneValidation = new PhoneValidation();


    public boolean checkRegistrationProperties(String phone, String email) {
        return loginDao.checkRegistrationProperties(phone, email) || phoneValidation.lengthNum(phone);
    }

    public boolean validateEmail(String email) {
        return emailValidation.validate(email);
    }

    public boolean existsEmail(String email) {
        if (userDao.readByEmail(email) != null) {
            logger.error("This mail is already registered. Please type another.");
            return true;
        }
        return false;
    }

    public boolean length(String password) {
        return passwordValidation.length(password);
    }
}
