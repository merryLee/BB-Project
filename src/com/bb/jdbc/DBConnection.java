package com.bb.jdbc;

import java.sql.*;

public class DBConnection {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection makeConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:oracle:thin:@192.168.12.40:1521:xe", "BBA", "BBA");
	}
}