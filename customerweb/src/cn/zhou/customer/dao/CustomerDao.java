package cn.zhou.customer.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.zhou.customer.domain.Customer;
import cn.zhou.utils.dbutils.QueryRunnerUtils;

public class CustomerDao {
	private QueryRunner qr = new QueryRunnerUtils();

	public void add(Customer c) {

		String sql = "insert into customer value(?,?,?,?,?,?,?)";
		Object[] parameters = { c.getId(), c.getName(), c.getGender(), c.getBirthday(), c.getPhonenumber(),
				c.getEmail(), c.getDescription() };
		try {
			qr.update(sql, parameters);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Customer> searchAll() {

		String sql = "select *from customer";
		try {
			return qr.query(sql, new BeanListHandler<Customer>(Customer.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
