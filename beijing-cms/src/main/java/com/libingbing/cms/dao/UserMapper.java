/**
 * 
 */
package com.libingbing.cms.dao;

import com.libingbing.cms.domain.User;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2018年1月10日 下午1:37:59
 */
public interface UserMapper {

	public void insert(User user);
	
	public void deleteById(int id);

	public User selectById(int id);

	public User selectByUsername(String username);

	public int count(User user);

	public void editAvatar(User user);

	public User selectUserByPrimaryKey(Integer id);

	public void saveUser(User user);
	
}
