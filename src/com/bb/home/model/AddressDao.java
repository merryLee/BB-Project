package com.bb.home.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.bb.jdbc.DBClose;
import com.bb.jdbc.DBConnection;

public class AddressDao {

	public List<String> selectAddress(String keyword) {
		
		List<String> list = new ArrayList<String>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.makeConnection();
			System.out.println("���Ἲ��!");
			String sql = "";
			sql += "SELECT DISTINCT '('||pno||') '||si||' '||gu||' '||street AS \"result\" \n";
			sql += "FROM add_val \n";
			sql += "WHERE street LIKE '%" + keyword +"%' OR gu LIKE '%" + keyword + "%' OR si LIKE '%" + keyword + "%'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(rs.getString("result"));
			}
			System.out.println("�˻���������!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(stmt, conn, rs);
			System.out.println("��������");
		}
		return list;
	}
	
	
}
