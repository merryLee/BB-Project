package com.bb.common.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bb.admin.view.Admin;
import com.bb.home.view.Home;
import com.bb.house.view.AccomodateEdit;
import com.bb.house.view.AccomodateRegist;
import com.bb.house.view.HouseInfo;
import com.bb.member.view.Findid;
import com.bb.member.view.Findid_main;
import com.bb.member.view.Findpw;
import com.bb.member.view.Findpw_main;
import com.bb.member.view.Join;
import com.bb.member.view.Login;
import com.bb.mypage.view.MypageMain;
import com.bb.mypage.view.Profile;
import com.bb.reservation.view.Reservation;
import com.bb.reservation.view.Reservation_Confirm;
import com.bb.review.view.Reservation_Review;

public class Main_frame extends JFrame {

	private boolean session; // false일때 비로그인상태, true일때 로그인상태
	private int mno; // 0(비로그인상태), 회원번호(로그인상태)

	private JPanel contentPane;
	MainHeader top;
	public JPanel intentp;
	CardLayout cards = new CardLayout();
	public MypageMain mypagemain;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_frame frame = new Main_frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main_frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 634);
		setBackground(Color.WHITE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		top = new MainHeader(this);
		top.setBounds(0, 0, 753, 41);
		contentPane.add(top);

		intentp = new JPanel();
		intentp.setBounds(0, 41, 753, 553);
		contentPane.add(intentp);
		intentp.setLayout(cards);
		intentp.add("home", new Home(this));
		// intentp.add("",new );
		intentp.add("login", new Login(this));
		intentp.add("join", new Join(this));
		intentp.add("findid_main", new Findid_main(this));
		intentp.add("findid", new Findid(this));
		intentp.add("findpw_main", new Findpw_main(this));
		intentp.add("findpw", new Findpw(this));

	}

	public Main_frame(boolean session, int mno) {

		this();
		this.session = session;
		this.mno = mno;
		this.top.updateHeader();
		if (mno != 19910327) {
			mypagemain = new MypageMain(this);
			intentp.add("mypagemain", mypagemain);
			intentp.add("profile", new Profile(this));
			intentp.add("accomodateregist", new AccomodateRegist(this));
		} else if (mno == 19910327) {
			intentp.add("admin", new Admin());
		}
	}

	public void changePanel(String panelname) {
		cards.show(intentp, panelname);
	}

	public boolean isSession() { // 로그인상태 여부 true! false!로 반환
		return session;
	}

	public void setSession(boolean session) {
		this.session = session;
		top.updateHeader();
	}

	public int getMno() { // 현재 로그인되어있는 회원의 번호 반환
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
		top.updateHeader();
	}
}