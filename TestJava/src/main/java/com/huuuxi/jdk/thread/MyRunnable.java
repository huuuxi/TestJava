package com.huuuxi.jdk.thread;

public class MyRunnable implements Runnable { 
    public Foo foo = new Foo(); 
    private ThreadLocal<Foo> foos = new ThreadLocal<Foo>(){
    	protected Foo initialValue() {return new Foo();};
    };

    public static void main(String[] args) { 
        MyRunnable r = new MyRunnable(); 
        System.out.println(r.foo == r.foo);
        Thread ta = new Thread(r, "Thread-A"); 
        Thread tb = new Thread(r, "Thread-B"); 
        ta.start(); 
        tb.start(); 
    } 

    public void run() { 
        for (int i = 0; i < 3; i++) { 
           // this.fix(30);
        	
        	foo.fix(30);
        	foos.get().fix(30);
            try { 
                Thread.sleep(1); 
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            } 
            System.out.println(Thread.currentThread().getName() + " : 当前foo对象的x值= " + foos.get().getX()+"---:"+foo.getX()); 
        } 
    } 

    
}
 class Foo { 
    private Integer x = 100; 

    public synchronized Integer getX() { 
        return x; 
    } 

    public synchronized  Integer fix(Integer y) { 
    	x = x - y; 
        return x; 
    } 
}