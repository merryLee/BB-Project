package bb_final;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Review2 extends JPanel {

	
	
	private JLabel lbl1 = new JLabel("\uCD1D\uC810");
	private JLabel lbl2 = new JLabel("\uC704\uCE58");
	private JLabel lbl3 = new JLabel("\uCCAD\uACB0\uB3C4");
	private JLabel lbl4 = new JLabel("\uC758\uC0AC\uC18C\uD1B5");
	
	private ButtonGroup rbg1 = new ButtonGroup();
	private ButtonGroup rbg2 = new ButtonGroup();
	private ButtonGroup rbg3 = new ButtonGroup();
	private ButtonGroup rbg4 = new ButtonGroup();
	private JRadioButton rb1A = new JRadioButton("\uB9E4\uC6B0\uBD88\uB9CC\uC871");
	private JRadioButton rb1B = new JRadioButton("\uBD88\uB9CC\uC871");
	private JRadioButton rb1C = new JRadioButton("\uBCF4\uD1B5");
	private JRadioButton rb1D = new JRadioButton("\uB9CC\uC871");
	private JRadioButton rb1E = new JRadioButton("\uB9E4\uC6B0\uB9CC\uC871");
	private JRadioButton rb2A = new JRadioButton("\uB9E4\uC6B0\uBD88\uB9CC\uC871");
	private JRadioButton rb2B = new JRadioButton("\uBD88\uB9CC\uC871");
	private JRadioButton rb2C = new JRadioButton("\uBCF4\uD1B5");
	private JRadioButton rb2D = new JRadioButton("\uB9CC\uC871");
	private JRadioButton rb2E = new JRadioButton("\uB9E4\uC6B0\uB9CC\uC871");
	private JRadioButton rb3A = new JRadioButton("\uB9E4\uC6B0\uBD88\uB9CC\uC871");
	private JRadioButton rb3B = new JRadioButton("\uBD88\uB9CC\uC871");
	private JRadioButton rb3C = new JRadioButton("\uBCF4\uD1B5");
	private JRadioButton rb3D = new JRadioButton("\uB9CC\uC871");
	private JRadioButton rb3E = new JRadioButton("\uB9E4\uC6B0\uB9CC\uC871");
	private JRadioButton rb4A = new JRadioButton("\uB9E4\uC6B0\uBD88\uB9CC\uC871");
	private JRadioButton rb4B = new JRadioButton("\uBD88\uB9CC\uC871");
	private JRadioButton rb4C = new JRadioButton("\uBCF4\uD1B5");
	private JRadioButton rb4D = new JRadioButton("\uB9CC\uC871");
	private JRadioButton rb4E = new JRadioButton("\uB9E4\uC6B0\uB9CC\uC871");
	
	private JButton submit;

	public Review2(Main_frame main_frame) {
		
		setBounds(new Rectangle(0, 0, 775, 559));
		setLayout(null);

		JLabel title = new JLabel("평점 및 후기 작성2");
		title.setFont(new Font("굴림", Font.BOLD, 30));
		title.setBounds(271, 50, 260, 45);
		add(title);

		Font f = new Font("굴림", Font.PLAIN, 14);


		rb1A.setFont(f);
		rb1A.setBounds(175, 120, 100, 30);
		add(rb1A);
		rb1B.setFont(f);
		rb1B.setBounds(280, 120, 100, 30);
		add(rb1B);
		rb1C.setFont(f);
		rb1C.setBounds(385, 120, 100, 30);
		add(rb1C);
		rb1D.setFont(f);
		rb1D.setBounds(490, 120, 100, 30);
		add(rb1D);
		rb1E.setFont(f);
		rb1E.setBounds(595, 120, 100, 30);
		add(rb1E);

		
		rbg1.add(rb1A);
		rbg1.add(rb1B);
		rbg1.add(rb1C);
		rbg1.add(rb1D);
		rbg1.add(rb1E);


		
		
		rb2A.setFont(f);
		rb2A.setBounds(175, 165, 100, 30);
		add(rb2A);
		rb2B.setFont(f);
		rb2B.setBounds(280, 165, 100, 30);
		add(rb2B);
		rb2C.setFont(f);
		rb2C.setBounds(385, 165, 100, 30);
		add(rb2C);
		rb2D.setFont(f);
		rb2D.setBounds(490, 165, 100, 30);
		add(rb2D);
		rb2E.setFont(f);
		rb2E.setBounds(595, 165, 100, 30);
		add(rb2E);

		rbg2.add(rb2A);
		rbg2.add(rb2B);
		rbg2.add(rb2C);
		rbg2.add(rb2D);
		rbg2.add(rb2E);


		rb3A.setFont(f);
		rb3A.setBounds(175, 210, 100, 30);
		add(rb3A);
		rb3B.setFont(f);
		rb3B.setBounds(280, 210, 100, 30);
		add(rb3B);
		rb3C.setFont(f);
		rb3C.setBounds(385, 210, 100, 30);
		add(rb3C);
		rb3D.setFont(f);
		rb3D.setBounds(490, 210, 100, 30);
		add(rb3D);
		rb3E.setFont(f);
		rb3E.setBounds(595, 210, 100, 30);
		add(rb3E);

		rbg3.add(rb3A);
		rbg3.add(rb3B);
		rbg3.add(rb3C);
		rbg3.add(rb3D);
		rbg3.add(rb3E);

		rb4A.setFont(f);
		rb4A.setBounds(175, 255, 100, 30);
		add(rb4A);
		rb4B.setFont(f);
		rb4B.setBounds(280, 255, 100, 30);
		add(rb4B);
		rb4C.setFont(f);
		rb4C.setBounds(385, 255, 100, 30);
		add(rb4C);
		rb4D.setFont(f);
		rb4D.setBounds(490, 255, 100, 30);
		add(rb4D);
		rb4E.setFont(f);
		rb4E.setBounds(595, 255, 100, 30);
		add(rb4E);

		rbg4.add(rb4A);
		rbg4.add(rb4B);
		rbg4.add(rb4C);
		rbg4.add(rb4D);
		rbg4.add(rb4E);
		
		
		System.out.println(rbg1.getElements().toString());

		
		
		
		f = new Font("굴림", Font.BOLD, 14);

		lbl1.setFont(f);
		lbl1.setBounds(100, 120, 60, 30);
		add(lbl1);
		lbl2.setFont(f);
		lbl2.setBounds(100, 165, 60, 30);
		add(lbl2);
		lbl3.setFont(f);
		lbl3.setBounds(100, 210, 60, 30);
		add(lbl3);
		lbl4.setFont(f);
		lbl4.setBounds(100, 255, 60, 30);
		add(lbl4);

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

		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main_frame.changePanel("mypagemain");
			}
		});

	}
}