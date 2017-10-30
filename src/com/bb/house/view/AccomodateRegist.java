package com.bb.house.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import com.bb.common.view.Main_frame;
import com.bb.house.controller.AccomodateRegistLogic;
import com.bb.house.model.ConvDto;
import com.bb.house.model.HouseDto;
import com.bb.house.model.HouseInfoDao;


public class AccomodateRegist extends JPanel {
	public JTextField regi_name;
	public JTextField regi_phone;
	public JTextField regi_loc;
	public JTextField regi_detail;
	public JTextField regi_price;
	public JTextField regi_maxp;
	public JTextArea regi_intro;
	public JButton regi_btn;
	public ImageIcon img ;
	
	public JButton regi_file_btn1;
	public JButton regi_file_btn2;
	public JButton regi_file_btn3;
	
	HouseDto housedto = new HouseDto();
	
	public JLabel regi_photo_path1;
	public JLabel regi_photo_path2;
	public JLabel regi_photo_path3;
	public JLabel regi_picture;
	public JCheckBox con1_wifi;
	public JCheckBox con2_aircon;
	public JCheckBox con3_washing;
	public JCheckBox con4_iron;
	public JCheckBox con5_bath;
	public JCheckBox con6_bathgoods;
	public JCheckBox con7_dryer;
	public JCheckBox con8_tv;
	public JCheckBox con9_animal;
	public JCheckBox con10_elevator;
	public JCheckBox con11_freeparking;
	public JCheckBox con12_front24;

	public Main_frame main;
	/**
	 * Create the panel.
	 * @param main_frame 
	 */
	
	public AccomodateRegist(Main_frame main_frame) {
		this.main = main_frame;
		
		setBackground(new Color(255, 255, 255));
		setBackground(Color.WHITE);
		setBounds(new Rectangle(0, 0, 775, 559));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 775, 599);
		add(scrollPane);
		
		JPanel panel_s= new JPanel();
        panel_s.setPreferredSize(new Dimension(775, 820));
        scrollPane.setViewportView(panel_s);
        panel_s.setLayout(null);
		
		regi_name = new JTextField();
		regi_name.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		regi_name.setBounds(142, 112, 226, 21);
		panel_s.add(regi_name);
		
		regi_phone = new JTextField();
		regi_phone.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		regi_phone.setBounds(402, 112, 216, 21);
		panel_s.add(regi_phone);
		
		JLabel label = new JLabel("\uC219\uC18C \uC8FC\uC18C");
		label.setBounds(142, 143, 57, 15);
		panel_s.add(label);
		
		regi_loc = new JTextField();
		regi_loc.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		regi_loc.setBounds(142, 168, 226, 21);
		panel_s.add(regi_loc);
		
		regi_detail = new JTextField();
		regi_detail.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		regi_detail.setBounds(402, 168, 216, 21);
		panel_s.add(regi_detail);
		
		JLabel label_1 = new JLabel("\uC0C1\uC138\uC8FC\uC18C");
		label_1.setBounds(400, 143, 57, 15);
		panel_s.add(label_1);
		
		regi_price = new JTextField();
		regi_price.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		regi_price.setBounds(142, 224, 226, 21);
		panel_s.add(regi_price);
		
		JLabel label_2 = new JLabel("\uC219\uC18C \uAC00\uACA9");
		label_2.setBounds(142, 199, 57, 15);
		panel_s.add(label_2);
		
		JLabel label_3 = new JLabel("\uCD5C\uB300 \uC778\uC6D0");
		label_3.setBounds(402, 199, 57, 15);
		panel_s.add(label_3);
		
		JLabel label_4 = new JLabel("\uD3B8\uC758 \uC2DC\uC124");
		label_4.setBounds(142, 255, 57, 15);
		panel_s.add(label_4);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(142, 277, 474, 87);
		panel_s.add(panel);
		
		
		
		con1_wifi = new JCheckBox("WI-FI");
		con1_wifi.setBackground(Color.WHITE);
		con1_wifi.setBounds(8, 6, 93, 23);
		panel.add(con1_wifi);

		con5_bath = new JCheckBox("\uC804\uC6A9\uC695\uC2E4");
		con5_bath.setBackground(Color.WHITE);
		con5_bath.setBounds(8, 31, 93, 23);
		panel.add(con5_bath);
		
		
		con9_animal = new JCheckBox("\uBC18\uB824\uB3D9\uBB3C");
		con9_animal.setBackground(Color.WHITE);
		con9_animal.setBounds(8, 56, 104, 23);
		panel.add(con9_animal);
		
		con2_aircon = new JCheckBox("\uC5D0\uC5B4\uCEE8");
		con2_aircon.setBackground(Color.WHITE);
		con2_aircon.setBounds(116, 6, 107, 23);
		panel.add(con2_aircon);
		
		con6_bathgoods = new JCheckBox("\uC695\uC2E4\uC6A9\uD488");
		con6_bathgoods.setBackground(Color.WHITE);
		con6_bathgoods.setBounds(116, 31, 107, 23);
		panel.add(con6_bathgoods);
		
		con10_elevator = new JCheckBox("\uC5D8\uB9AC\uBCA0\uC774\uD130");
		con10_elevator.setBackground(Color.WHITE);
		con10_elevator.setBounds(116, 56, 107, 23);
		panel.add(con10_elevator);
		
		con3_washing = new JCheckBox("\uC138\uD0C1\uAE30");
		con3_washing.setBackground(Color.WHITE);
		con3_washing.setBounds(232, 6, 115, 23);
		panel.add(con3_washing);
		
