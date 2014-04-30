package com.huuuxi.jdk;
/**
 * 
 * 
 * @author wyliujiangbin
 *	类初始化:
 *	两种：一种new，先父类静态 --> 子类静态--> 父类构造 --> 子类构造
 *	静态类 -- 只初始化 本类的静态；
 *		如果调用父类的 静态，只初始化父类的静态
 *			如果调用父类的 final 静态 ，都不调用，因在编译器已经处理了；加入final static 调用的是一个构造函数，那么这个构造函数最先调用；
 *
 */
public class TestFinal {
	
	;
	
//	static final FinalVar  ff1 = new FinalVar();
//	 static FinalVar ff2 = new FinalVar();
	public static void main(String[] args) {
//		System.out.println(ff1);
//		System.out.println(ff2);
//		System.out.println(ff1);
//		System.out.println(ff2);
//		System.out.println(ff1);
//		System.out.println(ff2);
//		System.out.println(SubVar.t);
//		System.out.println("00000000000000");
//		System.out.println(SubVar.ss.t);
		System.out.println(SubVar.gg);
		
		
	}
	
}

class FinalVar{
	private static int counter;
	private int id = counter++;
	static  String t = "12123";
	static final SubVar ss = new SubVar();
	static{
		System.out.println(" Super is compleral");
	}
	public String toString(){
		return " counter:" +counter +",id :"+id;
	}
}

class SubVar extends FinalVar{
	static int gg = 1;
	static{
		System.out.println(" Sub is run");
	}
	public SubVar(){
		System.out.println("con sub");
		}
}
