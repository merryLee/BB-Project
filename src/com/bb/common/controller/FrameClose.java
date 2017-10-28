package com.bb.common.controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.bb.common.SwingCalendar;

public class FrameClose extends WindowAdapter {

	SwingCalendar sc;

	public FrameClose(SwingCalendar sc) {
		this.sc = sc;
	}

	@Override
	public void windowClosing(WindowEvent e) {
		sc.setVisible(false);
	}
}
