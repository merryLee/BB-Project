package com.bb.mypage.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bb.jdbc.DBClose;
import com.bb.jdbc.DBConnection;
import com.bb.member.model.MemberDto;

public class ProfileDao {
	
	public List<MemberDto> joinValue(int mno) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<MemberDto> list = new ArrayList<MemberDto>();
		try {
			conn = DBConnection.makeConnection();
			String sql = "";
			sql += "select * \n";
			sql += "from MEM_MNG \n";
			sql += "where MNO = " + mno ;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			MemberDto memberdto = new MemberDto();
			if(rs.next()) {
				memberdto.setMname(rs.getString("MNAME"));
				memberdto.setMpw(rs.getString("MPW"));
				memberdto.setMbirth(rs.getString("MBIRTH"));
				memberdto.setMphone(rs.getString("MPHONE"));
				memberdto.setQno(rs.getInt("QNO"));
				memberdto.setMansw(rs.getString("MANSW"));
				list.add(memberdto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(stmt, conn, rs);
		}		
		return list;
	}
	
	public void updateValue(MemberDto memberdto) {
		Connection conn = null;
		Statement stmt = null;
		int cnt = 0;
		try {
			conn = DBConnection.makeConnection();
			String sql = "";
			sql += "UPDATE MEM_MNG \n";
			sql += "SET MNAME = '" + memberdto.getMname() +"', \n" ;
			sql += "MANSW = '" + memberdto.getMansw() +"', \n";
			sql += " MPW = '" + memberdto.getMpw() +"', \n";
			sql += " MBIRTH = '" + memberdto.getMbirth() +"', \n";
			sql += " MPHONE = '" + memberdto.getMphone() +"', \n";
			sql += " QNO = " + memberdto.getQno() + " \n";
			sql += " WHERE MNO = " + memberdto.getMno() ;
			stmt = conn.createStatement();
			cnt = stmt.executeUpdate(sql);
			if(cnt != 0) {
				System.out.println("업데이트!완료!");
			}else System.out.println("업데이트!실패!");			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(stmt, conn);
		}
	}
}
