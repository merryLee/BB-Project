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
					rs.getInt("�����ȣ"),
					rs.getString("�մ��̸�"),
					rs.getString("�����̸�"),
					rs.getString("�����̸�"),
					rs.getString("�Խ�����"),
					rs.getString("�������"),
					rs.getString("��������"),
					rs.getString("�������")
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
						rs.getInt("�����ȣ"),
						rs.getString("�մ��̸�"),
						rs.getString("�����̸�"),
						rs.getString("�����̸�"),
						rs.getString("�Խ�����"),
						rs.getString("�������"),
						rs.getString("��������"),
						rs.getString("�������")
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
			Alert alert = new Alert(rn, "����");
			
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
				+ "        b.bno �����ȣ, "
				+ "        mem_mng.mname �մ��̸�, "
				+ "        b.hname �����̸�, "
				+ "        b.hostname �����̸�, "
				+ "        b.bin �Խ�����, "
				+ "        b.bout �������, "
				+ "        b.bdate ��������, "
				+ "        DECODE (b.bstatus, 0, '�������', 1, '����Ȯ��' ) ������� "
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
				+ "        b.bno �����ȣ, "
				+ "        mem_mng.mname �մ��̸�, "
				+ "        b.hname �����̸�, "
				+ "        b.hostname �����̸�, "
				+ "        b.bin �Խ�����, "
				+ "        b.bout �������, "
				+ "        b.bdate ��������, "
				+ "        DECODE (b.bstatus, 0, '�������', 1, '����Ȯ��' ) ������� "
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
			condition += " AND c.������� = '" + bstatus + "'";
		
		if (!bdate.isEmpty())
			condition += " AND c.�������� LIKE '%" + bdate + "%'";
		
		if (!bguest.isEmpty())
			condition += " AND c.�մ��̸� LIKE '%" + bguest + "%'";
		
		if (!hhost.isEmpty())
			condition += " AND c.�����̸� LIKE '%" + hhost + "%'";
		
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
