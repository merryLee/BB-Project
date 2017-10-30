package com.bb.member.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.bb.jdbc.DBClose;
import com.bb.jdbc.DBConnection;
import com.bb.member.view.Findpw_main;

public class FindpwDao {
	
	
//	public void pwReset(FindDTO)
//	query
//	"UPDATE MEM_MEG \n"
//	"SET MPW = " + setpw +" \n"
//	"WHERE MID = " + id;
	
	public void pwReset(MemberDto memberdto) {
		Connection conn = null;
		Statement stmt = null;
		int cnt;
		
		try {
			conn = DBConnection.makeConnection();
			String sql = "";
			sql += "UPDATE MEM_MNG \n";
			sql += "SET MPW = '" + memberdto.getMpw() + "' \n";
			sql += "WHERE MID = '" + Findpw_main.pwresult + "'";
			stmt = conn.createStatement();
			cnt = stmt.executeUpdate(sql);
			if(cnt != 0) {
				System.out.println("¾÷µ¥ÀÌÆ®µÊ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(stmt, conn);
		}		
	}
}
