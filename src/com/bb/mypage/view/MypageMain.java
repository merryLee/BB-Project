package com.bb.mypage.view;

import javax.swing.JPanel;

import com.bb.common.view.Main_frame;
import com.bb.house.view.AccomodateEdit;
import com.bb.mypage.model.MypageMainDao;
import com.bb.mypage.model.MypageMainDto;
import com.bb.reservation.view.Reservation_Confirm;
import com.bb.review.view.Reservation_Review;

import java.awt.Rectangle;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class MypageMain extends JPanel {
	public JButton homepic1;
	public JButton homepic2;
	public JButton homepic3;
	public JButton homepic4;
	public JButton addhome1;
	public JButton addhome2;
	public JButton addhome3;
	public JButton addhome4;
	private JButton registerhome_mng;
	private JButton btn_profile_edit;
	private MypageMainDao dao = new MypageMainDao();
	private List<MypageMainDto> glist = new ArrayList<MypageMainDto>();
	private List<MypageMainDto> slist = new ArrayList<MypageMainDto>();
	public MypageMainDto regdto[] = new MypageMainDto[100];
	public MypageMainDto resdto[] = new MypageMainDto[100];
	private ImageIcon aimg[] = new ImageIcon[100];
	private ImageIcon rimg[] = new ImageIcon[100];
	public JTextArea textArea;
	public JTextArea textArea_1;
	public JTextArea textArea_2;
	public JTextArea textArea_3;
	public int mno;
	public boolean session;
	public int delete;
	public Main_frame main_frame;
	private Calendar time = Calendar.getInstance();
	
	/**
	 * Create the panel.
	 * 
	 * @param main_frame
	 */

	public MypageMain(Main_frame main_frame) {
		this.main_frame = main_frame;
		setBounds(new Rectangle(0, 0, 753, 553));
		setBackground(Color.WHITE);
		setLayout(null);
		Reservation_Confirm rc[] = new Reservation_Confirm[100];
		AccomodateEdit ae[] = new AccomodateEdit[100];
		Reservation_Review rv[] = new Reservation_Review[100];
		if (main_frame.isSession()) {
			session = main_frame.isSession();
			mno = main_frame.getMno();
			glist = dao.pathOrvalue(mno);
			slist = dao.rpathOrvalue(mno);
			
				int len = glist.size();
				int i = 0;				
				for (i = 0; i < len; i++) {
					regdto[i] = glist.get(i);
					ae[i] = new AccomodateEdit(this, regdto[i].getHno());
					aimg[i] = new ImageIcon(regdto[i].getPath());					
				}
				if(len == 1) {
					i = 1;
				}
				for (int k = 0; k < 10 - i; k++) {
					regdto[9 - k] = new MypageMainDto();
					aimg[9 - k] = new ImageIcon();
				}
				len = slist.size();
				i = 0;
				for (i = 0; i < len; i++) {					
					resdto[i] = slist.get(i);
					rc[i] = new Reservation_Confirm(this, resdto[i]);
					rv[i] = new Reservation_Review(this, resdto[i]);
					rimg[i] = new ImageIcon(resdto[i].getPath());
				}
				if(len == 1) {
					i = 1;
				}
				for (int k = 0; k < 10 - i; k++) {
					resdto[9 - k] = new MypageMainDto();
					rimg[9 - k] = new ImageIcon();
				}
			
		}
		JLabel MyPage_label = new JLabel("MyPage");
		MyPage_label.setFont(new Font("굴림", Font.BOLD, 35));
		MyPage_label.setBounds(59, 20, 152, 83);
		add(MyPage_label);

		JLabel reservation_now_label = new JLabel("\uC608\uC57D\uD604\uD669");
		reservation_now_label.setFont(new Font("굴림", Font.BOLD, 25));
		reservation_now_label.setBounds(59, 113, 130, 39);
		add(reservation_now_label);
		

		JLabel register_now_label = new JLabel("\uB4F1\uB85D \uD604\uD669");
		register_now_label.setFont(new Font("굴림", Font.BOLD, 25));
		register_now_label.setBounds(59, 340, 130, 39);
		add(register_now_label);
		if(slist.size() != 0) {	
			
			System.out.println("허허");
		homepic1 = new JButton(rimg[0]);
		homepic1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				delete = resdto[0].getHno();
				if(delete != 0 && resdto[0].getBin().after(time.getTime())) {
				main_frame.intentp.add("reservation_confirm", rc[0]);
				main_frame.changePanel("reservation_confirm");
				}else if(delete != 0 && resdto[0].getBin().before(time.getTime())) {
					if(resdto[0].getBstatus().equals("2")) {
						rv[0].button.setVisible(false);
					}
					main_frame.intentp.add("reservation_review", rv[0]);
					main_frame.changePanel("reservation_review");
					
				}else {
					JOptionPane.showMessageDialog(null, "예약이 없습니다!");
				}
			}
		});
		homepic1.setBounds(57, 162, 132, 113);
		add(homepic1);
		
		homepic2 = new JButton(rimg[1]);
		homepic2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete = resdto[1].getHno();
				if(delete != 0 && resdto[1].getBin().after(time.getTime())) {
					System.out.println(resdto[1].getBin()+ "VS" + time.getTime());
				main_frame.intentp.add("reservation_confirm", rc[1]);
				main_frame.changePanel("reservation_confirm");
				}else if(delete != 0 && resdto[1].getBin().before(time.getTime())) {
					main_frame.intentp.add("reservation_review", rv[1]);
					main_frame.changePanel("reservation_review");
				}else {
					JOptionPane.showMessageDialog(null, "예약이 없습니다!");
				}
			}
		});
		homepic2.setBounds(212, 162, 130, 113);
		add(homepic2);

		homepic3 = new JButton(rimg[2]);
		homepic3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete = resdto[2].getHno();
				if(delete != 0 && resdto[2].getBin().after(time.getTime())) {
					System.out.println(resdto[2].getBin()+ "VS" + time.getTime());
				main_frame.intentp.add("reservation_confirm", rc[2]);
				main_frame.changePanel("reservation_confirm");
				}else if(delete != 0 && resdto[2].getBin().before(time.getTime())) {
					main_frame.intentp.add("reservation_review", rv[2]);
					main_frame.changePanel("reservation_review");
				}else {
					JOptionPane.showMessageDialog(null, "예약이 없습니다!");
				}
			}
		});
		homepic3.setBounds(376, 162, 130, 113);
		add(homepic3);

		homepic4 = new JButton(rimg[3]);
		homepic4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete = resdto[3].getHno();
				if(delete != 0 && resdto[3].getBin().after(time.getTime())) {
				System.out.println(resdto[3].getBin()+ "VS" + time.getTime());
				main_frame.intentp.add("reservation_confirm", rc[3]);
				main_frame.changePanel("reservation_confirm");
				}else if(delete != 0 && resdto[3].getBin().before(time.getTime())) {
					main_frame.intentp.add("reservation_review", rv[3]);
					main_frame.changePanel("reservation_review");
				}else {
					JOptionPane.showMessageDialog(null, "예약이 없습니다!");
				}
			}
		});
		homepic4.setBounds(533, 162, 130, 113);
		add(homepic4);
		System.out.println(resdto[0].getHname());
		
		textArea = new JTextArea(resdto[0].getHname() + "\n$" + resdto[0].getHprice());
		textArea.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea.setEditable(false);
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(59, 274, 130, 45);
		add(textArea);

		textArea_1 = new JTextArea(resdto[1].getHname() + "\n$" + resdto[1].getHprice());
		textArea_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea_1.setEditable(false);
		textArea_1.setBackground(Color.WHITE);
		textArea_1.setBounds(212, 274, 130, 45);
		add(textArea_1);

		textArea_2 = new JTextArea(resdto[2].getHname() + "\n$" + resdto[2].getHprice());
		textArea_2.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea_2.setEditable(false);
		textArea_2.setBackground(Color.WHITE);
		textArea_2.setBounds(376, 274, 130, 45);
		add(textArea_2);

		textArea_3 = new JTextArea(resdto[3].getHname() + "\n$" + resdto[3].getHprice());
		textArea_3.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea_3.setEditable(false);
		textArea_3.setBackground(Color.WHITE);
		textArea_3.setBounds(533, 274, 130, 45);
		add(textArea_3);
				
		}
		
	
		addhome1 = new JButton(aimg[0]);
		addhome1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (regdto[0].getHprice() == 0) {
					main_frame.changePanel("accomodateregist");
				} else {
					main_frame.intentp.add("accomdateedit",ae[0]);
					if(regdto[0].getHstatus().equals("등록중")) {
							addhome1.setEnabled(false);
							JOptionPane.showMessageDialog(null, "등록중이라 편집이 불가합니다.");
					}else main_frame.changePanel("accomdateedit");
				}
			}
		});
		addhome1.setBounds(59, 389, 130, 113);
		add(addhome1);
		addhome2 = new JButton(aimg[1]);
		addhome2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (regdto[1].getHprice() == 0) {
					main_frame.changePanel("accomodateregist");
				} else {
					main_frame.intentp.add("accomdateedit",ae[1]);
					if(regdto[1].getHstatus().equals("등록중")) {
						addhome2.setEnabled(false);
						JOptionPane.showMessageDialog(null, "등록중이라 편집이 불가합니다.");
					}else main_frame.changePanel("accomdateedit");
				}
			}
		});
		addhome2.setBounds(214, 389, 130, 113);
		add(addhome2);
		
		addhome3 = new JButton(aimg[2]);
		addhome3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (regdto[2].getHprice() == 0) {
					main_frame.changePanel("accomodateregist");
				} else {
					main_frame.intentp.add("accomdateedit",ae[2]);
					if(regdto[2].getHstatus().equals("등록중")) {
						addhome3.setEnabled(false);
						JOptionPane.showMessageDialog(null, "등록중이라 편집이 불가합니다.");
					}else main_frame.changePanel("accomdateedit");
				}
			}
		});
		addhome3.setBounds(376, 389, 130, 113);
		add(addhome3);
		
		addhome4 = new JButton(aimg[3]);
		addhome4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (regdto[3].getHprice() == 0) {
					main_frame.changePanel("accomodateregist");
				} else {
					main_frame.intentp.add("accomdateedit",ae[3]);
					if(regdto[3].getHstatus().equals("등록중")) {
						addhome4.setEnabled(false);
						JOptionPane.showMessageDialog(null, "등록중이라 편집이 불가합니다.");
					}else main_frame.changePanel("accomdateedit");
				}
			}
		});
		addhome4.setBounds(533, 389, 130, 113);
		add(addhome4);

		

		JTextArea addhomepic1_textArea = new JTextArea(regdto[0].getHname()+ "("+regdto[0].getHstatus() + ")" + "\n$" + regdto[0].getHprice());
		addhomepic1_textArea.setFont(new Font("Monospaced", Font.BOLD, 13));
		addhomepic1_textArea.setBackground(Color.WHITE);
		addhomepic1_textArea.setBounds(59, 505, 130, 40);
		add(addhomepic1_textArea);

		JTextArea addhomepic2_textArea = new JTextArea(regdto[1].getHname()+ "("+regdto[1].getHstatus() + ")"+ "\n$" + regdto[1].getHprice());
		addhomepic2_textArea.setFont(new Font("Monospaced", Font.BOLD, 13));
		addhomepic2_textArea.setBackground(Color.WHITE);
		addhomepic2_textArea.setBounds(212, 505, 130, 40);
		add(addhomepic2_textArea);

		JTextArea addhomepic3_textArea = new JTextArea(regdto[2].getHname()+ "("+regdto[2].getHstatus() + ")"+ "\n$" + regdto[2].getHprice());
		addhomepic3_textArea.setFont(new Font("Monospaced", Font.BOLD, 13));
		addhomepic3_textArea.setBackground(Color.WHITE);
		addhomepic3_textArea.setBounds(376, 505, 130, 40);
		add(addhomepic3_textArea);

		JTextArea addhomepic4_textArea = new JTextArea(regdto[3].getHname()+ "("+regdto[3].getHstatus() + ")"+ "\n$" + regdto[3].getHprice());
		addhomepic4_textArea.setFont(new Font("Monospaced", Font.BOLD, 13));
		addhomepic4_textArea.setBackground(Color.WHITE);
		addhomepic4_textArea.setBounds(533, 505, 130, 40);
		add(addhomepic4_textArea);
		
		
		registerhome_mng = new JButton("\uB4F1\uB85D\uB41C \uC9D1 \uC608\uC57D \uAD00\uB9AC");
		registerhome_mng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_frame.intentp.add("mypage_registered_mng",new Mypage_registered_mng(main_frame));
				main_frame.changePanel("mypage_registered_mng");
			}
		});
		registerhome_mng.setBackground(new Color(35, 86, 149));
		registerhome_mng.setForeground(new Color(255, 255, 255));
		registerhome_mng.setBounds(180, 344, 184, 39);
		add(registerhome_mng);

		btn_profile_edit = new JButton("\uD504\uB85C\uD544 \uC218\uC815");
		btn_profile_edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_frame.changePanel("profile");
			}
		});
		btn_profile_edit.setForeground(Color.WHITE);
		btn_profile_edit.setBackground(new Color(35, 86, 149));
		btn_profile_edit.setBounds(223, 50, 141, 39);
		add(btn_profile_edit);

	}
}