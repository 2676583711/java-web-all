package cn.zhou.customer.service;

import java.util.List;

import cn.zhou.customer.dao.CustomerDao;
import cn.zhou.customer.domain.Customer;

public class CustomerService {

	private CustomerDao cs = new CustomerDao();

	public void add(Customer c) {
		cs.add(c);
	}

	public List<Customer> searchAll() {
		return cs.searchAll();
	}
}
