package bb_final;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mypage_registered_mng extends JPanel {

   public Mypage_registered_mng(Main_frame main_frame) {
      setBounds(new Rectangle(0, 0, 775, 559));
      setLayout(null);

      JLabel registered_mng_label = new JLabel("\uB4F1\uB85D\uB41C \uC9D1 \uC608\uC57D \uAD00\uB9AC");
      registered_mng_label.setFont(new Font("굴림", Font.BOLD, 35));
      registered_mng_label.setBounds(222, 0, 368, 95);
      add(registered_mng_label);

      /////////////////////////////////////////////////JTable 순서 중요
      JTable userTable;
      JScrollPane listjs;
      Vector<String> userColumn = new Vector<String>();
      Vector<String> userRow;
      DefaultTableModel model;
      userColumn.addElement("No.");
      userColumn.addElement("예약 번호");
      userColumn.addElement("게스트 이름");
      userColumn.addElement("체크인 날짜");
      userColumn.addElement("체크아웃 날짜");
      userColumn.addElement("인원");
      model = new DefaultTableModel(userColumn, 100);
      userTable = new JTable(model);
      listjs = new JScrollPane(userTable);
      listjs.setBounds(115, 123, 568, 294);
      listjs.setAutoscrolls(true);
      add(listjs);
      ///////////////////////////////////////////////////

      JLabel registered_mng_label2 = new JLabel("\uB4F1\uB85D\uB41C \uC9D1 \uC608\uC57D \uAD00\uB9AC");
      registered_mng_label2.setBounds(115, 105, 117, 15);
      add(registered_mng_label2);

      JButton register_cancel_button = new JButton("\uC608\uC57D \uCDE8\uC18C");
      register_cancel_button.setBackground(new Color(35, 85, 149));
      register_cancel_button.setForeground(Color.WHITE);
      register_cancel_button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      register_cancel_button.setBounds(531, 477, 152, 41);
      add(register_cancel_button);

   }
}