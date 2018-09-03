/**
 * 
 */
package com.lanheixingkong.hellojava8.functions;

import java.util.function.Supplier;

/**
 * @author: 谌磊
 * @date: 2018年9月3日 下午1:55:03
 * 
 */
public class SupplierDemo {

	public static void main(String[] args) {
		Supplier<SoccerTeam> createClubTeam = ClubFactory::createClub;
		SoccerTeam club = createClubTeam.get();
	}
}
