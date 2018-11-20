package com.lanheixingkong.hellojava8.optional;

import com.lanheixingkong.hellojava8.optional.notuse.Coach;
import com.lanheixingkong.hellojava8.optional.notuse.SoccerTeam;

public class FirstDemo {

	public static void main(String[] args) {
		System.out.println(new FirstDemo().getTeamCoachAssistantName(null));
	}

	public String getTeamCoachAssistantName(SoccerTeam team) {
		if (team != null) {
			Coach coach = team.getCoach();
			if (coach.getAssistant() != null) {
				return coach.getAssistant().getName();
			}
		}

		return "Unknown";
	}

}
