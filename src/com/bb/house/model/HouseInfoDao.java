package com.bb.house.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bb.jdbc.DBClose;
import com.bb.jdbc.DBConnection;
import com.bb.review.model.ReviewDto;
public class HouseInfoDao {
	
	
	public List<ReviewDto> reviewList(int hno) {
		
		List<ReviewDto> list = new ArrayList<ReviewDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ReviewDto re = null;
		try {
			conn = DBConnection.makeConnection();
			
			String sql = "";
			sql += " select y.mid, x.rscore1, x.rscore2, x.rscore3, x.rscore4, x.rspec, x.rdate \n";
			sql += " from (select r.bno,rscore1, rscore2, rscore3, rscore4, rspec, rdate, rcnt, bguest \n";
			sql += " 				 from (select b.bno, bguest \n";
			sql += " 							 from book_mng b \n";
			sql += " 								where  b.hno ="+hno+") mb, rev_mng r \n";
			sql += " 				 where mb.bno = r.bno) x , (select m.mno, mid \n";
			sql += "                  									 from mem_mng m, (select bguest \n";
			sql += "                                                       											from book_mng b, rev_mng r \n";
			sql += "                                                       												where b.bno = r.bno) bm  \n";
			sql += "                                 						 where m.mno = bm.bguest) y \n";
			sql += "	where x.bguest = y.mno \n";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				re = new ReviewDto();
				re.setMid(rs.getString(1));
				re.setRscore1(rs.getInt(2));				
				re.setRscore2(rs.getInt(3));	
				re.setRscore3(rs.getInt(4));	
				re.setRscore4(rs.getInt(5));
				re.setRspec(rs.getString(6));
				re.setRdate(rs.getString(7));
				list.add(re);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(stmt, conn, rs);
		}
		return list;		
	}
}
//
//sql += " select x.*, y.mid \n";
//sql += " from (select r.bno,rscore1, rscore2, rscore3, rscore4, rspec, TO_DATE(rdate), rcnt, bguest \n";
//sql += " 				from (select b.bno, bguest \n";
//sql += " 							 from book_mng b, house_mng h \n";
//sql += " 								where  b.hno = h.hno) mb, rev_mng r \n";
//sql += " 				where mb.bno = r.bno) x , (select m.mno, mid \n";
//sql += "                  									 from mem_mng m, (select bguest \n";
//sql += "                                                       											from book_mng b, rev_mng r \n";
//sql += "                                                       												where b.bno = r.bno) bm  \n";
//sql += "                                 						 where m.mno = bm.bguest) y \n";
//sql += "	where x.bguest = y.mno \n";
