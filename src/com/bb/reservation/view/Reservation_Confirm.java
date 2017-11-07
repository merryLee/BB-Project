package com.bb.reservation.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.bb.common.view.Main_frame;
import com.bb.mypage.model.MypageMainDto;
import com.bb.mypage.view.MypageMain;
import com.bb.reservation.model.Reservation_ConfirmDao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class Reservation_Confirm extends JPanel {
	private JButton btn_rescon_cancel;
	Reservation_ConfirmDao dao = new Reservation_ConfirmDao();
	int mno;
	MypageMain mypagemain;

	/**
	 * Create the panel.
	 * 
	 * @param resdto
	 * @param mypageMain
	 */
	public Reservation_Confirm(MypageMain mypagemain, MypageMainDto resdto) {
		setBackground(Color.WHITE);
		
		this.mypagemain = mypagemain;
		setBounds(new Rectangle(0, 0, 775, 559));
		setBounds(new Rectangle(0, 0, 775, 600));
		setLayout(null);

		JLabel label = new JLabel("\uD655\uC815 \uC608\uC57D \uBCF4\uAE30");
		label.setFont(new Font("±¼¸²", Font.BOLD, 25));
		label.setBounds(278, 0, 195, 67);
		add(label);

		JLabel label_3 = new JLabel("\uCD94\uAC00 \uC694\uCCAD\uC0AC\uD56D");
		label_3.setFont(new Font("±¼¸²", Font.BOLD, 19));
		label_3.setBorder(null);
		label_3.setBounds(349, 296, 156, 35);
		add(label_3);

		btn_rescon_cancel = new JButton("\uC608\uC57D \uCDE8\uC18C");
		btn_rescon_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mypagemain.session) {
					mno = mypagemain.mno;
				}
				if (mypagemain.delete == mypagemain.resdto[0].getHno()) {
					dao.cancelBook(mno, mypagemain.resdto[0].getHno());
					mypagemain.remove(mypagemain);
					MypageMain myPageMain = new MypageMain(mypagemain.main_frame);
		      		mypagemain.main_frame.intentp.add("mypagemain",myPageMain);
		      		mypagemain.main_frame.changePanel("mypagemain");      	
				} else if (mypagemain.delete == mypagemain.resdto[1].getHno()) {
					dao.cancelBook(mno, mypagemain.resdto[1].getHno());
					mypagemain.remove(mypagemain);
					MypageMain myPageMain = new MypageMain(mypagemain.main_frame);
		      		mypagemain.main_frame.intentp.add("mypagemain",myPageMain);
		      		mypagemain.main_frame.changePanel("mypagemain");
				} else if (mypagemain.delete == mypagemain.resdto[2].getHno()) {
					dao.cancelBook(mno, mypagemain.resdto[2].getHno());
					mypagemain.remove(mypagemain);
					MypageMain myPageMain = new MypageMain(mypagemain.main_frame);
		      		mypagemain.main_frame.intentp.add("mypagemain",myPageMain);
		      		mypagemain.main_frame.changePanel("mypagemain");
				} else if (mypagemain.delete == mypagemain.resdto[3].getHno()) {
					dao.cancelBook(mno, mypagemain.resdto[3].getHno());
					mypagemain.remove(mypagemain);
					MypageMain myPageMain = new MypageMain(mypagemain.main_frame);
		      		mypagemain.main_frame.intentp.add("mypagemain",myPageMain);
		      		mypagemain.main_frame.changePanel("mypagemain");
				} else
					mypagemain.main_frame.changePanel("mypagemain");
			}
		});
		btn_rescon_cancel.setBorder(null);
		btn_rescon_cancel.setBackground(new Color(255, 89, 95));
		btn_rescon_cancel.setBounds(349, 456, 331, 46);
		add(btn_rescon_cancel);

		ImageIcon img = new ImageIcon(resdto.getPath());
		JLabel label_5 = new JLabel(img);
		label_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		label_5.setBounds(99, 88, 222, 202);
		add(label_5);

		JTextArea textArea = new JTextArea();
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea.setBackground(UIManager.getColor("TextArea.disabledBackground"));
		textArea.setFont(new Font("Monospaced", Font.BOLD, 20));
		textArea.setText(resdto.getHname() + "\n" + "TEL : " + resdto.getHphone());
		textArea.setBounds(99, 296, 222, 154);
		add(textArea);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea_1.setFont(new Font("Monospaced", Font.BOLD, 21));
		textArea_1.setBackground(UIManager.getColor("TextField.disabledBackground"));
		textArea_1.setText("¿¹¾à¹øÈ£ : " + resdto.getBno() + "\n" + "Ã¼Å©ÀÎ : " + resdto.getBin() + "\n" + "Ã¼Å©¾Æ¿ô : "
				+ resdto.getBout() + "\n" + "¿ä±Ý : " + resdto.getHprice() + "\n" + "Åõ¼÷°´ ¸í¼ö : " + resdto.getBperson());
		textArea.setFont(new Font("Monospaced", Font.BOLD, 18));
		textArea_1.setBounds(349, 88, 331, 202);
		add(textArea_1);

		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea_2.setBackground(UIManager.getColor("TextArea.disabledBackground"));
		textArea_2.setFont(new Font("Monospaced", Font.BOLD, 20));
		textArea_2.setText(resdto.getBreq());
		textArea_2.setBounds(349, 336, 331, 110);
		add(textArea_2);

	}
}
