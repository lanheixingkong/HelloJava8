/**
 * 
 */
package com.lanheixingkong.hellojava8.functions;

import java.util.List;
import java.util.function.Function;

import com.google.common.collect.Lists;

/**
 * @author: 谌磊
 * @date: 2018年9月3日 下午1:12:54
 * 
 */
public class FunctionDemo {

	public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
		List<R> result = Lists.newArrayListWithCapacity(list.size());
		for (T t : list) {
			result.add(function.apply(t));
		}

		return result;
	}

	public static void main(String[] args) {
		List<String> strList = Lists.newArrayList("Hello", "Java 8", "lanheixingkong");
		Function<String, Integer> stringToLengthFunction = str -> str.length();
		List<Integer> lenList = map(strList, stringToLengthFunction);
		// [5, 6, 14]
		System.out.println(lenList);
	}
}
