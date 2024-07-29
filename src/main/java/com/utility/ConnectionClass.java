package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
	static Connection con=null;
 public static Connection getConnection() {
	 try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AllCrud","root","mysql@1984");
		return con;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 return con;
 }
}
