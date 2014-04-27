package com.huuuxi.jdk.collections;

import java.util.BitSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author wyliujiangbin
 *		Set 和 List 都 继承 Collection, Iterator必然会有了；
 *		set 不运行 重复，允许null；
 */
public class TestSet {
	public static void main(String[] args) {
		//testSet();
		testBitSet();
	}
	
	public static void testSet(){
		Set set = new HashSet<Object>();
		set.add(null);
		set.add(null);
		System.out.println(set.size());
	}
	/**
	 * 	HashSet 里面存储了 Transient的 HashMap来维护；
	 * 	定义了 Persent = new Object(); Set的值存储的是 Map的 key；因为Map的key是不允许重复；
	 * 
	 */
	public static void testHashSet(){
		HashSet hashSet ;
	}
	/**
	 *  LinkedHashSet 继承了 HashSet；
	 *  	构造函数 调用的是 super() 最后参数 dummy = true 表示，初始化 LinkedHashMap;
	 */
	public static void testLinkedHashSet(){
		LinkedHashSet set;
	}
	/**
	 * 		TreeSet 实现 NavigableSet ，实现SortedSet；其必须包含 Comparator接口和方法；subSet tailSet subSet 都是取 区间的 sortedset；
	 *			LinkedList 和 SortedSet 不同在，list有序是顺序，而 Sorted是 对象排序；
	 *		NavigableSet 里面 多了几个方法： ceiling(e) 取大于e的最小的值；floor(e) 小于e的最大的值；和Number里面的方法相似命名；
	 *		
	 *		里面变量维护 NavigableMap 存储数据；
	 *			 还是用Map来维持数据；
	 */
	public static void testTreeSet(){
		TreeSet set ;
	}
	/**
	 * 	BitSet 默认是 64位，那么就存储 64个数字； 类似oracle的bit hash；
	 * 	里面存储 整数，字符 比较靠谱
	 * 
	 */
	public static void testBitSet(){
		BitSet bit = new BitSet();
		System.out.println(bit.size());
		//bit.set('a');
		//bit.set('A');
		bit.set(-4);
		bit.set(0);
		bit.set(63);
		System.out.println(bit.size());
		System.out.println(bit.get(0, 128));
	}
}
