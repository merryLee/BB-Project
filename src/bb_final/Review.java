package bb_final;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;

public class Review extends JPanel {
   
   JButton submit;

   public Review() {
      setBounds(new Rectangle(0, 0, 775, 559));
      setLayout(null);
      
      JLabel title = new JLabel("평점 및 후기 작성");
      title.setFont(new Font("굴림", Font.BOLD, 30));
      title.setBounds(271, 50, 260, 45);
      add(title);
      
      Font f = new Font("굴림", Font.PLAIN, 14);
      
      JRadioButton btn1A = new JRadioButton("\uB9E4\uC6B0\uBD88\uB9CC\uC871");
      btn1A.setFont(f);
      btn1A.setBounds(175, 120, 100, 30);
      add(btn1A);
      JRadioButton btn1B = new JRadioButton("\uBD88\uB9CC\uC871");
      btn1B.setFont(f);
      btn1B.setBounds(280, 120, 100, 30);
      add(btn1B);
      JRadioButton btn1C = new JRadioButton("\uBCF4\uD1B5");
      btn1C.setFont(f);
      btn1C.setBounds(385, 120, 100, 30);
      add(btn1C);      
      JRadioButton btn1D = new JRadioButton("\uB9CC\uC871");
      btn1D.setFont(f);
      btn1D.setBounds(490, 120, 100, 30);
      add(btn1D);
      JRadioButton btn1E = new JRadioButton("\uB9E4\uC6B0\uB9CC\uC871");
      btn1E.setFont(f);
      btn1E.setBounds(595, 120, 100, 30);
      add(btn1E);

      JRadioButton btn2A = new JRadioButton("\uB9E4\uC6B0\uBD88\uB9CC\uC871");
      btn2A.setFont(f);
      btn2A.setBounds(175, 165, 100, 30);
      add(btn2A);      
      JRadioButton btn2B = new JRadioButton("\uBD88\uB9CC\uC871");
      btn2B.setFont(f);
      btn2B.setBounds(280, 165, 100, 30);
      add(btn2B);
      JRadioButton btn2C = new JRadioButton("\uBCF4\uD1B5");
      btn2C.setFont(f);
      btn2C.setBounds(385, 165, 100, 30);
      add(btn2C);
      JRadioButton btn2D = new JRadioButton("\uB9CC\uC871");
      btn2D.setFont(f);
      btn2D.setBounds(490, 165, 100, 30);
      add(btn2D);
      JRadioButton btn2E = new JRadioButton("\uB9E4\uC6B0\uB9CC\uC871");
      btn2E.setFont(f);
      btn2E.setBounds(595, 165, 100, 30);
      add(btn2E);   

      JRadioButton btn3A = new JRadioButton("\uB9E4\uC6B0\uBD88\uB9CC\uC871");
      btn3A.setFont(f);
      btn3A.setBounds(175, 210, 100, 30);
      add(btn3A);      
      JRadioButton btn3B = new JRadioButton("\uBD88\uB9CC\uC871");
      btn3B.setFont(f);
      btn3B.setBounds(280, 210, 100, 30);
      add(btn3B);
      JRadioButton btn3C = new JRadioButton("\uBCF4\uD1B5");
      btn3C.setFont(f);
      btn3C.setBounds(385, 210, 100, 30);
      add(btn3C);
      JRadioButton btn3D = new JRadioButton("\uB9CC\uC871");
      btn3D.setFont(f);
      btn3D.setBounds(490, 210, 100, 30);
      add(btn3D);
      JRadioButton btn3E = new JRadioButton("\uB9E4\uC6B0\uB9CC\uC871");
      btn3E.setFont(f);
      btn3E.setBounds(595, 210, 100, 30);
      add(btn3E);   
      
      JRadioButton btn4A = new JRadioButton("\uB9E4\uC6B0\uBD88\uB9CC\uC871");
      btn4A.setFont(f);
      btn4A.setBounds(175, 255, 100, 30);
      add(btn4A);
      JRadioButton btn4B = new JRadioButton("\uBD88\uB9CC\uC871");
      btn4B.setFont(f);
      btn4B.setBounds(280, 255, 100, 30);
      add(btn4B);
      JRadioButton btn4C = new JRadioButton("\uBCF4\uD1B5");
      btn4C.setFont(f);
      btn4C.setBounds(385, 255, 100, 30);
      add(btn4C);
      JRadioButton btn4D = new JRadioButton("\uB9CC\uC871");
      btn4D.setFont(f);
      btn4D.setBounds(490, 255, 100, 30);
      add(btn4D);   
      JRadioButton btn4E = new JRadioButton("\uB9E4\uC6B0\uB9CC\uC871");
      btn4E.setFont(f);
      btn4E.setBounds(595, 255, 100, 30);
      add(btn4E);      
      

      f = new Font("굴림", Font.BOLD, 14);
      
      JLabel label = new JLabel("\uCD1D\uC810");
      label.setFont(f);
      label.setBounds(100, 120, 60, 30);
      add(label);
      JLabel label2 = new JLabel("\uC704\uCE58");
      label2.setFont(f);
      label2.setBounds(100, 165, 60, 30);
      add(label2);
      JLabel label3 = new JLabel("\uCCAD\uACB0\uB3C4");
      label3.setFont(f);
      label3.setBounds(100, 210, 60, 30);
      add(label3);   
      JLabel label4 = new JLabel("\uC758\uC0AC\uC18C\uD1B5");
      label4.setFont(f);
      label4.setBounds(100, 255, 60, 30);
      add(label4);
            
      JLabel lblReview = new JLabel("\uD6C4\uAE30 \uC791\uC131");
      lblReview.setFont(f);
      lblReview.setBounds(100, 300, 80, 30);
      add(lblReview);
      JTextArea reviewSpec = new JTextArea();
      reviewSpec.setBorder(new LineBorder(new Color(21, 139, 203), 2));
      reviewSpec.setText("후기를 작성해주세요.");
      reviewSpec.setBounds(100, 330, 575, 113);
      add(reviewSpec);
      
      submit = new JButton("평점 및 후기 등록");
      submit.setFont(new Font("굴림", Font.BOLD, 16));
      submit.setBackground(new Color(21, 139, 203));
      submit.setForeground(Color.WHITE);
      submit.setBounds(455, 460, 220, 49);
      add(submit);
      

   }
}