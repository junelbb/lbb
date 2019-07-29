package com.lbb.demo;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lbb.cms.domain.Article;
import com.lbb.cms.domain.SpcialArticle;
import com.lbb.cms.service.adminService.AdminService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-context.xml")

public class DemoTest {
	
	@Autowired
	AdminService service;

	@Test
	public void test1(){
		SpcialArticle specialById = service.getSpecialById(1);
		List<Article> articleList = specialById.getArticleList();
		for (Article article : articleList) {
			System.out.println(article.getTitle());
/*			Date created = article.getCreated();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:MM:ss");
			String format = simpleDateFormat.format(created);
			System.out.println(format);*/
		}
	}
	
	@Test
	public void test2(){
		List<SpcialArticle> selectSpecial = service.selectSpecial();
		for (SpcialArticle spcialArticle : selectSpecial) {
			System.out.println(spcialArticle.getTitle());
		}
	}
	
	@Test
	public void test3(){
		SpcialArticle selectSpecialById = service.selectSpecialById(2);
		List<Article> articleList = selectSpecialById.getArticleList();
		for (Article article : articleList) {
			System.out.println(article.getTitle());
		}
	}
	
	
}
