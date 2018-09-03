/**
 * 
 */
package com.lanheixingkong.hellojava8.functions;

import static java.util.Comparator.*;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author: 谌磊
 * @date: 2018年9月3日 下午3:57:20
 * 
 */
public class ComposingComparators {

	public static void main(String[] args) {

		List<SoccerTeam> teams = Lists.newArrayList();
		teams.sort(comparing(SoccerTeam::getScore));// 按积分递增排序

		teams.sort(comparing(SoccerTeam::getScore).reversed());// 按积分递减排序

		teams.sort(comparing(SoccerTeam::getScore).reversed()// 按积分递减排序
				.thenComparing(comparing(SoccerTeam::getName)));// 按名称二次排序
	}
}
