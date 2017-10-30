package com.bb.member.controller;

import com.bb.member.model.FindpwDao;
import com.bb.member.model.MemberDto;
import com.bb.member.view.Findpw;

public class FindpwLogic {
	Findpw main;
	
	public FindpwLogic(Findpw main) {
		this.main = main;
	}
	
	public void check() {
		FindpwDao findpwdao = new FindpwDao();
		MemberDto memberdto = new MemberDto();
		char cpw[] = main.pw.getPassword();
		String pws = new String(cpw);
		memberdto.setMpw(pws);
		findpwdao.pwReset(memberdto);
	}

}
