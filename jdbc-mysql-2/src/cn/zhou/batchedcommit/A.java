package cn.zhou.batchedcommit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import cn.zhou.jdbcutils.JdbcUtils;



public class A {

	@Test
	public void test1() throws SQLException {

		
		Connection con=JdbcUtils.getConnection();
		System.out.println(con);

		
		
		String sql="insert into account values(?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, null);
		ps.setString(2, "zip");
		ps.setInt(3, 2500);
		ps.executeUpdate();
		
		
		
	}
	
	
	@Test
	public void test2() throws SQLException {
		
		
		Connection con = JdbcUtils.getConnection( );

		System.out.println(con);

		String sql = "insert into student values(?,?,?,?)";
		PreparedStatement prepared = con.prepareStatement(sql);

		for (int i = 0; i < 10000; i++) {
			prepared.setInt(1, i + i + i);
			prepared.setString(2, "stu" + i);
			prepared.setInt(3, i);
			prepared.setString(4, i % 2 == 0 ? "男" : "女");
			prepared.addBatch();
		}
		
		long start = System.currentTimeMillis();
		prepared.executeBatch(); // 执行批
		long end = System.currentTimeMillis();

		System.out.println(end - start);   //34149       
	  }


}
