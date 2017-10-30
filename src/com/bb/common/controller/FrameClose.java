package com.bb.common.controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class FrameClose extends WindowAdapter {

	JFrame jf;

	public FrameClose(JFrame jf) {
		this.jf = jf;
	}

	@Override
	public void windowClosing(WindowEvent e) {
		jf.setVisible(false);
	}
}
