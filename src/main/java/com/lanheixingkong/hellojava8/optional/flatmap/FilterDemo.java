package com.lanheixingkong.hellojava8.optional.flatmap;

public class FilterDemo {

	public String getTeamCoachAssistantName(SoccerTeam team) {
		return team.getCoach().filter(c -> "瓜迪奥拉".equals(c.getName()))
				.flatMap(Coach::getAssistant).map(Assistant::getName)
				.orElse("Unknown");

	}
}
