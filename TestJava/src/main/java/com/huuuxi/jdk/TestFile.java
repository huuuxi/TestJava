package com.huuuxi.jdk;

import java.io.File;
import java.io.IOException;

/**
 * @author wyliujiangbin
 *
 *	File 类，文件系统，调用本地方法，native；使用的是 FileSystem fs；来处理；
 *	他的separater 是 fs 的值；
 *	而且 file的 list 查询等 都是 fs 调用的产物；
 *	当然，setRead Write等操作，需要经过 securityManage的管理；
 *	
 *	path : 就是路径；
 *	AbsolutePath ： 绝对路径
 *	CannocilPath : 规范路径
 *
 */
public class TestFile {

	private final static  String STR = "d://a.txt";
	public static void main(String[] args) {
		testFile();
	}
	
	public static void testFile(){
		File  file = new File(STR);
		System.out.println(file.getAbsolutePath());
		try {
			System.out.println(file.getCanonicalPath());
			File f = new File("../");
			System.out.println(f.getPath());
			System.out.println(f.getAbsolutePath());
			System.out.println(f.getCanonicalPath());
			System.out.println(TestFile.class.getResource(""));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
