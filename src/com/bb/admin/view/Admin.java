package com.bb.admin.view;

import java.awt.BorderLayout;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class Admin extends JPanel {

	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	
	ImageIcon iconHouse = new ImageIcon(".\\img\\iconRoom.jpg");
	ImageIcon iconBook = new ImageIcon(".\\img\\iconBooking.jpg");
	ImageIcon iconUser = new ImageIcon(".\\img\\iconUser.jpg");
	ImageIcon iconAnalysis = new ImageIcon(".\\img\\iconAnalysis.jpg");
	
	
	HouseManagement houseManagement = new HouseManagement();
	BookManagement bookManagement = new BookManagement();
	UserManagement userManagement = new UserManagement();
	AnalysisManagement analysisManagement = new AnalysisManagement(); 

	/**
	 * Create the panel.
	 */
//	public Admin(Frame frame) { 
	public Admin() { 
		setBounds(new Rectangle(0, 0, 753, 553));
		setLayout(new BorderLayout(0, 0));
		tabbedPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		add(tabbedPane, BorderLayout.CENTER);
		tabbedPane.addTab(null, iconHouse, houseManagement);
		tabbedPane.addTab(null, iconBook, bookManagement);
		tabbedPane.addTab(null, iconUser, userManagement);
		tabbedPane.addTab(null, iconAnalysis, analysisManagement); 

	}

}
