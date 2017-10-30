package com.bb.member.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bb.jdbc.DBClose;
import com.bb.jdbc.DBConnection;
import com.bb.member.view.Findpw_main;

public class Findpw_mainDao {
	
//	String findPw(FindDTO)
//	query
//	"SELECT MID, QNO, MANSW \n"
//	"FROM MEM_MNG \n"
//	"WHERE MID = " + id + " AND QNO = " + qno + " AND MANSW = " + mansw;

	public boolean findpwCheck(MemberDto memberdto) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.makeConnection();
			String sql = "";
			sql += "SELECT MID, QNO, MANSW \n";
			sql += "FROM MEM_MNG \n";
			sql += "WHERE MID = '" + memberdto.getMid() + "' AND QNO = " + memberdto.getQno() + " AND MANSW = '" + memberdto.getMansw() + "'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				Findpw_main.pwresult = rs.getString(1);
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
