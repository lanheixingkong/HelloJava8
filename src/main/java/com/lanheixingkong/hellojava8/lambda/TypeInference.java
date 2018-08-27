package com.lanheixingkong.hellojava8.lambda;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.ToIntBiFunction;

public class TypeInference {

	public static void main(String[] args) {
		Comparator<String> c1 = (String s1, String s2) -> s1.length() - s2.length(); // 目标类型是Comparator<String>
		ToIntBiFunction<String, String> c2 = (String s1, String s2) -> s1.length() - s2.length(); // 目标类型是ToIntBiFunction<String, String>
		BiFunction<String, String, Integer> c3 = (String s1, String s2) -> s1.length() - s2.length(); // 目标类型是BiFunction<String, String, Integer>

		Comparator<String> c4 = (String s1, String s2) -> s1.length() - s2.length(); // 没有类型推断
		Comparator<String> c5 = (s1, s2) -> s1.length() - s2.length(); // 有类型推断
		Predicate<String> c6 = s -> s.length() > 0;// 当只有一个参数时，参数两边的括号也可以省略
	
		
		
	}
	
	private void finalVariable1(){
		Button button  = new Button();
		final String name = getUserName();//匿名内部类中引用该变量必须为final
		button.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        System.out.println("Hello " + name);
		    }
		});
	}
	
	private void finalVariable2(){
		Button button  = new Button();
		String name = getUserName();//Lambda表达式中，不用强制声明，但其事实上也必须是final
		button.addActionListener(e -> System.out.println("Hello " + name));
//		name = "new name";// 放开该行，将会编译报错
	}
	
	private String getUserName(){
		return "lanheixingkong";
	}
}
