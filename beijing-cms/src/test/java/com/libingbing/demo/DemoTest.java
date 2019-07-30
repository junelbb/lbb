package com.libingbing.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.libingbing.cms.domain.Article;
import com.libingbing.cms.service.ArticleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")

public class DemoTest {
	
	@Autowired
	ArticleService service;

	
	@Test
	public void test1(){
		System.out.println(1);
	}
	
	@Test
	public void test2(){
		List<Article> queryAll = service.queryAll(new Article());
		for (Article article : queryAll) {
			System.out.println(article.getTitle());
		}
	}
	
}
