package com.libingbing.common.utils;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

//工具类，实现方法
public class AssertUtil {
	
	/**
	 * 
	 * @param condition 
	 * @param message
	 */
	public static void isTrue(boolean condition, String message){
		//断言为真
		if(condition){
			System.out.println("这是一个true");
		}else{
			throw new CRuntimeExcception(message);
		}
	}
	
	/**
	 * 
	 * @Title: isFalse 
	 * @Description: TODO
	 * @param condition
	 * @param message
	 * @return: void
	 */
	public static void isFalse(boolean condition, String message){
		//断言为假
		if(condition){
			throw new CRuntimeExcception(message);
		}else{
			System.out.println("这是一个false");
		}
	}
	
	/**
	 * 
	 * @Title: notNull 
	 * @Description: TODO
	 * @param obj
	 * @param message
	 * @return: void
	 */
	public static void notNull(Object obj, String message){
		//断言对象不为空
		if(obj != null){
			System.out.println("这是一个不为空的对象");
		}else{
			throw new CRuntimeExcception(message);
		}
		
	}
	
	/**
	 * 
	 * @Title: isNull 
	 * @Description: TODO
	 * @param obj
	 * @param message
	 * @return: void
	 */
	public static void isNull(Object obj, String message){
		//断言对象必须空
		if(obj != null){
			throw new CRuntimeExcception(message);
		}else{
			System.out.println("这是一个空对象");
		}
		
	}
	
	/**
	 * 
	 * @Title: notEmpty 
	 * @Description: TODO
	 * @param coll
	 * @param message
	 * @return: void
	 */
	public static void notEmpty(Collection<?> coll, String message){
		//断言集合对象不为空
		if(coll == null || coll.size()==0){
			throw new CRuntimeExcception(message);
		}else{
			System.out.println("这是一个不为空的集合对象");
		}
		
	}
	
	/**
	 * 
	 * @Title: notMapEmpty 
	 * @Description: TODO
	 * @param map
	 * @param message
	 * @return: void
	 */
	public static void notMapEmpty(Map<String ,Object> map, String message){
		//断言map集合不为空
		if(map == null || map.size()==0){
			throw new CRuntimeExcception(message);
		}else{
			System.out.println("这是一个不为空的map集合");
		}
	}
	
	/**
	 * 
	 * @Title: hasText 
	 * @Description: TODO
	 * @param condition
	 * @param message
	 * @return: void
	 */
	public static void hasText(String condition, String message){
		//断言字符串必须有值
		if(condition == "" || condition.trim().length()<=0){
			throw new CRuntimeExcception(message);
		}else{
			System.out.println("这是非空字符串");
		}
	}
	
	/**
	 * 
	 * @Title: greaterThanZero 
	 * @Description: TODO
	 * @param value
	 * @param message
	 * @return: void
	 */
	public static void greaterThanZero(BigDecimal value, String message){
		//断言值必须大于0
		int i = value.compareTo(new BigDecimal("0"));
		if(i<=0){
			throw new CRuntimeExcception(message);
		}else{
			System.out.println("这是一个大于0的值");
		}
	}
	
	
	
}
