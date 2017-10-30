package com.bb.home.view;

import java.awt.BorderLayout;
import java.awt.Color;
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

public class Address extends JFrame {

	private JPanel contentPane;

	JPanel pN = new JPanel();
	JPanel pC = new JPanel();

	private JLabel searchLbl = new JLabel("���θ� �ּҸ� �Է����ּ���. (ex ����, ��������, ���۷�292����)");
	public JTextField searchTf = new JTextField();
	private JButton searchBtn = new JButton("�˻�");

	public JList<String> list;
	public DefaultListModel<String> listModel;

	public JLabel extLabel;

	public Address() {

		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("�ּ�ã��");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(new BorderLayout(0, 10));

		Font f = new Font("����", Font.PLAIN, 14);

		pN.setLayout(new BorderLayout(10, 5));

		searchLbl.setBounds(0, 0, 57, 15);
		searchTf.setBounds(0, 0, 116, 21);
		searchTf.setColumns(10);
		searchLbl.setFont(f);
		searchTf.setFont(f);
		searchBtn.setFont(f);

		pN.add(searchLbl, "North");
		pN.add(searchTf, "Center");
		pN.add(searchBtn, "East");
		contentPane.add(pN, BorderLayout.NORTH);

		listModel = new DefaultListModel<String>();
		listModel.addElement("�ּҸ� �˻����ּ���.");

		list = new JList<String>(listModel);
		list.setFont(f);

		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setPreferredSize(new Dimension(395, 158));
		pC.add(scrollPane);

		contentPane.add(pC, BorderLayout.CENTER);

		// ��Ϻ�
		AddressLogic al = new AddressLogic(this);
		
		// �̺�Ʈ ���
		//
		// dateTable.addMouseListener(scl);
		// b1.addActionListener(scl);
		searchBtn.addActionListener(al);
		list.addMouseListener(al);

		addWindowListener(new FrameClose(this));
	}
}
