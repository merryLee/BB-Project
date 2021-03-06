package com.bb.admin.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import com.bb.admin.model.BookDAO;
import com.bb.admin.view.Alert;
import com.bb.admin.view.BookManagement;

public class BookCTRL extends MouseAdapter implements ActionListener {

	public BookManagement bookManagement;
	public BookDAO bookDAO;
	
	public BookCTRL(BookManagement bookManagement) {
		this.bookManagement = bookManagement;
		bookDAO = new BookDAO(bookManagement);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		
		if (obj == bookManagement.btnSearch) {
			String bstatus = bookManagement.cbBstatus.getSelectedItem().toString();
			String bdate = bookManagement.tfBdate.getText();
			String bguest = bookManagement.tfBguest.getText();
			String hhost = bookManagement.tfHhost.getText();
			bookDAO.search(bstatus, bdate, bguest, hhost);
		}
		else if (obj == bookManagement.btnDelete) {
			int[] row = bookManagement.table.getSelectedRows();
			int num = bookManagement.table.getSelectedRowCount();
			int[] bno = new int[num];
			for (int i = 0; i < num; ++i) {
				bno[i] = (int) bookManagement.table.getValueAt(row[i], 1);
				System.out.println(bno[i]);
			}
			if (bookDAO.isPossibleToDelete(num, bno)) {
				bookDAO.delete(num, bno);				
			}
			else {
				Alert alert = new Alert("선택하신 예약 건은 삭제가 불가합니다.");
			}
		}
	}

//	@Override
//	public void mouseClicked(MouseEvent e) {
//		
//		if (e.getClickCount() == 2) {
//			상세페이지 이동
//		}
//	}
	
}
