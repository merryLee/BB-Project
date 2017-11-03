package com.bb.house.view;

import javax.swing.JPanel;
import java.awt.Rectangle;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import com.bb.common.view.Main_frame;
import com.bb.house.controller.HouseInfoLogic;
import com.bb.house.model.ConvDto;
import com.bb.house.model.HouseDto;
import com.bb.house.model.HouseInfoDao;
import com.bb.reservation.view.Reservation;
import com.bb.review.model.ReviewDto;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.awt.BorderLayout;
import javax.swing.JList;

import java.awt.event.*;

public class HouseInfo extends JPanel {
	public JLabel bin;
	public JLabel binout;
	public JButton info_btn_resev;
	public JLabel info_tiltle_L;
	public JLabel info_addr_L;
	public JLabel info_photo;
	public JLabel house_detail_L;
	public JButton info_btn_recomm;
	public JLabel review_num;
	public JLabel acc_price;
	public JLabel conv_panel;
	public HouseInfoDao hid;
	public ReviewDto re;
	Reservation rs;
	int bperson;

	/**
	 * Create the panel.
	 * 
	 * @param houseDto
	 */
	public HouseInfo(HouseDto houseDto, Main_frame main_frame) {
		HouseInfoLogic hil = new HouseInfoLogic(this);
		hid = new HouseInfoDao();

		setBackground(new Color(255, 255, 255));
		setBounds(new Rectangle(0, 0, 775, 700));
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 775, 700);
		add(scrollPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setPreferredSize(new Dimension(775, 1100));
		scrollPane.setViewportView(panel);
		panel.setLayout(null);

		info_tiltle_L = new JLabel(houseDto.getHname());
		info_tiltle_L.setBounds(85, 10, 342, 43);
		info_tiltle_L.setFont(new Font("±¼¸²", Font.BOLD, 25));
		panel.add(info_tiltle_L);

		info_addr_L = new JLabel(houseDto.getHloc());
		info_addr_L.setBounds(85, 63, 616, 52);
		info_addr_L.setFont(new Font("±¼¸²", Font.BOLD, 14));
		panel.add(info_addr_L);

		ImageIcon img = new ImageIcon(houseDto.getHpath1());
		info_photo = new JLabel(img);
		info_photo.setBounds(85, 125, 626, 176);
		panel.add(info_photo);

		JLabel label_4 = new JLabel("\uCCB4\uD06C\uC778");
		label_4.setBounds(86, 429, 57, 15);
		panel.add(label_4);

		bin = new JLabel();
		bin.setBounds(85, 454, 143, 29);
		bin.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192),
				new Color(192, 192, 192), new Color(192, 192, 192)));
		bin.setBackground(Color.WHITE);
		panel.add(bin);

		JLabel label_5 = new JLabel("\uCCB4\uD06C\uC544\uC6C3");
		label_5.setBounds(244, 429, 57, 15);
		panel.add(label_5);

		binout = new JLabel();
		binout.setBounds(246, 454, 143, 29);
		binout.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192),
				new Color(192, 192, 192), new Color(192, 192, 192)));
		panel.add(binout);

		JLabel label_6 = new JLabel("\uC778\uC6D0");
		label_6.setBounds(419, 429, 57, 15);
		panel.add(label_6);

		JComboBox cnbbperson = new JComboBox();
		int blen = houseDto.getHmax();
		for (int i = 0; i < blen; i++) {
			cnbbperson.addItem(i + 1);
		}
		cnbbperson.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				bperson = (int) e.getItem();
			}
		});
		cnbbperson.setBounds(420, 454, 143, 29);
		cnbbperson.setBackground(Color.WHITE);
		panel.add(cnbbperson);
		info_btn_resev = new JButton("\uC608\uC57D");
		info_btn_resev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rs = new Reservation(houseDto, bin.getText(), binout.getText(), bperson, main_frame);
				if (main_frame.isSession()) {
					main_frame.intentp.add("reservation", rs);
					main_frame.changePanel("reservation");
				} else
					main_frame.changePanel("login");
			}
		});
		info_btn_resev.setBounds(602, 452, 111, 31);
		info_btn_resev.setForeground(Color.WHITE);
		info_btn_resev.setBackground(new Color(35, 86, 149));
		panel.add(info_btn_resev);

		JLabel label_7 = new JLabel("\uD3B8\uC758 \uC2DC\uC124");
		label_7.setBounds(85, 503, 57, 15);
		panel.add(label_7);

		JLabel label_21 = new JLabel("\uC219\uC18C \uAC00\uACA9");
		label_21.setBounds(204, 624, 92, 29);
		label_21.setFont(new Font("±¼¸²", Font.BOLD, 20));
		panel.add(label_21);

		acc_price = new JLabel("$" + houseDto.getHprice());
		acc_price.setBounds(308, 614, 143, 43);
		acc_price.setForeground(new Color(46, 139, 87));
		acc_price.setFont(new Font("±¼¸²", Font.BOLD, 27));
		panel.add(acc_price);

		JLabel label_23 = new JLabel("\uD6C4\uAE30");
		label_23.setBounds(85, 683, 48, 26);
		label_23.setFont(new Font("±¼¸²", Font.BOLD, 20));
		panel.add(label_23);

		JLabel label_24 = new JLabel("(vat \uD3EC\uD568)");
		label_24.setBounds(463, 630, 78, 20);
		label_24.setForeground(new Color(46, 139, 87));
		label_24.setFont(new Font("±¼¸²", Font.BOLD, 15));
		panel.add(label_24);

		//////////////////////////////////////////////////////////////
		JLabel label_26 = new JLabel("\uC704\uCE58");
		label_26.setBounds(378, 732, 43, 20);
		label_26.setFont(new Font("±¼¸²", Font.BOLD, 15));
		panel.add(label_26);

		JLabel label_27 = new JLabel("\uCCAD\uACB0");
		label_27.setBounds(85, 773, 33, 19);
		label_27.setFont(new Font("±¼¸²", Font.BOLD, 15));
		panel.add(label_27);

		JLabel label_28 = new JLabel("\uC758\uC0AC\uC18C\uD1B5");
		label_28.setBounds(378, 772, 65, 19);
		label_28.setFont(new Font("±¼¸²", Font.BOLD, 15));
		panel.add(label_28);

		JLabel label_29 = new JLabel("\uCD1D\uC810");
		label_29.setBounds(85, 733, 33, 24);
		label_29.setFont(new Font("±¼¸²", Font.BOLD, 15));
		panel.add(label_29);

		house_detail_L = new JLabel(houseDto.getHdetail());
		house_detail_L.setBounds(85, 304, 626, 104);
		panel.add(house_detail_L);

		String con = "";
		if (houseDto.getConvcode().substring(0, 1).equals("1")) {
			con = "wifi";
		}
		if (houseDto.getConvcode().substring(1, 2).equals("1")) {
			con += "¿¡¾îÄÁ";
		}
		if (houseDto.getConvcode().substring(2, 3).equals("1")) {
			con += "¼¼Å¹±â";
		}
		if (houseDto.getConvcode().substring(3, 4).equals("1")) {
			con += "´Ù¸®¹Ì";
		}
		if (houseDto.getConvcode().substring(4, 5).equals("1")) {
			con += "Àü¿ë¿å½Ç";
		}
		if (houseDto.getConvcode().substring(5, 6).equals("1")) {
			con += "¿å½Ç¿ëÇ°";
		}
		if (houseDto.getConvcode().substring(6, 7).equals("1")) {
			con += "Çì¾îµå¶óÀÌ¾î";
		}
		if (houseDto.getConvcode().substring(7, 8).equals("1")) {
			con += "TV";
		}
		if (houseDto.getConvcode().substring(8, 9).equals("1")) {
			con += "¹Ý·Áµ¿¹°";
		}
		if (houseDto.getConvcode().substring(9, 10).equals("1")) {
			con += "¿¤¸®º£ÀÌÅÍ";
		}
		if (houseDto.getConvcode().substring(10, 11).equals("1")) {
			con += "¹«·áÁÖÂ÷";
		}
		if (houseDto.getConvcode().substring(11, 12).equals("1")) {
			con += "24½Ã°£ÇÁ·ÐÆ®";
		}
		conv_panel = new JLabel(con);
		conv_panel.setBounds(86, 528, 625, 82);
		panel.add(conv_panel);

		/////////////////////////////////////////////// review/////////////////////////////////////////
		List<ReviewDto> list = hid.reviewList(houseDto.getHno());// create score , reivew
		int len = list.size();

		if (len != 0) {
			int total_num = 0, clean_num = 0, loc_num = 0, comm_num = 0;

			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(85, 820, 626, 111);
			panel.add(scrollPane_1);

			JPanel review_panel_mng = new JPanel();
			scrollPane_1.setViewportView(review_panel_mng);

			for (int i = 0; i < len; i++) {

				re = list.get(i);

				total_num += re.getRscore1(); // i have to calculate total score
				clean_num += re.getRscore2();
				loc_num += re.getRscore3();
				comm_num += re.getRscore4();

				review_panel_mng.setPreferredSize(new Dimension(565, 111 * (i + 1))); // 565
				review_panel_mng.setLayout(new GridLayout((i + 1), 1));

				JPanel review_panel = new JPanel();
				review_panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192),
						new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
				review_panel.setLayout(null);
				review_panel_mng.add(review_panel);

				JLabel review_name = new JLabel(re.getMid());
				review_name.setBounds(0, 10, 110, 20);
				review_panel.add(review_name);

				JLabel review_date = new JLabel(re.getRdate());
				review_date.setBounds(0, 25, 119, 15);
				review_panel.add(review_date);

				JLabel review = new JLabel(re.getRspec());
				review.setBounds(0, 31, 499, 78);
				review_panel.add(review);

				info_btn_recomm = new JButton("\uCD94\uCC9C");
				info_btn_recomm.setBounds(540, 0, 67, 112);
				review_panel.add(info_btn_recomm);
				info_btn_recomm.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192),
						new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
				info_btn_recomm.setForeground(Color.BLACK);
				info_btn_recomm.setFont(new Font("±¼¸²", Font.BOLD, 15));
				info_btn_recomm.setBackground(Color.WHITE);

				info_btn_recomm.addActionListener(hil);
			}

			String total = (total_num / len) + "";
			String clean = (clean_num / len) + "";
			String loc = (loc_num / len) + "";
			String comm = (comm_num / len) + "";

			JLabel total_score = new JLabel(total);
			total_score.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192),
					new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
			total_score.setBounds(134, 732, 231, 24);
			panel.add(total_score);

			JLabel clean_score = new JLabel(clean);
			clean_score.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192),
					new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
			clean_score.setBounds(134, 769, 231, 24);
			panel.add(clean_score);

			JLabel loc_score = new JLabel(loc);
			loc_score.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192),
					new Color(192, 192, 192), new Color(192, 192, 192)));
			loc_score.setBounds(461, 731, 250, 24);
			panel.add(loc_score);

			JLabel comm_score = new JLabel(comm);
			comm_score.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192),
					new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
			comm_score.setBounds(461, 767, 250, 24);
			panel.add(comm_score);
			/////////////////////////////////////////////////////////////////////////////////////////////////////
			total_num = Integer.parseInt(total);
			if (total_num >= 2) {
				JPanel hotP = new JPanel();
				hotP.setBounds(418, 20, 77, 24);
				hotP.setBackground(new Color(255, 165, 0));
				panel.add(hotP);

				JLabel hotL = new JLabel("Hot");
				hotL.setForeground(Color.WHITE);
				hotL.setFont(new Font("±¼¸²", Font.BOLD, 12));
				hotP.add(hotL);
			}
			review_num = new JLabel(len + "°³");
			review_num.setBounds(135, 685, 75, 23);
			review_num.setFont(new Font("±¼¸²", Font.BOLD, 20));
			panel.add(review_num);
		}
		else
		{
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(85, 820, 626, 111);
			panel.add(scrollPane_1);

			JPanel review_panel_mng = new JPanel();
			scrollPane_1.setViewportView(review_panel_mng);
			
			JPanel review_panel = new JPanel();
			review_panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192),
					new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
			review_panel.setLayout(null);
			review_panel_mng.add(review_panel);
			
			review_num = new JLabel(0 + "°³");
			review_num.setBounds(135, 685, 75, 23);
			review_num.setFont(new Font("±¼¸²", Font.BOLD, 20));
			panel.add(review_num);
		}
			
		bin.addMouseListener(hil);
		binout.addMouseListener(hil);
		info_btn_resev.addActionListener(hil);
	}
}
