package com.bb.review.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;

import com.bb.review.model.ReviewDao;
import com.bb.review.model.ReviewDto;
import com.bb.review.view.Review;

public class ReviewLogic implements ActionListener {

	Review review;

	public ReviewLogic(Review review) {
		this.review = review;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		ReviewDao reviewDao = new ReviewDao();
		ReviewDto reviewDto = new ReviewDto();
//		String key = e.getActionCommand();

		Enumeration<AbstractButton> elements = review.rbg1.getElements();
		while (elements.hasMoreElements()) {
			AbstractButton button = (AbstractButton) elements.nextElement();
			if (button.isSelected()) {
				System.out.println(button.getText() + " " + changeGrade(button.getText()));
				reviewDto.setRscore1(changeGrade(button.getText()));
			}
		}

		elements = review.rbg2.getElements();
		while (elements.hasMoreElements()) {
			AbstractButton button = (AbstractButton) elements.nextElement();
			if (button.isSelected()) {
				System.out.println(button.getText() + " " + changeGrade(button.getText()));
				reviewDto.setRscore2(changeGrade(button.getText()));
			}
		}

		elements = review.rbg3.getElements();
		while (elements.hasMoreElements()) {
			AbstractButton button = (AbstractButton) elements.nextElement();
			if (button.isSelected()) {
				System.out.println(button.getText() + " " + changeGrade(button.getText()));
				reviewDto.setRscore3(changeGrade(button.getText()));
			}
		}

		elements = review.rbg4.getElements();
		while (elements.hasMoreElements()) {
			AbstractButton button = (AbstractButton) elements.nextElement();
			if (button.isSelected()) {
				System.out.println(button.getText() + " " + changeGrade(button.getText()));
				reviewDto.setRscore4(changeGrade(button.getText()));
			}
		}
		
		System.out.println(review.reviewSpec.getText());
		reviewDto.setRspec(review.reviewSpec.getText());

		int cnt = reviewDao.insertReview(reviewDto);
		if (cnt != 0) {
			System.out.println("�����ϼ���");
			review.main_frame.changePanel("mypagemain");
		} else {
			System.out.println("�����Ͻ���TT");
		}
		
		

	}

	private int changeGrade(String text) { // �ؽ�Ʈ�� �޾ƿ� ������ư���� ����ȭ
		int igrade = 0;

		if ("�ſ�Ҹ���".equals(text))
			igrade = 1;
		else if ("�Ҹ���".equals(text))
			igrade = 2;
		else if ("����".equals(text))
			igrade = 3;
		else if ("����".equals(text))
			igrade = 4;
		else if ("�ſ츸��".equals(text))
			igrade = 5;

		return igrade;
	}

}
