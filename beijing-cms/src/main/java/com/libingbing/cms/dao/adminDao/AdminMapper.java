package com.libingbing.cms.dao.adminDao;

import java.util.HashMap;
import java.util.List;

import com.libingbing.cms.domain.Article;
import com.libingbing.cms.domain.SpcialArticle;
import com.libingbing.cms.domain.User;

public interface AdminMapper {

	List<SpcialArticle> selectSpecial();

	SpcialArticle getSpecialById(Integer id);

	void saveSpeccial(SpcialArticle spcialArticle);

	void updateSpecial(SpcialArticle spcialArticle);

	SpcialArticle selectSpecial(Integer id);

	SpcialArticle selectSpecialById(Integer id);

	void addSpecialArticle(HashMap<String,Object> map);

	Article selectArticleByMiddleId(Integer id);

	void updateSpecialArticle(HashMap<String, Object> map);

	List<User> selectUsers();

}
