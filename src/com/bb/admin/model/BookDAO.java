package com.bb.admin.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bb.admin.view.Alert;
import com.bb.admin.view.BookManagement;
import com.bb.jdbc.DBClose;
import com.bb.jdbc.DBConnection;

public class BookDAO {

	BookManagement bookManagement;
	
	public BookDAO(BookManagement bookManagement) {
		this.bookManagement = bookManagement;
	}

	public void init() {
		if (bookManagement.model != null)
			bookManagement.model.setRowCount(0);
	}

	public void setData() {
		init();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.makeConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(queryTheBook());
			
			while(rs.next()) {
				bookManagement.model.addRow(new Object[] {
					rs.getInt("ROWNUM"),
					rs.getInt("예약번호"),
					rs.getString("손님이름"),
					rs.getString("숙소이름"),
					rs.getString("주인이름"),
					rs.getString("입실일자"),
					rs.getString("퇴실일자"),
					rs.getString("예약일자"),
					rs.getString("예약상태")
				});
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(stmt, conn, rs);
		}
	}

	public void search(String bstatus, String bdate, String bguest, String hhost) {
		init();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.makeConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(searchTheBook(bstatus, bdate, bguest, hhost));
			
			while(rs.next()) {
				bookManagement.model.addRow(new Object[] {
						rs.getInt("ROWNUM"),
						rs.getInt("예약번호"),
						rs.getString("손님이름"),
						rs.getString("숙소이름"),
						rs.getString("주인이름"),
						rs.getString("입실일자"),
						rs.getString("퇴실일자"),
						rs.getString("예약일자"),
						rs.getString("예약상태")
				});
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(stmt, conn, rs);
		}
	}
	
	public boolean isPossibleToDelete(int num, int[] bno) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.makeConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectFromRevMng(num, bno));
			
			if (rs.next())
				return false;
			else
				return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(stmt, conn, rs);
		}
		
		
		return false;
	}

	public void delete(int num, int[] bno) {
		
		Connection conn = null;
		Statement stmt = null;
		int rn = 0;
		
		try {
			conn = DBConnection.makeConnection();
			stmt = conn.createStatement();
			rn = stmt.executeUpdate(deleteTheBook(num, bno));
			Alert alert = new Alert(rn, "삭제");
			
			setData();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(stmt, conn);
		}
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
				+ "        DECODE (b.bstatus, 0, '예약취소', 1, '예약확정' ) 예약상태 "
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
		
		return sql;
	}
	
	public String searchTheBook(String bstatus, String bdate, String bguest, String hhost) {
		
		String sql = ""
				+ "SELECT "
				+ "    ROWNUM, d.* "
				+ "FROM "
				+ "( "
				+ "    SELECT "
				+ "        c.* "
				+ "    FROM "
				+ "    ( "
				+ "    SELECT "
				+ "        b.bno 예약번호, "
				+ "        mem_mng.mname 손님이름, "
				+ "        b.hname 숙소이름, "
				+ "        b.hostname 주인이름, "
				+ "        b.bin 입실일자, "
				+ "        b.bout 퇴실일자, "
				+ "        b.bdate 예약일자, "
				+ "        DECODE (b.bstatus, 0, '예약취소', 1, '예약확정' ) 예약상태 "
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
				+ "    )c "
				+ "    WHERE 1=1";
		
		String condition = "";
		
		if (!bstatus.equals("-"))
			condition += " AND c.예약상태 = '" + bstatus + "'";
		
		if (!bdate.isEmpty())
			condition += " AND c.예약일자 LIKE '%" + bdate + "%'";
		
		if (!bguest.isEmpty())
			condition += " AND c.손님이름 LIKE '%" + bguest + "%'";
		
		if (!hhost.isEmpty())
			condition += " AND c.주인이름 LIKE '%" + hhost + "%'";
		
		sql += condition;
		sql += ")d";
		
		return sql;
	}
	
	public String selectFromRevMng(int num, int[] bno) {
		
		String sql = ""
				+ "SELECT * "
				+ "FROM rev_mng "
				+ "WHERE bno = " + bno[0];
		
		for (int i = 1; i < num; ++i) {
			sql += " OR bno = " + bno[i];
		}
		System.out.println(sql);
		
		return sql;
	}
	
	public String deleteTheBook(int num, int[] bno) {
		String sql = ""
				+ "DELETE FROM book_mng "
				+ "WHERE bno = " + bno[0];
		for (int i = 1; i < num; ++i)
			sql += " OR bno = " + bno[i];
		System.out.println(sql);
		
		return sql;
	}

}
