package bb_final;

import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MypageMain extends JPanel {
	JButton homepic1;
	JButton homepic2;
	JButton homepic3;
	JButton homepic4;
	JButton addhome1;
	JButton addhome2;
	JButton addhome3;
	JButton addhome4;
	JButton registerhome_mng;
	JButton btn_profile_edit;

   /**
    * Create the panel.
 * @param main_frame 
    */
   public MypageMain(Main_frame main_frame) {
      setBounds(new Rectangle(0, 0, 775, 559));
      setLayout(null);
      
      JLabel MyPage_label = new JLabel("MyPage");
      MyPage_label.setFont(new Font("±¼¸²", Font.BOLD, 35));
      MyPage_label.setBounds(73, 32, 152, 83);
      add(MyPage_label);
      
      JLabel reservation_now_label = new JLabel("\uC608\uC57D\uD604\uD669");
      reservation_now_label.setFont(new Font("±¼¸²", Font.BOLD, 25));
      reservation_now_label.setBounds(73, 125, 130, 39);
      add(reservation_now_label);
      
      homepic1 = new JButton("\uC9D1\uC0AC\uC9C41");
      homepic1.setBounds(71, 174, 130, 113);
      add(homepic1);
      
      homepic2 = new JButton("\uC9D1\uC0AC\uC9C42");
      homepic2.setBounds(226, 174, 130, 113);
      add(homepic2);
      
      homepic3 = new JButton("\uC9D1\uC0AC\uC9C43");
      homepic3.setBounds(390, 174, 130, 113);
      add(homepic3);
      
      homepic4 = new JButton("\uC9D1\uC0AC\uC9C44");
      homepic4.setBounds(547, 174, 130, 113);
      add(homepic4);
      
      JLabel homepic1_label = new JLabel("New labelffffffffffffff");
      homepic1_label.setBounds(71, 290, 130, 15);
      add(homepic1_label);
      
      JLabel homepic2_label = new JLabel("New labelffffffffffffff");
      homepic2_label.setBounds(226, 290, 130, 15);
      add(homepic2_label);
      
      JLabel homepic3_label = new JLabel("New labelffffffffffffff");
      homepic3_label.setBounds(390, 290, 130, 15);
      add(homepic3_label);
      
      JLabel homepic4_label = new JLabel("New labelffffffffffffff");
      homepic4_label.setBounds(547, 290, 130, 15);
      add(homepic4_label);
      
      JLabel register_now_label = new JLabel("\uB4F1\uB85D \uD604\uD669");
      register_now_label.setFont(new Font("±¼¸²", Font.BOLD, 25));
      register_now_label.setBounds(73, 352, 130, 39);
      add(register_now_label);
      
      addhome1 = new JButton("\uC9D1\uC0AC\uC9C41");
      addhome1.setBounds(73, 401, 130, 113);
      add(addhome1);
      
      addhome2 = new JButton("\uC9D1\uC0AC\uC9C42");
      addhome2.setBounds(228, 401, 130, 113);
      add(addhome2);
      
      JLabel addhomepic1_label = new JLabel("New labelffffffffffffff");
      addhomepic1_label.setBounds(73, 517, 130, 15);
      add(addhomepic1_label);
      
      JLabel addhomepic2_label = new JLabel("New labelffffffffffffff");
      addhomepic2_label.setBounds(228, 517, 130, 15);
      add(addhomepic2_label);
      
      JLabel addhomepic3_label = new JLabel("New labelffffffffffffff");
      addhomepic3_label.setBounds(392, 517, 130, 15);
      add(addhomepic3_label);
      
      registerhome_mng = new JButton("\uB4F1\uB85D\uB41C \uC9D1 \uC608\uC57D \uAD00\uB9AC");
      registerhome_mng.setBackground(new Color(35, 86, 149));
      registerhome_mng.setForeground(new Color(255,255,255));
      registerhome_mng.setBounds(194, 356, 141, 39);
      add(registerhome_mng);
      
      addhome4 = new JButton("+ \uAE30\uD638");
      addhome4.setBounds(547, 401, 130, 113);
      add(addhome4);
      
      addhome3 = new JButton("\uC9D1\uC0AC\uC9C43");
      addhome3.setBounds(390, 401, 130, 113);
      add(addhome3);
      
      btn_profile_edit = new JButton("\uD504\uB85C\uD544 \uC218\uC815");
      btn_profile_edit.setForeground(Color.WHITE);
      btn_profile_edit.setBackground(new Color(35, 86, 149));
      btn_profile_edit.setBounds(237, 62, 141, 39);
      add(btn_profile_edit);

   }
}