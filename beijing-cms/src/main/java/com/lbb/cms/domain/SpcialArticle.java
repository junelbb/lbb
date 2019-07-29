package com.lbb.cms.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author 李冰冰
 *
 */
public class SpcialArticle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**专题id**/
	private Integer id;
	
	/**专题名称**/
	private String title;
	
	/**专题简介**/
	private String abstr;
	
	/**专题创建时间**/
	private Date created;

	/**所包含文章**/
	private List<Article> articleList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAbstr() {
		return abstr;
	}

	public void setAbstr(String abstr) {
		this.abstr = abstr;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}

	public SpcialArticle(Integer id, String title, String abstr, Date created,
			List<Article> articleList) {
		super();
		this.id = id;
		this.title = title;
		this.abstr = abstr;
		this.created = created;
		this.articleList = articleList;
	}

	public SpcialArticle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
