package connections_pool;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.jupiter.api.Test;

public class Demo1 {

	
	private BasicDataSource basicDataSource;

	@Test
	public void func1() throws SQLException {
		/*
		 * 使用 dbcp 连接池链接数据库
		 * 
		 * */
		
		basicDataSource = new BasicDataSource();
		
		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		basicDataSource.setUrl("jdbc:mysql://localhost:3306/zhou");
		basicDataSource.setUsername("root");
		basicDataSource.setPassword("zhou123");
		
		Connection con=basicDataSource.getConnection();
		
		
		//System.out.println(con);
		System.out.println(con.getClass().getName());
	
	
	
	}
}
