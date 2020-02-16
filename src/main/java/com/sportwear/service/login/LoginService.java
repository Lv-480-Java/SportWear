package com.sportwear.service.login;

import com.sportwear.dao.LoginDao;
import org.apache.log4j.Logger;

public class LoginService {
    private static Logger logger = Logger.getLogger(LoginService.class.getName());
    private LoginDao loginDao = new LoginDao();


    public boolean checkUserProperties(String email, String password) {
        logger.info("Login service ---- OK");
        return loginDao.checkUserProperties(email, password);
    }

}
