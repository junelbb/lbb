package com.lbb.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class StreamUtil {
	
	public static void closeAll(Closeable... closeables) throws IOException{
		//批量关闭流对象
		for (Closeable closeable : closeables) {
			closeable.close();
		}
		
	}
	
	public static void copy(InputStream src, OutputStream out, boolean isCloseInputStream, boolean isCloseOutputStream) throws IOException{
		//拷贝流，将InputStream流拷到OutputStream，可以用于快速读与文件、上传下载，为了提高性能，需要使用缓冲。
		BufferedInputStream bufferedInputStream = new BufferedInputStream(src);
		
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(out);
		
		bufferedInputStream.close();
		
		bufferedOutputStream.close();
		
	}
	
	
	public static void readTextFile(InputStream src) throws IOException{
		
		
		BufferedInputStream bufferedInputStream = new BufferedInputStream(src);
		InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream);
		
		Integer str = null;
		while((str = bufferedInputStream.read()) != -1){
			System.out.println(str);
		}
		
		//调用第一个方法关闭流
		closeAll(src,bufferedInputStream);
	}
	
	
	public static void readTextFile1(File file) throws IOException{
		FileInputStream fileInputStream = new FileInputStream(file);
		readTextFile(fileInputStream);
	}
	
	public static void readName(String name){
		String[] split = name.split("");
		for (String string : split) {
			System.out.println(string);
		}
	}
	
	public static int readAge(String age){
		int parseInt = Integer.parseInt(age);
		if(parseInt>0){
			return parseInt;
		}else{
			return -1;
		}
	}
	
	
}
