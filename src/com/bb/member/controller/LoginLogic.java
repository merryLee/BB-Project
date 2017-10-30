package com.bb.member.controller;

import com.bb.member.model.LoginDao;
import com.bb.member.model.MemberDto;
import com.bb.member.view.*;

public class LoginLogic {
	
	Login login;
	public LoginLogic(Login login) {
		this.login = login;
	}
	
	public boolean loginCheck() {
		LoginDao logindao = new LoginDao();
		MemberDto memberdto = new MemberDto();
		char cpw[] = login.pw.getPassword();
		String pws = new String(cpw);
		memberdto.setMid(login.id.getText());
		memberdto.setMpw(pws);
		if(logindao.idpwCheck(memberdto)) {
			return true;
		}
		return false;
	}
	
	public int mnoGet() {
		LoginDao logindao = new LoginDao();
		MemberDto memberdto = new MemberDto();
		memberdto.setMid(login.id.getText());
		return logindao.mnoFind(memberdto);
	}
}
