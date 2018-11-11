package com.lanheixingkong.hellojava8.stream;

import java.util.List;

import com.google.common.collect.Lists;

public class TerminalOperation {

	public static void main(String[] args) {
		List<String> str = Lists.newArrayList("hello", "world", "2018");
		str.stream().forEach(System.out::print);
	}
}
