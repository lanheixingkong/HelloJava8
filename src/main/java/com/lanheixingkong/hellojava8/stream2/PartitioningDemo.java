package com.lanheixingkong.hellojava8.stream2;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

public class PartitioningDemo {

	public static void main(String[] args) {
		List<Integer> nums = Lists.newArrayList(1, 3, 4, 5, 4, 6, 2, 1);

		// 奇偶数分区
		System.out.println(nums.stream().collect(
				Collectors.partitioningBy((Integer n) -> n % 2 == 1)));

		// 找出奇偶数中最大的数
		System.out.println(nums.stream().collect(
				Collectors.partitioningBy((Integer n) -> n % 2 == 1,
						Collectors.collectingAndThen(Collectors
								.maxBy(Comparator
										.comparingInt((Integer n) -> n)),
								Optional::get))));
	}
}
