package com.huuuxi.jdk;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: wyliujiangbin
 * Date: 14-3-19
 * Time: 下午5:49
 * To change this template use File | Settings | File Templates.
 */
public class TestLockSyc {
    private volatile int id;
    private AtomicInteger atId;

    private TestLockSyc(){}
    private static TestLockSyc testLockSyc;
    private static TestLockSyc testLockSyc1 = new TestLockSyc();

    public synchronized static TestLockSyc getInstant(){
        if (testLockSyc == null){
              testLockSyc = new TestLockSyc();
        }
        return testLockSyc;
    }

    public  synchronized  static TestLockSyc getInstant1(){
        if (testLockSyc == null){
            synchronized (TestLockSyc.class){
                if (testLockSyc == null){
                    testLockSyc = new TestLockSyc();
                }
            }
        }
        return testLockSyc;
    }

    public  static void testSyc(){
        // volatile 只能保证数据的可见性，不能保证数据的互斥；使用范围：不依赖原来的值，独立于其它变量；
        //  cas 原子类里面使用此机制，compare and set
        // ReentrantLock 比   synchronized 添加了好多机制，锁投票、定时锁等候和可中断锁等候的一些特性，在锁竞争激烈的时候性能会更好；
        //  增加了计数器，分为公平锁和非公平锁；

        // 单例中，我们遇到了  Double Checked Locking （DCL）两次监测锁；
        synchronized (TestLockSyc.class){

        }
        ReentrantLock lock;

    }
}

