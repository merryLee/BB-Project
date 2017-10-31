package com.bb.house.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import oracle.net.ns.MarkerPacket;
import com.bb.jdbc.*;

public class AccomodateRegistDao {

	public int register(HouseDto housedto) {

		Connection conn = null;
		Statement stmt = null;
		int cnt = 0;
		int cnt1 =0;
		try {
			conn = DBConnection.makeConnection();
			System.out.println("연결성공");
			String sql = "INSERT INTO HOUSE_MNG VALUES (HOUSE_SEQ.NEXTVAL, '"+ housedto.getHname() + "','"+housedto.getHloc() + "','"+ housedto.getHdetail() + "','"+housedto.getHprice() + "','" + housedto.getHmax()+"','"+housedto.getConvcode()+"','" + housedto.getHintro() + "','"+housedto.getHhost()+"','"+ housedto.getHphone() + "','"+housedto.getHstatus()+"')";
			stmt = conn.createStatement();	
			cnt = stmt.executeUpdate(sql);

			sql =  "INSERT INTO HOUSE_IMG VALUES (house_seq.currval, '"+ housedto.getHpath1()  +"','"+ housedto.getHpath2() + "','"+ housedto.getHpath3() + "')"; 
			cnt1 = stmt.executeUpdate(sql);

			if(cnt != 0 && cnt1 != 0) {
				System.out.println("숙소등록 성공");
				return cnt;
			}
			else
				System.out.println("숙소등록 실패");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(stmt,conn);
		}

		return 0;
	}
}
