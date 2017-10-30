package com.bb.member.view;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import com.bb.common.view.Main_frame;
import com.bb.member.controller.FindidLogic;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class Findid_main extends JPanel {
	public JTextField name;
	private JButton btnfindidm;
	public int y;
	public int m;
	public int d;
	public int lastday;
	public static String result;
	FindidLogic findidlogic = new FindidLogic(this);

	/**
	 * Create the panel.
	 * @param main_frame 
	 */
	public Findid_main(Main_frame main_frame) {
		setBounds(new Rectangle(0, 0, 775, 559));
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel label = new JLabel("\uC544\uC774\uB514 \uCC3E\uAE30");
		label.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 25));
		label.setBounds(315, 183, 165, 48);
		add(label);
		
		JLabel label_1 = new JLabel("\uC774\uB984");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label_1.setBounds(254, 241, 226, 15);
		add(label_1);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(254, 266, 262, 29);
		add(name);
		
		JLabel label_2 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		label_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label_2.setBounds(254, 305, 177, 15);
		add(label_2);
		
		JComboBox cmby = new JComboBox();
		cmby.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				y = (int) e.getItem();
			}
		});
		for (int i = 0; i < 30; i++) {
			cmby.addItem(2020-i);
		}
		cmby.setSelectedItem(1998);
		cmby.setBounds(254, 328, 122, 21);
		add(cmby);
		
		JComboBox cmbm = new JComboBox();
		JComboBox cmbd = new JComboBox();
		for (int i = 0; i < 12; i++) {
			cmbm.addItem(i+1);
		}
		Calendar cal = Calendar.getInstance();
		cmbm.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Object ob = e.getStateChange();
				if((int)ob == 1) {
					m = (int) e.getItem();
					cal.set(y, m-1, 1);
					lastday = cal.getActualMaximum(Calendar.DATE);
									
					for (int i = 0; i < lastday; i++) {
						cmbd.addItem(i+1);
					}
				}else if((int) ob == 2) {
					cmbd.removeAllItems();
				}
			}
		});
		cmbm.setBounds(388, 328, 58, 21);
		add(cmbm);
		cmbd.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				d = (int) e.getItem();
			}
		});		
		cmbd.setBounds(458, 328, 58, 21);
		add(cmbd);
		
		btnfindidm = new JButton("\uC544\uC774\uB514 \uCC3E\uAE30");
		btnfindidm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(findidlogic.check()) {
					main_frame.changePanel("findid");
				}else {
					JOptionPane.showMessageDialog(null, "´Ù½Ã ÀÔ·Â ÇØÁÖ¼¼¿ä");
				}
			}
		});
		btnfindidm.setForeground(Color.WHITE);
		btnfindidm.setBackground(new Color(35, 86, 149));
		btnfindidm.setBounds(254, 389, 262, 29);
		add(btnfindidm);
		
	}
}
