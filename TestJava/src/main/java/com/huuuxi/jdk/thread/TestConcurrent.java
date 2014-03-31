package com.huuuxi.jdk.thread;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created with IntelliJ IDEA.
 * User: wyliujiangbin
 * Date: 14-3-19
 * Time: 下午4:17
 * To change this template use File | Settings | File Templates.
 */
public class TestConcurrent {
	
        public static void main(String[] args) { 
                ExecutorService pool = Executors.newFixedThreadPool(2); 
                Runnable t1 = new MyRunnablet("张三", 2000); 
                Runnable t2 = new MyRunnablet("李四", 3600); 
                Runnable t3 = new MyRunnablet("王五", 2700); 
                Runnable t4 = new MyRunnablet("老张", 600); 
                Runnable t5 = new MyRunnablet("老牛", 1300); 
                Runnable t6 = new MyRunnablet("胖子", 800); 
                //执行各个线程 
                pool.execute(t1); 
                pool.execute(t2); 
                pool.execute(t3); 
                pool.execute(t4); 
                pool.execute(t5); 
                pool.execute(t6); 
                //关闭线程池 
                pool.shutdown(); 
        } 

	
    public static void testCopyOnWrite(){
        // 实现为CopyOnWrite；write的时候拷贝一份，在新拷贝里面写入，然后把就的地址指向新拷贝；cow；
        // 应用场景：读多写少，比如黑名单白名单；
        // 数据一致性：最终一致，不是实时；
        CopyOnWriteArrayList list;
        CopyOnWriteArraySet set;

    }
}

class MyRunnablet implements Runnable { 
	//ps，注意，并不一定引用的是同一个对象，类里面的static变量也会让其操作的是同一个数字；
    private static AtomicLong aLong = new AtomicLong(10000);        //原子量，每个线程都可以自由操作 
    private String name;                //操作人 
    private int x;                            //操作数额 

    MyRunnablet(String name, int x) { 
            this.name = name; 
            this.x = x; 
    } 

    public void run() { 
            System.out.println(name + "执行了" + x + "，当前余额：" + aLong.addAndGet(x)); 
    } 
}
