package com.huuuxi.jdk.thread;

/**
 * @author wyliujiangbin
 * 
 *	当使用ThreadLocal维护变量时，ThreadLocal为每个使用该变量的线程提供独立的变量副本，所以每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本。
 *	从线程的角度看，目标变量就象是线程的本地变量，这也是类名中“Local”所要表达的意思。
 *	Spring使用ThreadLocal解决线程安全问题
 *	我们知道在一般情况下，只有无状态的Bean才可以在多线程环境下共享，在Spring中，绝大部分Bean都可以声明为singleton作用域。就是因为Spring对一些Bean（如RequestContextHolder、TransactionSynchronizationManager、LocaleContextHolder等）中非线程安全状态采用ThreadLocal进行处理，让它们也成为线程安全的状态，因为有状态的Bean就可以在多线程中共享了。
 *
 *	PS: 我的理解，ThreadLocal只是让变量能复制拷贝，但是不能让变量通讯，即多线程之间不会通信，只会使用且对象不冲突；
 */
public class TestThreadLocal {

	public static void main(String[] args) {
		Mythead my1 = new Mythead();
		Mythead my2 = new Mythead();
		Mythead my3 = new Mythead();
		
		my1.start();
		my2.start();
		my3.start();
	}
}

class Mythead extends Thread{
	
	// ThreadLocal 维护一个 Integer 对象
	ThreadLocal<Integer> vars = new ThreadLocal<Integer>(){
		@Override
		protected Integer initialValue() {
			return 0;
		}
	};
	
	@Override
	public void run() {
		// 异步延迟加载，第一次get() 后，初始化执行 
		/*if (vars.get() == null) {
			vars.set(0);
		}*/
		while (vars.get() < 3) {
			System.out.println(Thread.currentThread().getName()+"----:"+vars.get() );
			vars.set(vars.get() +1);
		}
	}
	
}
