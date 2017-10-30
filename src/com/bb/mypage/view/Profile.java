package com.bb.mypage.view;

import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.bb.common.view.Main_frame;
import com.bb.member.model.MemberDto;
import com.bb.mypage.controller.ProfileLogic;
import com.bb.mypage.model.ProfileDao;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Profile extends JPanel {
	public JTextField name;
	public JPasswordField pw;
	public JTextField tel;
	public JTextField ans;
	public JComboBox cmbq;
	public JComboBox cmby;
	public JComboBox cmbm;
	public JComboBox cmbd;
	private JButton btn_reg;
	MemberDto memberdto = new MemberDto();
	List<MemberDto> list = new ArrayList<MemberDto>();
	public int y;
	public int m;
	public int d;
	public int lastday;
	ProfileDao dao = new ProfileDao();
	ProfileLogic logic = new ProfileLogic(this);
	/**
	 * Create the panel.
	 * 
	 * @param main_frame
	 */
	private int mno;
	public Profile(Main_frame main_frame) {
		setBounds(new Rectangle(0, 0, 775, 559));
		setBackground(Color.WHITE);
		setLayout(null);
		
		if(main_frame.isSession()) {
			mno = main_frame.getMno();
			list = dao.joinValue(mno);
			memberdto = list.get(0);			
		}

		JLabel label = new JLabel("\uD504\uB85C\uD544 \uC218\uC815");
		label.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		label.setBounds(290, 31, 177, 48);
		add(label);

		JLabel label_2 = new JLabel("\uC774\uB984");
		label_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		label_2.setBounds(290, 141, 177, 15);
		add(label_2);
		
		name = new JTextField(memberdto.getMname());
		name.setColumns(10);
		name.setBounds(290, 166, 177, 21);
		add(name);

		JLabel label_3 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label_3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		label_3.setBounds(290, 197, 177, 15);
		add(label_3);
		
		
		
		pw = new JPasswordField(memberdto.getMpw());
		pw.setBounds(290, 222, 177, 21);
		add(pw);

		JLabel label_4 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		label_4.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		label_4.setBounds(290, 253, 177, 15);
		add(label_4);
		String ymd[] = memberdto.getMbirth().split("-");
		cmby = new JComboBox();
		cmby.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				y = (int) e.getItem();
			}
		});
		for (int i = 0; i < 30; i++) {
			cmby.addItem(2020-i);
		}
		
		cmby.setSelectedItem(Integer.parseInt(ymd[0]));
		cmby.setBounds(290, 276, 71, 21);
		add(cmby);

		cmbm = new JComboBox();
		cmbd = new JComboBox();
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
		cmbm.setSelectedItem(Integer.parseInt(ymd[1]));
		cmbm.setBounds(369, 276, 43, 21);
		add(cmbm);		
		cmbd.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				d = (int) e.getItem();
			}
		});	
		cmbd.setSelectedItem(Integer.parseInt(ymd[2]));
		cmbd.setBounds(424, 276, 43, 21);
		add(cmbd);

		JLabel label_5 = new JLabel("\uC804\uD654\uBC88\uD638");
		label_5.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		label_5.setBounds(290, 307, 177, 15);
		add(label_5);

		tel = new JTextField(memberdto.getMphone());
		tel.setColumns(10);
		tel.setBounds(290, 332, 177, 21);
		add(tel);

		JLabel label_6 = new JLabel("\uBCF4\uC548\uC9C8\uBB38");
		label_6.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		label_6.setBounds(290, 363, 177, 15);
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
		cmbq.setSelectedIndex(memberdto.getQno());
		cmbq.setBounds(290, 385, 177, 21);
		add(cmbq);

		JLabel label_7 = new JLabel("\uBCF4\uC548\uB2F5\uBCC0");
		label_7.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		label_7.setBounds(290, 414, 177, 15);
		add(label_7);

		ans = new JTextField(memberdto.getMansw());
		ans.setColumns(10);
		ans.setBounds(290, 439, 177, 21);
		add(ans);

		btn_reg = new JButton("\uB4F1\uB85D");
		btn_reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.update(mno);
				main_frame.changePanel("mypagemain");
			}
		});
		btn_reg.setForeground(Color.WHITE);
		btn_reg.setBackground(new Color(35, 86, 149));
		btn_reg.setBounds(290, 483, 177, 29);
		add(btn_reg);

	}
}
