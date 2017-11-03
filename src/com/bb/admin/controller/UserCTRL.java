package com.bb.admin.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.bb.admin.model.UserDAO;
import com.bb.admin.view.UserManagement;

public class UserCTRL implements ActionListener {
	
	public UserManagement userManagement;
	public UserDAO userDAO;

	public UserCTRL(UserManagement userManagement) {
		this.userManagement = userManagement;
		userDAO = new UserDAO(userManagement);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		
		if (obj == userManagement.btnSearch) {
			String mstatus = userManagement.cbMstatus.getSelectedItem().toString();
			String mdate = userManagement.tfMdate.getText();
			String mid = userManagement.tfMid.getText();
			String mname = userManagement.tfMname.getText();
			userDAO.search(mstatus, mdate, mid, mname);
		}
		else if (obj == userManagement.btnBlock) {
			int[] row = userManagement.table.getSelectedRows();
			int num = userManagement.table.getSelectedRowCount();
			int[] mno = new int[num];
			for (int i = 0; i < num; ++i) {
				mno[i] = (int) userManagement.table.getValueAt(row[i], 1);
				System.out.println(mno[i]);
			}
			userDAO.block(num, mno);
		}
		else if (obj == userManagement.btnUnBlock) {
			int[] row = userManagement.table.getSelectedRows();
			int num = userManagement.table.getSelectedRowCount();
			int[] mno = new int[num];
			for (int i = 0; i < num; ++i) {
				mno[i] = (int) userManagement.table.getValueAt(row[i], 1);
				System.out.println(mno[i]);
			}
			userDAO.unblock(num, mno);
		}
	}

}
