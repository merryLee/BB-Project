package bb_final;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Findpw_main extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	JButton btn_fpm;

	/**
	 * Create the panel.
	 * @param main_frame 
	 */
	public Findpw_main(Main_frame main_frame) {
		setBounds(new Rectangle(0, 0, 775, 559));
		setLayout(null);
		
		JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		label.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 25));
		label.setBounds(291, 161, 177, 48);
		add(label);
		
		JLabel label_1 = new JLabel("\uC544\uC774\uB514");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label_1.setBounds(242, 223, 226, 15);
		add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(242, 248, 262, 29);
		add(textField);
		
		JLabel label_2 = new JLabel("\uBCF4\uC548\uC9C8\uBB38");
		label_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label_2.setBounds(242, 287, 216, 15);
		add(label_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(242, 309, 262, 21);
		add(comboBox);
		
		JLabel label_3 = new JLabel("\uBCF4\uC548\uB2F5\uBCC0");
		label_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label_3.setBounds(242, 338, 262, 15);
		add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(242, 363, 262, 21);
		add(textField_1);
		
		btn_fpm = new JButton("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		btn_fpm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_frame.changePanel("findpw");
			}
		});
		btn_fpm.setForeground(Color.WHITE);
		btn_fpm.setBackground(new Color(35, 86, 149));
		btn_fpm.setBounds(291, 410, 177, 29);
		add(btn_fpm);

	}
}
