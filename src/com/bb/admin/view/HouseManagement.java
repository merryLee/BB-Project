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

import com.bb.admin.controller.HouseCTRL;

public class HouseManagement extends JPanel {
	
	public JComboBox cbBstatus;
	public JComboBox cbHstatus;
	
	public JTextField tfHdate;
	public JTextField tfHhost;
	public JTextField tfHname;
	
	public static Vector<String> column;
	public static DefaultTableModel model;
	public JTable table;
	public JScrollPane scrollPane;
	
	public JButton btnSearch;
	public JButton btnPermit;
	public JButton btnCancel;
	public JButton btnDelete;

	/**
	 * Create the panel.
	 */
	public HouseManagement() {
		setBounds(new Rectangle(0, 0, 753, 553));
//		setBackground(SystemColor.desktop);
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setLayout(null);
		
		HouseCTRL houseCTRL = new HouseCTRL(this);
		
		JLabel lbBstatus = new JLabel("\uC608\uC57D \uC0C1\uD0DC :");
		lbBstatus.setBounds(15, 18, 87, 15);
		add(lbBstatus);
		
		String[] strBstatus = {"-", "예약취소", "예약확정"};
		cbBstatus = new JComboBox(strBstatus);
		cbBstatus.setBounds(101, 15, 98, 21);
		add(cbBstatus);
		
		JLabel lbhHstatus = new JLabel("\uB4F1\uB85D \uC0C1\uD0DC :");
		lbhHstatus.setBounds(206, 18, 68, 15);
		add(lbhHstatus);
		
		String[] strHstatus = {"-", "삭제", "등록중", "등록됨", "등록취소"};
		cbHstatus = new JComboBox(strHstatus);
		cbHstatus.setBounds(275, 15, 98, 21);
		add(cbHstatus);
		
		JLabel lbHdate = new JLabel("\uB4F1\uB85D \uC77C\uC790 :");
		lbHdate.setBounds(15, 47, 87, 15);
		add(lbHdate);
		
		tfHdate = new JTextField();
		tfHdate.setColumns(10);
		tfHdate.setBounds(101, 43, 513, 21);
		add(tfHdate);
		
		JLabel lbHhost = new JLabel("\uC8FC\uC778 \uC774\uB984 :");
		lbHhost.setBounds(15, 76, 87, 15);
		add(lbHhost);
		
		tfHhost = new JTextField();
		tfHhost.setColumns(10);
		tfHhost.setBounds(101, 72, 513, 21);
		add(tfHhost);
		
		JLabel lbHname = new JLabel("\uC219\uC18C \uC774\uB984 :");
		lbHname.setBounds(15, 102, 87, 15);
		add(lbHname);
		
		tfHname = new JTextField();
		tfHname.setColumns(10);
		tfHname.setBounds(101, 99, 513, 21);
		add(tfHname);
		
		btnSearch = new JButton("\uAC80\uC0C9");
		btnSearch.addActionListener(houseCTRL);
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
		
		houseCTRL.houseDAO.setData();
		
		table = new JTable(model);
		
		table.getColumn("숙소번호").setPreferredWidth(20);
		table.getColumn("숙소이름").setPreferredWidth(20);
		table.getColumn("주인이름").setPreferredWidth(20);
		table.getColumn("숙소가격").setPreferredWidth(20);
		table.getColumn("평균평점").setPreferredWidth(10);
		table.getColumn("예약상태").setPreferredWidth(10);
		table.getColumn("등록일자").setPreferredWidth(120);
		table.getColumn("등록상태").setPreferredWidth(10);
		
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setSelectionBackground(Color.GRAY);
		
//		table.addMouseListener(houseCTRL);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setAutoscrolls(true);
		scrollPane.setBounds(15, 132, 702, 322);
		add(scrollPane);
		
		btnPermit = new JButton("\uB4F1\uB85D \uD5C8\uAC00");
		btnPermit.addActionListener(houseCTRL);
		btnPermit.setBounds(426, 461, 97, 39);
		add(btnPermit);
		
		btnCancel = new JButton("\uB4F1\uB85D \uCDE8\uC18C");
		btnCancel.addActionListener(houseCTRL);
		btnCancel.setBounds(524, 461, 97, 39);
		add(btnCancel);
		
		btnDelete = new JButton("\uC219\uC18C \uC0AD\uC81C");
		btnDelete.addActionListener(houseCTRL);
		btnDelete.setBounds(622, 461, 97, 39);
		add(btnDelete);

	}
}
