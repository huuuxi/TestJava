package com.huuuxi.jvm;

public class TestTryCatch {

	
	public static void main(String[] args) {
		Long t = System.nanoTime();
		testNonTry();
		//testTry();
		System.out.println(System.nanoTime() - t);
	}
	
	/**
	 * 	cost time : 49,336,459 nano by each 2000;
	 * cost time : 1,242,121,442 nano by each 200000;
	 * */
	public static void testNonTry(){
		for (int i = 0; i <200000; i++) {
			System.out.println(i);
		}
	}
	
	/**
	 * cost time : 50,648,064 nano  by each 2000;
	 * cost time : 1,478,272,721 nano by each 200000;
	 */
	public static void testTry(){
		for (int i = 0; i <200000; i++) {
			try {
				System.out.println(i);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
