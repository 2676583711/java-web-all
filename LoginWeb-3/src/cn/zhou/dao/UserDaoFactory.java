package cn.zhou.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UserDaoFactory {

	private static Properties properties = null;

	
	/*Class.class.getClassLoader().getResourceAsStream(path); 
	 * 这个ｐａｔｈ使绝对路径
	 * 从ｃｌａｓｓｐａｔｈ下的ｓｒｃ木开始的绝对查询
	 * 
	 * 
	 * Class.class.getResourceAsStream(path);
	 * 这ｐａｔｈ是相对路径，相对与当前类所在的路径
	 * 
	 * */
	
	
	static {

		InputStream is = UserDaoFactory.class.getResourceAsStream("userdao.properties");

		try {
			// InputStream is =
			// UserDaoFactory.class.getClassLoader().getResourceAsStream("userdao.properties");
			properties = new Properties();
			properties.load(is);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static UserDao getUserDao() {

		try {
			String className = properties.getProperty("cn.zhou.dao.UserDao");

			Class clazz = Class.forName(className);

			return (UserDao) clazz.newInstance();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
