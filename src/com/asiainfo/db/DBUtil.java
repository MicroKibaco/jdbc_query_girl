package com.asiainfo.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// com.mysql.jdbc.exceptions.MySQLSyntaxErrorException: SELECT command denied to user 'root'@'192.168.0.134' for table 'query_girl'

public class DBUtil {

    private static final String URL = "jdbc:mysql://192.168.0.134:3306/queryGirl";
    private static final String USER = "root";
    private static final String PASSWORD = "MicroKibaco0813";

    public static void main(String [] args) throws Exception {

        // 1.Load the driver
        Class.forName("com.mysql.jdbc.Driver");

        // 2.Obtain a database connection
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

        // 3.Database operation through a database connection, the realization of add and delete
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select user_name,age from query_girl");
        while (rs.next()){
            System.out.println(rs.getString("user_name")+rs.getInt("age"));
        }
    }
}
