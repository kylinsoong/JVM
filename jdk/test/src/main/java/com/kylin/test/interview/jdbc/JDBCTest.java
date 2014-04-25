package com.kylin.test.interview.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) {

		Connection conn = null;  
		
        final String driver = "com.mysql.jdbc.Driver";  
        final String url = "jdbc:mysql://127.0.0.1:3306/test";  
        final String user = "test_user";  
        final String passwd = "test_pass";  
          
        try {  
//            Class c = Class.forName(driver);  
//            Driver d = (Driver) c.newInstance();  
        	com.mysql.jdbc.Driver d = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(d);  
            conn = DriverManager.getConnection(url, user, passwd);  
            System.out.println(conn);
        } catch (Exception e) {  
            e.printStackTrace();  
        }finally {  
            try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}  
        } 
	}

}
