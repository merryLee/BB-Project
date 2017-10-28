package com.bb.home.view;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;

import javax.swing.*;

import com.bb.home.controller.HomeLogic;
import com.bb.home.model.HomeDao;
import com.bb.house.model.HouseDto;

import bb_final.Main_frame;

public class Home extends JPanel {

	public Main_frame main_frame;

	ImageIcon mainImg;
	JLabel mainText1 = new JLabel();
	JLabel mainText2 = new JLabel();
	JLabel mainText3 = new JLabel();

	JLabel labelS = new JLabel("SEARCH");
	JLabel location = new JLabel();
	JLabel labelS1 = new JLabel("\uC704\uCE58");
	JLabel labelS2 = new JLabel("\uCCB4\uD06C\uC778");
	JLabel labelS3 = new JLabel("\uCCB4\uD06C\uC544\uC6C3");
	JLabel labelS4 = new JLabel("\uCD5C\uB300\uC778\uC6D0");
	JButton button = new JButton("Search");

	public JLabel dateIn = new JLabel();
	public JLabel dateOut = new JLabel();
	JComboBox<String> person = new JComboBox<String>();

	JLabel labelR = new JLabel("RECOMMENDATION");
	public List<HouseDto> hList;
	public List<JButton> hBtnList;

	public Home(Main_frame main_frame) {
		this.main_frame = main_frame;
		setBackground(Color.WHITE);
		setBounds(new Rectangle(0, 0, 775, 559));
		setLayout(null);

		mainImg = new ImageIcon(".\\img\\blackBB.jpg");
		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(mainImg.getImage(), 0, 0, null);
				setOpaque(false);
				// super.paintComponent(g);
			}
		};
		panel.setBounds(22, 30, 200, 200);
		mainText1.setText("Best Bed\uB97C BB\uC5D0\uC11C!");
		mainText1.setForeground(new Color(0, 115, 170));
		mainText1.setFont(new Font("Dialog", Font.BOLD, 30));
		mainText1.setBounds(234, 108, 398, 46);
		mainText2.setText("\uC548\uC804\uD558\uACE0 \uD569\uB9AC\uC801\uC778 \uC219\uC18C");
		mainText2.setForeground(new Color(50, 55, 60));
		mainText2.setFont(new Font("Dialog", Font.PLAIN, 26));
		mainText2.setBounds(234, 154, 398, 38);
		mainText3.setText("\uD55C\uBC88\uC5D0 \uB9CC\uB098\uBCF4\uC138\uC694");
		mainText3.setForeground(new Color(50, 55, 60));
		mainText3.setFont(new Font("Dialog", Font.PLAIN, 26));
		mainText3.setBounds(234, 192, 398, 38);
		add(panel); // �ΰ��̹���
		add(mainText1);
		add(mainText2);
		add(mainText3);

		labelS.setFont(new Font("Dialog", Font.PLAIN, 20));
		labelS.setBounds(22, 260, 200, 28);
		labelS1.setFont(new Font("����", Font.PLAIN, 13));
		labelS1.setBounds(22, 292, 57, 15);
		labelS2.setFont(new Font("����", Font.PLAIN, 13));
		labelS2.setBounds(181, 292, 57, 15);
		labelS3.setFont(new Font("����", Font.PLAIN, 13));
		labelS3.setBounds(340, 292, 97, 15);
		labelS4.setFont(new Font("����", Font.PLAIN, 13));
		labelS4.setBounds(499, 292, 57, 15);
		add(labelS);
		add(labelS1);
		add(labelS2);
		add(labelS3);
		add(labelS4);

		location.setBounds(22, 308, 140, 24);
		location.setBorder(UIManager.getBorder("TextField.border"));
		dateIn.setBounds(181, 308, 140, 24);
		dateOut.setBounds(340, 308, 140, 24);
		dateIn.setBorder(UIManager.getBorder("TextField.border"));
		dateOut.setBorder(UIManager.getBorder("TextField.border"));
		person.setBounds(499, 308, 140, 24);
		person.addItem("���� 1��");
		person.addItem("���� 2��");
		person.addItem("���� 4��");
		person.addItem("���� 6��");
		person.addItem("���� 8��");
		person.addItem("���� 10��");
		person.addItem("10�� �̻�");
		button.setBackground(new Color(38, 84, 149));
		button.setForeground(Color.WHITE);
		button.setBounds(657, 308, 76, 24);

		add(location);
		add(dateIn);
		add(dateOut);
		add(person);
		add(button);

		labelR.setFont(new Font("Dialog", Font.PLAIN, 20)); // RECOMMENDED
		labelR.setBounds(22, 351, 200, 28);
		add(labelR);

		JPanel homePanel = new JPanel(new GridLayout(1, 4, 20, 0));
		homePanel.setBounds(22, 380, 711, 154);
		HomeDao houseDao = new HomeDao();
		hList = houseDao.selectTop(); // top4 ����Ʈ�޾ƿ�
		hBtnList = new ArrayList<JButton>();
		int size = hList.size();

		JButton hBtn;
		for (int i = 0; i < size; i++) { // �̹�����ư ���� �� ����Ʈ�� ����.
			hBtn = new JButton("hBtn"+i, new ImageIcon(hList.get(i).getHpath1()));
		
			hBtnList.add(hBtn);
			homePanel.add(hBtn);
		}
		add(homePanel);

		HomeLogic hl = new HomeLogic(this);

		dateIn.addMouseListener(hl);
		dateOut.addMouseListener(hl);

		for (int i = 0; i < size; i++) { // �������߰�
			hBtnList.get(i).addActionListener(hl);
		}

	}
}