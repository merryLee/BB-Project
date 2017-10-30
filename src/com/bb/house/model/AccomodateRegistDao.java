package com.bb.house.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//import oracle.net.ns.MarkerPacket;
import com.bb.jdbc.*;

public class AccomodateRegistDao {

	public int register(HouseDto housedto) {

		Connection conn = null;
		Statement stmt = null;
		int cnt = 0;

		try {
			conn = DBConnection.makeConnection();
			System.out.println("연결성공");
			String sql = "INSERT INTO HOUSE_MNG VALUES (HOUSE_SEQ.NEXTVAL, '"+ housedto.getHname() + "','"+housedto.getHloc() + "','"+ housedto.getHdetail() + "','"+housedto.getHprice() + "','" + housedto.getHmax()+"','"+housedto.getConvcode()+"','" + housedto.getHintro() + "','"+housedto.getHhost()+"','"+ housedto.getHphone() + "','"+housedto.getHstatus()+"' ,null)";
			stmt = conn.createStatement();	
			cnt = stmt.executeUpdate(sql);
			System.out.println(sql);
			if(cnt != 0) {
				
				return cnt;
				
			}
			sql =  "INSERT INTO HOUSE_IMG VALUES (select hno from house_mng where hhost = "+housedto.getHhost()+", '"+ housedto.getHpath1()  +"','"+ housedto.getHpath2() + "','"+ housedto.getHpath3() + "')";  
			//stmt = conn.createStatement();	
			cnt = stmt.executeUpdate(sql);
			System.out.println(sql);
			if(cnt != 0) {
				
				return cnt;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(stmt,conn);
		}

		return 0;
	}
	
//	public int imgRegister(HouseDto housedto) {
//
//		Connection conn = null;
//		Statement stmt = null;
//		int cnt = 0;
//
//		try {
//			conn = DBConnection.makeConnection();
//			String sql = "INSERT INTO HOUSE_IMG VALUES (select hno from house_mng where hhost = "+housedto.getHhost()+", '"+ housedto.getRegi_path1()  +"','"+ housedto.getRegi_path2() + "','"+ housedto.getRegi_path3() + "')";
//			stmt = conn.createStatement();
//			cnt = stmt.executeUpdate(sql);
//			if(cnt != 0) {
//				return cnt;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBClose.close(stmt,conn);
//		}
//		return 0;
//	}
}
