package com.huuuxi.jdk.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author admin
 * ForkJoinPool 执行的好处在于，invokeAll() 是同步的，但是调用 Pool的任务 ，可以执行其它的任务；
 *	关键在于 Join，其它的Runnale也许也能满足，但是Join的化就不可以；所以 ForkJoin有优势；
 *	核心是： 轻量级调度work-stealing
 *	可以异步调用 fork()，结果返回用同步 join(); 也有get();
 *	不可以取消cancel();
 */
public class TestForkJoinPool {

	public static void main(String[] args) {
		GeneralProduct gp = new GeneralProduct();
		List<Product> list = gp.generate(1000);
		Task t = new Task(list, 0, list.size(), 0.2);
		ForkJoinPool pool = new ForkJoinPool();
		pool.execute(t);
		do {
			System.out.printf("Main :Thread count :%d\n",pool.getActiveThreadCount());
			System.out.printf("Main :Thead Steal : %d\n", pool.getStealCount());
			System.out.printf("Main : Parallelism : %d\n", pool.getParallelism());
			try {
				TimeUnit.MILLISECONDS.sleep(5);
			} catch (Exception e) {
				// TODO: handle exception
			}
		} while (!t.isDone());
		pool.shutdown();
		if (t.isCompletedNormally()) {
			System.out.println("Main : The process has completed nomarlly");
		}
		for(Product p  : list){
			if (p.getPrice() != 12) {
				System.err.println(p.toString());
			}
		}
		System.out.println("Main function is End;");
	}
}
/**x
 * 
 * @author admin
 *	Recursive 递归的意思； ForkJoinPool的工作类，继承了 ForkJoinTask
 */
class Task extends RecursiveAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3524132239152564266L;

	private List<Product> list ;
	private int first;
	private int last;
	private double increment;
	public Task(List<Product> list ,int first ,int last,double increment){
		this.list = list;
		this.first = first;
		this.last = last;
		this.increment = increment;
	}
	
	private void updatePrice(){
		for( int i = first ; i< last; i++){
			Product p = list.get(i);
			p.setPrice(p.getPrice()*(1+increment));
		}
	}
	
	@Override
	protected void compute() {
		if (last - first < 10) {
			updatePrice();
		}else {
			int middle  = (last + first) /2;
			System.out.printf("Task : panding tasks %s \n",getQueuedTaskCount());
			Task task1 = new Task(list, first, middle, increment);
			Task task2 = new Task(list, middle, last	, increment);
			invokeAll(task1,task2);
		}
		
	}
	
}

class GeneralProduct{
	public List<Product> generate(int size){
		 List<Product> list = new ArrayList<Product>();
		for(int i = 0 ; i < size ;i++){
			list.add(new Product("product-"+i, 10));
		}
		return list;
	}
}


class Product {
	private String name;
	private double price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Product(){
		
	}
	public Product(String name, double price){
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString(){
		return new StringBuilder().append("Name :").append(name).append(",Price:").append(price).toString();
		
	}
	
}