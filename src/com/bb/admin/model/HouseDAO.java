package com.bb.admin.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bb.admin.view.Alert;
import com.bb.admin.view.HouseManagement;
import com.bb.jdbc.DBClose;
import com.bb.jdbc.DBConnection;

public class HouseDAO {
	
	public HouseManagement houseManagement;
	
	public HouseDAO(HouseManagement houseManagement) {
		this.houseManagement = houseManagement;
	}
	
	public void init() {
		if (houseManagement.model != null) {
			houseManagement.model.setNumRows(0);
			return;
		}
	}
	
	public void setData() {
		init();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.makeConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(queryTheHouse());
			
			while(rs.next()) {
				HouseDTO houseDTO = new HouseDTO();
				
				houseDTO.setNo(rs.getInt("ROWNUM"));
				houseDTO.setHno(rs.getInt("숙소번호"));
				houseDTO.setHname(rs.getString("숙소이름"));
				houseDTO.setHhost(rs.getString("주인이름"));
				houseDTO.setHprice(rs.getInt("숙소가격"));
				houseDTO.setHavg(rs.getDouble("평균평점"));
				houseDTO.setBstatus(rs.getString("예약상태"));
				houseDTO.setHdate(rs.getString("등록일자"));
				houseDTO.setHstatus(rs.getString("등록상태"));
				
				houseManagement.model.addRow(new Object[] {
						houseDTO.getNo(),
						houseDTO.getHno(), 
						houseDTO.getHname(), 
						houseDTO.getHhost(), 
						houseDTO.getHprice(),
						houseDTO.getHavg(),
						houseDTO.getBstatus(),
						houseDTO.getHdate(),
						houseDTO.getHstatus()
				});
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(stmt, conn, rs);
		}
	}

	public void search(String bstatus, String hstatus, String hdate, String hhost, String hname) {
		init();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.makeConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(searchTheHouse(bstatus, hstatus, hdate, hhost, hname));
			
			while(rs.next()) {
				HouseDTO houseDTO = new HouseDTO();
				
				houseDTO.setNo(rs.getInt("ROWNUM"));
				houseDTO.setHno(rs.getInt("숙소번호"));
				houseDTO.setHname(rs.getString("숙소이름"));
				houseDTO.setHhost(rs.getString("주인이름"));
				houseDTO.setHprice(rs.getInt("숙소가격"));
				houseDTO.setHavg(rs.getDouble("평균평점"));
				houseDTO.setBstatus(rs.getString("예약상태"));
				houseDTO.setHdate(rs.getString("등록일자"));
				houseDTO.setHstatus(rs.getString("등록상태"));
				
				houseManagement.model.addRow(new Object[] {
						houseDTO.getNo(),
						houseDTO.getHno(), 
						houseDTO.getHname(), 
						houseDTO.getHhost(), 
						houseDTO.getHprice(),
						houseDTO.getHavg(),
						houseDTO.getBstatus(),
						houseDTO.getHdate(),
						houseDTO.getHstatus()
				});
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(stmt, conn, rs);
		}
	}

