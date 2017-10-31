package com.bb.home.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

import javax.swing.JOptionPane;

import com.bb.home.view.Address;
import com.bb.home.view.Search;
import com.bb.home.view.SwingCalendar;
import com.bb.house.model.HouseDto;
import com.bb.house.view.HouseInfo;

public class SearchLogic extends MouseAdapter implements ActionListener {

	Search search;
	SwingCalendar sc = new SwingCalendar();
	Address address = new Address();
	public HouseInfo hi;

	public SearchLogic(Search search) {
		this.search = search;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object ob = e.getSource();

		if (ob == search.dateIn) {
			sc.setVisible(true);
			sc.extLabel = search.dateIn;
			sc.setTitle("체크인");
		}
		if (ob == search.dateOut) {
			sc.setVisible(true);
			sc.extLabel = search.dateOut;
			sc.setTitle("체크아웃");
		}
		if (ob == search.address) {
			address.setVisible(true);
			address.extLabel = search.address;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		int size = search.hBtnList.size();
		for (int i = 0; i < size; i++) {
			if (obj == search.hBtnList.get(i)) {
				System.out.println("logic = " + search.searchList.get(i).getHname()); // house에값 넘겨줘야함.
				hi = new HouseInfo(search.searchList.get(i), search.main_frame);
				System.out.println("생성완료");

				search.main_frame.intentp.add("houseinfo", hi);
				System.out.println("삽입완료");
				search.main_frame.changePanel("houseinfo");
			}
		}
		if (obj == search.searchBtn) {

			System.out.println("값읽기 성공1");

			try {
				String address = search.address.getText();
				String dateIn = search.dateIn.getText();
				String dateOut = search.dateOut.getText();
				String person = search.person.getSelectedItem().toString();

				List<HouseDto> searchList = new ArrayList<HouseDto>();

				searchList = search.homeDao.selectExport(address, dateIn, dateOut, person);
				System.out.println("-----------------------검색list출력--------------");
				for (HouseDto houseDto : searchList) {
					System.out.println(houseDto.getHname());
				}
				// search.main_frame.intentp.remove(search);
				search = new Search(search.main_frame, searchList);
				search.main_frame.intentp.add("s", search);
				search.main_frame.changePanel("s");

			} catch (NullPointerException e1) {
				e1.getMessage();
				JOptionPane.showMessageDialog(null, "선택값이 잘못되었습니다.");
			} catch (NoSuchElementException e2) {
				e2.getMessage();
				JOptionPane.showMessageDialog(null, "선택값이 잘못되었습니다.");
			}
		}

	}

}
