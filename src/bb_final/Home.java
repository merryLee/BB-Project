package bb_final;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.kitri.main.SwingCalendar;

public class Home extends JPanel {
	JButton house1;
	JButton house2;
	JButton house3;
	JButton house4;
	JButton button;

	SwingCalendar sc = new SwingCalendar();

	public Home(Main_frame main_frame) {
		setBackground(Color.WHITE);
		setBounds(new Rectangle(0, 0, 775, 559));
		setLayout(null);

		ImageIcon mainImg = new ImageIcon(".\\img\\main\\blackBB.jpg");
		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(mainImg.getImage(), 0, 0, null);
				setOpaque(false);
				// super.paintComponent(g);
			}
		};

		JLabel mainText1 = new JLabel();
		JLabel mainText2 = new JLabel();
		JLabel mainText3 = new JLabel();

		JLabel labelS = new JLabel("SEARCH");
		JLabel labelS1 = new JLabel("\uC704\uCE58");
		JLabel labelS2 = new JLabel("\uCCB4\uD06C\uC778");
		JLabel labelS3 = new JLabel("\uCCB4\uD06C\uC544\uC6C3");
		JLabel labelS4 = new JLabel("\uCD5C\uB300\uC778\uC6D0");
		JTextField location = new JTextField();
		// JComboBox dateIn = new JComboBox();
		JTextField dateIn = new JTextField();

		JTextField dateOut = new JTextField();
		JComboBox<String> person = new JComboBox<String>();
		button = new JButton("Search");

		JLabel labelR = new JLabel("RECOMMENDATION");
		ImageIcon houseImg = new ImageIcon(".\\img\\main\\reco1.jpg");
		ImageIcon houseImg2 = new ImageIcon(".\\img\\main\\reco2.jpg");
		ImageIcon houseImg3 = new ImageIcon(".\\img\\main\\reco3.jpg");
		ImageIcon houseImg4 = new ImageIcon(".\\img\\main\\reco4.jpg");
		house1 = new JButton(houseImg);
		house1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main_frame.changePanel("houseinfo");
			}
		});
		house2 = new JButton(houseImg2);
		house2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_frame.changePanel("houseinfo");
			}
		});
		house3 = new JButton(houseImg3);
		house3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_frame.changePanel("houseinfo");
			}
		});
		house4 = new JButton(houseImg4);
		house4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_frame.changePanel("houseinfo");
			}
		});

		panel.setBounds(22, 30, 200, 200);
		add(panel);

		mainText1.setText("Best Bed\uB97C BB\uC5D0\uC11C!");
		mainText1.setForeground(new Color(0, 115, 170));
		mainText1.setFont(new Font("Dialog", Font.BOLD, 30));
		mainText1.setBounds(234, 108, 398, 46);
		add(mainText1);
		mainText2.setText("\uC548\uC804\uD558\uACE0 \uD569\uB9AC\uC801\uC778 \uC219\uC18C");
		mainText2.setForeground(new Color(50, 55, 60));
		mainText2.setFont(new Font("Dialog", Font.PLAIN, 26));
		mainText2.setBounds(234, 154, 398, 38);
		add(mainText2);
		mainText3.setText("\uD55C\uBC88\uC5D0 \uB9CC\uB098\uBCF4\uC138\uC694");
		mainText3.setForeground(new Color(50, 55, 60));
		mainText3.setFont(new Font("Dialog", Font.PLAIN, 26));
		mainText3.setBounds(234, 192, 398, 38);
		add(mainText3);

		labelS.setFont(new Font("Dialog", Font.PLAIN, 20));
		labelS.setBounds(22, 260, 200, 28);
		add(labelS);

		labelS1.setFont(new Font("굴림", Font.PLAIN, 13));
		labelS1.setBounds(22, 292, 57, 15);
		add(labelS1);
		labelS2.setFont(new Font("굴림", Font.PLAIN, 13));
		labelS2.setBounds(181, 292, 57, 15);
		add(labelS2);
		labelS3.setFont(new Font("굴림", Font.PLAIN, 13));
		labelS3.setBounds(340, 292, 97, 15);
		add(labelS3);
		labelS4.setFont(new Font("굴림", Font.PLAIN, 13));
		labelS4.setBounds(499, 292, 57, 15);
		add(labelS4);

		location.setBounds(22, 308, 140, 24);
		add(location);
		dateIn.setBounds(181, 307, 140, 24);
		dateIn.getCaret().setVisible(false);

		dateIn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				sc.setVisible(true);
				sc.extField = dateIn;
				sc.setTitle("체크인");

			}
		});

		dateOut.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				sc.setVisible(true);
				sc.extField = dateOut;
				sc.setTitle("체크아웃");

			}
		});

		add(dateIn);
		dateOut.setBounds(340, 307, 140, 24);
		dateOut.getCaret().setVisible(false);

		add(dateOut);
		person.setBounds(499, 307, 140, 24);
		person.addItem("성인 1명");
		person.addItem("성인 2명");
		person.addItem("성인 4명");
		person.addItem("성인 6명");
		person.addItem("성인 8명");
		person.addItem("성인 10명");
		person.addItem("10명 이상");
		add(person);
		button.setBackground(new Color(38, 84, 149));
		button.setForeground(Color.WHITE);
		button.setBounds(657, 308, 76, 24);
		add(button);

		labelR.setFont(new Font("Dialog", Font.PLAIN, 20));
		labelR.setBounds(22, 351, 200, 28);
		add(labelR);

		house1.setBounds(22, 379, 150, 150);
		add(house1);
		house2.setBounds(210, 379, 150, 150);
		add(house2);
		house3.setBounds(397, 379, 150, 150);
		add(house3);
		house4.setBounds(587, 379, 150, 150);
		add(house4);

	}

}