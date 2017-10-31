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
				houseDTO.setHno(rs.getInt("���ҹ�ȣ"));
				houseDTO.setHname(rs.getString("�����̸�"));
				houseDTO.setHhost(rs.getString("�����̸�"));
				houseDTO.setHprice(rs.getInt("���Ұ���"));
				houseDTO.setHavg(rs.getDouble("�������"));
				houseDTO.setBstatus(rs.getString("�������"));
				houseDTO.setHdate(rs.getString("�������"));
				houseDTO.setHstatus(rs.getString("��ϻ���"));
				
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
				houseDTO.setHno(rs.getInt("���ҹ�ȣ"));
				houseDTO.setHname(rs.getString("�����̸�"));
				houseDTO.setHhost(rs.getString("�����̸�"));
				houseDTO.setHprice(rs.getInt("���Ұ���"));
				houseDTO.setHavg(rs.getDouble("�������"));
				houseDTO.setBstatus(rs.getString("�������"));
				houseDTO.setHdate(rs.getString("�������"));
				houseDTO.setHstatus(rs.getString("��ϻ���"));
				
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
			Alert alert = new Alert(rn, "����");
			
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
			Alert alert = new Alert(rn, "�㰡");
			
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
			Alert alert = new Alert(rn, "���");
			
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
				+ "        c.hno ���ҹ�ȣ, "
				+ "        c.hname �����̸�, "
				+ "        mem_mng.mname �����̸�, "
				+ "        c.hprice ���Ұ���, "
				+ "        c.havg �������, "
				+ "        DECODE (c.bstatus, 0, '�������', 1, '����Ȯ��') �������, "
				+ "        c.hdate �������, "
				+ "        DECODE (c.hstatus, 0, '����', 1, '�����', 2, '��ϵ�', 3, '������') ��ϻ��� "
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
				+ "            c.hno ���ҹ�ȣ, "
				+ "            c.hname �����̸�, "
				+ "            mem_mng.mname �����̸�, "
				+ "            c.hprice ���Ұ���, "
				+ "            c.havg �������, "
				+ "            DECODE (c.bstatus, 0, '�������', 1, '����Ȯ��') �������, "
				+ "            c.hdate �������, "
				+ "            DECODE (c.hstatus, 0, '����', 1, '�����', 2, '��ϵ�', 3, '������') ��ϻ��� "
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
			condition += " AND d.������� = '" + bstatus + "'";
		
		if (!hstatus.equals("-"))
			condition += "    AND d.��ϻ��� = '" + hstatus + "'";
		
		if (!hdate.isEmpty())
			condition += "    AND d.������� LIKE '%" + hdate +"%'";
		
		if (!hhost.isEmpty())
			condition += "    AND d.�����̸� LIKE '%" + hhost + "%'";
		
		if (!hname.isEmpty())
			condition += "    AND d.�����̸� LIKE '%" + hname + "%'";
		
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
