package cn.zhou.transaction;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import cn.zhou.jdbcutils.transaction.TransactionUtils;
import cn.zhou.utils.dbutils.QueryRunnerUtils;

public class DaoTransaction {

	public void daoUpdate(String name, int money) throws SQLException {

		QueryRunner qr = new QueryRunnerUtils();

		String sql = "update account set money=money+? where name=?";

		Object[] obj = { money, name };

		Connection con = TransactionUtils.getConnection();

		qr.update(con, sql, obj);

	}

	@Test
	public void test1() throws SQLException {
		Connection con = TransactionUtils.getConnection();

		System.out.println(con);

	}
}
