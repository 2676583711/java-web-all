package cn.zhou.test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import cn.zhou.utils.CommonUtils;

public class Test1 {

	@Test
	public void test1() throws IllegalAccessException, InvocationTargetException {
		Map map = new HashMap();
		map.put("username", "tom");
		map.put("password", "mima");

		User u = new User();

		BeanUtils.populate(u, map);
		System.out.println(u);
	}

	@Test
	public void test2() {
		Map map = new HashMap();
		map.put("username", "tom");
		map.put("password", "mima");

		User u=CommonUtils.toBean(map, User.class);
		System.out.println(u);
	}
}
