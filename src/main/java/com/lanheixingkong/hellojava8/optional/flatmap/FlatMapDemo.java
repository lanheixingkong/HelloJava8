package com.lanheixingkong.hellojava8.optional.flatmap;


public class FlatMapDemo {

	public String getTeamCoachAssistantName(SoccerTeam team) {
		return team.getCoach().flatMap(Coach::getAssistant)
				.map(Assistant::getName).orElse("Unknown");

	}

}
