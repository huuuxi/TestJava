package com.huuuxi.jdk.collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
/**
 * 
 * @author wyliujiangbin
 *		Map 不能放 重复key；替换了 接口Dictionary；
 *			entrySet() 比 keySet() 效率高，都是遍历；
 *			put() 很有意思，他返回的是 前一个值；
 *			containsValue()  values();
 */
public class TestMap {

	public static void main(String[] args) {
//		testMap();
		testLinkedHashMap();
	}
	/**
	 * 	keySet() 很有意思，返回的是 它的私有变量 keySet Set<K>; 返回的是一个抽象类 AbstractSet,里面当然必须实现自己的方法，他也可以实现一个私有类来返回这个类，但是他没有，可能考虑是 没必要重新声明一个类吧；
	 * values	是一个 Collection<E>
	 * 
	 */
	public static void testMap(){
		Map map = new HashMap<String, String>();
		Object obj = map.put("1", 1);
		Object obj2 = map.put("1", "2");
		System.out.println(obj);
		System.out.println(obj2);
		System.out.println(map.remove(3));
	}
	/**
	 * 	HashMap 实现用了 Entry ：｛key value next hash｝,put 的时候，先求 key的hash,再求bucketIndex，然后addEntry (hash,key ,value, bucketIndex)，取出 table[bucketIndex]，然后赋值 table[bucketIndex] = new Entry(hash,key ,value,e); 数组链表就实现了； 
	 * putForCreate() 有一个判空处理；
	 * isEmpty() 都是判断数组size是否=0；
	 * 由于实现是 数组+链表，nextEntry调用的是，index++，的Entry的next...一直往下挪到，相当于把 Entry 数组 拉平了；
	 * resize(size) 其实就是重新hash，新建entry[] 数组大小为size，然后把远 table里面的entry 的hash 和size 取新位置，然后put进去，即可；
	 */
	public static void testHashMap(){
		
	}
	/**
	 *  和 TreeSet一样，NavigableMap  SortedMap 继承；都包含 Comparator；
	 * 	 *************************
	 * 	著名的红黑树，艹，TreeSet就是用 TreeMap实现的；
	 * 		Entry{ key value left right parent color}
	 * 		只需要维持 root size 即可；
	 */
	public static void testTreeMap(){
		TreeMap treeMap;
	}
	/**
	 *  LinkedHashMap 很巧妙，= HashMap+Deque；初始化调用 HashMap 构造函数，而hashmap构造函数调用了 空方法 init();
	 *   而 LinkedHashMap 重写了 init();
	 *   也没有重写 put 等方法，但是重写了 put 调用的 addEntry, createEntity 方法等；后给 after before 赋值；
	 * 
	 */
	public static void testLinkedHashMap(){
		LinkedHashMap map = new LinkedHashMap<String, String>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
		for(Map.Entry<String, String> entry : (Set<Map.Entry<String, String>>)map.entrySet()){
			System.out.println(entry.getKey() +":" +entry.getValue());
		}
	}
	/**
	 * 	线程安全
	 * 	其它没有什么特殊的；
	 */
	public static void testHashTable(){
		Hashtable hashtable = new Hashtable<String, String>();
		hashtable.put(null, null);
		for(Object obj :hashtable.entrySet()){
			
		}
	}
}
