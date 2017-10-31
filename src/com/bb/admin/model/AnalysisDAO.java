package com.bb.admin.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bb.admin.view.AnalysisManagement;
import com.bb.jdbc.DBConnection;

public class AnalysisDAO {
	
	public AnalysisManagement analysisManagement;

	public AnalysisDAO(AnalysisManagement analysisManagement) {
		this.analysisManagement = analysisManagement;
	}
	
	public double getValue(int month) {
		
		double value = 0.0;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = ""
				+ "SELECT * "
				+ "FROM "
				+ "( "
				+ "    SELECT "
				+ "        TO_CHAR(bdate, 'MM') month, "
				+ "        COUNT(*) cnt "
				+ "    FROM "
				+ "        book_mng "
				+ "    GROUP BY "
				+ "        TO_CHAR(bdate, 'MM') "
				+ ") "
				+ "WHERE "
				+ "    month = " + month;
//				+ "OR "
//				+ "    month = " + (month+1)
//				+ "OR "
//				+ "    month = " + (month+2)
//				+ "OR "
//				+ "    month = " + (month+3);		
		
		try {
			conn = DBConnection.makeConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				value = rs.getDouble("month");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return value;
	}

}
