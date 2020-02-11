package com.sportwear.service.login;

import com.sportwear.dao.UserDao;
import com.sportwear.entity.Customer;
import com.sportwear.entity.IUser;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpSession;

public class LoginService {
    private static Logger logger = Logger.getLogger(LoginService.class.getName());

    public IUser login(HttpSession session, String email, String password) {
        IUser iUser = null;

//        UserDao userDao = new UserDao();
//        CustomerDao customerDAO = new CustomerDao();
//        try {
//            if ((iUser = userDao.getUser(email)) != null) {
//                if (!iUser.getPassword().equals(password)) {
//                    MessageForOutput.setMsg("Dear customer, your password is incorrect");
//                    iUser = null;
//                } else {
//                    session.setAttribute("User", iUser);
//                }
//            } else if ((iUser = customerDAO.getCustomer(email)) != null) {
//                if (!iUser.getPassword().equals(password)) {
//                    MessageForOutput.setMsg("Dear customer, your password is incorrect");
//                    iUser = null;
//                } else {
//                    Customer currVisitor = customerDAO.getCustomer(email);
//                    session.setAttribute("Customer", iUser);
//                }
//            } else {
//                logger.info("There is no such user nor customer in db.");
//                MessageForOutput.setMsg("There us no such user nor customer, please, " +
//                        "check your input data or contact us for registration");
//            }
//
//            MessageForOutput.setMsgTypeError();
//
//        } catch (RuntimeException e) {
//            logger.error("Error during user/customer logining");
//            logger.error(e);
//        }

        return iUser;
    }
}