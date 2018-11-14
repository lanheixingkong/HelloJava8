/**
 * 
 */
package com.lanheixingkong.hellojava8.functions;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 谌磊
 * @date: 2018年9月3日 上午11:41:46
 * 
 */
@Data
@NoArgsConstructor
public class SoccerTeam {
	private String name;
	private TeamType teamType;
	private Integer score;

	public SoccerTeam(TeamType teamType) {
		this.teamType = teamType;
	}

	public SoccerTeam(String name, TeamType teamType, Integer score) {
		this.name = name;
		this.teamType = teamType;
		this.score = score;
	}

	public boolean isClub() {
		return this.teamType == TeamType.CLUB;
	}
}
