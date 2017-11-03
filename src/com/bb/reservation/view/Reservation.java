package com.bb.reservation.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import com.bb.common.view.Main_frame;
import com.bb.house.model.HouseDto;
import com.bb.house.view.HouseInfo;
import com.bb.mypage.view.MypageMain;
import com.bb.reservation.model.ReservationDao;
import com.bb.reservation.model.ReservationDto;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Reservation extends JPanel {
   private JTextField reservation_add_text;
   private JButton reservation_cancle_button;
   private JButton reservation_confirm_button;
   int mno;
   Date indate ;
   Date outdate;
   public Reservation(HouseDto housedto, String BIN, String BOUT, int BPERSON,Main_frame main_frame) {
      setBounds(new Rectangle(0, 0, 775, 559));
      setBounds(new Rectangle(0, 0, 775, 600));
      setBackground(Color.WHITE);
      setLayout(null);
      if(main_frame.isSession()) {
    	  mno = main_frame.getMno();
      }
      
      JLabel reservation_confirm_label = new JLabel("\uD655\uC815 \uC608\uC57D \uBCF4\uAE30");
      reservation_confirm_label.setFont(new Font("±¼¸²", Font.BOLD, 25));
      reservation_confirm_label.setBounds(278, 0, 195, 67);
      add(reservation_confirm_label);
      
      JLabel reservation_add_label = new JLabel("\uCD94\uAC00 \uC694\uCCAD\uC0AC\uD56D");
      reservation_add_label.setBorder(new LineBorder(new Color(0, 0, 0)));
      reservation_add_label.setBounds(347, 296, 156, 35);
      add(reservation_add_label);
      
      reservation_cancle_button = new JButton("\uCDE8\uC18C");
      reservation_cancle_button.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		 main_frame.changePanel("home");
      	}
      });
      reservation_cancle_button.setBounds(347, 456, 156, 46);
      add(reservation_cancle_button);
      
      ImageIcon img = new ImageIcon(housedto.getHpath1());
      JLabel reservation_pic_label = new JLabel(img);
      reservation_pic_label.setBorder(new LineBorder(new Color(0, 0, 0)));
      reservation_pic_label.setBounds(97, 88, 222, 202);
      add(reservation_pic_label);
      
      reservation_confirm_button = new JButton("\uC608\uC57D \uD655\uC815");
      reservation_confirm_button.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		ReservationDto dto = new ReservationDto();
      		ReservationDao dao = new ReservationDao();
      		dto.setHNO(housedto.getHno());	      		
      		dto.setBGUEST(mno);
      		dto.setBPERSON(BPERSON);
      		dto.setBREQ(reservation_add_text.getText());
      		dao.insertBook(dto,BIN,BOUT);      		
      		
      		main_frame.remove(main_frame.mypagemain);
      		MypageMain myPageMain = new MypageMain(main_frame);
      		main_frame.intentp.add("mypagemain",myPageMain);
      		main_frame.changePanel("mypagemain");      		
      	}
      });
      reservation_confirm_button.setBackground(new Color(35,85,149));
      reservation_confirm_button.setForeground(Color.WHITE);
      reservation_confirm_button.setBounds(522, 456, 156, 46);
      add(reservation_confirm_button);
      
      reservation_add_text = new JTextField();
      reservation_add_text.setBounds(347, 338, 331, 112);
      add(reservation_add_text);
      reservation_add_text.setColumns(10);
      
      JTextArea textArea = new JTextArea("¿¹¾à¹øÈ£ :   BOOK_SEQ.CURRVAL "  + "\n" + "Ã¼Å©ÀÎ : " + BIN + "\n" + "Ã¼Å©¾Æ¿ô : "
				+ BOUT + "\n" + "¿ä±Ý : " + (housedto.getHprice()*BPERSON) + "\n" + "Åõ¼÷°´ ¸í¼ö : " + BPERSON );
      textArea.setFont(new Font("Monospaced", Font.BOLD, 21));
      textArea.setBounds(347, 88, 331, 202);
      add(textArea);
      
      JTextArea textArea_1 = new JTextArea(housedto.getHname() + "\n" + "TEL : " + housedto.getHphone());
      textArea_1.setFont(new Font("Monospaced", Font.BOLD, 20));
      textArea_1.setBounds(97, 296, 222, 154);
      add(textArea_1);

   }
}