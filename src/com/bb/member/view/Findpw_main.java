package com.bb.member.view;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import com.bb.common.view.Main_frame;
import com.bb.member.controller.Findpw_mainLogic;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Findpw_main extends JPanel {
	public JTextField id;
	public JTextField ans;
	public JComboBox cmbq;
	private JButton btn_fpm;
	public static String pwresult;
	
	Findpw_mainLogic findpwlogic = new Findpw_mainLogic(this);
	
	/**
	 * Create the panel.
	 * @param main_frame 
	 */
	public Findpw_main(Main_frame main_frame) {
		setBounds(new Rectangle(0, 0, 775, 559));
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		label.setFont(new Font("���� ���", Font.PLAIN, 25));
		label.setBounds(291, 161, 177, 48);
		add(label);
		
		JLabel label_1 = new JLabel("\uC544\uC774\uB514");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("���� ���", Font.PLAIN, 12));
		label_1.setBounds(242, 223, 226, 15);
		add(label_1);
		
		id = new JTextField();
		id.setBounds(242, 248, 262, 29);
		add(id);
		
		JLabel label_2 = new JLabel("\uBCF4\uC548\uC9C8\uBB38");
		label_2.setFont(new Font("���� ���", Font.PLAIN, 12));
		label_2.setBounds(242, 287, 216, 15);
		add(label_2);
		
		cmbq = new JComboBox();
		cmbq.addItem("ù ��° �������� �����̽��ϱ�?");
		cmbq.addItem("ù ��° ������ ��𿴽��ϱ�?");
		cmbq.addItem("���� �����ߴ� �������� �����̽��ϱ�?");
		cmbq.addItem("ó������ �� �� �ܼ�Ʈ�� �����Դϱ�?");
		cmbq.addItem("���� �����ߴ� ��Ҵ� ��𿴽��ϱ�?");
		cmbq.addItem("� ���� ���� ģ�ߴ� ģ���� ���������ϱ�?");
		cmbq.addItem("��ӴϿ� �ƹ����� ������ ���ô� ����Դϱ�?");
		cmbq.addItem("2000�� 1�� 1�Ͽ� ��� �־����ϱ�?");
		cmbq.setBounds(242, 309, 262, 21);
		add(cmbq);
		
		JLabel label_3 = new JLabel("\uBCF4\uC548\uB2F5\uBCC0");
		label_3.setFont(new Font("���� ���", Font.PLAIN, 12));
		label_3.setBounds(242, 338, 262, 15);
		add(label_3);
		
		ans = new JTextField();
		ans.setColumns(10);
		ans.setBounds(242, 363, 262, 21);
		add(ans);
		
		btn_fpm = new JButton("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		btn_fpm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(findpwlogic.check()) {					
					main_frame.changePanel("findpw");
				}else {
					JOptionPane.showMessageDialog(null, "�ٽ� �Է� ���ּ���");
				}
			}
		});
		btn_fpm.setForeground(Color.WHITE);
		btn_fpm.setBackground(new Color(35, 86, 149));
		btn_fpm.setBounds(291, 410, 177, 29);
		add(btn_fpm);

	}
}
