package com.asiainfo.db;

import java.sql.Connection;
import java.sql.DriverManager;


public class myJDBAUnits {
	public static  Connection getConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection
				("jdbc:mysql://192.168.0.138:3306/query_girl_db","root","root");
		return conn;
		
	}

}
