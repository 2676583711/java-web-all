package cn.zhou.jdbcutils.transaction;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TransactionUtils {
	private static Properties properties = null;

	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

	private static ComboPooledDataSource cpds = null;
	static {
		InputStream is = TransactionUtils.class.getResourceAsStream("transaction.properties");
		properties = new Properties();

		try {
			properties.load(is);

			// con = cu.getConnection();
			cpds = new ComboPooledDataSource(); // 得到ｃ３ｐ０连接池对象

			// 设置连接数据库的四大参数:
			cpds.setDriverClass(properties.getProperty("driverClassName"));
			cpds.setJdbcUrl(properties.getProperty("url"));
			cpds.setUser(properties.getProperty("username"));
			cpds.setPassword(properties.getProperty("password"));

			// 得到链接对象
			// con = cpds.getConnection();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	@Test
	public void test1() {
		System.out.println(tl.get());
		System.out.println(cpds);

	}

	public static Connection getConnection() throws SQLException {
		Connection con = tl.get();
		if (con != null)
			return con;

		return cpds.getConnection();

	}

	public static DataSource getDataSource() {

		return cpds;
	}

	public static void beginTransaction() throws SQLException {
		Connection con = tl.get();

		if (con != null)
			throw new SQLException("事务已经开启,不要重复开启!");
		con = getConnection();
		con.setAutoCommit(false);

	}

	public static void commitTransaction() throws SQLException {
		Connection con = tl.get();

		if (con == null)
			throw new SQLException("事务没有开启,无法提交!");

		con.commit();
		con.close();
		con = null;
		tl.remove();
	}

	public static void rollbackTransaction() throws SQLException {
		Connection con = tl.get();

		if (con == null)
			throw new SQLException("事务没有开启,无法回滚!");

		con.rollback();
		con.close();
		tl.remove();;
	}

	public static void closeConnection(Connection c) throws SQLException {
		Connection con = tl.get();

		if (con == null)
			c.close(); // 判断所传递过来的链接是不是事务，若不是则直接关闭此连接；

		if (con != c)
			c.close();  // 判断所传递的连接与事务连接是否相同，不同也关闭；
	}
}
