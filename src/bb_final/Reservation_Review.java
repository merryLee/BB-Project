package bb_final;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Reservation_Review extends JPanel {
   private JTextField textField;

   /**
    * Create the panel.
    */
   public Reservation_Review() {
      setBounds(new Rectangle(0, 0, 775, 559));
      setBounds(new Rectangle(0, 0, 775, 600));
      setLayout(null);
      
      JLabel label = new JLabel("\uD655\uC815 \uC608\uC57D \uBCF4\uAE30");
      label.setFont(new Font("±¼¸²", Font.BOLD, 25));
      label.setBounds(277, 0, 195, 67);
      add(label);
      
      JLabel label_3 = new JLabel("\uCD94\uAC00 \uC694\uCCAD\uC0AC\uD56D");
      label_3.setBorder(new LineBorder(new Color(0, 0, 0)));
      label_3.setBounds(346, 296, 156, 35);
      add(label_3);
      
      JButton button = new JButton("\uD6C4\uAE30 \uBC0F \uD3C9\uC810");
      button.setBackground(new Color(35, 86, 149));
      button.setForeground(Color.WHITE);
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      button.setBounds(346, 456, 331, 46);
      add(button);
      
      JLabel label_5 = new JLabel("New label");
      label_5.setBorder(new LineBorder(new Color(0, 0, 0)));
      label_5.setBounds(96, 88, 222, 202);
      add(label_5);
      
      textField = new JTextField();
      textField.setColumns(10);
      textField.setBounds(346, 338, 331, 112);
      add(textField);
      
      JTextArea textArea = new JTextArea();
      textArea.setText("\uC219\uC18C\uC815\uBCF4 \uBC1B\uC544\uC624\uAE30");
      textArea.setBounds(346, 88, 331, 202);
      add(textArea);
      
      JTextArea textArea_1 = new JTextArea();
      textArea_1.setText("\uC219\uC18C\uC815\uBCF4 \uBC1B\uC544\uC624\uAE30");
      textArea_1.setBounds(96, 296, 222, 154);
      add(textArea_1);
   }

}
