package com.bb.house.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import javax.swing.*;

import com.bb.house.model.AccomodateRegistDao;
import com.bb.house.model.HouseDto;
import com.bb.house.view.AccomodateRegist;
import com.bb.common.view.*;

public class AccomodateRegistLogic implements ActionListener, KeyListener {

	AccomodateRegist ar;
	String conv;
	 AccomodateRegistDao ard = new AccomodateRegistDao();
	 
	public AccomodateRegistLogic(AccomodateRegist ar) {
		this.ar = ar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		HouseDto housedto = new HouseDto();
		
		if (ob == ar.regi_btn) {
			housedto.setHname(ar.regi_name.getText());
			housedto.setHloc(ar.regi_loc.getText());
			housedto.setHdetail(ar.regi_detail.getText());
			housedto.setHintro(ar.regi_intro.getText());
			int maxp = Integer.parseInt(ar.regi_maxp.getText());
			housedto.setHmax(maxp);
			int price = Integer.parseInt(ar.regi_price.getText());
			housedto.setHprice(price);
			housedto.setHphone(ar.regi_phone.getText());
			housedto.setHpath1(ar.regi_photo_path1.getText());
			
			housedto.setHpath2(ar.regi_photo_path2.getText());
			housedto.setHpath3(ar.regi_photo_path3.getText());

			conv = new String();
			checkBox(ar.con1_wifi);
			checkBox(ar.con2_aircon);
			checkBox(ar.con3_washing);
			checkBox(ar.con4_iron);
			checkBox(ar.con5_bath);
			checkBox(ar.con6_bathgoods);
			checkBox(ar.con7_dryer);
			checkBox(ar.con8_tv);
			checkBox(ar.con9_animal);
			checkBox(ar.con10_elevator);
			checkBox(ar.con11_freeparking);
			checkBox(ar.con12_front24);
			//double numcon = Double.parseDouble(conv.toString());
			housedto.setConvcode(conv);
			housedto.setHhost(ar.main.getMno());
			housedto.setHstatus("0");
			////////////////////////////////////////////////////////////////////등록
			 int cnt = ard.register(housedto);
			// int cntimg = ard.imgRegister(housedto);
			 System.out.println("cnt : " + cnt);
			// System.out.println("cntimg : " + cntimg);
			 
			 if(cnt != 0) {
				 System.out.println("insert sucess");
				 
				 ar.main.changePanel("mypagemain");
			 }
			 else  System.out.println("insert fail");
			

		} else if (ob == ar.regi_file_btn1) {
			housedto.setHpath1(RegiFileBtn(ar.regi_photo_path1));
			ImageIcon img = new ImageIcon(housedto.getHpath1());
			ar.regi_picture.setIcon(img);
			System.out.println(housedto.getHpath1());
		} else if (ob == ar.regi_file_btn2) {
			housedto.setHpath2(RegiFileBtn(ar.regi_photo_path2));
			System.out.println(housedto.getHpath2());
		} else if (ob == ar.regi_file_btn3) {
			//RegiFileBtn(ar.regi_photo_path3);
			housedto.setHpath3(RegiFileBtn(ar.regi_photo_path3));
			System.out.println(housedto.getHpath3());
		}

	}

	private void checkBox(JCheckBox check) {
		if (check.isSelected()) {
			conv+=1;
		} else
			conv+=0;
	}

	
	// 파일 경로
	public String RegiFileBtn(JLabel regi_photo_path) {

		JFileChooser chooser = new JFileChooser();
		int ret = chooser.showOpenDialog(null);
		String filePath = "";
		chooser.setCurrentDirectory(new File("C:\\"));

		if (ret == JFileChooser.APPROVE_OPTION) {
			filePath = chooser.getSelectedFile().getPath();
			regi_photo_path.setText(filePath);
		} else {
			JOptionPane.showMessageDialog(null, "경로를 선택하지 못함.", "경고", JOptionPane.WARNING_MESSAGE);
		}
		return filePath;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		
		if(!(Character.isDigit(c)))
		{
			e.consume();
			return;
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}

}