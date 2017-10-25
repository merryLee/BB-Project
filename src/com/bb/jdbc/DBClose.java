package com.bb.jdbc;

import java.sql.*;

public class DBClose {

	public static void close(Connection conn, Statement stmt) {
		try {
			if (conn != null)
				conn.close();
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (conn != null)
				conn.close();
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
