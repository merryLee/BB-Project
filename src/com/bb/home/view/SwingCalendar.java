package com.bb.home.view;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.bb.common.controller.FrameClose;
import com.bb.home.controller.SwingCalendarLogic;

public class SwingCalendar extends JFrame {
	private JPanel contentPane;
	JPanel datePanel = new JPanel();

	JButton b1 = new JButton("<");
	public JLabel dateLabel = new JLabel();
	JButton b2 = new JButton(">");

	public JTable dateTable;
	public DefaultTableModel model;
	
	public JLabel extLabel;

	public SwingCalendar() {

		setTitle("Calendar");
		// setDefaultCloseOperation(SwingCalendar.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);

		datePanel.setLayout(new BorderLayout());
		datePanel.setBorder(new EmptyBorder(10, 0, 10, 0));
		datePanel.add(b1, BorderLayout.WEST);
		datePanel.add(dateLabel, BorderLayout.CENTER);
		datePanel.add(b2, BorderLayout.EAST);

		String[] columns = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
		model = new DefaultTableModel(null, columns) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		dateTable = new JTable(model);
		dateTable.setRowHeight(20);
		dateTable.getTableHeader().setReorderingAllowed(false);
		dateTable.setCellSelectionEnabled(true);

		JScrollPane pane = new JScrollPane(dateTable);
		pane.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		getContentPane().add(datePanel, BorderLayout.NORTH);
		getContentPane().add(pane, BorderLayout.CENTER);

		setBounds(100, 100, 360, 260);
		setVisible(false);

		// 등록부
		SwingCalendarLogic scl = new SwingCalendarLogic(this);
		scl.updateDate();
		scl.tableCellCenter(dateTable);
		
		// 이벤트 등록
		dateTable.addMouseListener(scl);
		b1.addActionListener(scl);
		b2.addActionListener(scl);
		
		addWindowListener(new FrameClose(this));
	}

}