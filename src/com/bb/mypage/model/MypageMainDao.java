package com.bb.mypage.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bb.jdbc.DBClose;
import com.bb.jdbc.DBConnection;
import com.bb.member.model.MemberDto;
import com.bb.mypage.view.Mypage_registered_mng;

public class MypageMainDao {
//	Select m.hno,m.hname, m.hprice, i.thumb1
//	from (house_mng) m , (house_img) i , (book_mng) b
//	where m.hno = i.hno AND m.hno = b.hno AND b.bguest = 1800001
	
	public List<MypageMainDto> rpathOrvalue(int mno) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<MypageMainDto> list = new ArrayList<MypageMainDto>();;
		try {
			conn = DBConnection.makeConnection();
			String sql = "";
			sql += "Select m.hno, i.thumb1, m.hname, (((b.bout-b.bin)*m.hprice)*b.bperson), b.bin, b.bout, m.hloc, m.hphone, b.bno, b.bperson, b.breq \n";
			sql += "from (house_mng) m , (house_img) i , (book_mng) b \n";
			sql += "where m.hno = i.hno AND m.hno = b.hno AND b.bguest = "+ mno +" AND b.bstatus = "+ 1;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
					
			while(rs.next()) {
				MypageMainDto mypagemaindto = new MypageMainDto();
				mypagemaindto.setHno(rs.getInt(1));
				mypagemaindto.setPath(rs.getString(2));
				mypagemaindto.setHname(rs.getString(3));
				mypagemaindto.setHprice(rs.getInt(4));
				mypagemaindto.setBin(rs.getDate(5));
				mypagemaindto.setBout(rs.getDate(6));
				mypagemaindto.setHloc(rs.getString(7));
				mypagemaindto.setHphone(rs.getString(8));
				mypagemaindto.setBno(rs.getInt(9));
				mypagemaindto.setBperson(rs.getInt(10));
				mypagemaindto.setBreq(rs.getString(11));
				System.out.println("hname : " + rs.getString(3));
				System.out.println("path : " + rs.getString(2));
				list.add(mypagemaindto);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(stmt, conn, rs);
		}		
		return list;
	}	
	
	
	
	public List<MypageMainDto> pathOrvalue(int mno) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<MypageMainDto> list = new ArrayList<MypageMainDto>();;
		try {
			conn = DBConnection.makeConnection();
			String sql = "";
			sql += "select i.hno, i.thumb1, h.hname, h.hprice ,DECODE(h.hstatus,0,'삭제', 1, '등록중',2,'등록완료',3,'등록취소')\n";
			sql += "from (Select hno, hname, hprice, hstatus From house_mng where hhost = "+ mno +") h , (house_img) i \n";
			sql += "where h.hno = i.hno AND hstatus > 0";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
					
			while(rs.next()) {
				MypageMainDto mypagemaindto = new MypageMainDto();
				mypagemaindto.setHno(rs.getInt(1));
				mypagemaindto.setPath(rs.getString(2));
				mypagemaindto.setHname(rs.getString(3));
				mypagemaindto.setHprice(rs.getInt(4));
				mypagemaindto.setHstatus(rs.getString(5));
				list.add(mypagemaindto);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(stmt, conn, rs);
		}		
		return list;
	}	
	
	public void registeredmng(int num) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.makeConnection();
			String sql = "";			
			sql += "select rownum, b.bno, m.mname, b.bin, b.bout, b.BPERSON\n";
			sql += "from book_mng b, house_mng h, mem_mng m\n";
			sql += "where h.hno = b.hno AND h.hhost = "+ num +" AND m.mno = b.bguest AND b.bstatus=1 AND h.hstatus = 2";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				MypageMainDto mypagemaindto = new MypageMainDto();
				mypagemaindto.setRownum(rs.getInt(1));
				mypagemaindto.setBno(rs.getInt(2));
				mypagemaindto.setMname(rs.getString(3));
				mypagemaindto.setBin(rs.getDate(4));
				mypagemaindto.setBout(rs.getDate(5));
				mypagemaindto.setBperson(rs.getInt(6));

				Mypage_registered_mng.model.addRow(new Object[] {
						mypagemaindto.getRownum(),
						mypagemaindto.getBno(),
						mypagemaindto.getMname(),
						mypagemaindto.getBin(),
						mypagemaindto.getBout(),
						mypagemaindto.getBperson()
				});
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(stmt, conn, rs);
		}
	}
	
	public void registercancle(Object value) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			String sql = "";
			sql += "update book_mng \n";
			sql += "set bstatus = 0 \n";
			sql += "where bstatus = 1 AND bno = " + value;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(stmt, conn, rs);
		}		
	}

}