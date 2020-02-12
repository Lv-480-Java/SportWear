package com.sportwear.connection;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database management singleton
 */
public class DatabaseConnection {
    private static Logger logger = Logger.getLogger(DatabaseConnection.class.getName());
    private static DatabaseConnection instance;
    private Connection connection;
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/sport?useUnicode=true&serverTimezone=UTC";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";
//    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";

    private DatabaseConnection() {}

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            logger.info("Connected to database  is successfully");
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("Problem with connection to database");
            logger.error(e.getMessage());
        }
        return connection;
    }
}
