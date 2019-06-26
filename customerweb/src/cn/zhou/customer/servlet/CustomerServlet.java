package cn.zhou.customer.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import cn.zhou.baseservlet.BaseServlet;
import cn.zhou.commonsutils.CommonUtils;
import cn.zhou.customer.domain.Customer;
import cn.zhou.customer.service.CustomerService;

/**
 * Servlet implementation class CustomerServlet
 */

public class CustomerServlet extends BaseServlet {

	private CustomerService cs = new CustomerService();

	public String searchAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Customer> list = cs.searchAll();
		request.setAttribute("list", list);
		return "f:/jsp/search.jsp";
	}

	public String addCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, IllegalAccessException, InvocationTargetException {

		System.out.println("addCustomer()...........................");
		System.out.println(request.getParameterMap());
		// Customer c = CommonUtils.toBean(request.getParameterMap(), Customer.class);
		// Customer c = new Customer();
		// BeanUtils.populate(c, request.getParameterMap());
		//
		// System.out.println(c);
		// c.setId(CommonUtils.getUuid());
		//
		// cs.add(c);

		Map<String, String> map = new HashMap<String, String>();
		map.put("id", CommonUtils.getUuid());
		map.put("name", request.getParameter("name"));
		map.put("gender", request.getParameter("gender"));
		map.put("phonenumber", request.getParameter("phonenumber"));
		map.put("birthday", request.getParameter("birthday"));
		map.put("description", request.getParameter("description"));
		map.put("email", request.getParameter("email"));
		Customer c = CommonUtils.toBean(map, Customer.class);
		c.setId(CommonUtils.getUuid());
		cs.add(c);

		request.setAttribute("mesage", "恭喜，添加用户成功!");

		return "f:/jsp/mesage.jsp";
		// return "";
	}

	public String edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("edit....");
		return "f:/jsp/edit.jsp";
	}

	@Test
	public void test1() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", CommonUtils.getUuid());
		map.put("name", "value");
		map.put("gender", "value");
		map.put("phonenumber", "value");
		map.put("birthday", "value");
		map.put("description", "i'm a description");
		map.put("email", "email");
		Customer c = CommonUtils.toBean(map, Customer.class);
		c.setId(CommonUtils.getUuid());
		cs.add(c);
		System.out.println(c);

	}
}
