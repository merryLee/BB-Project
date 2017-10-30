package com.bb.mypage.model;

import java.util.ArrayList;
import java.util.Date;

public class MypageMainDto {
	
	
	private int bguest;
	private int bno;
	private int hno;
	private String path;
	private String hname = "¾øÀ½";
	private int hprice;
	private int rownum;
	private String mname;
	private Date bin;
	private Date bout;
	private String hphone;
	private String hloc;
	private String breq;
	public String getHloc() {
		return hloc;
	}
	public void setHloc(String hloc) {
		this.hloc = hloc;
	}
	public String getBreq() {
		return breq;
	}
	public void setBreq(String breq) {
		this.breq = breq;
	}
	public String getHphone() {
		return hphone;
	}
	public void setHphone(String hphone) {
		this.hphone = hphone;
	}
	public Date getBin() {
		return bin;
	}
	public void setBin(Date bin) {
		this.bin = bin;
	}
	public Date getBout() {
		return bout;
	}
	public void setBout(Date bout) {
		this.bout = bout;
	}
	private int bperson;
	
	public int getBguest() {
		return bguest;
	}
	public void setBguest(int bguest) {
		this.bguest = bguest;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getHno() {
		return hno;
	}
	public void setHno(int hno) {
		this.hno = hno;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public int getHprice() {
		return hprice;
	}
	public void setHprice(int hprice) {
		this.hprice = hprice;
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	
	public int getBperson() {
		return bperson;
	}
	public void setBperson(int bperson) {
		this.bperson = bperson;
	}

	
	
	
}
