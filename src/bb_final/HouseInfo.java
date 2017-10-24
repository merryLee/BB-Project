package bb_final;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;

public class HouseInfo extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	JButton info_btn_resev;

	/**
	 * Create the panel.
	 * @param main_frame 
	 */
	public HouseInfo(Main_frame main_frame) {
		setBackground(new Color(255, 255, 255));
		setBounds(new Rectangle(0, 0, 775, 700));
		setLayout(null);
		
		JLabel info_tiltle_L = new JLabel("HANGBAE'S RULE HOUSE");
		info_tiltle_L.setBounds(85, 10, 342, 43);
		info_tiltle_L.setFont(new Font("±¼¸²", Font.BOLD, 25));
		add(info_tiltle_L);
		
		JLabel info_addr_L = new JLabel("\uACBD\uAE30\uB3C4 \uC6A9\uC778\uC2DC \uCC98\uC778\uAD6C \uC5ED\uBD81\uB3D9 202-349435234");
		info_addr_L.setBounds(85, 63, 616, 52);
		info_addr_L.setFont(new Font("±¼¸²", Font.BOLD, 14));
		add(info_addr_L);
		
		JLabel info_photo = new JLabel((Icon) null);
		info_photo.setBounds(85, 125, 626, 176);
		info_photo.setText("\uC0AC\uC9C4");
		add(info_photo);
		
		JLabel label_4 = new JLabel("\uCCB4\uD06C\uC778");
		label_4.setBounds(86, 429, 57, 15);
		add(label_4);
		
		textField = new JTextField();
		textField.setBounds(86, 454, 143, 29);
		textField.setColumns(10);
		textField.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		textField.setBackground(Color.WHITE);
		add(textField);
		
		JLabel label_5 = new JLabel("\uCCB4\uD06C\uC544\uC6C3");
		label_5.setBounds(244, 429, 57, 15);
		add(label_5);
		
		textField_1 = new JTextField();
		textField_1.setBounds(246, 454, 143, 29);
		textField_1.setColumns(10);
		textField_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		add(textField_1);
		
		JLabel label_6 = new JLabel("\uC778\uC6D0");
		label_6.setBounds(419, 429, 57, 15);
		add(label_6);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(420, 454, 143, 29);
		comboBox.setBackground(Color.WHITE);
		add(comboBox);
		
		info_btn_resev = new JButton("\uC608\uC57D");
		info_btn_resev.setBounds(602, 452, 111, 31);
		info_btn_resev.setForeground(Color.WHITE);
		info_btn_resev.setBackground(new Color(35, 86, 149));
		add(info_btn_resev);
		
		JLabel label_7 = new JLabel("\uD3B8\uC758 \uC2DC\uC124");
		label_7.setBounds(85, 503, 57, 15);
		add(label_7);
		
		JPanel hotP = new JPanel();
		hotP.setBounds(418, 20, 77, 24);
		hotP.setBackground(new Color(255, 165, 0));
		add(hotP);
		
		JLabel hotL = new JLabel("Hot");
		hotL.setForeground(Color.WHITE);
		hotL.setFont(new Font("±¼¸²", Font.BOLD, 12));
		hotP.add(hotL);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(85, 528, 627, 75);
		panel_1.setLayout(null);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		panel_1.setBackground(Color.WHITE);
		add(panel_1);
		
		JLabel lblImg = new JLabel((Icon) null);
		lblImg.setText("img");
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblImg.setForeground(Color.GRAY);
		lblImg.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblImg.setBounds(6, 4, 46, 27);
		panel_1.add(lblImg);
		
		JLabel label_10 = new JLabel("\uAC74\uC870\uAE30");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setForeground(Color.GRAY);
		label_10.setFont(new Font("±¼¸²", Font.BOLD, 12));
		label_10.setBounds(56, 7, 57, 21);
		panel_1.add(label_10);
		
		JLabel label_11 = new JLabel((Icon) null);
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setForeground(Color.GRAY);
		label_11.setFont(new Font("±¼¸²", Font.BOLD, 12));
		label_11.setBounds(232, 4, 46, 27);
		panel_1.add(label_11);
		
		JLabel label_12 = new JLabel("\uAC74\uC870\uAE30");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setForeground(Color.GRAY);
		label_12.setFont(new Font("±¼¸²", Font.BOLD, 12));
		label_12.setBounds(282, 7, 57, 21);
		panel_1.add(label_12);
		
		JLabel label_13 = new JLabel((Icon) null);
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setForeground(Color.GRAY);
		label_13.setFont(new Font("±¼¸²", Font.BOLD, 12));
		label_13.setBounds(427, 4, 46, 27);
		panel_1.add(label_13);
		
		JLabel label_14 = new JLabel("\uAC74\uC870\uAE30");
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setForeground(Color.GRAY);
		label_14.setFont(new Font("±¼¸²", Font.BOLD, 12));
		label_14.setBounds(477, 7, 57, 21);
		panel_1.add(label_14);
		
		JLabel label_15 = new JLabel((Icon) null);
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setForeground(Color.GRAY);
		label_15.setFont(new Font("±¼¸²", Font.BOLD, 12));
		label_15.setBounds(6, 41, 46, 27);
		panel_1.add(label_15);
		
		JLabel label_16 = new JLabel("\uAC74\uC870\uAE30");
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setForeground(Color.GRAY);
		label_16.setFont(new Font("±¼¸²", Font.BOLD, 12));
		label_16.setBounds(56, 44, 57, 21);
		panel_1.add(label_16);
		
		JLabel label_17 = new JLabel((Icon) null);
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setForeground(Color.GRAY);
		label_17.setFont(new Font("±¼¸²", Font.BOLD, 12));
		label_17.setBounds(232, 41, 46, 27);
		panel_1.add(label_17);
		
		JLabel label_18 = new JLabel("\uAC74\uC870\uAE30");
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setForeground(Color.GRAY);
		label_18.setFont(new Font("±¼¸²", Font.BOLD, 12));
		label_18.setBounds(282, 44, 57, 21);
		panel_1.add(label_18);
		
		JLabel label_19 = new JLabel((Icon) null);
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setForeground(Color.GRAY);
		label_19.setFont(new Font("±¼¸²", Font.BOLD, 12));
		label_19.setBounds(427, 41, 46, 27);
		panel_1.add(label_19);
		
		JLabel label_20 = new JLabel("\uAC74\uC870\uAE30");
		label_20.setHorizontalAlignment(SwingConstants.CENTER);
		label_20.setForeground(Color.GRAY);
		label_20.setFont(new Font("±¼¸²", Font.BOLD, 12));
		label_20.setBounds(477, 44, 57, 21);
		panel_1.add(label_20);
		
		JLabel label_21 = new JLabel("\uC219\uC18C \uAC00\uACA9");
		label_21.setBounds(274, 623, 92, 29);
		label_21.setFont(new Font("±¼¸²", Font.BOLD, 20));
		add(label_21);
		
		JLabel label_22 = new JLabel("$89000");
		label_22.setBounds(378, 613, 111, 43);
		label_22.setForeground(new Color(46, 139, 87));
		label_22.setFont(new Font("±¼¸²", Font.BOLD, 27));
		add(label_22);
		
		JLabel label_23 = new JLabel("\uD6C4\uAE30");
		label_23.setBounds(85, 683, 48, 26);
		label_23.setFont(new Font("±¼¸²", Font.BOLD, 20));
		add(label_23);
		
		JLabel label_24 = new JLabel("(vat \uD3EC\uD568)");
		label_24.setBounds(485, 629, 78, 20);
		label_24.setForeground(new Color(46, 139, 87));
		label_24.setFont(new Font("±¼¸²", Font.BOLD, 15));
		add(label_24);
		
		JLabel label_25 = new JLabel("180\uAC1C");
		label_25.setBounds(135, 685, 75, 23);
		label_25.setFont(new Font("±¼¸²", Font.BOLD, 20));
		add(label_25);
		
		JLabel label_26 = new JLabel("\uC704\uCE58");
		label_26.setBounds(378, 732, 43, 20);
		label_26.setFont(new Font("±¼¸²", Font.BOLD, 15));
		add(label_26);
		
		JLabel label_27 = new JLabel("\uCCAD\uACB0");
		label_27.setBounds(85, 773, 33, 19);
		label_27.setFont(new Font("±¼¸²", Font.BOLD, 15));
		add(label_27);
		
		JLabel label_28 = new JLabel("\uC758\uC0AC\uC18C\uD1B5");
		label_28.setBounds(378, 772, 65, 19);
		label_28.setFont(new Font("±¼¸²", Font.BOLD, 15));
		add(label_28);
		
		JLabel label_29 = new JLabel("\uCD1D\uC810");
		label_29.setBounds(85, 733, 33, 24);
		label_29.setFont(new Font("±¼¸²", Font.BOLD, 15));
		add(label_29);
		
		JButton info_btn_recomm = new JButton("\uCD94\uCC9C");
		info_btn_recomm.setBounds(648, 828, 65, 44);
		info_btn_recomm.setForeground(Color.BLACK);
		info_btn_recomm.setFont(new Font("±¼¸²", Font.BOLD, 15));
		info_btn_recomm.setBackground(Color.WHITE);
		add(info_btn_recomm);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("\uD6C4\uAE30\uB4E4");
		textArea.setBounds(87, 829, 561, 43);
		add(textArea);
		
		JLabel house_detail_L = new JLabel("New label");
		house_detail_L.setBounds(85, 304, 626, 104);
		add(house_detail_L);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		lblNewLabel.setBounds(134, 732, 231, 24);
		add(lblNewLabel);
		
		JLabel label = new JLabel("New label");
		label.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		label.setBounds(134, 769, 231, 24);
		add(label);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		label_1.setBounds(461, 731, 250, 24);
		add(label_1);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		label_2.setBounds(461, 767, 250, 24);
		add(label_2);

	}
}