package cn.zhou.transaction;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import cn.zhou.jdbcutils.transaction.TransactionUtils;

public class Demo01 {

	private DaoTransaction dt = new DaoTransaction();

	@Test
	public void test1() {

		try {
			TransactionUtils.beginTransaction();

			dt.daoUpdate("tom", -500);
			dt.daoUpdate("jim", 500);

			TransactionUtils.commitTransaction();
		//	throw new RuntimeException("");

		} catch (SQLException e) {
			try {
				TransactionUtils.rollbackTransaction();

			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			e.printStackTrace();
		}

	}

}
