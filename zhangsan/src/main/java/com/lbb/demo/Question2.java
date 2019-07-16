package com.lbb.demo;

import java.util.HashMap;
import java.util.Iterator;

public class Question2 {
	public void realfun2(HashMap<String, Integer> map){
		
		for (String key : map.keySet()) {
			
			if((key.compareTo("a")>=0 && key.compareTo("z")<=0) || key.compareTo("A")>=0 && key.compareTo("Z")<=0){
				System.out.println(key+"------"+map.get(key));
			}
		}
		
		
		System.err.println("*****************");
		
		Iterator<String> iterator = map.keySet().iterator();
		while(iterator.hasNext()){
			String next = iterator.next();
			if((next.compareTo("a")>=0 && next.compareTo("z")<=0) || next.compareTo("A")>=0 && next.compareTo("Z")<=0){
				System.out.println(next+"------"+map.get(next));
			}
		}
		
	}
}
