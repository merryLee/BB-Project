package com.bb.home.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JList;

import com.bb.home.model.AddressDao;
import com.bb.home.view.Address;

public class AddressLogic extends MouseAdapter implements ActionListener {

	Address address;
	AddressDao adao = new AddressDao();
	List<String> resultList;

	public AddressLogic(Address address) {
		this.address = address;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String keyword = "";

		if (obj == address.searchTf || obj == address.searchBtn) {
			keyword = address.searchTf.getText();
			resultList = adao.selectAddress(keyword);
			System.out.println("다오 - 검색쿼리실행성공!");
			if (!resultList.isEmpty()) {
				address.listModel.removeAllElements();
				for (String r : resultList) {
					address.listModel.addElement(r);
				}
			} else {
				address.listModel.removeAllElements();
				address.listModel.addElement("검색된 데이터가 없습니다.");
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JList target = (JList) e.getSource();
		if (e.getClickCount() == 2) {
			int index = target.locationToIndex(e.getPoint());
			if (index >= 0) {
				Object o = target.getModel().getElementAt(index);
				address.extLabel.setText(o.toString().substring(8));
				address.setVisible(false);
			}
		}

	}

}
