package com.lanheixingkong.hellojava8.stream2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.lanheixingkong.hellojava8.functions.SoccerTeam;
import com.lanheixingkong.hellojava8.functions.TeamType;

public class FirstDemo {

	public static void main(String[] args) {
		List<SoccerTeam> teams = Lists.newArrayList(new SoccerTeam("国际米兰",
				TeamType.CLUB, 60), new SoccerTeam("曼城", TeamType.CLUB, 100),
				new SoccerTeam("中国队", TeamType.COUNTRY, 10), new SoccerTeam("巴塞罗那",
						TeamType.CLUB, 80));
		
		System.out.println(groupbyJava7(teams));
		System.out.println(groupbyJava8(teams));
	}

	private static Map<TeamType, List<SoccerTeam>> groupbyJava7(
			List<SoccerTeam> teams) {
		Map<TeamType, List<SoccerTeam>> result = Maps.newHashMap();
		for (SoccerTeam team : teams) {
			if (result.containsKey(team.getTeamType())) {
				result.get(team.getTeamType()).add(team);
			} else {
				result.put(team.getTeamType(), Lists.newArrayList(team));
			}
		}
		return result;
	}

	private static Map<TeamType, List<SoccerTeam>> groupbyJava8(
			List<SoccerTeam> teams) {
		return teams.stream().collect(
				Collectors.groupingBy(SoccerTeam::getTeamType));
	}
}
