/**
 * 
 */
package com.libingbing.cms.web.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONArray;
import com.libingbing.cms.core.Page;
import com.libingbing.cms.domain.Article;
import com.libingbing.cms.domain.Category;
import com.libingbing.cms.domain.Channel;
import com.libingbing.cms.domain.Picture;
import com.libingbing.cms.domain.Slide;
import com.libingbing.cms.domain.SpcialArticle;
import com.libingbing.cms.service.ArticleService;
import com.libingbing.cms.service.SlideService;

/**
 * 说明:首页
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2018年1月10日 下午8:19:15
 */
@Controller
public class HomeController {

	@Resource
	private ArticleService articleService;
	
	@Resource
	private SlideService slideService;
	
	@RequestMapping({"/", "/index", "/home"})
	public String home(
			@RequestParam(required = false) Integer channel, //频道
			@RequestParam(required = false) Integer category,//分类
			@RequestParam(defaultValue = "1") Integer page,//分类
			Model model){
		
		//------------------------------------
		
		//拼条件
		Article conditions = new Article();
		conditions.setDeleted(false);
		conditions.setStatus(1);

		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//默认首页显示热门文章
				if(category == null && channel == null){
					conditions.setHot(true);
					
					//热门文章时显示幻灯片
					List<Slide> slides = slideService.getTops(5);
					model.addAttribute("slides", slides);
				}
			}
		});
		
		Thread t2 =new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//如果频道或分类不为空，则显示分类或频道数据
				List<Article> articles = null;
				Page _page = new Page(page, 30);
				if(category != null){
					conditions.setCategory(new Category(category));
				}else if(channel != null){
					conditions.setChannel(new Channel(channel));
				}
				articles = articleService.gets(conditions, _page, null);
				model.addAttribute("articles", articles);
			}
		});
			
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//---------------右侧放10条最新文章---------------------
				Article lastArticlesConditions = new Article();
				lastArticlesConditions.setDeleted(false);
				lastArticlesConditions.setStatus(1);
				
				Page lastArticlesPage = new Page(1, 10);
				lastArticlesPage.setTotalCount(100);//设置了总记录数，可以节省统计查询，提高性能。
				
				List<Article> lastArticles = articleService.gets(lastArticlesConditions, lastArticlesPage, null);
				model.addAttribute("lastArticles", lastArticles);

				if(channel != null){
					model.addAttribute("channel", new Channel(channel));
				}
				model.addAttribute("category", category);
			}
		});

		
		Thread t4 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//---------------右侧放专题文章---------------------
				
				Article specileArticle = new Article();
				specileArticle.setDeleted(false);
				specileArticle.setStatus(1);
				
				Page specialPage = new Page(1, 2);
				specialPage.setTotalCount(20);
				
				List<SpcialArticle> spcialArticles = articleService.getSpcial(specileArticle, specialPage, null);
				model.addAttribute("spcialArticles", spcialArticles);
			}
		});
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "home";
	}
	
	@RequestMapping("/article")
	public String article(Integer id,Model model){
		
		articleService.increaseHit(id);
		Article article = articleService.selectByPrimaryKey(id);
		if(article.getContent()!=null && article.getContent().length()>0){
			List<Picture> parseArray = JSONArray.parseArray(article.getContent(), Picture.class);
			model.addAttribute("parseArray", parseArray);
		}
		model.addAttribute("blog", article);
		return "blog";
	}
	

}
