package com.kitri.main;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class SwingCalendar extends JFrame {
	private JPanel contentPane;

	DefaultTableModel model;
	Calendar cal = new GregorianCalendar();
	JLabel label;
	public JTextField extField;
	int month;
	int year;

	public SwingCalendar() {
		
//		this.extField = extField;
		setTitle("Calendar");
		setDefaultCloseOperation(SwingCalendar.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(new BorderLayout(0, 0));
		

		setContentPane(contentPane);


		label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);

		JButton b1 = new JButton("<");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				cal.add(Calendar.MONTH, -1);
				updateMonth();
			}
		});

		JButton b2 = new JButton(">");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				cal.add(Calendar.MONTH, +1);
				updateMonth();
			}
		});

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(new EmptyBorder(10, 0, 10, 0));
		panel.add(b1, BorderLayout.WEST);
		panel.add(label, BorderLayout.CENTER);
		panel.add(b2, BorderLayout.EAST);

		String[] columns = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
		model = new DefaultTableModel(null, columns) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		JTable table = new JTable(model);
		table.setBorder(null);

		table.getTableHeader().setReorderingAllowed(false);

		table.setCellSelectionEnabled(true);
		JScrollPane pane = new JScrollPane(table);
//		pane.add(table);
		pane.setBackground(Color.GREEN);
		pane.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		getContentPane().add(panel, BorderLayout.NORTH);
		getContentPane().add(pane, BorderLayout.CENTER);

		this.updateMonth();

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JTable target = (JTable) e.getSource();
				int row = target.getSelectedRow();
				int column = target.getSelectedColumn();

				if (e.getButton() == 1) {
					if (e.getClickCount() == 2) {
						System.out.println("두번클릭 = " + row + " " + column);
						extField.setText(year + ". " + month + ". " + target.getValueAt(row, column) + "");
						
						setVisible(false);
						
					} else {
						System.out.println(target.getValueAt(row, column));
						
						System.out.println("한번클릭 = " + row + " " + column);
					}
				}
			}
		});

		System.out.println(table.getColumnCount() + " " + table.getY());
		System.out.println(table.getHeight());
		table.setRowHeight(20);
		

		setBounds(100, 100, 360, 260);
		setVisible(false);
	}

	void updateMonth() {
		cal.set(Calendar.DAY_OF_MONTH, 1);

		month = cal.get(Calendar.MONTH);
		year = cal.get(Calendar.YEAR);
		label.setText(year + ". " + month + ". ");

		int startDay = cal.get(Calendar.DAY_OF_WEEK);
		int numberOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int weeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);

		model.setRowCount(0);
		model.setRowCount(weeks);

		int i = startDay - 1;
		for (int day = 1; day <= numberOfDays; day++) {
			model.setValueAt(day, i / 7, i % 7);
			i = i + 1;
		}

	}

}