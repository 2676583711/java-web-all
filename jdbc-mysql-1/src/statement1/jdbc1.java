package statement1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.zhou.mysql.User;

public class jdbc1 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

//		String username = "tom";
//		String password = "tom123";
		
//		String username="a' or 'a'='a";
//		String password="a' or 'a'='a";
		
		String username="tom";  
		String password="tom123"; 
		
		
		boolean Boolean=func1(username, password);
		System.out.println(Boolean);
	}

	private static boolean func1(String username, String password) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String className = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/zhou";

		String un = User.getUsername();
		String ps = User.getPassword();

		Class.forName(className);
		Connection connection = DriverManager.getConnection(url, un, ps);
//		String sql = "select *from user where username='" + username + "' and password='" + password + "'";
//		System.out.println(sql);
		
//		Statement statement = (Statement) connection.createStatement();
//		ResultSet resultset = statement.executeQuery(sql);
//
//		return resultset.next();
		
		String sql="select *from user where username=? and password=?"; //设置ｓｑｌ语句模板
		PreparedStatement preparedstatement=connection.prepareStatement(sql); //得到ｐｒｅｐａｒｅｄｓｔａｔｅｍｅｎｔ对象
		preparedstatement.setString(1, username); //设置ｓｑｌ语句中的查询语句的第一条条件参数
		preparedstatement.setString(2, password);  //设置ｓｑｌ语句的查询语句的第二条参数
		
		ResultSet resultset=preparedstatement.executeQuery(); //得到查询结果集
		
		return resultset.next();
		
	}
}
