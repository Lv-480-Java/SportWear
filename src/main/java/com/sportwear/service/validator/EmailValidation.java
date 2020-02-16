package com.sportwear.service.validator;

import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {
    private static Logger logger = Logger.getLogger(EmailValidation.class.getName());

    public boolean validate(String email) {
        String emailString = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
        Pattern emailPattern = Pattern.compile(emailString);
        Matcher emailMatcher = emailPattern.matcher(email);
        if (!emailMatcher.matches()) {
            logger.error("Email is valid.");
            return true;
        }
        return false;
    }

}
