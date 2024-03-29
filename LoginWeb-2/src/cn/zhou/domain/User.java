package cn.zhou.domain;

import cn.zhou.verifycode.VerifyCode;

public class User {

	private String username;
	private String password;
	private String age;
	private String sex;
	private VerifyCode verifyCode;

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

	public VerifyCode getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(VerifyCode verifyCode) {
		this.verifyCode = verifyCode;
	}

}
