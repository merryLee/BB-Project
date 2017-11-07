package com.bb.reservation.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.bb.jdbc.DBClose;
import com.bb.jdbc.DBConnection;
import com.bb.member.model.MemberDto;

public class ReservationDao {
	
	public void insertBook(ReservationDto reservationdto,String bin, String bout) {
		Connection conn = null;
		Statement stmt = null;
		int cnt = 0;
		
		try {
			String strin = "DATE '" + bin.replace('.', '-') + "'";
			String strout = "DATE '" + bout.replace('.', '-') + "'";
			conn = DBConnection.makeConnection();
			String sql = "";
			sql += "INSERT INTO BOOK_MNG \n";
			sql += "VALUES ( BOOK_SEQ.NEXTVAL ";
			sql += "," + reservationdto.getBGUEST();
			sql += "," + reservationdto.getHNO();
			sql += "," + strin;
			sql += "," + strout;
			sql += "," + reservationdto.getBPERSON();
			sql += ",'" + reservationdto.getBREQ() + "'";
			sql += ",SYSDATE,'1')";
			stmt = conn.createStatement();
			cnt = stmt.executeUpdate(sql);
			if(cnt != 0) {
				System.out.println("book 업데이트 완료");
			}else System.out.println("book 업데이트 실패");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(stmt, conn);
		}
	}
	

}
