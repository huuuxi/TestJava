package com.huuuxi.jdk;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class TestBuffer {

	public static void main(String[] args) {
		
	}
	/**
	 * Buffer 几个元素比较重要；
	 * 		mark		 和postion 配对使用，reset()会将 position重置为 mark
	 * 		position	buffer读写的开始位置
	 * 		limit		buffer读写 最大限制
	 * 		capacity		buffer的最大容量
	 *  对应的几个方法
	 *  	mark() 标志mark = position 标志mark
	 *  	reset() 标志 position = mark 返回mark标志
	 *  	rewind() 标志 position = 0；mark = -1;重置
	 *  	clear() 清除信息；limit = capacity ; mark = -1;position = 0;
	 *  	remaining() 返回剩余读取位置 limit - position
	 *  	flip() 将数据置为当前传输位置，读、写，都操作当前位置重置后；limit = position ; mark = -1; position = 0;
	 * 
	 */
	public static void testBuffer(){
		Buffer buffer;
	}
	/**
	 * ByteBuffer 里面 allocate ,wrap使用的是  HeapByteBuffer, HeapByteBuffer 继承了 ByteBuffer；
	 * 						allocateDirect 使用的是 DirectByteBuffer 继承 MappedByteBuffer 继承 ByteBuffer ；
	 *  相对 Buffer 增加了 byte[] hb 和 int offset  都是final;
	 *  	MappedByteBuffer 使用目标是  FileChinel ，自身不支持构造函数，用FileChannel.getMap()；
	 *  		作用是把文件映射到虚拟内存；
	 *  		force() Read_Write 模式下，将缓冲区内容强制写入文件；
	 *  		load() 把缓冲区内容加载到 内存；并返回缓冲的引用；
	 *  		isLoaded() 如果内容在物理内存返回真，否则假；
	 * 		调用map(),即可映射到内存，具有很好的有有点，读入快、写入快、随时读写；
	 * 	而其实现 DirectByteBuffer 中Direct的意思就是 直接，频繁操作native io.、要求低延时情况下用；
	 */
	public static void testByteBuffer(){
		ByteBuffer buffer ;
	}
}
