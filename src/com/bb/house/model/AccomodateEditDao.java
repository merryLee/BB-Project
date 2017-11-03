package com.bb.house.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bb.jdbc.DBClose;
import com.bb.jdbc.DBConnection;
import com.bb.member.model.MemberDto;
import com.bb.mypage.model.MypageMainDto;

public class AccomodateEditDao {
	
//	SELECT h.hname, h.hloc, h.hdetail, h.hprice, h.hmax, h.convcode, h.hintro, i.thumb1, i.thumb2, i.thumb3
//	FROM (house_mng) h , (house_img) i
//	WHERE hhost = 2 AND (hstatus = 2 OR hstatus = 3) AND i.hno = h.hno
	
	public HouseDto accomodateValue(int mno, int hno) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		HouseDto housedto = null;		
		try {
			conn = DBConnection.makeConnection();
			String sql = "";
			sql += "SELECT h.hname, h.hloc, h.hdetail, h.hprice, h.hmax,  h.convcode, h.hintro, h.hphone, i.thumb1, i.thumb2, i.thumb3 \n";
			sql += "FROM (house_mng) h , (house_img) i \n";
			sql += "WHERE hhost = "+ mno +" AND i.hno = h.hno AND h.HNO = " + hno;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				housedto = new HouseDto();
				housedto.setHname(rs.getString("HNAME"));
				housedto.setHloc(rs.getString("HLOC"));
				housedto.setHdetail(rs.getString("HDETAIL"));
				housedto.setHprice(rs.getInt("HPRICE"));
				housedto.setHmax(rs.getInt("HMAX"));
				housedto.setConvcode(rs.getString("CONVCODE"));
				System.out.println(rs.getString("CONVCODE"));
				housedto.setHintro(rs.getString("HINTRO"));
				housedto.setHphone(rs.getString("HPHONE"));
				housedto.setHpath1(rs.getString("THUMB1"));
				housedto.setHpath2(rs.getString("THUMB2"));
				housedto.setHpath3(rs.getString("THUMB3"));
			}else System.out.println("놉!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(stmt, conn, rs);
		}		
		return housedto;
	}
	
	public void updateValue(HouseDto housedto,int mno) {
		Connection conn = null;
		Statement stmt = null;
		int cnt = 0;
		int cnt1 = 0;
		try {
			conn = DBConnection.makeConnection();
			String sql = "";
			sql += "UPDATE HOUSE_MNG \n";
			sql += "SET HNAME = '" + housedto.getHname() +"', ";
			sql += "HLOC = '" + housedto.getHloc() + "', ";
			sql += "HDETAIL = '" + housedto.getHdetail() + "', ";
			sql += "HPRICE = " + housedto.getHprice() + ", ";
			sql += "HMAX = " + housedto.getHmax() + ", ";
			sql += "CONVCODE = '" + housedto.getConvcode() + "', ";
			sql += "HINTRO = '" + housedto.getHintro() + "' ";
			sql += " WHERE HHOST = " + mno +" AND HNO = "+ housedto.getHno() ;
			stmt = conn.createStatement();
			cnt = stmt.executeUpdate(sql);
			sql = "";
			sql += "UPDATE HOUSE_IMG \n";
			sql += "SET THUMB1 = '" + housedto.getHpath1() + "', ";
			sql += "THUMB2 = '" + housedto.getHpath2() + "', ";
			sql += "THUMB3 = '" + housedto.getHpath3() + "' ";
			sql += " WHERE HNO = "+ housedto.getHno() ;
			System.out.println(sql);
			cnt1 = stmt.executeUpdate(sql);
			if(cnt != 0 && cnt1 !=0) {
				System.out.println("업데이트!완료!");
			}else System.out.println("업데이트!실패!");			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(stmt, conn);
		}
	}

}
