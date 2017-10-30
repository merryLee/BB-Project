package com.bb.member.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bb.jdbc.DBClose;
import com.bb.jdbc.DBConnection;

public class LoginDao {

//	boolean loginCheck(LoginDTO)
//	query
//	"SELECT MID,MPW \n";
//	"FROM MEM_MNG \n";
//	"WHERE MID = " + id +" AND MPW = " + pw;
//
//
//	int mnoGet(LoginDTO)
//	query
//	"SELECT MNO \n";
//	"FROM MEM_MNG \n";
//	"WHERE MID = " + id;
	
	public boolean idpwCheck(MemberDto memberdto) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.makeConnection();
			String sql = "";
			sql += "SELECT MID, MPW \n";
			sql += "FROM MEM_MNG \n";
			sql += "WHERE MID ='" + memberdto.getMid() +"' AND MPW = '" + memberdto.getMpw()+"'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
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
	
	public int mnoFind(MemberDto memberdto) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.makeConnection();
			String sql = "";
			sql += "SELECT MNO \n";
			sql += "FROM MEM_MNG \n";
			sql += "WHERE MID = '" + memberdto.getMid()+"'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(stmt, conn, rs);
		}
		return 0;		
	}
}
