package cn.zhou.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.zhou.domain.User;
import cn.zhou.jdbcutils.ant.JdbcUtils;

public class JdbcUserDaoImpl implements UserDao {

	@Override
	public User findByUsername(String username) {

		try {
			Connection con = JdbcUtils.getConnection();
			String sql="select *from user where username=?";
			PreparedStatement prepared=con.prepareStatement(sql);
			prepared.setString(1, username);
			
			ResultSet rs=prepared.executeQuery();
			if(rs==null) return null;
			
			if(rs.next()) {
				User user=new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setAge(rs.getString("age"));
				user.setSex(rs.getString("sex"));
				return user;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return null;
	}

	@Override
	public void addUser(User user) {
		try {
			Connection con = JdbcUtils.getConnection();
			String sql = "insert into user value(?,?,?,?)";
			PreparedStatement prepared = con.prepareStatement(sql);
			prepared.setString(1, user.getUsername());
			prepared.setString(2, user.getPassword());
			prepared.setString(3, user.getAge());
			prepared.setString(4, user.getSex());
			prepared.executeUpdate();

		} catch (SQLException e) {

			throw new RuntimeException(e);
		}

	}

}
