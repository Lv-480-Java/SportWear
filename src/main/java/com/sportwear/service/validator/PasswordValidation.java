package com.sportwear.service.validator;

import org.apache.log4j.Logger;

public class PasswordValidation {
    private static Logger logger = Logger.getLogger(PasswordValidation.class.getName());

    public boolean length(String password) {
        if (password.length() < 4) {
            logger.error("Password length must be at least 4 symbols");
            return true;
        }
        return false;
    }
}
