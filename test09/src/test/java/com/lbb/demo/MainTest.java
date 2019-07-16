package com.lbb.demo;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

import com.lbb.utils.StreamUtil;

public class MainTest {
	public static void main(String[] args) throws IOException {
		
		
		
		
		
	}
	
	@Test
	public void fun1() throws IOException {
		//创建流对象
		FileInputStream fileInputStream = new FileInputStream("D:/file.txt");
		BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("D:/file.txt"));
		//传入流对象，实现批量关闭流
		StreamUtil.closeAll(fileInputStream,bufferedInputStream);
	}
	
	
	@Test
	public void fun2() throws IOException{
		File file = new File("D:/file.txt");
		
		FileInputStream fileInputStream = new FileInputStream(file);
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		
		boolean isCloseInputStream = false;
		boolean isCloseOutputStream = false;
		StreamUtil.copy(fileInputStream, fileOutputStream, isCloseInputStream, isCloseOutputStream);
	}
	
	@Test
	public void fun3() throws IOException{
		File file = new File("D:/123.txt");
		FileInputStream fileInputStream = new FileInputStream(file);
		StreamUtil.readTextFile(fileInputStream);
		
	}
	
	
	@Test
	public void fun4() throws IOException{
		File file = new File("D:/123.txt");
		StreamUtil.readTextFile1(file);
	}
	
	@Test
	public void fun5(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入你的姓名:");
		String name = scanner.next();
		StreamUtil.readName(name);
		
	}
	
	@Test
	public void fun6(){
		Scanner scanner = new Scanner(System.in);
		Integer integer = -1;
		while(integer<0){
			System.out.println("请输入你的年龄:");
			String age = scanner.next();
			integer = StreamUtil.readAge(age);
		}
		System.out.println(integer);
	}
	
}
