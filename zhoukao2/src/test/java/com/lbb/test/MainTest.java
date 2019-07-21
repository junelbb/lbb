package com.lbb.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import com.libingbing.common.utils.AssertUtil;
import com.libingbing.common.utils.CRuntimeExcception;

//测试类
public class MainTest {

	@Test//断言为真
	public void isTrue(){
		try {
			AssertUtil.isTrue(true, "这是一个假的值");
		} catch (CRuntimeExcception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test//断言为假
	public void isFalse(){
		try {
			AssertUtil.isFalse(false, "这是一个真的值");
		} catch (CRuntimeExcception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test//断言为对象不为空
	public void notNull(){
		try {
			Object obj = null;
			AssertUtil.notNull(obj, "这是一个空的对象");
		} catch (CRuntimeExcception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test//断言为对象必须空
	public void isNull(){
		try {
			Object obj = "123";
			AssertUtil.isNull(obj, "这不是一个空的对象");
		} catch (CRuntimeExcception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test//断言为集合不为空
	public void notEmpty(){
		try {
			ArrayList<Integer> list = new ArrayList<Integer>();
			//list.add(1);
			AssertUtil.notEmpty(list, "这是一个空的集合对象");
		} catch (CRuntimeExcception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	@Test//断言为map集合不为空
	public void notMapEmpty(){
		try {
			HashMap<String,Object> map = new HashMap<String ,Object>();
			//map.put("1", 1);
			AssertUtil.notMapEmpty(map, "这是一个空的map集合");
		} catch (CRuntimeExcception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test//断言字符串必须有值
	public void hasText(){
		try {
			//String str = "  1 ";
			String str = "   ";
			AssertUtil.hasText(str, "这是一个空的字符串");
		} catch (CRuntimeExcception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test//断言值必须大于0
	public void greaterThanZero(){
		try {
			//BigDecimal decimal = new BigDecimal("0");
			BigDecimal decimal = new BigDecimal("1");
			AssertUtil.greaterThanZero(decimal, "这不是一个大于0的值");
		} catch (CRuntimeExcception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void strlength(){
		try {
			//BigDecimal decimal = new BigDecimal("0");
			AssertUtil.strlength("", "字符串应该大于0");
		} catch (CRuntimeExcception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
