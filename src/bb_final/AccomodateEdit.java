package bb_final;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AccomodateEdit extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	 JButton edit_btn;

	/**
	 * Create the panel.
	 */
	public AccomodateEdit() {
		setBackground(new Color(255, 255, 255));
		setBounds(new Rectangle(0, 0, 775, 700));
		setLayout(null);
		
		JLabel label = new JLabel("\uC219\uC18C \uC774\uB984");
		label.setBackground(Color.WHITE);
		label.setBounds(137, 87, 57, 15);
		add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		textField.setBounds(137, 111, 226, 21);
		add(textField);
		
		JLabel label_1 = new JLabel("\uB300\uD45C \uC5F0\uB77D\uCC98");
		label_1.setBounds(397, 87, 82, 15);
		add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		textField_1.setBounds(397, 111, 216, 21);
		add(textField_1);
		
		JLabel label_2 = new JLabel("\uC219\uC18C \uC8FC\uC18C");
		label_2.setBounds(137, 142, 57, 15);
		add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		textField_2.setBounds(137, 167, 226, 21);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		textField_3.setBounds(397, 167, 216, 21);
		add(textField_3);
		
		JLabel label_3 = new JLabel("\uC0C1\uC138\uC8FC\uC18C");
		label_3.setBounds(395, 142, 57, 15);
		add(label_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		textField_4.setBounds(137, 223, 226, 21);
		add(textField_4);
		
		JLabel label_4 = new JLabel("\uC219\uC18C \uAC00\uACA9");
		label_4.setBounds(137, 198, 57, 15);
		add(label_4);
		
		JLabel label_5 = new JLabel("\uCD5C\uB300 \uC778\uC6D0");
		label_5.setBounds(397, 198, 57, 15);
		add(label_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.WHITE);
		comboBox.setBorder(null);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(397, 223, 216, 21);
		add(comboBox);
		
		JLabel label_6 = new JLabel("\uD3B8\uC758 \uC2DC\uC124");
		label_6.setBounds(137, 254, 57, 15);
		add(label_6);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(137, 276, 474, 87);
		add(panel);
		
		JCheckBox checkBox = new JCheckBox("\uC138\uD0C1\uAE30");
		checkBox.setBackground(Color.WHITE);
		checkBox.setBounds(8, 6, 93, 23);
		panel.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("\uC5D0\uC5B4\uCEE8");
		checkBox_1.setBackground(Color.WHITE);
		checkBox_1.setBounds(8, 31, 93, 23);
		panel.add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("\uD5E4\uC5B4\uB4DC\uB77C\uC774\uC5B4");
		checkBox_2.setBackground(Color.WHITE);
		checkBox_2.setBounds(8, 56, 104, 23);
		panel.add(checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox("TV");
		checkBox_3.setBackground(Color.WHITE);
		checkBox_3.setBounds(116, 6, 107, 23);
		panel.add(checkBox_3);
		
		JCheckBox checkBox_4 = new JCheckBox("\uC0F4\uD478");
		checkBox_4.setBackground(Color.WHITE);
		checkBox_4.setBounds(116, 31, 107, 23);
		panel.add(checkBox_4);
		
		JCheckBox checkBox_5 = new JCheckBox("\uBD80\uC5CC");
		checkBox_5.setBackground(Color.WHITE);
		checkBox_5.setBounds(116, 56, 107, 23);
		panel.add(checkBox_5);
		
		JCheckBox checkBox_6 = new JCheckBox("\uC778\uD130\uB137");
		checkBox_6.setBackground(Color.WHITE);
		checkBox_6.setBounds(232, 6, 115, 23);
		panel.add(checkBox_6);
		
		JCheckBox checkBox_7 = new JCheckBox("\uC544\uCE68\uC2DD\uC0AC");
		checkBox_7.setBackground(Color.WHITE);
		checkBox_7.setBounds(232, 31, 115, 23);
		panel.add(checkBox_7);
		
		JCheckBox checkBox_8 = new JCheckBox("\uB09C\uBC29");
		checkBox_8.setBackground(Color.WHITE);
		checkBox_8.setBounds(232, 56, 115, 23);
		panel.add(checkBox_8);
		
		JCheckBox checkBox_9 = new JCheckBox("\uC218\uAC74");
		checkBox_9.setBackground(Color.WHITE);
		checkBox_9.setBounds(357, 6, 115, 23);
		panel.add(checkBox_9);
		
		JCheckBox checkBox_10 = new JCheckBox("\uBE44\uB204");
		checkBox_10.setBackground(Color.WHITE);
		checkBox_10.setBounds(357, 31, 115, 23);
		panel.add(checkBox_10);
		
		JCheckBox checkBox_11 = new JCheckBox("\uD654\uC7A5\uC9C0");
		checkBox_11.setBackground(Color.WHITE);
		checkBox_11.setBounds(357, 56, 115, 23);
		panel.add(checkBox_11);
		
		JLabel label_7 = new JLabel("\uC219\uC18C \uC0AC\uC9C4");
		label_7.setBounds(137, 377, 57, 15);
		add(label_7);
		
		JLabel label_8 = new JLabel("New label");
		label_8.setBackground(new Color(102, 205, 170));
		label_8.setBounds(137, 402, 99, 80);
		add(label_8);
		
		JButton edit_file_btn1 = new JButton("\uD30C\uC77C\uC120\uD0DD");
		edit_file_btn1.setForeground(Color.WHITE);
		edit_file_btn1.setBackground(new Color(35, 86, 149));
		edit_file_btn1.setBounds(516, 402, 97, 23);
		add(edit_file_btn1);
		
		JButton edit_file_btn2 = new JButton("\uD30C\uC77C\uC120\uD0DD");
		edit_file_btn2.setForeground(Color.WHITE);
		edit_file_btn2.setBackground(new Color(35, 86, 149));
		edit_file_btn2.setBounds(516, 431, 97, 23);
		add(edit_file_btn2);
		
		JButton edit_file_btn3 = new JButton("\uD30C\uC77C\uC120\uD0DD");
		edit_file_btn3.setForeground(Color.WHITE);
		edit_file_btn3.setBackground(new Color(35, 86, 149));
		edit_file_btn3.setBounds(516, 460, 97, 23);
		add(edit_file_btn3);
		
		JLabel label_9 = new JLabel("\uC18C\uAC1C\uAE00(1000\uC790 \uC774\uB0B4)");
		label_9.setBounds(137, 497, 121, 21);
		add(label_9);
		
		JTextArea textArea = new JTextArea();
		textArea.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(137, 523, 474, 128);
		add(textArea);
		
		edit_btn = new JButton("\uB4F1\uB85D \uBC0F \uC218\uC815");
		edit_btn.setForeground(Color.WHITE);
		edit_btn.setBackground(new Color(35, 86, 149));
		edit_btn.setBounds(282, 674, 197, 23);
		add(edit_btn);
		
		JLabel label_10 = new JLabel("\uC219\uC18C \uD3B8\uC9D1");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setFont(new Font("±¼¸²", Font.BOLD, 25));
		label_10.setBounds(303, 10, 121, 54);
		add(label_10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		lblNewLabel.setBounds(248, 403, 267, 22);
		add(lblNewLabel);
		
		JLabel label_11 = new JLabel("New label");
		label_11.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		label_11.setBounds(248, 431, 267, 22);
		add(label_11);
		
		JLabel label_12 = new JLabel("New label");
		label_12.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		label_12.setBounds(248, 460, 267, 22);
		add(label_12);

	}

}