package com.bb.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBClose {
	
	public static void close(Statement stmt, Connection conn) {
	try {
		if(stmt != null) {
			stmt.close();
		}
		if(conn != null) {
			conn.close();	
		}				
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt, Connection conn, ResultSet rs) {
		try {
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();	
			}				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}

}
