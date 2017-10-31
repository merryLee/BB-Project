package com.bb.home.controller;

import java.awt.event.*;
import java.util.*;

import javax.swing.JOptionPane;

import com.bb.home.view.*;
import com.bb.house.model.HouseDto;
import com.bb.house.view.HouseInfo;

public class HomeLogic extends MouseAdapter implements ActionListener {

	Home home;
	SwingCalendar sc = new SwingCalendar();
	Address address = new Address();
	public HouseInfo hi;
	Search search;

	public HomeLogic(Home home) {
		this.home = home;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object ob = e.getSource();

		if (ob == home.dateIn) {
			sc.setVisible(true);
			sc.extLabel = home.dateIn;
			sc.setTitle("üũ��");
		}
		if (ob == home.dateOut) {
			sc.setVisible(true);
			sc.extLabel = home.dateOut;
			sc.setTitle("üũ�ƿ�");
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
		for (int i = 0; i < size; i++) {
			if (obj == home.hBtnList.get(i)) {
				System.out.println("logic = " + home.hList.get(i).getHname()); // house���� �Ѱ������.
				hi = new HouseInfo(home.hList.get(i), home.main_frame);
				home.main_frame.intentp.add("houseinfo", hi);
				home.main_frame.changePanel("houseinfo");
			}
		}
		if (obj == home.searchBtn) {

			System.out.println("���б� ����1");

			try {
				String address = home.address.getText();
				String dateIn = home.dateIn.getText();
				String dateOut = home.dateOut.getText();
				String person = home.person.getSelectedItem().toString();
				
				List<HouseDto> searchList = new ArrayList<HouseDto>();

				searchList = home.homeDao.selectExport(address, dateIn, dateOut, person);
				System.out.println("-----------------------�˻�list���--------------");
				for (HouseDto houseDto : searchList) {
					System.out.println(houseDto.getHname());
				}
				search = new Search(home.main_frame, searchList);
				home.main_frame.intentp.add("s", search);
				home.main_frame.changePanel("s");
				
			} catch (NullPointerException e1) {
				e1.getMessage();
				JOptionPane.showMessageDialog(null, "���ð��� �߸��Ǿ����ϴ�.");
			} catch (NoSuchElementException e2) {
				e2.getMessage();
				JOptionPane.showMessageDialog(null, "���ð��� �߸��Ǿ����ϴ�.");
			} 
		}
	}
}
