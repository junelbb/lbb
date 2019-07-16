package com.lbb.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Question1 {
	public void realfun(String line,HashMap<String, Integer> map){
		
		char[] charArray = line.toCharArray();
		
		for (char c : charArray) {
			String string = String.valueOf(c);
			if(map.containsKey(string)){
				Integer char_count = map.get(string)+1;
				map.put(string, char_count);
			}else{
				map.put(string, 1);
			}
		}
	}
}
