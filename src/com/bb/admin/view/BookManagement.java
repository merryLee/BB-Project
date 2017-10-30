package com.bb.admin.view;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.bb.admin.controller.BookCTRL;

public class BookManagement extends JPanel {
	
	public JComboBox cbBstatus;
	
	public JTextField tfBdate;
	public JTextField tfBguest;
	public JTextField tfHhost;
	
	public static Vector<String> column;
	public static DefaultTableModel model;
	public JTable table;
	public JScrollPane scrollPane;

	public JButton btnSearch;
	public JButton btnDelete;
	
	/**
	 * Create the panel.
	 */
	public BookManagement() {
		setBorder(new EmptyBorder(0, 0, 0, 0));		
//		setBackground(SystemColor.desktop);
		setBackground(Color.WHITE);
		setBounds(new Rectangle(0, 0, 753, 553));
		setLayout(null);

		BookCTRL bookCTRL = new BookCTRL(this);
		
		JLabel lbBstatus = new JLabel("\uC608\uC57D \uC0C1\uD0DC :");
		lbBstatus.setBounds(15, 18, 87, 15);
		add(lbBstatus);
		
		String[] strBstatus = {"-", "예약취소", "예약확정"};
		cbBstatus = new JComboBox(strBstatus);
		cbBstatus.setBounds(101, 15, 98, 21);
		add(cbBstatus);
		
		JLabel lbBdate = new JLabel("\uC608\uC57D \uC77C\uC790 :");
		lbBdate.setBounds(15, 47, 87, 15);
		add(lbBdate);
		
		tfBdate = new JTextField();
		tfBdate.setColumns(10);
		tfBdate.setBounds(101, 43, 513, 21);
		add(tfBdate);
		
		JLabel lbBguest = new JLabel("\uC190\uB2D8 \uC774\uB984 :");
		lbBguest.setBounds(15, 76, 87, 15);
		add(lbBguest);
		
		tfBguest = new JTextField();
		tfBguest.setColumns(10);
		tfBguest.setBounds(101, 72, 513, 21);
		add(tfBguest);
		
		JLabel lbHhost = new JLabel("\uC8FC\uC778 \uC774\uB984 :");
		lbHhost.setBounds(15, 102, 87, 15);
		add(lbHhost);
		
		tfHhost = new JTextField();
		tfHhost.setColumns(10);
		tfHhost.setBounds(101, 99, 513, 21);
		add(tfHhost);
		
		btnSearch = new JButton("\uAC80\uC0C9");
		btnSearch.addActionListener(bookCTRL);
		btnSearch.setBounds(615, 15, 105, 110);
		add(btnSearch);
		
		column = new Vector<String>();
		column.addElement("숙소번호");
		column.addElement("숙소이름");
		column.addElement("주인이름");
		column.addElement("숙소가격");
		column.addElement("평균평점");
		column.addElement("예약상태");
		column.addElement("등록일자");
		column.addElement("등록상태");
		
		model = new DefaultTableModel(column, 0) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		
		bookCTRL.bookDAO.setData();
		
		table = new JTable(model);
		
//		table.getColumn("예약번호").setPreferredWidth(20);
//		table.getColumn("손님이름").setPreferredWidth(20);
//		table.getColumn("숙소이름").setPreferredWidth(20);
//		table.getColumn("주인이름").setPreferredWidth(20);
//		table.getColumn("입실일자").setPreferredWidth(10);
//		table.getColumn("퇴실일자").setPreferredWidth(10);
//		table.getColumn("예약일자").setPreferredWidth(120);
//		table.getColumn("예약상태").setPreferredWidth(10);
		
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setSelectionBackground(Color.GRAY);
		
//		table.addMouseListener(bookCTRL);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setAutoscrolls(true);
		scrollPane.setBounds(15, 132, 702, 322);
		add(scrollPane);

		btnDelete = new JButton("\uC608\uC57D \uC0AD\uC81C");
		btnDelete.addActionListener(bookCTRL);
		btnDelete.setBounds(622, 461, 97, 39);
		add(btnDelete);

	}
}
