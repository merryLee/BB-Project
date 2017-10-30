package com.bb.member.view;

import javax.swing.JPanel;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import com.bb.admin.view.Admin;
import com.bb.common.view.Main_frame;
import com.bb.member.controller.LoginLogic;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JPanel {
	public JTextField id;
	public JPasswordField pw;
	private JButton btnfindid;
	private JButton btnfindpw;
	private JButton btnlogin;
	/**
	 * Create the panel.
	 * 
	 * @param main_frame
	 */
	LoginLogic loginlogic = new LoginLogic(this);

	public Login(Main_frame main_frame) {

		setBounds(new Rectangle(0, 0, 775, 559));
		setBackground(Color.WHITE);
		setLayout(null);

		JLabel label = new JLabel("\uB85C\uADF8\uC778");
		label.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 25));
		label.setBounds(333, 154, 116, 48);
		add(label);

		JLabel label_1 = new JLabel("\uC544\uC774\uB514");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		label_1.setBounds(256, 212, 226, 15);
		add(label_1);

		id = new JTextField();
		id.setColumns(10);
		id.setBounds(256, 237, 262, 29);
		add(id);

		JLabel label_2 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label_2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		label_2.setBounds(256, 276, 226, 15);
		add(label_2);

		pw = new JPasswordField();
		pw.setBounds(256, 301, 262, 29);
		add(pw);

		btnfindid = new JButton("\uC544\uC774\uB514 \uCC3E\uAE30");
		btnfindid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_frame.changePanel("findid_main");
			}
		});
		btnfindid.setForeground(Color.WHITE);
		btnfindid.setBackground(new Color(35, 86, 149));
		btnfindid.setBounds(256, 340, 116, 29);
		add(btnfindid);

		btnfindpw = new JButton("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		btnfindpw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_frame.changePanel("findpw_main");
			}
		});
		btnfindpw.setForeground(Color.WHITE);
		btnfindpw.setBackground(new Color(35, 86, 149));
		btnfindpw.setBounds(384, 340, 134, 29);
		add(btnfindpw);

		btnlogin = new JButton("\uB85C\uADF8\uC778");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loginlogic.loginCheck()) {
					main_frame.setSession(true);
					main_frame.setMno(loginlogic.mnoGet());
					if (loginlogic.mnoGet() != 8) {
						main_frame.setVisible(false);
						Main_frame loginmain_frame = new Main_frame(main_frame.isSession(), main_frame.getMno());
						System.out.println("loginmain_frame : " + loginmain_frame.isSession());

						loginmain_frame.setVisible(true);
						loginmain_frame.changePanel("home");
					} else {
						main_frame.setVisible(false);
						Main_frame loginmain_frame = new Main_frame(main_frame.isSession(), main_frame.getMno());
						System.out.println("loginmain_frame : " + loginmain_frame.isSession());
						
					}
				} else {
					JOptionPane.showMessageDialog(null, "¥ŸΩ√ ∑Œ±◊¿Œ «ÿ¡÷ººø‰");
				}
			}
		});
		btnlogin.setForeground(Color.WHITE);
		btnlogin.setBackground(new Color(35, 86, 149));
		btnlogin.setBounds(256, 379, 262, 29);
		add(btnlogin);

	}

}
