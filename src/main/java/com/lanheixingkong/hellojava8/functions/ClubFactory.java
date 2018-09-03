/**
 * 
 */
package com.lanheixingkong.hellojava8.functions;

/**
 * @author: 谌磊
 * @date: 2018年9月3日 下午2:06:27
 * 
 */
public class ClubFactory {
	public static SoccerTeam createClub() {
		return new SoccerTeam(TeamType.CLUB);
	}
}
