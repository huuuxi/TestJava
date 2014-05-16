package com.huuuxi.jdk;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: wyliujiangbin
 * Date: 14-3-19
 * Time: 下午3:49
 * To change this template use File | Settings | File Templates.
 * 	BigDecimal ： 里面可以指定 scale ：小数点尾数，Round 四舍五入规则；
 */
public class TestNumber {
    /**
     * 单精度和双精度问题；
     * 	单精度 32位 = 4字节；float
     * 	双精度 64位 = 8字节；double
     * 	long 在32位编译器里面占位 4字节，64位占8字节；
     * */
    public static void testNumber(){
//        float f = 80838.0f;
//        float fl = -2499.0f;
        double f = 80838.0d;
        double fl = -2499.0d;
        double d =  f*fl;
        System.out.println(d);
        /***
         * Number 是数字的抽象类，包含基础类型和BigInteger BigDecimal
         */
        Number number;
        /***
         * Math final类，具体算法；
         * 	abs 负数是 0.0D-param;
         * 	floor 取小于其的最大值
         * 	ceil 取大于他的最小值
         *  round 四舍五入，算法：+0.5D，然后取 floor
         */
        Math math;
        //严格的
        StrictMath strictMath;
    }
    public static void  main(String[] args){
        //testNumber();
    	//testNumb();
    	//testInteger();
//    	testRandom();
    	System.out.println(Long.SIZE);
    }

    public static void testInteger(){
    	System.out.println(Integer.bitCount(8)); // 取 位为1的个数
    	System.out.println(Integer.decode("0xa")); // 解析字符到数字；
    	//System.out.println(Integer.parseInt("0x6")); // exception
    	System.out.println(Integer.highestOneBit(9)); // 取最高位为1，其余位为0的值
    	System.out.println(Integer.lowestOneBit(9));
    	System.out.println(Integer.numberOfLeadingZeros(8)); // 左侧0的个数
    	System.out.println(Integer.numberOfTrailingZeros(8));
    	System.out.println(Integer.parseInt("12", 16)); // 第二个参数是 radix ，进制的意思
    	System.out.println(Integer.reverse(8));  // 按照位 反向
    	System.out.println(Integer.reverseBytes(8)); // 按照自己反向
    	System.out.println(Integer.rotateLeft(7, 2)); // 左移 2位
    	System.out.println(Integer.signum(-9)); // 返回的是i的符号
    	System.out.println(Integer.toBinaryString(-9)); //转换成 2进制，在字符输出
    	System.out.println(Integer.SIZE);
    	System.out.println(Long.SIZE);
    	System.out.println(Float.SIZE);
    	System.out.println(Double.SIZE);
    }
    /**
     * 测试 Integer 缓冲的 -128~ 127 个数字
     */
    public static void testNumb(){
    	int a = 1000 ;int   b = 1000;
    	System.out.println(a == b);
    	Integer c = 1000 ;Integer d = 1000;
    	System.out.println(c == d);
    	Integer e = 100 ; Integer f = 100;
    	System.out.println(e == f);
    	Integer g = new Integer(100); Integer h = new Integer(100);
    	System.out.println(g == h);
    }
    /**
     * 测试 Random，种子一样，得到结果也一样；
     * 	默认种子是时间；
     */
    public static void testRandom(){
    	Random r1 = new Random(100);
    	Random r2 = new Random(100);
    	for (int i = 0; i < 2; i++) {
    		System.out.println("r1:"+i+"::"+r1.nextInt());
    		System.out.println("r2:"+i+"::"+r2.nextInt());
		}
    	
    }

}
