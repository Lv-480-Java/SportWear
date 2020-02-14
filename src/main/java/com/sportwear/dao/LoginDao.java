package com.sportwear.dao;

import com.sportwear.connection.DatabaseConnection;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    private static Logger logger = Logger.getLogger(LoginDao.class.getName());
    private static final String CHECK_LOGIN = "select * from users where email = ? and password = ?";


    public boolean checkUserProperties(String email, String password) {
        boolean status = false;
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CHECK_LOGIN)){

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            status = resultSet.next();
        } catch (SQLException e){
            logger.error("Issue in email validation");
            logger.error(e.getMessage());
        }
        return status;
    }
}
