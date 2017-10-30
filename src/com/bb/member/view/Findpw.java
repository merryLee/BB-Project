package com.bb.member.view;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import com.bb.common.view.Main_frame;
import com.bb.member.controller.FindpwLogic;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Findpw extends JPanel {
	public JPasswordField pw;
	public JPasswordField repw;
	private JButton btn_fp_rlogin;
	FindpwLogic findpwlogic = new FindpwLogic(this);
	private String pws;
	private boolean check;
	/**
	 * Create the panel.
	 * @param main_frame 
	 */
	public Findpw(Main_frame main_frame) {
		setBounds(new Rectangle(0, 0, 775, 559));
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638 \uC7AC\uC124\uC815");
		label.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		label.setBounds(270, 161, 218, 48);
		add(label);
		
		JLabel label_1 = new JLabel("\uBCC0\uACBD\uD560 \uBE44\uBC00\uBC88\uD638");
		label_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		label_1.setBounds(270, 219, 218, 15);
		add(label_1);
		
		pw = new JPasswordField();
		pw.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				char cpw[] = pw.getPassword();
				pws = new String(cpw);
				
			}
		});
		pw.setBounds(270, 244, 218, 21);
		add(pw);
		
		JLabel label_2 = new JLabel("\uBCC0\uACBD\uD560 \uBE44\uBC00\uBC88\uD638 \uC7AC\uC785\uB825");
		label_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		label_2.setBounds(270, 286, 218, 15);
		add(label_2);
		
		Action enter = new AbstractAction()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	char cpw[] = repw.getPassword();
				String repws = new String(cpw);
				if(pws.equals(repws)) {
					check = true;
					JOptionPane.showMessageDialog(null, "비밀번호가 같습니다.");
				}else {
					check = false;
					JOptionPane.showMessageDialog(null, "비밀번호가 틀립니다.\n 다시 입력 해주세요");
				}
		    }
		};
		
		repw = new JPasswordField();
		repw.addActionListener(enter);		
		repw.setBounds(270, 311, 218, 21);
		add(repw);		
		
		btn_fp_rlogin = new JButton("\uB85C\uADF8\uC778\uC73C\uB85C \uB3CC\uC544\uAC00\uAE30");
		btn_fp_rlogin.setEnabled(false);
			btn_fp_rlogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(check == true) {					
					btn_fp_rlogin.setEnabled(true);
				}else if(check == false) {
					btn_fp_rlogin.setEnabled(false);
				}
			}
		});
		btn_fp_rlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findpwlogic.check();
				main_frame.changePanel("login");
			}
		});
		btn_fp_rlogin.setForeground(Color.WHITE);
		btn_fp_rlogin.setBackground(new Color(35, 86, 149));
		btn_fp_rlogin.setBounds(270, 366, 218, 29);
		add(btn_fp_rlogin);
		
		JLabel lblNewLabel = new JLabel("\uB2E4 \uC785\uB825\uD558\uC2DC\uACE0 Enter\uB97C \uB20C\uB7EC\uC8FC\uC138\uC694");
		lblNewLabel.setBounds(270, 342, 218, 15);
		add(lblNewLabel);

	}
}
