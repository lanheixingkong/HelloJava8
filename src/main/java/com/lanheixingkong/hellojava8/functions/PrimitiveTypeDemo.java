/**
 * 
 */
package com.lanheixingkong.hellojava8.functions;

import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import com.google.common.collect.Lists;

/**
 * @author: 谌磊
 * @date: 2018年9月3日 下午2:38:04
 * 
 */
public class PrimitiveTypeDemo {

	public void autoboxing() {
		List<Integer> list = Lists.newArrayList();
		for (int i = 0; i < 100; i++) {
			list.add(i);
		}
	}

	public static void main(String[] args) {

		IntPredicate evenNumbers = (int i) -> i % 2 == 0;
		evenNumbers.test(1000); // 无装箱

		Predicate<Integer> oddNumbers = (Integer i) -> i % 2 == 1;
		oddNumbers.test(1000); // 装箱
	}
}
