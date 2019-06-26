package cn.zhou.batchedcommit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.zhou.jdbcutils.JdbcUtils;

public class Commit1 {

	public void updateMoney(Connection con,String name, int money) {
		try {
			//Connection con = JdbcUtils.getConnection();  //得到数据库连接

			String sql = "update account set money=money+? where name=?"; //写ｓｑｌ语句
			PreparedStatement prepare = con.prepareStatement(sql);
			
			prepare.setInt(1, money);
			prepare.setString(2, name);
			
			prepare.executeUpdate();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
