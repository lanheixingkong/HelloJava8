/**
 * 
 */
package com.lanheixingkong.hellojava8.functions;

import java.util.List;
import java.util.function.Predicate;

import com.google.common.collect.Lists;

/**
 * @author: 谌磊
 * @date: 2018年9月3日 下午4:17:37
 * 
 */
public class ComposingPredicates {

	public static void main(String[] args) {
		List<SoccerTeam> teams = Lists.newArrayList();

		Predicate<SoccerTeam> clubTeam = team -> team.getTeamType() == TeamType.CLUB;// 筛选出俱乐部
		Predicate<SoccerTeam> notClubTeam = clubTeam.negate();// 筛选出非俱乐部
		Predicate<SoccerTeam> highScoreClubTeam = clubTeam.and(team -> team.getScore() > 50);// 筛选出积分大于50的俱乐部
		Predicate<SoccerTeam> highScoreClubOrCountryTeam = clubTeam.and(team -> team.getScore() > 50).or(team -> team.getTeamType() == TeamType.COUNTRY);// 筛选出积分大于50的俱乐部或者国家队
	}
}
