package com.bb.review.view;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.bb.common.view.Main_frame;
import com.bb.mypage.model.MypageMainDto;
import com.bb.mypage.view.MypageMain;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class Reservation_Review extends JPanel {
	public JButton button;

   /**
    * Create the panel.
 * @param mypageMain 
    */
   public Reservation_Review(MypageMain mypageMain, MypageMainDto resdto) {
      setBounds(new Rectangle(0, 0, 775, 559));
      setBounds(new Rectangle(0, 0, 775, 600));
      setBackground(Color.WHITE);
      setLayout(null);
      
      JLabel label = new JLabel("\uD6C4\uAE30 \uBC0F \uD3C9\uC810");
      label.setFont(new Font("±¼¸²", Font.BOLD, 25));
      label.setBounds(277, 0, 195, 67);
      add(label);
      
      JLabel label_3 = new JLabel("\uCD94\uAC00 \uC694\uCCAD\uC0AC\uD56D");
      label_3.setBounds(346, 296, 156, 35);
      add(label_3);
      
      button = new JButton("\uD6C4\uAE30 \uBC0F \uD3C9\uC810");
      button.setBackground(new Color(35, 86, 149));
      button.setForeground(Color.WHITE);
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 if(resdto.getBstatus().equals("2")) {
        		 remove(button);
        	 }
        	 mypageMain.main_frame.intentp.add("review",new Review(mypageMain.main_frame,resdto));
        	 mypageMain.main_frame.changePanel("review");        	
        }
      });
      button.setBounds(346, 456, 331, 46);
      add(button);
      ImageIcon img = new ImageIcon(resdto.getPath());      
      JLabel imgg = new JLabel(img);
      imgg.setBorder(new LineBorder(new Color(0, 0, 0)));
      imgg.setBounds(96, 88, 222, 202);
      add(imgg);
      
      JTextArea textArea = new JTextArea("¿¹¾à¹øÈ£ : " + resdto.getBno() + "\n" + "Ã¼Å©ÀÎ : " + resdto.getBin() + "\n" + "Ã¼Å©¾Æ¿ô : "
				+ resdto.getBout() + "\n" + "¿ä±Ý : " + resdto.getHprice() + "\n" + "Åõ¼÷°´ ¸í¼ö : " + resdto.getBperson());
      textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
      textArea.setBackground(UIManager.getColor("Panel.background"));
      textArea.setFont(new Font("Monospaced", Font.BOLD, 21));
      textArea.setBounds(346, 88, 331, 202);
      add(textArea);
      
      JTextArea textArea_1 = new JTextArea(resdto.getHname() + "\n" + "TEL : " + resdto.getHphone());
      textArea_1.setBorder(new LineBorder(new Color(0, 0, 0)));
      textArea_1.setBackground(UIManager.getColor("Panel.background"));
      textArea_1.setFont(new Font("Monospaced", Font.BOLD, 20));
      textArea_1.setBounds(96, 296, 222, 154);
      add(textArea_1);
      
      JTextArea textArea_2 = new JTextArea();
      textArea_2.setBorder(new LineBorder(new Color(0, 0, 0)));
      textArea_2.setBackground(UIManager.getColor("Panel.background"));
      textArea_2.setBounds(346, 338, 331, 103);
      textArea_2.setText(resdto.getBreq());
      add(textArea_2);
   }
}
