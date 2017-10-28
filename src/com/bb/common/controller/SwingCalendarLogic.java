package com.bb.common.controller;

import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.*;

import com.bb.common.SwingCalendar;

public class SwingCalendarLogic extends MouseAdapter implements ActionListener {

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
				sc.extLabel.setText(year + ". " + month + ". " + target.getValueAt(row, column));
				sc.setVisible(false);
			}
		}
	}

	public void updateDate() {
		cal.set(Calendar.DAY_OF_MONTH, 1);

		month = cal.get(Calendar.MONTH) + 1;
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

	public void tableCellCenter(JTable t) {

		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = t.getColumnModel();
		int col = tcm.getColumnCount();
		for (int i=0;i<col;i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}

	}
}
