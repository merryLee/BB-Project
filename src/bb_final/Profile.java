package bb_final;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;

public class Profile extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField_2;
	private JTextField textField_3;
	JButton btn_reg;

	/**
	 * Create the panel.
	 */
	public Profile() {
		setBounds(new Rectangle(0, 0, 775, 559));
		setLayout(null);
		
		JLabel label = new JLabel("\uD504\uB85C\uD544 \uC218\uC815");
		label.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 25));
		label.setBounds(290, 31, 177, 48);
		add(label);
		
		JLabel label_1 = new JLabel("\uC544\uC774\uB514");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label_1.setBounds(290, 85, 177, 15);
		add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(290, 110, 177, 21);
		add(textField);
		
		JLabel label_2 = new JLabel("\uC774\uB984");
		label_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label_2.setBounds(290, 141, 177, 15);
		add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(290, 166, 177, 21);
		add(textField_1);
		
		JLabel label_3 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label_3.setBounds(290, 197, 177, 15);
		add(label_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(290, 222, 177, 21);
		add(passwordField);
		
		JLabel label_4 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		label_4.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label_4.setBounds(290, 253, 177, 15);
		add(label_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(290, 276, 71, 21);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(369, 276, 43, 21);
		add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(424, 276, 43, 21);
		add(comboBox_2);
		
		JLabel label_5 = new JLabel("\uC804\uD654\uBC88\uD638");
		label_5.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label_5.setBounds(290, 307, 177, 15);
		add(label_5);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(290, 332, 177, 21);
		add(textField_2);
		
		JLabel label_6 = new JLabel("\uBCF4\uC548\uC9C8\uBB38");
		label_6.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label_6.setBounds(290, 363, 177, 15);
		add(label_6);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(290, 385, 177, 21);
		add(comboBox_3);
		
		JLabel label_7 = new JLabel("\uBCF4\uC548\uB2F5\uBCC0");
		label_7.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label_7.setBounds(290, 414, 177, 15);
		add(label_7);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(290, 439, 177, 21);
		add(textField_3);
		
		btn_reg = new JButton("\uB4F1\uB85D");
		btn_reg.setForeground(Color.WHITE);
		btn_reg.setBackground(new Color(35, 86, 149));
		btn_reg.setBounds(290, 483, 177, 29);
		add(btn_reg);

	}
}
