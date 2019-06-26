package cn.zhou.c3p0utils;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Utils {

	// private static Properties properties = null;
	private static ComboPooledDataSource cpds = null;

	// 加载连接池的配置文件
	static {
		InputStream is = C3p0Utils.class.getResourceAsStream("c3p0.properties");
		Properties properties = new Properties();
		cpds = new ComboPooledDataSource();
		try {
			properties.load(is);

			String driverClassName = properties.getProperty("driverClassName");
			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");

			cpds.setDriverClass(driverClassName); // 设置连接池的四大参数
			cpds.setJdbcUrl(url);
			cpds.setUser(username);
			cpds.setPassword(password);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Connection getConnection() {

		try {
			return cpds.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public DataSource getDataSource() {

		return cpds;
	}

}
