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

import com.bb.admin.controller.UserCTRL;
import javax.swing.UIManager;

public class UserManagement extends JPanel {
	
	public JComboBox cbMstatus;
	
	public JTextField tfMdate;
	public JTextField tfMid;
	public JTextField tfMname;
	
	public Vector<String> column;
	public DefaultTableModel model;
	public JTable table;
	public JScrollPane scrollPane;
	
	public JButton btnSearch;
	public JButton btnBlock;
	public JButton btnUnBlock;

	/**
	 * Create the panel.
	 */
	public UserManagement() {
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setBackground(UIManager.getColor("Panel.background"));
		setBounds(new Rectangle(0, 0, 753, 553));
		setLayout(null);
		
		UserCTRL userCTRL = new UserCTRL(this);
		
		JLabel lbMstatus = new JLabel("\uD68C\uC6D0 \uC0C1\uD0DC :");
		lbMstatus.setBounds(15, 18, 87, 15);
		add(lbMstatus);
		
		String[] strMstatus = {"-", "차단회원", "이용회원"};
		cbMstatus = new JComboBox(strMstatus);
		cbMstatus.setBounds(101, 15, 98, 21);
		add(cbMstatus);
		
		JLabel lbMdate = new JLabel("\uAC00\uC785 \uC77C\uC790 :");
		lbMdate.setBounds(15, 47, 87, 15);
		add(lbMdate);
		
		tfMdate = new JTextField();
		tfMdate.setColumns(10);
		tfMdate.setBounds(101, 43, 513, 21);
		add(tfMdate);
		
		JLabel lbMid = new JLabel("\uD68C\uC6D0 ID :");
		lbMid.setBounds(15, 76, 87, 15);
		add(lbMid);
		
		tfMid = new JTextField();
		tfMid.setColumns(10);
		tfMid.setBounds(101, 72, 513, 21);
		add(tfMid);
		
		JLabel lbMname = new JLabel("\uD68C\uC6D0 \uC774\uB984 :");
		lbMname.setBounds(15, 102, 87, 15);
		add(lbMname);
		
		tfMname = new JTextField();
		tfMname.setColumns(10);
		tfMname.setBounds(101, 99, 513, 21);
		add(tfMname);
		
		btnSearch = new JButton("\uAC80\uC0C9");
		btnSearch.addActionListener(userCTRL);
		btnSearch.setBounds(617, 16, 105, 110);
		add(btnSearch);
		
		column = new Vector<String>();
		column.addElement("NO.");
		column.addElement("회원번호");
		column.addElement("회원ID");
		column.addElement("회원이름");
		column.addElement("가입일자");
		column.addElement("회원상태");
		
		model = new DefaultTableModel(column, 0) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		
		userCTRL.userDAO.setData();
		
		table = new JTable(model);
		
		table.getColumn("NO.").setPreferredWidth(10);
		table.getColumn("회원번호").setPreferredWidth(10);
		table.getColumn("회원ID").setPreferredWidth(10);
		table.getColumn("회원이름").setPreferredWidth(10);
		table.getColumn("가입일자").setPreferredWidth(60);
		table.getColumn("회원상태").setPreferredWidth(10);
		
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION	);
		table.setSelectionBackground(Color.GRAY);
		
//		table.addMouseListener(userCTRL);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setAutoscrolls(true);
		scrollPane.setBounds(15, 132, 702, 322);
		add(scrollPane);
		
		btnUnBlock = new JButton("\uB4F1\uB85D \uCDE8\uC18C");
		btnUnBlock.addActionListener(userCTRL);
		btnUnBlock.setBounds(524, 461, 97, 39);
		add(btnUnBlock);
		
		btnBlock = new JButton("\uD68C\uC6D0 \uCC28\uB2E8");
		btnBlock.addActionListener(userCTRL);
		btnBlock.setBounds(622, 461, 97, 39);
		add(btnBlock);
		

	}

}
