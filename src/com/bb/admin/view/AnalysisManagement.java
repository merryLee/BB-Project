package com.bb.admin.view;

import java.awt.Rectangle;
import java.awt.SystemColor;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.bb.admin.controller.AnalysisCTRL;

public class AnalysisManagement extends JPanel {

	public JComboBox cbClassification;
	
	public JRadioButton rbtnYear;
	public JRadioButton rbtnMonth;
	public JRadioButton rbtnDay;
	
	public int[] date = new int[3];
	
	public String[] strTerm;
	public String[] strTermOpt1;
	public String[] strTermOpt2;
	
	public JComboBox cbTermStart;
	public JComboBox cbTermEnd;
	public JComboBox cbTermOpt1;
	public JComboBox cbTermOpt2;
	
	public JButton btnSearch;
	
	public DefaultCategoryDataset dataset;
	public String data;
	
	public JFreeChart chart;
	public ChartPanel chartPanel;
	private JLabel lb;
	
	/**
	 * Create the panel.
	 */
	public AnalysisManagement() {
//		setBackground(SystemColor.desktop);
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setBounds(new Rectangle(0, 0, 753, 553));
		setLayout(null);
		
		AnalysisCTRL analysisCTRL = new AnalysisCTRL(this);
		
		JLabel lbClassification = new JLabel("\uBD84\uB958 :");
		lbClassification.setBounds(15, 18, 87, 15);
		add(lbClassification);
		
		String[] strClassification = {"총 예약 건수"};
		cbClassification = new JComboBox(strClassification);
		cbClassification.setBounds(60, 15, 266, 21);
		add(cbClassification);
		
		JLabel lbTerm1 = new JLabel("\uAE30\uAC04 : ");
		lbTerm1.setBounds(15, 47, 87, 15);
		add(lbTerm1);
		
//		JLabel lbTerm2 = new JLabel(" ~ ");
//		lbTerm2.setBounds(185, 47, 16, 15);
//		add(lbTerm2);
		
//		setDate();
//		strTerm = analysisCTRL.makeStrYear(date[0]);
//		strTermOpt1 = new String[1];
//		strTermOpt2 = new String[1];
		
		String[] temp = {"-", "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"};
		cbTermStart = new JComboBox(temp);
		cbTermStart.setSelectedIndex(10);
//		cbTermStart = new JComboBox(strTerm);
		cbTermStart.setBounds(60, 45, 118, 21);
		add(cbTermStart);
		
//		cbTermEnd = new JComboBox(strTerm);
//		cbTermEnd.setBounds(208, 45, 118, 21);
//		add(cbTermEnd);
		
//		cbTermOpt1 = new JComboBox(strTermOpt1);
//		cbTermOpt1.setBounds(331, 45, 96, 21);
//		cbTermOpt1.setVisible(false);
//		add(cbTermOpt1);
		
//		cbTermOpt2 = new JComboBox(strTermOpt2);
//		cbTermOpt2.setBounds(423, 45, 96, 21);
//		cbTermOpt2.setVisible(false);
//		add(cbTermOpt2);
		
//		rbtnYear = new JRadioButton("\uC5F0\uBCC4");
//		rbtnYear.addItemListener(analysisCTRL);
//		rbtnYear.setBounds(331, 15, 60, 23);
//		add(rbtnYear);
		
//		rbtnMonth = new JRadioButton("\uC6D4\uBCC4");
//		rbtnMonth.addItemListener(analysisCTRL);
//		rbtnMonth.setSelected(true);
//		rbtnMonth.setBounds(395, 15, 60, 23);
//		add(rbtnMonth);
		
//		rbtnDay = new JRadioButton("\uC77C\uBCC4");
//		rbtnDay.addItemListener(analysisCTRL);
//		rbtnDay.setBounds(459, 15, 60, 23);
//		add(rbtnDay);
		
//		ButtonGroup rbtnGroup = new ButtonGroup();
//		rbtnGroup.add(rbtnYear);
//		rbtnGroup.add(rbtnMonth);
//		rbtnGroup.add(rbtnDay);
		
		btnSearch = new JButton("\uAC80\uC0C9");
		btnSearch.addActionListener(analysisCTRL);
		btnSearch.setBounds(615, 15, 105, 59);
		add(btnSearch);
		
		dataset = new DefaultCategoryDataset();
		data = "";
        
//        String test1 = "1월";
//        String test2 = "2월";
//        String test3 = "3월";
//        String test4 = "4월";
//        String test5 = "5월";
//        String test6 = "6월";
//        String test7 = "7월";
//        String test8 = "8월";
//        String test9 = "9월";
//        String test10 = "10월";
//        String test11 = "11월";
//        String test12 = "12월";
        
        
//        int startIdx = cbTermStart.getSelectedIndex();
//        int endIdx = cbTermEnd.getSelectedIndex();
//        for (int i = startIdx; i <= endIdx; ++i) {
//        		dataset.addValue(analysisCTRL.analysisDAO., data, strTerm[i]);
//        }
        
//        int month = cbTermStart.getSelectedIndex();
        int month = 10;
        dataset.addValue(analysisCTRL.analysisDAO.getValue(month+3), data, temp[month-3]);
        dataset.addValue(analysisCTRL.analysisDAO.getValue(month+2), data, temp[month-2]);
        dataset.addValue(analysisCTRL.analysisDAO.getValue(month+1), data, temp[month-1]);
        dataset.addValue(analysisCTRL.analysisDAO.getValue(month), data, temp[month]);
        
        
        
//        dataset.addValue(15.0, data, test1);
//        dataset.addValue(39.0, data, test2);
//        dataset.addValue(22.0, data, test3);
//        dataset.addValue(45.0, data, test4);
//        dataset.addValue(15.0, data, test5);
//        dataset.addValue(39.0, data, test6);
//        dataset.addValue(22.0, data, test7);
//        dataset.addValue(45.0, data, test8);
//        dataset.addValue(15.0, data, test9);
//        dataset.addValue(39.0, data, test10);
//        dataset.addValue(22.0, data, test11);
//        dataset.addValue(45.0, data, test12);
		
        
		chart = ChartFactory.createBarChart(
        		"chart title",
        		"xaxis title",
        		"yaxis title",
        		dataset,
			PlotOrientation.VERTICAL,
        		true,
        		true,
        		false
        		);
		
		chartPanel = new ChartPanel(chart);
		chartPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		chartPanel.setBounds(15, 86, 700, 404);
		add(chartPanel);
	
		
		
	}
	
	public void setDate() {
		ZonedDateTime systemTime = ZonedDateTime.now();
		String time = systemTime.format(DateTimeFormatter.BASIC_ISO_DATE);
		
		int yyyy = Integer.parseInt(time.substring(0, 4));
		int mm = Integer.parseInt(time.substring(4, 6)); 	
		int dd = Integer.parseInt(time.substring(6, 8));
		
		date[0] = yyyy;
		date[1] = mm;
		date[2] = dd;
		
	}
}
