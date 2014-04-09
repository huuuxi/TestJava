package com.huuuxi.jdk;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author wyliujiangbin
 *	 JVM 三个 ClassLoader：bootstrap extend app 自定义；
 *	类加载：需要双亲托管，查询类的时候，由底到上查询；如果类字节码相同，加载器不同，也是不能够判断类相同的；
 *
 *	Tomcat 定义了自己的ClassLoader WebappClassLoader 和 StandardClassLoader
 */
public class TestClassLoader {

	public static void main(String[] args) {
		test();
	}
	
	public static void test(){
		TestClassLoader test = new TestClassLoader();
		ClassLoader loader = test.getClass().getClassLoader();
		while(loader != null){
			System.out.println(loader);
			loader = loader.getParent();
		}
		System.out.println(loader);
	}
}
/**
 * @author wyliujiangbin
 *	自定义 ClassLoader
 *	主要作用是 findClass() 方法；
 */
class MyClassLoader extends ClassLoader{
	public Class<?> findClass(String name) throws ClassNotFoundException{
		Class clazz = null;
		byte[]  clazzBuff = getClassData(name);
		if (clazzBuff == null) {
			throw new ClassNotFoundException();
		}
		clazz = defineClass(name, clazzBuff, 0, clazzBuff.length);
		return clazz;
	}
	public byte[] getClassData(String name){
		String rootName = "/"+name;
		InputStream in = null;
		try {
			URL url = new URL(rootName);
			byte[] buffer = new byte[1024*4];
			int len = -1;
			in = url.openStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			while ( (len = in.read(buffer) ) != -1) {
				baos.write(buffer, 0, len);
			}
			baos.toByteArray();
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
