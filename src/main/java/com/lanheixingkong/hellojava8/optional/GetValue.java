package com.lanheixingkong.hellojava8.optional;

import java.util.Optional;

import com.lanheixingkong.hellojava8.optional.used.Assistant;
import com.lanheixingkong.hellojava8.optional.used.SoccerTeam;

public class GetValue {

	public String getTeamCoachAssistantName2(SoccerTeam team) {
		// 使用map方法
		return team.getCoach().getAssistant().map(Assistant::getName)
				.orElse("Unknown");
	}

	public static void main(String[] args) {
		Optional<String> empty = Optional.empty();
		Optional<String> strOpt = Optional.of("hello");

		// 使用get方法
		// System.out.println(empty.get());// error! NoSuchElementException!!
		System.out.println(strOpt.get());// hello

		// 使用orElse(T other)方法
		System.out.println(empty.orElse("Default String"));// Default String
		System.out.println(strOpt.orElse("Default String"));// hello

		// 使用orElseGet(Supplier<? extends T> other)方法
		System.out.println(empty.orElseGet(() -> "Default String"));// Default
																	// String
		System.out.println(strOpt.orElseGet(() -> "Default String"));// hello

		// 使用orElseThrow(Supplier<? extends T> other)方法
//		System.out.println(empty
//				.orElseThrow(() -> new IllegalArgumentException("字符串不能为空")));// error! IllegalArgumentException!!
		System.out.println(strOpt.orElseThrow(() -> new IllegalArgumentException("字符串不能为空")));// hello
		
		// 使用ifPresent(Consumer<? super T>)方法
		empty.ifPresent(System.out::println);// 没有任何输出
		strOpt.ifPresent(System.out::println);// hello
	}
}
