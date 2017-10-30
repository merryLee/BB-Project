package com.bb.admin.model;

public class HouseDTO {
	
	private int hno; //숙소번호
	private String hname; //숙소이름
	private String hhost; //주인이름
	private int hprice; //숙소가격
	private double havg; //평균평점
	private String bstatus; //예약상태
	private String hdate; //등록일자
	private String hstatus; //등록상태
	
	public int getHno() {
		return hno;
	}
	
	public void setHno(int hno) {
		this.hno = hno;
	}
	
	public String getHhost() {
		return hhost;
	}
	
	public void setHhost(String hhost) {
		this.hhost = hhost;
	}
	
	public String getHname() {
		return hname;
	}
	
	public void setHname(String hname) {
		this.hname = hname;
	}
	
	public String getHdate() {
		return hdate;
	}
	
	public void setHdate(String hdate) {
		this.hdate = hdate;
	}
	
	public int getHprice() {
		return hprice;
	}
	
	public void setHprice(int hprice) {
		this.hprice = hprice;
	}
	
	public double getHavg() {
		return havg;
	}
	
	public void setHavg(double havg) {
		this.havg = havg;
	}
	
	public String getBstatus() {
		return bstatus;
	}
	
	public void setBstatus(String bstatus) {
		this.bstatus = bstatus;
	}
	
	public String getHstatus() {
		return hstatus;
	}
	
	public void setHstatus(String hstatus) {
		this.hstatus = hstatus;
	}
}

