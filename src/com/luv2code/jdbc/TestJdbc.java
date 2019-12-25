package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;



public class TestJdbc {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String password = "hb_Student1";
		
		
		 try {
			
			 System.out.println("Connecting to Database" + jdbcUrl);
			 
			 Connection myconn = DriverManager.getConnection(jdbcUrl, user, password);
			 
			 System.out.println("Connection Successful");
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		
			
	}

}
