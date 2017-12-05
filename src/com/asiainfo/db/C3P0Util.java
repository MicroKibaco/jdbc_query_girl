package com.asiainfo.db;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;


public class C3P0Util {
  private static ComboPooledDataSource ds=new ComboPooledDataSource();
  public static Connection getConnection(){
	  try {
		return ds.getConnection();
	} catch (Exception e) {
		// TODO: handle exception
		throw new RuntimeException(e);
	}
  }
}
