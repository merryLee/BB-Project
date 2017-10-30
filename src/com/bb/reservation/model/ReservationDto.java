package com.bb.reservation.model;

import java.util.Date;

public class ReservationDto {
	
	private int BNO;
	private int BGUEST;
	private int HNO;
	private Date BIN;
	private Date BOUT;
	private int BPERSON;	
	private String BREQ;
	private String BSTATUS;
	
	public int getBNO() {
		return BNO;
	}
	public void setBNO(int bNO) {
		BNO = bNO;
	}
	public int getBGUEST() {
		return BGUEST;
	}
	public void setBGUEST(int bGUEST) {
		BGUEST = bGUEST;
	}
	public int getHNO() {
		return HNO;
	}
	public void setHNO(int hNO) {
		HNO = hNO;
	}
	public Date getBIN() {
		return BIN;
	}
	public void setBIN(Date bIN) {
		BIN = bIN;
	}
	public Date getBOUT() {
		return BOUT;
	}
	public void setBOUT(Date bOUT) {
		BOUT = bOUT;
	}
	public int getBPERSON() {
		return BPERSON;
	}
	public void setBPERSON(int bPERSON) {
		BPERSON = bPERSON;
	}
	public String getBREQ() {
		return BREQ;
	}
	public void setBREQ(String bREQ) {
		BREQ = bREQ;
	}
	public String getBSTATUS() {
		return BSTATUS;
	}
	public void setBSTATUS(String bSTATUS) {
		BSTATUS = bSTATUS;
	}
	
	

}
