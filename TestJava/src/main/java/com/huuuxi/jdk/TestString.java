package com.huuuxi.jdk;

import java.util.Arrays;

public class TestString {

	private static final String url = "https://merchant3.chinabank.com.cn:9103/billfiles/%s/%s_%s_accountBill.xls";
	public static void main(String[] args) {
		//testFormat();
		//testString();
		//testConstString();
//		testStringBuffer();
		testEquals();
	}
	
	public static void testFormat(){
		String u = String.format(url, "111","222","333");
		String usub = url.substring(url.lastIndexOf("/")+1);
		System.out.println(usub);
		System.out.println(u);
	}
	/**
	 * 	split 调用的是index substring，添加到List里
	 * 	ps：返回值不是 基本类型，绝大部分调用内部方法；其它调用System Arrays 和构造方法，以及char[]
	 * trim 调用的是 substring
	 *  Arrays.copyof  和 System.copyof 
	 */
	public static void testString(){
		//System.out.println(String.CASE_INSENSITIVE_ORDER.compare("abc", "ABC"));
		System.out.println(Arrays.copyOf(new char[]{'1','2','3'}, 2));
		System.out.println(Arrays.copyOfRange(new char[]{'1','2','3','4','5'}, 2,4));
		char[] a = new char[]{'1','2','3','4','5'};
		char[] b = new char[4];
		System.arraycopy(a, 2, b, 1, 3);	
		System.out.println(String.valueOf(b));
		String ttt = "" ;
		System.arraycopy("123456", 1, ttt, 0, 3);
		System.out.println(ttt);
	}
	/**
	 *  String 常量池
	 *  	intern() 补充：若String执行intern，常量池里面不存在值，就把自己的地址注册到常量池；这个是对的；
	 *  	下面例子  String b = new String("abcde"); b.intern(); 实际上常量池已经有了 "abcde"；intern 返回的是他的地址；
	 *  	String b = new String("abc") +"de"； b.intern() 返回的是 b的地址；
	 */
	public static void testConstString(){
		String a = "hell";
		String b = "0";
		String c = "hello";
		System.out.println(c == (a+b)); // 返回false，运行时，值不能用常量池；
		System.out.println(c ==("he"+"llo")); //true，编译时，常量池；
		System.out.println(c == (a+b).intern()); // intern返回的常量池中的值，如果常量池里面有则返回；
		
		String x = new String("xyz");
		x.intern();
		System.out.println(x == x.intern());
		System.out.println("----");
		String m = new String("mmm")+"nnn";
		m.intern();
		System.out.println(m == m.intern());
		
		
		System.out.println("--");
		String b1 = new String("cd1")+"23";
		//b1.intern();
		System.out.println(b1.hashCode());
		System.out.println("cd123".hashCode());
		System.out.println(b1 == "cd123");
		
	}
	
	public static void testStringBuffer(){
		StringBuffer buffer =  new StringBuffer();
		buffer.append("hello");
		String reverse = buffer.reverse().toString();
		System.out.println(reverse);
	}
	/**
	 * 
	 * @author admin
	 *	Object t = new StringEquals();  这个很神奇，运行的时候是 StringEquals；编译的时候是 Object
	 *	故要加 Override
	 */
	class StringEquals {
		
		//@Override
		public boolean equals(StringEquals obj) {
			System.out.println("override ....");
			return true;
		}
	}
	public static void testEquals(){
		StringEquals s1 = new TestString().new StringEquals();
		StringEquals s2 = new TestString().new StringEquals();
		
		Object s3 = new TestString().new StringEquals();
		Object s4 = new TestString().new StringEquals();
		
		if (s1.equals(s2)) {
			System.out.println("s1 == s2");
		}
		if (s3.equals(s4)) {
			System.out.println("s3 == s4");
		}
		
	}
	
}
