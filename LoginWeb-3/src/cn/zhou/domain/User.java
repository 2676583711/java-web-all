package cn.zhou.domain;

import cn.zhou.verifycode.VerifyCode;

public class User {

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String username;
	private String password;
	private String age;
	private String sex;
	private String verifyCode;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode2) {
		// TODO Auto-generated method stub

	}

}
