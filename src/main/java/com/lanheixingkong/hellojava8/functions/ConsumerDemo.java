/**
 * 
 */
package com.lanheixingkong.hellojava8.functions;

import java.util.List;
import java.util.function.Consumer;

import com.google.common.collect.Lists;

/**
 * @author: 谌磊
 * @date: 2018年9月3日 下午12:55:10
 * 
 */
public class ConsumerDemo {

	public static <T> void forEach(List<T> list, Consumer<T> consumer) {
		for (T t : list) {
			consumer.accept(t);
		}
	}

	public static void main(String[] args) {
		List<String> strList = Lists.newArrayList("Hello", "Java 8");
		Consumer<String> printStringConsumer = str -> System.out.println(str);
		forEach(strList, printStringConsumer);
	}
}
