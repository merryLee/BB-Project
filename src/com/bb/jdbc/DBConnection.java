package com.bb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	static { // 클래스가 읽혀질때 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection makeConnection() throws SQLException {
			return DriverManager.getConnection("jdbc:oracle:thin:@Jungsh:1521:xe","BBA","BBA");
	}

}
