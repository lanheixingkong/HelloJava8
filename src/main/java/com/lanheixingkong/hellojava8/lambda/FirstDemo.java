package com.lanheixingkong.hellojava8.lambda;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstDemo {

	public void setButtonListener() {

		Button button = new Button();
		// 使用匿名类
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("有人点击了这个按钮");
			}
		});

		// 使用Lambda表达式
		button.addActionListener(e -> System.out.println("有人点击了这个按钮"));
	}

}
