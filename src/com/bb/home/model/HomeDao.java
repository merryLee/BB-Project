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
	
	public List<HouseDto> selectExport(String address, String in, String out, String people) {
		List<HouseDto> exportList = new ArrayList<HouseDto>();
		HouseDto h = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		in = changeDate(in);
		out = changeDate(out);
		int max = changePeople(people);		//구현해야함 address빼고 전부다.

		try {
			conn = DBConnection.makeConnection();
			System.out.println("연결성공!");
			String sql = "";			
			sql += "SELECT house.*, i.thumb1, i.thumb2, i.thumb3 \n";
			sql += "FROM house_img i, \n";
			sql	+= "	(SELECT h.* \n";
			sql += "	FROM HOUSE_MNG h, \n";
			sql += "		(SELECT hno FROM HOUSE_MNG \n";
			sql += "		MINUS \n";
			sql += "		SELECT DISTINCT hno \n";
			sql += "		FROM BOOK_MNG \n";
			sql += "		WHERE to_char(bin) BETWEEN '" + in + "' AND '" + out + "' \n";
			sql += "		AND to_char(bout) BETWEEN '" + in + "' AND '" + out + "') con \n";
			sql += "	WHERE h.hno = con.hno AND hloc LIKE '%" + address + "%' \n";
			sql += "						AND hmax >= " + max + ") house \n";
			sql += "WHERE house.hno = i.hno";
			
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
				
				exportList.add(h);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(stmt, conn, rs);
			System.out.println("검색성공");
		}
		return exportList;
	}

	private String changeDate(String date) {
		StringTokenizer st = new StringTokenizer(date, ". ");
		return st.nextToken().substring(2)+"/"+st.nextToken()+"/"+st.nextToken();
	}

	private int changePeople(String people) {
		int m = 0;
		
		if("성인 1명".equals(people))
				m = 1;
		else if("성인 2명".equals(people))
				m = 2;
		else if("성인 4명".equals(people))
				m = 4;
		else if("성인 6명".equals(people))
				m = 6;
		else if("성인 8명".equals(people))
				m = 8;
		else if("성인 10명".equals(people))
				m = 10;
		else if("10명 이상".equals(people))
				m = 99;
		
		return m;
	}
}
