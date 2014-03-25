package com.huuuxi.jdk.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Multiset;

/**
 * @author admin
 * Guava is Google Collections extents
 * http://www.ibm.com/developerworks/cn/java/j-lo-googlecollection/
 * ImmutableSet
 * MultiSet
 * MultiMap
 * BiMap	双向map
 * MapMaker	应该说牛逼到一定程度拉；
 */
public class TestGoogleGuava {

	/**
	 * 使用的是默认的collections的不可变set，但是set的引用还是可以变的；
	 */
	public static void testImmutableSet(){
		Set<String> strs = new HashSet<String>();
		strs.add("a");
		strs.add("b");
		Set<String> immutableSet =  Collections.unmodifiableSet(strs);
		try {
			immutableSet.add("c");
		} catch (Exception e) {
			e.printStackTrace();
		}
		showSet(strs);
		showSet(immutableSet);
		strs.add("d");
		showSet(strs);
		showSet(immutableSet);
	}
	/**
	 * guava ImmutableSet
	 * builder 模式可以建造
	 */
	public static void testImmutableSet2(){
		Set<String> strs = new HashSet<String>();
		strs.add("a");
		strs.add("b");
		ImmutableSet<String> immutableSet = ImmutableSet.copyOf(strs);
		//Builder<String> builder = ImmutableSet.builder();
		try {
			immutableSet.add("c");
		} catch (Exception e) {
			e.printStackTrace();
		}
		showSet(strs);
		showSet(immutableSet);
		strs.add("d");
		showSet(strs);
		showSet(immutableSet);
	}
	
	/**
	 * Multiset 并没有实现 java.util.Set 接口，它更像是一个 Bag。普通的 Set 就像这样 :[car, ship, bike]，而 Multiset 会是这样 : [car x 2, ship x 6, bike x 3]。
	 */
	public static void testMultiSet(){
		String[]  strs = new String[]{"aaa","bbb","ccc","bbb","ccc","ccc"};
		List list = Arrays.asList(strs);
		Multiset<String> multiset = HashMultiset.create();
		multiset.addAll(list);
		System.out.println(multiset.count("aaa"));
		System.out.println(multiset.count("bbb"));
		System.out.println(multiset.count("ccc"));
	}
	
	public static void main(String[] args) {
		//testImmutableSet();
		//testImmutableSet2();
		testMultiSet();
		MapMaker mapMaker = new MapMaker();
	}
	
	
	public static void showSet(Set<?> set){
		for(Object obj : set){
			System.out.println(obj.toString());
		}
		System.out.println("-------------------");
	}
	
	
}
