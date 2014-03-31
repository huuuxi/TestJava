package com.huuuxi.jdk.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author admin
 *	@class Buffer 是nio里面的一个类；
 *	是nio缓冲的基础；
 *	两种类型的缓冲区，直接缓冲区和非直接缓冲区。
 *	判断一个缓冲区是否是直接缓冲区，可以调用isDirect()方法。 
 *
 * 这几个属性是每个缓冲区都有的并且是常用的操作。 
 *	a. 容量(capacity),缓冲区大小 
 *	b. 限制(limit),第一个不应被读取或写入的字节的索引，总是小于容量。 
 *	c. 位置(position)，下一个被读取或写入的字节的索引，总是小于限制。 
 *	d. clear()方法：设置limit为capacity，position为0。 
 * 	e. filp()方法：设置limit为当前position，然后设置position为0。 
 *	f. rewind()方法：保持limit不变，设置position为0。 
 *
 *	MappedByteBuffer
 */
public class TestBuffer {

	public static void main(String[] args) {
		//testBuffers();
		testTheBuffer();
	}
	public static void testBuffers(){
		// 非直接缓存，allocateDriect()直接缓存；
		ByteBuffer  byteBuffer = ByteBuffer.allocate(100);
		for (int i = 0; i < 100; i++) {
			byte b = (byte) (Math.random()*100);
			byteBuffer.put(b);
		}
		System.out.println("写入了缓冲区");
		byteBuffer.flip();
		while (byteBuffer.hasRemaining()) {
			System.out.print(byteBuffer.get()+" ");
		}
		System.out.println();
		try {
			FileChannel channel = new FileOutputStream("output.txt").getChannel();
			byteBuffer.flip();
			channel.write(byteBuffer);
			channel.force(true);
			channel.close();
			byteBuffer = null;
			channel = null;
			
			channel = new FileInputStream("output.txt").getChannel();
			ByteBuffer bf2 = ByteBuffer.allocate((int)channel.size());
			channel.read(bf2);
			System.out.println("读取到了缓存：");
			bf2.flip();
			while(bf2.hasRemaining())
				System.out.print(bf2.get()+" ");
			System.out.println();
			channel.close();
			channel = null;
			bf2 = null;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void testTheBuffer(){
		ByteBuffer bf = ByteBuffer.allocate(10);
		for(int i=1;i<9 ;i++){
			bf.put((byte) i);
		}
		
		System.out.println("capacity:"+bf.capacity());
		System.out.println("limit:"+bf.limit());
		System.out.println("position:"+bf.position());
		
		bf.flip();
		System.out.println("after flip:");
		System.out.println("capacity:"+bf.capacity());
		System.out.println("limit:"+bf.limit());
		System.out.println("position:"+bf.position());
		
		bf.mark();
		System.out.println("after mark:");
		System.out.println("capacity:"+bf.capacity());
		System.out.println("limit:"+bf.limit());
		System.out.println("position:"+bf.position());
		
		bf.reset();
		System.out.println("after reset:");
		System.out.println("capacity:"+bf.capacity());
		System.out.println("limit:"+bf.limit());
		System.out.println("position:"+bf.position());
		
		bf.clear();
		System.out.println("after clear:");
		System.out.println("capacity:"+bf.capacity());
		System.out.println("limit:"+bf.limit());
		System.out.println("position:"+bf.position());
		
		bf.limit(1);
		bf.put((byte) 9);;//超出limit范围，抛出java.nio.BufferOverflowException异常  
		bf.put((byte) 10);
	}
}
