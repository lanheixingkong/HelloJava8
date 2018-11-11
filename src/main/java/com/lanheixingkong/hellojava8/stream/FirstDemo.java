package com.lanheixingkong.hellojava8.stream;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import com.lanheixingkong.hellojava8.functions.SoccerTeam;

public class FirstDemo {

	public static void main(String[] args) {
		List<SoccerTeam> teams = Lists.newArrayList();// 一个球队集合
		List<SoccerTeam> gt50ScoreClubs = Lists.newArrayList();// 积分大于50的俱乐部
		for (SoccerTeam team : teams) {
			if (team.isClub() && team.getScore() > 50) {
				gt50ScoreClubs.add(team);
			}
		}

		// 使用流处理
		gt50ScoreClubs = teams.stream().filter(SoccerTeam::isClub)
				.filter(team -> team.getScore() > 50)
				.collect(Collectors.toList());
	}

}
