package com.bb.house.controller;

import javax.swing.JCheckBox;

import com.bb.house.model.AccomodateEditDao;
import com.bb.house.model.HouseDto;
import com.bb.house.view.AccomodateEdit;

public class AccomodateEditLogic {
	
	AccomodateEdit accomodateedit;
	String conv = "";
	public AccomodateEditLogic(AccomodateEdit accomodateedit) {
		this.accomodateedit = accomodateedit;		
	}
	
	public void update(int hno) {
		AccomodateEditDao dao = new AccomodateEditDao();
		HouseDto dto = new HouseDto();
		dto.setHno(hno);
		dto.setHname(accomodateedit.hname.getText());
		dto.setHloc(accomodateedit.hloc.getText());
		dto.setHphone(accomodateedit.hphone.getText());
		dto.setHmax(Integer.parseInt(accomodateedit.hmax.getText()));
		dto.setHprice(Integer.parseInt(accomodateedit.hprice.getText()));
		
		checkBox(accomodateedit.c1);
		checkBox(accomodateedit.c2);
		checkBox(accomodateedit.c3);
		checkBox(accomodateedit.c4);
		checkBox(accomodateedit.c5);
		checkBox(accomodateedit.c6);
		checkBox(accomodateedit.c7);
		checkBox(accomodateedit.c8);
		checkBox(accomodateedit.c9);
		checkBox(accomodateedit.c10);
		checkBox(accomodateedit.c11);
		checkBox(accomodateedit.c12);
		dto.setConvcode(conv);
		dto.setHpath1(accomodateedit.hpath1.getText());
		dto.setHpath2(accomodateedit.hpath2.getText());
		dto.setHpath3(accomodateedit.hpath3.getText());
		dto.setHintro(accomodateedit.hintro.getText());
		dao.updateValue(dto, accomodateedit.mno);
	}
	
	private void checkBox(JCheckBox check) {
		if (check.isSelected()) {
			conv+=1;
		} else
			conv+=0;
	}


}
