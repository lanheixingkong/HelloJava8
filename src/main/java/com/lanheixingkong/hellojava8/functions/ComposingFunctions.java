/**
 * 
 */
package com.lanheixingkong.hellojava8.functions;

import java.util.function.Function;

/**
 * @author: 谌磊
 * @date: 2018年9月3日 下午3:57:20
 * 
 */
public class ComposingFunctions {

	public static void main(String[] args) {

		Function<String, String> addHeader = Letter::addHeader;// 增加抬头
		// 第一条流水线
		Function<String, String> transformationPipeline1 = addHeader.andThen(Letter::checkSpelling)// 拼写检查
				.andThen(Letter::addFooter);// 增加落款

		// 第二条流水线
		Function<String, String> transformationPipeline2 = addHeader.andThen(Letter::addFooter);// 增加落款
	}
}
