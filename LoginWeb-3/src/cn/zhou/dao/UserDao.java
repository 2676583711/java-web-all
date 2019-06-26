package cn.zhou.dao;

import cn.zhou.domain.User;

public interface UserDao {

	public User findByUsername(String username);
	public void addUser(User user);
	
}
