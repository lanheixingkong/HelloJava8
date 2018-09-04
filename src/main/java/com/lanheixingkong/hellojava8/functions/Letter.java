/**
 * 
 */
package com.lanheixingkong.hellojava8.functions;

/**
 * @author: 谌磊
 * @date: 2018年9月4日 上午9:35:33
 * 
 */
public class Letter {

	// 增加抬头
	public static String addHeader(String content) {
		return "From Lionel Messi:" + content;
	}

	// 增加落款
	public static String addFooter(String content) {
		return content + " Kind regards";
	}

	// 拼写检查
	public static String checkSpelling(String content) {
		return content.replaceAll("labda", "lambda");
	}
}
