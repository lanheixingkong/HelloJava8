package com.lanheixingkong.hellojava8.optional;

import java.util.Optional;

import com.lanheixingkong.hellojava8.optional.used.Assistant;
import com.lanheixingkong.hellojava8.optional.used.SoccerTeam;

public class UseOptionalDemo {

	public String getTeamCoachAssistantName(SoccerTeam team) {
		Optional<Assistant> assistant = team.getCoach().getAssistant();

		if (assistant.isPresent()) {
			return assistant.get().getName();
		}

		return "Unknown";
	}

}
