package com.libingbing.cms.service.impl.AdminServiceImp;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libingbing.cms.dao.adminDao.AdminMapper;
import com.libingbing.cms.domain.Article;
import com.libingbing.cms.domain.SpcialArticle;
import com.libingbing.cms.domain.User;
import com.libingbing.cms.service.adminService.AdminService;

@Service
public class AdminServiecImp implements AdminService {

	@Autowired
	AdminMapper dao;

	@Override
	public List<SpcialArticle> selectSpecial() {
		// TODO Auto-generated method stub
		return dao.selectSpecial();
	}

	@Override
	public SpcialArticle getSpecialById(Integer id) {
		// TODO Auto-generated method stub
		return dao.getSpecialById(id);
	}

	@Override
	public void saveSpeccial(SpcialArticle spcialArticle) {
		// TODO Auto-generated method stub
		dao.saveSpeccial(spcialArticle);
	}

	@Override
	public void updateSpecial(SpcialArticle spcialArticle) {
		// TODO Auto-generated method stub
		dao.updateSpecial(spcialArticle);
	}

	@Override
	public SpcialArticle selectSpecialById(Integer id) {
		// TODO Auto-generated method stub
		return dao.selectSpecialById(id);
	}

	@Override
	public void addSpecialArticle(HashMap<String,Object> map) {
		// TODO Auto-generated method stub
		dao.addSpecialArticle(map);
	}

	@Override
	public Article selectArticleByMiddleId(Integer id) {
		// TODO Auto-generated method stub
		return dao.selectArticleByMiddleId(id);
	}

	@Override
	public void updateSpecialArticle(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		dao.updateSpecialArticle(map);
	}

	@Override
	public List<User> selectUsers() {
		// TODO Auto-generated method stub
		return dao.selectUsers();
	}

	
}
