package com.huuuxi.jdk.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author wyliujiangbin
 *	无返回值的实现 Runnable，有返回值的实现Callable
 */
public class TestCallableThread {

	public static void main(String[] args) {
		testCall();
	}
	
	/**
	 * futuretask 测试，其实多了while，比future直接get()；多了阻塞；
	 * */
	public static void testFutureTask(){
		
		
	}
	
	@SuppressWarnings("rawtypes")
	public static void testCall(){
		// 线程池来跑
		ExecutorService executor  =  Executors.newFixedThreadPool(2);
		Callable my1 = new MyCallable("a");
		Callable my2 = new MyCallable("b");
	
		// submit 返回 一个future；
		Future<Object> obj1 = executor.submit(my1);
		Future<Object> obj2 = executor.submit(my2);
		// 可以取消，但是结果不能出来
		obj1.cancel(true);
		System.out.println(obj1.isCancelled());
		System.out.println(obj2.isDone());
		try {
			System.out.println(">>>"+obj1.get().toString());
			System.out.println(">>>"+obj2.get().toString());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}		
		executor.shutdown();
	}
	
}
class MyCallable implements Callable<Object>{

	private String str;
	public MyCallable(String str){
		this.str = str;
	}
	@Override
	public Object call() throws Exception {
		return str+":fanhui";
	}
}
class TaskCallable implements Callable<String>{
	@Override
	public String call() throws Exception {
		Thread.sleep(5000);
		return "hi,everyone ,i am back;";
	}
}
