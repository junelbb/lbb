package com.lbb.cms.service;

import com.lbb.cms.domain.User;


/**
 * 说明: 用户服务
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年3月27日 下午1:12:48
 */
public interface UserService {

	public abstract User get(int id);

	public abstract User get(String username);

	public int count(User user);

	public abstract void editAvatar(User user);

	public abstract User selectUserByPrimaryKey(Integer id);

	public abstract void saveUser(User user);
}