package com.bb.house.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

import com.bb.house.model.ConvDto;
import com.bb.house.model.HouseDto;
import com.bb.house.model.HouseInfoDao;
import com.bb.review.model.ReviewDto;
import com.bb.home.view.Home;
import com.bb.home.view.SwingCalendar;
import com.bb.house.view.HouseInfo;
import com.bb.common.view.Main_frame;

public class HouseInfoLogic extends MouseAdapter implements ActionListener {

//	Home home;
//	public HouseInfoLogic(Home home) {
//		this.home = home;
//	}
	SwingCalendar sc = new SwingCalendar();

	HouseInfo hi;
	public HouseInfoLogic(HouseInfo hi) {
		this.hi = hi;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == hi.info_btn_recomm){
			System.out.println(hi.re.getRno());
				int cnt = hi.hid.reviewRcommed(hi.re.getRno());
				
				if(cnt != 0)
					System.out.println("추천 업데이트 성공");
				else
					System.out.println("추천 업데이트 실패");
		}
		
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		Object ob = e.getSource();
		
		if (ob == hi.bin) {
			sc.setVisible(true);
			sc.extLabel = hi.bin;
			sc.setTitle("체크인");
		}
		if (ob == hi.binout) {
			sc.setVisible(true);
			sc.extLabel = hi.binout;
			sc.setTitle("체크아웃");
		}
	
	}
}
