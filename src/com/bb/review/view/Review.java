package com.bb.review.view;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.LineBorder;

import com.bb.common.view.Main_frame;
import com.bb.mypage.model.MypageMainDto;
import com.bb.review.controller.ReviewLogic;

public class Review extends JPanel {

	private JLabel lbl1 = new JLabel("\uCD1D\uC810");
	private JLabel lbl2 = new JLabel("\uC704\uCE58");
	private JLabel lbl3 = new JLabel("\uCCAD\uACB0\uB3C4");
	private JLabel lbl4 = new JLabel("\uC758\uC0AC\uC18C\uD1B5");
	
	public ButtonGroup rbg1 = new ButtonGroup();
	public ButtonGroup rbg2 = new ButtonGroup();
	public ButtonGroup rbg3 = new ButtonGroup();
	public ButtonGroup rbg4 = new ButtonGroup();
	private JRadioButton rb1A = new JRadioButton("\uB9E4\uC6B0\uBD88\uB9CC\uC871");
	private JRadioButton rb1B = new JRadioButton("\uBD88\uB9CC\uC871");
	private JRadioButton rb1C = new JRadioButton("\uBCF4\uD1B5");
	private JRadioButton rb1D = new JRadioButton("\uB9CC\uC871");
	private JRadioButton rb1E = new JRadioButton("\uB9E4\uC6B0\uB9CC\uC871");
	private JRadioButton rb2A = new JRadioButton("\uB9E4\uC6B0\uBD88\uB9CC\uC871");
	private JRadioButton rb2B = new JRadioButton("\uBD88\uB9CC\uC871");
	private JRadioButton rb2C = new JRadioButton("\uBCF4\uD1B5");
	private JRadioButton rb2D = new JRadioButton("\uB9CC\uC871");
	private JRadioButton rb2E = new JRadioButton("\uB9E4\uC6B0\uB9CC\uC871");
	private JRadioButton rb3A = new JRadioButton("\uB9E4\uC6B0\uBD88\uB9CC\uC871");
	private JRadioButton rb3B = new JRadioButton("\uBD88\uB9CC\uC871");
	private JRadioButton rb3C = new JRadioButton("\uBCF4\uD1B5");
	private JRadioButton rb3D = new JRadioButton("\uB9CC\uC871");
	private JRadioButton rb3E = new JRadioButton("\uB9E4\uC6B0\uB9CC\uC871");
	private JRadioButton rb4A = new JRadioButton("\uB9E4\uC6B0\uBD88\uB9CC\uC871");
	private JRadioButton rb4B = new JRadioButton("\uBD88\uB9CC\uC871");
	private JRadioButton rb4C = new JRadioButton("\uBCF4\uD1B5");
	private JRadioButton rb4D = new JRadioButton("\uB9CC\uC871");
	private JRadioButton rb4E = new JRadioButton("\uB9E4\uC6B0\uB9CC\uC871");
	
	public JTextArea reviewSpec = new JTextArea();
	public Main_frame main_frame;
	public MypageMainDto mypagemaindto;
	public JButton submit;
	
	public Review(Main_frame main_frame, MypageMainDto mypagemaindto ) {
		this.mypagemaindto = mypagemaindto;
		this.main_frame = main_frame;
		setBounds(new Rectangle(0, 0, 775, 559));
		setBackground(Color.WHITE);
		setLayout(null);

		JLabel title = new JLabel("평점 및 후기 작성");
		title.setFont(new Font("굴림", Font.BOLD, 30));
		title.setBounds(271, 50, 260, 45);
		add(title);


		
		JPanel grade = new JPanel(new BorderLayout(0, 0));
		grade.setBounds(100, 103, 575, 192);

		JPanel gradeLabel = new JPanel(new GridLayout(4, 1, 0, 0));
		JPanel gradeTable = new JPanel(new GridLayout(4, 5, 0, 0));
		
		Font f;
		

		List<JLabel> lblList = new ArrayList<JLabel>();
		lblList.add(lbl1);
		lblList.add(lbl2);
		lblList.add(lbl3);
		lblList.add(lbl4);
				
		f = new Font("굴림", Font.BOLD, 14);
		for(int i=0;i<lblList.size();i++) {
			JLabel lbl = lblList.get(i);
			lbl.setFont(f);
			gradeLabel.add(lbl);		
			
		}

//		rdbtnNewRadioButton.setSelected(true);
		List<JRadioButton> rbList = new ArrayList<JRadioButton>();
		rbList.add(rb1A);
		rbList.add(rb1B);
		rbList.add(rb1C);
		rbList.add(rb1D);
		rbList.add(rb1E);
		
		rbList.add(rb2A);
		rbList.add(rb2B);
		rbList.add(rb2C);
		rbList.add(rb2D);
		rbList.add(rb2E);
		
		rbList.add(rb3A);
		rbList.add(rb3B);
		rbList.add(rb3C);
		rbList.add(rb3D);
		rbList.add(rb3E);
		
		rbList.add(rb4A);
		rbList.add(rb4B);
		rbList.add(rb4C);
		rbList.add(rb4D);
		rbList.add(rb4E);
		
		f = new Font("굴림", Font.PLAIN, 14);
		for(int i=0;i<rbList.size();i++) {
			JRadioButton rb = rbList.get(i);
			rb.setFont(f);
			gradeTable.add(rb);
		}

		
		rbg1.add(rb1A);
		rbg1.add(rb1B);
		rbg1.add(rb1C);
		rbg1.add(rb1D);
		rbg1.add(rb1E);

		rbg2.add(rb2A);
		rbg2.add(rb2B);
		rbg2.add(rb2C);
		rbg2.add(rb2D);
		rbg2.add(rb2E);

		rbg3.add(rb3A);
		rbg3.add(rb3B);
		rbg3.add(rb3C);
		rbg3.add(rb3D);
		rbg3.add(rb3E);

		rbg4.add(rb4A);
		rbg4.add(rb4B);
		rbg4.add(rb4C);
		rbg4.add(rb4D);
		rbg4.add(rb4E);
		
			
		
		
		grade.add(gradeLabel, "West");
		grade.add(gradeTable, "Center");
		add(grade);
	
	
		f = new Font("굴림", Font.BOLD, 14);
		JLabel lblReview = new JLabel("\uD6C4\uAE30 \uC791\uC131");
		lblReview.setFont(f);
		lblReview.setBounds(100, 300, 80, 30);
		add(lblReview);
		
		
		reviewSpec.setBorder(new LineBorder(new Color(21, 139, 203), 2));
		reviewSpec.setText("후기를 작성해주세요.");
		reviewSpec.setBounds(100, 330, 575, 113);
		add(reviewSpec);

		submit = new JButton("평점 및 후기 등록");
		submit.setFont(new Font("굴림", Font.BOLD, 16));
		submit.setBackground(new Color(21, 139, 203));
		submit.setForeground(Color.WHITE);
		submit.setBounds(455, 460, 220, 49);
		add(submit);
				
//		등록부
		ReviewLogic rl = new ReviewLogic(this);
//		이벤트 등록
		submit.addActionListener(rl);
		
	}

}