package cn.zhou.service;

import org.junit.jupiter.api.Test;

import cn.zhou.dao.UserDao;
import cn.zhou.dao.UserDaoFactory;
import cn.zhou.domain.User;

public class UserService {
	private UserDao userDao = UserDaoFactory.getUserDao();

	public void regist(User user) throws UserException {

		User u = userDao.findByUsername(user.getUsername());

		if (u != null)
			throw new UserException("该用户名:" + user.getUsername() + "已经被注册过了!!!");

		userDao.addUser(user);
	}

	public User Login(User user) throws UserException {

		User u = userDao.findByUsername(user.getUsername());
		if (u == null)
			throw new UserException("用户名或密码错误!!!");
		if (!user.getPassword().equals(u.getPassword()))
			throw new UserException("密码错误!");

		return user;

	}
	
	
	
	@Test
	public void test1() {
		System.out.println(userDao);
	}

}
