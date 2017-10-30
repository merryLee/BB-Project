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

      btn1 = new JButton("ȸ������");
      btn1.setBackground(new Color(35, 86, 149));
      btn1.setForeground(new Color(255, 255, 255));
      btn1.setBounds(538, 15, 96, 14);
      add(btn1);

      btn2 = new JButton("�α���");
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
      if (main_frame.isSession() == false) { // �α׾ƿ������̸�
         btn1.setText("ȸ������");
         btn2.setText("�α���");
      } else if (main_frame.getMno() == 19910327) { // �α��λ��� - �������ϰ��, �����ڹ�ȣ �����ź����!
         btn1.setText("Admin");
         btn2.setText("�α׾ƿ�");
      } else { // �α��λ��� - �Ϲ�ȸ���ϰ��
         btn1.setText("MyPage");
         btn2.setText("�α׾ƿ�");
      }
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
      String btn = e.getActionCommand();

      if (e.getSource() == btnhome) {
         main_frame.changePanel("home");
      } else if ("ȸ������".equals(btn)) {
         main_frame.changePanel("join");
      } else if ("�α���".equals(btn)) {
         main_frame.changePanel("login");   //�α��� ȭ�鿡�� setSession, setMno �޼ҵ� �����.
      } else if ("MyPage".equals(btn)) {
         main_frame.changePanel("mypagemain");
      } else if ("Admin".equals(btn)) {
         main_frame.changePanel("admin");
      } else if ("�α׾ƿ�".equals(btn)) {
         main_frame.changePanel("home");
         main_frame.setSession(false);   //���ǹ� ȸ����ȣ �ʱ�ȭ
         main_frame.setMno(0);
      }
   }

}
