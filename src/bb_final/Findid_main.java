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

public class Findid_main extends JPanel {
	private JTextField textField;
	JButton btnfindidm;

	/**
	 * Create the panel.
	 * @param main_frame 
	 */
	public Findid_main(Main_frame main_frame) {
		setBounds(new Rectangle(0, 0, 775, 559));
		setLayout(null);
		
		JLabel label = new JLabel("\uC544\uC774\uB514 \uCC3E\uAE30");
		label.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 25));
		label.setBounds(315, 183, 165, 48);
		add(label);
		
		JLabel label_1 = new JLabel("\uC544\uC774\uB514");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label_1.setBounds(254, 241, 226, 15);
		add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(254, 266, 262, 29);
		add(textField);
		
		JLabel label_2 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		label_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label_2.setBounds(254, 305, 177, 15);
		add(label_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(254, 328, 122, 21);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(388, 328, 58, 21);
		add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(458, 328, 58, 21);
		add(comboBox_2);
		
		btnfindidm = new JButton("\uC544\uC774\uB514 \uCC3E\uAE30");
		btnfindidm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_frame.changePanel("findid");
			}
		});
		btnfindidm.setForeground(Color.WHITE);
		btnfindidm.setBackground(new Color(35, 86, 149));
		btnfindidm.setBounds(254, 389, 262, 29);
		add(btnfindidm);
		
	}
}
