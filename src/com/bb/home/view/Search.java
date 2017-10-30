package com.bb.home.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

import com.bb.common.view.Main_frame;
import com.bb.home.controller.SearchLogic;
import com.bb.home.model.HomeDao;
import com.bb.house.model.HouseDto;
import javax.swing.ScrollPaneConstants;

public class Search extends JPanel {

	public Main_frame main_frame;
	public List<HouseDto> searchList;

	ImageIcon mainImg;
	JLabel mainText1 = new JLabel();
	JLabel mainText2 = new JLabel();
	JLabel mainText3 = new JLabel();

	JLabel labelS = new JLabel("SEARCH");
	JLabel labelS1 = new JLabel("\uC704\uCE58");
	JLabel labelS2 = new JLabel("\uCCB4\uD06C\uC778");
	JLabel labelS3 = new JLabel("\uCCB4\uD06C\uC544\uC6C3");
	JLabel labelS4 = new JLabel("\uCD5C\uB300\uC778\uC6D0");
	public JButton searchBtn = new JButton("Search");

	public JLabel address = new JLabel();
	public JLabel dateIn = new JLabel();
	public JLabel dateOut = new JLabel();
	public JComboBox<String> person = new JComboBox<String>();

	JLabel labelR = new JLabel("SEARCH");
	public List<HouseDto> hList;
	public List<JButton> hBtnList;

	public HomeDao homeDao = new HomeDao();
	
	public Search(Main_frame main_frame, List<HouseDto> searchList) {
		
		this.main_frame = main_frame;
		this.searchList = searchList;
		System.out.println("search생성성공!");
		setBackground(Color.WHITE);
		setBounds(new Rectangle(0, 0, 775, 559));
		setLayout(null);

		JPanel p = new JPanel();
		p.setLayout(null);
		
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
		p.add(panel); // 로고이미지
		p.add(mainText1);
		p.add(mainText2);
		p.add(mainText3);

		labelS.setFont(new Font("Dialog", Font.PLAIN, 20));
		labelS.setBounds(22, 260, 200, 28);
		labelS1.setFont(new Font("굴림", Font.PLAIN, 13));
		labelS1.setBounds(22, 292, 57, 15);
		labelS2.setFont(new Font("굴림", Font.PLAIN, 13));
		labelS2.setBounds(181, 292, 57, 15);
		labelS3.setFont(new Font("굴림", Font.PLAIN, 13));
		labelS3.setBounds(340, 292, 97, 15);
		labelS4.setFont(new Font("굴림", Font.PLAIN, 13));
		labelS4.setBounds(499, 292, 57, 15);
		p.add(labelS);
		p.add(labelS1);
		p.add(labelS2);
		p.add(labelS3);
		p.add(labelS4);

		address.setBounds(22, 308, 140, 24);
		address.setBorder(UIManager.getBorder("TextField.border"));
		dateIn.setBounds(181, 308, 140, 24);
		dateOut.setBounds(340, 308, 140, 24);
		dateIn.setBorder(UIManager.getBorder("TextField.border"));
		dateOut.setBorder(UIManager.getBorder("TextField.border"));
		person.setBounds(499, 308, 140, 24);
		person.addItem("성인 1명");
		person.addItem("성인 2명");
		person.addItem("성인 4명");
		person.addItem("성인 6명");
		person.addItem("성인 8명");
		person.addItem("성인 10명");
		person.addItem("10명 이상");
		searchBtn.setBackground(new Color(38, 84, 149));
		searchBtn.setForeground(Color.WHITE);
		searchBtn.setBounds(657, 308, 76, 24);

		p.add(address);
		p.add(dateIn);
		p.add(dateOut);
		p.add(person);
		p.add(searchBtn);

		labelR.setFont(new Font("Dialog", Font.PLAIN, 20)); // RECOMMENDED
		labelR.setBounds(22, 351, 200, 28);
		p.add(labelR);

		
		
		JScrollPane pane = new JScrollPane();
		pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pane.setBounds(0, 0, 775, 559);
		add(pane, "Center");
		
		hBtnList = new ArrayList<JButton>();
		JButton hBtn;
		int size = searchList.size();
		System.out.println("사이즈값 불러오기성공");

		JPanel homePanel =  new JPanel();
		JPanel homeContent = null;
		
		for (int i = 0; i < size; i++) {
			if (i % 4 == 0) {
				p.setPreferredSize(new Dimension(775, 559 + (154 * (i/4+1))));
				homePanel.setBounds(22, 380, 711, 154 * (i/4+1)); // 여기의 길이가 늘어나야함.
				homePanel.setLayout(new GridLayout(1 + (i/4), 1, 0, 20));
				homeContent = new JPanel(new GridLayout(1, 4, 20, 0));
				homeContent.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
			}
			hBtn = new JButton("hBtn" + i, new ImageIcon(searchList.get(i).getHpath1()));
			System.out.println(searchList.get(i).getHpath1());
			hBtnList.add(hBtn);
			homeContent.add(hBtn);
			if (i % 4 == 3 || i == size-1)
				homePanel.add(homeContent);
		}
		
	
		p.add(homePanel);
		pane.setViewportView(p);
	
		SearchLogic sl = new SearchLogic(this);

		address.addMouseListener(sl);
		dateIn.addMouseListener(sl);
		dateOut.addMouseListener(sl);

		searchBtn.addActionListener(sl);

	}
}