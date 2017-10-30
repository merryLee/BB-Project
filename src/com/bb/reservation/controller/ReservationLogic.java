package com.bb.reservation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.bb.reservation.model.ReservationDao;
import com.bb.reservation.model.ReservationDto;
import com.bb.reservation.view.Reservation;

public class ReservationLogic {
	Reservation rs;
	
	public ReservationLogic(Reservation reservation) {
		// TODO Auto-generated constructor stub
		this.rs = reservation;
	}

	public void update() {
		
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		
//  		ReservationDto dto = new ReservationDto();
//  		ReservationDao dao = new ReservationDao();
//  		dto.setHNO(rs.housedto.getHno());	      		
//  		dto.setBGUEST(rs.mno);
//  		dto.setBPERSON(BPERSON);
//  		dto.setBREQ(reservation_add_text.getText());
//  		dao.insertBook(dto,BIN,BOUT);      		
//  		main_frame.changePanel("mypagemain");      		
//  
//	}

}
