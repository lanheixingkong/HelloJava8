package com.lanheixingkong.hellojava8.stream;

import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;

public class UseStream {
	public static void main(String[] args) {
		// useFilter();
		// useDistinct();
		// useLimit();
		// useSkip();
		// useMap();
		// useFlatmap();
		// useAnyMatch();
		// useAllMatch();
		// useNoneMatch();
		// useFindAny();
		// useReduce();
		useCount();
	}

	public static void useFilter() {
		List<Integer> nums = Lists.newArrayList(1, 2, 3, 3, 2, 5, 2, 3, 4);
		// 筛选奇数
		nums.stream().filter(n -> n % 2 == 1).forEach(System.out::print);
	}

	public static void useDistinct() {
		List<Integer> nums = Lists.newArrayList(1, 2, 3, 3, 2, 5, 2, 3, 4);
		// 筛选不重复的奇数
		nums.stream().filter(n -> n % 2 == 1).distinct()
				.forEach(System.out::print);
	}

	public static void useLimit() {
		List<Integer> nums = Lists.newArrayList(1, 2, 3, 3, 2, 5, 2, 3, 4);
		// 截取前三个数字
		nums.stream().limit(3).forEach(System.out::print);
	}

	public static void useSkip() {
		List<Integer> nums = Lists.newArrayList(1, 2, 3, 3, 2, 5, 2, 3, 4);
		// 跳过前三个数字
		nums.stream().skip(3).forEach(System.out::print);
	}

	public static void useMap() {
		List<Integer> nums = Lists.newArrayList(1, 2, 3, 3, 2, 5, 2, 3, 4);
		// 将数字映射为数字的平方
		nums.stream().map(n -> n * n).forEach(System.out::print);
	}

	public static void useFlatmap() {
		List<String> strs = Lists.newArrayList("hello", "world");
		// 过滤出所有不同的字符
		strs.stream().map(str -> str.split("")).flatMap(Arrays::stream)
				.distinct().forEach(System.out::print);
	}

	public static void useAnyMatch() {
		List<Integer> nums = Lists.newArrayList(1, 2, 3, 3, 2, 5, 2, 3, 4);
		// 检查是否有大于10的数字
		System.out.println(nums.stream().anyMatch(num -> num > 10));// false
	}

	public static void useAllMatch() {
		List<Integer> nums = Lists.newArrayList(1, 2, 3, 3, 2, 5, 2, 3, 4);
		// 检查是否所有的数字都大于10
		System.out.println(nums.stream().allMatch(num -> num < 10));// true
	}

	public static void useNoneMatch() {
		List<Integer> nums = Lists.newArrayList(1, 2, 3, 3, 2, 5, 2, 3, 4);
		// 检查是否所有的数字都不大于10
		System.out.println(nums.stream().noneMatch(num -> num > 10));// true
	}

	public static void useFindAny() {
		List<Integer> nums = Lists.newArrayList(1, 2, 3, 3, 2, 5, 2, 3, 4);
		// 查询大于1的任意元素
		System.out.println(nums.stream().filter(n -> n > 1).findAny());
	}

	public static void useFindFirst() {
		List<Integer> nums = Lists.newArrayList(1, 2, 3, 3, 2, 5, 2, 3, 4);
		// 查询大于1的第一个元素
		System.out.println(nums.stream().filter(n -> n > 1).findFirst());
	}

	public static void useReduce() {
		List<Integer> nums = Lists.newArrayList(1, 2, 3, 3, 2, 5, 2, 3, 4);
		// 对集合中的所有数字求和
		System.out.println(nums.stream().reduce(0, (a, b) -> a + b));// 25
		// 求最大值
		nums.stream().reduce(Integer::max).ifPresent(System.out::print);// 5
		// 求最小值
		nums.stream().reduce(Integer::min).ifPresent(System.out::print);// 1
	}

	public static void useCount() {
		List<Integer> nums = Lists.newArrayList(1, 2, 3, 3, 2, 5, 2, 3, 4);
		System.out.println(nums.stream().count());// 9
	}
}
