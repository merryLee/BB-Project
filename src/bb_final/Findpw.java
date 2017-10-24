package bb_final;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Findpw extends JPanel {
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	JButton btn_fp_rlogin;

	/**
	 * Create the panel.
	 * @param main_frame 
	 */
	public Findpw(Main_frame main_frame) {
		setBounds(new Rectangle(0, 0, 775, 559));
		setLayout(null);
		
		JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638 \uC7AC\uC124\uC815");
		label.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 25));
		label.setBounds(270, 161, 218, 48);
		add(label);
		
		JLabel label_1 = new JLabel("\uBCC0\uACBD\uD560 \uBE44\uBC00\uBC88\uD638");
		label_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label_1.setBounds(270, 219, 218, 15);
		add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(270, 244, 218, 21);
		add(passwordField);
		
		JLabel label_2 = new JLabel("\uBCC0\uACBD\uD560 \uBE44\uBC00\uBC88\uD638 \uC7AC\uC785\uB825");
		label_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label_2.setBounds(270, 286, 218, 15);
		add(label_2);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(270, 311, 218, 21);
		add(passwordField_1);
		
		btn_fp_rlogin = new JButton("\uB85C\uADF8\uC778\uC73C\uB85C \uB3CC\uC544\uAC00\uAE30");
		btn_fp_rlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_frame.changePanel("login");
			}
		});
		btn_fp_rlogin.setForeground(Color.WHITE);
		btn_fp_rlogin.setBackground(new Color(35, 86, 149));
		btn_fp_rlogin.setBounds(270, 366, 218, 29);
		add(btn_fp_rlogin);

	}

}
