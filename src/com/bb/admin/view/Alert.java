package com.bb.admin.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Alert extends JDialog {

	public Alert(int rn, String command) {
		setBounds(300, 250, 250, 200);
		setLayout(new BorderLayout(0, 20));
		
		JPanel center = new JPanel(new BorderLayout());
		JPanel bottom = new JPanel(new BorderLayout());
		
		add(center, BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);
		
		JLabel msg = new JLabel(rn + "개가 " + command + "되었습니다.", JLabel.CENTER);
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
				dispose();
			}
		});
		
		center.add(msg, "Center");
		bottom.add(btnOK, "Center");
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	public Alert(String msg) {
		setBounds(300, 250, 250, 200);
		setLayout(new BorderLayout(0, 20));
		
		JPanel center = new JPanel(new BorderLayout());
		JPanel bottom = new JPanel(new BorderLayout());
		
		add(center, BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
				dispose();
			}
		});
		
		center.add(new JLabel(msg, JLabel.CENTER), "Center");
		bottom.add(btnOK, "Center");
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}
