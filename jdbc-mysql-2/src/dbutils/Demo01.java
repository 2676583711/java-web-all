package dbutils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import cn.zhou.c3p0utils.C3p0Utils;

public class Demo01 {

	@Test
	public void test1() throws SQLException {

		C3p0Utils cu = new C3p0Utils();

		QueryRunner qr = new QueryRunner(cu.getDataSource());

		String sql = "insert into student values(?,?,?,?)";
		Object[] ob = { 001, "tomy", 16, "woman" };

		qr.update(sql, ob);
	}

	/*
	 * 演示BeanHandler
	 */
	@Test
	public void test2() throws SQLException {

		C3p0Utils cu = new C3p0Utils();
		QueryRunner qr = new QueryRunner(cu.getDataSource());

		String sql = "select *from student where id=?";
		Object[] paramers = { 2 };
		Student stu = qr.query(sql, new BeanHandler<Student>(Student.class), paramers);
		System.out.println(stu);

	}

	/*
	 * 
	 * 演示ｂｅａｎ ｌｉｓｔ ｈａｎｄｌｅｒ
	 */
	@Test
	public void test3() throws SQLException {

		C3p0Utils cu = new C3p0Utils();
		QueryRunner qr = new QueryRunner(cu.getDataSource());
		String sql = "select *from student";
		List<Student> list = qr.query(sql, new BeanListHandler<Student>(Student.class));
		System.out.println(list);

	}

	/*
	 * MapHandler
	 */
	@Test
	public void test4() throws SQLException {
		C3p0Utils cu = new C3p0Utils();
		QueryRunner qr = new QueryRunner(cu.getDataSource());
		String sql = "select *from student where id=?";
		Object[] o = { 1 };
		Map map = qr.query(sql, new MapHandler(), o);
		System.out.println(map);

	}

	/*
	 * MapListHandler
	 */
	@Test
	public void test5() throws SQLException {
		C3p0Utils cu = new C3p0Utils();
		QueryRunner qr = new QueryRunner(cu.getDataSource());
		String sql = "select *from student";
		List list = qr.query(sql, new MapListHandler());
		// <Map<String,Object>>
		System.out.println(list);

	}

	/*
	 * ScalarHandler
	 */

	@Test
	public void test6() throws SQLException {
		C3p0Utils cu = new C3p0Utils();
		QueryRunner qr = new QueryRunner(cu.getDataSource());
		String sql = "select count(*) from student";
		Object obj = qr.query(sql, new ScalarHandler());

		System.out.println(obj);

	}

}
