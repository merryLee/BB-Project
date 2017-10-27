package com.bb.common.model;

import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JTable;

import com.bb.common.SwingCalendar;

public class SwingCalendarLogic implements ActionListener, MouseListener, WindowListener {

	SwingCalendar sc;
	private Calendar cal = new GregorianCalendar();
	private int month;
	private int year;
	
	public SwingCalendarLogic(SwingCalendar sc) {
		this.sc = sc;	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String key = e.getActionCommand();
		if ("<".equals(key)) { // b1
			cal.add(Calendar.MONTH, -1);
			updateDate();
		}
		if (">".equals(key)) { // b2
			cal.add(Calendar.MONTH, +1);
			updateDate();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JTable target = (JTable) e.getSource();
		int row = target.getSelectedRow();
		int column = target.getSelectedColumn();
		
		if (e.getButton() == 1) {
			if (e.getClickCount() == 2) {
				sc.extField.setText(year + ". " + month + ". " + target.getValueAt(row, column));
				sc.setVisible(false);
			}
		}
	}
	
	
	public void updateDate() {
		cal.set(Calendar.DAY_OF_MONTH, 1);
		
		month = cal.get(Calendar.MONTH);
		year = cal.get(Calendar.YEAR);
		sc.dateLabel.setText(year + ". " + month + ". ");
		
		int startDay = cal.get(Calendar.DAY_OF_WEEK);
		int numberOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int weeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
		
		sc.model.setRowCount(0);
		sc.model.setRowCount(weeks);
		
		int i = startDay - 1;
		for (int day = 1; day <= numberOfDays; day++) {
			sc.model.setValueAt(day, i / 7, i % 7);
			i = i + 1;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		sc.setVisible(false);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
