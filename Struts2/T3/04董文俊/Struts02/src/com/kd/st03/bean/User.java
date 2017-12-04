package com.kd.st03.bean;

import java.util.Date;

public class User {
	private String uname;
	private String pwd;
	private int age;
	private Date birthday;
	private String telphone;
	public User() {
		super();
	}
	public User(String uname, String pwd, int age, Date birthday,
			String telphone) {
		super();
		this.uname = uname;
		this.pwd = pwd;
		this.age = age;
		this.birthday = birthday;
		this.telphone = telphone;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	@Override
	public String toString() {
		String toString=
				"姓名："+uname+";年龄："+age+";电话："+telphone;
		return toString;
	}
	
}
