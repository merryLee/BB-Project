package bb_final;

import javax.swing.JPanel;
import java.awt.Rectangle;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JPanel {
	JTextField loginid;
	JPasswordField loginpw;
	JButton btnfindid;
	JButton btnfindpw;
	JButton btnlogin;
	/**
	 * Create the panel.
	 * @param main_frame 
	 */
	public Login(Main_frame main_frame) {
		
		setBounds(new Rectangle(0, 0, 775, 559));
		setLayout(null);
		
		JLabel label = new JLabel("\uB85C\uADF8\uC778");
		label.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 25));
		label.setBounds(333, 154, 116, 48);
		add(label);
		
		JLabel label_1 = new JLabel("\uC544\uC774\uB514");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label_1.setBounds(256, 212, 226, 15);
		add(label_1);
		
		loginid = new JTextField();
		loginid.setColumns(10);
		loginid.setBounds(256, 237, 262, 29);
		add(loginid);
		
		JLabel label_2 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label_2.setBounds(256, 276, 226, 15);
		add(label_2);
		
		loginpw = new JPasswordField();
		loginpw.setBounds(256, 301, 262, 29);
		add(loginpw);
		
		btnfindid = new JButton("\uC544\uC774\uB514 \uCC3E\uAE30");
		btnfindid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_frame.changePanel("findid_main");
			}
		});
		btnfindid.setForeground(Color.WHITE);
		btnfindid.setBackground(new Color(35, 86, 149));
		btnfindid.setBounds(256, 340, 116, 29);
		add(btnfindid);
		
		btnfindpw = new JButton("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		btnfindpw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_frame.changePanel("findpw_main");
			}
		});
		btnfindpw.setForeground(Color.WHITE);
		btnfindpw.setBackground(new Color(35, 86, 149));
		btnfindpw.setBounds(384, 340, 134, 29);
		add(btnfindpw);
		
		btnlogin = new JButton("\uB85C\uADF8\uC778");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnlogin.setForeground(Color.WHITE);
		btnlogin.setBackground(new Color(35, 86, 149));
		btnlogin.setBounds(256, 379, 262, 29);
		add(btnlogin);

	}


}
