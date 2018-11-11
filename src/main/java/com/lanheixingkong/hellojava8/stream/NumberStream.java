package com.lanheixingkong.hellojava8.stream;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumberStream {

	public static void main(String[] args) {
		Stream<Integer> stream = Stream.of(1, 3, 5, 8);
		int sum = stream.mapToInt(num -> num.intValue()).sum();// 求和
		OptionalDouble average = stream.mapToInt(num -> num.intValue())
				.average();// 求平均值
		OptionalInt max = stream.mapToInt(num -> num.intValue()).max();// 求最大值

		// 将Stream转化为数值流
		IntStream intStream = stream.mapToInt(num -> num.intValue());
		// 将数值流转化为Stream
		stream = intStream.boxed();

		IntStream nums = IntStream.rangeClosed(1, 100);// 包含100
		IntStream nums2 = IntStream.range(1, 100);// 不包含100
	}

}
