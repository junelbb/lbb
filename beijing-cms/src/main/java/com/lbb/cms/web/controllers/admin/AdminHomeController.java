/**
 * 
 */
package com.lbb.cms.web.controllers.admin;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lbb.cms.domain.Article;
import com.lbb.cms.domain.SpcialArticle;
import com.lbb.cms.domain.User;
import com.lbb.cms.service.adminService.AdminService;
import com.lbb.cms.web.controllers.PassportController;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年3月29日 下午6:54:11
 */
@Controller
@RequestMapping("/admin")
public class AdminHomeController {

	
	public static Logger log = LoggerFactory.getLogger(PassportController.class);
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping({"/", "/index"})
	public String home(){
		return "admin/home";
	}
	
	/**文章管理**/
	@RequestMapping("categories")
	public String categories(){
		return "admin/articleManage";
	}
	
	/**文章管理--专题管理**/
	@RequestMapping("specialArticle")
	public String specialArticle(Model model){
		List<SpcialArticle> spcialArticles = adminService.selectSpecial();
		model.addAttribute("spcialArticles", spcialArticles);
		return "admin/specialArticle";
	}
	
	/**修改专题进行回显**/
	@RequestMapping("toUpdateSpecial")
	public String updateSpecial(Model model,Integer id){
		SpcialArticle spcialArticle = adminService.getSpecialById(id);
		model.addAttribute("spcialArticle", spcialArticle);
		return "admin/updateSpecial";
	}
	
	/**跳转至添加界面**/
	@RequestMapping("toAddSpecial")
	public String toAddSpecial(){
		return "admin/insertSpecial";
	}
	
	
	/**修改或者添加专题**/
	@RequestMapping("saveSpecial")
	public String saveSpeccial(SpcialArticle spcialArticle){
		if(spcialArticle.getId()!=null){
			adminService.updateSpecial(spcialArticle);
		}else{
			spcialArticle.setCreated(new Date());
			adminService.saveSpeccial(spcialArticle);
		}
		return "redirect:/admin/specialArticle";
	}
	
	/**追加文章**/
	@RequestMapping("setArticle")
	public String setArticle(Integer id,Model model){
		SpcialArticle spcialArticle = adminService.selectSpecialById(id);
		model.addAttribute("sid", id);
		model.addAttribute("spcialArticle", spcialArticle);
		return "admin/setArticle";
	}
	
	/**向标题内添加文章**/
	@RequestMapping("addSpecialArticle")
	public String addSpecialArticle(Integer id,Integer sid,Model model){
		HashMap<String,Object> map = new HashMap<String ,Object>();
		map.put("aid", id);
		map.put("sid", sid);
		Article artcleArticle = adminService.selectArticleByMiddleId(id);
		if(artcleArticle!=null){
			adminService.updateSpecialArticle(map);
		}else{
			//adminService.addSpecialArticle(map);
		}
		return "redirect:/admin/specialArticle";
	}
	
	
	@RequestMapping("userEdit")
	public String userEdit(Model model){
		List<User> userList = adminService.selectUsers();
		model.addAttribute("userList", userList);
		return "admin/user-manage";
	}
	
}
