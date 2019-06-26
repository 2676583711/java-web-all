package cn.zhou.batchedcommit;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import cn.zhou.jdbcutils.JdbcUtils;

public class ServiceJdbc {
	

	public void transform(String from, String to, int money) throws ClassNotFoundException {
		Connection con = null;

		try {

			 con = JdbcUtils.getConnection();

			System.out.println(con);

//			con.setAutoCommit(false);
//
//			Commit1 c = new Commit1();
//
//			c.updateMoney(con, from, -100);
//			c.updateMoney(con, to, 100);
//
//			con.commit();
//			con.close();
			
			
		} catch (SQLException e) {
//
//			try {
//				con.rollback();
//				con.close();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			throw new RuntimeException(e);
		}

	}

	@Test
	public void test1(String[] aers) throws ClassNotFoundException {
		transform("tom", "jim", 100);
	}

	
	
}
