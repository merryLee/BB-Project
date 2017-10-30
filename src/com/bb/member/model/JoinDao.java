package com.bb.member.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.bb.jdbc.DBClose;
import com.bb.jdbc.DBConnection;

public class JoinDao {

//
//insertMem(JoinDTO)
//"INSERT INTO MEM_MNG VALUES (?,?,?,?,?,?,?,?,?,SYSDATE,?)";
	public boolean insertMem(MemberDto memberdto) {
		Connection conn = null;
		Statement stmt = null;
		int cnt = 0;
		
		try {
			conn = DBConnection.makeConnection();
			String sql = "";
			sql += "INSERT INTO MEM_MNG \n";
			sql += "VALUES ( MEM_SEQ.NEXTVAL ";
			sql += ",'" + memberdto.getMname() + "'";
			sql += ",'" + memberdto.getMid() + "'";
			sql += ",'" + memberdto.getMpw() + "'";
			sql += ",'" + memberdto.getMbirth() + "'";
			sql += ",'" + memberdto.getMphone() + "',";
			sql += memberdto.getQno();
			sql += ",'" + memberdto.getMansw() + "'";
			sql += ",'" + memberdto.getMtems() + "'";
			sql += ",'" + memberdto.getMdate() + "'";
			sql += ",'" + memberdto.getMstatus() + "')";
			stmt = conn.createStatement();
			cnt = stmt.executeUpdate(sql);
			if(cnt != 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(stmt, conn);
		}
		return false;
	}
	
	
}
