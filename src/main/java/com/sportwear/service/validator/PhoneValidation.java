package com.sportwear.service.validator;

import org.apache.log4j.Logger;

public class PhoneValidation {
    private static Logger logger = Logger.getLogger(PhoneValidation.class.getName());

    public boolean lengthNum(String phone) {
        if (phone.length() < 8 || phone.length() > 14) {
            logger.error("Phone length must be at least 8 symbols and not more 14");
            return true;
        }
        return false;
    }
}
