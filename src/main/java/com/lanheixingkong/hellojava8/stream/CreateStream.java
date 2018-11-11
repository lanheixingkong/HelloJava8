package com.lanheixingkong.hellojava8.stream;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStream {

	public static void main(String[] args) {
		// 创建一个字符串流
		Stream<String> stream = Stream.of("Hello", "Java", "8", "2018");
		// 使用empty得到一个空流
		Stream<String> emptyStream = Stream.empty();

		// 通过数组创建流
		int[] numbers = { 1, 2, 4, 6, 4, 3, 1 };
		IntStream numStream = Arrays.stream(numbers);
		String[] strs = { "hello", "world" };
		Stream<String> strStream = Arrays.stream(strs);

		// 从文件创建流
		try (Stream<String> lines = Files.lines(Paths.get("data.txt"),
				Charset.defaultCharset())) {
			// TODO
		} catch (Exception e) {
			// TODO
		}

		// 通过iterate创建流
		Stream<Integer> intStream = Stream.iterate(0, n -> n + 2).limit(10);
		
		//通过generate创建流
		Stream<Double> doubleStream = Stream.generate(Math::random).limit(5);
	}
}
