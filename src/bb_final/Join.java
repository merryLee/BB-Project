package bb_final;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Join extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField_2;
	private JTextField textField_3;
	JButton btn_join_reg;

	/**
	 * Create the panel.
	 * @param main_frame 
	 */
	public Join(Main_frame main_frame) {
		setBounds(new Rectangle(0, 0, 775, 559));
		setLayout(null);
		
		JLabel label = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		label.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 25));
		label.setBounds(314, 10, 116, 48);
		add(label);
		
		JLabel label_1 = new JLabel("\uC544\uC774\uB514");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label_1.setBounds(302, 64, 177, 15);
		add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(302, 89, 177, 21);
		add(textField);
		
		JLabel label_2 = new JLabel("\uC774\uB984");
		label_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label_2.setBounds(302, 120, 177, 15);
		add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(302, 145, 177, 21);
		add(textField_1);
		
		JLabel label_3 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label_3.setBounds(302, 176, 177, 15);
		add(label_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(302, 201, 177, 21);
		add(passwordField);
		
		JLabel label_4 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		label_4.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label_4.setBounds(302, 232, 177, 15);
		add(label_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(302, 255, 71, 21);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(381, 255, 43, 21);
		add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(436, 255, 43, 21);
		add(comboBox_2);
		
		JLabel label_5 = new JLabel("\uC804\uD654\uBC88\uD638");
		label_5.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label_5.setBounds(302, 286, 177, 15);
		add(label_5);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(302, 311, 177, 21);
		add(textField_2);
		
		JLabel label_6 = new JLabel("\uBCF4\uC548\uC9C8\uBB38");
		label_6.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label_6.setBounds(302, 342, 177, 15);
		add(label_6);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(302, 364, 177, 21);
		add(comboBox_3);
		
		JLabel label_7 = new JLabel("\uBCF4\uC548\uB2F5\uBCC0");
		label_7.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label_7.setBounds(302, 393, 177, 15);
		add(label_7);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(302, 418, 177, 21);
		add(textField_3);
		
		JCheckBox checkBox = new JCheckBox("\uC774\uC6A9\uC57D\uAD00, \uAC1C\uC778\uC815\uBCF4 \uC218\uC9D1 \uBC0F \uC774\uC6A9\uC5D0 \uBAA8\uB450 \uB3D9\uC758\uD569\uB2C8\uB2E4.");
		checkBox.setBounds(256, 445, 343, 23);
		add(checkBox);
		
		btn_join_reg = new JButton("\uB4F1\uB85D");
		btn_join_reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_frame.changePanel("login");
				
			}
		});
		btn_join_reg.setForeground(Color.WHITE);
		btn_join_reg.setBackground(new Color(35, 86, 149));
		btn_join_reg.setBounds(302, 474, 177, 29);
		add(btn_join_reg);

	}
	public void register() {
		
	}
}
