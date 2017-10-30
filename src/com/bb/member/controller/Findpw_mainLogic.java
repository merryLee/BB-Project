package com.bb.member.controller;

import com.bb.member.model.Findpw_mainDao;
import com.bb.member.model.MemberDto;
import com.bb.member.view.Findpw_main;

public class Findpw_mainLogic {
	Findpw_main main;
	
	public Findpw_mainLogic(Findpw_main main) {
		this.main = main;
	}
	
	public boolean check() {
		Findpw_mainDao findpw_maindao = new Findpw_mainDao();
		MemberDto memberdto = new MemberDto();
		memberdto.setMid(main.id.getText());
		memberdto.setQno(main.cmbq.getSelectedIndex()+1);
		memberdto.setMansw(main.ans.getText());
		if(findpw_maindao.findpwCheck(memberdto)) {

			return true;
		}		
		return false;
	}

}
