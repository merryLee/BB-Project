package com.bb.house.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import com.bb.common.view.Main_frame;
import com.bb.house.controller.AccomodateEditLogic;
import com.bb.house.model.AccomodateEditDao;
import com.bb.house.model.HouseDto;
import com.bb.mypage.view.MypageMain;

import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class AccomodateEdit extends JPanel {
	public JTextField hname;
	public JTextField hphone;
	public JTextField hloc;
	public JTextField hdetail;
	public JTextField hprice;
	public JButton edit_btn;
	
	public int mno;
	public JTextField hmax;
	public JLabel hpath1;
	public JLabel hpath2;
	public JLabel hpath3;
	public JTextArea hintro;
	public JCheckBox c1;
	public JCheckBox c2;
	public JCheckBox c3;
	public JCheckBox c4;
	public JCheckBox c5;
	public JCheckBox c6;
	public JCheckBox c7;
	public JCheckBox c8;
	public JCheckBox c9;
	public JCheckBox c10;
	public JCheckBox c11;
	public JCheckBox c12;
	public ImageIcon img;
	public JLabel thumb1_img;
	AccomodateEditLogic logic = new AccomodateEditLogic(this);
	public HouseDto dto;
	MypageMain mypagemain;
	String conv;
	/**
	 * Create the panel.
	 * @param mypageMain 
	 */
	public AccomodateEdit(MypageMain mypageMain, int hno) {
		this.mypagemain = mypageMain;
		setBackground(new Color(255, 255, 255));
		setBackground(Color.WHITE);
		setBounds(new Rectangle(0, 0, 775, 700));
		setLayout(null);
		
		
		JScrollPane sp = new JScrollPane();
		sp.setBounds(0, 0, 775, 700);
		add(sp);
		
		JPanel panel_mng = new JPanel();
		panel_mng.setPreferredSize(new Dimension(775, 900));
		sp.setViewportView(panel_mng);
		panel_mng.setLayout(null);
		
		
		JLabel label = new JLabel("\uC219\uC18C \uC774\uB984");
		label.setBackground(Color.WHITE);
		label.setBounds(137, 87, 57, 15);
		panel_mng.add(label);
		if(mypageMain.main_frame.isSession()) {
			AccomodateEditDao dao = new AccomodateEditDao();
			mno = mypageMain.main_frame.getMno();
			dto = dao.accomodateValue(mno, hno);
		}
		hname = new JTextField(dto.getHname());
		hname.setColumns(10);
		hname.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		hname.setBounds(137, 111, 226, 21);
		panel_mng.add(hname);
		
		JLabel label_1 = new JLabel("\uB300\uD45C \uC5F0\uB77D\uCC98");
		label_1.setBounds(397, 87, 82, 15);
		panel_mng.add(label_1);
		
		hphone = new JTextField(dto.getHphone());
		hphone.setColumns(10);
		hphone.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		hphone.setBounds(397, 111, 216, 21);
		panel_mng.add(hphone);
		
		JLabel label_2 = new JLabel("\uC219\uC18C \uC8FC\uC18C");
		label_2.setBounds(137, 142, 57, 15);
		panel_mng.add(label_2);
		
		hloc = new JTextField(dto.getHloc());
		hloc.setColumns(10);
		hloc.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		hloc.setBounds(137, 167, 226, 21);
		panel_mng.add(hloc);
		
		hdetail = new JTextField(dto.getHdetail());
		hdetail.setColumns(10);
		hdetail.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		hdetail.setBounds(397, 167, 216, 21);
		panel_mng.add(hdetail);
		
		JLabel label_3 = new JLabel("\uC0C1\uC138\uC8FC\uC18C");
		label_3.setBounds(395, 142, 57, 15);
		panel_mng.add(label_3);
		hprice = new JTextField(dto.getHprice()+"");
		
		hprice.setColumns(10);
		hprice.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		hprice.setBounds(137, 223, 226, 21);
		panel_mng.add(hprice);
		
		JLabel label_4 = new JLabel("\uC219\uC18C \uAC00\uACA9");
		label_4.setBounds(137, 198, 57, 15);
		panel_mng.add(label_4);
		
		JLabel label_5 = new JLabel("\uCD5C\uB300 \uC778\uC6D0");
		label_5.setBounds(397, 198, 57, 15);
		panel_mng.add(label_5);
		
		JLabel label_6 = new JLabel("\uD3B8\uC758 \uC2DC\uC124");
		label_6.setBounds(137, 254, 57, 15);
		panel_mng.add(label_6);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(137, 276, 474, 87);
		panel_mng.add(panel);
		
	
		c1 = new JCheckBox("\uC138\uD0C1\uAE30");
		c1.setBackground(Color.WHITE);
		c1.setBounds(8, 6, 93, 23);
		panel.add(c1);
		
		c5 = new JCheckBox("\uC5D0\uC5B4\uCEE8");
		c5.setBackground(Color.WHITE);
		c5.setBounds(8, 31, 93, 23);
		panel.add(c5);
		
		c9 = new JCheckBox("\uD5E4\uC5B4\uB4DC\uB77C\uC774\uC5B4");
		c9.setBackground(Color.WHITE);
		c9.setBounds(8, 56, 104, 23);
		panel.add(c9);
		
		c2 = new JCheckBox("TV");
		c2.setBackground(Color.WHITE);
		c2.setBounds(116, 6, 107, 23);
		panel.add(c2);
		
		c6 = new JCheckBox("\uC0F4\uD478");
		c6.setBackground(Color.WHITE);
		c6.setBounds(116, 31, 107, 23);
		panel.add(c6);
		
		c10 = new JCheckBox("\uBD80\uC5CC");
		c10.setBackground(Color.WHITE);
		c10.setBounds(116, 56, 107, 23);
		panel.add(c10);
		
		c3 = new JCheckBox("\uC778\uD130\uB137");
		c3.setBackground(Color.WHITE);
		c3.setBounds(232, 6, 115, 23);
		panel.add(c3);
		
		c7 = new JCheckBox("\uC544\uCE68\uC2DD\uC0AC");
		c7.setBackground(Color.WHITE);
		c7.setBounds(232, 31, 115, 23);
		panel.add(c7);
		
		c11 = new JCheckBox("\uB09C\uBC29");
		c11.setBackground(Color.WHITE);
		c11.setBounds(232, 56, 115, 23);
		panel.add(c11);
		
		c4 = new JCheckBox("\uC218\uAC74");
		c4.setBackground(Color.WHITE);
		c4.setBounds(357, 6, 115, 23);
		panel.add(c4);
		
		c8 = new JCheckBox("\uBE44\uB204");
		c8.setBackground(Color.WHITE);
		c8.setBounds(357, 31, 115, 23);
		panel.add(c8);
		
		c12 = new JCheckBox("\uD654\uC7A5\uC9C0");
		c12.setBackground(Color.WHITE);
		c12.setBounds(357, 56, 115, 23);
		panel.add(c12);
		
		conv = dto.getConvcode();
		if (conv.substring(0, 1).equals("1")) {
			c1.setSelected(true);
		}
		if (conv.substring(1, 2).equals("1")) {
			c2.setSelected(true);
		}
		if (conv.substring(2, 3).equals("1")) {
			c3.setSelected(true);
		}
		if (conv.substring(3, 4).equals("1")) {
			c4.setSelected(true);
		}
		if (conv.substring(4, 5).equals("1")) {
			c5.setSelected(true);
		}
		if (conv.substring(5, 6).equals("1")) {
			c6.setSelected(true);
		}
		if (conv.substring(6, 7).equals("1")) {
			c7.setSelected(true);
		}
		if (conv.substring(7, 8).equals("1")) {
			c8.setSelected(true);
		}
		if (conv.substring(8, 9).equals("1")) {
			c9.setSelected(true);
		}
		if (conv.substring(9, 10).equals("1")) {
			c10.setSelected(true);
		}
		if (conv.substring(10, 11).equals("1")) {
			c11.setSelected(true);
		}
		if (conv.substring(11, 12).equals("1")) {
			c12.setSelected(true);
		}
		JLabel label_7 = new JLabel("\uC219\uC18C \uC0AC\uC9C4");
		label_7.setBounds(137, 377, 57, 15);
		panel_mng.add(label_7);
		
		img = new ImageIcon(dto.getHpath1());
		thumb1_img = new JLabel(img);
		thumb1_img.setBackground(new Color(102, 205, 170));
		thumb1_img.setBounds(137, 402, 99, 80);
		panel_mng.add(thumb1_img);
		
		JButton edit_file_btn1 = new JButton("\uD30C\uC77C\uC120\uD0DD");
		edit_file_btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource() == edit_file_btn1) {
				JFileChooser chooser = new JFileChooser();
			      int ret = chooser.showOpenDialog(null);
			      String filePath = "";
			      chooser.setCurrentDirectory(new File("C:\\"));

			      if (ret == JFileChooser.APPROVE_OPTION) {
			         filePath = chooser.getSelectedFile().getPath();
			         hpath1.setText(filePath);
			      } else {
			         JOptionPane.showMessageDialog(null, "경로를 선택하지 못함.", "경고", JOptionPane.WARNING_MESSAGE);
			      }
				}
			}
		});
		edit_file_btn1.setForeground(Color.WHITE);
		edit_file_btn1.setBackground(new Color(35, 86, 149));
		edit_file_btn1.setBounds(516, 402, 97, 23);
		panel_mng.add(edit_file_btn1);
		
		JButton edit_file_btn2 = new JButton("\uD30C\uC77C\uC120\uD0DD");
		edit_file_btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == edit_file_btn2) {
					JFileChooser chooser = new JFileChooser();
				      int ret = chooser.showOpenDialog(null);
				      String filePath = "";
				      chooser.setCurrentDirectory(new File("C:\\"));

				      if (ret == JFileChooser.APPROVE_OPTION) {
				         filePath = chooser.getSelectedFile().getPath();
				         hpath2.setText(filePath);
				      } else {
				         JOptionPane.showMessageDialog(null, "경로를 선택하지 못함.", "경고", JOptionPane.WARNING_MESSAGE);
				      }
					}
			}
		});
		edit_file_btn2.setForeground(Color.WHITE);
		edit_file_btn2.setBackground(new Color(35, 86, 149));
		edit_file_btn2.setBounds(516, 431, 97, 23);
		panel_mng.add(edit_file_btn2);
		
		JButton edit_file_btn3 = new JButton("\uD30C\uC77C\uC120\uD0DD");
		edit_file_btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == edit_file_btn3) {
					JFileChooser chooser = new JFileChooser();
				      int ret = chooser.showOpenDialog(null);
				      String filePath = "";
				      chooser.setCurrentDirectory(new File("C:\\"));

				      if (ret == JFileChooser.APPROVE_OPTION) {
				         filePath = chooser.getSelectedFile().getPath();
				         hpath3.setText(filePath);
				      } else {
				         JOptionPane.showMessageDialog(null, "경로를 선택하지 못함.", "경고", JOptionPane.WARNING_MESSAGE);
				      }
					}
			}
		});
		edit_file_btn3.setForeground(Color.WHITE);
		edit_file_btn3.setBackground(new Color(35, 86, 149));
		edit_file_btn3.setBounds(516, 460, 97, 23);
		panel_mng.add(edit_file_btn3);
		
		JLabel label_9 = new JLabel("\uC18C\uAC1C\uAE00(1000\uC790 \uC774\uB0B4)");
		label_9.setBounds(137, 497, 121, 21);
		panel_mng.add(label_9);
		
		hintro = new JTextArea(dto.getHintro());
		hintro.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		hintro.setBackground(Color.WHITE);
		hintro.setBounds(137, 523, 474, 128);
		panel_mng.add(hintro);
		
		edit_btn = new JButton("\uB4F1\uB85D \uBC0F \uC218\uC815");
		edit_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logic.update(hno);
				mypageMain.main_frame.changePanel("mypagemain");			
			}
		});
		edit_btn.setForeground(Color.WHITE);
		edit_btn.setBackground(new Color(35, 86, 149));
		edit_btn.setBounds(282, 674, 197, 23);
		panel_mng.add(edit_btn);
		
		JLabel label_10 = new JLabel("\uC219\uC18C \uD3B8\uC9D1");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setFont(new Font("굴림", Font.BOLD, 25));
		label_10.setBounds(303, 10, 121, 54);
		panel_mng.add(label_10);
		
		hpath1 = new JLabel(dto.getHpath1());
		hpath1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		hpath1.setBounds(248, 403, 267, 22);
		panel_mng.add(hpath1);
		
		hpath2 = new JLabel(dto.getHpath2());
		hpath2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		hpath2.setBounds(248, 431, 267, 22);
		panel_mng.add(hpath2);
		
		hpath3 = new JLabel(dto.getHpath3());
		hpath3.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		hpath3.setBounds(248, 460, 267, 22);
		panel_mng.add(hpath3);
		
		hmax = new JTextField(dto.getHmax()+"");
		hmax.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		hmax.setBounds(397, 223, 216, 21);
		panel_mng.add(hmax);

	}
	
	
	
}