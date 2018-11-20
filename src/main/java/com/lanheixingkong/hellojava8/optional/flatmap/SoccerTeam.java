/**
 * 
 */
package com.lanheixingkong.hellojava8.optional.flatmap;

import java.util.Optional;

import lombok.Data;

/**
 * @author: 谌磊
 * @date: 2018年9月3日 上午11:41:46
 * 
 */
@Data
public class SoccerTeam {
	private String name;
	private Optional<Coach> coach;
}
