package com.alin.bean;

import java.util.Date;

public class User {
	private String uname;
	private String upwd;
	private int age;
	private String sex;
	private Date brith;
	private String phone;
	public User(String uname, String upwd, int age, String sex, Date brith,
			String phone) {
		super();
		this.uname = uname;
		this.upwd = upwd;
		this.age = age;
		this.sex = sex;
		this.brith = brith;
		this.phone = phone;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBrith() {
		return brith;
	}
	public void setBrith(Date brith) {
		this.brith = brith;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "用户名：" + uname + ", 密码：" + upwd + ", 年龄：" + age
				+", 性别：" + sex + ", 生日：" + brith + ", 手机号：" + phone;
	}
	
}
