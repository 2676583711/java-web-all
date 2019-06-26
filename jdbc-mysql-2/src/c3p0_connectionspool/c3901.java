package c3p0_connectionspool;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cn.zhou.c3p0utils.C3p0Utils;

public class c3901 {

	@Test
	public void test1() throws PropertyVetoException, SQLException {

		ComboPooledDataSource cpds = new ComboPooledDataSource();

		/*
		 * driverClassName=com.mysql.jdbc.Driver
		 *  url=jdbc:mysql://localhost:3306/zhou
		 * username=root 
		 * password=zhou123
		 */

		// 连接数据库的四大参数的配置
		cpds.setDriverClass("com.mysql.jdbc.Driver");
		cpds.setJdbcUrl("jdbc:mysql://localhost:3306/zhou");
		cpds.setUser("root");
		cpds.setPassword("zhou123");

		// 数据库连接池的参数配置

		cpds.setInitialPoolSize(20); // 初始产生的链接数量为２０
		cpds.setAcquireIncrement(5); // 每次增长的数量为５个
		cpds.setMinPoolSize(3);
		cpds.setMaxPoolSize(50);

		Connection con = cpds.getConnection();
		System.out.println(con);

		cpds.close();

	}

	
	@Test
	public void test2() throws SQLException {
		C3p0Utils ct = new C3p0Utils();
		Connection con = ct.getConnection();

		System.out.println(con);
		con.close();
	}

}
