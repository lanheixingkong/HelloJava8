package com.lanheixingkong.hellojava8.optional;

import java.util.Optional;

public class CreateOptional {

	public static void main(String[] args) {
		// 创建一个空的Optional
		Optional<?> empty = Optional.empty();// Optional.empty
		System.out.println(empty);

		// 根据一个非空值创建Optional
		Optional<String> strOpt = Optional.of("Hello Java 8");// Optional[Hello Java 8]
		System.out.println(strOpt);
		Optional<String> strOpt2 = Optional.of(null);// error! NullPointerException!

		// 可接受null的Optional
		Optional<String> nullOpt = Optional.ofNullable(null);// Optional.empty
		System.out.println(nullOpt);
	}
}
