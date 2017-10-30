package com.bb.admin.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bb.jdbc.DBConnection;

public class BookDAO {

	public BookDAO() {

	}

	public void setData() {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.makeConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(queryTheBook());
			
			while(rs.next()) {
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void search(String bstatus, String bdate, String bguest, String hhost) {
		
	}

	public void delete(int num, int[] bno) {
		
	}
	
	public String queryTheBook() {
		
		String sql = ""
				+ "SELECT "
				+ "    ROWNUM, c.* "
				+ "FROM "
				+ "( "
				+ "    SELECT "
				+ "        b.bno 예약번호, "
				+ "        mem_mng.mname 손님이름, "
				+ "        b.hname 숙소이름, "
				+ "        b.hostname 주인이름, "
				+ "        b.bin 입실일자, "
				+ "        b.bout 퇴실일자, "
				+ "        b.bdate 예약일자, "
				+ "        b.bstatus 예약상태 "
				+ "    FROM "
				+ "    ( "
				+ "        SELECT DISTINCT "
				+ "            a.bno bno, "
				+ "            a.bguest, "
				+ "            a.hname, "
				+ "            mem_mng.mname hostname, "
				+ "            a.bin, "
				+ "            a.bout, "
				+ "            a.bdate bdate, "
				+ "            a.bstatus bstatus, "
				+ "            a.hhost hhost "
				+ "        FROM "
				+ "        ( "
				+ "            SELECT "
				+ "                book_mng.bno bno, "
				+ "                book_mng.bguest bguest, "
				+ "                house_mng.hname hname, "
				+ "                book_mng.hno hno, "
				+ "                book_mng.bin bin, "
				+ "                book_mng.bout bout, "
				+ "                book_mng.bdate bdate, "
				+ "                book_mng.bstatus bstatus, "
				+ "                house_mng.hhost hhost "
				+ "            FROM "
				+ "                book_mng, house_mng "
				+ "            WHERE "
				+ "                book_mng.hno = house_mng.hno "
				+ "        )a, mem_mng "
				+ "        WHERE "
				+ "            a.hhost = mem_mng.mno "
				+ "    )b,mem_mng "
				+ "    WHERE "
				+ "        b.bguest = mem_mng.mno "
				+ "    ORDER BY "
				+ "        b.bno DESC "
				+ ")c";
		
		System.out.println(sql);
		return sql;
	}
	
	public String searchTheBook() {
		String sql = "";
		
		System.out.println(sql);
		return sql;
	}
	
	public String deleteTheBook() {
		String sql = "";
		
		System.out.println(sql);
		return sql;
	}

}
