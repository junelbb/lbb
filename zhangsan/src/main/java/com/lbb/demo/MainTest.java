package com.lbb.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class MainTest {
	public static void main(String[] args) throws IOException {
		
		FileReader fileReader = new FileReader("D:/file.txt");
		BufferedReader reader = new BufferedReader(fileReader);
		
		String line = null;
		HashMap<String,Integer> map = new HashMap<String ,Integer>();
		//第一问
		Question1 question1 = new Question1();
		Question3 question3 = new Question3();
		while((line = reader.readLine()) != null){
			question1.realfun(line, map);
			
		}
		question3.realfun3(map);
		
		map.remove(null);
		for (String string : map.keySet()) {
			//System.out.println(string+"   ---->     "+map.get(string));
		}
		
		
		//第二问
		Question2 question2 = new Question2();
		//question2.realfun2(map);
		reader.close();
		
	}
}
