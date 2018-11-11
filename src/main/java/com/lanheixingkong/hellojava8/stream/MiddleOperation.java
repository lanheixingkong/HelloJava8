package com.lanheixingkong.hellojava8.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.collect.Lists;

public class MiddleOperation {

	public static void main(String[] args) {
		List<String> numStrings = Lists.newArrayList("1", "15", "6", "10", "9",
				"11", "9", "13", "15");
		// 一下全是中间操作，再触发一个终端操作之前，都不会被执行
		Stream<Integer> stream = numStrings.stream().map(Integer::parseInt)
				.filter(num -> num % 2 == 1).distinct().sorted().limit(3);
		// 触发终端操作
		stream.collect(Collectors.toList());
	}
}
