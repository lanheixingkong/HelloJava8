package com.lanheixingkong.hellojava8.stream2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import com.lanheixingkong.hellojava8.functions.SoccerTeam;
import com.lanheixingkong.hellojava8.functions.TeamType;

public class GroupingDemo {

	public static void main(String[] args) {
		List<SoccerTeam> teams = Lists.newArrayList(new SoccerTeam("国际米兰",
				TeamType.CLUB, 60), new SoccerTeam("曼城", TeamType.CLUB, 100),
				new SoccerTeam("中国队", TeamType.COUNTRY, 10), new SoccerTeam(
						"巴塞罗那", TeamType.CLUB, 80));

		// 根据球队类型分组
		Map<TeamType, List<SoccerTeam>> teamTypeGroup = teams.stream().collect(
				Collectors.groupingBy(SoccerTeam::getTeamType));

		// 根据球队的积分分组
		Map<TeamLevel, List<SoccerTeam>> scoreGroup = teams.stream().collect(
				Collectors.groupingBy(team -> {
					if (team.getScore() > 70) {
						return TeamLevel.High;
					} else if (team.getScore() > 30) {
						return TeamLevel.Middle;
					}
					return TeamLevel.Low;
				}));

		// 先按球队类型再按照积分进行分组
		Map<TeamType, Map<TeamLevel, List<SoccerTeam>>> mulGroup = teams
				.stream().collect(
						Collectors.groupingBy(SoccerTeam::getTeamType,
								Collectors.groupingBy((SoccerTeam team) -> {
									if (team.getScore() > 70) {
										return TeamLevel.High;
									} else if (team.getScore() > 30) {
										return TeamLevel.Middle;
									}
									return TeamLevel.Low;
								})));
		System.out.println(mulGroup);

		// 统计不同类型球队的个数
		Map<TeamType, Long> countingGroup = teams.stream().collect(
				Collectors.groupingBy(SoccerTeam::getTeamType,
						Collectors.counting()));// {COUNTRY=1, CLUB=3}
		System.out.println(countingGroup);

		// 统计不同积分级别积分最高的球队
		Map<TeamLevel, Optional<SoccerTeam>> maxScoreGroup = teams.stream()
				.collect(
						Collectors.groupingBy(team -> {
							if (team.getScore() > 70) {
								return TeamLevel.High;
							} else if (team.getScore() > 30) {
								return TeamLevel.Middle;
							}
							return TeamLevel.Low;
						}, Collectors.maxBy(Comparator
								.comparingInt(SoccerTeam::getScore))));
		System.out.println(maxScoreGroup);

		// 统计不同积分级别积分最高的球队
		Map<TeamLevel, SoccerTeam> maxScoreTeamGroup = teams.stream().collect(
				Collectors.groupingBy(team -> {
					if (team.getScore() > 70) {
						return TeamLevel.High;
					} else if (team.getScore() > 30) {
						return TeamLevel.Middle;
					}
					return TeamLevel.Low;
				}, Collectors.collectingAndThen(Collectors.maxBy(Comparator
						.comparingInt(SoccerTeam::getScore)), Optional::get)));
		System.out.println(maxScoreTeamGroup);

		// 统计不同类型的球队包含哪些积分级别
		Map<TeamType, Set<TeamLevel>> typeLevelGroup = teams.stream().collect(
				Collectors.groupingBy(SoccerTeam::getTeamType,
						Collectors.mapping(team -> {
							if (team.getScore() > 70) {
								return TeamLevel.High;
							} else if (team.getScore() > 30) {
								return TeamLevel.Middle;
							}
							return TeamLevel.Low;
						}, Collectors.toSet())));
		//{COUNTRY=[Low], CLUB=[Middle, High]}
		System.out.println(typeLevelGroup);
	}

	public enum TeamLevel {
		High, Middle, Low
	}
}
