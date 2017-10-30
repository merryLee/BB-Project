package com.bb.home.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.bb.home.view.Address;
import com.bb.home.view.Home;
import com.bb.home.view.Search;
import com.bb.home.view.SwingCalendar;
import com.bb.house.view.HouseInfo;

public class HomeLogic extends MouseAdapter implements ActionListener {

	Home home;
	SwingCalendar sc = new SwingCalendar();
	Address address = new Address();
	public HouseInfo hi;
	
	
	public HomeLogic(Home home) {
		this.home = home;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object ob = e.getSource();
		
		if (ob == home.dateIn) {
			sc.setVisible(true);
			sc.extLabel = home.dateIn;
			sc.setTitle("체크인");
		}
		if (ob == home.dateOut) {
			sc.setVisible(true);
			sc.extLabel = home.dateOut;
			sc.setTitle("체크아웃");
		}
		if (ob == home.address) {
			address.setVisible(true);
			address.extLabel = home.address;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		int size = home.hBtnList.size();
		for(int i=0;i<size;i++) {
			if(obj == home.hBtnList.get(i)) {
				System.out.println("logic = " + home.hList.get(i).getHname());	//house에값 넘겨줘야함.
				hi = new HouseInfo(home.hList.get(i),home.main_frame);
				home.main_frame.intentp.add("houseinfo",hi);
				home.main_frame.changePanel("houseinfo");
			}
		}
		if(obj == home.searchBtn) {
			System.out.println(home.address.getText());
			System.out.println(home.dateIn.getText());
			System.out.println(home.dateOut.getText());
			System.out.println(home.person.getSelectedItem().toString());
//			Search search = new Search(null);
			
		}
	}

}
