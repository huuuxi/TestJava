package com.huuuxi.jdk.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wyliujiangbin
 *	List 接口 继承 Collection 继承 Iterator ，那么访问是顺序访问，对立于 随即访问；
 *	ArrayList 也实现了 RandomAccess ，故也是支持 随即访问的；
 *	AbstractList 里面的iterator 定义了自己的私有类，iter类，lastIndexOf 则是返回的iterator 调用 previous
 *		modCount 为其变量：修改次数；
 */
public class TestList {

	public static void main(String[] args) {
		testList();
	}
	/**
	 *  retain ;
	 *  add (index ,Element);
	 *  sublist : 和substring 差不多，都是offset改变；不同的是String对象是final，需要return new
	 */
	public static void testList(){
		List list1 = new ArrayList<String>();
		List list2 = new ArrayList<String>();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		list2.add("b");
		list2.add(1, "c");
		list2.add(2,"d");
		list1.retainAll(list2);
		for(Object str : list1){
			System.out.println(str.toString());
		}
		List l = list1.subList(1, list1.size());
		System.out.println("------------------");
		for(Object str : list1){
			System.out.println(str.toString());
		}
		System.out.println("------------------");
		for(Object str : l){
			System.out.println(str.toString());
		}
	}
	/**
	 *  ArrayList 实现，存储的数组；初始化默认 大小是 10；
	 *  		elementData(object[]) size 
	 *  	add，需要ensureCapacity；当size+1 超过 容量，扩容为*3/2；
	 *  	add(index,element) ，确保size不超出后，system.arraycopy 5个参数，拷贝index后面挪动，赋值index为element；
	 *  	addall(index,list) , 首先system.arraycopy 挪出index 位置，然后system.arraycopy把新的list放进来；
	 *  	addall(list) 直接在最后 system.arraycopy;
	 *  	clone() ：super.clone();elementData 复制，modCount = 0; modCount : 修改次数；
	 *  	fastRemove(index) : 取到位置，system.arraycopy, 关键是 size--  = null; let gc works;
	 *  	remove(index) ：同 fastRemove() ，返回 index指向的 Object；
	 *  	remove(object) : 循环判断，object 相等，调用 fastRemove();
	 *  	removeRange(index,end) : modCount++,取位置，system.arraycopy，size赋值，elementDate = null; 
	 * 		trimToSize() : 调用的是 Arrays.copyof，对elementData 重新赋值；
	 */
	public static void testArrayList(){
		
	}
	/**
	 * LinkedList ：实现了List、Deque，是一个双向队列；由于是双向队列，头和尾是一个; 也就是环形的结构（终于觉悟了，一致性hash里面的环形策略）
	 * 		header 里面时间上是没有值的，即element为空，first为 header.next; last 为header.previous；
	 * 	存储 header size；header ：Entry（私有类），Element、next、previous
	 * 		add(E): 调用的是addBefore方法；header 不变，header默认 next element previous 都是自己；
	 * 		add(index,object) : 判断位置 == size ，就是调用header在header前面插入，否则是查找index，操作index插入；
	 * 		addFirst() : 操作处理的是 header.next  
	 * 		addLast() : 操作的是 header
	 * 		clone() : 方法实际上没用，但是要调用super.clone(); 类的私有变量需要重新赋值；
	 * 		offer() offerFirst() 分别对应 add() ...
	 * 		peek()  只返回，不删除
	 * 		pop() 删除 并返回
	 * 		poll() 删除返回，判空null；
	 * 		removeLastOccurrence() 需要逆向查找到第一个并且删除, removeFirstOccurrence() 调用的就是remove
	 * 		set(index,elemet) 取到 index 的entry ，设置element；
	 * 
	 */
	public static void testLinkedList(){
		
	}
}