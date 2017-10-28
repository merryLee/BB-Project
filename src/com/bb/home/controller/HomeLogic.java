package com.bb.home.controller;

import java.awt.event.*;

import com.bb.common.SwingCalendar;
import com.bb.home.view.Home;

public class HomeLogic extends MouseAdapter implements ActionListener {

	Home home;
	SwingCalendar sc = new SwingCalendar();

	public HomeLogic(Home home) {
		this.home = home;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == home.dateIn) {
			sc.setVisible(true);
			sc.extLabel = home.dateIn;
			sc.setTitle("üũ��");
		}
		if (e.getSource() == home.dateOut) {
			sc.setVisible(true);
			sc.extLabel = home.dateOut;
			sc.setTitle("üũ�ƿ�");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int size = home.hBtnList.size();
		Object obj = e.getSource();
		for(int i=0;i<size;i++) {
			if(obj == home.hBtnList.get(i)) {
				System.out.println(home.hList.get(i).getHname());	//house���� �Ѱ������.
			}
		}
//		home.main_frame.changePanel("houseinfo");
	}

}
