package com.bb.reservation.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.bb.jdbc.DBClose;
import com.bb.jdbc.DBConnection;

public class Reservation_ConfirmDao {
	
	public int cancelBook(int mno, int hno) {
		Connection conn = null;
		Statement stmt = null;
		int cnt = 0;
		try {
			conn = DBConnection.makeConnection();
			String sql = "";
			sql += "UPDATE BOOK_MNG \n";
			sql += "SET BSTATUS = '0' \n" ;
			sql += " WHERE BGUEST = " + mno +" AND HNO = "+hno ;
			
			stmt = conn.createStatement();
			cnt = stmt.executeUpdate(sql);
			if(cnt != 0) {
				System.out.println("취소업데이트!완료!");
				return 1;
			}else System.out.println("취소업데이트!실패!");			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(stmt, conn);
		}	
		return 0;
	}

}
