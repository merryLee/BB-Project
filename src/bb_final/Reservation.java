package bb_final;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Reservation extends JPanel {
   private JTextField reservation_add_text;
   JButton reservation_cancle_button;
   JButton reservation_confirm_button;

   public Reservation() {
      setBounds(new Rectangle(0, 0, 775, 559));
      setBounds(new Rectangle(0, 0, 775, 600));
      setLayout(null);
      
      JLabel reservation_confirm_label = new JLabel("\uD655\uC815 \uC608\uC57D \uBCF4\uAE30");
      reservation_confirm_label.setFont(new Font("±¼¸²", Font.BOLD, 25));
      reservation_confirm_label.setBounds(278, 0, 195, 67);
      add(reservation_confirm_label);
      
      JLabel reservation_add_label = new JLabel("\uCD94\uAC00 \uC694\uCCAD\uC0AC\uD56D");
      reservation_add_label.setBorder(new LineBorder(new Color(0, 0, 0)));
      reservation_add_label.setBounds(347, 296, 156, 35);
      add(reservation_add_label);
      
      reservation_cancle_button = new JButton("\uCDE8\uC18C");
      reservation_cancle_button.setBounds(347, 456, 156, 46);
      add(reservation_cancle_button);
      
      JLabel reservation_pic_label = new JLabel("New label");
      reservation_pic_label.setBorder(new LineBorder(new Color(0, 0, 0)));
      reservation_pic_label.setBounds(97, 88, 222, 202);
      add(reservation_pic_label);
      
      reservation_confirm_button = new JButton("\uC608\uC57D \uD655\uC815");
      reservation_confirm_button.setBackground(new Color(35,85,149));
      reservation_confirm_button.setForeground(Color.WHITE);
      reservation_confirm_button.setBounds(522, 456, 156, 46);
      add(reservation_confirm_button);
      
      reservation_add_text = new JTextField();
      reservation_add_text.setBounds(347, 338, 331, 112);
      add(reservation_add_text);
      reservation_add_text.setColumns(10);
      
      JTextArea textArea = new JTextArea();
      textArea.setText("\uC219\uC18C\uC815\uBCF4 \uBC1B\uC544\uC624\uAE30");
      textArea.setBounds(347, 88, 331, 202);
      add(textArea);
      
      JTextArea textArea_1 = new JTextArea();
      textArea_1.setText("\uC219\uC18C\uC815\uBCF4 \uBC1B\uC544\uC624\uAE30");
      textArea_1.setBounds(97, 296, 222, 154);
      add(textArea_1);

   }
}