package com.bb.admin.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import com.bb.admin.model.HouseDAO;
import com.bb.admin.view.HouseManagement;

public class HouseCTRL extends MouseAdapter implements ActionListener {

	public HouseManagement houseManagement;
	public HouseDAO houseDAO;
	
	public HouseCTRL(HouseManagement houseManagement) {
		this.houseManagement = houseManagement;
		houseDAO = new HouseDAO(houseManagement);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		
		if (obj == houseManagement.btnSearch) {
			String bstatus = houseManagement.cbBstatus.getSelectedItem().toString();
			String hstatus = houseManagement.cbHstatus.getSelectedItem().toString();
			String hdate = houseManagement.tfHdate.getText();
			String hhost = houseManagement.tfHhost.getText();
			String hname = houseManagement.tfHname.getText();
			houseDAO.search(bstatus, hstatus, hdate, hhost, hname);
		}
		else if (obj == houseManagement.btnDelete) {
			int[] row = houseManagement.table.getSelectedRows();
			int num = houseManagement.table.getSelectedRowCount();
			int[] hno = new int[num];
			for (int i = 0; i < num; ++i) {
				hno[i] = (int) houseManagement.model.getValueAt(row[i], 1);
				System.out.println(hno[i]);
			}
			houseDAO.delete(num, hno);
		}
		else if (obj == houseManagement.btnPermit) {
			int[] row = houseManagement.table.getSelectedRows();
			int num = houseManagement.table.getSelectedRowCount();
			int[] hno = new int[num];
			for (int i = 0; i < num; ++i) {
				hno[i] = (int) houseManagement.model.getValueAt(row[i], 1);
				System.out.println(hno[i]);
			}
			houseDAO.permit(num, hno);
		}
		else if (obj == houseManagement.btnCancel) {
			int[] row = houseManagement.table.getSelectedRows();
			int num = houseManagement.table.getSelectedRowCount();
			int hno[] = new int[num];
			for (int i = 0; i < num; ++i) {
				hno[i] = (int) houseManagement.model.getValueAt(row[i], 1);
				System.out.println(hno[i]);
			}
			houseDAO.cancel(num, hno);
		}
	}
	
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		
//		if (e.getButton() == 2) {
//			상세페이지 이동
//		}
//	}

}
