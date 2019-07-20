/**
 * 
 */
package com.lbb.cms.web.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lbb.cms.core.Page;
import com.lbb.cms.domain.Article;
import com.lbb.cms.domain.Category;
import com.lbb.cms.domain.Channel;
import com.lbb.cms.domain.User;
import com.lbb.cms.service.ArticleService;
import com.lbb.cms.utils.FileUploadUtil;
import com.lbb.cms.utils.PageHelpUtil;
import com.lbb.cms.web.Constant;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2018年1月10日 下午2:40:38
 */
@Controller
@RequestMapping("/my")
public class UserController {

	@Autowired
	ArticleService articleService;
	
	@RequestMapping({"/", "/index", "/home"})
	public String home(){
		return "user-space/home";
	}
	
	@RequestMapping({"/profile"})
	public String profile(){
		return "user-space/profile";
	}

	@RequestMapping("/blogs")
	public String blogs(Model model, HttpSession session,
			@RequestParam(value="page",defaultValue="1")Integer page){
		Article article = new Article();
		//当前登录用户
		User user = (User) session.getAttribute(Constant.LOGIN_USER);
		
		article.setAuthor(user);
		//当前用户发布的所有文章
		List<Article> list = articleService.queryAll(article);
		
		//分页信息
		PageHelper.startPage(page, 3);
		PageInfo<Article> pageInfo = new PageInfo<Article>(list,3);
		String pageList = PageHelpUtil.page("blogs", pageInfo, null);
		
		//传入前台页面
		model.addAttribute("blogs", list);
		model.addAttribute("pageList", pageList);

		return "user-space/blog_list";
		
	}
	
	@RequestMapping("/blog/edit")
	public String edit(Integer id,Model model){
		
		Article article = articleService.selectByPrimaryKey(id);
		
		model.addAttribute("blog", article);
		
		return "user-space/blog_edit";
		
	}
	
	//修改和发布文章
	@RequestMapping("/blog/save")
	public String save(Model model,Article article,MultipartFile file,HttpServletRequest request){
		
		String upload = FileUploadUtil.upload(request, file);
		if(!upload.equals("")){
			article.setPicture(upload);
		}
		
		Integer id = article.getId();
		if(id != null){
			//修改文章
			articleService.updateByKey(article);
		}else{
			//发布文章
			article.setHits(0);//点击量设置为0
			article.setHot(true);//是否为热门文章
			article.setStatus(1);//设置是否通过审核
			article.setDeleted(false);//是否被删除
			article.setCreated(new Date());//文章发布时间
			
			User user = (User) request.getSession().getAttribute(Constant.LOGIN_USER);
			
			article.setAuthor(user);
			
			articleService.save(article);
			
		}
		
		return "redirect:/my/blogs";
		
	}
	
	//删除文章
	@RequestMapping("/blog/remove")
	@ResponseBody
	public Boolean remove(Model model,Integer id){
		articleService.removeArticle(id);//删除文章
		return true;
	}
	
	
}
