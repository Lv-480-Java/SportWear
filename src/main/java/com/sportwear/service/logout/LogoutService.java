package com.sportwear.service.logout;

import org.apache.log4j.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

public class LogoutService {
    private static Logger logger = Logger.getLogger(LogoutService.class.getName());

    public void logout(HttpSession session) {
        session.invalidate();
    }
}
