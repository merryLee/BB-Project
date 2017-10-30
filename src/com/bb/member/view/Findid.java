package com.bb.member.view;

import javax.swing.JPanel;

import com.bb.common.view.Main_frame;

import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class Findid extends JPanel {
	JButton btn_fi_rlogin;
	String id;
	/**
	 * Create the panel.
	 * @param main_frame 
	 */
	public Findid(Main_frame main_frame) {
		setBounds(new Rectangle(0, 0, 775, 559));
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel label = new JLabel("\uCC3E\uC740 \uC544\uC774\uB514");
		label.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 25));
		label.setBounds(302, 190, 174, 48);
		add(label);
		
		JLabel findidresult = new JLabel();
		findidresult.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		findidresult.setHorizontalAlignment(SwingConstants.CENTER);
		findidresult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				findidresult.setText(Findid_main.result);
			}
		});			
		findidresult.setBounds(249, 267, 270, 38);
		add(findidresult);
		
		btn_fi_rlogin = new JButton("\uB85C\uADF8\uC778\uC73C\uB85C \uB3CC\uC544\uAC00\uAE30");
		btn_fi_rlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_frame.changePanel("login");
			}
		});
		btn_fi_rlogin.setForeground(Color.WHITE);
		btn_fi_rlogin.setBackground(new Color(35, 86, 149));
		btn_fi_rlogin.setBounds(249, 337, 262, 29);
		add(btn_fi_rlogin);

	}
	
	
}
