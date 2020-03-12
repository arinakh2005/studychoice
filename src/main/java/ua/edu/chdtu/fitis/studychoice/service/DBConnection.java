package ua.edu.chdtu.fitis.studychoice.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;
    static final String DB_URL = "jdbc:mysql://localhost/studychoice?useUnicode=true&serverTimezone=EET";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "admin";

    static {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
