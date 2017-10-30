package com.bb.common.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainHeader extends JPanel implements ActionListener {

   private Main_frame main_frame;
   private JButton btnhome;
   private JButton btn1;
   private JButton btn2;

   /**
    * Create the panel.
    */
   public MainHeader(Main_frame main_frame) {

      this.main_frame = main_frame;
      setBackground(new Color(35, 86, 149));
      setBounds(0, 0, 753, 41);
      setLayout(null);

      ImageIcon symw = new ImageIcon(".\\img\\symbol_w_mini.jpg");
      btnhome = new JButton(symw);
      btnhome.setBounds(0, 0, 51, 41);
      add(btnhome);

      btn1 = new JButton("회원가입");
      btn1.setBackground(new Color(35, 86, 149));
      btn1.setForeground(new Color(255, 255, 255));
      btn1.setBounds(538, 15, 96, 14);
      add(btn1);

      btn2 = new JButton("로그인");
      btn2.setBackground(new Color(35, 86, 149));
      btn2.setForeground(new Color(255, 255, 255));
      btn2.setBounds(640, 15, 96, 14);
      add(btn2);

      btnhome.addActionListener(this);
      btn1.addActionListener(this);
      btn2.addActionListener(this);

      updateHeader();
   }
 

public void updateHeader() {
      if (main_frame.isSession() == false) { // 로그아웃상태이면
         btn1.setText("회원가입");
         btn2.setText("로그인");
      } else if (main_frame.getMno() == 19910327) { // 로그인상태 - 관리자일경우, 관리자번호 양희님탄신일!
         btn1.setText("Admin");
         btn2.setText("로그아웃");
      } else { // 로그인상태 - 일반회원일경우
         btn1.setText("MyPage");
         btn2.setText("로그아웃");
      }
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
      String btn = e.getActionCommand();

      if (e.getSource() == btnhome) {
         main_frame.changePanel("home");
      } else if ("회원가입".equals(btn)) {
         main_frame.changePanel("join");
      } else if ("로그인".equals(btn)) {
         main_frame.changePanel("login");   //로그인 화면에서 setSession, setMno 메소드 써야함.
      } else if ("MyPage".equals(btn)) {
         main_frame.changePanel("mypagemain");
      } else if ("Admin".equals(btn)) {
         main_frame.changePanel("admin");
      } else if ("로그아웃".equals(btn)) {
         main_frame.changePanel("home");
         main_frame.setSession(false);   //세션및 회원번호 초기화
         main_frame.setMno(0);
      }
   }

}
