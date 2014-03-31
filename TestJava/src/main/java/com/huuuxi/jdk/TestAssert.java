package com.huuuxi.jdk;

/**
 * @author admin
 *在Java中，assert关键字是从JAVA SE 1.4 引入的，为了避免和老版本的Java代码中使用了assert关键字导致错误，Java在执行的时候默认是不启动断言检查的（这个时候，所有的断言语句都将忽略！），如果要开启断言检查，则需要用开关-enableassertions或-ea来开启。
 */
public class TestAssert {

	public static void main(String[] args) {
		testAssert(1);
	}
	
	public static void testAssert(int a){
		assert(a == 1);
		System.out.println(a);
	}
}
