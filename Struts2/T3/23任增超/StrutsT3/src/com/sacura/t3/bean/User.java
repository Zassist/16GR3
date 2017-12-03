package com.sacura.t3.bean;

import java.util.Date;

public class User {
	private String uname;
	private String upwd;
	private int age;
	private String sex;
	private Date brithday;
	private String address;
	public User(String uname, String upwd, int age, String sex, Date brithday, String address) {
		super();
		this.uname = uname;
		this.upwd = upwd;
		this.age = age;
		this.sex = sex;
		this.brithday = brithday;
		this.address = address;
	}
	public User() {
		super();
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
	public Date getBrithday() {
		return brithday;
	}
	public void setBrithday(Date brithday) {
		this.brithday = brithday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getUserInfo() {
		return uname + "/" + age + "/"+ brithday;
		
		
	}
}
