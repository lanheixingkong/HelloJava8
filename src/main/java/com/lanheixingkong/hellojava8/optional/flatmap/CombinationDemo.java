package com.lanheixingkong.hellojava8.optional.flatmap;

import java.util.Optional;

public class CombinationDemo {

	public static void main(String[] args) {
		Optional<Integer> speed = Optional.of(110);
		Optional<Integer> time = Optional.of(120);

		Optional<Integer> distance = Optional.empty();
		if (speed.isPresent() && time.isPresent()) {
			distance = Optional.of(speed.get() * time.get());
		}

		distance.ifPresent(System.out::println);

		// Optional组合方式
		Optional<Integer> distance2 = speed.flatMap(s -> time
				.map(t -> calDistance(s, t)));
	}

	public static Integer calDistance(Integer speed, Integer time) {
		return speed * time;
	}

}
