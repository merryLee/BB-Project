package com.bb.admin.view;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;

public class Admin extends JPanel {

	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	
	ImageIcon iconHouse = new ImageIcon(".\\img\\iconRoom.jpg");
	ImageIcon iconBook = new ImageIcon(".\\img\\iconBook.jpg");
	
	HouseManagement houseManagement = new HouseManagement();
	BookManagement bookManagement = new BookManagement();

	/**
	 * Create the panel.
	 */
	public Admin() {
		setBounds(new Rectangle(0, 0, 753, 553));
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		tabbedPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		add(tabbedPane, BorderLayout.CENTER);
		houseManagement.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab(null, iconHouse, houseManagement);
		bookManagement.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab(null, iconBook, bookManagement);

	}

}
