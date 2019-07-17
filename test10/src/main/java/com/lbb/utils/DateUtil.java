package com.lbb.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static Integer getAge(String date){
		
		String[] split = date.split("-");
		Integer year = Integer.parseInt(split[0]);
		Date date2 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String format = simpleDateFormat.format(date2);
		String[] split2 = format.split("-");
		int year2 = Integer.parseInt(split2[0]);
		Integer age = year2 - year;
		return age;
	}
	
	public static String getDateByMonthInit(String date){
		String[] split = date.split(" ");
		String y1 = split[0];
		String[] split2 = y1.split("-");
		String newDate = split2[0]+"-"+split2[1]+"-01";
		return newDate;
	}
	
	public static String getDateByMonthLast(String date){
		String newDate = "";
		String[] split = date.split(" ");
		String y1 = split[0];
		String[] split2 = y1.split("-");
		Integer m = Integer.parseInt(split2[1]);
		if(m==1||m==3||m==5||m==7||m==8||m==10||m==10){
			newDate = split2[0]+"-"+split2[1]+"-31";
		}else if(m==4||m==6||m==9||m==11){
			newDate = split2[0]+"-"+split2[1]+"-30";
		}else if(m==2){
			newDate = split2[0]+"-"+split2[1]+"-28";
		}
		return newDate;
	}
	
	public static Integer getDaysByFuture (String date){
		Date date2 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String format = simpleDateFormat.format(date2);
		String[] split = date.split("-");
		Integer dfy = Integer.parseInt(split[0]);
		Integer dfm = Integer.parseInt(split[1]);
		Integer dfd = Integer.parseInt(split[2]);
		String[] split2 = format.split("-");
		Integer dny = Integer.parseInt(split2[0]);
		Integer dnm = Integer.parseInt(split2[1]);
		Integer dnd = Integer.parseInt(split2[2]);

		Integer df = dfy*365+dfm*12+dfd*30;
		Integer dn = dny*365+dnm*12+dnd*30;
		Integer d = df-dn;
		return d;
	}
	
	public static Integer getDaysByDeparted  (String date){
		Date date2 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String format = simpleDateFormat.format(date2);
		String[] split = date.split("-");
		Integer dfy = Integer.parseInt(split[0]);
		Integer dfm = Integer.parseInt(split[1]);
		Integer dfd = Integer.parseInt(split[2]);
		String[] split2 = format.split("-");
		Integer dny = Integer.parseInt(split2[0]);
		Integer dnm = Integer.parseInt(split2[1]);
		Integer dnd = Integer.parseInt(split2[2]);

		Integer df = dfy*365+dfm*12+dfd*30;
		Integer dn = dny*365+dnm*12+dnd*30;
		Integer d = dn-df;
		return d;
	}
	
}
