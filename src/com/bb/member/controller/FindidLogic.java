package com.bb.member.controller;

import com.bb.member.model.FindidDao;
import com.bb.member.model.MemberDto;
import com.bb.member.view.Findid_main;

public class FindidLogic {
	Findid_main main;
	
	public FindidLogic(Findid_main main) {
		this.main = main;
	}
	public boolean check() {
		FindidDao findiddao = new FindidDao();
		MemberDto memberdto = new MemberDto();
		memberdto.setMname(main.name.getText());
		String birth = main.y+"-"+main.m+"-"+main.d;
		memberdto.setMbirth(birth);
		if(findiddao.findidCheck(memberdto)) {
			return true;
		}		
		return false;
	}

}
