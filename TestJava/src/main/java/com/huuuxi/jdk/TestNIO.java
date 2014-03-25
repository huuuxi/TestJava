package com.huuuxi.jdk;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author wyliujiangbin
 *	NIO 使用一般是 网络or文件
 *	NIO 添加了 ByteBuffer Channel Selector
 */
public class TestNIO {

	/**
	 * @throws IOException
	 * ServerSocketChannel
	 * nio 网络编程
	 */
	public static void testServerSocketChannel() throws IOException{
		ServerSocketChannel channel = ServerSocketChannel.open();
		channel.socket().bind(new InetSocketAddress(9999));
		// 设置非阻塞
		channel.configureBlocking(false);
		//Selector的使用
		Selector selector = Selector.open();
		//SelectionKey 可以是多个值；
		SelectionKey selectionKey = channel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
		// 获取 Channel 和 Selector
		Selector sel = selectionKey.selector();
		Channel chan = selectionKey.channel();
		while(true){
			// select()方法会阻塞，selectNow()不会；
			// 只返回了可选的数字，需要变量 SelectionKeys
			int readyChannals = selector.select();
			selector.select();
			selector.select(1000);
			selector.selectNow();
			if (readyChannals == 0) {
				continue;
			}
			// selector遍历
			Set selectionKeys =  selector.selectedKeys();
			Iterator<SelectionKey> iterator = selectionKeys.iterator();
			while(iterator.hasNext()){
				SelectionKey key = iterator.next();
				if (key.isAcceptable()) {
					// do something...
					//scatter 分散使用
					//gather 集中使用
					FileChannel fileChannel = new RandomAccessFile("c://t.txt", "rw").getChannel();
					ByteBuffer header = ByteBuffer.allocate(128);
					ByteBuffer body = ByteBuffer.allocate(256);
					ByteBuffer[] buffers = new ByteBuffer[]{header , body};
					fileChannel.read(buffers);
					fileChannel.write(buffers);
				}
				if (key.isReadable()) {
					// do something...
				}
				//....
				// 注意每次迭代末尾的keyIterator.remove()调用。Selector不会自己从已选择键集中移除SelectionKey实例。必须在处理完通道时自己移除。下次该通道变成就绪时，Selector会再次将其放入已选择键集中。
				iterator.remove();
			}
			break;
		}
		
		while (true) {
			// 非阻塞模式下，accept()会直接返回，如果没有为 null;
			SocketChannel sc = channel.accept();
			if (sc != null) {
				//....
			}
			
		}
	}
	/**
	 * IO信息
	 */
	public static void testServerSocket(){
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(9999);
			while(true){
				Socket socket = serverSocket.accept();
				InputStream inputStream = socket.getInputStream();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
