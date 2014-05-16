package com.huuuxi.apache.lang;

import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.commons.lang3.ArrayUtils;



public class TestArrays {

	
	public static void main(String[] args) {
		
	}
	
	public static void testArrays(){
		Boolean[] bs = new Boolean[]{true,false};
		/**
		 * add 很巧妙，先判断 初始数组是否为空，然后判断 index 是否大于length；
		 * 	然后 调用System的 arraycopy 两次，中间截取为index；
		 */
		bs = (Boolean[]) ArrayUtils.add(bs,1, new Boolean(true));
	}
}
