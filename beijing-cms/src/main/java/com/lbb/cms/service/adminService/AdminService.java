package com.lbb.cms.service.adminService;

import java.util.HashMap;
import java.util.List;

import com.lbb.cms.domain.Article;
import com.lbb.cms.domain.SpcialArticle;
import com.lbb.cms.domain.User;

public interface AdminService {

	List<SpcialArticle> selectSpecial();

	SpcialArticle getSpecialById(Integer id);

	void saveSpeccial(SpcialArticle spcialArticle);

	void updateSpecial(SpcialArticle spcialArticle);

	SpcialArticle selectSpecialById(Integer id);

	void addSpecialArticle(HashMap<String,Object> map);

	Article selectArticleByMiddleId(Integer id);

	void updateSpecialArticle(HashMap<String, Object> map);

	List<User> selectUsers();

}
