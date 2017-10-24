package bb_final;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Findid extends JPanel {
	JButton btn_fi_rlogin;

	/**
	 * Create the panel.
	 * @param main_frame 
	 */
	public Findid(Main_frame main_frame) {
		setBounds(new Rectangle(0, 0, 775, 559));
		setLayout(null);
		
		JLabel label = new JLabel("\uCC3E\uC740 \uC544\uC774\uB514");
		label.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 25));
		label.setBounds(302, 190, 174, 48);
		add(label);
		
		JLabel label_1 = new JLabel("\uCC3E\uC740 \uC544\uC774\uB514 \uBB50\uC2DC\uAE30\uBB50\uC2DC\uAE30");
		label_1.setBounds(249, 267, 270, 38);
		add(label_1);
		
		btn_fi_rlogin = new JButton("\uB85C\uADF8\uC778\uC73C\uB85C \uB3CC\uC544\uAC00\uAE30");
		btn_fi_rlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_frame.changePanel("login");
			}
		});
		btn_fi_rlogin.setForeground(Color.WHITE);
		btn_fi_rlogin.setBackground(new Color(35, 86, 149));
		btn_fi_rlogin.setBounds(249, 337, 262, 29);
		add(btn_fi_rlogin);

	}

}