		con7_dryer = new JCheckBox("\uD5E4\uC5B4\uB4DC\uB77C\uC774\uC5B4");
		con7_dryer.setBackground(Color.WHITE);
		con7_dryer.setBounds(232, 31, 115, 23);
		panel.add(con7_dryer);
		
		con11_freeparking = new JCheckBox("\uBB34\uB8CC\uC8FC\uCC28");
		con11_freeparking.setBackground(Color.WHITE);
		con11_freeparking.setBounds(232, 56, 115, 23);
		panel.add(con11_freeparking);
		
		con4_iron = new JCheckBox("\uB2E4\uB9AC\uBBF8");
		con4_iron.setBackground(Color.WHITE);
		con4_iron.setBounds(357, 6, 115, 23);
		panel.add(con4_iron);
		
		con8_tv = new JCheckBox("TV");
		con8_tv.setBackground(Color.WHITE);
		con8_tv.setBounds(357, 31, 115, 23);
		panel.add(con8_tv);
		
		con12_front24 = new JCheckBox("24\uC2DC\uAC04\uD504\uB860\uD2B8");
		con12_front24.setBackground(Color.WHITE);
		con12_front24.setBounds(357, 56, 115, 23);
		panel.add(con12_front24);
		
		
		
		
		
		
		
		
		
		
		
		
		JLabel label_5 = new JLabel("\uC219\uC18C \uC0AC\uC9C4");
		label_5.setBounds(142, 378, 57, 15);
		panel_s.add(label_5);
		
		
		
		regi_picture = new JLabel();	
		regi_picture.setBackground(new Color(102, 205, 170));
		regi_picture.setBounds(142, 403, 99, 80);
		panel_s.add(regi_picture);
		
		
		
		
		
		regi_file_btn1 = new JButton("\uD30C\uC77C\uC120\uD0DD"); // 첫번쨰 번튼
		regi_file_btn1.setForeground(Color.WHITE);
		regi_file_btn1.setBackground(new Color(35, 86, 149));
		regi_file_btn1.setBounds(521, 403, 97, 23);
		panel_s.add(regi_file_btn1);
		
		regi_file_btn2 = new JButton("\uD30C\uC77C\uC120\uD0DD");
		regi_file_btn2.setForeground(Color.WHITE);
		regi_file_btn2.setBackground(new Color(35, 86, 149));
		regi_file_btn2.setBounds(521, 432, 97, 23);
		panel_s.add(regi_file_btn2);
		
		regi_file_btn3 = new JButton("\uD30C\uC77C\uC120\uD0DD");
		regi_file_btn3.setForeground(Color.WHITE);
		regi_file_btn3.setBackground(new Color(35, 86, 149));
		regi_file_btn3.setBounds(521, 461, 97, 23);
		panel_s.add(regi_file_btn3);
		
		
		
		
		
		
		JLabel label_7 = new JLabel("\uC18C\uAC1C\uAE00(1000\uC790 \uC774\uB0B4)");
		label_7.setBounds(142, 498, 121, 21);
		panel_s.add(label_7);
		
		regi_intro = new JTextArea();
		regi_intro.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		regi_intro.setBackground(Color.WHITE);
		regi_intro.setBounds(142, 524, 474, 128);
		panel_s.add(regi_intro);
		
		regi_btn = new JButton("\uB4F1\uB85D \uBC0F \uC218\uC815");
		regi_btn.setForeground(Color.WHITE);
		regi_btn.setBackground(new Color(35, 86, 149));
		regi_btn.setBounds(292, 675, 197, 23);
		panel_s.add(regi_btn);
		
		JLabel label_8 = new JLabel("\uC219\uC18C \uC774\uB984");
		label_8.setBackground(Color.WHITE);
		label_8.setBounds(142, 88, 57, 15);
		panel_s.add(label_8);
		
		JLabel label_9 = new JLabel("\uB300\uD45C \uC5F0\uB77D\uCC98");
		label_9.setBounds(402, 88, 82, 15);
		panel_s.add(label_9);
		
		JLabel label_10 = new JLabel("\uC219\uC18C \uB4F1\uB85D");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setFont(new Font("굴림", Font.BOLD, 25));
		label_10.setBounds(309, 10, 121, 54);
		panel_s.add(label_10);
		
		regi_photo_path1 = new JLabel();
		regi_photo_path1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		regi_photo_path1.setBackground(new Color(255, 255, 255));
		regi_photo_path1.setBounds(253, 404, 267, 22);
		panel_s.add(regi_photo_path1);
		
		regi_photo_path2 = new JLabel();
		regi_photo_path2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		regi_photo_path2.setBackground(Color.WHITE);
		regi_photo_path2.setBounds(253, 432, 267, 22);
		panel_s.add(regi_photo_path2);
		
		regi_photo_path3 = new JLabel();
		regi_photo_path3.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		regi_photo_path3.setBackground(Color.WHITE);
		regi_photo_path3.setBounds(253, 461, 267, 22);
		panel_s.add(regi_photo_path3);
		
		regi_maxp = new JTextField();
		regi_maxp.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		regi_maxp.setBounds(402, 224, 216, 21);
		panel_s.add(regi_maxp);
		
		
		AccomodateRegistLogic arl = new AccomodateRegistLogic(this);
		regi_file_btn1.addActionListener(arl);
		regi_file_btn2.addActionListener(arl);
		regi_file_btn3.addActionListener(arl);
		regi_btn.addActionListener(arl);
		regi_price.addKeyListener(arl);
		regi_maxp.addKeyListener(arl);
		
		
	}
}
