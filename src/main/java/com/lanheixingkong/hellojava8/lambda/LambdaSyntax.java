package com.lanheixingkong.hellojava8.lambda;

public class LambdaSyntax {

public static void process(Runnable r) {
	r.run();
}

public static void main(String[] args) {
	// 使用Lambda
	Runnable r1 = () -> System.out.println("Hello Java 8");
	// 当然也可以使用匿名内部类来实现
	Runnable r2 = new Runnable() {
		@Override
		public void run() {
			System.out.println("Hello world");
		}
	};

	process(r1); // 打印 Hello Java 8
	process(r2); // 打印 Hello world
	process(() -> System.out.println("Hello Lambda")); // 直接传递Lambda表达式作为参数，打印 Hello Lambda
}
}
