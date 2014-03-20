package com.huuuxi.jdk;

/**
 * Created with IntelliJ IDEA.
 * User: wyliujiangbin
 * Date: 14-3-19
 * Time: 下午3:49
 * To change this template use File | Settings | File Templates.
 */
public class TestNumber {
    /**
     * 单精度和双精度问题；
     * */
    public static void testNumber(){
//        float f = 80838.0f;
//        float fl = -2499.0f;
        double f = 80838.0d;
        double fl = -2499.0d;
        double d =  f*fl;
        System.out.println(d);
    }
    public static void  main(String[] args){
        testNumber();
    }


}
