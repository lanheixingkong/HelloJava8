package com.lanheixingkong.hellojava8.stream2;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.collect.Lists;
import com.lanheixingkong.hellojava8.functions.SoccerTeam;
import com.lanheixingkong.hellojava8.functions.TeamType;

public class ReduceAndSummaryDemo {

	public static void main(String[] args) {
		// 收集
		List<Integer> nums = Lists
				.newArrayList(1, 2, 3, 4, 3, 4, 5, 6, 5, 9, 1);

		// 收集奇数并转换为List
		System.out.println(nums.stream().filter(n -> n % 2 == 1)
				.collect(Collectors.toList()));// [1, 3, 3, 5, 5, 9, 1]
		// 收集奇数并转换为Set
		System.out.println(nums.stream().filter(n -> n % 2 == 1)
				.collect(Collectors.toSet()));// [1, 3, 5, 9]

		// 转换为map
		List<SoccerTeam> teams = Lists.newArrayList(new SoccerTeam("国际米兰",
				TeamType.CLUB, 60), new SoccerTeam("曼城", TeamType.CLUB, 100),
				new SoccerTeam("中国队", TeamType.COUNTRY, 10), new SoccerTeam("巴塞罗那",
						TeamType.CLUB, 80));
		Map<String, SoccerTeam> teamMap = teams.stream().collect(
				Collectors.toMap(SoccerTeam::getName, team -> team));

		// 统计个数
		System.out.println(nums.stream().filter(n -> n % 2 == 1)
				.collect(Collectors.counting()));// 7
		System.out.println(nums.stream().filter(n -> n % 2 == 1).count());// 7

		// 查找最大值
		nums.stream().collect(Collectors.maxBy(Comparator.comparing(n -> n)))
				.ifPresent(System.out::println);// 9
		// 查找最小值
		nums.stream().collect(Collectors.minBy(Comparator.comparing(n -> n)))
				.ifPresent(System.out::println);// 1

		// 求和
		int sum = nums.stream().collect(Collectors.summingInt(n -> n));// 43
		double sum2 = nums.stream().collect(Collectors.summingDouble(n -> n));// 43.0
		long sum3 = nums.stream().collect(Collectors.summingLong(n -> n));// 43
		System.out.println(sum + "--" + sum2 + "--" + sum3);

		// 求平均值
		double avg = nums.stream().collect(Collectors.averagingInt(n -> n));// 3.909090909090909
		double avg2 = nums.stream().collect(Collectors.averagingDouble(n -> n));// 3.909090909090909
		double avg3 = nums.stream().collect(Collectors.averagingLong(n -> n));// 3.909090909090909
		System.out.println(avg + "--" + avg2 + "--" + avg3);

		// 统计
		IntSummaryStatistics stat = nums.stream().collect(
				Collectors.summarizingInt(n -> n));
		// IntSummaryStatistics{count=11, sum=43, min=1, average=3.909091,
		// max=9}
		DoubleSummaryStatistics stat2 = nums.stream().collect(
				Collectors.summarizingDouble(n -> n));
		// DoubleSummaryStatistics{count=11, sum=43.000000, min=1.000000,
		// average=3.909091, max=9.000000}
		LongSummaryStatistics stat3 = nums.stream().collect(
				Collectors.summarizingLong(n -> n));
		// LongSummaryStatistics{count=11, sum=43, min=1, average=3.909091,
		// max=9}
		System.out.println(stat);
		System.out.println(stat2);
		System.out.println(stat3);

		// 连接字符串
		System.out.println(Stream.of("hello", "java", "8").collect(
				Collectors.joining()));// hellojava8
		// 使用空格进行分隔
		System.out.println(Stream.of("hello", "java", "8").collect(
				Collectors.joining(" ")));// hello java 8

		// 使用reducing求和
		int reduceSum = nums.stream().collect(
				Collectors.reducing(0, n -> n, (a, b) -> a + b));
		System.out.println(reduceSum);// 43
		// 单参数的reducing写法
		Optional<Integer> opSum = nums.stream().collect(
				Collectors.reducing((a, b) -> a + b));
	}
}
