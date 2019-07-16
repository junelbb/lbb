package com.lbb.demo;

import java.util.HashMap;

public class Question3 {
	public void realfun3(HashMap<String, Integer> map){
		for (String key : map.keySet()) {
			if(map.get(key)>=3){
				System.out.println(key);
			}
		}
	}
}
