package com.bb.member.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bb.jdbc.DBClose;
import com.bb.jdbc.DBConnection;
import com.bb.member.view.Findid_main;

public class FindidDao {
//	String findId(FindDTO)
//	query
//	"SELECT MNAME, MBIRTH \n";
//	"FROM MEM_MNG \n";
//	"WHERE MNAME = " + name + " AND MBIRTH = " + mbirth;
	
	
	public boolean findidCheck(MemberDto memberdto) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.makeConnection();
			String sql = "";
			sql += "SELECT MID, MNAME, MBIRTH \n";
			sql += "FROM MEM_MNG \n";
			sql += "WHERE MNAME = '" + memberdto.getMname() + "' AND MBIRTH = '" + memberdto.getMbirth() + "'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				Findid_main.result = rs.getString(1);
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(stmt, conn, rs);
		}
		
		return false;
	}

}
