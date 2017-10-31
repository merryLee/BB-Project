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
	public MypageMainDto regdto[] = new MypageMainDto[4];
	public MypageMainDto resdto[] = new MypageMainDto[4];
	private ImageIcon aimg[] = new ImageIcon[4];
	private ImageIcon rimg[] = new ImageIcon[4];
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
		setBounds(new Rectangle(0, 0, 775, 559));
		setBackground(Color.WHITE);
		setLayout(null);
		Reservation_Confirm rc[] = new Reservation_Confirm[4];
		AccomodateEdit ae[] = new AccomodateEdit[4];
		Reservation_Review rv[] = new Reservation_Review[4];
		if (main_frame.isSession()) {
			session = main_frame.isSession();
			mno = main_frame.getMno();
			glist = dao.pathOrvalue(mno);
			slist = dao.rpathOrvalue(mno);
			if (glist.isEmpty()) {

			} else {
				int len = glist.size();
				for (int i = 0; i < len; i++) {
					regdto[i] = glist.get(i);
					ae[i] = new AccomodateEdit(this, regdto[i].getHno());
					aimg[i] = new ImageIcon(regdto[i].getPath());					
				}
				for (int i = 0; i < 4 - len; i++) {
					regdto[3 - i] = new MypageMainDto();
					aimg[3 - i] = new ImageIcon();
				}
				len = slist.size();
				for (int i = 0; i < len; i++) {					
					resdto[i] = slist.get(i);
					rc[i] = new Reservation_Confirm(this, resdto[i]);
					rv[i] = new Reservation_Review(this, resdto[i]);
					rimg[i] = new ImageIcon(resdto[i].getPath());
				}
				for (int i = 0; i < 4 - len; i++) {
					resdto[3 - i] = new MypageMainDto();
					rimg[3 - i] = new ImageIcon();
				}
			}
		}

		JLabel MyPage_label = new JLabel("MyPage");
		MyPage_label.setFont(new Font("굴림", Font.BOLD, 35));
		MyPage_label.setBounds(73, 32, 152, 83);
		add(MyPage_label);

		JLabel reservation_now_label = new JLabel("\uC608\uC57D\uD604\uD669");
		reservation_now_label.setFont(new Font("굴림", Font.BOLD, 25));
		reservation_now_label.setBounds(73, 125, 130, 39);
		add(reservation_now_label);

		homepic1 = new JButton(rimg[0]);
		homepic1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				delete = resdto[0].getHno();

				System.out.println(resdto[0].getBin()+ "VS" + time.getTime());
				if(delete != 0 && resdto[0].getBin().after(time.getTime())) {
				main_frame.intentp.add("reservation_confirm", rc[0]);
				main_frame.changePanel("reservation_confirm");
				}else if(delete != 0 && resdto[0].getBin().before(time.getTime())) {
					main_frame.intentp.add("reservation_review", rv[0]);
					main_frame.changePanel("reservation_review");
				}else {
					JOptionPane.showMessageDialog(null, "예약이 없습니다!");
				}
			}
		});
		homepic1.setBounds(71, 174, 132, 113);
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
		homepic2.setBounds(226, 174, 130, 113);
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
		homepic3.setBounds(390, 174, 130, 113);
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
		homepic4.setBounds(547, 174, 130, 113);
		add(homepic4);
		
		textArea = new JTextArea(resdto[0].getHname() + "\n$" + resdto[0].getHprice());
		textArea.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea.setEditable(false);
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(73, 286, 130, 45);
		add(textArea);

		textArea_1 = new JTextArea(resdto[1].getHname() + "\n$" + resdto[1].getHprice());
		textArea_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea_1.setEditable(false);
		textArea_1.setBackground(Color.WHITE);
		textArea_1.setBounds(226, 286, 130, 45);
		add(textArea_1);

		textArea_2 = new JTextArea(resdto[2].getHname() + "\n$" + resdto[2].getHprice());
		textArea_2.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea_2.setEditable(false);
		textArea_2.setBackground(Color.WHITE);
		textArea_2.setBounds(390, 286, 130, 45);
		add(textArea_2);

		textArea_3 = new JTextArea(resdto[3].getHname() + "\n$" + resdto[3].getHprice());
		textArea_3.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea_3.setEditable(false);
		textArea_3.setBackground(Color.WHITE);
		textArea_3.setBounds(547, 286, 130, 45);
		add(textArea_3);
		
		JLabel register_now_label = new JLabel("\uB4F1\uB85D \uD604\uD669");
		register_now_label.setFont(new Font("굴림", Font.BOLD, 25));
		register_now_label.setBounds(73, 352, 130, 39);
		add(register_now_label);

		System.out.println("loginmain_frame의 mypage session : " + main_frame.isSession());
		System.out.println("loginmain_frame의 mypage mno: " + main_frame.getMno());

		addhome1 = new JButton(aimg[0]);
		addhome1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (regdto[0].getHprice() == 0) {
					main_frame.changePanel("accomodateregist");
				} else {
					main_frame.intentp.add("accomdateedit",ae[0]);
					main_frame.changePanel("accomdateedit");
				}
			}
		});
		addhome1.setBounds(73, 401, 130, 113);
		add(addhome1);
		addhome2 = new JButton(aimg[1]);
		addhome2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (regdto[1].getHprice() == 0) {
					main_frame.changePanel("accomodateregist");
				} else {
					main_frame.intentp.add("accomdateedit",ae[1]);
					main_frame.changePanel("accomdateedit");
				}
			}
		});
		addhome2.setBounds(228, 401, 130, 113);
		add(addhome2);
		
		addhome3 = new JButton(aimg[2]);
		addhome3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (regdto[2].getHprice() == 0) {
					main_frame.changePanel("accomodateregist");
				} else {
					main_frame.intentp.add("accomdateedit",ae[2]);
					main_frame.changePanel("accomdateedit");
				}
			}
		});
		addhome3.setBounds(390, 401, 130, 113);
		add(addhome3);
		
		addhome4 = new JButton(aimg[3]);
		addhome4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (regdto[3].getHprice() == 0) {
					main_frame.changePanel("accomodateregist");
				} else {
					main_frame.intentp.add("accomdateedit",ae[3]);
					main_frame.changePanel("accomdateedit");
				}
			}
		});
		addhome4.setBounds(547, 401, 130, 113);
		add(addhome4);

		

		JTextArea addhomepic1_textArea = new JTextArea(regdto[0].getHname() + "\n$" + regdto[0].getHprice());
		addhomepic1_textArea.setFont(new Font("Monospaced", Font.BOLD, 15));
		addhomepic1_textArea.setBackground(Color.WHITE);
		addhomepic1_textArea.setBounds(73, 517, 130, 32);
		add(addhomepic1_textArea);

		JTextArea addhomepic2_textArea = new JTextArea(regdto[1].getHname() + "\n$" + regdto[1].getHprice());
		addhomepic2_textArea.setFont(new Font("Monospaced", Font.BOLD, 15));
		addhomepic2_textArea.setBackground(Color.WHITE);
		addhomepic2_textArea.setBounds(226, 517, 130, 32);
		add(addhomepic2_textArea);

		JTextArea addhomepic3_textArea = new JTextArea(regdto[2].getHname() + "\n$" + regdto[2].getHprice());
		addhomepic3_textArea.setFont(new Font("Monospaced", Font.BOLD, 15));
		addhomepic3_textArea.setBackground(Color.WHITE);
		addhomepic3_textArea.setBounds(390, 517, 130, 32);
		add(addhomepic3_textArea);

		JTextArea addhomepic4_textArea = new JTextArea(regdto[3].getHname() + "\n$" + regdto[3].getHprice());
		addhomepic4_textArea.setFont(new Font("Monospaced", Font.BOLD, 15));
		addhomepic4_textArea.setBackground(Color.WHITE);
		addhomepic4_textArea.setBounds(547, 517, 130, 32);
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
		registerhome_mng.setBounds(194, 356, 184, 39);
		add(registerhome_mng);

		btn_profile_edit = new JButton("\uD504\uB85C\uD544 \uC218\uC815");
		btn_profile_edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_frame.changePanel("profile");
			}
		});
		btn_profile_edit.setForeground(Color.WHITE);
		btn_profile_edit.setBackground(new Color(35, 86, 149));
		btn_profile_edit.setBounds(237, 62, 141, 39);
		add(btn_profile_edit);

	}
}