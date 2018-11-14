package com.lanheixingkong.hellojava8.stream2;

import java.util.stream.Stream;

public class ParallelDemo {

	public static void main(String[] args) {
		// 顺序流
		Stream.iterate(1L, i -> i + 1).limit(100).reduce(0L, Long::sum);

		// 并行流
		Stream.iterate(1L, i -> i + 1).limit(100).parallel()
				.reduce(0L, Long::sum);

		// 合并使用
		Stream.iterate(1L, i -> i + 1).limit(100).parallel()
				.filter(i -> i % 2 == 1).sequential().map(i -> i * i)
				.parallel().reduce((a, b) -> a + b);
	}
}
