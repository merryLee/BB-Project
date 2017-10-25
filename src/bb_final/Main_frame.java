package bb_final;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bb.home.view.Home;
import com.bb.review.view.*;

public class Main_frame extends JFrame {

	private boolean session; // false�϶� ��α��λ���, true�϶� �α��λ���
	private int mno; // 0(��α��λ���), ȸ����ȣ(�α��λ���)

	private JPanel contentPane;
	MainHeader top;
	JPanel intentp;
	CardLayout cards = new CardLayout();
	Jdbc jdbc = new Jdbc();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_frame frame = new Main_frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main_frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		top = new MainHeader(this);
		top.setBounds(0, 0, 753, 41);
		contentPane.add(top);

		intentp = new JPanel();
		intentp.setBounds(0, 41, 753, 553);
		contentPane.add(intentp);
		intentp.setLayout(cards);
		intentp.add("home", new Home(this));
		intentp.add("review", new Review(this));
		intentp.add("houseinfo", new HouseInfo(this));
		intentp.add("mypage_registered_mng", new Mypage_registered_mng(this));
		intentp.add("mypagemain", new MypageMain(this));
		intentp.add("login", new Login(this));
		intentp.add("join", new Join(this));

	}

	public void changePanel(String panelname) {
		cards.show(intentp, panelname);
	}

	public boolean isSession() { // �α��λ��� ���� true! false!�� ��ȯ
		return session;
	}

	public void setSession(boolean session) {
		this.session = session;
		top.updateHeader();
	}

	public int getMno() { // ���� �α��εǾ��ִ� ȸ���� ��ȣ ��ȯ
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
		top.updateHeader();
	}
}