	public void delete(int num, int[] hno) {
		
		Connection conn = null;
		Statement stmt = null;
		int rn = 0;
		
		try {
			conn = DBConnection.makeConnection();
			stmt = conn.createStatement();
			rn = stmt.executeUpdate(deleteTheHouse(num, hno));
			Alert alert = new Alert(rn, "삭제");
			
			setData();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void permit(int num, int[] hno) {
		
		Connection conn = null;
		Statement stmt = null;
		int rn = 0;
		
		try {
			conn = DBConnection.makeConnection();
			stmt = conn.createStatement();
			rn = stmt.executeUpdate(permitTheHouse(num, hno));
			Alert alert = new Alert(rn, "허가");
			
			setData();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void cancel(int num, int[] hno) {
		
		Connection conn = null;
		Statement stmt = null;
		int rn = 0;
		
		try {
			conn = DBConnection.makeConnection();
			stmt = conn.createStatement();
			rn = stmt.executeUpdate(cancelTheHouse(num, hno));
			Alert alert = new Alert(rn, "취소");
			
			setData();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String queryTheHouse() {
		
		String sql = ""	
				+ "SELECT "
				+ "    ROWNUM, d.* "
				+ "FROM "
				+ "( "
				+ "    SELECT "
				+ "        c.hno 숙소번호, "
				+ "        c.hname 숙소이름, "
				+ "        mem_mng.mname 주인이름, "
				+ "        c.hprice 숙소가격, "
				+ "        c.havg 평균평점, "
				+ "        DECODE (c.bstatus, 0, '예약취소', 1, '예약확정') 예약상태, "
				+ "        c.hdate 등록일자, "
				+ "        DECODE (c.hstatus, 0, '삭제', 1, '등록중', 2, '등록됨', 3, '등록취소') 등록상태 "
				+ "    FROM "
				+ "    ( "
				+ "        SELECT "
				+ "            b.hno hno, "
				+ "            house_mng.hname hname, "
				+ "            house_mng.hhost hhost, "
				+ "            house_mng.hprice hprice, "
				+ "            b.havg havg, "
				+ "            b.bstatus bstatus, "
				+ "            house_mng.hdate hdate, "
				+ "            house_mng.hstatus hstatus "
				+ "        FROM "
				+ "        ( "
				+ "            SELECT DISTINCT "
				+ "                a.hno hno, "
				+ "                a.havg havg, "
				+ "                book_mng.bstatus bstatus "
				+ "            FROM "
				+ "            ( "
				+ "                SELECT "
				+ "                    book_mng.hno hno, "
				+ "                    ROUND(AVG(rev_mng.rscore1), 2) havg "
				+ "                FROM "
				+ "                    book_mng, rev_mng "
				+ "                WHERE "
				+ "                    book_mng.bno = rev_mng.bno "
				+ "                GROUP BY "
				+ "                    book_mng.hno "
				+ "            )a, book_mng "
				+ "            WHERE "
				+ "                a.hno = book_mng.hno "
				+ "        )b, house_mng "
				+ "        WHERE "
				+ "            b.hno = house_mng.hno "
				+ "    )c, mem_mng "
				+ "    WHERE "
				+ "        c.hhost = mem_mng.mno "
				+ "    ORDER BY "
				+ "        c.hno DESC "
				+ ")d";
		
		return sql;
	}
	
	public String searchTheHouse(String bstatus, String hstatus, String hdate, String hhost, String hname) {
		String sql = ""
				+ "SELECT "
				+ "    ROWNUM, e.* "
				+ "FROM "
				+ "( "
				+ "    SELECT "
				+ "        d.* "
				+ "    FROM "
				+ "    ( "
				+ "        SELECT "
				+ "            c.hno 숙소번호, "
				+ "            c.hname 숙소이름, "
				+ "            mem_mng.mname 주인이름, "
				+ "            c.hprice 숙소가격, "
				+ "            c.havg 평균평점, "
				+ "            DECODE (c.bstatus, 0, '예약취소', 1, '예약확정') 예약상태, "
				+ "            c.hdate 등록일자, "
				+ "            DECODE (c.hstatus, 0, '삭제', 1, '등록중', 2, '등록됨', 3, '등록취소') 등록상태 "
				+ "        FROM "
				+ "        ( "
				+ "            SELECT "
				+ "                b.hno hno, "
				+ "                house_mng.hname hname, "
				+ "                house_mng.hhost hhost, "
				+ "                house_mng.hprice hprice, "
				+ "                b.havg havg, "
				+ "                b.bstatus bstatus, "
				+ "                house_mng.hdate hdate, "
				+ "                house_mng.hstatus hstatus "
				+ "            FROM "
				+ "            ( "
				+ "                SELECT DISTINCT "
				+ "                    a.hno hno, "
				+ "                    a.havg havg, "
				+ "                    book_mng.bstatus bstatus "
				+ "                FROM "
				+ "                ( "
				+ "                    SELECT "
				+ "                        book_mng.hno hno, "
				+ "                        ROUND(AVG(rev_mng.rscore1), 2) havg "
				+ "                    FROM "
				+ "                        book_mng, rev_mng "
				+ "                    WHERE "
				+ "                        book_mng.bno = rev_mng.bno "
				+ "                    GROUP BY "
				+ "                        book_mng.hno "
				+ "                )a, book_mng "
				+ "                WHERE "
				+ "                    a.hno = book_mng.hno "
				+ "            )b, house_mng "
				+ "            WHERE "
				+ "                b.hno = house_mng.hno "
				+ "        )c, mem_mng "
				+ "        WHERE "
				+ "            c.hhost = mem_mng.mno "
				+ "        ORDER BY "
				+ "            c.hno DESC "
				+ "    )d "
				+ "    WHERE 1=1 ";
		
		String condition = "";
		
		if (!bstatus.equals("-"))
			condition += " AND d.예약상태 = '" + bstatus + "'";
		
		if (!hstatus.equals("-"))
			condition += "    AND d.등록상태 = '" + hstatus + "'";
		
		if (!hdate.isEmpty())
			condition += "    AND d.등록일자 LIKE '%" + hdate +"%'";
		
		if (!hhost.isEmpty())
			condition += "    AND d.주인이름 LIKE '%" + hhost + "%'";
		
		if (!hname.isEmpty())
			condition += "    AND d.숙소이름 LIKE '%" + hname + "%'";
		
		sql += condition;
		sql += ")e";
		
		return sql;
	}

	public String deleteTheHouse(int num, int[] hno) {
		String sql = ""
				+ "UPDATE house_mng "
				+ "SET hstatus = '0' "
				+ "WHERE hno = " + hno[0];
		for (int i = 1; i < num; ++i) 
			sql += " OR hno = " + hno[i];
		System.out.println(sql);
		
		return sql;
	}
	
	public String permitTheHouse(int num, int[] hno) {
		String sql = ""
				+ "UPDATE house_mng "
				+ "SET hstatus = '2' "
				+ "WHERE hno = " + hno[0];
		for (int i = 1; i < num; ++i)
			sql += " OR hno = " + hno[i];
		System.out.println(sql);
		
		return sql;
	}
	
	public String cancelTheHouse(int num, int[] hno) {
		String sql = ""
				+ "UPDATE house_mng "
				+ "SET hstatus = '3' "
				+ "WHERE hno = " + hno[0];
		for (int i = 1; i < num; ++i)
			sql += " OR hno = " + hno[i];
		System.out.println(sql);
		
		return sql;
	}

}
