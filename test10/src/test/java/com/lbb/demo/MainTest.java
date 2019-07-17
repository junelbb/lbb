package com.lbb.demo;


import java.util.Date;

import org.junit.Test;

import com.lbb.utils.DateUtil;

public class MainTest {
	
	@Test//根据传入日期获得年龄
	public void fun1(){
		
		String date = "2001-1-6";
		
		Integer age = DateUtil.getAge(date);
		
		System.out.println("你的年龄是:"+age+"岁");
		
	}
	
	//根据传入的参数获取该日期的月初日期
	@Test
	public void fun2(){
		String date = "2018-07-19 23:55:23";
		
		String dateByMonthInit = DateUtil.getDateByMonthInit(date);
		System.out.println(dateByMonthInit);
	}
	
	
	@Test//根据传入的参数获取该日器的月末日期
	public void fun3(){
		String date = "2018-02-19 23:55:23";
		
		String dateByMonthInit = DateUtil.getDateByMonthLast(date);
		System.out.println(dateByMonthInit);
	}
	
	@Test//求未来日期离今天还剩的天数
	public void fun4(){
		String date = "2021-07-19";
		Integer daysByFuture = DateUtil.getDaysByFuture(date);
		System.out.println(daysByFuture);
	}
	
	@Test//求过去日期离今天过去的天数
	public void fun5(){
		String date = "2011-07-19";
		Integer daysByFuture = DateUtil.getDaysByDeparted (date);
		System.out.println(daysByFuture);
	}
	
}
