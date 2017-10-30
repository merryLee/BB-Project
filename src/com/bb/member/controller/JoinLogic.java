package com.bb.member.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JOptionPane;

import com.bb.member.model.JoinDao;
import com.bb.member.model.MemberDto;
import com.bb.member.view.Join;

	public class JoinLogic {
		Join join;
		
		public JoinLogic(Join join) {
			this.join = join;
		}
	public void check() {
		JoinDao joindao = new JoinDao();
		MemberDto memberdto = new MemberDto();
		if(join.id.getText().length() != 0 && join.name.getText().length() != 0 && join.pw.getPassword().length != 0 && join.d != 0 && join.tel.getText().length() != 0 && join.ans.getText().length() != 0 && join.chkagree.isSelected() ) {
		memberdto.setMname(join.name.getText());
		memberdto.setMid(join.id.getText());
		char cpw[] = join.pw.getPassword();
		String pws = new String(cpw);
		memberdto.setMpw(pws);
		String birth = join.y+"-"+join.m+"-"+join.d;
		memberdto.setMbirth(birth);
		memberdto.setMphone(join.tel.getText());
		memberdto.setQno(join.cmbq.getSelectedIndex()+1);
		memberdto.setMansw(join.ans.getText());
		memberdto.setMtems("1");
		memberdto.setMdate(now());
		System.out.println(now());
		memberdto.setMstatus("1");
		joindao.insertMem(memberdto);
		}else {
			JOptionPane.showMessageDialog(null, "모두 다 입력 해주세요");
		}
	}
	private String now() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar time = Calendar.getInstance();
        String strToday = sdf.format(time.getTime());
        return strToday;
	}
}
