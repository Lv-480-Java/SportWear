package com.sportwear.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DatabaseConnect {
    private static Connection connection;
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/sport?useUnicode=true&serverTimezone=UTC";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";
//    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";

    private DatabaseConnect() {}

    public static Connection getConnection() {
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        }catch (SQLException | ClassNotFoundException e) {
            Logger.getGlobal().info("Connected Error");
        }
        return connection;
    }
}
