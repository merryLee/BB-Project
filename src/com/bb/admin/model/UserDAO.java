package com.bb.admin.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bb.admin.view.Alert;
import com.bb.admin.view.UserManagement;
import com.bb.jdbc.DBClose;
import com.bb.jdbc.DBConnection;

public class UserDAO {
	
	public UserManagement userManagement;

	public UserDAO(UserManagement userManagement) {
		this.userManagement = userManagement;
	}

	public void init() {
		if (userManagement.model != null) {
			userManagement.model.setRowCount(0);
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
			rs = stmt.executeQuery(queryTheUser());
			
			while (rs.next()) {
				userManagement.model.addRow(new Object[] {
						rs.getInt("ROWNUM"),
						rs.getInt("ȸ����ȣ"),
						rs.getString("ȸ��ID"),
						rs.getString("ȸ���̸�"),
						rs.getString("��������"),
						rs.getString("ȸ������")
				});
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(stmt, conn, rs);
		}
	}
	
	public void search(String mstatus, String mdate, String mid, String mname) {
		init();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.makeConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(searchTheUser(mstatus, mdate, mid, mname));
			
			while(rs.next()) {
				userManagement.model.addRow(new Object[] {
						rs.getInt("ROWNUM"),
						rs.getInt("ȸ����ȣ"),
						rs.getString("ȸ��ID"),
						rs.getString("ȸ���̸�"),
						rs.getString("��������"),
						rs.getString("ȸ������")
				});
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(stmt, conn, rs);
		}
	}

	public void block(int num, int[] mno) {
		
		Connection conn = null;
		Statement stmt = null;
		int rn = 0;
		
		try {
			conn = DBConnection.makeConnection();
			stmt = conn.createStatement();
			rn = stmt.executeUpdate(blockTheUser(num, mno));
			Alert alert = new Alert(rn, "����");
			
			setData();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(stmt, conn);
		}
	}
	
	public void unblock(int num, int[] mno) {
		
		Connection conn = null;
		Statement stmt = null;
		int rn = 0;
		
		try {
			conn = DBConnection.makeConnection();
			stmt = conn.createStatement();
			rn = stmt.executeUpdate(unBlockTheUser(num, mno));
			Alert alert = new Alert(rn, "���� ��");
			
			setData();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(stmt, conn);
		}
	}

	public String queryTheUser() {
		String sql = ""
				+ "SELECT "
				+ "    ROWNUM, a.* "
				+ "FROM "
				+ "( "
				+ "    SELECT "
				+ "        mno ȸ����ȣ, "
				+ "        mid ȸ��ID, "
				+ "        mname ȸ���̸�, "
				+ "        mdate ��������, "
				+ "        DECODE (mstatus, 0, '����ȸ��', 1, '�̿�ȸ��') ȸ������ "
				+ "    FROM "
				+ "        mem_mng "
				+ "    ORDER BY "
				+ "        mno DESC "
				+ ")a";
		
		return sql;
	}
	
	public String searchTheUser(String mstatus, String mdate, String mid, String mname) {
		
		String sql = ""
				+ "SELECT "
				+ "    ROWNUM, b.* "
				+ "FROM "
				+ "( "
				+ "    SELECT "
				+ "        a.* "
				+ "    FROM "
				+ "    ( "
				+ "    SELECT "
				+ "        mno ȸ����ȣ, "
				+ "        mid ȸ��ID, "
				+ "        mname ȸ���̸�, "
				+ "        mdate ��������, "
				+ "        DECODE(mstatus, 0, '����ȸ��', 1, '�̿�ȸ��') ȸ������ "
				+ "    FROM "
				+ "        mem_mng "
				+ "    ORDER BY "
				+ "        mno DESC "
				+ "    )a "
				+ "    WHERE 1=1 ";
		
		String condition = "";
		
		if (!mstatus.equals("-"))
			condition += " AND a.ȸ������ = '" + mstatus + "'";
		
		if (!mdate.isEmpty())
			condition += " AND a.������ LIKE '%" + mdate + "%'";
		
		if (!mid.isEmpty())
			condition += " AND a.ȸ��ID LIKE '%" + mid + "%'";
		
		if (!mname.isEmpty())
			condition += " AND a.ȸ���̸� LIKE '%" + mname + "%'";
		
		sql += condition;
		sql += ")b";
			
		return sql;
	}
	
	public String blockTheUser(int num, int[] mno) {
		
		String sql = ""
				+ "UPDATE mem_mng "
				+ "SET mstatus = '0' "
				+ "WHERE mno = " + mno[0];
		for (int i = 1; i < num; ++i) {
			sql += " OR mno = " + mno[i];
			System.out.println(mno[i]);
		}
		
		return sql;
	}
	
	public String unBlockTheUser(int num, int[] mno) {
		
		String sql = ""
				+ "UPDATE mem_mng "
				+ "SET mstatus = '1' "
				+ "WHERE mno = " + mno[0];
		for (int i = 1; i < num; ++i) {
			sql += " OR mno = " + mno[i];
			System.out.println(mno[i]);
		}
		
		return sql;
	}
}
