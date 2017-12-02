package com.asiainfo.db;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    private static final String URL = "jdbc:mysql://192.168.0.100:3306/queryGirl";
    private static final String USER = "root";
    private static final String PASSWORD = "MicroKibaco0813";
    private static Connection sConn;

    static {
        try {
            // 1.Load the driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2.Obtain a database connection
            sConn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return sConn;
    }
}
