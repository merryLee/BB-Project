package com.bb.mypage.controller;

import java.util.ArrayList;
import java.util.List;

import com.bb.member.model.MemberDto;
import com.bb.mypage.model.ProfileDao;
import com.bb.mypage.view.Profile;

public class ProfileLogic {
	
	Profile profile;
	
	public ProfileLogic(Profile profile) {
		this.profile = profile;
	}
	
	public void update(int mno) {
		MemberDto memberdto = new MemberDto();
		ProfileDao dao = new ProfileDao();
		memberdto.setMno(mno);
		memberdto.setMname(profile.name.getText());
		char cpw[] = profile.pw.getPassword();
		String pws = new String(cpw);
		memberdto.setMpw(pws);
		String birth = profile.y +"-"+profile.m+"-"+profile.d;
		memberdto.setMbirth(birth);
		memberdto.setMphone(profile.tel.getText());
		memberdto.setQno(profile.cmbq.getSelectedIndex());
		memberdto.setMansw(profile.ans.getText());
		dao.updateValue(memberdto);
		
	}
	


}
