package com.bb.home.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import com.bb.home.view.Address;
import com.bb.home.view.Home;
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
		for(int i=0;i<size;i++) {
			if(obj == search.hBtnList.get(i)) {
				System.out.println("logic = " + search.searchList.get(i).getHname());	//house에값 넘겨줘야함.
				hi = new HouseInfo(search.searchList.get(i));
				search.main_frame.intentp.add("houseinfo",hi);
				search.main_frame.changePanel("houseinfo");
			}
		}
		if(obj == search.searchBtn) {
			List<HouseDto> searchList = new ArrayList<HouseDto>();
			
//			System.out.println(home.address.getText());
//			System.out.println(home.dateIn.getText());
//			System.out.println(home.dateOut.getText());
//			System.out.println(home.person.getSelectedItem().toString());
			
			searchList = search.homeDao.selectExport(search.address.getText(), search.dateIn.getText(), 
					search.dateOut.getText(), search.person.getSelectedItem().toString());
			System.out.println("-----------------------검색list출력--------------");
			for (HouseDto houseDto : searchList) {
				System.out.println(houseDto.getHname());
			}
			search.main_frame.intentp.remove(search);
			search = new Search(search.main_frame, searchList);
			search.main_frame.intentp.add("s", search);
			search.main_frame.changePanel("s");
		}
	}

}
