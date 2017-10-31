package com.bb.admin.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.bb.admin.model.AnalysisDAO;
import com.bb.admin.view.AnalysisManagement;

public class AnalysisCTRL implements /*ItemListener,*/ ActionListener {

	public AnalysisManagement analysisManagement;
	public AnalysisDAO analysisDAO;
	
	public AnalysisCTRL(AnalysisManagement analysisManagement) {
		this.analysisManagement = analysisManagement;
		analysisDAO = new AnalysisDAO(analysisManagement);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	

//	@Override
//	public void itemStateChanged(ItemEvent e) {
//		
//		Object obj = e.getSource();
//		
//		if (obj == analysisManagement.rbtnYear) {
//			analysisManagement.strTerm = makeStrYear(analysisManagement.date[0]);
//			analysisManagement.cbTermOpt1.setVisible(false);
//			analysisManagement.cbTermOpt2.setVisible(false);
//			
//		}
//		else if (obj == analysisManagement.rbtnMonth) {
//			analysisManagement.strTerm = makeStrMonth();
//			analysisManagement.strTermOpt1 = makeStrYear(analysisManagement.date[0]);
//			analysisManagement.cbTermOpt1.setVisible(true);
//			analysisManagement.cbTermOpt2.setVisible(true);
//			
//		}
//		else if (obj == analysisManagement.rbtnDay) {
//			analysisManagement.strTerm = makeStrDay();
//			analysisManagement.strTermOpt1 = makeStrMonth();
//			analysisManagement.strTermOpt2 = makeStrYear(analysisManagement.date[0]);
//			analysisManagement.cbTermOpt1.setVisible(true);
//			analysisManagement.cbTermOpt2.setVisible(true);
//			
//		}
//		
//	}
	
//	public String[] makeStrYear(int yyyy) {
//		int n = (yyyy - 2017) >= 0 ? (yyyy - 2017 + 1) : 0;
//		String[] strYear = new String[n];
//		
//		for (int i = 0; i < n; ++i)
//			strYear[i] = (2017 + i) + "년";
//		
//		return strYear;
//	}
//	
//	public String[] makeStrMonth() {
//		String[] strMonth = {"-", "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"};
//		
//		return strMonth;
//	}
//
//	public String[] makeStrDay() {
//		int n = 0;
//		int[] month31 = {1, 3, 5, 7, 8, 10, 12};
//		int[] month30 = {4, 6, 9, 11};
//		int[] month28 = {2};
//		
////		for (int i = 0; i < month31.length; ++i)
////			time
//		String[] strDay = new String[1];
//		
//		return strDay;
//	}


}
