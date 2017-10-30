package com.bb.member.view;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import com.bb.common.view.Main_frame;
import com.bb.member.controller.JoinLogic;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.util.Calendar;

import java.awt.event.ActionEvent;

public class Join extends JPanel {
	public JTextField id;
	public JTextField name;
	public JPasswordField pw;
	public JTextField tel;
	public JTextField ans;
	public JComboBox cmbq;
	public JCheckBox chkagree;
	private JButton btn_join_reg;
	public int y;
	public int m;
	public int d;
	public int lastday;
	JoinLogic joinlogic = new JoinLogic(this);
	
	
	/**
	 * Create the panel.
	 * @param main_frame 
	 */
	public Join(Main_frame main_frame) {
		setBounds(new Rectangle(0, 0, 775, 559));
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel label = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		label.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		label.setBounds(314, 10, 116, 48);
		add(label);
		
		JLabel label_1 = new JLabel("\uC544\uC774\uB514");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		label_1.setBounds(302, 64, 177, 15);
		add(label_1);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(302, 89, 177, 21);
		add(id);
		
		JLabel label_2 = new JLabel("\uC774\uB984");
		label_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		label_2.setBounds(302, 120, 177, 15);
		add(label_2);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(302, 145, 177, 21);
		add(name);
		
		JLabel label_3 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label_3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		label_3.setBounds(302, 176, 177, 15);
		add(label_3);
		
		pw = new JPasswordField();
		pw.setBounds(302, 201, 177, 21);
		add(pw);
		
		JLabel label_4 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		label_4.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		label_4.setBounds(302, 232, 177, 15);
		add(label_4);
		
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
		cmby.setBounds(302, 255, 71, 21);
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
		cmbm.setBounds(381, 255, 43, 21);
		add(cmbm);
		cmbd.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				d = (int) e.getItem();
			}
		});			
		cmbd.setBounds(436, 255, 43, 21);
		add(cmbd);
		
		JLabel label_5 = new JLabel("\uC804\uD654\uBC88\uD638");
		label_5.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		label_5.setBounds(302, 286, 177, 15);
		add(label_5);
		
		tel = new JTextField();
		tel.setColumns(10);
		tel.setBounds(302, 311, 177, 21);
		add(tel);
		
		JLabel label_6 = new JLabel("\uBCF4\uC548\uC9C8\uBB38");
		label_6.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		label_6.setBounds(302, 342, 177, 15);
		add(label_6);
		
		cmbq = new JComboBox();
		cmbq.addItem("첫 번째 선생님은 누구셨습니까?");
		cmbq.addItem("첫 번째 직장은 어디였습니까?");
		cmbq.addItem("가장 좋아했던 선생님은 누구셨습니까?");
		cmbq.addItem("처음으로 가 본 콘서트는 무엇입니까?");
		cmbq.addItem("가장 좋아했던 장소는 어디였습니까?");
		cmbq.addItem("어린 시절 가장 친했던 친구는 누구였습니까?");
		cmbq.addItem("어머니와 아버지가 만났던 도시는 어디입니까?");
		cmbq.addItem("2000년 1월 1일에 어디에 있었습니까?");
		cmbq.setBounds(302, 364, 177, 21);
		add(cmbq);
		
		JLabel label_7 = new JLabel("\uBCF4\uC548\uB2F5\uBCC0");
		label_7.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		label_7.setBounds(302, 393, 177, 15);
		add(label_7);
		
		ans = new JTextField();
		ans.setColumns(10);
		ans.setBounds(302, 418, 177, 21);
		add(ans);
		
		chkagree = new JCheckBox("\uC774\uC6A9\uC57D\uAD00, \uAC1C\uC778\uC815\uBCF4 \uC218\uC9D1 \uBC0F \uC774\uC6A9\uC5D0 \uBAA8\uB450 \uB3D9\uC758\uD569\uB2C8\uB2E4.");
		chkagree.setBounds(256, 445, 343, 23);
		add(chkagree);
		
		btn_join_reg = new JButton("\uB4F1\uB85D");
		btn_join_reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				joinlogic.check();
				name.setText("");
				id.setText("");
				pw.setText("");
				cmby.setSelectedIndex(1);
				cmbm.setSelectedIndex(1);
				tel.setText("");
				cmbq.setSelectedIndex(1);
				ans.setText("");
				chkagree.setSelected(false);
				main_frame.changePanel("login");
								
			}
		});
		btn_join_reg.setForeground(Color.WHITE);
		btn_join_reg.setBackground(new Color(35, 86, 149));
		btn_join_reg.setBounds(302, 474, 177, 29);
		add(btn_join_reg);

	}
	
}
