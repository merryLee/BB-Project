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
import com.bb.home.view.Home;
import com.bb.home.view.SwingCalendar;
import com.bb.house.view.HouseInfo;
import com.bb.review.model.ReviewDto;
import com.bb.common.view.Main_frame;

public class HouseInfoLogic extends MouseAdapter {

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
	public void mouseClicked(MouseEvent e) {
		Object ob = e.getSource();
		
		if (ob == hi.bin) {
			sc.setVisible(true);
			sc.extLabel = hi.bin;
			sc.setTitle("체크인");
		}
		if (ob == hi.bout) {
			sc.setVisible(true);
			sc.extLabel = hi.bout;
			sc.setTitle("체크아웃");
		}
	
	}
}
