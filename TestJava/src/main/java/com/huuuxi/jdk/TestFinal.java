package com.huuuxi.jdk;

public class TestFinal {
	static final FinalVar  ff1 = new FinalVar();
	 static FinalVar ff2 = new FinalVar();
	public static void main(String[] args) {
		System.out.println(ff1);
		System.out.println(ff2);
		System.out.println(ff1);
		System.out.println(ff2);
		System.out.println(ff1);
		System.out.println(ff2);
	}
	
}

class FinalVar{
	private static int counter;
	private int id = counter++;
	
	public String toString(){
		return " counter:" +counter +",id :"+id;
	}
	
	
}
