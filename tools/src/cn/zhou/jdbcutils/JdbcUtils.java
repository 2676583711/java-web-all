package cn.zhou.jdbcutils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.jupiter.api.Test;


public class JdbcUtils {

	/*
	 * JdbcUtils version 1.0
	 * 
	 * 
	 * 1.写一个ｐｒｏｐｅｒｔｉｅｓ配置文件存放，数据库连接所需要的四大参数 
	 * ２．加载类读取配置文件 
	 * ３．根据配置文件所读取到的四大参数链接数据库
	 * 
	 */

	private static Properties properties = null;
	static {

		InputStream inputstream = JdbcUtils.class.getResourceAsStream("jdbc.properties");
		properties = new Properties();
		try {
			properties.load(inputstream);
			Class.forName(properties.getProperty("className"));

		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

	}

	public static Connection getConnection() throws SQLException {

		// InputStream inputstream =
		// JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");

		return (Connection) DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("username"), properties.getProperty("password"));

	}

	@Test
	public void test1() throws ClassNotFoundException, IOException, SQLException {
		Connection connection = JdbcUtils.getConnection();
		System.out.println(connection);

		String sql = "select *from user ";
		PreparedStatement preparedstatement = connection.prepareStatement(sql);
		ResultSet rs = preparedstatement.executeQuery();
		while (rs.next()) {
			String s1 = rs.getString("username");
			String s2 = rs.getString("password");

			System.out.println(s1 + ":" + s2);
		}
	}
}
