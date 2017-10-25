package com.bb.review.model;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.bb.jdbc.DBClose;
import com.bb.jdbc.DBConnection;

public class ReviewDao {
	
	public int insertReview(ReviewDto reviewDto) {
		int cnt = 0;
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DBConnection.makeConnection();
			System.out.println("연결 성공!");

			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String strDate = dateFormat.format(Calendar.getInstance().getTime());
			strDate = "DATE '" + strDate + "'";
			System.out.println(strDate);
			int bno = 1234;
			
			String sql = "";
			sql += "INSERT INTO rev_mng (rno, bno, rscore1, rscore2, rscore3, rscore4, rspec, rdate, rcnt) \n";
			sql += "VALUES ('10001001', '1234567', '" + 
					reviewDto.getRscore1() + "', '" + reviewDto.getRscore2() + 
					"', '" + reviewDto.getRscore3() + "', '" + reviewDto.getRscore4() + 
					"', '" + reviewDto.getRspec() + "', " + strDate + ", 0)";
			stmt = conn.createStatement();
			cnt = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt);
		}
		return cnt;
	}

}
