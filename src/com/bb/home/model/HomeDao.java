package com.bb.home.model;

import java.sql.*;
import java.util.*;

import com.bb.house.model.HouseDto;
import com.bb.jdbc.DBClose;
import com.bb.jdbc.DBConnection;

public class HomeDao {

	public List<HouseDto> selectTop() {
		List<HouseDto> topList = new ArrayList<HouseDto>();
		HouseDto h = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.makeConnection();
			System.out.println("연결성공!");
			String sql = "";
			sql += "SELECT ht.*, i.thumb1, i.thumb2, i.thumb3 \n";
			sql += "FROM house_img i, \n";
			sql += "(SELECT h.* FROM house_mng h, \n";
			sql += "(SELECT rank.* FROM \n";
			sql += "(SELECT b.hno, RANK() OVER(ORDER BY AVG(rscore1) DESC) rank \n";
			sql += "FROM rev_mng r, book_mng b \n";
			sql += "WHERE r.bno = b.bno \n";
			sql += "GROUP BY b.hno) rank WHERE rownum <= 4) top \n";
			sql += "WHERE h.hno = top.hno \n";
			sql += "ORDER BY top.rank) ht \n";
			sql += "WHERE ht.hno = i.hno(+)";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				h = new HouseDto();
				h.setHno(rs.getInt("hno"));
				h.setHname(rs.getString("hname"));
				h.setHloc(rs.getString("hloc"));
				h.setHdetail(rs.getString("hdetail"));
				h.setHprice(rs.getInt("hprice"));
				h.setHmax(rs.getInt("hmax"));
				h.setConvcode(rs.getString("convcode"));
				h.setHintro(rs.getString("hintro"));
				h.setHhost(rs.getInt("hhost"));
				h.setHphone(rs.getString("hphone"));
				h.setHstatus(rs.getString("hstatus"));
				h.setHdate(rs.getString("hdate"));
				
				h.setHpath1(rs.getString("thumb1"));
				h.setHpath2(rs.getString("thumb2"));
				h.setHpath3(rs.getString("thumb3"));
				
				topList.add(h);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(stmt, conn, rs);
			System.out.println("쿼리성공");
		}
		return topList;
	}
}
