package com.bb.home.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.bb.common.controller.FrameClose;
import com.bb.home.controller.AddressLogic;
import java.awt.Color;

public class Address extends JFrame {

	private JPanel contentPane;

	JPanel pN = new JPanel();
	JPanel pC = new JPanel();

	private JLabel searchLbl = new JLabel("\uB3C4\uB85C\uBA85 \uC8FC\uC18C\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694.");
	public JTextField searchTf = new JTextField();
	public JButton searchBtn = new JButton("검색");

	public JList<String> list;
	public DefaultListModel<String> listModel;

	public JLabel extLabel;

	public Address() {

		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("주소찾기");

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 10));

		Font f = new Font("굴림", Font.PLAIN, 14);
		pN.setBackground(Color.WHITE);

		pN.setLayout(new BorderLayout(10, 5));
		searchLbl.setBackground(Color.WHITE);

		searchLbl.setBounds(0, 0, 57, 15);
		searchTf.setBounds(0, 0, 116, 21);
		searchTf.setColumns(10);
		searchLbl.setFont(f);
		searchTf.setFont(f);
		searchBtn.setForeground(Color.WHITE);
		searchBtn.setBackground(new Color(35, 86, 149));
		searchBtn.setFont(f);

		pN.add(searchLbl, "North");
		pN.add(searchTf, "Center");
		pN.add(searchBtn, "East");
		contentPane.add(pN, BorderLayout.NORTH);

		listModel = new DefaultListModel<String>();
		listModel.addElement("주소를 검색해주세요.");

		list = new JList<String>(listModel);
		list.setFont(f);

		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setPreferredSize(new Dimension(395, 158));
		pC.setBackground(Color.WHITE);
		pC.add(scrollPane);

		contentPane.add(pC, BorderLayout.CENTER);

		// 등록부
		AddressLogic al = new AddressLogic(this);
		
		// 이벤트 등록
		//
		// dateTable.addMouseListener(scl);
		// b1.addActionListener(scl);
		searchTf.addActionListener(al);
		searchBtn.addActionListener(al);
		list.addMouseListener(al);

		addWindowListener(new FrameClose(this));
	}
}
