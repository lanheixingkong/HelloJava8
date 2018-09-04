/**
 * 
 */
package com.lanheixingkong.hellojava8.functions;

import java.util.List;
import java.util.function.Predicate;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;

/**
 * @author: 谌磊
 * @date: 2018年9月3日 上午11:41:05
 * 
 */
public class PredicateDemo {

	public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
		List<T> result = Lists.newArrayList();
		for (T t : list) {
			if (predicate.test(t)) {
				result.add(t);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		List<String> strList = Lists.newArrayList("hello", "", "lanheixingkong", null, "java 8", " ", "null");
		Predicate<String> notBlankStringPredicate = str -> StringUtils.isNotBlank(str);
		List<String> notBlankStrList = filter(strList, notBlankStringPredicate);
		List<String> notBlankStrList2 = filter(strList, str -> StringUtils.isNotBlank(str));
		// [hello, lanheixingkong, java 8, null]
		System.out.println(notBlankStrList);
	}
}
